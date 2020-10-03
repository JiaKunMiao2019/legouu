/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: EnsurService
 * Author:   莉莉
 * Date:     2020/6/21 17:55
 * Description: 保存的实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.service.applyservice;

import com.legouu.common.AnnocationFactorydd.AnnocationFactory;
import com.legouu.common.AnnocationFactorydd.pojo.TranserService;
import com.legouu.common.chainfactory.BaseApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈保存的实现〉
 *
 * @author 莉莉
 * @create 2020/6/21
 * @since 1.0.0
 */
@Service("ensurService")
public class EnsurService extends BaseApply {
    @Autowired
    private AnnocationFactory annocationFactory;

    public void doExchang(String msg){
        doSaveFileter(msg);
    }

    public void doClain(String code){
        TranserService transerService = annocationFactory.doFactory(code);
        transerService.doClean();
    }
}