/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ApplyChainService
 * Author:   莉莉
 * Date:     2020/6/21 17:40
 * Description: 责任链service
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.chainfactory.chainService;

import com.legouu.common.chainfactory.ChainApply;

/**
 * 〈一句话功能简述〉<br> 
 * 〈责任链service〉
 *
 * @author 莉莉
 * @create 2020/6/21
 * @since 1.0.0
 */
public interface ApplyChainService {
    void doSave(String msg, ChainApply chainApply);

}