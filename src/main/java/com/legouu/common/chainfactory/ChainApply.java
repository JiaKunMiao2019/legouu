/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ChainApply
 * Author:   莉莉
 * Date:     2020/6/21 17:39
 * Description: 责任链
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.chainfactory;

import com.legouu.common.chainfactory.chainService.ApplyChainService;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈责任链〉
 *
 * @author 莉莉
 * @create 2020/6/21
 * @since 1.0.0
 */
public class ChainApply {
    private int index = 0;//对访问时的service进行下标标识
    private List<ApplyChainService> applyChainServices;

    public void addService(List<ApplyChainService> list){
        if (!CollectionUtils.isEmpty(list)){
            applyChainServices = new ArrayList<>();
            list.forEach(x->{
                applyChainServices.add(x);
            });
        }
    }

    public void doSave(String msg){
        if (index == applyChainServices.size()){//如果下标等于集合的个数就会返回
            return;
        }
        msg = "第"+index+"执行";
        ApplyChainService applyChainService = applyChainServices.get(index++);
        applyChainService.doSave(msg,this);
    }
}