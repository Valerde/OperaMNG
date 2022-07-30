package com.sovava.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Description: 分页查询的javaBean
 *
 * @author: ykn
 * @date: 2022年07月29日 22:44
 **/
public class PageBean<T> implements Serializable {
    //总记录数
    private int totalCount;
    //当前页数据
    private List<T> rows;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
