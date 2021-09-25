package org.learn.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @program: frame
 * @description: 分类文章展示首页
 * @author: MiaoWei
 * @create: 2021-09-19 19:28
 **/
@Data
public class ArticleSorts {
    /**
     * 标题
     */
    private String title;
    /**
     * url
     */
    private String url;
    /**
     * 创建日期
     */
    private String createDate;

    /**
     * 类型id
     */
    @JsonIgnore
    private Integer typeId;
}
