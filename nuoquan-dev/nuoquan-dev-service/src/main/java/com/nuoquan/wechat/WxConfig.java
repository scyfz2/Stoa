package com.nuoquan.wechat;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * WxConfig
 *
 * @author xxdd
 * @date 2023-09-25 21:23
 */
@Configuration
public class WxConfig {

    @Value("${WXConst.appId}")
    public String appId;
    @Value("${WXConst.appSecret}")
    public String appSecret;
    @Value("${WXConst.wxGetOpenIdUrl}")
    public String wxGetOpenIdUrl;
    /**
     * 微信客户端配置存储
     *
     * @return
     */
    @Bean
    public WxMaConfig wxMpConfigStorage() {
        WxMaDefaultConfigImpl configStorage = new WxMaDefaultConfigImpl ();
        // 公众号appId
        configStorage.setAppid(appId);
        // 公众号appSecret
        configStorage.setSecret(appSecret);
        // 公众号Token
        return configStorage;
    }

    /**
     * 声明实例
     *
     * @return
     */
    @Bean
    public WxMaService wxMpService() {
        WxMaService wxMpService = new WxMaServiceImpl();
        wxMpService.setWxMaConfig(wxMpConfigStorage());
        return wxMpService;
    }

}
