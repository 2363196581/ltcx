package com.connxun.util.easemob.util;


import com.connxun.util.easemob.model.TalkNode;
import com.connxun.util.easemob.service.TalkDataService;
import com.connxun.util.easemob.service.impl.TalkDataServiceImpl;
import com.connxun.util.easemob.service.impl.TalkHttpServiceImplApache;

/**
 * 聊天室工具
 * Created by Mac on 2017/6/21.
 */
public class TalkRoomUtil {

    private static TalkDataService service = new TalkDataServiceImpl(new TalkHttpServiceImplApache());

    /**
     * 添加聊天室
     *
     * @param owner  所属用户
     * @param name   群组名称
     * @param desc   群组描述
     * @param limit  用户上限
     */
    public static TalkNode roomSave(String owner, String name, String desc, Integer limit) {
        String[] friend = {"000001", "00000"};
        TalkNode talkNode = new TalkNode();

        //注册
        try {
            talkNode = service.roomSave(owner, name, desc, limit, friend);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return talkNode;

    }

    /**
     * 删除聊天群室
     *
     * @param id 群组编号
     */
    public static TalkNode roomDrop(String id) {
        TalkNode talkNode = new TalkNode();

        //
        try {
            talkNode = service.roomDrop(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return talkNode;

    }

    /**
     * 添加聊天室成员[单个]
     *
     * @param id     群组编号
     * @param friend 聊天账户
     */
    public static TalkNode roomFriendSave(String id, String friend) {
        TalkNode talkNode = new TalkNode();

        //
        try {
            talkNode = service.roomFriendSave(id, friend);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return talkNode;
    }

    /**
     * 删除聊天好友(单个)
     *
     * @param id     群组编号
     * @param friend 聊天账户
     */
    public static TalkNode roomFriendDrop(String id, String friend) {

        TalkNode talkNode = new TalkNode();

        //
        try {
            talkNode = service.roomFriendDrop(id, friend);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return talkNode;

    }

}
