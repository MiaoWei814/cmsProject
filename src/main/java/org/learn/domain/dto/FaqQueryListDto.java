package org.learn.domain.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.learn.util.BasePage;

@Data
@Accessors(chain = true)
public class FaqQueryListDto extends BasePage {
    //标题
    private String title;
}