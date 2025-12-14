package core;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Scheduler {

    private final ThreadPool pool;
    private final ConcurrentHashMap<String, String> jobStatus = new ConcurrentHashMap<>();

    public Scheduler(int workers) {
        pool = new ThreadPool(workers);
    }

    public String submitTask(String taskName) {
        String id = UUID.randomUUID().toString();
        jobStatus.put(id, "QUEUED");

        pool.execute(() -> {
            jobStatus.put(id, "RUNNING");
            System.out.println("Executing task: " + taskName);

            try { Thread.sleep(2000); } catch (InterruptedException ignored) {}

            jobStatus.put(id, "COMPLETED");
            System.out.println("Finished task: " + taskName);
        });

        return id;
    }

    public String getJobStatus(String id) {
        return jobStatus.getOrDefault(id, "NOT FOUND");
    }

    public void shutdown() {
        pool.shutdown();
    }
}
