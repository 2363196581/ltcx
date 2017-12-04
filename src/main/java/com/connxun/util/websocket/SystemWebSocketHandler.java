//package com.connxun.util.websocket;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.*;
//
//import java.io.IOException;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//
////import com.google.gson.GsonBuilder;
//
///**
// * @Author：luoxiaosheng
// * @Date：2017-09-12 10:52
// * @Comments：websockrt server实现类
// */
//@Component
//public class SystemWebSocketHandler implements WebSocketHandler {
//    private static final Logger logger;
//
//    //当MyWebSocketHandler类被加载时就会创建该Map，随类而生
//    private static final ArrayList<WebSocketSession> users;
//
//    static {
//        users = new ArrayList<>();
//        logger = LoggerFactory.getLogger(SystemWebSocketHandler.class);
//     }
//
////    @Autowired
////    private UserService userService;
//
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        logger.debug("connect to the websocket success......");
//
//        //添加每个与服务器建立连接的用户
//        users.add(session);
//        //发送消息
//        //session.sendMessage(new TextMessage("你好"));
//        //取当前用户的username
//        String userName = (String) session.getAttributes().get(Constants.WEBSOCKET_USERNAME);
//        if(userName!= null){
//            //查询未读消息
//            int count = 99;
//                    //userService.getUnReadNews((String) session.getAttributes().get(Constants.WEBSOCKET_USERNAME));
//            //服务端向客户端发送消息
//            //session.sendMessage(new TextMessage(count + ""));
//        }
//    }
//
//    @Override
//    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
//        //接收到客户端消息时调用
//        if(message.getPayloadLength()==0)return;
//        System.out.println("我要发送消息了 ");
//        //得到Socket通道中的数据并转化为Message对象
//        //Message msg=new Gson().fromJson(message.getPayload().toString(),Message.class);    //使用gson方式解析json
//
//        ObjectMapper mapper=new ObjectMapper();
//        Message msg=mapper.readValue(message.getPayload().toString(),Message.class);    //使用Jackson方式解析json
//
//        Timestamp now = new Timestamp(System.currentTimeMillis());
//        msg.setMessageDate(now);
//        //System.out.println("将接受到的json转化为string："+msg.toString());
////        //将信息保存至数据库
////        userService.addMessage(msg.getFromId(),msg.getFromName(),msg.getToId(),msg.getMessageText(),msg.getMessageDate());
//        //System.out.println("--------"+new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg)));
//        //发送Socket信息
//        //sendMessageToUser(msg.getFromName(), new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg)));
//        sendMessageToUser(msg.getFromName(), new TextMessage(mapper.writeValueAsString(msg)));
//        TextMessage returnMessage = new TextMessage(message.getPayload()+"received at server");
//        //System.out.println(session.getHandshakeHeaders().getFirst("Cookie"));
//        session.sendMessage(returnMessage);
//        System.out.println("text message: " + session.getId() + "-" + message.getPayload());
//    }
//
//    @Override
//    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
//        if(session.isOpen()){
//            session.close();
//        }
//        logger.debug("websocket connection closed......");
//        System.out.println("websocket connection closed......");
//        users.remove(session);
//    }
//
//    @Override
//    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
//        logger.debug("websocket connection closed......");
//        System.out.println("websocket connection closed......");
//        users.remove(session);
//    }
//
//    @Override
//    public boolean supportsPartialMessages() {
//        return false;
//    }
//
//    /**
//     * 给所有在线用户发送消息
//     *
//     * @param message
//     */
//    public void sendMessageToUsers(TextMessage message) {
//        for (WebSocketSession user : users) {
//            try {
//                if (user.isOpen()) {
//                    user.sendMessage(message);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /**
//     * 给某个用户发送消息
//     *
//     * @param userName
//     * @param message
//     */
//    public void sendMessageToUser(String userName, TextMessage message) {
//        for (WebSocketSession user : users) {
//            if (user.getAttributes().get(Constants.WEBSOCKET_USERNAME).equals(userName)) {
//                try {
//                    if (user.isOpen()) {
//                        user.sendMessage(message);
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                break;
//            }
//        }
//    }
//}
