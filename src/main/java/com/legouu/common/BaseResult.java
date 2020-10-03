/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: BaseResult
 * Author:   莉莉
 * Date:     2020/4/2 22:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common;

/**
 * 〈一句话功能简述〉<br> 
 * 〈结果封装〉
 *
 * @author 莉莉
 * @create 2020/4/2
 * @since 1.0.0
 */
public class BaseResult {
    private String msg = "成功";
    private String code = "000000";
    /**正确数据*/
    private Object data;
    public void setMsg(String msg){
        this.msg = msg;
    }
    public void setData(Object data){
        this.data = data;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getMsg(){
        return this.msg;
    }
    public String getCode(){
        return this.code;
    }
    public Object getData(){
        return this.data;
    }
    /**
     * 异常时调用
     */
    public BaseResult(Throwable t){
        this.msg=t.getMessage();
        this.code = "999999";
    }
    /**
     * 正常时调用
     */
    public BaseResult(Object data){
        this.data=data;
    }
    /**
     * 无参构造
     */
    public BaseResult(){}
    /**
     * 返回msg
     */
    public BaseResult(String msg){
        this.msg = msg;
    }
}