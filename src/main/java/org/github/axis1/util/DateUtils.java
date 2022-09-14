package org.github.axis1.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class DateUtils {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat sfs = new SimpleDateFormat("yyyyMMddHHmmss");
    public static SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static Date parse(String dateString) throws ParseException {
        return sdfs.parse(dateString);
    }

    public static String getToday() {
        //计算日期，计算1天前的时间
        Calendar s = Calendar.getInstance();
        String time = sfs.format(s.getTime());
        return time;
    }

    //获取昨天日期字符串 yyyy-MM-dd
    public static String getBefore1Day() {
        //计算日期，计算1天前的时间
        Calendar s = Calendar.getInstance();
        s.add(Calendar.DATE, -1);
        String time = sdf.format(s.getTime());
        return time;
    }


    //获取今天日期字符串 yyyy-MM-dd
    public static String getBeforeDay() {
        //计算日期，计算1天前的时间
        Calendar s = Calendar.getInstance();
        s.add(Calendar.DATE, 0);
        String time = sdf.format(s.getTime());
        return time;
    }

    //获取今天日期字符串 yyyy-MM-dd
    public static String getBeforeDay(int amount) {
        //计算日期，计算1天前的时间
        Calendar s = Calendar.getInstance();
        s.add(Calendar.DATE, amount);
        String time = sdf.format(s.getTime());
        return time;
    }


    //获取前2天日期字符串 yyyy-MM-dd
    public static String getBefore2Day() {
        //计算日期，计算1天前的时间
        Calendar s = Calendar.getInstance();
        s.add(Calendar.DATE, -2);
        String time = sdf.format(s.getTime());
        return time;
    }

    //获取前10天日期字符串 yyyy-MM-dd
    public static String getBefore10Day() {
        //计算日期，计算1天前的时间
        Calendar s = Calendar.getInstance();
        s.add(Calendar.DATE, -10);
        String time = sdf.format(s.getTime());
        return time;
    }

    //获取前35天日期字符串 yyyy-MM-dd
    public static String getBefore35Day() {
        //计算日期，计算1天前的时间
        Calendar s = Calendar.getInstance();
        s.add(Calendar.DATE, -35);
        String time = sdf.format(s.getTime());
        return time;
    }


    //转换日期格式
    public static String fomateDate(Date date) {
        //计算日期，计算1天前的时间
        String time = sdfs.format(date.getTime());
        return time;
    }

    //将指定日期转化为毫秒数
    public static long millisecondFromDate(String expireDate) {
        try {
            Date date = sdf.parse(expireDate);
            return date.getTime();
        } catch (ParseException e) {
            return 0;
        }
    }

    //将指定日期转化为毫秒数
    public static long millisecondFromDateTime(String expireDate) {
        try {
            Date date = sdfs.parse(expireDate);
            return date.getTime();
        } catch (ParseException e) {
            return 0;
        }
    }

    //整数(秒数)转换为时分秒格式(xx:xx:xx)
    public static String secToTime(int time) {
        String timeStr = null;

        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return "0秒";
        else {
            time = time / 1000;
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                if (time > 60) {
                    timeStr = minute + "分钟" + second + "秒";
                } else {
                    timeStr = time + "秒";
                }
            } else {
                hour = minute / 60;
                if (hour > 99)
                    return "99小时59分钟59秒";
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = hour + "小时" + minute + "分钟" + second + "秒";
            }
        }
        return timeStr;
    }


    /**
     * //整数(秒数)转换为时分秒格式(xx:xx:xx)四舍五入
     *
     * @param mSec
     * @return
     */
    public static String mSec2hms(Long mSec) {
        Long diffTime = mSec / 1000L;
        long modSen = (mSec % 1000) > 499 ? 1 : 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 2; i > 0; i--) {
            Long modTime = diffTime % 60;
            if (i % 2 == 0) {
                modTime += modSen;
            }
            if (modTime > 0) {
                stringBuilder.insert(0, modTime + (i % 2 == 1 ? "分钟" : "秒"));
            }
            diffTime /= 60;
        }
        if (diffTime > 0) {
            stringBuilder.insert(0, diffTime + "小时");
        }
        if (stringBuilder.length() == 0) {
            stringBuilder.append("0秒");
        }
        return stringBuilder.toString();
    }


    //日期加一天
    public static String getTM(String time) throws ParseException {
        Calendar cd = Calendar.getInstance();
        cd.setTime(sdf.parse(time));
        cd.add(Calendar.DATE, 1);
        return sdf.format(cd.getTime());
    }

    /**
     * 获取两个日期之间的所有日期
     * @param start
     * @param end
     * @return
     */
    private static List<Date> getDays(Date start, Date end) {
        List<Date> result = new ArrayList<Date>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);
        tempStart.add(Calendar.DAY_OF_YEAR, 1);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        while (tempStart.before(tempEnd)) {
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        return result;
    }

    /**
     * 获取两个日期之间的所有日期
     * @param startTime
     * @param endTime
     * @return
     */
    public static List<String> getDays(String startTime, String endTime) {
        return getDays(startTime,endTime,"yyyy-MM-dd");
    }
    /**
     * 获取两个日期之间的所有日期
     * @param startTime
     * @param endTime
     * @return
     */
    public static List<String> getDays(String startTime, String endTime, String fmt) {

        // 返回的日期集合
        List<String> days = new ArrayList<String>();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat1 = new SimpleDateFormat(fmt);
        try {
            Date start = dateFormat.parse(startTime);
            Date end = dateFormat.parse(endTime);

            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);

            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            tempEnd.add(Calendar.DATE, +1);// 日期加1(包含结束)
            while (tempStart.before(tempEnd)) {
                days.add(dateFormat1.format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return days;
    }

}
