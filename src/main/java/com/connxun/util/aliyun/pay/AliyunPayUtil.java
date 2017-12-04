//package com.connxun.util.aliyun.pay;
//
//import com.alipay.api.AlipayApiException;
//import com.alipay.api.AlipayClient;
//import com.alipay.api.DefaultAlipayClient;
//import com.alipay.api.request.AlipayTradeCreateRequest;
//import com.alipay.api.request.AlipayTradePagePayRequest;
//import com.alipay.api.request.AlipayTradeWapPayRequest;
//import com.alipay.api.response.AlipayTradeCreateResponse;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.math.BigDecimal;
//
///**
// * Created by zosoft-java on 2017/7/25.
// */
//public class AliyunPayUtil {
//
//
//    //    alipay.trade.pay(统一收单交易支付接口)
//    public static void pay(HttpServletRequest httpRequest,
//                           HttpServletResponse httpResponse, LwOrder lwOrder) throws ServletException, IOException, AlipayApiException {
//        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE); //获得初始化的AlipayClient
//        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
//        //        同步返回地址，HTTP/HTTPS开头字符串
//        alipayRequest.setReturnUrl("http://domain.com/CallBack/return_url.jsp");
//        //        支付宝服务器主动通知商户服务器里指定的页面http/https路径。
//        alipayRequest.setNotifyUrl(NOTIFY_URL);//在公共参数中设置回跳和通知地址
//        alipayRequest.setBizContent("{" +
//                //               商户订单号,64个字符以内、可包含字母、数字、下划线；需保证在商户端不重复
//                "    \"out_trade_no\":" + lwOrder.getOrderNumber() + "," +
//                //                        可选	32	销售产品码
//                "    \"product_code\":" + lwOrder.getExternalNo() + "," +
//                //                订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
//                "    \"total_amount\":" + lwOrder.getFinalAmount() + "," +
//                //                        可选	128	订单标题
//                "    \"subject\":" + lwOrder.getGoodsName() + "," +
//                //                              订单描述
//                "    \"body\":" + lwOrder.getGoodsName() + "," +
//                "    \"extend_params\":{" +
//                //               系统商编号 该参数作为系统商返佣数据提取的依据，请填写系统商签约协议的PID
//                "    \"sys_service_provider_id\":\"2088421630965163\"" +
//                "    }" +
//                "  }");//填充业务参数
//        String form = "";
//        //        AlipayTradePayResponse response = alipayClient.execute(alipayRequest);
//        try {
//            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
//            System.out.println(form);
//        } catch (AlipayApiException e) {
//            e.printStackTrace();
//        }
//        httpResponse.setContentType("text/html;charset=" + CHARSET);
//        httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
//        httpResponse.getWriter().flush();
//        httpResponse.getWriter().close();
//    }
//
//    /**
//     * alipay.trade.create(统一收单交易创建接口)
//     * 返回 支付宝交易号
//     */
//    public static String create(LwOrder lwOrder) throws AlipayApiException {
//        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE); //获得初始化的AlipayClient
//        AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();
//        request.setNotifyUrl(NOTIFY_URL);//在公共参数中设置回跳和通知地址
//
//        request.setBizContent("{" +
////商户订单号,64个字符以内、可包含字母、数字、下划线；需保证在商户端不重复
//                "    \"out_trade_no\":" + lwOrder.getOrderNumber() + "," +
//                //                        可选	32	销售产品码
//                "    \"product_code\":" + lwOrder.getExternalNo() + "," +
//                //                订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
//                "    \"total_amount\":" + lwOrder.getFinalAmount() + "," +
//                //                        可选	128	订单标题
//                "    \"subject\":" + lwOrder.getGoodsName() + "," +
//                //                              订单描述
//                "    \"body\":" + lwOrder.getGoodsName() + "," +
//                "    \"extend_params\":{" +
//                //               系统商编号 该参数作为系统商返佣数据提取的依据，请填写系统商签约协议的PID
//                "    \"sys_service_provider_id\":\"2088421630965163\"" +
//                "    }" +
//                "  }");//填充业务参数
//        AlipayTradeCreateResponse response = alipayClient.execute(request);
//        String tradeNo = "";
//        if (response.isSuccess()) {
//            System.out.println("调用成功");
//            tradeNo = response.getTradeNo();
//        } else {
//            System.out.println("调用失败");
//        }
//        return tradeNo;
//    }
//
//    /**
//     * 手机网站支付
//     *
//     * @param lwOrder
//     * @return
//     * @throws ServletException
//     * @throws IOException
//     * @throws AlipayApiException
//     */
//    public static String h5(LwOrder lwOrder) throws ServletException, IOException, AlipayApiException {
//        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE); //获得初始化的AlipayClient
//
//        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();//创建API对应的request
//        /*前端决定  支付成功跳转的页面*/
//        alipayRequest.setReturnUrl("http://domain.com/CallBack/return_url.jsp");
//        alipayRequest.setNotifyUrl(NOTIFY_URL);//在公共参数中设置回跳和通知地址
//
//        alipayRequest.setBizContent("{" +
////商户订单号,64个字符以内、可包含字母、数字、下划线；需保证在商户端不重复
//                "    \"out_trade_no\":" + lwOrder.getOrderNumber() + "," +
//                //                        可选	32	销售产品码
//                "    \"product_code\":" + lwOrder.getExternalNo() + "," +
//                //                订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
//                "    \"total_amount\":" + lwOrder.getFinalAmount() + "," +
//                //                        可选	128	订单标题
//                "    \"subject\":" + lwOrder.getGoodsName() + "," +
//                //                              订单描述
//                "    \"body\":" + lwOrder.getGoodsName() + "," +
//                "    \"extend_params\":{" +
//                //               系统商编号 该参数作为系统商返佣数据提取的依据，请填写系统商签约协议的PID
//                "    \"sys_service_provider_id\":\"2088421630965163\"" +
//                "    }" +
//                "  }");//填充业务参数
//        String form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
//        /*
//        * <form name="punchout_form" method="post" action="https://openapi.alipay.com/gateway.do?charset=UTF-8&method=alipay.trade.wap.pay&sign=CnBb%2FxMSAtGUQALXxGnIsxkY82dkbsOYhMZNDcXc3Po1e1UfcJ8%2FhzxkeiGDfwlbeyb3TUzD0o%2B%2BuLUk8ashiAqhXuSw13aB96tPXsbjfoe8rwXEIGC0nixrelq00ONp%2FGgYq%2B%2BlU7QRK5Q2cPZi6mXEOaS2HxEzB5TBOqRL%2Fd%2FjyG6UcDi%2FregdwrHK7lusW0Bi78pMJCDdA9aICgTb5hJkdIRCukx1x33F1rnxqGEE%2FsdBQ0Xkbdg9YnUHLFmVfXBbs4didvzqA1TqF4aHxH85HociGA4JHFC6vIxD2IA6ajwDsxpyUHxpVki7IBZRHQuowOdZsMho6WQZA3hp9g%3D%3D&return_url=http%3A%2F%2Fdomain.com%2FCallBack%2Freturn_url.jsp&notify_url=http%3A%2F%2Fwww.932edu.net%2Flwgk%2Fpay%2Faliyun%2FCallBack%2Fnotify_url.do&version=1.0&app_id=+2016081001726633&sign_type=RSA2&timestamp=2017-08-23+19%3A00%3A50&alipay_sdk=alipay-sdk-java-dynamicVersionNo&format=json">
//           <input type="hidden" name="biz_content" value="{    &quot;out_trade_no&quot;:订单号,    &quot;product_code&quot;:商品号,    &quot;total_amount&quot;:10,    &quot;subject&quot;:商品的名称,    &quot;body&quot;:商品的名称,    &quot;extend_params&quot;:{    &quot;sys_service_provider_id&quot;:&quot;2088421630965163&quot;    }  }">
//            <input type="submit" value="立即支付" style="display:none" >
//              </form>
//               <script>document.forms[0].submit();</script>
//*/
//        return form;
//    }
//
//    public static void main(String[] args) {
//        LwOrder lwOrder = new LwOrder();
//        lwOrder.setOrderNumber("订单号");
//        lwOrder.setFinalAmount(new BigDecimal(10));
//        lwOrder.setExternalNo("商品号");
//        lwOrder.setGoodsName("商品的名称");
//        try {
//            String s = h5(lwOrder);
//            System.out.println("=-============================" + s);
//            System.out.println("====================================");
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (AlipayApiException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    //    支付宝网关（固定）
//    public static final String URL = "https://openapi.alipay.com/gateway.do";
//    public static final String SYS_SERVICE_PROVIDER_ID = "2088421630965163";
//    public static final String APP_ID = " 2016081001726633";
//    //    开发者私钥，由商户自己生成的RSA私钥（与应用公钥必须匹配），商户开发者使用应用私钥对请求字符串进行加签。
//    public static final String APP_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCRIgnaCOHZ7qVrzDP9/2B6w8ydifyHpfNaEYlRtlp3T24O4GQNm0m/R7R53xIuki4uiDHi0AAqkRIWwyH5WwS1F+5rMK7hPAcoTUHxI2cpHXn/JMo1c2g4wNCdQ4zIuel4ktg6mlLiauadC6+FtEOxuUnzKyy1A4f6bS8VDBnxc8LlqiB42yUJ8oOt8kWeMkP9WFzwDjskMM0TGntM4T3c2DuHvTJmu7IYPNoWISq+9EGl0KgcvOv++Tzyd8jMxknyj205MLaqGiKs/VgX5jfkz1+S4xbzCogfKNhFyWV5Olw6Hh7GdEnca6Y3ua/WmfLo60kxVLJJ5eB/G3h91IzdAgMBAAECggEABaCJOz/u6dE77rMLLQTyy6+9xjnsZaIEjnBxn45vcYLN5JvEpVZpBJaWI8eHX/DhA4LaVE32Q7A+QE2uiomB5DeaUeOgVDFMob5lGSFjRY/UBBV8FZh06QZo0EAnPD0hFUC0S4liP08fw+UJGCkGGuTxPhFleVs6sXX8Rleixd7E4dYToUsTK9VuaUTa+mbtEZxeIouAKvLBUNr01f2I1HkHrQkQh/LNVUXhBVYpswO1PmAhRQmFEoPWsWrCWp3NB+hV0XVUPhJNyxkXurMcEM+/ybsp5XIZ1rnLHncHznNENSqGdx+DtPfvrKwWBW7GN/qvcdu4PCm7AQ+qkELcTQKBgQDtId0YyQ0ZhJSx0MvLuGoVXPUUM2tW3gPklfcnMDzITA0wSFj569TL8mUKHf494fD6TnPVstsK+++SypOrQyGHL1Ju4pBbcuNIanngATmVAK4k2DFsafZ4zHEE9GzfEtgh6ymslISZQBY0vPgvTzq8bKJ4SQ9ZbjiCUnKmlmMfswKBgQCcrj66LKk5rDHEsjR0iDJsbnlF0vAxtDMgvsxQSfELrdKVxOiLzBIxMoQPuIvMzsQvQQ9IK74AcRAxO5eR9taqnNEFAi9Y9XjBVarHMkujzklEQH3rWwlz4wagNnJcI2ENojMMLEvkJRWa7SDw6Tf00qKKIKxNSLCTMFHPy7HZLwKBgHpNUeQ7pZb4q1w+jS2oEoasJ/bgQkdOQIG/2vYKSf8gQlkZp1JXEKyTewtJxtwR0SC4H8Qi+BhlMf3qn1jgScWYYZKxJbUUvyaVTAB9gT5ZWHfGTU9WI3nQL6ZXjmNLK8/qotbQzsbfp9RRdkuoOGoAOZeCTvlYAKsubNWAkOVDAoGADt2RYgSewbQOvMTTqULK1fLdWryawXyBZVf09qEtV5hUZJVcIvdnunc6hGtUCEiN4JXhp01PJ6eSi7lFtjmfQGzEgB8m8t/HZ0CDhYbGGnKWDP25dL0cdnxRwp2n2AobSTnccgk54hmKpTpeZ70Y7AeYGFblQiflaPGqsXZ4F00CgYAwyZiQDn11+4cC3H3+QgQpKaMGYXcgXZfOCofEPfbVHjdrAvizeSNbMgUR8ytPjcm1mkF8ZrksYp4KTucZS+RBVLvngkRjL0bQTSGPQKOHBU90K5aYo8dk9n6K1a8fXLH08j6kOYC3mCscxNcDAvGSHFY3tfvVPFMSmWGf4fUfgA==";
//    //    参数返回格式，只支持json
//    public static final String FORMAT = "json";
//    public static final String CHARSET = "UTF-8";
//    //    支付宝公钥，由支付宝生成
//    public static final String ALIPAY_PUBLIC_KEY = "MIIEowIBAAKCAQEAuFpfjbdzW8VZIcl3RIZWW0AKs8ql2hzMDUvUCaU1Gb1XMewg EMxNSNsA1vXbkc0fWwkKx8ZMPeY0Q+kcit8x7cQU9acTfiTyIZkMrm4YE2h4ds+9 LYWfmkgnLEIKxxP7eWPBZ0ugc1ltemsDt83jJD06MNDnq5hjrtXLYAcubaSFwaGa zfaBXOQ9ofNIh9Roxb+FM0Y5iWTnrgeWDNppJSY7GjIgZ7IF8MIZLZmpS6Snufb4 KTpTm3+FTNGpZ3rECYtS3nSXQ3HL4r0MU+DdaIHNhGZWFxbjtOEKHvP3lLAAgJBl 0MRHVnWo+MCFs6oeOeyUjSLxAcV6juXPOISh3QIDAQABAoIBAD04permNUUQsJzr ztPO2PbMucEjVxir34e62tupJY06t644gB2T+0ZqlEjOtPAicntE8XOOgts7i7fR vkzP+kC/kUZTCcImetJ1hSSYIx6u3vJ14pkveuU9eOTVucaK+ERDwIKRNuOXmyfA SifME9aBDsYPWiA+Jzx0e2mUePKn001vPnSQP921x35Nf7l2J5EJELZpw9fdvRZw eYvWFWP5pALoWo/G5RXDYVze+02eiqlEbfK2KYghMiln+u5gT97w0P4nHEB6757K yuuev9/ctzQNGGWRKSWO29S17PbVlifj2JrXdtWHl3csJOunf3g9wqz+sWVL0rjs 6HnZf4ECgYEA8EypdE61E5raIeJMOGEqmrq6b8ySu7vjhayVxaF9q2RJGnGbVqMJ 3nHW70TNx0qIfRA4OQwuZRKFlkKHKF4upa0Tfms7mNwPvFdIr2v+gDwp8TivSKLA gPEAbvSIt/O3gsVIU7WqyQlQEcYF2sXKe5pJ8WWRFC+JHBoXz3kXgfkCgYEAxGXu LVJWgI4TpTpxHqebEOku8AyqPjgCJd+Y3a8SYzRiI3mg7wfHwwkxj6D+aaSWcl6p 6ZwguZ+rYUtiHohXenJ6v25H+XfoPyOiK218scknjQ3jOjcDQ2XS8fp0QzIXJ/0g 0zcX99H87XSmq5cbrnu4t3KlUDA6TG1gBrnN2AUCgYA9Rs9PYWK7hRlq2pIlLmH2 4vb322rvhJIYXFI0+2FYe1JI8/9wsFKr7suoaBsxXsg/XAt6QKj0DS0TjBN7L8kl ZmU6L44bBMLefEOEuD1F5hGr+ZB5LUd5mftKUAEtJ3D8X+J5tjG+4ikQ3zZO+3EO 4+FHNWcxho2oJN89gNuFwQKBgHKNybjht9bQCCFtzyFEPaxFdr1Jhds4q/gPTYiw XxdCLKPog7goX5ohOKlADGTuPVqEYLMEAAqFWV8sqxSIDg47y+DwoEaga/S4AhU2 jW7dl5YsrYb9I4giUkIWBc5T3zHR8V2BWxePgem3Cqg3QUwqmflWg5ocJ0UA3uvN YIVJAoGBAKr9l/tdPfA/CGJlk+uP4g5mLsWDkaYSwnHCAO7vJkmie2Hu0anANnrk QF9QlLsmQ7nLm3X6iIr9nhR5MOJPSbmVUVIN5Ok4LfJcZrKcIc3iBTPJSlbzYUsC Y/xnzNuGZU/50RXY5Vlmo7NlZmunYNzpdd/5UfJ7ABor9tzwIcRF";
//    //    商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2
//    public static final String SIGN_TYPE = "RSA2";
//    public static final String NOTIFY_URL = "http://www.932edu.net/lwgk/pay/aliyun/CallBack/notify_url.do";
//}
