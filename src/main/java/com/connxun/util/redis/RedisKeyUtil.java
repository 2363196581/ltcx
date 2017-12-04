package com.connxun.util.redis;

/**
 * Redis设置的key
 *
 * @author gaoyf
 */
public class RedisKeyUtil {

    /**
     * 购物车
     */
    public static final String SHOPPINGCART_KEY = "BALANCE:WFX:CACHE:SHOPPINGCART:";

    /**
     * 微信access_token
     */
    public static final String ACCESS_TOKEN = "BALANCE:WFX:CACHE:ACCESS_TOKEN";
    /**
     * 微信jsapi_ticket
     */
    public static final String JSAPI_TICKET = "BALANCE:WFX:CACHE:JSAPI_TICKET";

    /**
     * 用户验证错误次数
     */
    public static final String VERIFYERROR_KEY = "BALANCE:WFX:CACHE:VERIFYERROR:";
    /**
     * 用户验证码
     */
    public static final String VERIFYCODE_KEY = "BALANCE:WFX:CACHE:VERIFYCODE:";

    /**
     * 微信部分 用户token
     */
    public static final String WECHAT_USER_TOKEN = "BALANCE:WFX:CACHE:WECHAT_USER_TOKEN";

    /**
     * APP某类型图片状态码
     */
    public static final String STARTUPPAGE_CACHE_TYPE = "STARTUPPAGE:CACHE:TYPE:";

    /**
     * APP图片状态
     */
    public static final String STARTUPPAGE_STATE_TYPE = "STARTUPPAGE:STATE:TYPE:";


    /**
     * 代金券待自启动缓存redis
     */
    public static final String SELFSTART_VOUCHER_LIST = "SELFSTART:VOUCHER:LIST";


    /*
   * 首页直播预告
   * */
    public static final String HOME_PAGE_LIVE_TRAILER = "HOME_PAGE_LIVE_TRAILER";

    /*
      * 首页直播轮播图
      * */
    public static final String HOME_PAGE_LIVE_BANNER = "HOME_PAGE_LIVE_BANNER";
    /*
      * 首页侧部轮播图
      * */
    public static final String HOME_PAGE_LEFT_BANNER = "HOME_PAGE_LEFT_BANNER";
    /*APP推荐课程*/
    public static final String APP_COURSE_HAT = "APP_COURSE_HAT";
    /*
    * 首页直播列表的缓存（长度4）
    * */
    public static final String HOME_PAGE_LIVE_4 = "HOME_PAGE_LIVE_4";
    /*
    * 首页录播列表的缓存（长度4）
	* */
    public static final String HOME_PAGE_RECORD_4 = "HOME_PAGE_RECORD_4";
    /*
    * 首页面授列表的缓存（长度4）
	* */
    public static final String HOME_PAGE_FACE_4 = "HOME_PAGE_FACE_4";
    /*
    * 首页套餐列表的缓存（长度4）
	* */
    public static final String HOME_PAGE_PACKAGE_4 = "HOME_PAGE_PACKAGE_4";

    /*手机访问长度*/
    /*
       * 首页直播列表的缓存（长度15）
       * */
    public static final String HOME_PAGE_LIVE_15 = "HOME_PAGE_LIVE_15";
    /*
       * 首页录播列表的缓存（长度15）
       * */
    public static final String HOME_PAGE_RECORD_15 = "HOME_PAGE_RECORD_15";
    /*
    * 首页面授列表的缓存（长度15）
	* */
    public static final String HOME_PAGE_FACE_15 = "HOME_PAGE_FACE_15";
    /*
    * 首页套餐列表的缓存（长度15）
	* */
    public static final String HOME_PAGE_PACKAGE_15 = "HOME_PAGE_PACKAGE_15";


    /*网页访问长度*/
    /*
       * 首页直播列表的缓存（长度16）
       * */
    public static final String HOME_PAGE_LIVE_16 = "HOME_PAGE_LIVE_16";
    /*
       * 首页录播列表的缓存（长度16）
       * */
    public static final String HOME_PAGE_RECORD_16 = "HOME_PAGE_RECORD_16";

    /*
    * 首页面授列表的缓存（长度16）
	* */
    public static final String HOME_PAGE_FACE_16 = "HOME_PAGE_FACE_16";
    /*
    * 首页套餐列表的缓存（长度16）
	* */
    public static final String HOME_PAGE_PACKAGE_16 = "HOME_PAGE_PACKAGE_16";

    /**
     * APK最新版本信息
     */
    public static final String VERSION_APK_LATEST = "VERSION:APK:LATEST";

    /**
     * APK下载地址
     */
    public static final String VERSION_APK_ADDRESS = "VERSION:APK:ADDRESS:";
}
