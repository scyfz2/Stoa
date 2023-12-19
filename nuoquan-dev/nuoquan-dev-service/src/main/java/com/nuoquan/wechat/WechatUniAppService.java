package com.nuoquan.wechat;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.nuoquan.utils.StringUtils;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaSubscribeMessage;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * WechatService
 *
 * @author xxdd
 * @date 2023-09-25 21:21
 */

@Service
public class WechatUniAppService {
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
    Logger              log = LoggerFactory.getLogger(WechatUniAppService.class);

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
        // 测试版本 不发送
        try {
            switch (type) {
                case 0: // 私信
                    wxMaService.getMsgService().sendSubscribeMsg(
                            WxMaSubscribeMessage.builder().templateId(templatePrivateMsg).data(Lists.newArrayList(new WxMaSubscribeMessage.MsgData("thing4", msg.getName1()),
                                    new WxMaSubscribeMessage.MsgData("time1", DateUtil.formatDate(new Date())))).toUser(openId).build());
                    break;
                case 1: // 评论
                    wxMaService.getMsgService().sendSubscribeMsg(
                            WxMaSubscribeMessage.builder().templateId(templateCommentMsg).data(Lists.newArrayList(new WxMaSubscribeMessage.MsgData("thing2", msg.getThing2()),
                                    new WxMaSubscribeMessage.MsgData("time3", DateUtil.formatDate(new Date())))).toUser(openId).build());
                    break;
                case 3: // 测试用
                    wxMaService.getMsgService()
                            .sendSubscribeMsg(WxMaSubscribeMessage.builder().templateId("f7zdfu-4EsdDA4fPgrr63ytRAhvEeZ8VP6nyrDaXJKA")
                                    .data(Lists.newArrayList(new WxMaSubscribeMessage.MsgData("thing1", msg.getThing2()),
                                            new WxMaSubscribeMessage.MsgData("time3", DateUtil.formatDate(new Date()))))
                                    .toUser(openId).build());
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            log.error("wechat msg send failed, type: {}, openId: {},WxTemplateMsg: {}", type, openId, JSONUtil.toJsonStr(msg), e);
        }
    }
}
