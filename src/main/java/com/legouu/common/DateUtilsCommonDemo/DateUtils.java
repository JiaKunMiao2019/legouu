/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DateUtils
 * Author:   莉莉
 * Date:     2020/3/28 9:24
 * Description: 常用日期类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.DateUtilsCommonDemo;
import com.legouu.common.StringUtilsCommonDemo.StringUtil;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


/**
 * 〈常用日期类〉
 *
 * @author 莉莉
 * @create 2020/3/28
 * @since 1.0.0
 */
public class DateUtils {
    private static final String YEAR = "yyyy-MM-dd";
    private static final String HOUR = "HH:mm:ss";
    private static final String YEARANDHOUR = "yyyy-MM-dd HH:mm:ss";
    private static final String LOCALDATETIME = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String KEYY = "date";//获取日期标识
    private static final String KEYH = "hour";//获取时间标识
    /**获取当前时间
     * 默认为获取当前的年月加时间
     * date=date：获取年
     * @param date
     * @return
     */
    public static Date getNowTime(String date){
        Date nowDate;
        if (StringUtils.isEmpty(date)){
            LocalDateTime now = LocalDateTime.now();
            nowDate = doExchenge(now);
        }else if (StringUtil.doEquals(date,KEYY)){
            LocalDate now = LocalDate.now();
            nowDate = doExchenge(now);
        }else{
            return null;
        }
        return nowDate;
    }

    /**
     * 对时间进行修改，修改时间的年月日：时分秒
     * 规则：日期进行转换为天，时间转换为秒
     */
    public static Date doChangeDate(Date date,int days,int milins){
        LocalDateTime dateTime = doExchenge(date);
        LocalDateTime localDateTime = dateTime.plusDays(days);
        return doExchenge(localDateTime.plusSeconds(milins));
    }

    /**
     * 对时间进行设置，设置时间的年月日：时分秒
     * 规则：日期进行转换为天，时间转换为秒
     */
    public static Date doSetDate(Date date,int year,int mounth,int day,int hour,int milty,int milins){
        LocalDateTime dateTime = doExchenge(date);
        LocalDateTime localDateTime = dateTime.withDayOfMonth(day).withMonth(mounth).withYear(year);
        return doExchenge(localDateTime.withHour(hour).withMinute(milty).withSecond(milins));
    }

    /**
     * 两个时间的比较:比较到时分秒
     */
    public static Boolean doEqualDateTime(Date date1,Date date2){
        if (ObjectUtils.isEmpty(date1) || ObjectUtils.isEmpty(date2)){
            return false;
        }
        LocalDateTime localDateTime1 = doExchenge(date1);
        LocalDateTime localDateTime2 = doExchenge(date2);
        boolean equal = localDateTime1.isEqual(localDateTime2);
        return equal;
    }

    /**
     * 两个时间的比较:比较到时分秒
     */
    public static Boolean doEqualDate(Date date1,Date date2){
        if (ObjectUtils.isEmpty(date1) || ObjectUtils.isEmpty(date2)){
            return false;
        }
        LocalDate localDate1 = doExchengeLocalDate(date1);
        LocalDate localDate2 = doExchengeLocalDate(date2);
        boolean equal = localDate1.isEqual(localDate2);
        return equal;
    }

    /**
     * localDate与Date的转换
     */
    private static Date doExchenge(LocalDate localDate){
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * localDateTime与Date的转换
     */
    private static Date doExchenge(LocalDateTime localDate){
        return Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * localDateTime与Date的转换
     */
    private static LocalDateTime doExchenge(Date date){
        return LocalDateTime.ofInstant(date.toInstant(),ZoneId.systemDefault());
    }

    /**
     * localDate与Date的转换
     */
    private static LocalDate doExchengeLocalDate(Date date){
        return LocalDateTime.ofInstant(date.toInstant(),ZoneId.systemDefault()).toLocalDate();
    }

    //测试工具类
    public static void main(String[] args) {
        Date date = new Date();
        Date date1 = new Date();
        Date date2 = DateUtils.doChangeDate(date1, 0, 50);
        SimpleDateFormat format111 = new SimpleDateFormat(YEAR);
        String format = format111.format(date);
        System.out.println(format);
        System.out.println(DateUtils.doEqualDateTime(date, date2));

        System.out.println(getNowTime("date"));
    }
}