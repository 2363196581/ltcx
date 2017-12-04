package com.connxun.app.controller;


import com.connxun.util.date.DateUtil;
import com.connxun.util.jpush.PushService;
import com.connxun.util.string.StringUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-26 10:43
 * @Comments：消息推送
 */
@Component
@RestController
@RequestMapping(value = "/lw/user/TempletUtil")
public class TempletUtil {

//    private static LwUserMsgService lwUserMsgService;
//
//    private static LwUserService lwUserService;
//
//    @Autowired
//    public void setLwUserMsgService(LwUserMsgService dsForRW, LwUserService lwUserService) {
//        TempletUtil.lwUserMsgService = dsForRW;
//        TempletUtil.lwUserService = lwUserService;
//    }

    @RequestMapping(value = "index")
    public static void addMsg(String alias, String msg, String title, Integer iconNo, Integer type, Integer courseNo, Integer voucherNo) {
        if (StringUtil.isInteger(alias)) {
//            LwUser lwUser = lwUserService.findOne(Integer.parseInt(alias));
//            JzUser lwUser = null;
//            if (lwUser != null) {
//                LwUserMsg lwUserMsg = new LwUserMsg();
//                lwUserMsg.setUserNo(Integer.parseInt(alias));
//                lwUserMsg.setMsg(msg);
//                lwUserMsg.setTitle(title);
//                lwUserMsg.setIconNo(iconNo);
//                if (type != null) {
//                    lwUserMsg.setType(type);
//                }
//                if (courseNo != null) {
//                    lwUserMsg.setCourseNo(courseNo);
//                }
//                if (voucherNo != null) {
//                    lwUserMsg.setVoucherNo(voucherNo);
//
//                }
////                lwUserMsgService.save(lwUserMsg);
//            }

        }
    }

    /*0 课程  1 代金券 2订单列表 3 注册邀请 4代金券   9 不跳*/
    /*//    注册成功信息*/
    /*场景1：注册成功
icon：[系]
消息类别：系统消息
消息标题：注册成功
*/
    public static String reg(String alias) {
        String msg = "您好！欢迎您加入老吴公考大家庭。真诚希望您在老吴公考学习平台上，天天有收获，早日踏入机关大门！加入老吴公考，让成功来得更快些！";
        addMsg(alias, msg, "系统消息", 1, null, null, null);
        PushService.pushAlert(alias, msg);
        return msg;
    }

    public static String PushDemo(String alias,String msg) {
        PushService.pushAlert(alias, msg);
//     addMsg(alias, msg, "系统消息", 1);
        return msg;
    }

