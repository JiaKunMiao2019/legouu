/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: StudentDilter
 * Author:   莉莉
 * Date:     2020/8/12 21:20
 * Description: 学生的过滤器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.TacticsDemo.Filter;

import com.legouu.common.TacticsDemo.Student;

/**
 * 〈学生的过滤器〉
 *
 * @author 莉莉
 * @create 2020/8/12
 * @since 1.0.0
 */
public interface StudentDilter {
    boolean getStudent(Student student);
}