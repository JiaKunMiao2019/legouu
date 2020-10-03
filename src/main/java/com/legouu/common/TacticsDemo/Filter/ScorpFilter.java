/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ScorpFilter
 * Author:   莉莉
 * Date:     2020/8/12 21:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.TacticsDemo.Filter;

import com.legouu.common.TacticsDemo.Student;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 莉莉
 * @create 2020/8/12
 * @since 1.0.0
 */
public class ScorpFilter implements StudentDilter {

    @Override
    public boolean getStudent(Student student) {
        return student.getScorp()>30000;
    }
}