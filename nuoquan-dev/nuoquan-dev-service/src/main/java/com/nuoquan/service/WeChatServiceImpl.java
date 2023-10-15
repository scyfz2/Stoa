package com.nuoquan.service;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nuoquan.utils.JsonUtils;
import com.nuoquan.utils.RedisOperator;
import com.nuoquan.utils.RestTemplateUtil;

import cn.binarywang.wx.miniapp.api.WxMaService;

/**
 * 微信业务 业务实现类
 * 
 * @author cy
 */
@Service
public class WeChatServiceImpl implements WeChatService {
    @Autowired
    public RedisOperator       redis;

    public static final String ACCESS_TOKEN = "access_token";                                   // Final 均大写

    Logger                     logger       = LoggerFactory.getLogger(WeChatServiceImpl.class); // 控制台输出日志

    @Value("${WXConst.accessTokenUrl}")
    private String             accessTokenUrl;
    @Value("${WXConst.appId}")
    public String              appId;
    @Value("${WXConst.appSecret}")
    public String              appSecret;

    @Autowired
    private WxMaService        wxMaService;

    @Override
    public String getWeChatAccessToken() {
        try {
            // 在 redis 中检测 accessToken 是否过期
            logger.info("WeChatServiceImpl get accessToken: {}", wxMaService.getAccessToken());
            return wxMaService.getAccessToken();
        } catch (Exception e) {
            e.printStackTrace();
            return "请求获取access_token出现异常";
        }
    }

    /**
     * 文本安全检测返回类，jackson 反序列化非static类有问题，所以写外面
     * 
     * @author jerrio
     */
    public static class CheckRes {
        private Number errcode;
        private String errmsg;

        public Number getErrcode() {
            return errcode;
        }

        public void setErrcode(Number errcode) {
            this.errcode = errcode;
        }

        public String getErrmsg() {
            return errmsg;
        }

        public void setErrmsg(String errmsg) {
            this.errmsg = errmsg;
        }
    }

    @Override
    public boolean msgSecCheck(String content) {
        /* 传输数据格式 */
        final class Data {
            private String content;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }
        if (StringUtils.isBlank(content)) {
            return true;
        }
        // 获取AccessToken
        String accessToken = getWeChatAccessToken();
        //        System.out.println(accessToken);

        String requestUrl = "https://api.weixin.qq.com/wxa/msg_sec_check?access_token=" + accessToken;

        Data data = new Data();
        data.setContent(content);
        String dataString = JsonUtils.objectToJson(data);
        //        System.out.println(content);
        //        System.out.println(dataString);

        // 获取检测结果
        String jsonRes = RestTemplateUtil.post(requestUrl, dataString);
        CheckRes checkRes = JsonUtils.jsonToPojo(jsonRes, CheckRes.class);
        if (checkRes.getErrcode().equals(0)) {
            return true; // 合法
        } else {
            System.out.println(content + ", " + jsonRes);
            return false; // 非法
        }
    }

    @Override
    public String getQrcodeUnlimit(String page, String scene, Number width, boolean isHyaline) {

        // 获取AccessToken
        String accessToken = getWeChatAccessToken();
        String requestUrl = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=" + accessToken;
        /* 传输数据格式 */
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("page", page);
        data.put("scene", scene);
        data.put("width", width);
        data.put("is_hyaline", isHyaline);

        String dataString = JsonUtils.objectToJson(data);
        byte[] res = RestTemplateUtil.postGetBuffer(requestUrl, dataString); //返回为图片的buffer

        return Base64.getEncoder().encodeToString(res); // 编码为base64
    }
}
