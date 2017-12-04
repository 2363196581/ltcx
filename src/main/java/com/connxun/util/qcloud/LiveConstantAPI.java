package com.connxun.util.qcloud;

import com.connxun.util.properties.OpeProperties;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-15 16:10
 * @Comments：直播接口类
 */
public class LiveConstantAPI {

//    //bizid
//    public static final String BIZID   = "2914";
//    //appid
//    public static final String APPID  = "1252084313";
//    //API鉴权key
//    public static final String APIKEY = "adf2b179a0ba67114b37211426b46d6a";
//    //推流防盗链key
//    public static final String PUSHKEY   = "2e6dc0f80dfb03fb1114be3ff80e4bf2";
//    //回调URL
//    public static final String BACKURL   = "http://wx.connxun.com/wx/callback";


    //bizid
    public static String BIZID;
    //appid
    public static String APPID;
    //API鉴权key
    public static String APIKEY;
    //推流防盗链key
    public static String PUSHKEY;
    //回调URL
    public static String BACKURL;
    /*静态代码块*/
    static{
        OpeProperties opeProperties=new OpeProperties();
        BIZID   = opeProperties.GetValueByKey("","live.bizid").trim();
        APPID  = opeProperties.GetValueByKey("","live.appid").trim();
        APIKEY = opeProperties.GetValueByKey("","live.apikey").trim();
        PUSHKEY   = opeProperties.GetValueByKey("","live.pushkey").trim();
        BACKURL   = opeProperties.GetValueByKey("","live.backurl").trim();
    }

    //推流地址前缀
    public static final String LIVEPUSH = "rtmp://" + BIZID + ".livepush.myqcloud.com/live/";
    //播放地址前缀
    public static final String LIVEPLAY = "rtmp://" + BIZID + ".liveplay.myqcloud.com/live/";

    //播放地址前缀
    public static final String PLAYURL = "http://live.cloud.tencent.com/live/play.html?";
    //RTMP播放地址
    public static final String RTMPPLAY = "rtmp://" + BIZID + ".liveplay.myqcloud.com/live/";
    //FLV播放地址前缀
    public static final String FLVPLAY = "http://" + BIZID + ".liveplay.myqcloud.com/live/";
    //HLS播放地址前缀
    public static final String HLSPLAY = "http://" + BIZID + ".liveplay.myqcloud.com/live/";

    /*------------查询类接口-----------*/
    //查询直播状态
    public static final String LIVE_CHANNEL_GETSTATUS = "Live_Channel_GetStatus";
    //查询指定直播流的推流和播放信息
    public static final String GET_LIVESTAT = "Get_LiveStat";
    //仅返回推流统计信息以提高查询效率
    public static final String GET_LIVEPUSHSTAT = "Get_LivePushStat";
    //仅返回播放统计信息以提高查询效率
    public static final String GET_LIVEPLAYSTAT = "Get_LivePlayStat";
    //查询录制文件
    public static final String LIVE_TAPE_GETFILELIST = "Live_Tape_GetFilelist";
    //查询截图文件
    public static final String LIVE_QUEUE_GET = "Live_Queue_Get";
    //查询频道列表
    public static final String LIVE_CHANNEL_GETCHANNELLIST = "Live_Channel_GetChannelList";
    //查询直播中的频道列表
    public static final String LIVE_CHANNEL_GETLIVECHANNELLIST = "Live_Channel_GetLiveChannelList";


    /*------------操作类接口------------*/
    //开启关闭推流
    public static final String LIVE_CHANNEL_SETSTATUS = "Live_Channel_SetStatus";
    //创建录制任务
    public static final String LIVE_TAPE_START = "Live_Tape_Start";
    //结束录制任务
    public static final String LIVE_TAPE_STOP = "Live_Tape_Stop";
    //暂停推流并延迟恢复接口
    public static final String CHANNEL_MANAGER = "channel_manager";

    /*------------统计类接口------------*/
    //获取推流历史信息
    public static final String GET_LIVEPUSHSTATHISTORY = "Get_LivePushStatHistory";
    //获取播放统计历史信息
    public static final String GET_LIVEPLAYSTATHISTORY = "Get_LivePlayStatHistory";

}
