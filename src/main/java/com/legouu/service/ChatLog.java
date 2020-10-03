/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ChatLog
 * Author:   莉莉
 * Date:     2020/5/4 10:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.service;

import com.legouu.service.DuoTai.UserDao;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 莉莉
 * @create 2020/5/4
 * @since 1.0.0
 */
public class ChatLog {
    private UserDao userDao;
    public void setSysLog(ChatLog sysLog) {

    }

    public void logIn(){
        this.userDao.doLogIn();
        System.out.println("we are family");
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}