/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TwoPayRuls
 * Author:   莉莉
 * Date:     2020/6/21 20:27
 * Description: 第二个执行器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.onebymoreFactory.pojo.impl;

import com.legouu.common.onebymoreFactory.pojo.PayRuls;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈第二个执行器〉
 *
 * @author 莉莉
 * @create 2020/6/21
 * @since 1.0.0
 */
@Component("twoPayRuls")
public class TwoPayRuls implements PayRuls {

    @Override
    public String descriptRuls() {
        return "第二个执行器";
    }

    @Override
    public List<String> ruleCodes() {
        return Arrays.asList("001","005","006");
    }

    @Override
    public boolean doExchangeRils(String msg) {
        if (msg.equals("004")){
            return true;
        }
        return false;
    }
}