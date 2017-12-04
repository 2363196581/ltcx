package com.connxun.util.qcloud;

import com.connxun.util.date.DateUtil;
import com.connxun.util.http.HttpUtil;
import com.connxun.util.string.StringUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import static com.connxun.util.qcloud.LiveConstantAPI.*;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-15 18:01
 * @Comments：直播操作工具类
 */
public class LiveOperate {

    /*获取当前时间戳*/
    public static String TIMESTRAP  = DateUtil.getTimeStrap(new Date());

    /**
     * @author luoxiaosheng 2017-09-15
     * @time 17:11
     * @param inface 接口名称
     * @return
     * @description  基础查询字段
     */
    public static String baseSearch(String inface){
        return "http://fcgi.video.qcloud.com/common_access" +
                "?appid=" + APPID +
                "&t=" + TIMESTRAP +
                "&sign=" + StringUtil.getMD5(APIKEY.concat(TIMESTRAP)) +
                "&interface="+inface ;

    }

    /**
     * @author luoxiaosheng 2017-09-15
     * @time 17:12
     * @param channel_id 直播流id
     * @param status 0表示禁用； 1表示允许推流；2表示断流
     * @return
     * @description  开启关闭推流
     */
    public static String LiveChannelSetStatus(String channel_id,int status){
        return HttpUtil.getJsonFromUrl(baseSearch(LIVE_CHANNEL_SETSTATUS)+
                "&Param.s.channel_id="+channel_id +
                "&Param.n.status="+status);
    }


    // TODO: 2017-09-15 云端混流

    /**
     * @author luoxiaosheng 2017-09-15
     * @time 17:12
     * @param channel_id 直播流id
     * @param start_time 开始时间
     * @param end_time 结束时间
     * @return
     * @description  创建录制任务
     */
    public static String LiveTapeStart(String channel_id,String start_time,String end_time){
        try {
            return HttpUtil.getJsonFromUrl(baseSearch(LIVE_TAPE_START)+
                    "&Param.s.channel_id="+channel_id +
                    "&Param.s.start_time="+ URLEncoder.encode(start_time,"utf-8") +
                    "&Param.n.end_time="+URLEncoder.encode(end_time,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @author luoxiaosheng 2017-09-15
     * @time 17:12
     * @param channel_id 直播流id
     * @param task_id 开始时间
     * @param task_sub_type 结束时间
     * @return
     * @description  结束录制任务
     */
    public static String LiveTapeStop(String channel_id,String task_id,int task_sub_type){

        return HttpUtil.getJsonFromUrl(baseSearch(LIVE_TAPE_STOP)+
                "&Param.s.channel_id="+channel_id +
                "&Param.s.task_id="+ task_id +
                "&Param.n.task_sub_type="+task_sub_type);

    }

    /**
     * @author luoxiaosheng 2017-09-15
     * @time 17:12
     * @param channel_id 直播流id
     * @param abstime_end 恢复的绝对时间戳
     * @param action 动作 断流：forbid；恢复推流：resume
     * @return
     * @description  暂停推流并延迟恢复接口
     */
    public static String channelManager(String channel_id,int abstime_end,String action){

        return HttpUtil.getJsonFromUrl(baseSearch(CHANNEL_MANAGER)+
                "&Param.s.channel_id="+channel_id +
                "&Param.s.task_id="+ abstime_end +
                "&Param.n.task_sub_type="+action);

    }




    public static void  main(String ...args){

//        System.out.println(LiveChannelSetStatus("2914_0a9cd808b1",1));
//        System.out.println(LiveTapeStart("2914_0a9cd808b1",DateUtil.getSystemTime(),
//                DateUtil.dateToString(new Date(2017, 9, 30),"yy-MM-dd HH:mm:ss")));
        //18847395
        System.out.println(LiveTapeStop("2914_0a9cd808b1","18847174",0));
        System.out.println(channelManager("2914_0a9cd808b1",Integer.parseInt(DateUtil.getTimeStrap(new Date(2017,9,15,18,40))),"resume"));
        System.out.println(TIMESTRAP);
//        System.out.println(result);
    }
}
