package org.learn.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: frame
 * @description: 文章浏览次数
 * @author: MiaoWei
 * @create: 2021-09-22 16:31
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleResultBrowseVo {
    /**
     * 次数
     */
    private Integer count;
}
