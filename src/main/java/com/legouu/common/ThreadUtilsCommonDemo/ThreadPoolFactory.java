/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ThreadPoolFactory
 * Author:   莉莉
 * Date:     2020/8/10 16:26
 * Description: 线程池的创建
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.ThreadUtilsCommonDemo;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈线程池的创建〉
 *
 * @author 莉莉
 * @create 2020/8/10
 * @since 1.0.0
 */
@Component
public class ThreadPoolFactory implements InitializingBean {
    private static ExecutorService pool;

    private static ScheduledExecutorService schedulPool;

    public static ExecutorService getPool() {
        return pool;
    }

    public static void setPool(ExecutorService pool) {
        ThreadPoolFactory.pool = pool;
    }

    public static ScheduledExecutorService getSchedulPool() {
        return schedulPool;
    }

    public static void setSchedulPool(ScheduledExecutorService schedulPool) {
        ThreadPoolFactory.schedulPool = schedulPool;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        /*三种创建的方式*/
        //BasicThreadFactory build = new BasicThreadFactory.Builder().namingPattern("basicThread").build();
        //CustomizableThreadFactory build = new CustomizableThreadFactory("springThread-pool-");

        ThreadFactory build = new ThreadFactoryBuilder()
                                .setNameFormat("commom-pool-%d")
                                .build();
        /**
         * 参数定义：
         * corePoolSize核心线程数大小，当线程数<corePoolSize，会创建线程执行runnable
         * maximumPoolSize最大线程数，当线程数>=corePoolSize的时候，会把runnable放入workQueue
         * keepAliveTime保持存活时间，当线程数大于corePoolSize的空闲线程能保持的最大时间
         * unit时间单位
         * workQueue保存任务的阻塞队列
         * threadFactory创建线程工厂
         * handler拒绝策略
         */
        pool = new ThreadPoolExecutor
                (5,200,0
                , TimeUnit.MICROSECONDS,new LinkedBlockingDeque<>(1024)
                ,build,new ThreadPoolExecutor.CallerRunsPolicy());

        schedulPool = new ScheduledThreadPoolExecutor(1,build);
    }
}