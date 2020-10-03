/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: OneService
 * Author:   莉莉
 * Date:     2020/6/21 17:41
 * Description: 第一个实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.chainfactory.chainService.impl;

import com.legouu.common.chainfactory.ChainApply;
import com.legouu.common.chainfactory.chainService.ApplyChainService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈第一个实现类〉
 *
 * @author 莉莉
 * @create 2020/6/21
 * @since 1.0.0
 */
@Component("twoService")
@Order(1)
public class TwoService implements ApplyChainService {

    @Override
    public void doSave(String msg, ChainApply chainApply) {
        System.out.println("1");
        System.out.println(msg);
        chainApply.doSave(msg);
    }
}