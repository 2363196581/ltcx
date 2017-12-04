package com.connxun.app.searchVO;

import io.swagger.annotations.ApiParam;

/**
 * Created by 1553280431@qq.com on 2017/5/25.
 * 公共查询VO
 */
public class CommonSearchVO {

    @ApiParam(required = false, name = "page", value = "页码")
    private int page = 0;//页码
    @ApiParam(required = false, name = "start", value = "每次请求起始位置")
    private int start = 0;//
    @ApiParam(required = false, name = "length", value = "每页条目数")
    private int length = 15;//每页条目数
    @ApiParam(required = false, name = "total", value = "总条目数")
    private int total = 0;//总条目数
    @ApiParam(required = false, name = "draw", value = "")
    private int draw;


    public int getPageParams() {
//        return start > length ? ((start - (start % length)) / length + 1) : 1;
        return page / length;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }
}
