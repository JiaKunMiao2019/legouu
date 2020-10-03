/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: OneServiceAnnocation
 * Author:   莉莉
 * Date:     2020/6/21 21:07
 * Description: 第一个执行器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.AnnocationFactorydd.pojo.impl;

import com.legouu.common.AnnocationFactorydd.messege.ProductCodes;
import com.legouu.common.AnnocationFactorydd.messege.ProductType;
import com.legouu.common.AnnocationFactorydd.pojo.TranserService;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈第一个执行器〉
 *
 * @author 莉莉
 * @create 2020/6/21
 * @since 1.0.0
 */
@Service("twoServiceAnnocation")
@ProductType(ProductCodes.FR)
public class TwoServiceAnnocation implements TranserService {
    public String doClean(){
        String msg = "我是第二个执行器";
        System.out.println(msg);
        return msg;
    }
}