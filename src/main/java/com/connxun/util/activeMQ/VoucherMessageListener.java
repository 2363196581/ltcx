//package com.connxun.util.activeMQ;
//
//import com.app.controller.TempletUtil;
//import com.app.entity.LwVoucher;
//import com.app.entity.LwVoucherLog;
//import com.app.service.LwVoucherCourseService;
//import com.app.service.LwVoucherLogService;
//import com.app.service.LwVoucherService;
//import com.common.vo.JsonResult;
//import com.util.date.DateUtil;
//import com.util.redis.RedisClient;
//import org.apache.activemq.command.ActiveMQObjectMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.listener.SessionAwareMessageListener;
//
//import javax.jms.*;
//
///**
// * @Author：luoxiaosheng
// * @Date：2017-08-18 15:45
// * @Comments：异步消息监听器
// */
//public class VoucherMessageListener implements SessionAwareMessageListener<Message> {
////    private final String transactionBiz = "tstDistributedTransaction";
//
//    @Autowired
//    private LwVoucherLogService lwVoucherLogService;
//    @Autowired
//    private LwVoucherService lwVoucherService;
//    @Autowired
//    private LwVoucherCourseService lwVoucherCourseService;
//    @Autowired
//    private RedisClient redisClient;
//
//    @Override
//    public void onMessage(Message message, Session session) throws JMSException {
//        //这里建议不要try catch，让异常抛出，通过redeliveryPolicy去重试，达到重试次数进入死信DLQ(Dead Letter Queue)
////        ActiveMQTextMessage msg = (ActiveMQTextMessage) message;
//        ActiveMQObjectMessage msg=(ActiveMQObjectMessage)message;
//        LwVoucherLog obj=(LwVoucherLog)msg.getObject();
//        // 转换成相应的对象
//        if(obj!=null){
//            /*获取代金券*/
//            LwVoucher lwVoucher=lwVoucherService.findOne(obj.getVoucherId());
//            /*编写回执消息*/
//            Destination recall_destination =message.getJMSReplyTo();
//            // 创建回执消息
//            ObjectMessage objectMessage = null;
//            JsonResult jsonResult=null;
//
//            if (lwVoucher.getNumber()>0){
//                LwVoucherLog lwVoucherLog=lwVoucherLogService.save(obj);
////                LwVoucherLog lwVoucherLog=lwVoucherLogService.save((LwVoucherLog) JsonUtil.toObject(LwVoucherLog.class,msg.getText()));
//                //获取代金券对应课程
//                String courseNames = lwVoucherCourseService.getCourseNames(lwVoucherLog.getVoucherId());
//                /*缓存当前状态值*/
//                redisClient.set("VOUCHERLOG:STATE:" + Integer.toString(lwVoucherLog.getId()), Integer.toString(lwVoucherLog.getState()));
//                //发送推送消息
//                try {    //sendData.getUserNo().toString()
//                    TempletUtil.voucher(lwVoucherLog.getUserNo().toString(), lwVoucherLog.getCode(), courseNames, DateUtil.dateStringZH(lwVoucher.getBeginDate()), DateUtil.dateStringZH(lwVoucher.getStopDate()));
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                jsonResult=new JsonResult(true,"代金券领取成功",lwVoucher);
////                objectMessage = session.createObjectMessage(lwVoucher);
//            }else{
//                jsonResult=new JsonResult(true,"代金券领取失败",lwVoucher);
////                objectMessage = session.createObjectMessage(lwVoucher);
//            }
//            //回执对象消息
//            objectMessage = session.createObjectMessage(jsonResult);
//            // 以上收到消息之后，重新创建生产者，然后在回执过去
//            MessageProducer producer = session.createProducer(recall_destination);
//            producer.send(objectMessage);
//        }
//    }
//}
