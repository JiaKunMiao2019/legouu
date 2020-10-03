/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TargetDto
 * Author:   莉莉
 * Date:     2020/6/21 20:20
 * Description: 具体执行的对象
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.onebymoreFactory.Dto;

import com.legouu.common.onebymoreFactory.ResultMsg;
import com.legouu.common.onebymoreFactory.pojo.PayRuls;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈具体执行的对象〉
 *
 * @author 莉莉
 * @create 2020/6/21
 * @since 1.0.0
 */
public class TargetDto {
    private String code;//进行新建对象的时候每个code管理一个对象
    private List<PayRuls> listPayRuls ;//存储每个code应该对应的规则

    public TargetDto(String code) {
        this.code = code;
        listPayRuls = new ArrayList<>();
    }

    public void addService(PayRuls payRuls){
        listPayRuls.add(payRuls);
    }

    public ResultMsg doExcheng(String msg){
        ResultMsg resultMsg = new ResultMsg("9999");
        if (!CollectionUtils.isEmpty(listPayRuls)){
            listPayRuls.forEach(x->{
                boolean b = x.doExchangeRils(msg);
                if (!b){
                    resultMsg.addMessege(x.descriptRuls());
                }
            });
        }
        return resultMsg;
    }
 }