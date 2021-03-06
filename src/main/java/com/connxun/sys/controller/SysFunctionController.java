package com.connxun.sys.controller;


import com.connxun.config.config.PubConfig;
import com.connxun.sys.model.SysFunction;
import com.connxun.sys.model.SysModule;
import com.connxun.sys.service.SysFunctionService;
import com.connxun.sys.service.SysModuleService;
import com.connxun.util.controller.BaseController;
import com.connxun.util.json.JsonUtil;
import com.connxun.util.web.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("portal/sys/function")
public class SysFunctionController extends BaseController {
    @Autowired
    private SysFunctionService sysFunctionService;
    @Autowired
    private SysModuleService sysModuleService;
    @Autowired
    private PubConfig pubConfig;

    /**
     * 功能设置列表
     */
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request, int module_id) {
        setBtnAutho(request, "SysModule");
        ModelAndView mv = new ModelAndView();
        List<SysFunction> functionList = sysFunctionService.list(module_id);
        mv.addObject("functionList", functionList);// 把获取的记录放到mv里面
        SysModule sysModule = sysModuleService.get(module_id);
        mv.addObject("sysModule", sysModule);
        String url = pubConfig.getDynamicServer() + "portal/sys/function/index.do?module_id=" + sysModule.getId();
        mv.setViewName("/sys/function");

        return mv;
    }

    /**
     * 新增功能列表
     */
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(int module_id) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("module_id", module_id);
        mv.setViewName("/sys/functionAdd");
        return mv;
    }

    /**
     * 修改功能列表
     */
    @RequestMapping("/toUpdate")
    public ModelAndView toUpdate(int id) {
        ModelAndView mv = new ModelAndView();
        SysFunction sysFunction = sysFunctionService.get(id);
        mv.addObject("sysFunction", sysFunction);
        mv.setViewName("/sys/functionUpdate");
        return mv;
    }

    @RequestMapping("/update")
    public String update(SysFunction sysFunction) {
        int flag = sysFunctionService.update(sysFunction);
        if (flag == 0)
            return "forward:/error.do";
        else
            return "redirect:/portal/sys/function/index.do";
    }

    @RequestMapping("/add")
    public String add(SysFunction sysFunction) {
        int flag = sysFunctionService.add(sysFunction);
        if (flag == 0)
            return "forward:/error.do";
        else
            return "redirect:/portal/sys/function/index.do";
    }

    /**
     * 删除模块
     */
    @RequestMapping("/delete")
    public String delete(int id) {
        int flag = sysFunctionService.delete(id);
        if (flag == 0)
            return "forward:/error.do";
        else
            return "redirect:/portal/sys/function/index.do";
    }

    /**
     * 操作 grid列表
     */
    @RequestMapping("/listJson")
    public void listJson(HttpServletResponse response, int module_id) {
        List<SysFunction> list = sysFunctionService.list(module_id);
        WebUtil.out(response, JsonUtil.toStr(list));
    }

    /**
     * 该角色对应的模块下功能列表
     */
    @RequestMapping("/listRoleModuleFunction")
    public void listRoleModuleFunction(HttpServletRequest request, HttpServletResponse response) {
        int role_id = WebUtil.getSafeInt(request.getParameter("role_id"));
        int module_id = WebUtil.getSafeInt(request.getParameter("module_id"));
        String json = JsonUtil.toStr(sysFunctionService.listRoleModuleFunction(role_id, module_id));
        WebUtil.out(response, json);
    }

}
