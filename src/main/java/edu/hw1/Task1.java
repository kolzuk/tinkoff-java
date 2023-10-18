package edu.hw1;

import java.util.Objects;

public final class Task1 {
    private static final int SECONDS_PER_MINUTE = 60;

    private Task1() {
    }

    public static int minutesToSeconds(String videoLength) {
        Objects.requireNonNull(videoLength);

        int colonPosition = videoLength.indexOf(':');

        String[] videoPieces = videoLength.split(":");

        if (videoPieces.length != 2) {
            return -1;
        }

        String minutes = videoPieces[0];
        String second = videoPieces[1];

        // Negative is checking too
        if (!minutes.matches("[0-9]+")
                || !second.matches("[0-9]+")) {
            return -1;
        }
        int iMinutes = Integer.parseInt(minutes);
        int iSeconds = Integer.parseInt(second);

        if (iSeconds >= SECONDS_PER_MINUTE) {
            return -1;
        }

        return iMinutes * SECONDS_PER_MINUTE + iSeconds;
    }
}
