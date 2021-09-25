package org.learn.service;


import org.learn.domain.Emp;

import java.util.List;
import java.util.Map;

/**
 * (Emp)表服务接口
 *
 * @author 小缪
 * @since 2021-09-08 15:19:15
 */
public interface EmpService {
    List<Emp> list();

    Map<String, Object> save(Emp emp);

    Map<String, Object> delete(Long id);
}
