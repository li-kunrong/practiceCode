package com.crc.aboutTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class IsBelongToDuringTime {
    public static void main(String []args) {
        Date now = new Date();
        IsBelongToDuringTime isBelongToDuringTime = new IsBelongToDuringTime();
        isBelongToDuringTime.isBelong(now);
    }

    public boolean isBelong(Date now){
        System.out.println(now);

        SimpleDateFormat df = new SimpleDateFormat("HH:mm");//设置日期格式

       // Date now =null;
        Date beginTime = null;
        Date endTime = null;
        try {
            now = df.parse(df.format(new Date()));
            Date date = df.parse( "22:00" );
            now = df.parse(df.format(date));
            System.out.println(now);
            beginTime = df.parse("8:00");
            endTime = df.parse("20:00");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Boolean flag = belongCalendar(now, beginTime, endTime);
        System.out.println(flag);
        return flag;
    }


    /**
     * 判断时间是否在时间段内
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
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
}
