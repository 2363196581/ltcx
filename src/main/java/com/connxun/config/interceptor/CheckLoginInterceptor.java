package com.connxun.config.interceptor;


import com.connxun.util.json.JsonUtil;
import com.connxun.util.session.SessionUtil;
import com.connxun.util.session.UserSession;
import com.connxun.util.string.StringUtil;
import com.connxun.util.web.WebUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 功能描述:校验是否登录拦截器
 *
 * @author 高宇飞
 * @version 1.0.0
 */
public class CheckLoginInterceptor implements HandlerInterceptor {

    /**
     * 操作前先判断是否登录，未登录跳转到登录界面
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserSession userSession = SessionUtil.getUserSession(request);
        if (userSession == null) {
            boolean isAjaxRequest = StringUtil.checkAjaxRequest(request);
            if (isAjaxRequest) {
                Message msg = new Message();
                msg.setSuccess(false);
                msg.setExName("错误提示");
                msg.setMsgText("连接超时，请重新登录");
                msg.setIsSessionOut(true);
                WebUtil.out(response, JsonUtil.toStr(msg));
            } else {
                String str = "<script>top.location.href='" + request.getContextPath() + "/portal/login'</script>";
                WebUtil.out(response, str);
            }
            return false;
        } else {
            return true;
        }

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}
