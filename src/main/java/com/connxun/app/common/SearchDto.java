package com.connxun.app.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author anna
 * @Date 2017-11-11 20:02
 * @Description 查询Dto对象
 */
@AllArgsConstructor
public class SearchDto {

    /** 拼接类型，and或者or */
    @Getter @Setter
    private String type;
    //查询列
    @Getter @Setter
    private String key;
    //查询条件 如：eq、like等
    @Getter @Setter
    private String operation;
    //条件值
    @Getter @Setter
    private Object value;

    public SearchDto(String key, String operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }
}
