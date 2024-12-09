package com.hss.stuDate.localDate.util;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

/**
 * <p>
 *  计算时间段内的月信息
 * </p>
 *
 * @author Hss
 * @date 2024-12-09
 */
public class MonthRange {

    public static void main(String[] args) {
        // 示例：获取2023年1月1日至2023年12月31日每周的开始和结束时间
        LocalDate startDate = LocalDate.of(2024, 5, 15);
        LocalDate endDate = LocalDate.of(2024, 12, 9);

        getMonthRanges(startDate, endDate);
    }

    /**
     * 计算时间段内的月信息
     * @param startDate
     * @param endDate
     */
    public static void getMonthRanges(LocalDate startDate, LocalDate endDate){
        LocalDate currentDate = startDate;

        while (endDate.isAfter(currentDate)){
            LocalDate monthStart = currentDate;
            LocalDate monthEnd = currentDate.plusDays(YearMonth.from(currentDate).lengthOfMonth());

            //区间结束时间晚于比赛时间
            if(monthEnd.isAfter(endDate)){
                monthEnd = endDate;
            }

            //区间时间大于等于15
            if(ChronoUnit.DAYS.between(monthStart,monthEnd) >= 15){
                System.out.println("周开始: " + monthStart + ", 周结束: " + monthEnd);
            }

            currentDate = monthEnd;
        }

    }
}
