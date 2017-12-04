package com.connxun.util.qcloud;

import com.connxun.util.string.StringUtil;

import java.util.Date;

public class TestAPI {

    public static final String APPID  = "1252084313";
    public static final String APIKEY = "adf2b179a0ba67114b37211426b46d6a";
    public static final String BIZID   = "2914";
    public static String TIMESTRAP  ="";

    public static void  main(String ...args){

        HttpUtils.doGetAsyn("http://fcgi.video.qcloud.com/common_access"
                        + "?appid=" + APPID +

                        "&t=" + getTimeStrap() +
                        "&sign=" + getSign()+
                        "&Para=" + getSign()+
                        "&interface=Live_Channel_GetChannelList"
                , result -> System.out.println(result));
        System.out.println(getTimeStrap());
    }

    private static String getSign(){
        TIMESTRAP = getTimeStrap();
//        return TIMESTRAP;
        return StringUtil.getMD5(APIKEY.concat(TIMESTRAP));
//      return Md5Util.encode(APIKEY.concat(TIMESTRAP));
    }


    private static String getTimeStrap(){
        return String.valueOf(new Date(2017,9,14).getTime());
    }


}
