package com.connxun.app.searchVO;

/**
 * @Author anna
 * @Date 2017-11-11 14:25
 * @Description
 */
public class CxUserSearchVO extends CommonSearchVO {

    private String phone;
    private String password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
