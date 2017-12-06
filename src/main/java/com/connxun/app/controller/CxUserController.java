package com.connxun.app.controller;

import com.connxun.app.common.AppBaseController;
import com.connxun.app.common.CodeEnum;
import com.connxun.app.common.JsonEntity;
import com.connxun.app.entity.CxUser;
import com.connxun.app.service.CxUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author anna
 * @Date 2017-11-16 15:46
 * @Description 用户模块
 */
@RestController
@RequestMapping(value = "api/user")
@Api(tags = {"User"},description = "用户相关操作", value = "用户相关操作")
public class CxUserController extends AppBaseController {

    private static Logger logger = LoggerFactory.getLogger("controllerLog");

    @Autowired
    private CxUserService cxUserService;

    /**
     * 用户基础信息
     *
     * @param userId 用户id
     * @param token  token
     * @return
     */
    @ApiOperation(value = "用户基础信息")
    @RequestMapping(value = "userInfo", method = RequestMethod.POST)
    public JsonEntity userInfo(
            @ApiParam(required = true, name = "userId", value = "用户id")
            @RequestParam(value = "userId", required = true) String userId,
            @ApiParam(required = true, name = "token", value = "token")
            @RequestParam(value = "token", required = true) String token) {
        CxUser user = cxUserService.findCxUserByUserid(userId);
        if (user != null) {
            json = objectToJson(user);
        } else {
            json = ErrorCode(CodeEnum.PARAMFAIL);
        }
        return json;
    }

    /**
     * 用户信息修改
     *
     * @param userId       用户id
     * @param token        token
     * @param name         姓名
     * @param phone        电话
     * @param identityCard 身份证号码
     * @param pic          用户头像
     * @param qq           QQ
     * @param email        邮箱
     * @param tel          固定电话
     * @return
     */
    @ApiOperation(value = "用户信息修改")
    @RequestMapping(value = "updateUserInfo", method = RequestMethod.POST)
    public JsonEntity updateUserInfo(
            @ApiParam(required = true, name = "userId", value = "用户id")
            @RequestParam(value = "userId", required = true) String userId,
            @ApiParam(required = true, name = "token", value = "token")
            @RequestParam(value = "token", required = true) String token,
            @ApiParam(required = true, name = "name", value = "姓名")
            @RequestParam(value = "name", required = true) String name,
            @ApiParam(required = true, name = "phone", value = "电话")
            @RequestParam(value = "phone", required = true) String phone,
            @ApiParam(required = true, name = "identityCard", value = "身份证号码")
            @RequestParam(value = "identityCard", required = true) String identityCard,
            @ApiParam(required = true, name = "pic", value = "用户头像")
            @RequestParam(value = "pic", required = true) String pic,
            @ApiParam(required = false, name = "qq", value = "QQ")
            @RequestParam(value = "qq", required = false) String qq,
            @ApiParam(required = false, name = "email", value = "邮箱")
            @RequestParam(value = "email", required = false) String email,
            @ApiParam(required = false, name = "tel", value = "固定电话")
            @RequestParam(value = "tel", required = false) String tel) {
        CxUser user = cxUserService.findCxUserByUserid(userId);
        if (user != null) {
            user.setName(name);
            user.setPhone(phone);
            user.setIdentitycard(identityCard);
            user.setHeadpic(pic);
            user.setQq(qq);
            user.setEmail(email);
            user.setTel(tel);
            user = cxUserService.save(user);
            if (user != null) {
                json = objectToJson(user);
            } else {
                json = ErrorCode(CodeEnum.FAIL);
            }

        } else {
            json = ErrorCode(CodeEnum.PARAMFAIL);
        }
        return json;
    }


    /**
     * 我的发布-当前用户发布的所有名片
     *
     * @param userId     用户id
     * @param token      token
     * @param city       当前城市
     * @param pageNumber 页码
     * @param pageSize   每页显示的记录数
     * @return
     */
    @ApiOperation(value = "我的发布")
    @RequestMapping(value = "myPublicCard", method = RequestMethod.POST)
    public JsonEntity loginCaptch(
            @ApiParam(required = true, name = "userId", value = "用户id")
            @RequestParam(value = "userId", required = true) String userId,
            @ApiParam(required = true, name = "token", value = "token")
            @RequestParam(value = "token", required = true) String token,
            @ApiParam(required = true, name = "city", value = "当前城市")
            @RequestParam(value = "city", required = true) String city,
            @ApiParam(required = true, name = "pageNumber", value = "页码")
            @RequestParam(value = "pageNumber", required = true) String pageNumber,
            @ApiParam(required = true, name = "pageSize", value = "每页显示的记录数")
            @RequestParam(value = "pageSize", required = true) String pageSize) {
        CxUser user = cxUserService.findCxUserByUserid(userId);
        if (user != null) {
            json = objectToJson(user);
        } else {
            json = ErrorCode(CodeEnum.PHONEFAIL);
        }
        return json;
    }


}
