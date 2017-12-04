//package com.connxun.util.websocket;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//
///**
// * @Author：luoxiaosheng
// * @Date：2017-09-12 10:51
// * @Comments：服务器添加websocket服务
// * @Bean的方式加载bean，并且支持springmvc和websocket
// */
//@Configuration
//@EnableWebMvc
//@EnableWebSocket
//public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
//    public WebSocketConfig(){
//
//    }
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        //注册websocket server实现类，第二个参数是访问websocket的地址
////        registry.addHandler(systemWebSocketHandler(),"/ws").addInterceptors(new WebSocketHandshakeInterceptor());
////
////        //使用Sockjs的注册方法
////        registry.addHandler(systemWebSocketHandler(), "/ws/sockjs").addInterceptors(new WebSocketHandshakeInterceptor())
////                .withSockJS();
//        //setAllowedOrigins解决浏览器403的问题
//        registry.addHandler(systemWebSocketHandler(),"/websck").addInterceptors(new WebSocketHandshakeInterceptor()).setAllowedOrigins("*");
//        System.out.println("registed");
//        registry.addHandler(systemWebSocketHandler(),"/sockjs/websock").addInterceptors(new WebSocketHandshakeInterceptor()).withSockJS();
//    }
//
//    /**
//     * 引用自定义的websocketHandler
//     * @return
//     */
//    @Bean
//    public WebSocketHandler systemWebSocketHandler(){
//        return new SystemWebSocketHandler();
//    }
//}
