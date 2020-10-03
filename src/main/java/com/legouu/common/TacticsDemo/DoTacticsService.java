/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DoTacticsService
 * Author:   莉莉
 * Date:     2020/8/12 21:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.TacticsDemo;

import com.legouu.common.TacticsDemo.Filter.AgeFilter;
import com.legouu.common.TacticsDemo.Filter.ScorpFilter;
import com.legouu.common.TacticsDemo.Filter.StudentDilter;

import java.util.ArrayList;

/**
 * 策略模式的执行者
 *
 * @author 莉莉
 * @create 2020/8/12
 * @since 1.0.0
 */
public class DoTacticsService {
    public void doTactics(){
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("lili",         12,3455));
        list.add(new Student("kangyongli",   28,89798));
        list.add(new Student("tangyouyun",   27,33333));
        list.add(new Student("zhangshenyang",28,4344));
        list.add(new Student("jiakunmiao",   28,2323423));

        getStudentByAge(list, new AgeFilter());
        getStudentByAge(list, new ScorpFilter());
    }

    private void getStudentByAge(ArrayList<Student> list, StudentDilter ageFilter) {
        ArrayList<Student> students = new ArrayList<>();
        for(Student student:list){
            if (ageFilter.getStudent(student)){
                students.add(student);
            }
        }
        students.forEach(System.out::println);
    }
}