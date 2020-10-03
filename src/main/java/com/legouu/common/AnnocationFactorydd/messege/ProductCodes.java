/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ProductCodes
 * Author:   莉莉
 * Date:     2020/6/21 21:02
 * Description: 存放关键code的枚举
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.AnnocationFactorydd.messege;

import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈存放关键code的枚举〉
 *
 * @author 莉莉
 * @create 2020/6/21
 * @since 1.0.0
 */
public enum  ProductCodes {
    FR(Arrays.asList("001","002","003")),
    SE(Arrays.asList("004","005"));
    private List<String> list;

    ProductCodes(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }}