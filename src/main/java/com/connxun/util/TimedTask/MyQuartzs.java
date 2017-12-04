package com.connxun.util.TimedTask;

/**
 * Created by anna on 2017-08-23.
 */
//@Component
//@Lazy(value=false)
public class MyQuartzs {

//    @Scheduled(cron = "*/5 * * * * ?")//每隔5秒执行一次
//    public void test() throws Exception {
//        System.out.println("Scheduled is working......");
//    }


    //@Scheduled(cron = "0 0 1 * * ?")//每天凌晨1点整
    //@Scheduled(cron = "0 30 0 * * ?")//每天凌晨0点30分
    //@Scheduled(cron = "0 */60 * * * ?")//1小时处理一次



//    @Scheduled(fixedDelay=10000)  //第一种方式
    //fixedDelay延时多少毫秒，多少毫秒执行一次
//    @Scheduled(cron="0 * * * * *")     //第二种方式
    /*
        1 Seconds (0-59)
        2 Minutes (0-59)
        3 Hours (0-23)
        4 Day of month (1-31)
        5 Month (1-12 or JAN-DEC)
        6 Day of week (1-7 or SUN-SAT)
        7 Year (1970-2099)
        取值：可以是单个值，如6；
            也可以是个范围，如9-12；
            也可以是个列表，如9,11,13
            也可以是任意取值，使用*
    */
    //0 * * * * * 代表每分钟执行一次
//    public void singing(){
//        System.out.println(DateUtil.getShortSystemTime());
//    }
}
