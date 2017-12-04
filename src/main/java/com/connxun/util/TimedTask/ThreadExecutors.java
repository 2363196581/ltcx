package com.connxun.util.TimedTask;


import com.connxun.util.date.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author：luoxiaosheng
 * @Date：2017-08-02 15:27
 * @Comments：线程池操作类
 */
@Component
@Lazy(value = false)
public class ThreadExecutors {


    protected final Logger LOG = LoggerFactory.getLogger(this.getClass());

    /*自定义连接池*/
//    private static ThreadPoolExecutor pool=null;
//
//    //静态工厂方法
//    public static ThreadPoolExecutor getInstance() {
//        if (pool == null) {
//            //创建等待队列
//            BlockingQueue bqueue = new ArrayBlockingQueue(20);
//            pool = new ThreadPoolExecutor(2,3,2,TimeUnit.MILLISECONDS,bqueue);
//        }
//        return pool;
//    }

    /*创建一个可重用的、具有固定线程数的线程池*/
//    public static ExecutorService FIXPOOL = Executors.newFixedThreadPool(5);

    /*创建一个具有缓存功能的线程池，系统根据需要创建线程，这些线程将会被缓存在线程池中*/
//    public static ExecutorService CACHEPOOL = Executors.newCachedThreadPool();

    /*创建单线程线程池*/
    public static ScheduledExecutorService SINGLESERVICE = Executors.newSingleThreadScheduledExecutor();

    //    /*创建具有指定线程数的线程池,且可指定延时*/
    public static ScheduledExecutorService SERVICE = Executors.newScheduledThreadPool(3);


    /**
     * 执行单次延时任务
     */
    public static void executeInitialDelay(Runnable runnable, long initialDelay) {
        ThreadExecutors.SINGLESERVICE.schedule(
                runnable,
                initialDelay,
                TimeUnit.MILLISECONDS);
    }

    /**
     * 以固定周期频率执行任务
     */
    public static void executeFixedRate(Runnable runnable, long initialDelay, long period) {

        SERVICE.scheduleAtFixedRate(
                runnable,
                initialDelay,
                period,
                TimeUnit.MILLISECONDS);
    }

    /**
     * 以固定延迟时间进行执行,取决于每次任务执行的时间长短
     * 本次任务执行完成后，需要延迟设定的延迟时间，才会执行新的任务
     */
    public static void executeFixedDelay(Runnable runnable, long initialDelay, long period) {
        SERVICE.scheduleWithFixedDelay(
                runnable,
                initialDelay,
                period,
                TimeUnit.MILLISECONDS);
    }

    /**
     * @param time "HH:mm:ss"
     *             每天晚上8点执行一次
     *             每天定时安排任务进行执行
     */
    public static void executeEightAtNightPerDay(Runnable runnable, String time) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        long oneDay = 24 * 60 * 60 * 1000;
        long initDelay = getTimeMillis("20:00:00") - System.currentTimeMillis();
        initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;

        executor.scheduleAtFixedRate(
                runnable,
                initDelay,
                oneDay,
                TimeUnit.MILLISECONDS);
        System.out.println("this is a executeEightAtNightPerDay");
    }


    /**
     * 获取指定时间对应的毫秒数
     *
     * @param time "HH:mm:ss"
     * @return
     */
    private static long getTimeMillis(String time) {
        System.out.println("this is a getTimeMillis");
        try {
            Date curDate = DateUtil.stringToDate(new Date() + "" + time, "yy-MM-dd HH:mm:ss");
            return curDate.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @PostConstruct
    public void onApplicationEvent() {
        LOG.info("spring初始化任务执行");
        System.out.println("++++++++++++++++++++++++++++++");
        /*定时任务——传入外部runnable*/
//        executeInitialDelay(new EchoServer(),30*1000);
    }

//    /**
//     * 代金券
//     */
//    private void voucherStartSelf() {
//        List<LwVoucher> list = lwVoucherService.findAllByState(1);
////        List<String> list = RedisUtil.getList(SELFSTART_VOUCHER_LIST);
//        if (list.size() > 0) {
//            for (LwVoucher lwVoucher : list) {
////            for (String str : list) {
////                LwVoucher lwVoucher= (LwVoucher) JsonUtil.toObject(LwVoucher.class,str);
//                if (lwVoucher.getStopDate().getTime() < new Date().getTime() && lwVoucher.getState() == 1) {
//                    /*开启延时任务*/
//                    Runnable runnable = () -> {
//                        // task to run goes here
//                        LOG.info("++++++++++++++++执行立即任务+++++++++++++++++");
//                        lwVoucherService.updateState(lwVoucher.getId(), 2);
//                        lwVoucherLogService.updateState(lwVoucher.getId());
//                    };
//                    /*设置30秒留给系统缓冲*/
//                    executeInitialDelay(runnable, 30 * 1000);
//                } else if (lwVoucher.getStopDate().getTime() > new Date().getTime() && lwVoucher.getState() == 1) {
//                    /*开启延时任务*/
//                    Runnable runnable = () -> {
//                        // task to run goes here
//                        LOG.info("++++++++++++++++执行延时任务+++++++++++++++++");
//                        lwVoucherService.updateState(lwVoucher.getId(), 2);
//                        lwVoucherLogService.updateState(lwVoucher.getId());
//                    };
//                    executeInitialDelay(runnable, lwVoucher.getStopDate().getTime() - new Date().getTime());
//                }
//
//            }
//        }
//    }


}
