package edu.hw8.Task2;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadPoolThread extends Thread {
    private AtomicBoolean isRun;
    private ConcurrentLinkedQueue<Runnable> tasks;

    ThreadPoolThread(AtomicBoolean isEnd, ConcurrentLinkedQueue<Runnable> tasks) {
        this.isRun = isEnd;
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (isRun.get()) {
            if (tasks.isEmpty()) {
                continue;
            }

            Runnable task = tasks.remove();
            task.run();
        }
    }
}
