package com.connxun.util.qcloud;

import com.connxun.util.encrypt.EncryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static com.connxun.util.qcloud.LiveConstantAPI.*;


/**
 * @Author：luoxiaosheng
 * @Date：2017-09-18 09:54
 * @Comments：推流地址生成器
 */
public class LiveAddressCreate {

    protected static Logger LOG = LoggerFactory.getLogger(LiveAddressCreate.class);

    /**
     * 创建推流地址
     * @param deadTime 地址有效时间
     * @param streamId 直播码（用户表标识符）
     * @return
     */
    public static String createLiveAddress(Date deadTime,String streamId){
        if (deadTime==null){
//            liveDate = DateUtil.stringToDate(deadTime,"yyyy-MM-dd HH:mm:ss");
//        }else{
            /*如果时间参数不存在，则设置当前时间+1*/
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动

            deadTime=calendar.getTime();
        }

        streamId=(BIZID+"_"+streamId);

        LOG.info(LIVEPUSH +streamId
                + "?" + "bizid="+BIZID
                + "&" +getSafeUrl(PUSHKEY, streamId, deadTime.getTime()/1000));
        return LIVEPUSH +streamId
                + "?" + "bizid="+BIZID
                + "&" +getSafeUrl(PUSHKEY, streamId, deadTime.getTime()/1000);
    }

    /**
     * 获取播放地址
     * @param streamId 直播码（bizid+streamId）
     * @param width 播放宽度
     * @param height 播放高度
     * @return
     */
    // http://live.cloud.tencent.com/live/play.html?
    // url=rtmp%3A%2F%2F2914.liveplay.myqcloud.com%2Flive%2F2914_test201703
    // url=http%3A%2F%2F2914.liveplay.myqcloud.com%2Flive%2F2914_test201703.flv
    // &url2=http%3A%2F%2F2914.liveplay.myqcloud.com%2Flive%2F2914_test201703.m3u8&width=800&height=600
    public static String getLivePlayAddress(String streamId,int width,int height){

//        streamId=(BIZID+"_"+streamId);

        StringBuilder playAddress=new StringBuilder();
        try {
            playAddress.append(PLAYURL
                    + "url=" +URLEncoder.encode( RTMPPLAY+streamId,"utf-8")
                    + "&url1=" + URLEncoder.encode( FLVPLAY+streamId+".flv","utf-8")
                    + "&url2=" + URLEncoder.encode( HLSPLAY+streamId+".m3u8","utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (width>0){
            playAddress.append("&width="+width);
        }
        if (width>0){
            playAddress.append("&width="+height);
        }
        LOG.info(playAddress.toString());
        return playAddress.toString();
    }

    private static final char[] DIGITS_LOWER =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /*
     * KEY+ stream_id + txTime
     */
    private static String getSafeUrl(String key, String streamId, long txTime) {
        String input = new StringBuilder().
                append(key).
                append(streamId).
                append(Long.toHexString(txTime).toUpperCase()).toString();

        String txSecret = null;
        txSecret= EncryptUtil.getMd5(input);
//            try {
//                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
//                txSecret  = byteArrayToHexString(
//                        messageDigest.digest(input.getBytes("UTF-8")));
//            } catch (NoSuchAlgorithmException e) {
//                e.printStackTrace();
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
        return txSecret == null ? "" :
                new StringBuilder().
                        append("txSecret=").
                        append(txSecret).
                        append("&").
                        append("txTime=").
                        append(Long.toHexString(txTime).toUpperCase()).
                        toString();
        }

    private static String byteArrayToHexString(byte[] data) {
        char[] out = new char[data.length << 1];

        for (int i = 0, j = 0; i < data.length; i++) {
            out[j++] = DIGITS_LOWER[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS_LOWER[0x0F & data[i]];
        }
        return new String(out);
    }

    public static void main(String[] args) {

        System.out.println(getLivePlayAddress("2914_test201703",0,0));
//        System.out.println(createLiveAddress("","test201704"));

    }

}