    public static void main(String[] args) {

        try {
            PushDemo("100097","老吴公考测试");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*场景2：课程订单-支付成功.
 icon：[订]
 消息标题：支付成功
 */
    public static String orderPaySuccess(String alias, String courseName, String orderShow, String courseNo) {
        String msg = "您购买的《" + courseName + "》（订单编号：" + orderShow + "）已支付成功。点击本消息可进入课程学习入口。";
        addMsg(alias, msg, "支付成功", 2, 0, Integer.parseInt(courseNo), null);
        PushService.pushAlertExt(alias, msg, "courseNo", courseNo);
        return msg;
    }

    /*场景3：课程订单-支付失败0
icon：[订]
消息标题：支付失败
*/
    public static String orderPayFail(String alias, String courseName, String orderShow) {
        String msg = "您购买的《" + courseName + "》（订单编号：" + orderShow + "）支付失败。请联系支付宝客服：95188 或者微信支付客服：95017了解详情。";
        PushService.pushAlert(alias, msg);
        addMsg(alias, msg, "支付失败", 2, 2, null, null);

        return msg;
    }


    /*场景4：课程订单-订单超时0
  icon：[订]
  消息标题：订单超时
  */
    public static String orderTimeOut(String alias, String courseName, String orderShow, int time) {

        String msg = " 您拍下的《" + courseName + "》（订单编号：" + orderShow + "），超过{" + time + "}天未支付，系统将自动删除本订单。";
        PushService.pushAlert(alias, msg);
        addMsg(alias, msg, "订单超时", 2, 2, null, null);


        return msg;
    }

    /*场景5：课程通知-上课提醒
 icon：[课]
 消息标题：上课提醒*/
    public static String classReminder(String alias, String courseName, String orderShow, String time, Integer courseNo) {

        String msg = " 您购买的《" + courseName + "》（第{1}次课）将于" + time + "开课！请您打开老吴公考网或者下载安装老吴公考APP准时上课哟。    ";

        PushService.pushAlert(alias, msg);
        addMsg(alias, msg, "上课提醒", 3, 0, courseNo, null);

        return msg;
    }

    /*场景6：课程通知-课程调整
 icon：[课]
 消息标题：课程调整
 */
    public static String courseTimeAdjustment(String alias, String courseName, String courseChatper, String orderShow, String time, Integer courseNo) {

        String msg = " 《" + courseName + "》上课内容为：" + courseChatper + "，上课时间为：" + time + "。老吴公考提醒您不要错过精彩课程哟。    ";

        PushService.pushAlert(alias, msg);
        addMsg(alias, msg, "课程调整", 3, 0, courseNo, null);

        return msg;
    }

    /*场景7：课程通知-课程即将下架
    icon：[课]
    消息标题：下架提醒（针对直播课、录播课、套餐课，依据课程有效期判定）
    */
    public static String courseOff(String alias, String courseName, String time, Integer courseNo) {

        String msg = " 您购买的《" + courseName + "》将于" + time + "下架。课程下架后将无法进行学习，老吴公考提醒您尽快学习。    ";

        PushService.pushAlert(alias, msg);
        addMsg(alias, msg, "下架提醒", 3, 0, courseNo, null);


        return msg;
    }

    /*场景8：课程通知-已经下架
    icon：[课]
    消息标题：下架提醒（针对直播课、录播课、套餐课，依据课程有效期判定）
    消息模板：（下架后）
    */
    public static String courseIsOff(String alias, String courseName) {

        String msg = " 您购买的《" + courseName + "》已下架。感谢您对老吴公考的认可，祝您：备考顺利，一举成公！    ";

        PushService.pushAlert(alias, msg);
        addMsg(alias, msg, "下架提醒", 3, 9, null, null);

        return msg;
    }

    /*场景9：课程开通-手动开课
    icon：[课]
    消息标题：课程开通
    */
    public static String courseOpen(String alias, String courseName, Integer courseNo, Date time) {
        String time1 = DateUtil.dateStringZH(time);
        String msg = "  老吴公考为您开通了《" + courseName + "》，课程有效期至" + time1 + "。请进入[个人中心]-[我的课程]中查看。   ";
        PushService.pushAlert(alias, msg);
        addMsg(alias, msg, "课程开通", 3, 0, courseNo, null);

        return msg;
    }

    /*
    场景10：发货通知-物流信息
    icon：[邮]
    消息标题：物流信息
    */
    public static String sendInfo(String alias, String sendData, String sendtime, String deliveryCompany, String deliveryNumber) {

        String msg = "  您的资料" + sendData + "已于" + sendtime + "发货。快递公司：" + deliveryCompany + "，快递单号" + deliveryNumber + "，请您于明天中午12点后登录" + deliveryCompany + "官网查询物流进度。   ";
        PushService.pushAlert(alias, msg);
        addMsg(alias, msg, "物流信息", 4, 2, null, null);

        return msg;
    }

    /*场景11：我的福利-注册邀请失败
    icon：福
    消息标题：注册邀请
    */
    public static String invitationFail(String alias, Integer userNum, Integer userLessNum) {

        String msg = "消息模板：非常遗憾！本轮注册邀请活动已结束，您共成功邀请" + userNum + "人注册，还差" + userLessNum + "人，没有达到免费学习课程的条件。希望您继续关注下一轮活动。     ";
        addMsg(alias, msg, "注册邀请", 5, 3, null, null);
        PushService.pushAlert(alias, msg);

        return msg;
    }

    /*场景12：我的福利-注册邀请成功
    icon：福
    消息标题：注册邀请
    */
    public static String invitationSuccess(String alias, String courseName, Integer courseNo, Integer userNum) {

        String msg = " 恭喜您！本轮注册邀请活动中，您共成功邀请" + userNum + "人注册，达到免费学习《" + courseName + "》的条件。系统已自动为您开通本课程。请进入[个人中心]-[我的课程]中查看。    ";
        addMsg(alias, msg, "注册邀请", 5, 0, courseNo, null);
        PushService.pushAlert(alias, msg);

        return msg;
    }

    /*场景13：我的福利-购课邀请失败
    icon：福
    消息标题：购课邀请
    */
    public static String inviteBuyFail(String alias, String courseName, Integer userNum, Integer userLessNum) {

        String msg = " 非常遗憾！《" + courseName + "》购课邀请活动已结束，您共成功邀请" + userNum + "人原价购课，还差" + userLessNum + "人，没有达到免费学习本课程的条件。希望您继续关注其他购课邀请活动。    ";
        PushService.pushAlert(alias, msg);
        addMsg(alias, msg, "购课邀请", 5, 5, null, null);

        return msg;
    }

    /*场景14：我的福利-购课邀请成功
 icon：福
 消息标题：购课邀请
 */
    public static String inviteBuySuccess(String alias, String courseName, Integer courseNo, Integer userNum) {

        String msg = "  恭喜您！《" + courseName + "》购课邀请活动中，您共成功邀请" + userNum + "人原价购课，达到免费学习本课程的条件。系统已自动为您开通本课程。请进入[个人中心]-[我的课程]中查看。   ";
        PushService.pushAlert(alias, msg);
        addMsg(alias, msg, "购课邀请", 5, 0, courseNo, null);

        return msg;
    }

    /*场景15：我的福利-代金券后台发放
icon：福
消息标题：福利来啦
*/

    /**
     * @param alias
     * @param code
     * @param courseNames
     * @param startTime
     * @param endTime
     * @return
     */
    public static String voucher(String alias, String code, String courseNames, String startTime, String endTime) {

        String msg = " 福利来啦！老吴公考为您发放了一张代金券No:" + code + "，本券可在购买" + courseNames + "时抵消等额现金。" +
                "本券有效期：" + startTime + "-" + endTime + "。请在[个人中心]-[我的福利]-[我的代金券]中查看。 ";
        PushService.pushAlert(alias, msg);
        addMsg(alias, msg, "福利来啦", 5, 4, null, null);

        return msg;
    }

    /*场景16：我的福利-代金券前端申领
 icon：福
 消息标题：福利来啦
 */
    public static String inviteBuySuccess(String alias, String code, String courseNames, String startTime, String endTime) {

        String msg = "  恭喜您！您成功抢到了一张代金券No:" + code + "，本券可在购买" + courseNames + "时抵消等额现金。" +
                "本券有效期：" + startTime + "-" + endTime + "。请在[个人中心]-[我的福利]-[我的代金券]中查看。 ";
        PushService.pushAlert(alias, msg);
        addMsg(alias, msg, "福利来啦", 5, 4, null, null);
        return msg;
    }


}