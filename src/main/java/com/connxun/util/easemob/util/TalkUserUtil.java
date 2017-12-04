package com.connxun.util.easemob.util;


import com.connxun.util.easemob.model.TalkNode;
import com.connxun.util.easemob.service.TalkDataService;
import com.connxun.util.easemob.service.impl.TalkDataServiceImpl;
import com.connxun.util.easemob.service.impl.TalkHttpServiceImplApache;

/**
 * 环信用户管理类
 * Created by Mac on 2017/6/21.
 */

public class TalkUserUtil {
    private static TalkDataService service = new TalkDataServiceImpl(new TalkHttpServiceImplApache());

    public static TalkNode userSave(String name) {

        TalkNode talkNode = new TalkNode();

        //注册
        try {
            talkNode = service.userSave(name, "12399123", name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return talkNode;

    }

    public static TalkNode userDrop(String name) {

        TalkNode talkNode = new TalkNode();

        //注册
        try {
            talkNode = service.userDrop(name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return talkNode;

    }

    //
    public static TalkNode userModifyNickname(String username, String nickname) {

        TalkNode talkNode = new TalkNode();

        //注册
        try {
            talkNode = service.userModifyNickname(username, nickname);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return talkNode;

    }


    public static void main(String[] args) {

        System.out.println( userSave("000001").getStatusCode());


    }

}
