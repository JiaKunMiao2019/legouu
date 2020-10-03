/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Student
 * Author:   莉莉
 * Date:     2020/8/12 21:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.TacticsDemo;

/**
 * 一个实体类
 *
 * @author 莉莉
 * @create 2020/8/12
 * @since 1.0.0
 */
public class Student {
    private String  name;
    private Integer age;
    private Integer scorp;

    public Student(String name, Integer age, Integer scorp) {
        this.name = name;
        this.age = age;
        this.scorp = scorp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getScorp() {
        return scorp;
    }

    public void setScorp(Integer scorp) {
        this.scorp = scorp;
    }
}