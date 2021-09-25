package org.learn.domain.vo;

import lombok.Data;

/**
 * @program: frame
 * @description: 查询用户返回
 * @author: MiaoWei
 * @create: 2021-09-24 14:31
 **/
@Data
public class QueryUserVo {
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 尼克的名字
     */
    private String nickName;
}
