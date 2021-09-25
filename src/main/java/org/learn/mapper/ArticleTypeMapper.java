package org.learn.mapper;

import org.learn.domain.ArticleType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文章类型映射器
 *
 * @author MiaoDaWei
 * @date 2021/09/18
 */
@Repository
public interface ArticleTypeMapper {
    /**
     * 找到所有
     *
     * @return {@link List}<{@link ArticleType}>
     */
    List<ArticleType> findAll();
}
