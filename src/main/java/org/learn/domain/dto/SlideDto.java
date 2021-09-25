package org.learn.domain.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.learn.util.BasePage;

/**
 * @program: frame
 * @description: 查询list
 * @author: MiaoWei
 * @create: 2021-09-22 20:33
 **/
@Data
@Accessors(chain = true)
public class SlideDto extends BasePage {
    /**
     * 名字
     */
    private String name;
    /**
     * 启用
     */
    private Boolean enable;
}
