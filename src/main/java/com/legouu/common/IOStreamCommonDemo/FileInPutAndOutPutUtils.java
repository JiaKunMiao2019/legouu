/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: FileInPutAndOutPutUtils
 * Author:   莉莉
 * Date:     2020/4/2 22:24
 * Description: 文件上传下载
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.IOStreamCommonDemo;

import com.legouu.common.BaseResult;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 〈文件上传下载〉
 *
 * @author 莉莉
 * @create 2020/4/2
 * @since 1.0.0
 */
public class FileInPutAndOutPutUtils {
    /**
     * 文件的上传
     */
    public static BaseResult upLoadFile(byte[] file, String filePath, String fileName){
        File targetFIle = new File(filePath);//指定文件位置
        if (!targetFIle.exists()){
            targetFIle.mkdirs();
        }//判断是否有该文件夹，没有就新建
        try {
            FileOutputStream out = new FileOutputStream(filePath + fileName);
            out.write(file);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BaseResult();
    }

    /**
     * 判断文件路径是否存在
     */
    public static boolean exites(String filePath){
        File file = new File(filePath);
        return file.exists();
    }
    /**
     * 删除文件
     */
    public static boolean delete(String fileName){
        File file = new File(fileName);
        if ( file.exists() && file.isFile()){
            if (file.delete()){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    /**
     * 文件重命名
     */
    public static String reNameToUUID(String fileName){
        return UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".")+1);
    }

    /**
     * 文件下载
     */
    public static void downLoadeFile
    (HttpServletResponse response,String path,String fileName){
        downLoadeLocal(response,path,fileName);
    }

    private static void downLoadeLocal(HttpServletResponse response, String path, String fileName) {
        FileInputStream fileIn = null;
        ServletOutputStream out = null;

       try {
           //String fileName = new String(fileNameString.getBytes("ISO8859-1"), "UTF-8");
           response.setContentType("application/octet-stream");
           // URLEncoder.encode(fileNameString, "UTF-8") 下载文件名为中文的，文件名需要经过url编码
           response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
           File file;
           String fileDownPath = path + fileName;
           file = new File(fileDownPath);
           fileIn =new FileInputStream(file);
           out = response.getOutputStream();
           byte[] bytes = new byte[1024];
           int readTem = 0;
           while ((readTem = fileIn.read(bytes)) != -1){
               out.write(bytes,0,readTem);
           }
       } catch (Exception e) {
            e.printStackTrace();
        }finally {
           try {
               assert fileIn != null;
               fileIn.close();
               assert out != null;
               out.flush();
               out.close();
           }catch (Exception e){
               e.printStackTrace();
           }
       }
    }
    /**
     * 网络文件下载
     */
    public static boolean downLoadeNet(String fileUrl,String fileLocal) throws Exception{
        boolean flag = false;
        URL url = new URL(fileUrl);
        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
        urlCon.setConnectTimeout(6000);
        urlCon.setReadTimeout(6000);
        int code = urlCon.getResponseCode();
        if (code != HttpURLConnection.HTTP_OK) {
            throw new Exception("文件读取失败");
        }
        //读文件流
        DataInputStream in = new DataInputStream(urlCon.getInputStream());
        DataOutputStream out = new DataOutputStream(new FileOutputStream(fileLocal));
        byte[] buffer = new byte[2048];
        int count = 0;
        while ((count = in.read(buffer)) > 0) {
            out.write(buffer, 0, count);
        }
        try {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        flag = true;
        return flag;
    }

    /**
     * 文件的复制
     */
    public static void copyDemo(String copyPath,String outPath) throws Exception{
        File file = new File(copyPath);
        File fileOut = new File(outPath);
        if (!file.exists()){
            throw new Exception("文件不存在");
        }
        if (!fileOut.exists()){
            fileOut.createNewFile();
        }
        FileInputStream in = new FileInputStream(file);
        FileOutputStream out = new FileOutputStream(fileOut);

        int length;
        byte[] bytes = new byte[1024];
        while((length = in.read(bytes)) != -1){
            out.write(bytes,0,length);
        }
        in.close();
        out.close();
        System.out.println("复制完成");
    }

    /**
     * 复制文件夹
     */
    public static void copyDecry(){}

    /**
     * 文件夹大小
     * @param path
     */
    public static Map<String,Object> fileSize(String path){
        File file = new File(path);
        HashMap<String , Object> map = new HashMap<>();
        if (!file.isDirectory()){
            map.put("returnMap","请输入正确的文件路径");
            return map;
        }
        if (file.isFile()){
            long length = file.length();
            map.put("returnSize",length);
            return map;
        }
        //如果是文件夹的时候调用方法进行计算
        long size = FileInPutAndOutPutUtils.size(file);
        map.put("returnSize",size);
        return  map;
    }

    /**
     * 文件加密复制
     * @return
     */
    public static void doCopyFlieInkey(String fromPath,String toPath,int key){
        File from = new File(fromPath);
        File to = new File(toPath);
        FileInputStream in = null;
        FileOutputStream out = null;
        byte[] bytes = new byte[1024];
        try {
            in = new FileInputStream(from);
            out = new FileOutputStream(to);
            int length = 0;
            while ((length = in.read(bytes))!= -1){
                //进行求反
                for (int i = 0; i < length; i++) {
                    bytes[i] ^= key;
                }
                out.write(bytes,0,length);
            }
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

    private static long size(File file) {
        File[] files = file.listFiles();
        if (files == null){
            return 0;
        }
        long sum = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()){
                sum+=files[i].length();
            }else{
                sum+=size(files[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        File file = new File("D://java资料");
        File[] files = file.listFiles();
        for (File name:
                files) {
            System.out.println(name.getName());
        }
    }
}