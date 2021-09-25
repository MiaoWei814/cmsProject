package org.learn.domain.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.learn.domain.ArticleSorts;

import java.util.List;

/**
 * @program: frame
 * @description:
 * @author: MiaoWei
 * @create: 2021-09-19 20:13
 **/
@Data
@Accessors(chain = true)
public class ArticleSortsVo {
    /**
     * 技术文章
     */
    private List<ArticleSorts> technology;
    /**
     * 行业新闻
     */
    private List<ArticleSorts> industry;
    /**
     * 学科咨询
     */
    private List<ArticleSorts> subject;
}
