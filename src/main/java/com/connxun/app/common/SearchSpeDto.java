package com.connxun.app.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specifications;

/**
 * @Author anna
 * @Date 2017-11-11 20:05
 * @Description 增加筛选条件的DTO对象
 */
@AllArgsConstructor
public class SearchSpeDto {

    /** 类型，and或者or */
    @Getter @Setter
    private String type;
    @Getter @Setter
    private Specifications spes;
}
