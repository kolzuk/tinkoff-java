package edu.hw1;

import java.util.Objects;

public final class Task1 {
    private static final int SECONDS_PER_MINUTE = 60;

    private Task1() {
    }

    public static int minutesToSeconds(String videoLength) {
        Objects.requireNonNull(videoLength);

        int colonPosition = videoLength.indexOf(':');

        String minutes = videoLength.substring(0, colonPosition);
        String second = videoLength.substring(colonPosition + 1);

        int iMinutes = Integer.parseInt(minutes);
        int iSeconds = Integer.parseInt(second);

        if (iSeconds >= SECONDS_PER_MINUTE) {
            return -1;
        }

        return iMinutes * SECONDS_PER_MINUTE + iSeconds;
    }
}
