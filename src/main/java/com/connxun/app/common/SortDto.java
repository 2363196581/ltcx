package com.connxun.app.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author anna
 * @Date 2017-11-11 15:45
 * @Description 排序Dto对象
 */
@AllArgsConstructor
public class SortDto {

    //排序方式
    @Getter @Setter
    private String orderType;

    //排序字段
    @Getter @Setter
    private String orderField;

    //默认为DESC排序
    public SortDto(String orderField) {
        this.orderField = orderField;
        this.orderType = "desc";
    }
}
