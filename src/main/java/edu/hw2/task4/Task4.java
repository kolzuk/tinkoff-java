package edu.hw2.task4;

import jdk.jfr.StackTrace;

import java.util.Arrays;

public class Task4 {
    public static CallingInfo callingInfo() {
        StackTraceElement[] methods = new Throwable().getStackTrace();

        String[] stringMethods = methods[1].toString().split("[\\.\\(\\)]");

        int n = stringMethods.length;

        String methodName = stringMethods[n - 3];
        String className = stringMethods[n - 2];

        return new CallingInfo(className, methodName);
    }
}
