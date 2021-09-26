package org.learn.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 【请填写功能名称】对象 problem
 * 
 * @author MiaoWei
 * @date 2021-09-26
 */
@Data
@Accessors(chain = true)
public class Problem {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String title;

    /**
     * 详细描述
     */
    @Excel(name = "详细描述")
    private String content;

    /**
     * 链接地址
     */
    @Excel(name = "链接地址")
    private String linkpath;

    /**
     * 邮箱
     */
    @Excel(name = "邮箱")
    private String email;

    /**
     * 电话
     */
    @Excel(name = "电话")
    private String phone;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate = new Date();

    /**
     * 问题类型id
     */
    @Excel(name = "问题类型id")
    private Long typeId;
}