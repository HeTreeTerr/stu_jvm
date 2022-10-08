package com.hss.stuDate.localDate;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class StuLocalDate {

    public static void main(String[] args) {
        StuLocalDate stuLocalDate = new StuLocalDate();
//        stuLocalDate.test1();
//        stuLocalDate.test2();
//        stuLocalDate.test3();
//        stuLocalDate.test4();
//        stuLocalDate.test5();
        stuLocalDate.test6();
    }

    /**
     * 创建LocalDateTime时间
     * 查看和基本修改
     */
    public void test1(){
//        从默认时区的系统时钟获取当前的日期时间。不用考虑时区差
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
//        获取时间详情
        System.out.println(dateTime.getYear());
        System.out.println(dateTime.getMonthValue());
        System.out.println(dateTime.getDayOfMonth());
        System.out.println(dateTime.getHour());
        System.out.println(dateTime.getMinute());
        System.out.println(dateTime.getSecond());
        System.out.println(dateTime.getNano());

//       手动创建一个LocalDateTime实例
        LocalDateTime dateTime2 = LocalDateTime
                .of(1998, 06, 21, 0, 0, 0, 0);
        System.out.println(dateTime2);

//       进行加操作，得到新的日期实例
        LocalDateTime dateTime3 = dateTime2.plusDays(12);
        System.out.println(dateTime3);
//       进行减操作，得到新的日期实例
        LocalDateTime dateTime4 = dateTime3.minusYears(2);
        System.out.println(dateTime4);
    }

    /**
     * 获取时间戳（时区）
     */
    public void test2(){
//        时间戳  1970年1月1日00：00：00 到某一个时间点的毫秒值（默认获取UTC）
        System.out.println(Instant.now());
        System.out.println(Instant.now().toEpochMilli());
//        获取时间戳(默认获取UTC)
        System.out.println(System.currentTimeMillis());
//        将所得时间倒退8小时后，得到时间戳
        System.out.println(LocalDateTime.now()
                .toInstant(ZoneOffset.of("+08")).toEpochMilli());
        System.out.println(Instant.now()
                .atOffset(ZoneOffset.ofHours(8)).toInstant().toEpochMilli());
    }

    /**
     * 获取时间差
     */
    public void test3(){
        System.out.println("------------Instant时间间隔----------");
        Instant instant1 = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant instant2 = Instant.now();
        Duration duration = Duration.between(instant1, instant2);
        System.out.println(duration.toMillis());

        System.out.println("------------LocalTime时间间隔----------");
        LocalTime localTime1 = LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime localTime2 = LocalTime.now();
        Duration duration1 = Duration.between(localTime1, localTime2);
        System.out.println(duration1.toMillis());

        System.out.println("------------LocalDateTime时间间隔----------");
        LocalDateTime localDateTime1 = LocalDateTime.now(ZoneId.of("UTC+8"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalDateTime localDateTime2 = LocalDateTime.now(ZoneId.of("UTC+8"));
        Duration duration2 = Duration.between(localDateTime1, localDateTime2);
        System.out.println(duration2.toMillis());

        System.out.println("------------LocalDate日期间隔----------");
        LocalDate localDate1 = LocalDate.ofYearDay(2021,100);
        LocalDate localDate2 = LocalDate.ofYearDay(2021,151);
        Period period = Period.between(localDate1, localDate2);
        System.out.println(period);
    }

    /**
     * 获取特殊的指定日期
     */
    public void test4(){
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("UTC+8"));
        System.out.println(localDateTime);

//        获取本年第一天
        LocalDateTime withDayOfYear = localDateTime.withDayOfYear(1);
        System.out.println(withDayOfYear);
//        获取本月第一天
        LocalDateTime withDayOfMonth = localDateTime.withDayOfMonth(1);
        System.out.println(withDayOfMonth);
//        获取下一个周五的日期
        LocalDateTime nextFriday = localDateTime
                .with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println(nextFriday);

//       获取下一个工作日
        LocalDateTime nextWorkDay = localDateTime.with((t) -> {
            LocalDateTime ldt = (LocalDateTime)t;
//            获取今天式星期n
            DayOfWeek dayOfWeek = ldt.getDayOfWeek();
            if (DayOfWeek.FRIDAY.equals(dayOfWeek)){
//                周五加3天
                return ldt.plusDays(3);
            }
            else if (DayOfWeek.SATURDAY.equals(dayOfWeek)){
//                周六加2天
                return ldt.plusDays(2);
            }
            else {
//                其余是明天
                return ldt.plusDays(1);
            }
        });
        System.out.println(nextWorkDay);
    }

    /**
     * 日期格式化
     */
    public void test5(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("---------------LocalDateTime转string-------------");
//        自定义格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(localDateTime));
        System.out.println(localDateTime.format(formatter));
//        api格式
        DateTimeFormatter formatter2 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        System.out.println(formatter2.format(localDateTime));
        System.out.println(localDateTime.format(formatter2));

        System.out.println("---------------string转LocalDateTime-------------");
        String dateStr = "1998-06-21 00:00:00";
        LocalDateTime localDateTime1 = LocalDateTime.parse(dateStr, formatter);
        System.out.println(localDateTime1);

        System.out.println("---------------时间戳转LocalDateTime-------------");
        long second = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).getEpochSecond();
        // 将时间戳转为当前时间
        System.out.println(LocalDateTime.ofEpochSecond(second, 0, ZoneOffset.ofHours(8)));

    }

    /**
     * 时区
     */
    public void test6(){
//        创建时间时指定时区
        LocalDateTime dateTime = LocalDateTime
                .now(ZoneId.of("Asia/Shanghai"));
        System.out.println(dateTime);

        LocalDateTime dateTime1 = LocalDateTime.now();
        ZonedDateTime zdt = dateTime1
                .atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zdt);
//        获取可用区域id
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.stream().forEach(System.out::println);
    }
}
