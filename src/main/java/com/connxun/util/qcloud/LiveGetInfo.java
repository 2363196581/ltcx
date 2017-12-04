package com.connxun.util.qcloud;

import com.connxun.util.date.DateUtil;
import com.connxun.util.http.HttpUtil;
import com.connxun.util.string.StringUtil;

import java.util.Date;

import static com.connxun.util.qcloud.LiveConstantAPI.*;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-15 16:30
 * @Comments：直播查询工具类
 */
public class LiveGetInfo {

    /*获取当前时间戳*/
    public static String TIMESTRAP  =DateUtil.getTimeStrap(new Date());

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
     * @return
     * @description  查询指定直播流的推流和播放信息
     */
    public static String LiveChannelGetStatus(String channel_id){
        return HttpUtil.getJsonFromUrl(baseSearch(LIVE_CHANNEL_GETSTATUS)+
                "&Param.s.channel_id="+channel_id);
    }

    /**
     * @author luoxiaosheng 2017-09-15
     * @time 17:12
     * @param channel_id 直播流id
     * @return
     * @description  查询录制文件
     */
    public static String LiveTapeGetFilelist(String channel_id){
        return HttpUtil.getJsonFromUrl(baseSearch(LIVE_TAPE_GETFILELIST)+
                "&Param.s.channel_id="+channel_id);
    }

    /**
     * @author luoxiaosheng 2017-09-15
     * @time 17:29
     * @param 
     * @return 
     * @description  查询频道列表
     */
    public static String LiveChannelGetChannelList(){

        return HttpUtil.getJsonFromUrl(baseSearch(LIVE_CHANNEL_GETCHANNELLIST));
    }

    /**
     * @author luoxiaosheng 2017-09-15
     * @time 17:29
     * @param
     * @return
     * @description  查询直播中频道列表
     */
    public static String LiveChannelGetLiveChannelList(){

        return HttpUtil.getJsonFromUrl(baseSearch(LIVE_CHANNEL_GETLIVECHANNELLIST));
    }




    public static void  main(String ...args){

        /*基于回调*/
//        HttpUtils.doGetAsyn(baseSearch(LIVE_CHANNEL_GETCHANNELLIST)
//                , result -> System.out.println(result));

        /*基于返回json*/
//        String result=HttpUtil.getJsonFromUrl(baseSearch(LIVE_CHANNEL_GETCHANNELLIST));

//
//        System.out.println(LiveChannelGetStatus("2914_0a9cd808b1"));
//        System.out.println(LiveTapeGetFilelist("2914_0a9cd808b1"));
        System.out.println(LiveChannelGetChannelList());
//        System.out.println(LiveChannelGetLiveChannelList());
        System.out.println(TIMESTRAP);
//        System.out.println(result);
    }
}
