/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MathUtils
 * Author:   莉莉
 * Date:     2020/3/28 9:23
 * Description: 常用Math计算类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.MathUtilsCommonDemo;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * 〈常用Math计算类〉
 *
 * @author 莉莉
 * @create 2020/3/28
 * @since 1.0.0
 */
public class MathUtils {
    private static final String MAX = "max";
    private static final String MIN = "min";

    //乘法运算
    public static Double doMultiplu(Double msg1, Double msg2, Integer key){
        if ( StringUtils.isEmpty(msg1) || StringUtils.isEmpty(msg2)){
            return 0.0;
        }
        BigDecimal bigDecimal = new BigDecimal(msg1);
        BigDecimal result;
        if (StringUtils.isEmpty(key)){
            result = bigDecimal.multiply(new BigDecimal(msg2));

        }else {
            result = bigDecimal.multiply(new BigDecimal(msg2)).setScale(key, BigDecimal.ROUND_HALF_UP);

        }
        return result.doubleValue();
    }

    //除法运算
    public static Double doDivide(Double msg1, Double msg2, Integer key){
        if ( StringUtils.isEmpty(msg1) || StringUtils.isEmpty(msg2)){
            return 0.0;
        }
        BigDecimal bigDecimal = new BigDecimal(msg1);
        BigDecimal result;
        if (StringUtils.isEmpty(key)){
            result = bigDecimal.divide(new BigDecimal(msg2));
        }else {
            result = bigDecimal.divide(new BigDecimal(msg2), key, BigDecimal.ROUND_HALF_UP);
        }
        return result.doubleValue();
    }
    //加法运算
    public static Double doAdd(Double msg1, Double msg2){
        BigDecimal bigDecimal = new BigDecimal(msg1);
        BigDecimal result = bigDecimal.add(new BigDecimal(msg2));
        return result.doubleValue();
    }
    //减法运算
    public static Double doSubtract(Double msg1, Double msg2){
        BigDecimal bigDecimal = new BigDecimal(msg1);
        BigDecimal result = bigDecimal.subtract(new BigDecimal(msg2));
        return result.doubleValue();
    }
    //计算
    public static Double doWork(List<String> list, Integer key){
        String s;
        String s1 = null;
        Double aDouble = null;
        Integer size = null;
        for (int i = 0; i < list.size(); i++) {
            if ((i+1)%2 == 0){
                if (i==1){
                    s1 = list.get(i-1);
                }else{
                    s1 = Double.toHexString(aDouble);
                }
                if (i==(list.size()-1)){
                    size = key;
                }
                s = list.get(i);
                switch (s){
                    case "+":
                        aDouble = MathUtils.doAdd(Double.parseDouble(s1), Double.parseDouble(list.get(i+1)));
                        break;
                    case "-":
                        aDouble = MathUtils.doSubtract(Double.parseDouble(s1), Double.parseDouble(list.get(i+1)));
                        break;
                    case "/":
                        aDouble = MathUtils.doDivide(Double.parseDouble(s1), Double.parseDouble(list.get(i+1)),size);
                        break;
                    case "*":
                        aDouble = MathUtils.doMultiplu(Double.parseDouble(s1), Double.parseDouble(list.get(i+1)),size);
                        break;
                    default:return -0.0;
                }
            }


        }
        return aDouble;
    }

    //最大值最小值
    public static Integer doChange(Integer msg1,Integer msg2,String key){
        if ( StringUtils.isEmpty(msg1) ){
            return msg2;
        }
        if ( StringUtils.isEmpty(msg2)){
            return msg1;
        }
        if (StringUtils.isEmpty(key)){
            return null;
        }
        if (MAX.equals(key)){
            return Math.max(msg1, msg2);
        }else {
            return Math.min(msg1, msg2);
        }
    }

    public static Double doChange(Double msg1,Double msg2,String key){
        if ( StringUtils.isEmpty(msg1) ){
            return msg2;
        }
        if ( StringUtils.isEmpty(msg2)){
            return msg1;
        }
        if (StringUtils.isEmpty(key)){
            return null;
        }
        if (MAX.equals(key)){
            return Math.max(msg1, msg2);
        }else {
            return Math.min(msg1, msg2);
        }
    }
}