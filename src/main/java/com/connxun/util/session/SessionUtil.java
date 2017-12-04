package com.connxun.util.session;

import com.connxun.util.redis.RedisKeyUtil;
import com.connxun.util.redis.RedisUtil;
import com.connxun.util.string.StringUtil;

import javax.servlet.http.HttpServletRequest;


public class SessionUtil {
	/**
	 * 
	 * 功能描述:获取用户session
	 * 
	 * @return UserSession
	 * @author 高宇飞
	 */
	public static UserSession getUserSession(HttpServletRequest request) {
		if (request.getSession().getAttribute("userSession") != null)
			return (UserSession) request.getSession().getAttribute("userSession");
		else {
			return null;
		}
	}


	/**
	 * 获取token
	 * 微信使用
	 * @param request
	 * @return
	 */
	public static String getToken(HttpServletRequest request) {
		String token = request.getParameter("token");
		if (StringUtil.isNotNullOrEmpty(token)) {
			return token;
		} else {
			return "";
		}
	}

	/**
	 * 根据token获取当前用户信息
	 * 用户的信息都保留在redis中，其中参数传递通过token，而不是通过session
	 */
	public static WechatSession getWechatSession(String token) {
		if (StringUtil.isNotNullOrEmpty(token)) {
			return RedisUtil.get(RedisKeyUtil.WECHAT_USER_TOKEN + "-" + token);
		} else {
			return null;
		}
	}

	/**
	 * 根据token获取当前用户信息
	 * 用户的信息都保留在redis中，其中参数传递通过token，而不是通过session
	 * @param request
	 * @return
	 */
	public static WechatSession getWechatSession(HttpServletRequest request) {
		String token = getToken(request);
		if (StringUtil.isNotNullOrEmpty(token)) {
			return RedisUtil.get(RedisKeyUtil.WECHAT_USER_TOKEN + "-" + token);
		} else {
			return null;
		}
	}
}
