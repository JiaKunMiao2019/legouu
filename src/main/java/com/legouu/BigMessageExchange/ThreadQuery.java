/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ThreadQuery
 * Author:   莉莉
 * Date:     2020/8/26 15:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.BigMessageExchange;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 莉莉
 * @create 2020/8/26
 * @since 1.0.0
 */
public class ThreadQuery implements Callable<List> {
    SqlHadle sqlHadle = new SqlHadle();
    private String search;//查询条件，根据条件来定义该类的属性
    private int bindex;//当前页数
    private int num;//每页查询多少条
    private String table;//要查询的表
    //private List page;//每次查询出来的数据

    public ThreadQuery(int bindex, int num, String table) {
        this.bindex = bindex;
        this.num = num;
        this.table = table;
    }

    @Override
    public List call() throws Exception {
        return sqlHadle.queryTest11(bindex, num, table);
    }
}