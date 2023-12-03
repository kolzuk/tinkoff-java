package edu.hw8.Task2;

public interface ThreadPool extends AutoCloseable {
    void start() throws Exception;
    void execute(Runnable runnable);
}
