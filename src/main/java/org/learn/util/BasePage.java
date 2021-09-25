package org.learn.util;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: frame
 * @description: 基础分页
 * @author: MiaoWei
 * @create: 2021-09-17 17:53
 **/
@Data
@Accessors(chain = true)
public class BasePage {
    /**
     * 开始分页
     */
    private Integer currentPage=1;

    /**
     * 分页数量
     */
    private Integer pageSize=10;

    /**
     * 开始分页
     *
     * @return {@link Integer}
     */
    public Integer getStartPage(){
        return (this.currentPage - 1) * this.pageSize;
    }
}
