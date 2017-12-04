//package com.connxun.util.websocket;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.http.server.ServletServerHttpRequest;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.server.HandshakeInterceptor;
//import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
//
//import javax.servlet.http.HttpSession;
//import java.util.Map;
//
///**
// * @Author：luoxiaosheng
// * @Date：2017-09-12 10:52
// * @Comments：握手（handshake）接口
// */
//public class WebSocketHandshakeInterceptor extends HttpSessionHandshakeInterceptor {
//    private static Logger logger = LoggerFactory.getLogger(HandshakeInterceptor.class);
//    @Override
//    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
//        System.out.println("beforeHandshake");
//        //解决iOS手机safari浏览器版本问题
//        if (request.getHeaders().containsKey("Sec-WebSocket-Extensions")) {
//            request.getHeaders().set("Sec-WebSocket-Extensions",
//                    "permessage-deflate");
//        }
//        if (request instanceof ServletServerHttpRequest) {
//            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
//            HttpSession session = servletRequest.getServletRequest().getSession(false);
//            if (session != null) {
//                //使用userName区分WebSocketHandler，以便定向发送消息
//                String userName = (String) session.getAttribute(Constants.SESSION_USERNAME);
//                logger.debug("当前用户名为："+userName);
//                //这里采用username做为区分，attributes会与WebSocketSession中每个与服务器建立连接的user做比对
//                attributes.put(Constants.WEBSOCKET_USERNAME,userName);
//            }else{
//                System.out.println("user为空");
//                return false;
//            }
//        }
//        return true;
////        return super.beforeHandshake(request, response, wsHandler, attributes);
//    }
//
//    @Override
//    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
//        System.out.println("afterHandshake");
//        super.afterHandshake(request, response, wsHandler, ex);
//    }
//}
