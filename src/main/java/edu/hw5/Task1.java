package edu.hw5;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Task1 {
    private final static String datePattern = "yyyy-MM-dd, HH:mm";
    private Task1() {
    }

    private static Duration getDurationOfSession(String session) {
        String[] time = session.split(" - ");

        LocalDateTime beginTime = LocalDateTime.parse(time[0],
                DateTimeFormatter.ofPattern(datePattern));
        LocalDateTime endTime = LocalDateTime.parse(time[1],
                DateTimeFormatter.ofPattern(datePattern));

        return Duration.between(beginTime, endTime);
    }

    public static Duration getAverageTimeOfSession(String[] sessions) {
        Duration duration = Duration.ZERO;

        for (String session : sessions) {
            duration = duration.plus(getDurationOfSession(session));
        }

        return duration.dividedBy(sessions.length);
    }
}
