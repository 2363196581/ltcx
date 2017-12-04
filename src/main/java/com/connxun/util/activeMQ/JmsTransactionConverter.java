package com.connxun.util.activeMQ;

import org.springframework.jms.support.converter.MessageConversionException;

import javax.jms.*;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-11 10:52
 * @Comments：
 */
public class JmsTransactionConverter  implements org.springframework.jms.support.converter.MessageConverter {

    private Queue rspQueue;
    public JmsTransactionConverter(){}

    public Queue getRspQueue() {
        return rspQueue;
    }
    public void setRspQueue(Queue queue) {
        rspQueue = queue;
    }

    /**
     * @author luoxiaosheng 2017-09-11
     * @time 10:53
     * @param
     * @return
     * @description  发送消息前转化消息
     */
    @Override
    public Message toMessage(Object o, Session session) throws JMSException, MessageConversionException {
        String s = (String)o;
        TextMessage message = session.createTextMessage(s);
        message.setStringProperty("mytype","java");
        return message;

    }

    /**
     * @author luoxiaosheng 2017-09-11
     * @time 10:53
     * @param
     * @return
     * @description  接受消息将消息转化为对象
     */
    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        MessageBean msgBean = new MessageBean();
        TextMessage massage = (TextMessage)message;
        try {
            String str = massage.getText();
            msgBean.setHead("HeadTest");
            msgBean.setOutput(str);
            msgBean.setStatus("success");

        } catch (JMSException e) {
            // TODO Auto-generated catch block
            msgBean = null;
            e.printStackTrace();
        }
        finally {
            return msgBean;
        }
    }
}
