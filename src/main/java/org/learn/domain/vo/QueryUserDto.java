package org.learn.domain.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.learn.util.BasePage;

/**
 * @program: frame
 * @description: 请求查询用户
 * @author: MiaoWei
 * @create: 2021-09-24 14:27
 **/
@Data
@Accessors(chain = true)
public class QueryUserDto extends BasePage {
    /**
     * 用户名
     */
    private String username;
}
