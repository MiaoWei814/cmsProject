package org.learn.mapper;


import org.learn.domain.Article;
import org.learn.domain.ArticleSorts;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文章映射器
 *
 * @author MiaoDaWei
 * @date 2021/09/17
 */
@Repository
public interface ArticleMapper {

    /**
     * 找到列表
     *
     * @return {@link List}<{@link Article}>
     */
    List<Article> findList(Article article);

    /**
     * 查询总数
     *
     * @param article 文章
     * @return {@link Integer}
     */
    Integer selectCount(Article article);

    /**
     * 删除过id
     *
     * @param id id
     * @return int
     */
    int delById(Long id);

    /**
     * 添加
     *
     * @param article 文章
     * @return int
     */
    int add(Article article);

    /**
     * 编辑
     *
     * @param article 文章
     * @return {@link Integer}
     */
    Integer edit(Article article);

    /**
     * 查询分类文章
     */
    List<ArticleSorts> querySortArticles();

    /**
     * 查询通过id
     *
     * @param id
     * @return {@link Article}
     */
    Article queryById(Long id);
}
