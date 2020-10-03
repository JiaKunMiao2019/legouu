/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AnnocationController
 * Author:   莉莉
 * Date:     2020/6/13 18:16
 * Description: 注解类的测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.controller;

import com.legouu.common.AnnocationFactory.TransferService;
import com.legouu.common.AnnocationFactory.TransferServiceFactory;
import com.legouu.common.onebymoreFactory.ResultMsg;
import com.legouu.common.onebymoreFactory.factory.OneByMore;
import com.legouu.service.applyservice.EnsurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Retention;

/**
 * 〈一句话功能简述〉<br> 
 * 〈注解类的测试〉
 *
 * @author 莉莉
 * @create 2020/6/13
 * @since 1.0.0
 */
@RestController
public class AnnocationController {
    @Autowired
    private TransferServiceFactory transferService;
    @Autowired
    private EnsurService ensurService;
    @Autowired
    private OneByMore oneByMore;

    @GetMapping("/annocation")
    public String doAnnocation(@RequestParam("TP") String TP){
        TransferService transferService = this.transferService.getTransferService(TP);
        String s = transferService.doYourThinks(TP);
        return s;
    }

    @GetMapping("/chainApply")
    public void doChainApply(@RequestParam("msg")String msg){
        ensurService.doExchang(msg);
    }

    @GetMapping("/doExchange")
    public ResultMsg doExchenge(@RequestParam("code") String code,@RequestParam("msg")String msg){
        return oneByMore.doChange(code,msg);
    }

    @GetMapping("/doClain")
    public void doClain(@RequestParam("code")String code){
        ensurService.doClain(code);
    }
}