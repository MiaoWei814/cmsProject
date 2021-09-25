package org.learn.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.learn.util.BasePage;

import java.util.Date;

/**
 * 文章
 *
 * @author MiaoDaWei
 * @Title: Article.java
 * @Package:cn.itsource.domain
 * @Description:(作用) : 实体类
 * @author:jack
 * @date:2021年9月17日
 * @version:V1.0
 * @date 2021/09/17
 */
@Data
@NoArgsConstructor
public class Article extends BasePage {
    //主键id
    private Long id;
    //文章标题
    private String title;
    //文章url地址
    private String url;
    //文章类型ID
    private Long typeId;
    //文章类型
    private ArticleType type;
    //点击次数
    private Integer clickCount = 0;
    //文章内容
    private String content;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate = new Date();
    //默认启用状态
    private Boolean enable;

    //自定义字段-总数
    @JsonIgnore
    private Integer count;
}
