package com.connxun.app.controller;

import com.connxun.app.common.AppBaseController;
import com.connxun.app.common.CodeEnum;
import com.connxun.app.common.JsonEntity;
import com.connxun.app.entity.CxUser;
import com.connxun.app.service.CxUserService;
import com.connxun.util.aliyun.sendsms.AliyunSms;
import com.connxun.util.redis.RedisUtil;
import com.connxun.util.string.StringUtil;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author anna
 * @Date 2017-11-10 17:12
 * @Description 账号模块 : 登录注册退出
 */

@RestController
@RequestMapping(value = "api/login")
@Api(tags = {"Login"},description = "登录注册退出", value = "登录注册退出")
public class CxLoginController extends AppBaseController {

    private static Logger logger = LoggerFactory.getLogger("controllerLog");

    @Autowired
    private CxUserService cxUserService;

    @PostMapping("login")
    @ApiOperation(value = "前端用户登录")
    public JsonEntity login(HttpServletRequest request, HttpServletResponse response,
                            @ApiParam(required = true, name = "phone", value = "手机号")
                            @RequestParam(value = "phone", required = true) String phone,
                            @ApiParam(required = true, name = "password", value = "密码")
                            @RequestParam(value = "password", required = true) String password) {
        if (StringUtil.isNullOrEmpty(phone) || StringUtil.isNullOrEmpty(password)) {
            logger.debug(phone + "参数错误");
            return booleanToJson(false, "参数错误");
        } else {
            CxUser user = cxUserService.findCxUserByPhone(phone);
//          手机号校验
            if (user != null) {
//            用户状态(需要验证)
                if (true) {
//                用户密码  ——已在android端加密  //StringUtil.getMD5(password)
                    if (user.getPassword().equals((password))) {
                        //更新用户登录状态
//                        cxUserService.updateLogin(user, request, isApp);
                        String ip = StringUtil.getIp(request);
                        user.setPassword(null);
                        //设置用户token
                        if (!RedisUtil.contain(user.getId() + "")) {
                            user.setToken(StringUtil.getNonceStr());
                            RedisUtil.set(user.getId() + "", user.getToken());
                        } else {
                            user.setToken(RedisUtil.get(user.getId() + ""));
                        }
//                        request.getSession().setAttribute("userSession", user);
                        return objectToJson(user);
                    } else {
                        return ErrorCode(CodeEnum.LOGINFAIL);
                    }
                } else {
                    return ErrorCode(CodeEnum.AUDITFAIL);
                }
            } else {
                return ErrorCode(CodeEnum.PHONEFAIL);
            }
        }

    }

    /**
     * 手机验证码登录接口
     *
     * @param phone  手机号
     * @param captch 验证码
     * @return
     */
    @ApiOperation(value = "手机验证码登录接口")
    @PostMapping("loginCaptch")
    public JsonEntity loginCaptch(
            @ApiParam(required = true, name = "phone", value = "手机号")
            @RequestParam(value = "phone", required = true) String phone,
            @ApiParam(required = true, name = "captch", value = "验证码")
            @RequestParam(value = "captch", required = true) String captch) {

        CxUser user = cxUserService.findCxUserByPhone(phone);
        if (user != null) {
            String sysCaptch = RedisUtil.get(phone + "3");
            if (sysCaptch.equals(captch)) {
                json = objectToJson(user);
                RedisUtil.del(phone + "3");
            } else {
                json = ErrorCode(CodeEnum.CAPTCHFAIL);
            }
        } else {
            json = ErrorCode(CodeEnum.PHONEFAIL);
        }
        return json;
    }

    // TODO: 2017-11-17 第三方登录鉴权

    /**
     * qq 微信 新浪微博进行登录接口
     *
     * @param uid    第三方登录的唯一标识
     * @param type   第三方登录的方式 0 QQ 1 微信 2 新浪微博
     * @param qwsPic 第三方登录的头像
     * @return
     */
    @ApiOperation(value = "qq 微信 新浪微博进行登录接口")
    @PostMapping(value = "qws")
    @ApiResponses(@ApiResponse(code = 110, message = "登录成功，请完善个人信息"))
    public JsonEntity openLogin(@ApiParam(required = true, name = "uid", value = "第三方登录的唯一标识")
                                @RequestParam(value = "uid", required = true) String uid,
                                @ApiParam(required = true, name = "type", value = "第三方登录的方式 0 QQ 1 微信 2 新浪微博")
                                @RequestParam(value = "type", required = true) String type,
                                @ApiParam(required = true, name = "qwsPic", value = "第三方登录的头像")
                                @RequestParam(value = "qwsPic", required = true) String qwsPic) {
//        CxUser user = cxUserService.findCxUserByUserid(uid);

        CxUser user = cxUserService.findCxUserByQqidWOrWxidOrSinaid(
                "0".equals(type) ? uid : null, "1".equals(type) ? uid : null, "2".equals(type) ? uid : null);
        if (user != null) {
            user.setPassword(null);
            //设置用户token
            if (!RedisUtil.contain(user.getId() + "")) {
                user.setToken(StringUtil.getNonceStr());
                RedisUtil.set(user.getId() + "", user.getToken());
            } else {
                user.setToken(RedisUtil.get(user.getId() + ""));
            }
            return objectToJson(user);
        } else {
            //第三方第一次登录
            //判断用户类型
            user = new CxUser();
            if ("0".equals(type)) {
                user.setQqid(uid);
            } else if ("1".equals(type)) {
                user.setWxid(uid);
            } else if ("2".equals(type)) {
                user.setSinaid(uid);
            } else {
                return json = ErrorCode(CodeEnum.PARAMFAIL);
            }
//            user.setUserid(StringUtil.genSixteenUUId());
            user.setType(type);
            user.setQwspic(qwsPic);
            user.setToken(StringUtil.getNonceStr());
            RedisUtil.set(user.getId() + "", user.getToken());

            //第三方第一次登录 返回码110——完善个人信息
            json = ErrorCode(CodeEnum.OPENLOGIN);
            json.setData(user);
            return json;
        }

    }

