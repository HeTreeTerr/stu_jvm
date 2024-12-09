package com.hss.stuDate.localDate.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
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
        LocalDate startDate = LocalDate.of(2024, 12, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 9);

        getWeeklyRanges(startDate, endDate);
    }

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

            System.out.println("周开始: " + weekStart + ", 周结束: " + weekEnd);

            // 移动到下一周
            currentDate = weekEnd.plusDays(1);
        }
    }

    public static LocalDate getWeekStart(LocalDate date) {
        return date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
    }

    public static LocalDate getWeekEnd(LocalDate weekStart) {
        return weekStart.plusDays(6);
    }
}
