package org.learn.util;

/**
 * 常数
 *
 * @author MiaoDaWei
 * @date 2021/09/24
 */
public interface Constant {
    /**
     * 用户会话密钥
     */
    String USER_SESSION_KEY ="user_session_key";
    /**
     * 最小的用户名长度
     */
    Integer MIN_USERNAME_LENGTH = 2;

    /**
     * 最小密码长度
     */
    Integer MIN_PASSWORD_LENGTH = 3;

    /**
     * 首页导航数量限制
     */
    Integer NAX_INDEX_NAVIGATION = 8;
}
