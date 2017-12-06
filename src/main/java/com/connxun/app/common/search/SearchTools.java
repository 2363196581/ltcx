package com.connxun.app.common.search;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

/**
 * @Author anna
 * @Date 2017-11-11 20:07
 * @Description 创建筛选功能对象
 */
public class SearchTools {

    /**
     * 生成最终JPA需要的多条件查询语句————————
     * 此DTO可以拼接多个，当有多个，第一个DTO为where，剩余根据DTO中的type判断，默认为or
     *
     * @param speDtos SearchSpeDto 底下生成的DTO
     * @return
     */
    public static Specification buildSpecification(SearchSpeDto... speDtos) {
        Specifications result = null;
        for (SearchSpeDto dto : speDtos) {
            if (result == null) {
                result = Specifications.where(dto.getSpes());
            } else {
                if ("and".equalsIgnoreCase(dto.getType())) {
                    result = result.and(dto.getSpes());
                } else {
                    result = result.or(dto.getSpes());
                }
            }
        }
        return result;
    }

    /**
     * 定义多条件查询DTO—————————
     * 此DTO可以拼接多个，当有多个，第一个DTO为where，剩余根据DTO中的type判断，默认为or
     *
     * @param type       (必填) 拼接类型 and/or
     * @param searchDtos 查询条件 and/or key operation value
     * @return
     */
    public static SearchSpeDto buildSpeDto(String type, SearchDto... searchDtos) {
        SearchSpeDto speDtos = null;

        Specifications result = null;
        for (SearchDto dto : searchDtos) {
            if (result == null) {
                result = Specifications.where(new BaseSearch(dto));
            } else {
                if ("and".equalsIgnoreCase(dto.getType())) {
                    result = result.and(new BaseSearch(dto));
                } else {
                    result = result.or(new BaseSearch(dto));
                }
            }
        }
        speDtos = new SearchSpeDto(type, result);
        return speDtos;
    }
}
