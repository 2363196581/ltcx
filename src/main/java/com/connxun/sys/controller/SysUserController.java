package com.connxun.sys.controller;


import com.connxun.sys.model.SysUser;
import com.connxun.sys.model.SysUserLogin;
import com.connxun.sys.service.SysRoleService;
import com.connxun.sys.service.SysUserLoginService;
import com.connxun.sys.service.SysUserService;
import com.connxun.sys.vo.SysUserSearchVO;
import com.connxun.util.config.PubConfig;
import com.connxun.util.controller.BaseController;
import com.connxun.util.global.GlobalConst;
import com.connxun.util.json.JsonUtil;
import com.connxun.util.page.PageNavigate;
import com.connxun.util.session.SessionUtil;
import com.connxun.util.session.UserSession;
import com.connxun.util.string.StringUtil;
import com.connxun.util.web.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@RequestMapping("portal/sys/user")
@Controller
public class SysUserController extends BaseController {
    private final SysUserService sysUserService;
    private final SysUserLoginService sysUserLoginService;
    private final SysRoleService sysRoleService;
    private final PubConfig pubConfig;

    @Autowired
    public SysUserController(SysUserService sysUserService, SysUserLoginService sysUserLoginService,
                             SysRoleService sysRoleService, PubConfig pubConfig) {
        this.sysUserService = sysUserService;
        this.sysUserLoginService = sysUserLoginService;
        this.sysRoleService = sysRoleService;
        this.pubConfig = pubConfig;
    }

