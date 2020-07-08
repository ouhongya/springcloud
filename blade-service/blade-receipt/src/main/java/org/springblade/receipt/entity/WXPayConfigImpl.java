
package org.springblade.receipt.entity;

import org.springframework.context.annotation.Configuration;
import org.springblade.receipt.sdk.wxpay.IWXPayDomain;
import org.springblade.receipt.sdk.wxpay.WXPayConfig;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class WXPayConfigImpl extends WXPayConfig {
    private String appId ="wx5d4692d47c604421";
    private String mchId = "1589840961";
    private String key= "a0d0931cf6ee2bb11cad6fb5cd20dfc1";
    private String body = "懒猫云商城VIP充值";
    private String notify = "http://heiha.easy.echosite.cn/api/v2/WxPay/callbackVip";


    @Override
    public String getAppID() {
        return appId;
    }
    @Override
    public String getMchID() {
        return mchId;
    }
    @Override
    public String getKey() {
        return key;
    }
    @Override
    public InputStream getCertStream() {
        return null;
    }
    @Override
    public IWXPayDomain getWXPayDomain() {
        return new IWXPayDomain() {
            @Override
            public void report(String s, long l, Exception e) {

            }

            @Override
            public DomainInfo getDomain(WXPayConfig wxPayConfig) {
                return new DomainInfo("api.mch.weixin.qq.com",true);
            }
        };
    }
    public String getBody(){
        return body;
    }
    public String getIp(){
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            return ip;
        } catch (UnknownHostException e) {
            return null;
        }
    }
    public String notifyUrl(){
        return notify;
    }
}
