package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;

public final class Task3 {
    private final static String YESTERDAY = "yesterday";
    private final static String TODAY = "today";
    private final static String TOMORROW = "tomorrow";
    private Task3() {
    }

    private static boolean isValidYear(String year) {
        return year.matches("[0-9]+");
    }

    private static boolean isValidMonth(String month) {
        return month.matches("[1-9]|1[0-2]");
    }
    private static boolean isValidDay(String day) {
        return day.matches("[1-9]|1[0-9]|2[0-9]|3[0-1]");
    }

    private static boolean isValidDate(String year, String month, String day) {
        return isValidYear(year) && isValidMonth(month) && isValidDay(day);
    }

    public static Optional<LocalDate> parseDate(String date) {
        Optional<LocalDate> ans = Optional.empty();

        date = date.toLowerCase();

        switch (date) {
            case YESTERDAY -> {
                return Optional.of(LocalDate.now().minusDays(1));
            }
            case TODAY -> {
                return Optional.of(LocalDate.now());
            }
            case TOMORROW -> {
                return Optional.of(LocalDate.now().plusDays(1));
            }
        }

        if (date.matches(".{1,4}-.{1,2}-.{1,2}")) {
            String[] times = date.split("-");

            if (times.length != 3) {
                return Optional.empty();
            }

            if (isValidDate(times[0], times[1], times[2])) {
                return Optional.of(LocalDate.of(
                        Integer.parseInt(times[0]),
                        Integer.parseInt(times[1]),
                        Integer.parseInt(times[2])));
            } else {
                return Optional.empty();
            }
        }

        if (date.matches(".{1,2}/.{1,2}/.{1,4}")) {
            String[] times = date.split("/");

            if (times.length != 3) {
                return Optional.empty();
            }

            if (isValidDate(times[2], times[1], times[0])) {
                return Optional.of(LocalDate.of(
                        Integer.parseInt(times[2]),
                        Integer.parseInt(times[1]),
                        Integer.parseInt(times[0])));
            } else {
                return Optional.empty();
            }
        }

        if (date.matches("[1-9]+ days? ago|[1-9]")) {
            String[] times = date.split(" ");
            return Optional.of(LocalDate.now().minusDays(Integer.parseInt(times[0])));
        }

        return Optional.empty();
    }
}