    /**
     * 进入用户维护界面
     *
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response, SysUserSearchVO sysUserSearchVO) {
        setBtnAutho(request, "SysUser");

        if (StringUtil.isNotNullOrEmpty(sysUserSearchVO.getRealname()))//如果为模糊查询或者中文，一定要decode
            sysUserSearchVO.setRealname(StringUtil.decodeUrl(sysUserSearchVO.getRealname()));
        ModelAndView mv = new ModelAndView();
        int recordCount = sysUserService.listCount(sysUserSearchVO);// 获取查询总数
        int pageIndex = WebUtil.getSafeInt(request.getParameter("pageIndex"), 1);// 获取当前页数
        int pageSize = GlobalConst.pageSize;// 直接取全局变量，每页记录数
        String url = createUrl(sysUserSearchVO, pageIndex, pageSize);
        PageNavigate pageNavigate = new PageNavigate(url, pageIndex, pageSize, recordCount);//
        List<SysUser> list = sysUserService.list(sysUserSearchVO, pageNavigate.getPageIndex(), pageSize);
        mv.addObject("pageNavigate", pageNavigate);// 设置分页的变量
        mv.addObject("list", list);// 把获取的记录放到mv里面
        mv.addObject("listRole", sysRoleService.list());// 角色列表
        mv.setViewName("/sys/user");// 跳转至指定页面
        return mv;
    }


    // 设置分页url，一般有查询条件的才会用到
    private String createUrl(SysUserSearchVO sysUserSearchVO, int pageIndex, int pageSize) {
        String url = pubConfig.getDynamicServer() + "portal/sys/user/index.do?";
        if (StringUtil.isNotNullOrEmpty(sysUserSearchVO.getUsername()))
            url += "&username=" + sysUserSearchVO.getUsername();
        if (StringUtil.isNotNullOrEmpty(sysUserSearchVO.getRealname()))//如果为模糊查询，要把该字段encode
            url += "&realname=" + StringUtil.encodeUrl(sysUserSearchVO.getRealname());
        if (sysUserSearchVO.getStatus() != null)
            url += "&status=" + sysUserSearchVO.getStatus();
        if (sysUserSearchVO.getRole_id() != null)
            url += "&role_id=" + sysUserSearchVO.getRole_id();
        return url;
    }

    /**
     * 进入添加用户界面
     */
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("listRole", sysRoleService.list());// 角色列表
        SysUser sysUser = new SysUser();
        mv.addObject("sysUser", sysUser);
        mv.setViewName("/sys/userAdd");
        return mv;
    }

    /**
     * 进入修改用户界面
     */
    @RequestMapping("/toUpdate")
    public ModelAndView toUpdate(HttpServletRequest request, HttpServletResponse response, int id) {
        ModelAndView mv = new ModelAndView();
        SysUser sysUser = sysUserService.get(id);
        mv.addObject("sysUser", sysUser);
        mv.addObject("listRole", sysRoleService.list());// 角色列表
        mv.setViewName("/sys/userUpdate");
        return mv;
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response, SysUser sysUser) {
        sysUser.setCreate_date(new Date());
        sysUser.setStatus(1);
        UserSession userSession = SessionUtil.getUserSession(request);
        assert userSession != null;
        sysUser.setCreate_person(userSession.getRealname());
        int flag = sysUserService.add(sysUser);
        if (flag == 0 || flag == 2)
            return "forward:/error.do";
        else
            return "redirect:/portal/sys/user/index.do";
    }

    @RequestMapping("/update")
    public String update(HttpServletRequest request, HttpServletResponse response, SysUser sysUser) {



        int flag = sysUserService.update(sysUser);
        if (flag == 0)
            return "forward:/error.do";
        else
            return "redirect:/portal/sys/user/index.do";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, HttpServletResponse response, int id) {
        int flag = sysUserService.delete(id);
        if (flag == 0)
            return "forward:/error.do";
        else
            return "redirect:/portal/sys/user/index.do";
    }

    /**
     * 重置密码
     */
    @RequestMapping("/saveResetPass")
    public String saveResetPass(int id) {
        int flag = sysUserService.saveResetPass(id);
        if (flag == 0)
            return "forward:/error.do";
        else
            return "redirect:/portal/sys/user/index.do";
    }

    /**
     * 用户加锁，状态由1变为0
     */
    @RequestMapping("/saveLock")
    public String saveLock(int id) {
        int flag = sysUserService.updateStatus(id, 2);
        if (flag == 0)
            return "forward:/error.do";
        else
            return "redirect:/portal/sys/user/index.do";
    }

    /**
     * 用户解锁，状态由2变为1
     *
     * @param id
     */
    @RequestMapping("/saveUnlock")
    public String saveUnlock(int id) {
        int flag = sysUserService.updateStatus(id, 1);
        if (flag == 0)
            return "forward:/error.do";
        else
            return "redirect:/portal/sys/user/index.do";
    }

    /**
     * 用户登录信息
     */
    @RequestMapping("/searchUserLogin")
    public ModelAndView searchUserLogin(HttpServletRequest request, int id) {
        ModelAndView mv = new ModelAndView();
        int recordCount = sysUserLoginService.listCount(id);// 获取查询总数
        int pageIndex = WebUtil.getSafeInt(request.getParameter("pageIndex"), 1);// 获取当前页数
        int pageSize = GlobalConst.pageSize;// 直接取全局变量，每页记录数
        String url = createUserLoginUrl(id, pageIndex, pageSize);
        PageNavigate pageNavigate = new PageNavigate(url, pageIndex, pageSize, recordCount);//
        List<SysUserLogin> list = sysUserLoginService.list(id, pageNavigate.getPageIndex(), pageSize);
        mv.addObject("pageNavigate", pageNavigate);// 设置分页的变量
        mv.addObject("list", list);// 把获取的记录放到mv里面
        mv.setViewName("/sys/userLogin");// 跳转至指定页面
        return mv;
    }

    // 设置分页url，一般有查询条件的才会用到
    private String createUserLoginUrl(int id, int pageIndex, int pageSize) {
        String url = pubConfig.getDynamicServer() + "portal/sys/user/searchUserLogin.do?id=" + id;
        return url;
    }

    /**
     * 验证用户代码是否存在
     */
    @RequestMapping("/checkUserExist")
    public void checkUserExist(HttpServletRequest request, HttpServletResponse response, String username) {
        SysUser sysUser = sysUserService.getByUsername(username);
        if (sysUser == null)
            WebUtil.out(response, "true");
        else
            WebUtil.out(response, "false");
    }

    @RequestMapping("getUsersByUsername")
    public void getUsersByUsername(String username, HttpServletResponse response) {
        List<SysUser> users = sysUserService.searchByUsername(username);
        WebUtil.out(response, JsonUtil.toStr(users));
    }

}
