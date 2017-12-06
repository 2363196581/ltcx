package com.connxun.app.common.page;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Iterator;
import java.util.List;

/**
 * @Author anna
 * @Date 2017-11-11 18:17
 * @Description 查询分页结果基础类
 */
@Data
@NoArgsConstructor
public class BasePage implements Page {

    private int draw;  //防止跨站脚本（XSS）攻击
    private int recordsTotal; //即没有过滤的记录数（数据库里总共记录数）
    private int recordsFiltered; //过滤后的记录数（如果有接收到前台的过滤条件，则返回的是过滤后的记录数）
    private Object data; //结果集

    private Page page;

    public BasePage(Page page) {
        this.page=page;
        this.recordsTotal = (int) getTotalElements();
        this.recordsFiltered=(int) getTotalElements();
        this.data =getContent();
        this.draw=0;
    }

    @Override
    public int getTotalPages() {
        return page.getTotalPages();
    }

    @Override
    public long getTotalElements() {
        return page.getTotalElements();
    }

    @Override
    public int getNumber() {
        return page.getNumber();
    }

    @Override
    public int getSize() {
        return page.getSize();
    }

    @Override
    public int getNumberOfElements() {
        return page.getNumberOfElements();
    }

    @Override
    public List getContent() {
        return page.getContent();
    }

    @Override
    public boolean hasContent() {
        return page.hasContent();
    }

    @Override
    public Sort getSort() {
        return page.getSort();
    }

    @Override
    public boolean isFirst() {
        return page.isFirst();
    }

    @Override
    public boolean isLast() {
        return page.isLast();
    }

    @Override
    public boolean hasNext() {
        return page.hasNext();
    }

    @Override
    public boolean hasPrevious() {
        return page.hasPrevious();
    }

    @Override
    public Pageable nextPageable() {
        return page.nextPageable();
    }

    @Override
    public Pageable previousPageable() {
        return page.previousPageable();
    }

    @Override
    public Iterator iterator() {
        return page.iterator();
    }
}
