package core;

import java.util.LinkedList;
import java.util.Queue;

public class JobQueue {

    private final Queue<Job> jobQueue = new LinkedList<>();

    public synchronized void addJob(Job job) {
        jobQueue.add(job);
        notify();
    }

    public synchronized Job getJob() {
        while (jobQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException ignored) {}
        }
        return jobQueue.poll();
    }
}
