package org.learn.domain.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: oneProject
 * @description: 首页导航栏列表
 * @author: MiaoWei
 * @create: 2021-09-26 11:41
 **/
@Data
@Accessors(chain = true)
public class IndexNavigationListSideVo {
    String url;
    String name;

}
