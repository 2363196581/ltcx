package com.connxun.app.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * @Author：luoxiaosheng
 * @Date：2017-11-11 17:13
 * @Description：Json实体
 */
public class JsonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String resultCode;
    @Getter @Setter
    private String message;
    @Getter @Setter
    private Object data;
    @Getter @Setter
    private String ext;

    public JsonEntity() {
        resultCode = "1";
        message = "错误";
        data = null;
        ext = "";
    }


    public void setErrorCode(CodeEnum code) {
        this.resultCode = code.getCode();
        this.message = code.getMessage();

    }

    public void setObject(Object object) {
        setErrorCode(CodeEnum.SUCCESS);
        this.data = object;

    }

}
