package com.connxun.app.common.sort;

import org.springframework.data.domain.Sort;

/**
 * @Author anna
 * @Date 2017-11-11 15:47
 * @Description 排序封装类
 */
public class SortTools {

    /**
     * 默认排序(ID降序)
     * @return
     */
    public static Sort basicSort() {
        return basicSort("desc", "id");
    }

    /**
     * 单个字段排序
     * @param orderType 排序方式
     * @param orderField 排序字段
     * @return
     */
    public static Sort basicSort(String orderType, String orderField) {
        Sort sort = new Sort(Sort.Direction.fromString(orderType), orderField);
        return sort;
    }

    /**
     * 多个字段排序,如果为空则默认ID降序排列
     * @param dtos
     * @return
     */
    public static Sort basicSort(SortDto... dtos) {
        Sort result = null;
        if (dtos.length==0){
            result= basicSort();
        }else{
            for(int i=0; i<dtos.length; i++) {
                SortDto dto = dtos[i];
                if(result == null) {
                    result = new Sort(Sort.Direction.fromString(dto.getOrderType()), dto.getOrderField());
                } else {
                    result = result.and(new Sort(Sort.Direction.fromString(dto.getOrderType()), dto.getOrderField()));
                }
            }
        }
        return result;
    }
}
