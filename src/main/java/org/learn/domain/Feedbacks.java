package org.learn.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class Feedbacks {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 图片名
     */
    @Excel(name = "图片名")
    private String name;

    /**
     * 图片路径
     */
    @Excel(name = "图片路径")
    private String path;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate = new Date();

    /**
     * 默认启用状态
     */
    @Excel(name = "默认启用状态")
    private Integer enable;
}