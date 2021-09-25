package org.learn.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * (TUser)表实体类
 *
 * @author 小缪
 * @since 2021-09-24 08:50:47
 */
@Data
@Accessors(chain = true)
public class TUser {

    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    @Excel(name = "用户名")
    private String username;

    /**
     * 密码
     */
    @Excel(name = "密码")
    private String password;

    /**
     * 昵称
     */
    @Excel(name = "昵称")
    private String nickName;
}




