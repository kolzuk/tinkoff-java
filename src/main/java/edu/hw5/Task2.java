package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;

public class Task2 {
    private final static int THIRTEEN = 13;
    private Task2() {
    }

    public static LocalDate[] findAll13Fridays(int year) {
        ArrayList<LocalDate> all13Fridays = new ArrayList<>();

        for (Month month : Month.values()) {
            LocalDate date = LocalDate.of(year, month, THIRTEEN);

            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                all13Fridays.add(date);
            }
        }

        return all13Fridays.toArray(new LocalDate[0]);
    }

    public static LocalDate findNext13Friday(LocalDate date) {
        TemporalAdjuster next_13_friday = TemporalAdjusters.ofDateAdjuster(
                localDate -> {
                    do {
                        localDate = localDate.plusDays(1);
                    } while (localDate.getDayOfWeek() != DayOfWeek.FRIDAY
                            || localDate.getDayOfMonth() != THIRTEEN);

                    return localDate;
                });

        return date.with(next_13_friday);
    }
}
