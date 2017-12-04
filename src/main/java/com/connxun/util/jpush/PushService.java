package com.connxun.util.jpush;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.ServiceHelper;
import cn.jiguang.common.connection.NativeHttpClient;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * http://docs.jiguang.cn/jpush/server/3rd/java_sdk/
 *
 * @author flyinke
 */
public class PushService {
    protected static final Logger LOG = LoggerFactory.getLogger(PushService.class);

    protected static final String APP_KEY = "0519b757065d249398dc03cd";
    protected static final String MASTER_SECRET = "8107e92b82648a2b99c2be60";
    private static final String TITLE = "老吴公考";

    private static void sendPush(PushPayload payload) {

        ClientConfig clientConfig = ClientConfig.getInstance();
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, clientConfig);
        String authCode = ServiceHelper.getBasicAuthorization(APP_KEY, MASTER_SECRET);
        NativeHttpClient httpClient = new NativeHttpClient(authCode, null, clientConfig);
        jpushClient.getPushClient().setHttpClient(httpClient);

        try {
            PushResult result = jpushClient.sendPush(payload);
            LOG.info("Got result - " + result);

        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
            LOG.error("Sendno: " + payload.getSendno());

        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
            LOG.error("Sendno: " + payload.getSendno());
        }
    }


    public static void pushAlert(List<String> aliasList, String pushEntity) {
//    	JsonObject jsonObject = new Gson().toJsonTree(pushEntity).getAsJsonObject();

        PushPayload payload = PushPayload.newBuilder()
//    			.setOptions(Options.newBuilder().setApnsProduction(true).build())
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.alias(aliasList))
                .setNotification(Notification.newBuilder()
                        .setAlert(pushEntity)
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .setTitle(TITLE).build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .incrBadge(1)
                                .addExtra("title", TITLE)
                                .build())

                        .build())
                .build();

        sendPush(payload);
    }

    public static void pushAlert(String alias, String pushEntity) {
        try {
            PushPayload payload = PushPayload.newBuilder()
                    .setOptions(Options.newBuilder().setApnsProduction(true).build())
                    .setPlatform(Platform.android_ios())
                    .setAudience(Audience.alias(alias))
                    .setNotification(Notification.newBuilder()
                            .setAlert(pushEntity)
                            .addPlatformNotification(AndroidNotification.newBuilder()
                                    .setTitle(TITLE).build())
                            .addPlatformNotification(IosNotification.newBuilder()
                                    .incrBadge(1)
                                    .addExtra("title", TITLE)
                                    .build())
                            .build())
                    .build();

            sendPush(payload);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void pushAlertExt(String alias, String pushEntity, String key, String value) {

        PushPayload payload = PushPayload.newBuilder()
                .setOptions(Options.newBuilder().setApnsProduction(true).build())
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.newBuilder()
                        .setAlert(pushEntity)
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .setTitle(TITLE).build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .incrBadge(1)
                                .addExtra("title", TITLE)
                                .addExtra(key, value).build())
                        .build())
                .build();

        sendPush(payload);
    }


    //    public static void pushAlertAll(PushEntity pushEntity) {
//
//    	JsonObject jsonObject = new Gson().toJsonTree(pushEntity).getAsJsonObject();
//    	PushPayload payload = PushPayload.newBuilder()
////    			.setOptions(Options.newBuilder().setApnsProduction(true).build())
//                .setPlatform(Platform.android_ios())
//                .setAudience(Audience.all())
//                .setNotification(Notification.newBuilder()
//                		.setAlert(pushEntity.getMessage())
//                		.addPlatformNotification(AndroidNotification.newBuilder()
//                				.setTitle(TITLE).build())
//                		.addPlatformNotification(IosNotification.newBuilder()
//                				.incrBadge(1)
//                				.addExtra("title", TITLE)
//                				.addExtra("pushEntity", jsonObject).build())
//                		.build())
//                .build();
//    	sendPush(payload);
//    }
//
//
    public static void main(String[] args) {
//		PushService.pushAlert("SU000000053", "海合网", "您有新的好友动态");
        pushAlert("123456", "122222222222222222222222222");
    }

}
