/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: LomdaDemo
 * Author:   莉莉
 * Date:     2020/8/11 22:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.lomdacommon;

import edu.emory.mathcs.backport.java.util.Collections;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 莉莉
 * @create 2020/8/11
 * @since 1.0.0
 */
public class LomdaDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("running1....");
            }
        });
        thread.start();

        //替换内部类
        new Thread(()->{
            System.out.println("running2...");
        }).start();

        List<String> list1 = Arrays.asList("java","javaScript","scala","python");
//        Collections.sort(list, new Comparator<String>() {
//
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length()-o2.length();
//            }
//        });
//        for(String str:list){
//            System.out.println(str);
//        }



    }

}