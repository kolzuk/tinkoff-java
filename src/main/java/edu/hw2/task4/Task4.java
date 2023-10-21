package edu.hw2.task4;

public class Task4 {
    private final static int PENULT_STACK_TRACE_ELEMENT_INDEX = 1;

    private Task4() {}

    public static CallingInfo callingInfo() {
        StackTraceElement[] methods = new Throwable().getStackTrace();

        String[] classNameWithPackage
                = methods[PENULT_STACK_TRACE_ELEMENT_INDEX]
                .getClassName()
                .split("\\.|\\$1");

        String className = classNameWithPackage[classNameWithPackage.length - 1];
        String methodName = methods[PENULT_STACK_TRACE_ELEMENT_INDEX].getMethodName();

        return new CallingInfo(className, methodName);
    }
}
