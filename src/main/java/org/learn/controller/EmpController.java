package org.learn.controller;


import org.learn.domain.Emp;
import org.learn.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @program: SSM_Merge
 * @description:
 * @author: MiaoWei
 * @create: 2021-09-08 16:30
 **/
@RestController
@CrossOrigin
public class EmpController {
    @Autowired
    private EmpService empService;

    /**
     * 获取列表的方法
     *
     * @return
     */
    @RequestMapping("/list")
    public List<Emp> list() {
        return empService.list();
    }

    /**
     * 添加或者修改调用此方法
     *
     * @param emp 如果emp的id为空  那就新增
     *            如果emp的id不为空   就是修改
     * @return
     */
    @RequestMapping("/save")
    public Map<String, Object> save(Emp emp) {
        return empService.save(emp);
    }

    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public Map<String, Object> delete(Long id) {
        return empService.delete(id);
    }
}
