//package com.connxun.util.activeMQ;
//
//import com.util.date.DateUtil;
//import org.springframework.jms.listener.SessionAwareMessageListener;
//
//import javax.jms.*;
//
///**
// * @Author：luoxiaosheng
// * @Date：2017-08-16 10:11
// * @Comments：消息监听器
// */
//public class QueueMessageListener implements SessionAwareMessageListener<Message> {
//
//    @Override
//    public void onMessage(Message message, Session session) throws JMSException {
//        TextMessage tm = (TextMessage) message;
//        // 收到消息之后进行确认
////        session.commit();
//        try {
//            System.out.println("QueueMessageListener监听到了文本消息：\t"
//                    + tm.getText());
//
//            /*编写回执消息*/
//            Destination recall_destination =message.getJMSReplyTo();
//            // 创建回执消息
//            TextMessage textMessage = session.createTextMessage("张三，我已经收到消息了"+ DateUtil.getSystemTime());
//            // 以上收到消息之后，从新创建生产者，然后在回执过去
//            MessageProducer producer = session.createProducer(recall_destination);
//            producer.send(textMessage);
//
//            //do something ...
//        } catch (JMSException e) {
//            e.printStackTrace();
//        }
////        finally {
////            session.close();
////        }
//    }
//}
