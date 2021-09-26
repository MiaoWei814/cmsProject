package org.learn.domain.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.learn.util.BasePage;

@Data
@Accessors(chain = true)
public class FaqQuerySaveDto {
    /**
     * id
     */
    private Integer id;

    //标题
    private String title;

    /**
     * 内容
     */
    private String content;
}