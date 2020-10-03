/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: UpDownFile
 * Author:   莉莉
 * Date:     2020/6/10 22:50
 * Description: 下载模板Excel文件
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.commonfile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * 〈一句话功能简述〉<br> 
 * 〈下载模板Excel文件〉
 *
 * @author 莉莉
 * @create 2020/6/10
 * @since 1.0.0
 */
public class UpDownFile {
    //下载模板Excel文件
    public void downExcelFile(HttpServletResponse response) throws Exception {
        InputStream is = null;
        OutputStream os = null;
        try {
            //定义导出模板的名称，此处导出文件设置名称使用的URLEncoder。encode（）
            //方法功能，提供了设置编码格式，防止中文乱码
            String disposition = "attachment;fileName = "
                    + URLEncoder.encode("多地址模板.xlsx","UTF-8");

            //设置xlsm的请求头的固定格式
            response.setContentType("application/vnd.openxmlformats-officedocuent.spreadsheetml.sheet;" +
                    ";charset=utf-8");
            response.setHeader("Content-disposition",disposition);

            //设置xls的格式
            /*response.setContentType("application/vnd.ms-excel";charset=utf-8");
            response.setHeader("Content-disposition",disposition);*/

            //设置文件读取位置
            is = this.getClass().getClassLoader().
                    getResourceAsStream("template/addressTemplates.xslx");

            //文件输出的固定格式
            byte[] bytes = new byte[1024];//设置每次读取的字节
            int len;//记录读取的位置游标
            os = response.getOutputStream();//文件输出流
            while ( ( len = is.read(bytes) ) > 0 ){
                os.write(bytes,0,len);
                os.flush();
            }
        }catch (IOException e){
            throw  new Exception(e);
        }finally{
            if (null != is){
                is.close();
            }
            if (null != os){
                os.close();
            }
        }
    }
}