    // TODO: 2017-11-16 第三方完善信息需要加上token鉴权

    /**
     * 选择第三方进行登录完善信息
     *
     * @param uid      第三方登录的唯一标识
     * @param phone    手机号
     * @param type     第三方登录的方式 0 QQ 1 微信 2 新浪微博
     * @param qwsPic   头像
     * @param password 密码
     * @param gender   性别 0男 1女
     * @return
     */
    @ApiOperation(value = "选择第三方进行登录完善信息")
    @PostMapping(value = "qwsRegister")
    public JsonEntity openRegister(@ApiParam(required = true, name = "uid", value = "第三方登录的唯一标识")
                                   @RequestParam(value = "uid", required = true) String uid,
                                   @ApiParam(required = true, name = "type", value = "第三方登录的方式 0 QQ 1 微信 2 新浪微博")
                                   @RequestParam(value = "type", required = true) String type,
                                   @ApiParam(required = true, name = "phone", value = "手机号")
                                   @RequestParam(value = "phone", required = true) String phone,
                                   @ApiParam(required = true, name = "qwsPic", value = "头像")
                                   @RequestParam(value = "qwsPic", required = true) String qwsPic,
                                   @ApiParam(required = true, name = "password", value = "密码")
                                   @RequestParam(value = "password", required = true) String password,
                                   @ApiParam(required = true, name = "gender", value = "性别 0男 1女")
                                   @RequestParam(value = "gender", required = true) String gender) {
//        CxUser user = cxUserService.findCxUserByUserid(uid);
        CxUser user = cxUserService.findCxUserByPhone(phone);
        if (user != null) {
            // 手机号码存在，绑定此第三方标识到该手机号
            if ("0".equals(type)) {
                user.setQqid(uid);
            } else if ("1".equals(type)) {
                user.setWxid(uid);
            } else if ("2".equals(type)) {
                user.setSinaid(uid);
            } else {
                return json = ErrorCode(CodeEnum.PARAMFAIL);
            }
            user = cxUserService.save(user);
            return objectToJson(user);
        } else {
            user.setUserid(StringUtil.genSixteenUUId());
            user.setPhone(phone);
            user.setType(type);
            user.setHeadpic(qwsPic);
            user.setPassword(password);
            user.setSex(gender);
            //非从第三方登录后过来——重新设置用户token
            if (!RedisUtil.contain(user.getId() + "")) {
                user.setToken(StringUtil.getNonceStr());
                RedisUtil.set(user.getId() + "", user.getToken());
            } else {
                user.setToken(RedisUtil.get(user.getId() + ""));
            }
            user = cxUserService.save(user);
            user.setPassword(null);
            return objectToJson(user);
        }

    }

    /**
     * 获取验证码
     *
     * @param phone
     * @param state 1 注册验证码   2 修改密码验证码  3 直接登录
     * @return
     */
    @ApiOperation(value = "验证码获取接口", notes = "验证码获取接口")
    @PostMapping(value = "getCaptch")
    public JsonEntity recaptch(@ApiParam(required = true, name = "phone", value = "手机号")
                               @RequestParam(value = "phone", required = true) String phone,
                               @ApiParam(required = true, name = "state", value = "1 注册验证码   2 修改密码验证码  3 直接登录")
                               @RequestParam(value = "state", required = true) int state) {
        CxUser user = cxUserService.findCxUserByPhone(phone);
        json = ErrorCode(CodeEnum.FAIL);
        if (state == 1) {
            if (user != null) {
                json = ErrorCode(CodeEnum.PHONEREPEAT);
            } else {
                for (int i = 0; i < 10; i++) {
                    String captcher = StringUtil.buildRandom(6) + "";
                    AliyunSms.sendSms(phone, captcher);
                    RedisUtil.set(phone + "1", captcher);
                    json = objectToJson(captcher);
                }
            }
        }
        if (state == 2) {
            if (user == null) {
                json = ErrorCode(CodeEnum.PHONEFAIL);
            } else {
                String captcher = StringUtil.buildRandom(6) + "";
                AliyunSms.sendSms(phone, captcher);
                RedisUtil.set(phone + "2", captcher);
                json = objectToJson(captcher);
            }
        }
        if (state == 3) {
            if (user == null) {
                json = ErrorCode(CodeEnum.PHONEFAIL);
            } else {
                String captcher = StringUtil.buildRandom(6) + "";
                AliyunSms.sendSms(phone, captcher);

                RedisUtil.set(phone + "3", captcher);
                json = objectToJson(captcher);
            }
        }
        return json;
    }


