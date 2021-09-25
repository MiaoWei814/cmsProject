package org.learn.util;

import lombok.Data;

import java.util.List;

/**
 * 返回页面属性
 *
 * @author MiaoDaWei
 * @date 2021/09/17
 */
@Data
public class PageBean<T> { //封装
    private Integer totals;
    private List<T> data;

    public PageBean(Integer totals, List<T> data) {
        super();
        this.totals = totals;
        this.data = data;
    }

}
