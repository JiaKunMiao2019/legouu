/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DoKeyUser
 * Author:   莉莉
 * Date:     2020/3/15 22:50
 * Description: 设置简单的加密工具
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.UnusalCommonDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 〈设置简单的加密工具〉
 *
 * @author 莉莉
 * @create 2020/3/15
 * @since 1.0.0
 */
@Component
public class DoKeyUser {
    @Value("${USER_kEY.KYL}")
    private  int userKeyKK;

    public String doMSGKey(String msg){
        char[] chars = msg.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] ^ userKeyKK);
        }
        return new String(chars);
    }
}