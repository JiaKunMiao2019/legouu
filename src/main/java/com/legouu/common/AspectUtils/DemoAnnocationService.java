/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DemoAnnocationService
 * Author:   莉莉
 * Date:     2020/6/14 10:27
 * Description: 注解的被拦截类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.AspectUtils;

import org.springframework.stereotype.Service;

/**
 * 〈注解的被拦截类〉
 *
 * @author 莉莉
 * @create 2020/6/14
 * @since 1.0.0
 */
@Service
public class DemoAnnocationService {

    @Action(name = "这是一个注解的拦截类")
    public void add(){}
}