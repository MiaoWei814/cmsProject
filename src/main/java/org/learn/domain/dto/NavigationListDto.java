package org.learn.domain.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.learn.util.BasePage;

import java.util.Date;

/**
 * 导航列表dto
 *
 * @author MiaoDaWei
 * @date 2021/09/26
 */
@Data
@Accessors(chain = true)
public class NavigationListDto extends BasePage {
    private static final long serialVersionUID = 1L;
    /**
     * id-保存的时候用
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 类型id
     */
    private Long typeId;
}