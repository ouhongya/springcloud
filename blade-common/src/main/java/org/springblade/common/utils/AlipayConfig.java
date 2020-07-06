package org.springblade.common.utils;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String APP_ID = "2017060807449089";

	// 商户私钥，您的PKCS8格式RSA2私钥，这些就是我们刚才设置的
	public static String MERCHANT_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCuP8KcjLCRYSJ9GWtkmIaEzrlaN/hjN2J+gCZkIhKVPqYjjridCVZboJsoQsKOGV4euYxpfLEIepnkF4yVvrBzdMlpibiNEDqyDN2d7SbHsHVm68QU7dA7G9HhZFNlwfHlCgEOJBJZezSkwKn83pkOggjJd/CRYYEKN90IT6UIxzMvUgsPuU4mZlmR0iUxzrE0F+gbzWK3hmYC3kbWveoWaa6OTEKazSZaVDlmtFdD/J4NBsZpZfn5+O5H3z8DsHzANErQ3rMqVxGW3/i/z9AI89CCW4DDHsQGhyDgnq0WIpOvhRWYZksiAq6R6tEqJ2qBjYUg/k68TJgPWaIq9XEdAgMBAAECggEBAI/Tw0BTBJ9LTRtzcuia2VYgCHCGiHjky2DdSFMYqLwV9S6ebJX6khSZkdh+mnaOS9kSkOq1aK81+3aBVaJ4vs7eFC4P5oxRXBGBeyATExJ6/b0RWE1qKpnPkcL4e7ofhxnl0w8oCRlhEAf5m5ZE6pNGFBiv7pshn1Ce4cwtaWy/Gyn9B0dYPR8sZxMTAaPVQAd/JVPBH+1/sEEhtRdnbCn9OB8vwfYAhusJysgbMlvuv/4p5+YUJdo/WqQcwoD2yqOGhR5n2681DTKNiSqB104B9WmtXe4yd/Mi/V6N1UFyE6zas2TibEF4+ynYo9oAdG/VmKnU6993v/AVe6WwQIECgYEA18uy/FxHmpu6D9TJy05HBOkg39KHQRgs1jkCoAvvZ3NAKYrGw68PPlmmHRcCAtezmI4pmEL5UC82Vbp3hUhl5rJEeccB240j8ZQBWko5NDpwOTrB90vg77PfMNadoXliMwLRXEHvLVIaDEAOKkZDxJUwryORkauZ0o4hZj2jo30CgYEAzraCN4G96144DJ30WAUuxUC2twbB+bTRYgNAv8KJZnCOgQqVMn5V5co5wDWj2Kyo5oqO6lDToae3M2ZGknCOP1Oiki7VGEg+oKxaVJOf+s0aPtGA3TBiyyh2Ss8YEcg1KeIO6WW7obbqbLUBx3Xauu3aaurB4X0hE9O3xiG1NiECgYEApWxqvdgDr/qWzFIDi01rVdFcuReLRZRBssqrP4NGt9f6pJ3Utud42QQiOgSMLx+pdlXsfuNAeX5nuZoiy1Jvg0S/B1dODj8JAcTCsLNbXLU7mDN5w5gwS7BodOjgl4sUgyQy1/VXYzef7iogcbnBc24mjuvGSJPybB02b0jrK4UCgYBTGVebzNJ2jjfmCpGx2NOGhI9vYI4WPjR2PGyJKkFmJxWClqiH1fXeHL++n1GwxyhXFZiCZd/N+shRJ2pzcEAfARY3wg/0ZQaYPPFLUtVbU5ybaElvogX1OdzkEgDRFTUaE0B/X2BgkFIJRXLjpmM6Bmhp1tn+NflYKSKVyfM5QQKBgAUdEDmTQ37AFaG9YtKFzEkhw6q6MDs5O26xCMoGz8raBoXi5g5Azl8/58qfUIGd2EMvHDKM4Xl9NABO9gLt0gL9G4oQc8jFZzvcu8+86ZU9EB04dT9xrx4eY9MC3O/YA1HKVvWDRwRq7VawpwmytJHC4oi3OmOZ6p6Xq7TKSz+Q";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。，这些就是我们刚才设置的
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgobsMz0UshNpEA4tswdjbR4Qb0LRBhS09mCb8ta6zmxsmcAZ7N5GWXY7g0Cab2Tzhkr3G3U0/fORrDObBDf328AQESu/NjvRiqQ4V0rEipz9BvesnV11Fe3dLyfDSW/+J107XRfEZUfm7tIBlDKLYLHWWzqMvYOGX234qm1e58xNfYNXZSuA6oBjDBoFLGIDIsHqkOyYdCWszFIAAc1pakAbcJOwE0Mhtx4jJVVTgbFldyhg+nW55yXusuNjkfrHPOEDnWC//UPoCJ9sZYVe4wCCfbKTaGLlcGriAYONxkjnRPpGnrkU+ZE1a6KRnAjDngbEwSp5o5XffIoUQW0fGQIDAQAB";

	//异步通知，再这里我们设计自己的后台代码
	public static String notify_url = "http://localhost:8080/api/aLiOrderNotifyResult";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String SIGN_TYPE = "RSA2";

	// 字符编码格式
	public static String CHARSET = "utf-8";

	// 支付宝网关
	public static String GATEWAYURL = "https://openapi.alipay.com/gateway.do";

	// 支付宝网关
	public static String LOG_PATH = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	/**
	 * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
	 *
	 * @param sWord 要写入日志里的文本内容
	 */
	public static void logResult(String sWord) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(LOG_PATH + "alipay_log_" + System.currentTimeMillis() + ".txt");
			writer.write(sWord);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
