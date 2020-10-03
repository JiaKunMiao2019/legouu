/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ResultMsg
 * Author:   莉莉
 * Date:     2020/6/21 20:16
 * Description: 返回信息
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.onebymoreFactory;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈返回信息〉
 *
 * @author 莉莉
 * @create 2020/6/21
 * @since 1.0.0
 */
public class ResultMsg {
    private String status;//返回的为9999为错误返回信息
    private List<String> listMsg;

    public ResultMsg(String status, List<String> listMsg) {
        this.status = status;
        this.listMsg = listMsg;
    }

    public ResultMsg(String status) {
        this(status,new ArrayList<>());
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getListMsg() {
        return listMsg;
    }

    public void setListMsg(List<String> listMsg) {
        this.listMsg = listMsg;
    }

    public ResultMsg addMessege(String msg){
        if (CollectionUtils.isEmpty(listMsg)){
            listMsg = new ArrayList<>();
        }
        listMsg.add(msg);
        return this;
    }
}