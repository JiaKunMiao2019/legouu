package com.legouu.common.StringUtilsCommonDemo;
import org.springframework.util.StringUtils;
 /**
 * 〈常用字符串的基本使用方法〉
 *
 * @author 莉莉
 * @create 2020/3/28
 * @since 1.0.0
 */
public class StringUtil {
    private static final String UP = "up";
    private static final String DOWN = "down";
    private static final String TRIM = "trim";

    /*字符串大小写与去空*/
    public static String doExchange(String msg,String type){
        if (StringUtils.isEmpty(msg)){
            return null;
        }
        String s="";
        if (StringUtil.doEquals(type,UP)){
            s = msg.toUpperCase();
        }else if (StringUtil.doEquals(type,DOWN)){
            s = msg.toLowerCase();
        }else if (StringUtil.doEquals(type,TRIM)){
            s = msg.trim();
        }
        return s;
    }

    /*字符串比较工具*/
    public static Boolean doEquals(String msg1,String msg2){
        if (org.springframework.util.StringUtils.isEmpty(msg1) || StringUtils.isEmpty(msg2)){
            return false;
        }
        boolean equals = msg1.equals(msg2);
        return equals;
    }

    /*字符串比较工具忽略大小写*/
    public static Boolean doEqualsIN(String msg1,String msg2){
        if (StringUtils.isEmpty(msg1) || StringUtils.isEmpty(msg2)){
            return false;
        }
        boolean b = msg1.equalsIgnoreCase(msg2);
        return b;
    }

    /*截取工具*/
    public static String[] doSlipt(String msg,String key,int index){
        if (StringUtils.isEmpty(msg)){
            return null;
        }
        return msg.split(key, index);
    }

    /*截取*/
    public static String doSustring(String msg,String key,int begin){
        if (StringUtils.isEmpty(msg)){
            return null;
        }
        if (StringUtils.isEmpty(key)){
            return msg;
        }
        int index = msg.indexOf(key);
        if (index == -1){
            return msg;
        }
        return msg.substring(begin,index);
    }
    public static String doSustringEnd(String msg,String key,int end){
        if (StringUtils.isEmpty(msg)){
            return null;
        }
        if (StringUtils.isEmpty(key)){
            return msg;
        }
        int index = msg.indexOf(key);
        if (index == -1){
            return msg;
        }
        //todo 如果需要分割多个的话需要如何操作
        return msg.substring(index-1,end);
    }

    /*替换*/
    public static String doReplace(String msg,String key,String old){
        msg.replaceFirst(old,key);
        //替换多个
        StringBuffer stringBuffer = new StringBuffer(msg);
        String s = "["+old+"]";
        return msg.replaceAll(s,key);
    }
}