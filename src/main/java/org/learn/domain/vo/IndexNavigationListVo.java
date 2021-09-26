package org.learn.domain.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @program: oneProject
 * @description: 首页导航栏列表
 * @author: MiaoWei
 * @create: 2021-09-26 11:41
 **/
@Data
@Accessors(chain = true)
public class IndexNavigationListVo {
    /**
     * 顶部导航
     */
    List<String> topNavigation;
    /**
     * 侧边栏
     */
    List<IndexNavigationListSideVo> sidebar;
}
