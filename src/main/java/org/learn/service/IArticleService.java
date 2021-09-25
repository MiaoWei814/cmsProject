package org.learn.service;

import org.learn.domain.Article;
import org.learn.domain.dto.LoginUserDto;
import org.learn.domain.vo.ArticleSortsVo;
import org.learn.util.AjaxResult;
import org.learn.util.PageBean;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * service
 *
 * @author MiaoDaWei
 * @date 2021/09/17
 */

public interface IArticleService {
    /**
     * 查询列表
     *
     * @return {@link List}<{@link Article}>
     */
    PageBean<Article> findList(Article article);

    /**
     * 删除
     *
     * @param id id
     * @param req
     */
    AjaxResult removeById(Long id, HttpServletRequest req);

    /**
     * 保存
     *
     * @param article 文章
     * @param req
     * @return {@link AjaxResult}
     */
    AjaxResult save(Article article, HttpServletRequest req) throws Exception;

    /**
     * 查询分类文章
     */
    ArticleSortsVo articleQuery();

    /**
     * 文章浏览数
     *
     * @return {@link AjaxResult}
     * @param id
     */
    AjaxResult articleBrowseCount(Long id);
}
