package com.connxun.util.aliyun.sendsms;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-19 15:41
 * @Comments：阿里短信接口
 */
public class TestSms {

    //阿里云短信服务regionID
    public static String regionId = "cn-hangzhou";
    //阿里云短信服务key
    public static String accessKey = "LTAI6mrgJpoMeF5q";
    //阿里云短信服务secret
    public static String accessSecret = "SilkfYHIPeBOYfbmvygxmvfRFLYWs1";
    //模板码
    public static String code = "SMS_97130040";
    //签名
    public static String signName = "家政频道";
    public static void main(String[] args) {

        String phone = "15927393643";
//        String time = getChinaDateByMM(System.currentTimeMillis());
        String jsonStr = "{\"code\":\"1234\"}";
        test(phone, jsonStr, code, signName);
    }
    public static void test(String phone, String jsonStr, String code, String signName) {

        // 设置超时时间-可自行调整
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        // 初始化ascClient需要的几个参数
        final String product = "Dysmsapi";// 短信API产品名称
        final String domain = "dysmsapi.aliyuncs.com";// 短信API产品域名

        try {
            IClientProfile profile = DefaultProfile.getProfile(regionId, accessKey, accessSecret);

//            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou",
//                    "Sms", "sms.aliyuncs.com");
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou",
                    product, domain);


            IAcsClient client = new DefaultAcsClient(profile);

            //组装请求对象
            SendSmsRequest request = new SendSmsRequest();
            //使用post提交
//            request.setMethod(MethodType.POST);
            // 必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为20个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
            request.setPhoneNumbers(phone);
            // 必填:短信签名-可在短信控制台中找到
            request.setSignName(signName);
            // 必填:短信模板-可在短信控制台中找到
            request.setTemplateCode(code);
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
            request.setTemplateParam(jsonStr);

            //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
//            request.setOutId("yourOutId");

            SendSmsResponse sendSmsResponse = client.getAcsResponse(request);
            if (sendSmsResponse.getCode() != null
                    && sendSmsResponse.getCode().equals("OK")) {
                // 请求成功
                System.out.println("发送成功！");
            }else {
                System.out.println(sendSmsResponse.getCode());
                System.out.println(sendSmsResponse.getMessage());
                System.out.println("此号码频繁发送验证码，暂时不能获取！");
            }
            String requestId = sendSmsResponse.getRequestId();
            System.err.println("requestId:" + requestId);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }


    /**
     * //         * @param tmpDateInt
     *
     * @return
     */
    public static String getChinaDateByMM(long time) {
        String ret_date = "";
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy年MM月dd日");
        ret_date = formatter.format(time);
        return ret_date;
    }
}  
