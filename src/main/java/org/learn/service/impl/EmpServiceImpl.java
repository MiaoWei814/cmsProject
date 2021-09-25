package org.learn.service.impl;


import org.learn.domain.Emp;
import org.learn.mapper.EmpMapper;
import org.learn.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: SSM_Merge
 * @description:
 * @author: MiaoWei
 * @create: 2021-09-08 19:33
 **/
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper mapper;

    @Override
    public List<Emp> list() {
        return mapper.list();
    }

    @Override
    public Map<String, Object> save(Emp emp) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if (emp.getId() == null) {
                mapper.save(emp);
            } else {
                mapper.edit(emp);
            }
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("msg", "操作失败!");
        }
        return map;
    }

    @Override
    public Map<String, Object> delete(Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            mapper.delete(id);
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("msg", "删除失败!");
        }
        return map;
    }
}
