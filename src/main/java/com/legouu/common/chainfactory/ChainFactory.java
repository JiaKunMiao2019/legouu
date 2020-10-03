/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ChainFactory
 * Author:   莉莉
 * Date:     2020/6/21 17:38
 * Description: 提供接口的所有实例
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.chainfactory;

import com.legouu.common.chainfactory.chainService.ApplyChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈提供接口的所有实例〉
 *
 * @author 莉莉
 * @create 2020/6/21
 * @since 1.0.0
 */
@Service
public class ChainFactory {
    @Autowired
    private List<ApplyChainService> chainApplys;

    public List<ApplyChainService> giveService(){
        return chainApplys;
    }
}