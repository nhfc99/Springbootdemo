package com.nhfc99.template.utils;

import org.joda.time.DateTime;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String YMD_HMS = "yyyy-MM-dd HH:mm:ss";
    /**
     * yyyyMMddHHmmss
     */
    public static final String YMDHMS = "yyyyMMddHHmmss";
    public static final String YMDHMSSS = "yyyyMMddHHmmssSSS";
    /**
     * yyyyMMdd
     */
    public static final String YMD = "yyyyMMdd";
    /**
     * yyyy-MM
     */
    public static final String YM = "yyyy-MM";
    /**
     * MMdd
     */
    public static final String MD = "MMdd";
    public static final String D = "dd";
    /**
     * MM-dd
     */
    public static final String MD_DASH = "MM-dd";
    /**
     * yyyy/MM/dd
     */
    public static final String YMD_SLASH = "yyyy/MM/dd";
    /**
     * yyyy-MM-dd
     */
    public static final String YMD_DASH = "yyyy-MM-dd";
    /**
     * yyyy-MM-dd H:m
     */
    public static final String YMD_DASH_WITH_TIME = "yyyy-MM-dd H:m";
    /**
     * yyyy-MM-dd HH:mm
     */
    public static final String DATETIME_YMD_DASH = "yyyy-MM-dd HH:mm";
    /**
     * yyyy/dd/MM
     */
    public static final String YDM_SLASH = "yyyy/dd/MM";
    /**
     * yyyy/MM/dd HH:mm:ss
     */
    public static final String YMD_SLAHMS = "yyyy/MM/dd HH:mm:ss";
    /**
     * yyyy-dd-MM
     */
    public static final String YDM_DASH = "yyyy-dd-MM";
    /**
     * HHmm
     */
    public static final String HM = "HHmm";
    /**
     * HH:mm
     */
    public static final String HM_COLON = "HH:mm";
    /**
     * HH:mm:ss
     */
    public static final String HMS_COLON = "HH:mm:ss";
    /**
     * yyyy-MM
     */
    public static final String YM_DASH = "yyyy-MM";
    /**
     * yyyy年MM月dd日
     */
    public static final String YMD_NYRSH = "yyyy年MM月dd日";

    public static final String YMDH_M_S = "yyyyMMdd HH:mm:ss";

    public static final String HH_ONLY = "HH";
    public static final long DAY = 24 * 60 * 60 * 1000L;
    public static final long MINUTE = 60 * 1000L;
    public static final long SECOND = 1000L;

    private static final Map<String, DateFormat> DFS = new HashMap<String, DateFormat>();

    /**
     * 得到系统日期
     *
     * @return ""
     */
    public static String getSysdate() {
        Date sysDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(YMD_DASH);
        return sdf.format(sysDate);
    }

    /**
     * 获取当前时间的时间戳（精确到秒）
     *
     * @return ""
     */
    public static String getCurrentTimeStamp() {
        return String.valueOf(new Date().getTime() / 1000L);
    }

    /**
     * 获取当前时间的时间戳（精确到毫秒）
     *
     * @return ""
     */
    public static Long getCurrentTimeStamps() {
        return new Date().getTime();
    }

    /**
     * 将指定的日期格式字符串转换为时间戳(精确到秒)
     *
     * @param date    日期字符串
     * @param pattern 日期格式
     * @return ""
     */
    public static String date2TimeStamp(String date, String pattern) {
        try {
            SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
            Date s = dateformat.parse(date);
            return String.valueOf(s.getTime() / 1000L);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取指定时间的时间戳（精确到毫秒）
     *
     * @param date
     * @return ""
     */
    public static Long getTimeStampsByDate(Date date) {
        return date.getTime();
    }

    /**
     * 当前日期的前N天或后N天的时间戳(精确到秒)
     *
     * @param days 当为负整数时，为前N天，当为正整数时，为后N天
     * @return ""
     */
    public static String getCurrentDayTime(int days) {
        return getDayTime(days);
    }

    /**
     * 指定日期的前N天或后N天的时间戳(精确到秒)
     *
     * @param date 指定日期
     * @param days 当为负整数时，为前N天，当为正整数时，为后N天
     * @return ""
     */
    public static String getDayTime(Date date, int days) {
        String dateStr = format(dayOffset(date, days), YMD_HMS);
        return date2TimeStamp(dateStr, YMD_HMS);
    }

    /**
     * 获取指定日期最后一秒的时间戳（精确到秒）
     *
     * @return ""
     */
    public static String getTimeDayLastSecond(Date date) {
        if (date == null) {
            return null;
        }
        return date2TimeStamp(format(date, YMD_DASH).concat(" 23:59:59"), YMD_HMS);
    }

    /**
     * 根据日期格式 对指定日期格式化
     *
     * @param date
     * @param pattern
     * @return ""
     */
    public static Date formatDate(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        return parse(format(date, pattern), pattern);
    }

    /**
     * 获取指定日期最后一秒的日期
     *
     * @param date
     * @return ""
     */
    public static Date getEndDate(Date date) {
        if (date == null) {
            return null;
        }
        return parse((format(date, YMD_DASH) + " 23:59:59"), YMD_HMS);
    }

    /**
     * 将指定的时间戳字符串转换为指定日期格式字符串
     *
     * @param timestampStr 时间戳字符串（精确到秒）
     * @param pattern      日期时间格式
     * @return ""
     */
    public static String timeStampToDate(String timestampStr, String pattern) {
        if (StringUtils.isEmpty(timestampStr)) return null;
        Long timestamp = Long.parseLong(timestampStr) * 1000;
        String date = new SimpleDateFormat(pattern).format(new Date(timestamp));
        return date;
    }

    /**
     * 将指定的时间戳字符串转换为日期
     *
     * @param timestampStr 时间戳字符串（精确到秒）
     * @return ""
     */
    public static Date timeStampToDate(String timestampStr) {
        Long timestamp = Long.parseLong(timestampStr) * 1000;
        return new Date(timestamp);
    }


    /**
     * 将指定日期的字符串 按格式转换成日期
     *
     * @param dateStr 日期字符串
     * @param pattern 日期格式
     * @return ""
     */
    public static Date parse(String dateStr, String pattern) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        Date date;
        try {
            date = getFormat(pattern).parse(dateStr);
        } catch (ParseException e) {
            e.getStackTrace();
            return null;
        }
        return date;
    }

    /**
     * 将指定日期按照日期格式转换成日期字符串
     *
     * @param date    指定日期
     * @param pattern 日期格式
     * @return ""
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        return getFormat(pattern).format(date);
    }

    /**
     * 按日期格式要求，输出DateFormat格式
     *
     * @param pattern
     * @return ""
     */
    public static DateFormat getFormat(String pattern) {
        DateFormat format = DFS.get(pattern);
        if (format == null) {
            format = new SimpleDateFormat(pattern);
            DFS.put(pattern, format);
        }
        return format;
    }

    /**
     * 判断输入的年、月、日是否是有效日期
     *
     * @param year
     * @param month (1-12)
     * @param day   (1-31)
     * @return ""
     */
    public static boolean isValid(int year, int month, int day) {
        if (month > 0 && month < 13 && day > 0 && day < 32) {
            int mon = month - 1;
            Calendar calendar = new GregorianCalendar(year, mon, day);
            if (calendar.get(Calendar.YEAR) == year && calendar.get(Calendar.MONTH) == mon && calendar.get(Calendar.DAY_OF_MONTH) == day) {
                return true;
            }
        }
        return false;
    }

    /**
     * 将指定日期转换为日历格式的日期对象
     *
     * @param date
     * @return ""
     */
    private static Calendar convert(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * 返回指定日期按年份【前移】或【后移】后的日期
     *
     * @param date   指定日期
     * @param offset 当为正整数，则后移，当为负整数，则前移
     * @return ""
     */
    public static Date yearOffset(Date date, int offset) {
        return offsetDate(date, Calendar.YEAR, offset);
    }

    /**
     * 回指定日期按月份【前移】或【后移】后的日期
     *
     * @param date   指定日期
     * @param offset 当为正整数，则后移，当为负整数，则前移
     * @return ""
     */
    public static Date monthOffset(Date date, int offset) {
        return offsetDate(date, Calendar.MONTH, offset);
    }

    /**
     * 返回指定日期按天数【前移】或【后移】后的日期
     *
     * @param date   指定日期
     * @param offset 当为正整数，则后移，当为负整数，则前移
     * @return ""
     */
    public static Date dayOffset(Date date, int offset) {
        return offsetDate(date, Calendar.DATE, offset);
    }

    /**
     * 返回指定日期按小时数【前移】或【后移】后的日期
     *
     * @param date   指定日期
     * @param offset 当为正整数，则后移，当为负整数，则前移
     * @return ""
     */
    public static Date hoursOffset(Date date, int offset) {
        return offsetDate(date, Calendar.HOUR, offset);
    }

    /**
     * 返回指定日期按分钟数【前移】或【后移】后的日期
     *
     * @param date   指定日期
     * @param offset 当为正整数，则后移，当为负整数，则前移
     * @return ""
     */
    public static Date minuteOffset(Date date, int offset) {
        return offsetDate(date, Calendar.MINUTE, offset);
    }

    /**
     * 返回指定日期按秒数【前移】或【后移】后的日期
     *
     * @param date   指定日期
     * @param offset 当为正整数，则后移，当为负整数，则前移
     * @return ""
     */
    public static Date secondOffset(Date date, int offset) {
        return offsetDate(date, Calendar.SECOND, offset);
    }

    /**
     * 返回指定日期按指定方式【前移】或【后移】后的日期<
     *
     * @param date   指定日期
     * @param field  指定方式，如：Calendar.YEAR 按年份，Calendar.MONTH 按月份，Calendar.DATE 按天数
     * @param offset 当为正整数，则后移，当为负整数，则前移
     * @return ""
     */
    public static Date offsetDate(Date date, int field, int offset) {
        Calendar calendar = convert(date);
        calendar.add(field, offset);
        return calendar.getTime();
    }

    /**
     * 返回指定日期所在当月的第一天的日期
     *
     * @param date
     * @return ""
     */
    public static Date firstDay(Date date) {
        Calendar calendar = convert(date);
        calendar.set(Calendar.DATE, 1);
        return calendar.getTime();
    }

    /**
     * 返回指定日期所在当月的最后一天的日期
     *
     * @param date
     * @return ""
     */
    public static Date lastDay(Date date) {
        Calendar calendar = convert(date);
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        return calendar.getTime();
    }

    /**
     * 返回两个日期间的差异天数
     *
     * @param date1 参照日期
     * @param date2 比较日期
     * @return "" 参照日期与比较日期之间的天数差异，正数表示参照日期在比较日期之后，0表示两个日期同天，负数表示参照日期在比较日期之前 int
     */
    public static int dayDiff(Date date1, Date date2) {
        long diff = date1.getTime() - date2.getTime();
        return (int) (diff / DAY);
    }

    /**
     * 返回两个日期间的差异月数
     *
     * @param date1 参照日期
     * @param date2 比较日期
     * @return "" int
     */
    public static int monthDiff(Date date1, Date date2) {
        Calendar c1 = convert(date1);
        Calendar c2 = convert(date2);
        int years = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        int months = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        return years * 12 + months;
    }

    /**
     * 返回两个日期间的差异月数<br />
     *
     * @param date1
     * @param date2
     * @return "" int
     */
    public static int monthAfterDiff(Date date1, Date date2) {
        int flag = 0;
        Calendar c1 = convert(date1);
        Calendar c2 = convert(date2);

        int years = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        int months = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        if (isEndOfMonth(c1) && isEndOfMonth(c2)) {
            flag = 0;
        } else {
            if (c1.get(Calendar.DAY_OF_MONTH) > c2.get(Calendar.DAY_OF_MONTH)) {
                flag = 0;
            } else if (c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH)) {
                flag = 0;
            } else {
                flag = 1;
            }
        }
        return years * 12 + months + flag;
    }

    /**
     * 判断这一天是否是月底
     *
     * @param calendar
     * @return "" boolean
     * @version 0.1 2015年6月3日
     */
    public static boolean isEndOfMonth(Calendar calendar) {
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        if (dayOfMonth == calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
            return true;
        return false;
    }

    /**
     * 返回两个日期间的差异天数--方法2，按天计算；| 上面是按24小时的倍数计算的；
     *
     * @param date1 参照日期
     * @param date2 比较日期
     * @return "" 参照日期与比较日期之间的天数差异，正数表示参照日期在比较日期之后，0表示两个日期同天，负数表示参照日期在比较日期之前 int
     * @throws ParseException
     */
    public static int dayDiffByDay(Date date1, Date date2) throws ParseException {
        // 日期时间转换为年月日
        String startStr = DateUtils.format(date1, DateUtils.YMD_DASH);
        Date startDate = DateUtils.parse(startStr, DateUtils.YMD_DASH);
        String endStr = DateUtils.format(date2, DateUtils.YMD_DASH);
        Date endDate = DateUtils.parse(endStr, DateUtils.YMD_DASH);
        long diff = startDate.getTime() - endDate.getTime();
        return (int) (diff / DAY);
    }

    /**
     * 返回两个日期间的差异分钟数
     *
     * @param date1 参照日期
     * @param date2 比较日期
     * @return "" 参照日期与比较日期之间的分钟数差异，正数表示参照日期在比较日期之后，0表示两个日期同分，负数表示参照日期在比较日期之前 int
     * @version 0.1 2013年10月30日
     */
    public static int minuteDiff(Date date1, Date date2) {
        long diff = date1.getTime() - date2.getTime();
        return (int) (diff / MINUTE);
    }

    /**
     * 返回两个日期间的差异秒数
     *
     * @param date1 参照日期
     * @param date2 比较日期
     * @return "" 参照日期与比较日期之间的秒数差异，正数表示参照日期在比较日期之后，0表示两个日期同分，负数表示参照日期在比较日期之前 int
     */
    public static int secondDiff(Date date1, Date date2) {
        long diff = date1.getTime() - date2.getTime();
        return (int) (diff / SECOND);
    }

    /**
     * 将指定日期转换为小时数
     *
     * @param date
     * @return "" Double
     */
    public static Double hour(Date date) {
        SimpleDateFormat st = new SimpleDateFormat("yyyyMMddHH");
        return Double.parseDouble(st.format(date));
    }

    /**
     * 获取当月的最后一天是几号
     *
     * @return "" int
     */
    public static int getMonthDays() {
        Calendar calendar = Calendar.getInstance();
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return maxDay;
    }

    /**
     * 获取今天是几号
     *
     * @return "" int
     */
    public static int getDateByDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取今天是几月
     *
     * @return "" int
     */
    public static int getMonthByDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取今天是那年
     *
     * @return "" int
     */
    public static int getYearByDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取指定日期是星期几
     *
     * @param date 指定日期
     * @return "" String
     */
    public static String getWeekOfDate(Date date) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
     * Description:获取给定日期当月的工作日集合
     *
     * @param year  指定年份
     * @param month 指定月份
     * @return "" List<Date>
     */
    public static List<Date> getDates(int year, int month) {
        List<Date> dates = new ArrayList<Date>();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DATE, 1);
        while (cal.get(Calendar.YEAR) == year && cal.get(Calendar.MONTH) < month) {
            int day = cal.get(Calendar.DAY_OF_WEEK);
            if (!(day == Calendar.SUNDAY || day == Calendar.SATURDAY)) {
                dates.add((Date) cal.getTime().clone());
            }
            cal.add(Calendar.DATE, 1);
        }
        return dates;

    }

    /**
     * 取得当月天数
     *
     * @return "" int
     */
    public static int getCurrentMonthLastDay() {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 得到指定月的天数
     *
     * @param year  指定年份
     * @param month 指定月份
     * @return "" int
     */
    public static int getMonthLastDay(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    private static Calendar getCalendar() {
        TimeZone tz = TimeZone.getDefault();
        return Calendar.getInstance(tz);
    }

    public static String getYear() {
        return String.valueOf(getCalendar().get(1));
    }

    public static String getMonth() {
        return strFormat(getCalendar().get(2) + 1);
    }

    public static String getDay() {
        return strFormat(getCalendar().get(5));
    }

    public static String getFormatDate(String separator) {
        return getYear() + separator + getMonth() + separator + getDay();
    }

    public static String getHour() {
        return strFormat(getCalendar().get(11));
    }

    public static String getMinute() {
        return strFormat(getCalendar().get(12));
    }

    public static String getSecond() {
        return strFormat(getCalendar().get(13));
    }


    private static String strFormat(int data) {
        String str = String.valueOf(data);
        if (data <= 9) {
            str = "0" + str;
        }
        return str;
    }


    public static String getDayTime(int days) {
        Calendar cal = Calendar.getInstance();
        cal.add(6, days);
        String timeStamp = String.valueOf(cal.getTimeInMillis() / 1000L);
        return timeStamp;
    }

    /**
     * 获取某天的某个时间点
     *
     * @param date
     * @param hour
     * @param minute
     * @param second
     * @return ""
     */
    public static Date getDateByTime(Date date, int hour, int minute, int second) {
        DateTime dateTime = new DateTime(date);
        date.setHours(hour);
        date.setMinutes(minute);
        date.setSeconds(second);
        return date;
    }

    /**
     * 判断指定时间是否在某个时间段内
     *
     * @param nowTime   指定时间
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return ""
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);
        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 比较两个日期的大小（仅比较天，即精确到天）
     *
     * @param date1
     * @param date2
     * @return "" 返回值 （1,0，-1）
     */
    public static int compareDate(Date date1, Date date2) throws Exception {
        if (date1 == null || date2 != null) {
            throw new Exception("比较日期不能为空");
        }
        date1 = parse(format(date1, YMD_DASH), YMD_DASH);
        date2 = parse(format(date2, YMD_DASH), YMD_DASH);
        return date1.compareTo(date2);
    }

    /**
     * 比较两个日期的大小（精确到时间）
     *
     * @param date1
     * @param date2
     * @return "" 返回值 （1,0，-1）
     * @throws Exception
     */
    public static int compareTime(Date date1, Date date2) throws Exception {
        if (date1 == null || date2 != null) {
            throw new Exception("比较日期不能为空");
        }
        return date1.compareTo(date2);
    }
}