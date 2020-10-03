/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DoTesat
 * Author:   莉莉
 * Date:     2020/5/4 10:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.test;

import com.legouu.service.ChatLog;
import com.legouu.service.DuoTai.UserDao;
import com.legouu.service.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 莉莉
 * @create 2020/5/4
 * @since 1.0.0
 */
public class DoTesat {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
//        ChatLog chatLog = (ChatLog)context.getBean("hatLog");
//////        User user1 = (User)context.getBean("user1");
//////        User user2 = (User)context.getBean("user2");
//////        System.out.println(user1);
//////        System.out.println(user2);
//////
       UserDao userDao = (UserDao) context.getBean("userDao");
    userDao.addUser();
    }
}