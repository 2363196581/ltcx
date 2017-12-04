//package com.connxun.app.controller;
//
//
//import com.connxun.app.common.AppBaseController;
//import com.connxun.app.common.CodeEnum;
//import com.connxun.app.common.JsonEntity;
//import com.connxun.app.entity.CxUser;
//import com.connxun.app.entity.CxUser;
//import com.connxun.app.searchVO.CxUserSearchVO;
//import com.connxun.app.service.CxUserService;
//import com.connxun.util.code.SerialNumUtil;
//import com.connxun.util.config.PubConfig;
//import com.connxun.util.date.DateUtil;
//import com.connxun.util.redis.RedisUtil;
//import com.connxun.util.string.StringUtil;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.util.List;
//
//
///**
// * @Author：luoxiaosheng
// * @Date：2017-11-11 17:44
// * @Description：
// */
//@Controller
//@RequestMapping("jz/user")
//public class CxUserController extends AppBaseController {
//
//    @Autowired
//    private CxUserService CxUserService;
//    @Autowired
//    private PubConfig pubConfig;
//
//
//    //图片上传
//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    @ResponseBody
//    public JsonEntity upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse
//            response, ModelMap model) {
//        JsonEntity json = new JsonEntity();
//        String uploadPath = pubConfig.getImageUploadPath();
//        String storePath = "/proPic/" + DateUtil.getShortSystemDate() + "/";
//        String fileName = file.getOriginalFilename();
//        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
//        //        String fileName = new Date().getTime()+".jpg";
//        String createFilename = DateUtil.getShortSystemTime() + SerialNumUtil.createRandowmNum(6) + "." + suffix;
//        File targetFile = new File(uploadPath + storePath, createFilename);
//        if (!targetFile.exists()) {
//            targetFile.mkdirs();
//        }
//
//        if (file.getSize() > 1024 * 1024) {
//            json.setResultCode("1");
//            json.setMessage("文件大于1M");
//
//        } else {
//            //保存
//            try {
//                file.transferTo(targetFile);
////                json = "{success:" + true + ",msgText:'" + "成功" + "',createFilename:'" + createFilename + "',createFilepath:'" + storePath + "'}";
//
//                json.setResultCode("200");
//                json.setData(storePath + createFilename);
//                json.setMessage("上传成功");
//            } catch (Exception e) {
//                System.out.println(e.toString());
//                json.setResultCode("1");
//                json.setMessage("上传失败");
////                json = "{success:" + false + ",msgText:'" + "上传失败" + e.getMessage() + "'}";
//                e.printStackTrace();
//            }
//        }
//        return json;
//    }
//
//    @RequestMapping("/out")
//    @ResponseBody
//    public JsonEntity out(HttpServletRequest request, HttpServletResponse response, String userNo) {
////        RedisUtil.set(userNo, "000");
//
//        RedisUtil.del(userNo);
//
//        return booleanToJson(true);
//
//    }
//
//    //  获取用户自己的信息
//    @ApiOperation(value="用户获取自己的信息")
//    @RequestMapping(value="/info",method = RequestMethod.POST)
//    @ResponseBody
//    public JsonEntity info( @ApiParam(required = true, name = "userNo", value = "用户ID")String userNo) {
//
//        CxUser user = CxUserService.findOne(Integer.parseInt(userNo));
//        if (user != null) {
//            user.setPassword(null);
//        }
//        return objectToJson(user);
//
//    }
//
//
//    @ResponseBody
//    @RequestMapping("/friendInfo")
//    public JsonEntity friendInfo(int id) {
//        CxUser user = CxUserService.findOne(id);
//        if (user != null) {
//            user.setPassword(null);
//            user.setToken(null);
//        }
//        return objectToJson(user);
//
//    }
//
//    //用户搜索
//    @RequestMapping(value = "search")
//    @ResponseBody
//    public JsonEntity search(CxUserSearchVO search) {
//        List<CxUser> liveUsers = CxUserService.search(search);
//        return objectToJson(liveUsers);
//
//    }
//
//    //    修改基础信息
//    @ResponseBody
//    @RequestMapping(value = "update", method = RequestMethod.POST)
//    public JsonEntity updateDeclaration(CxUserSearchVO vo, Integer state) {
//        CxUser sysUser = CxUserService.findOne(vo.getUserNo());
//
//        if (sysUser != null) {
//
//            if (state == 1) {
//
//                sysUser.setDeclaration(vo.getDeclaration());
//            }
//            if (state == 2) {
//                sysUser.setNickName(vo.getNickName());
//
//            }
//            if (state == 3) {
//                sysUser.setSex(vo.getSex());
//            }
//            if (state == 4) {
//                sysUser.setIcon(vo.getIcon());
//            }
//
//
//            sysUser = CxUserService.save(sysUser);
//            if (sysUser != null) {
//                sysUser.setPassword(null);
//                json = objectToJson(sysUser);
//
//            } else {
//                json = booleanToJson(false);
//
//            }
//        } else {
//            json = ErrorCode(CodeEnum.USERISNOT);
//
//        }
//        return json;
//    }
//
//
//    //    修改基础信息
//    @ResponseBody
//    @RequestMapping(value = "updateInfo", method = RequestMethod.POST)
//    public JsonEntity updateInfo(CxUserSearchVO vo) {
//        CxUser sysUser = CxUserService.findOne(vo.getUserNo());
//
//        if (sysUser != null) {
//
//            if (StringUtil.isNotNullOrEmpty(vo.getDeclaration())) {
//
//                sysUser.setDeclaration(vo.getDeclaration());
//            }
//            if (StringUtil.isNotNullOrEmpty(vo.getNickName())) {
//                sysUser.setNickName(vo.getNickName());
//
//            }
//            if (vo.getSex() != null) {
//                sysUser.setSex(vo.getSex());
//            }
//            if (StringUtil.isNotNullOrEmpty(vo.getIcon())) {
//                sysUser.setIcon(vo.getIcon());
//            }
//
//            sysUser = CxUserService.save(sysUser);
//            if (sysUser != null) {
//                sysUser.setPassword(null);
//                json = objectToJson(sysUser);
//
//            } else {
//                json = booleanToJson(false);
//
//            }
//        } else {
//            json = ErrorCode(CodeEnum.USERISNOT);
//
//        }
//        return json;
//    }
//
//
//    //修改手机号
//    @ResponseBody
//    @RequestMapping(value = "updatePhone", method = RequestMethod.POST)
//    public JsonEntity updatePhone(CxUserSearchVO vo, String captch) {
//        CxUser sysUser = CxUserService.findOne(vo.getUserNo());
//
//        if (sysUser != null) {
//            String sysCaptch = RedisUtil.get(vo.getPhone() + "1");
//            System.out.println(sysCaptch);
//            if (!StringUtil.isNotNullOrEmpty(sysCaptch)) {
//                json = ErrorCode(CodeEnum.CAPTCHFAIL);
//            } else {
//                sysUser.setPhone(vo.getPhone());
//                sysUser = CxUserService.save(sysUser);
//                if (sysUser != null) {
//                    sysUser.setPassword(null);
//                    json = objectToJson(sysUser);
//
//                } else {
//                    json = booleanToJson(false);
//
//                }
//            }
//
//
//        } else {
//            json = ErrorCode(CodeEnum.USERISNOT);
//
//        }
//        return json;
//    }
////    修改密码
//
//    @ResponseBody
//    @RequestMapping(value = "updatePassword", method = RequestMethod.POST)
//    public JsonEntity updatePassword(String userNo, String password, String newPwd) {
//        CxUser sysUser = CxUserService.findOne(Integer.parseInt(userNo));
//
//        System.out.println(sysUser.getPassword());
//        System.out.println(sysUser.getPassword().equals(password));
//        if (sysUser != null && sysUser.getPassword().equals(password)) {
//            sysUser.setPassword(newPwd);
//
//            sysUser = CxUserService.save(sysUser);
//            if (sysUser != null) {
//                json = booleanToJson(true);
//
//            } else {
//                json = booleanToJson(false);
//
//            }
//        } else {
//            json = ErrorCode(CodeEnum.LOGINFAIL);
//
//        }
//        return json;
//    }
//
////    用户扫码登录
//
//    @ResponseBody
//    @RequestMapping(value = "/phoneCode", method = RequestMethod.POST)
//    public JsonEntity loginCode(CxUserSearchVO vo) {
//
//
//        CxUser CxUser = CxUserService.findOne(vo.getUserNo());
//        json = booleanToJson(false);
//        if (CxUser != null) {
//            String ret = RedisUtil.get(vo.getCode());
//            if (StringUtil.isNotNullOrEmpty(ret)) {
//                if (ret.equals(vo.getCodeUUID())) {
//                    RedisUtil.set(vo.getCode(), vo.getUserNo());
//                    String token = RedisUtil.get(vo.getUserNo() + "");
//                    RedisUtil.set(vo.getCode() + "_token", token);
//                    json = booleanToJson(true);
//
//
//                }
//
//            }
//
//
//        }
//        return json;
//
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "isLogin")
//    public JsonEntity isLogin() {
//        return booleanToJson(true);
//
//
//    }
//
//
//}
