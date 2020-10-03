/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: OneByMore
 * Author:   莉莉
 * Date:     2020/6/21 20:36
 * Description: 装饰着执行器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.onebymoreFactory.factory;

import com.legouu.common.onebymoreFactory.Dto.TargetDto;
import com.legouu.common.onebymoreFactory.ResultMsg;
import com.legouu.common.onebymoreFactory.pojo.PayRuls;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈装饰着执行器〉
 *
 * @author 莉莉
 * @create 2020/6/21
 * @since 1.0.0
 */
@Service("oneByMore")
public class OneByMore {
    private HashMap<String, TargetDto> targetDtos;

    @Autowired
    public void doGetService(PayRuls...payRuls){
        targetDtos = new HashMap<>();
        for (PayRuls ruls:payRuls) {
            List<String> codes = ruls.ruleCodes();
            codes.forEach(x->{
                TargetDto targetDto = targetDtos.get(x);
                if (null == targetDto){
                    targetDto = new TargetDto(x);
                }
                targetDto.addService(ruls);
                targetDtos.put(x,targetDto);
            });
        }
    }

    public ResultMsg doChange(String code,String msg){
        ResultMsg resultMsg = new ResultMsg("9999");
        if (!CollectionUtils.isEmpty(targetDtos)){
           TargetDto targetDto = targetDtos.get(code);
           resultMsg = targetDto.doExcheng(msg);
       }
       return resultMsg;
    }
}