/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: EnumUtils
 * Author:   莉莉
 * Date:     2020/3/25 21:36
 * Description: 枚举类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.UnusalCommonDemo;

/**
 * 〈一句话功能简述〉<br> 
 * 〈枚举类〉
 *
 * @author 莉莉
 * @create 2020/3/25
 * @since 1.0.0
 */
public enum EnumUtils {
    RED("红色","red");
    private String key;
    private String value;
    private EnumUtils(String name, String value){
        this.key = name;
        this.value = value;
    }
   public String getKey(){
        return key;
   }
   public String getValue(){
        return value;
   }
}