package com.connxun.app.common;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：luoxiaosheng
 * @Date：2017-11-11 17:13
 * @Description：controller基类
 */
public class AppBaseController {

    protected JsonEntity json = new JsonEntity();

    protected Map<Object, Object> data = new HashMap<Object, Object>();

    public JsonEntity ErrorCode(CodeEnum code) {
        JsonEntity json = new JsonEntity();
        json.setErrorCode(code);
        return json;

    }

    public JsonEntity booleanToJson(boolean status) {
        JsonEntity json = new JsonEntity();
        if (status) {
            json.setResultCode("200");
            json.setData(null);
            json.setMessage("操作成功");
        } else {
            json.setResultCode("1");
            json.setData(null);

            json.setMessage("操作失败");
        }
        return json;
    }

    public JsonEntity booleanToJson(boolean status, String message) {
        JsonEntity json = new JsonEntity();
        if (status) {
            json.setResultCode("200");
            json.setData(null);

            json.setMessage(message);
        } else {
            json.setResultCode("1");
            json.setData(null);

            json.setMessage(message);
        }
        return json;
    }

    public <T> JsonEntity listToJson(List<T> dataList) {
        if (dataList != null && dataList.size() > 0) {
            json.setResultCode("200");
            json.setMessage("成功查询到列表信息");
            json.setData(dataList);
        } else {
            json.setResultCode("1");
            json.setData(null);

            json.setMessage("列表为空");
        }
        return json;
    }

    public JsonEntity objectToJson(Object object) {
        JsonEntity json = new JsonEntity();
        if (object != null) {
            json.setResultCode("200");
            json.setMessage("成功查询到信息");
            json.setData(object);
        } else {
            json.setResultCode("1");
            json.setData(null);

            json.setMessage("信息为空");
        }
        return json;
    }

}
