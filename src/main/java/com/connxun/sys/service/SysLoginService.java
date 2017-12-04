package com.connxun.sys.service;

import com.connxun.sys.dao.SysUserLoginDao;
import com.connxun.sys.model.SysUserLogin;
import com.connxun.util.code.RandomCodeUtil;
import com.connxun.util.redis.RedisClient;
import com.connxun.util.redis.RedisKeyUtil;
import com.connxun.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SysLoginService {
	@Autowired
	private RedisClient<String, String> redisClient;
	@Autowired
	private SysUserLoginDao sysUserLoginDao;

	/**
	 * 校验登录
	 *
	 * @param username
	 * @param password
	 * @param verifyCode
	 * @return
	 */
	public String checkLogin(String username, String password, String verifyCode) {
		return null;
	}

	/**
	 * 校验是否需要验证码
	 * 根据登录账号获取redis里面的值，如果不为空且大于2则需要验证码
	 *
	 * @param username
	 * @return
	 */
	public boolean isNeedVerifyCode(String username) {
		boolean result = false;
		String needVcKey = RedisKeyUtil.VERIFYERROR_KEY + username;
		String needVerifyCode = redisClient.get(needVcKey);
		if (StringUtil.isNotNullOrEmpty(needVerifyCode) && Integer.parseInt(needVerifyCode) > 2) {
			result = true;
		}
		return result;
	}

	/**
	 * 增加密码输入错误次数，放到redist里面
	 *
	 * @param username
	 */
	public void addVerifyCodeNum(String username) {
		String needVcKey = RedisKeyUtil.VERIFYERROR_KEY + username;
		String needVerifyCode = redisClient.get(needVcKey);
		if (StringUtil.isNullOrEmpty(needVerifyCode)) {
			redisClient.set(RedisKeyUtil.VERIFYERROR_KEY + username, "1", 60 * 60);//
		} else {
			redisClient.set(RedisKeyUtil.VERIFYERROR_KEY + username, String.valueOf(Integer.parseInt(needVerifyCode) + 1), 60 * 60);//
		}
	}

	/**
	 * 获取生成的验证码
	 *
	 * @param username
	 */
	public String getVerifyCodeNum(String username) {
		String needVcKey = RedisKeyUtil.VERIFYCODE_KEY + username;
		return redisClient.get(needVcKey);
	}

	/**
	 * 校验验证码是否正确
	 * 根据username获取对应的verifyCode值，与用户输入的进行比较，相同则正确，否则错误
	 *
	 * @param username
	 * @param verifyCode
	 * @return
	 */
	public boolean checkVerifyCode(String username, String verifyCode) {
		String needVcKey = RedisKeyUtil.VERIFYCODE_KEY + username;
		String redisVerifyCode = redisClient.get(needVcKey);
		if (StringUtil.isNullOrEmpty(redisVerifyCode) || (StringUtil.isNotNullOrEmpty(redisVerifyCode) && redisVerifyCode.equals(verifyCode))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 生成图形验证码
	 *
	 * @param username
	 * @return
	 */
	public String generateVerifyCode(String username) {
		String randomCode = RandomCodeUtil.createRandomNum(4);//生成四位随机数
		redisClient.set(RedisKeyUtil.VERIFYCODE_KEY + username, randomCode, 30 * 60);//
		return randomCode;
	}

	/**
	 * 登录成功后，删除redis里面的错误次数和验证码
	 *
	 * @param username
	 */
	public void clearLoginVerifyInfo(String username) {
		String needVcKey = RedisKeyUtil.VERIFYERROR_KEY + username;//错误次数
		String randomCode = RandomCodeUtil.createRandomNum(4);//生成四位随机数
		redisClient.del(needVcKey);
		redisClient.del(randomCode);
	}

	/**
	 * 登录时新增登录信息
	 *
	 * @param sysUserLogin
	 * @return
	 */
	@Async
	public void add(SysUserLogin sysUserLogin) {
		sysUserLoginDao.add(sysUserLogin);
	}

}
