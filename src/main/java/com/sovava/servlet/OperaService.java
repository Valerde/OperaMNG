package com.sovava.servlet;

import com.sovava.pojo.Opera;
import com.sovava.pojo.PageBean;

import java.util.List;

public interface OperaService {
    /**
     * 查询所有
     *
     * @return
     */
    List<Opera> selectAll();

    /**
     * 新增剧目
     *
     * @param opera
     */
    void add(Opera opera);

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteByIds(int[] ids);

    /**
     * 分页分条件查询
     *
     * @param currentPage 当前页码
     * @param size        每页战术的条目数
     * @param opera       查询的京剧条件
     * @return
     */
    PageBean<Opera> selectByPageAndCondition(int currentPage, int size, Opera opera);


}
