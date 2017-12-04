package com.connxun.util.easemob.tool;

public class _Global {
    public static int APP_PAGE_SIZE = 5;
    /*public static String APP_KEY = "liaozikeji#iamhere";
    public static String APP_CLIENT_ID = "YXA6NBMjoES_EeWfZX321e1Ufw";
    public static String APP_CLIENT_SECRET = "YXA6JvbvIj38v_Fi6Blkx246Cip4ZG0";*/
    public static String APP_KEY = "connxun#livebeauty";
    public static String APP_CLIENT_ID = "YXA6kV_KYFV4Eee1z63dA-ZkRQ";
    public static String APP_CLIENT_SECRET = "YXA6wUyIf6J1u8aU8qnmoH9K5_ZacPo";
    //TODO 以上参数需相应修改
    public static final int HTTP_METHOD_GET = 1;
    public static final int HTTP_METHOD_POST = 2;
    public static final int HTTP_METHOD_PUT = 3;
    public static final int HTTP_METHOD_DELETE = 4;
    public static final String URL_HOST = "http://a1.easemob.com/" + APP_KEY.replace("#", "/") + "/";
    public static final String URR_TOKEN = URL_HOST + "token";
    public static final String URL_CHAT = URL_HOST + "chatmessages";
    public static final String URL_GROUP = URL_HOST + "chatgroups";
    public static final String URL_FILE = URL_HOST + "chatfiles";
    public static final String URL_ROOM = URL_HOST + "chatrooms";
    public static final String URL_MESSAGES = URL_HOST + "messages";
    public static final String URL_USER = URL_HOST + "users";

    public static final String B_APP_ID = "bbc56218-0a54-4cc9-bf05-aec80aefa069";

    public static final String B_SECRET = "933097dc-304a-4f5c-998b-0dfbeb0cd0e6";
    public static final String B_MASTER_SECRET = "934622b1-8624-4f3d-930a-f1e53e6a87d8";
}