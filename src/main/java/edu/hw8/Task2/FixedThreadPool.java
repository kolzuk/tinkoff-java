package edu.hw8.Task2;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class FixedThreadPool implements ThreadPool {
    private final Thread[] threads;
    private final ConcurrentLinkedQueue<Runnable> taskQueue;
    private AtomicBoolean flag;

    public FixedThreadPool(int countOfThreads) {
        this.threads = new Thread[countOfThreads];
        this.taskQueue = new ConcurrentLinkedQueue<>();
    }

    @Override
    public void start() throws Exception {
        try {
            while (flag.get()) {
                for (int i = 0; i < threads.length; ++i) {
                    if (threads[i] == null || !threads[i].isAlive()) {
                        threads[i] = new Thread(taskQueue.remove());
                        threads[i].start();
                    }
                }

                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void execute(Runnable runnable) {
        taskQueue.add(runnable);
    }

    @Override
    public void close() throws Exception {
        flag.set(false);
    }
}
