package core;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

    private final Worker[] workers;
    private final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    private volatile boolean running = true;

    public ThreadPool(int size) {
        workers = new Worker[size];
        for (int i = 0; i < size; i++) {
            workers[i] = new Worker("Worker-" + (i + 1));
            workers[i].start();
        }
    }

    public void execute(Runnable task) {
        if (running) {
            queue.offer(task);
        }
    }

    public void shutdown() {
        running = false;
        for (Worker w : workers) {
            w.interrupt();
        }
    }

    private class Worker extends Thread {
        Worker(String name) {
            super(name);
        }

        public void run() {
            while (running) {
                try {
                    Runnable job = queue.take();
                    job.run();
                } catch (InterruptedException ignored) {}
            }
        }
    }
}
