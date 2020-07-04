package org.springblade.fee.config;

import com.github.wxpay.sdk.WXPayConfig;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class WXPayConfigImpl implements WXPayConfig {

	 //设置证书，没有的话注释掉
	 private byte[] certData;
	 public WXPayConfigImpl() throws Exception {
	    String certPath = "/path/to/apiclient_cert.p12";
	    File file = new File(certPath);
	    InputStream certStream = new FileInputStream(file);
	    this.certData = new byte[(int) file.length()];
	    certStream.read(this.certData);
	    certStream.close();
	 }


	private  static String appId="";

	private  static String mchId="";

	private  static String key="";

	public static void setAppId(String appId) {
		WXPayConfigImpl.appId = "";
	}
	// set mch_id
	public static void setMchId(String mchId) {
		WXPayConfigImpl.mchId = "";
	}
	// set key
	public static void setKey(String key) {
		WXPayConfigImpl.key = "";
	}

	@Override
	public String getAppID() {
		return this.appId;
	}

	@Override
	public String getMchID() {
		return this.mchId;
	}

	@Override
	public String getKey() {
		return this.key;
	}

	public InputStream getCertStream() {
		ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
		return certBis;
	}
	// 异步通知地址
	public String getNotifyUrl() {
		return "http://www.xxx.com/wxNotify";
	}

	public int getHttpConnectTimeoutMs() {
		return 8000;
	}

	public int getHttpReadTimeoutMs() {
		return 10000;
	}



}
