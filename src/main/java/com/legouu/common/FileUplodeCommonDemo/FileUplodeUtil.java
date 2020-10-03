/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: FileUplodeUtil
 * Author:   莉莉
 * Date:     2020/3/31 23:07
 * Description: 问件上传
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.FileUplodeCommonDemo;

import com.alibaba.druid.sql.visitor.functions.If;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈问件上传〉
 *
 * @author 莉莉
 * @create 2020/3/31
 * @since 1.0.0
 */
public class FileUplodeUtil extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
    //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
    String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
    File file = new File(savePath);

}