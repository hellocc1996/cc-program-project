package com.program.vo;

import java.io.Serializable;

/*
 * 描述:
 *  分页参数序列化类
 * @auth zhengkk19738
 * @time 2018/9/3
 */
public class PageParam implements Serializable {
    private int page; //当前页

    private int limit = 10; //每页数量


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
