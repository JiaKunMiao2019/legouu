/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ChatServer
 * Author:   莉莉
 * Date:     2020/4/21 21:41
 * Description: 创建消息服务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.service.websoket;

import java.io.*;
import java.net.Socket;

/**
 * 〈一句话功能简述〉<br> 
 * 〈创建消息服务〉
 *
 * @author 莉莉
 * @create 2020/4/21
 * @since 1.0.0
 */
public class ChatServer {
    /**
     * 创建服务线程
     */
    public void lunch(){
        new Thread(){
            @Override
            public void run() {
                
            }
        };
    }
    public void sendMessege(){
        Socket socket = null;
        BufferedReader in = null;
        BufferedWriter out = null;
        try{
            socket = new Socket("", 8000);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}