package com.connxun.cms.controller;


import com.connxun.app.common.BasePage;
import com.connxun.app.entity.CxCard;
import com.connxun.app.entity.CxUser;
import com.connxun.app.searchVO.CxUserSearchVO;
import com.connxun.app.service.CxCardService;
import com.connxun.app.service.CxUserService;
import com.connxun.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mac on 2017/6/26.
 */
@Controller
@RequestMapping("cms/user")
public class CmsCxUserController extends BaseController {

    @Autowired
    private CxUserService cxUserService;
    @Autowired
    private CxCardService cxCardService;

    /**
     * 进入index页面
     * @return
     */
    @RequestMapping(value = {"", "index"})
    public ModelAndView index() {
        return new ModelAndView("/cms/user/index");
    }

    /**
     * 给datatables返回数据，按照格式   详情看http://datatables.club/manual/server-side.html
     *
     * @param searchVO 查询VO
     */
    @RequestMapping(value = "getList", method = RequestMethod.GET)
    @ResponseBody
    public Page<CxUser> getList(CxUserSearchVO searchVO) {
//        BasePage page =new BasePage(CxUserService.findAll(searchVO));
//        CxUser cxUse1r= cxUserService.findOne(1);
        BasePage page =new BasePage(cxUserService.getList(searchVO));
//        DataTablesResult result = new DataTablesResult();
//        List<JzUser> list = CxUserService.findAll(searchVO);
//        result.setDraw(searchVO.getDraw());//每个字段在实体中都有注释
//        result.setRecordsFiltered(searchVO.getTotal());//每个字段在实体中都有注释
//        result.setRecordsTotal(searchVO.getTotal());//每个字段在实体中都有注释
//        result.setData(list);//每个字段在实体中都有注释


//        List<CxCard> cards=new ArrayList<CxCard>();
//        cards=cxCardService.findAll();

        List<CxUser> list=new ArrayList<CxUser>();
        CxCard cxCard=new CxCard();
        list=page.getContent();
        for (CxUser cxUser:list){
            if (cxUser.getUserid()=="3"||cxUser.getUserid()=="2"){
                System.out.println("____");
//                cxCard=cxUser.getCxCard();
            }
        }
        return page;
    }
//
//    /**
//     * 给datatables返回数据，按照格式   详情看http://datatables.club/manual/server-side.html
//     *
//     * @param searchVO 查询VO
//     */
//    @RequestMapping(value = "getList", method = RequestMethod.GET)
//    @ResponseBody
//    public DataTablesResult getList(JzUserSearchVO searchVO) {
//        DataTablesResult result = new DataTablesResult();
//        List<JzUser> list = CxUserService.findAll(searchVO);
//        result.setDraw(searchVO.getDraw());//每个字段在实体中都有注释
//        result.setRecordsFiltered(searchVO.getTotal());//每个字段在实体中都有注释
//        result.setRecordsTotal(searchVO.getTotal());//每个字段在实体中都有注释
//        result.setData(list);//每个字段在实体中都有注释
//        return result;
//    }

