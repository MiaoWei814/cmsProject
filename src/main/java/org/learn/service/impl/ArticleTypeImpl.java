package org.learn.service.impl;

import org.learn.domain.ArticleType;
import org.learn.mapper.ArticleTypeMapper;
import org.learn.service.ITArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: frame
 * @description: 文章类型实现类
 * @author: MiaoWei
 * @create: 2021-09-18 16:11
 **/
@Service
public class ArticleTypeImpl implements ITArticleTypeService {
    @Autowired
    private ArticleTypeMapper articleTypeMapper;
    @Override
    public List<ArticleType> findAll() {
        return articleTypeMapper.findAll();
    }
}
