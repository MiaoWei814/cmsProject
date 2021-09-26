package org.learn.domain.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.learn.util.BasePage;

/**
 * 反馈查询列表dto
 *
 * @author MiaoDaWei
 * @date 2021/09/26
 */
@Data
@Accessors(chain = true)
public class FeedbacksQueryListDto extends BasePage {
    /**
     * 图片名
     */
    private String name;

    /**
    /**
     * 默认启用状态
     */
    private Integer enable;
}