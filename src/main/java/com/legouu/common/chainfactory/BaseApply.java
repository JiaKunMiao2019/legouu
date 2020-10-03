/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: BaseApply
 * Author:   莉莉
 * Date:     2020/6/21 17:37
 * Description: 初始化责任链的属性
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.chainfactory;

import com.legouu.common.chainfactory.chainService.ApplyChainService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈初始化责任链的属性〉
 *
 * @author 莉莉
 * @create 2020/6/21
 * @since 1.0.0
 */
public class BaseApply {

    @Autowired
    private ChainFactory chainFactory;
    public void doSaveFileter(String msg){
        List<ApplyChainService> applyChainServices = chainFactory.giveService();
        ChainApply chainApply = new ChainApply();
        chainApply.addService(applyChainServices);
        chainApply.doSave(msg);
    }
}