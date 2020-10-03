/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ThreadQueryService
 * Author:   莉莉
 * Date:     2020/8/26 16:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.BigMessageExchange;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 用于查询百万级以下的数据查询
 *
 * @author 莉莉
 * @create 2020/8/26
 * @since 1.0.0
 */
public class ThreadQueryService {
    SqlHadle sqlHadle = new SqlHadle();

    public List<List> getMaxResult(String table) throws Exception {
        long start = System.currentTimeMillis();
        List<List> result = new ArrayList<>();//返回结果
        //查询数据库总数量
        int count = sqlHadle.count(table);
        int num = 8000;//每次查询数量

        //需要查询的次数
        int times = count / num;
        if (count%num != 0 ){
            times+=1;
        }
        //开始页数 连接的是oracle数据库  封装的分页方式
        int bindex = 1;
        //callable用于产生结果
        List tasks = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            Callable<List> qfe = new ThreadQuery(bindex, num, table);//如果循环数量大的话会出现GC，因为创建的对象太多
            List call = qfe.call();
            tasks.add(qfe);
            bindex = bindex+num;
        }
        //定义固定长度线程池  防止线程过多
        ExecutorService executorService = Executors.newFixedThreadPool(15);
        //future用于获取结果
        List<Future<List>> futures = executorService.invokeAll(tasks);
        //处理线程返回结果
        if (futures!=null&&futures.size()!=0){
            for (Future<List> future: futures){
                result.add(future.get());
            }
        }
        executorService.shutdown();//关闭线程池

        long end = System.currentTimeMillis();
        System.out.println("线程查询用时："+(end-start)+"ms");
        return result;
    }

}