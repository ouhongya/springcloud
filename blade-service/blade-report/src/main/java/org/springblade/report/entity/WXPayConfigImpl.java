
package org.springblade.report.entity;

import org.springblade.report.sdk.wxpay.IWXPayDomain;
import org.springblade.report.sdk.wxpay.WXPayConfig;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class WXPayConfigImpl extends WXPayConfig {
    private String appId ="wx7dab551a32515a12";
    private String mchId = "1563421801";
    private String key= "b88ca14dd4c7ae911cb306e93f149af8";
    private String body = "";
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
