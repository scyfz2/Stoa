package com.nuoquan.admin.controller;

import com.nuoquan.controller.BasicController;
import com.nuoquan.pojo.admin.Tablepar;
import com.nuoquan.pojo.vo.TitleVO;
import com.nuoquan.service.AuthenticatedUserService;
import com.nuoquan.utils.JSONResult;
import com.nuoquan.utils.PagedResult;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


/**
 * 小程序用户管理Controller
 *
 * @ClassName: UserController
 * @author 叶博源
 * @date 2022-08-30 22:35
 */

@Api(value = "用户管理")
@Controller
@RequestMapping("/UserManagement")
public class UserManagementController extends BasicController {

    private String prefix = "admin/userManagement";

    @Autowired
    AuthenticatedUserService authenticatedUserService;

    /**
     * 展示跳转页面
     *
     * @param model
     * @return
     * @author 叶博源
     * @Date 2022年08月30日
     */
    @GetMapping("/view")
//    @RequiresPermissions("system:userManagement:view")
    public String view(ModelMap model) {
        String str = "用户管理";
        setTitle(model, new TitleVO("列表", str + "管理", true, "欢迎进入" + str + "页面", true, false));
        return prefix + "/list";
    }

    /**
     * list集合
     *
     * @param tablepar
     * @param searchText
     * @return
     * @author 叶博源
     * @Date 2022年08月30日
     */
    @PostMapping("/list")
    @RequiresPermissions("system:userManagement:list")
    @ResponseBody
    public Object list(Tablepar tablepar, String searchText) {
        PagedResult result = authenticatedUserService.listAllAuthUsers(tablepar.getPageNum(), tablepar.getPageSize());
        return result;
    }

    /**
     * 新增保存
     *
     * @param email
     * @param type
     * @return
     * @author 叶博源
     * @Date 2022年08月30日
     */
    @PostMapping("/addAuth")
//    @RequiresPermissions("system:user:add")
    @ResponseBody
    public JSONResult addAuth(String email, Integer type) {
        if (StringUtils.isBlank(email)) {
            return JSONResult.errorMsg("email can not be null.");
        }
        if (type!=1 && type!=2){
            return JSONResult.errorException("wrong authenticate type!");
        }
        String userId = userService.getUserByEmail(email);
        if (userId == null){
            return JSONResult.errorException("email not exists!");
        }
        if (authenticatedUserService.checkUserIsAuth(userId)){
            return JSONResult.errorException("User Already be authenticated");
        }
        String authId = authenticatedUserService.saveAuth(email, type, userId);
        return JSONResult.ok(authId);
    }

}
