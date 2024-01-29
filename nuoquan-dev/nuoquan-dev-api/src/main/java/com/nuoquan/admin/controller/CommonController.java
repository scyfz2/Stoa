package com.nuoquan.admin.controller;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nuoquan.controller.BasicController;
import com.nuoquan.service.ResourceService;
import com.nuoquan.utils.JSONResult;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import io.swagger.annotations.ApiParam;

/**
 * CommonController
 *
 * @author xxdd
 * @date 2023-12-27 00:46
 */
@RestController
@RequestMapping("/common")
public class CommonController extends BasicController {

    @Autowired
    ResourceService resourceService;

    @PostMapping(value = "/file/upload")
    public JSONResult uploadArticleImg(@ApiParam(value = "file", required = true) MultipartFile file) throws Exception {
        // 判断是否超出大小限制
        if (file.getSize() > MAX_IMAGE_SIZE) {
            return JSONResult.errorException("Uploaded file size exceed server's limit (10MB)");
        }
        String fileName = file.getOriginalFilename();
        if (StringUtils.isNotBlank(fileName)) {
            return JSONResult.ok("https://nuoquan-1308006370.cos.ap-shanghai.myqcloud.com/" + resourceService.uploadImg(file));
        } else {
            return JSONResult.errorMsg("Upload error");
        }
    }

    public static String generateNo(String type) {
        StringBuffer sb = new StringBuffer(type);
        sb.append(DateUtil.format(new Date(), "yyyyMMdd"));
        sb.append(UUID.fastUUID().toString().replace("-", "").substring(17));
        return sb.toString();
    }
}
