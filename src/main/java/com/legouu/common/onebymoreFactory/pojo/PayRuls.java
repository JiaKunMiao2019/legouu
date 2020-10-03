/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: PayRuls
 * Author:   莉莉
 * Date:     2020/6/21 20:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.onebymoreFactory.pojo;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 莉莉
 * @create 2020/6/21
 * @since 1.0.0
 */
public interface PayRuls {
    String descriptRuls();//规则的描述
    List<String> ruleCodes();//codes的集合
    boolean doExchangeRils(String msg);//进行规则的处理
}