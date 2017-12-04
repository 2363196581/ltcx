package com.connxun.util.tls.sigcheck;

public class CheckResultEntity {
	private boolean isOk = false;
	private String sig=null;
	private int expireTime;
	private int initTime;
	private String errMsg;
	private int ret;
	
	public boolean isOk() {
		return isOk;
	}
	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
	public String getSig() {
		return sig;
	}
	public void setSig(String sig) {
		this.sig = sig;
	}
	public int getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(int expireTime) {
		this.expireTime = expireTime;
	}
	public int getInitTime() {
		return initTime;
	}
	public void setInitTime(int initTime) {
		this.initTime = initTime;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public int getRet() {
		return ret;
	}
	public void setRet(int ret) {
		this.ret = ret;
	}
	@Override
	public String toString() {
		return "CheckResultEntity [isOk=" + isOk + ", sig=" + sig
				+ ", expireTime=" + expireTime + ", initTime=" + initTime
				+ ", errMsg=" + errMsg + ", ret=" + ret + "]";
	}

	
	
	
	
}
