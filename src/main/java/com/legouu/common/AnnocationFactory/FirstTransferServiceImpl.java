/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: FirstTransferServiceImpl
 * Author:   莉莉
 * Date:     2020/6/13 18:10
 * Description: 第一个实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.AnnocationFactory;

import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈第一个实现类〉
 *
 * @author 莉莉
 * @create 2020/6/13
 * @since 1.0.0
 */
@Service("firstTransferService")
@TransferType(PointGroup.FR)
public class FirstTransferServiceImpl implements TransferService {

    @Override
    public String doYourThinks(String tp) {
        return "我是第一个实现类："+tp;
    }
}