    //注册
    @ApiOperation(value = "用户注册接口")
    @PostMapping(value = "reg")
    public JsonEntity reg(HttpServletRequest request, HttpServletResponse response,
                          @ApiParam(required = true, name = "phone", value = "手机号")
                          @RequestParam(value = "phone", required = true) String phone,
                          @ApiParam(required = true, name = "password", value = "密码")
                          @RequestParam(value = "password", required = true) String password,
                          @ApiParam(required = true, name = "captch", value = "验证码")
                          @RequestParam(value = "captch", required = true) String captch) {
        if (StringUtil.isNotNullOrEmpty(password) && StringUtil.isNotNullOrEmpty(phone)) {
            String sysCaptch = RedisUtil.get(phone + "1");
            if (!StringUtil.isNotNullOrEmpty(sysCaptch)) {
                json = ErrorCode(CodeEnum.FAIL);
            } else {
                if (sysCaptch.equals(captch)) {
                    CxUser user = new CxUser();
                    user.setUserid(StringUtil.genSixteenUUId());
                    user.setPhone(phone);
                    user.setPassword(StringUtil.getMD5(password));
                    user.setName(StringUtil.getNonceStr());
                    user.setHeadpic("/proPic/20170730/20170730102138563982.jpg");
//                    user.setInviteCode();
                    user = cxUserService.save(user);
                    if (user != null) {
//                        推送消息
                        user.setToken(StringUtil.getNonceStr());
                        /*清空redis中的验证码————保证每个验证码只能被使用一次*/
                        RedisUtil.del(phone + "1");
                        /*保存用户登录token*/
                        RedisUtil.set(user.getId() + "", user.getToken());
                        json = objectToJson(user);
                    }
                } else {
                    json = ErrorCode(CodeEnum.CAPTCHFAIL);
                }
            }
        } else {
            json = ErrorCode(CodeEnum.FAIL);
        }
        return json;
    }

    /**
     * 用户修改密码接口
     *
     * @param request
     * @param response
     * @param phone    手机号
     * @param password 新密码
     * @param captch   验证码
     * @return
     */
    @ApiOperation(value = "用户修改密码接口",notes = "用户修改密码接口")
    @PostMapping(value = "updatePwd")
    public JsonEntity updatePwd(HttpServletRequest request, HttpServletResponse response,
                                @ApiParam(required = true, name = "phone", value = "手机号")
                                @RequestParam(value = "phone", required = true) String phone,
                                @ApiParam(required = true, name = "password", value = "新密码")
                                @RequestParam(value = "password", required = true) String password,
                                @ApiParam(required = true, name = "captch", value = "验证码")
                                @RequestParam(value = "captch", required = true) String captch) {
        if (StringUtil.isNotNullOrEmpty(password) && StringUtil.isNotNullOrEmpty(phone)) {
            String sysCaptch = RedisUtil.get(phone + "2");
            CxUser user = cxUserService.findCxUserByPhone(phone);
            if (sysCaptch.equals(captch) && user != null) {
                user.setPassword(password);
                user = cxUserService.save(user);
                if (user != null) {
                    user.setPassword(null);
                    user.setToken(StringUtil.getNonceStr());
                    RedisUtil.del(phone + "2");
                    RedisUtil.set(user.getId() + "", user.getToken());

                    json = objectToJson(user);
                } else {
                    json = ErrorCode(CodeEnum.FAIL);
                }
            } else {
                json = ErrorCode(CodeEnum.CAPTCHFAIL);
            }
        } else {
            json = ErrorCode(CodeEnum.FAIL);
        }
        return json;

    }

    /**
     * 用户注销登出接口
     *
     * @return
     */
    @ApiOperation(value = "用户注销登出接口", notes = "用户注销登出接口")
    @PostMapping(value = "logout")
    public JsonEntity logout(@ApiParam(required = true, name = "userId", value = "用户ID")
                             @RequestParam(value = "userId", required = true) String userId) {
        if (StringUtil.isNotNullOrEmpty(userId)) {
            if (!RedisUtil.contain(userId)) {
                RedisUtil.del(userId);
            }
            return booleanToJson(true);
        } else {
            json = ErrorCode(CodeEnum.PARAMFAIL);
        }
        return json;
    }


}
