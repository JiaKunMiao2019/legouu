/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ThreadUtils2
 * Author:   莉莉
 * Date:     2020/4/26 20:37
 * Description: 数据同步
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.ThreadUtilsCommonDemo;

import com.legouu.common.Common;

/**
 * 〈一句话功能简述〉<br> 
 * 〈数据同步〉
 *
 * @author 莉莉
 * @create 2020/4/26
 * @since 1.0.0
 */
public class ThreadUtils2 extends Thread {
    private Common commn;
    public ThreadUtils2(Common commn){
        this.commn = commn;
    }
    @Override
    public void run() {
        synchronized (commn){
            //数据执行
            System.out.println(commn.getMsg());
        }
    }
}