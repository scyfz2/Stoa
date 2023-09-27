package com.nuoquan.wechat;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.nuoquan.utils.StringUtils;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaSubscribeMessage;
import cn.hutool.core.date.DateUtil;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * WechatService
 *
 * @author xxdd
 * @date 2023-09-25 21:21
 */

@Service
@Qualifier("uniAppService")
public class WechatService {

    @Value("${WXConst.appId}")
    public String       appId;
    @Value("${WXConst.appSecret}")
    public String       appSecret;
    @Value("${WXConst.wxGetOpenIdUrl}")
    public String       wxGetOpenIdUrl;
    @Value("${WXConst.uniApp.TemplatePrivateMsg}")
    public String       templatePrivateMsg;
    @Value("${WXConst.uniApp.TemplateCommentMsg}")
    public String       templateCommentMsg;
    @Autowired
    private WxMaService wxMaService;

    /**
     * 获取用户 OpenId
     *
     * @param code
     */

    /**
     * 发送模板消息
     *
     * @param type
     * @param openId
     * @throws WxErrorException
     */

    public void sendTemplateMsg(int type, String openId, WxTemplateMsg msg) throws WxErrorException {
        if (StringUtils.isEmpty(openId)) {
            return;
        }
        switch (type) {
            case 0:
                wxMaService.getMsgService()
                        .sendSubscribeMsg(WxMaSubscribeMessage.builder().templateId(templatePrivateMsg)
                                .data(Lists.newArrayList(new WxMaSubscribeMessage.MsgData("name1", msg.getName1()),
                                        new WxMaSubscribeMessage.MsgData("date3", DateUtil.formatDate(new Date()))))
                                .toUser(openId).build());
                break;
            case 1:
                wxMaService.getMsgService()
                        .sendSubscribeMsg(WxMaSubscribeMessage.builder().templateId(templateCommentMsg)
                                .data(Lists.newArrayList(new WxMaSubscribeMessage.MsgData("thing2", msg.getThing2()),
                                        new WxMaSubscribeMessage.MsgData("time3", DateUtil.formatDate(new Date()))))
                                .toUser(openId).build());
                break;
            default:
                break;
        }
    }
}