    /**
     * 新增/修改
     *
     * @param
     */
//    @RequestMapping(value = "save", method = RequestMethod.POST)
//    public ModelAndView save(JzUser JzUser) {
//        int user_id = getCurrentUser().getUser_id();//调用父类的方法获取当前用户session
//        if (StringUtil.isNullOrEmpty(JzUser.getId() + "")) {
//            JzUser.setCreateUser(user_id);//如果第一次数据，没有id  曾新增一个创建人
//        }
//        JzUser.setUpdateUser(user_id);
//        JzUser.setPassword(StringUtil.MD5(StringUtil.MD5(JzUser.getPassword())));
//        JzUser.setIcon("/proPic/20170730/20170730102138563982.jpg");
//        JzUserService.save(JzUser);
//        return new ModelAndView("/cms/user/index");
//    }
//
//    /**
//     * 新增/修改
//     *
//     * @param
//     */
//    @RequestMapping(value = "update", method = RequestMethod.POST)
//    public ModelAndView update(JzUser JzUser) {
//        int user_id = getCurrentUser().getUser_id();//调用父类的方法获取当前用户session
//        if (StringUtil.isNullOrEmpty(JzUser.getId() + "")) {
//            JzUser.setCreateUser(user_id);//如果第一次数据，没有id  曾新增一个创建人
//        }
//        JzUser.setUpdateUser(user_id);
//
//        if (StringUtil.isNotNullOrEmpty(JzUser.getNewPwd())) {
//            JzUser.setPassword(StringUtil.MD5(StringUtil.MD5(JzUser.getNewPwd())));
//        }
//
//        JzUserService.save(JzUser);
//        return new ModelAndView("/cms/user/index");
//    }
//
//    /**
//     * 跳转用户添加界面
//     * @return
//     */
//    @RequestMapping(value = "toAdd", method = RequestMethod.GET)
//    @ResponseBody
//    public ModelAndView toAdd() {
//        return new ModelAndView("/cms/user/add");
//    }
//
//
//    /**
//     * 根据ID查询对象
//     *
//     * @param id 用户ID
//     */
//    @RequestMapping(value = "toUpdate", method = RequestMethod.GET)
//    @ResponseBody
//    public ModelAndView toUpdate(Integer id) {
//        ModelAndView mv = new ModelAndView("/cms/user/update");
//        JzUser JzUser = JzUserService.findOne(id);
//        mv.addObject("user", JzUser);
//        return mv;
//    }
//
//
//    /**
//     * 根据ID查询对象
//     *
//     * @param id 用户ID
//     */
//    @RequestMapping(value = "findOne", method = RequestMethod.GET)
//    @ResponseBody
//    public JzUser findOne(int id) {
//        JzUser l = JzUserService.findOne(id);
//        l.setPassword(null);
//        return l;
//    }
//
//    /**
//     * 根据id删除对象
//     *
//     * @param id 部门id
//     */
//    @RequestMapping(value = "delete", method = RequestMethod.GET)
//    @ResponseBody
//    public void delete(int id) {
//        cxUserService.delete(id);
//    }
//
//    /**
//     * 查询所有
//     */
//    @RequestMapping(value = "findAll", method = RequestMethod.GET)
//    @ResponseBody
//    public List<JzUser> findAll() {
//
//        return JzUserService.findAll();
//    }
//
//    /**
//     * 冻结
//     */
//    @RequestMapping(value = "updateState")
//    @ResponseBody
//    public void updateState(Integer id, Integer state) {
//        JzUserService.updateState(id, state);
//
//    }
//
//    /**
//     * 验证用户手机是否存在
//     */
//    @RequestMapping("/isPhone")
//    public void isPhone(HttpServletRequest request, HttpServletResponse response, String phone) {
//        JzUser JzUser = JzUserService.getPhone(phone);
//        if (JzUser == null)
//            WebUtil.out(response, "true");
//        else
//            WebUtil.out(response, "false");
//    }
//
//
//    /**
//     * 导入
//     */
//    @RequestMapping(value = "import", method = RequestMethod.POST)
//    @ResponseBody
//    public ResponseEntity<JsonResult> importDepartment(MultipartFile excel_file) {
//        if (excel_file == null || excel_file.isEmpty()) {
//            return new ResponseEntity<>(new JsonResult(false, "上传失败!"), HttpStatus.BAD_REQUEST);
//        }
//        try {
//            String fileName = excel_file.getOriginalFilename();
//            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
//            List<ErrorImportVO> errorImportVOS = new ArrayList<>();
//
//            switch (suffix) {
//                case "xls": {
//                    HSSFWorkbook subjectWb = new HSSFWorkbook(excel_file.getInputStream());
//                    if (subjectWb.getNumberOfSheets() > 0) {
//
//                        HSSFSheet firstSheet = subjectWb.getSheetAt(0);
//                        if (firstSheet == null || firstSheet.getLastRowNum() < 1)
//                            return new ResponseEntity<>(new JsonResult(false, "没有找到上传数据!"), HttpStatus.BAD_REQUEST);
//                        List<JzUser> JzUserList = new ArrayList<>();
//                        int lastRowNum = firstSheet.getLastRowNum();
//                        for (int rowIndex = 1; rowIndex <= lastRowNum; rowIndex++) {
//                            HSSFRow hssfRow = firstSheet.getRow(rowIndex);
//                            if (hssfRow == null) {
//                                continue;
//                            }
//
//                            String phone = Excel2003Util.getCellStringValue(hssfRow, 0);
//                            String nickName = Excel2003Util.getCellStringValue(hssfRow, 1);
//                            String password = Excel2003Util.getCellStringValue(hssfRow, 2);
//                            String sexS = Excel2003Util.getCellStringValue(hssfRow, 3);
//                            Integer sex = 1;
//                            if (StringUtil.isNotNullOrEmpty(sexS)) {
//                                if (sex.equals("男")) {
//                                    sex = 1;
//                                }
//                                if (sex.equals("女")) {
//
//                                    sex = 2;
//
//                                }
//                            }
//                            String declaration = Excel2003Util.getCellStringValue(hssfRow, 4);
//                            String integralS = Excel2003Util.getCellStringValue(hssfRow, 5);
//                            int integral = 0;
//                            if (StringUtil.isNotNullOrEmpty(integralS) && StringUtil.isInteger(integralS)) {
//                                integral = Integer.parseInt(integralS);
//                            }
//                            String createDateS = Excel2003Util.getCellStringValue(hssfRow, 6);
//                            Date createDate = new Date();
//                            if (StringUtil.isNotNullOrEmpty(createDateS)) {
//
//                                createDate = DateUtil.stringToDate(createDateS, "yyyy-MM-dd");
//                            }
//                            String loginDateS = Excel2003Util.getCellStringValue(hssfRow, 7);
//                            Date loginDate = new Date();
//                            if (StringUtil.isNotNullOrEmpty(loginDateS)) {
//
//                                loginDate = DateUtil.stringToDate(loginDateS, "yyyy-MM-dd");
//                            }
//                            String loginIp = Excel2003Util.getCellStringValue(hssfRow, 8);
//
//                            if (check_params(phone, password)) {
//                                ErrorImportVO errorImportVO = new ErrorImportVO();
//                                errorImportVO.setRowIndex(rowIndex);
//                                errorImportVO.setReason("导入失败，有空单元格");
//                                errorImportVOS.add(errorImportVO);
//                            } else if (check_repeat_params(JzUserList, phone)) {
//                                ErrorImportVO errorImportVO = new ErrorImportVO();
//                                errorImportVO.setRowIndex(rowIndex);
//                                errorImportVO.setReason("行导入失败，编号重复");
//                                errorImportVOS.add(errorImportVO);
//                            } else {
//                                JzUser JzUser = getImport(phone, nickName, password, sex, declaration, integral, createDate
//                                        , loginDate, loginIp, rowIndex);
//                                JzUserList.add(JzUser);
//                            }
//                        }
//                        saveForImport(JzUserList);
//                        return ResponseEntity.ok(new JsonResult(true, "导入成功", errorImportVOS));
//                    }
//                    break;
//                }
//                case "xlsx": {
//                    XSSFWorkbook subjectWb = new XSSFWorkbook(excel_file.getInputStream());
//                    if (subjectWb.getNumberOfSheets() > 0) {
//                        XSSFSheet firstSheet = subjectWb.getSheetAt(0);
//                        if (firstSheet == null || firstSheet.getLastRowNum() < 1)
//                            return new ResponseEntity<>(new JsonResult(false, "没有找到上传数据!"), HttpStatus.BAD_REQUEST);
//                        List<JzUser> JzUserList = new ArrayList<>();
//                        int lastRowNum = firstSheet.getLastRowNum();
//                        for (int rowIndex = 1; rowIndex <= lastRowNum; rowIndex++) {
//                            XSSFRow xssfRow = firstSheet.getRow(rowIndex);
//                            if (xssfRow == null) {
//                                continue;
//                            }
//                            String phone = Excel2007Util.getCellStringValue(xssfRow, 0);
//                            String nickName = Excel2007Util.getCellStringValue(xssfRow, 1);
//                            String password = Excel2007Util.getCellStringValue(xssfRow, 2);
//                            String sexS = Excel2007Util.getCellStringValue(xssfRow, 3);
//                            Integer sex = 1;
//                            if (StringUtil.isNotNullOrEmpty(sexS)) {
//                                if (sex.equals("男")) {
//                                    sex = 1;
//                                }
//                                if (sex.equals("女")) {
//
//                                    sex = 2;
//
//                                }
//                            }
//                            String declaration = Excel2007Util.getCellStringValue(xssfRow, 4);
//                            String integralS = Excel2007Util.getCellStringValue(xssfRow, 5);
//                            System.out.println("integralS = " + integralS);
//                            int integral = 0;
//                            if (StringUtil.isNotNullOrEmpty(integralS) && StringUtil.isInteger(integralS)) {
//                                integral = Integer.parseInt(integralS);
//
//                            } else {
//                                integral = 0;
//                            }
//                            String createDateS = Excel2007Util.getCellStringValue(xssfRow, 6);
//                            Date createDate = new Date();
//                            if (StringUtil.isNotNullOrEmpty(createDateS)) {
//
//                                createDate = DateUtil.stringToDate(createDateS, "yyyy-MM-dd");
//                            }
//                            String loginDateS = Excel2007Util.getCellStringValue(xssfRow, 7);
//                            Date loginDate = new Date();
//                            if (StringUtil.isNotNullOrEmpty(loginDateS)) {
//
//                                loginDate = DateUtil.stringToDate(loginDateS, "yyyy-MM-dd");
//                            }
//                            String loginIp = Excel2007Util.getCellStringValue(xssfRow, 8);
//
//                            if (check_params(phone, password)) {
//                                ErrorImportVO errorImportVO = new ErrorImportVO();
//                                errorImportVO.setReason("第" + rowIndex + "行导入失败，有空单元格");
//                                errorImportVOS.add(errorImportVO);
//                            } else if (check_repeat_params(JzUserList, phone)) {
//                                ErrorImportVO errorImportVO = new ErrorImportVO();
//                                errorImportVO.setReason("第" + rowIndex + "行导入失败，编号重复");
//                                errorImportVOS.add(errorImportVO);
//                            } else {
//                                JzUser JzUser = getImport(phone, nickName, password, sex, declaration, integral, createDate
//                                        , loginDate, loginIp, rowIndex);
//                                JzUserList.add(JzUser);
//                            }
//                        }
//                        saveForImport(JzUserList);
//                        return ResponseEntity.ok(new JsonResult(true, "导入成功", errorImportVOS));
//                    }
//                    break;
//                }
//                default:
//                    return ResponseEntity.ok(new JsonResult(true, "导入成功", errorImportVOS));
//            }
//
//        } catch (NullPointerException ignored) {
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>(new JsonResult(false, "处理失败!"), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//
//    private boolean check_params(String phone, String password) {
//        return (StringUtils.isEmpty(phone) || StringUtils.isEmpty(password));
//    }
//
//    private boolean check_repeat_params(List<JzUser> list, String phone) {
//        List<JzUser> JzUserList = JzUserService.findAll();
//        if (list.size() == 0) {
//            for (JzUser JzUser : JzUserList) {
//                if (Objects.equals(JzUser.getPhone(), phone)) {
//                    return true;
//                }
//            }
//            return false;
//        } else {
//            for (JzUser JzUser : list) {
//                if (Objects.equals(JzUser.getPhone(), phone)) {
//                    for (JzUser JzUsers : JzUserList) {
//                        if (Objects.equals(JzUsers.getPhone(), phone)) {
//                                return true;
//                        }
//                    }
//                }
//            }
//            return false;
//        }
//    }
//
//    private JzUser getImport(String phone, String nickName, String password, Integer sex, String declaration, int integral, Date createDate, Date
//            loginDate, String loginIp, int rowIndex) {
//        JzUser JzUser = new JzUser();
//        JzUser.setPhone(phone);
//        JzUser.setPassword(password);
//        JzUser.setNickName(nickName);
//        JzUser.setSex(sex);
//        JzUser.setDeclaration(declaration);
//        JzUser.setIntegral(integral);
//        JzUser.setCreateDate(createDate);
//        JzUser.setLoginIp(loginIp);
//        JzUser.setLoginDate(loginDate);
//        JzUser.setCreateUser(getCurrentUser().getUser_id());
//        JzUser.setUpdateUser(getCurrentUser().getUser_id());
//        JzUser.setRow_index(rowIndex);
//        return JzUser;
//    }
//
//    /**
//     * 导入数据
//     *
//     * @param JzUserList 导入数据List
//     * @return 带有错误原因VO的list
//     */
//    private List<JzUser> saveForImport(List<JzUser> JzUserList) {
//        //todo 如果数据重复暂时不做处理
//        return IterableUtils.toList(JzUserService.save(JzUserList));
//    }


}
