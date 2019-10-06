package com.xja.gmsc.utils;

import java.io.FileWriter;
import java.io.IOException;
//udaumd5531@sandbox.com
public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
public static String app_id = "2016092800616853";

	//商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCj9bJYSGTmICtsoalFHKNKBfUNf7wfWduohsA99RwcvPQam8vj5Qzw0DCzm7U+SBmkLeEw9i6g2BQx2Yg5tfIyDHZefPCPAiTyP7gFmnWQGWwXmG77tMQJyk1Sav6urrt3sl6Ef72tDPJCIiJFJzEBUbCI3XP3uL8Ps0Xufc/I6BMBPRGQaebU+IWbeS2jG/+sJBaOqvtEi1O1mq2FpD2/CHenPnqbmnGfyrOHn0fCPuG9O+fn275I+eRjTNC7WSscoHci5HhhN1R0RLaYIw02Y4HVTKf7eIehgSWAT4WzglFWlS3575fFESuBCHMNXRqg5Un+zxQht3J31kOVj0GfAgMBAAECggEAVIxHSlUSisS9/8ehZP0uiuZlhm9/D9+jcNUD3y89LuiVK/949WzQ7oE9C/FYVeSSLGJoRHo+czzZtRcKs0/Ks9pPU8wztFsTuEP5XhJXW1Zwsf4uBOgjSzUiCEUaTfPWwhOdv8+rfMg3SLkXWPerwpVgZkNkILMI+0yj3CbOdje5pHokGPXUz7pReL1uuKu937aKJ2jW61RZeThcOJE6U/mHS15q9halIjBhs9h9eFhmn/nviGvJEeXHp2BA605yq7cHdKAuORhNtkMKtteWNSz0zW4TZE5YiICImqEOa3got81/BnbhaYNnxBoGpJ9uIQeltS1/3yXoHXTAOTQaMQKBgQDlgOGnR9/oiFhyadqqkBBGxuTGaq5Xcgfp084NIm+n5Q2qvb56k+Rf6NoiGmoQ7BdkTSyw34gqSBQYogCf6PYlmQBv875V6GOJ2o+KAeMN6tIgeIy1spyZcfr+zB+NMa2R8yIkBdKLxOsV4Y8iQKUfklkVruI1mXpgXD472NSw9wKBgQC246FWIBLPBswTvxHJQbwv8x055oe/DbAXy0mU7z4bqAAX5/6nLZjhdms3k6hUk9ur0x9FMfq9zDLr14ns6C1zYcgqyikisng/es2gcO7Onpbu2rlw1rJtgFHC1xxxGTjpWs/pJWufyZoaM7hKC50ycy8zDlqQTpQk86yXaBjymQKBgBWsVyMCAZ4nChs77d9/nVnhvIcUWgR+C0tEqkfJQbwcQG8oXg2bW8zG45qm3e9dLFRXiWnmoihECEnPOrnfOSeRzF3GKepY+NVy421IAlY1H8TbPYaHKIzBG8/mHPCriVWoHUhDmH+EiCLX2zmD21Qg8PLAQjKHnOvuqh3iuys/AoGBAJoP4O2zMQTyveD4eJwn4sYlrv4CY2GevzMcDU0HyDL177YzuQHNWFa9MY5stUUiFM+GlnXsp0NRC6g+NjK6Vuc2fK8HA2X2H3OiGCvKVnD5iT2GROZ4BXBWwwk1ugDP9XAmDrRg0GuXIVhnLxw48l/4Rc9ljQa5GvSRzFby2ukpAoGBAJTlGjpAV7lviNSTnGc5a9S/d9M48HoVqveEspvwdMYubWLZtGFNV7aIyGjD4kRzP/oZaVdEFkMSo8ib5DsewpVgqVY/U25dqY8CGnmpFm4AmlVggJXR+jwp4sQQTFrp5KTykNlROngj1TzqVp8cbdMtc7K6IvoY1daSskTtkHsr";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAo/WyWEhk5iArbKGpRRyjSgX1DX+8H1nbqIbAPfUcHLz0GpvL4+UM8NAws5u1PkgZpC3hMPYuoNgUMdmIObXyMgx2XnzwjwIk8j+4BZp1kBlsF5hu+7TECcpNUmr+rq67d7JehH+9rQzyQiIiRScxAVGwiN1z97i/D7NF7n3PyOgTAT0RkGnm1PiFm3ktoxv/rCQWjqr7RItTtZqthaQ9vwh3pz56m5pxn8qzh59Hwj7hvTvn59u+SPnkY0zQu1krHKB3IuR4YTdUdES2mCMNNmOB1Uyn+3iHoYElgE+Fs4JRVpUt+e+XxRErgQhzDV0aoOVJ/s8UIbdyd9ZDlY9BnwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //public static String return_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";
    public static String return_url = "http://localhost:8080/AliPayOrderSuccessServlet";
    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
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