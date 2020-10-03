/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: PointGroup
 * Author:   莉莉
 * Date:     2020/6/13 17:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.AnnocationFactory;

import java.util.Arrays;
import java.util.List;

/**
 * 〈定义工厂的成员〉<br>
 * 〈定义适用于同一种使用的方法的属性定义〉
 *
 * @author 莉莉
 * @create 2020/6/13
 * @since 1.0.0
 */
public enum  PointGroup {
    FR(Arrays.asList("TP10222", "TP10033")),
    ENTER(Arrays.asList("TP20011", "TP20012"));
    private List<String> list;

    PointGroup(List<String> asList) {
        this.list = asList;
    }
    public List<String> getList(){
        return this.list;
    }
}