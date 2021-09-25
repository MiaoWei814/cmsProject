package org.learn.mapper;


import org.learn.domain.Emp;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Emp)表数据库访问层
 *
 * @author 小缪
 * @since 2021-09-08 15:19:11
 */
@Repository
public interface EmpMapper {
    List<Emp> list();

    void save(Emp emp);

    void delete(Long id);

    void edit(Emp emp);
}

