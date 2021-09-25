package org.learn.service;

import org.learn.domain.ArticleType;

import java.util.List;

/**
 * itarticle类型服务
 *
 * @author MiaoDaWei
 * @date 2021/09/18
 */
public interface ITArticleTypeService {
    /**
     * 找到所有
     *
     * @return {@link List}<{@link ArticleType}>
     */
    List<ArticleType> findAll();
}
