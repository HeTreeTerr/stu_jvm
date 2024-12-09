package com.hss.stuDate.localDate.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * <p>
 *  计算时间段内的周信息
 * </p>
 *
 * @author Hss
 * @date 2024-12-09
 */
public class WeeklyRange {

    public static void main(String[] args) {
        // 示例：获取2023年1月1日至2023年12月31日每周的开始和结束时间
        LocalDate startDate = LocalDate.of(2024, 11, 2);
        LocalDate endDate = LocalDate.of(2024, 12, 9);

        getWeeklyRanges(startDate, endDate);
    }

    /**
     * 计算时间段内的周信息
     * @param startDate
     * @param endDate
     */
    public static void getWeeklyRanges(LocalDate startDate, LocalDate endDate) {
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            LocalDate weekStart = getWeekStart(currentDate);
            LocalDate weekEnd = getWeekEnd(weekStart);

            // 检查是否超出endDate
            if (weekEnd.isAfter(endDate)) {
                weekEnd = endDate;
            }
            // 检查是否小于startDate
            if(weekStart.isBefore(startDate)){
                weekStart = startDate;
            }

            //开始时间等于周一
            if(1 == weekStart.getDayOfWeek().getValue()){
                //每周时间大于等于5天
                if(ChronoUnit.DAYS.between(weekStart,weekEnd) >= 5){
                    System.out.println("周开始: " + weekStart + ", 周结束: " + weekEnd.plusDays(-2));
                }
            }

            // 移动到下一周
            currentDate = weekEnd.plusDays(1);
        }
    }

    /**
     * 获取一周的周一
     * @param date
     * @return
     */
    public static LocalDate getWeekStart(LocalDate date) {
        return date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
    }

    /**
     * 获取一周的周日
     * @param weekStart
     * @return
     */
    public static LocalDate getWeekEnd(LocalDate weekStart) {
        return weekStart.plusDays(6);
    }
}
