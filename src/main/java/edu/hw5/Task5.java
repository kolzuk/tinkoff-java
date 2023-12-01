package edu.hw5;

public class Task5 {
    private Task5() {
    }

    public static boolean IsValidSign(String sign) {
        return sign.matches("[АВЕКМНОРСТУХ][0-9]{3}[АВЕКМНОРСТУХ]{2}[0-9]{2,3}");
    }
}
