package org.learn.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @program: frame
 * @description: 轮播图
 * @author: MiaoWei
 * @create: 2021-09-22 20:21
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Slide {
    /**
     * id
     */
    private Long id;
    /**
     * 名字
     */
    private String name;
    /**
     * 路径
     */
    private String path;
    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate = new Date();
    /**
     * 启用
     */
    private Boolean enable;

}
