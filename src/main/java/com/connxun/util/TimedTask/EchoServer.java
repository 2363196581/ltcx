package com.connxun.util.TimedTask;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Author：luoxiaosheng
 * @Date：2017-08-14 14:42
 * @Comments：定时任务类
 */
@Component
@Lazy(value=false)
public class EchoServer implements Runnable{
    @Override
    public void run() {

    }

//    @Autowired
//    private LwVoucherService lwVoucherService;
//    @Autowired
//    private LwVoucherLogService lwVoucherLogService;
//
////    ThreadExecutors.executeInitialDelay(runnable,lwVoucher2.getStopDate().getTime() - new Date().getTime());
//
//    @Override
//    public void run() {
//        System.out.println("++++++++++++++++EchoServer+++++++++++++++++");
//        List<LwVoucher> list = lwVoucherService.findAllByState(1);
//        if (list.size()>0){
//            for (LwVoucher lwVoucher : list) {
//                if (lwVoucher.getStopDate().getTime() < new Date().getTime() && lwVoucher.getState() == 1) {
//                    /*开启延时任务*/
//                    Runnable runnable = () -> {
//                        // task to run goes here
//                        System.out.println("++++++++++++++++执行立即任务+++++++++++++++++");
//                        lwVoucherService.updateState(lwVoucher.getId(), 2);
//                        lwVoucherLogService.updateState(lwVoucher.getId());
//                    };
//                    executeInitialDelay(runnable, 2 * 60 * 1000);
//                } else if (lwVoucher.getStopDate().getTime() > new Date().getTime() && lwVoucher.getState() == 1) {
//                    /*开启延时任务*/
//                    Runnable runnable = () -> {
//                        // task to run goes here
//                        System.out.println("++++++++++++++++执行延时任务+++++++++++++++++");
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
