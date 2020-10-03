/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ThreadUtils
 * Author:   莉莉
 * Date:     2020/4/19 8:14
 * Description: 多线程使用
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.ThreadUtilsCommonDemo;

import org.springframework.util.ObjectUtils;

/**
 * 〈多线程使用〉
 *
 * @author 莉莉
 * @create 2020/4/19
 * @since 1.0.0
 */
public class ThreadUtils extends Thread{
    private String stack;

    public ThreadUtils(String stack) {
        this.stack = stack;
    }

    /**
     * 多线程的入口--执行顺序
     */
    @Override
    synchronized public void run() {
        synchronized (stack){
            //方法执行体
        }
    }

    public static Thread newThread(){
        Thread thread = new Thread();
        return thread;
    }

    public static void main(String[] args) {
        dotest dotest = new dotest();
        dotest.setName("sdfa");
        dotest.start();
        for (int i =0;i<10;i++) {
            int v = (int)Math.random() * 1000000000;
            try {
                Thread.sleep(v);
                System.out.println("当前线程:"+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 多线程数据同步问题
     */
    public static void moreThread(String msg){
        Thread thread;
        if (!Thread.currentThread().getName().equals("1243")){
                thread = new Thread();
                thread.setName("1243");

        }
    }
    public static class dotest extends Thread{
        @Override
        public void run() {
            synchronized (this){

            }
        }
    }
}
