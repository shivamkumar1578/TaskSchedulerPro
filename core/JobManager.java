package core;

import java.util.concurrent.ConcurrentHashMap;

public class JobManager {

    private final ConcurrentHashMap<String, Job> jobMap = new ConcurrentHashMap<>();

    public void addJob(Job job) {
        jobMap.put(job.getId(), job);
    }

    public Job getJob(String id) {
        return jobMap.get(id);
    }

    public void updateStatus(String id, JobStatus status) {
        Job job = jobMap.get(id);
        if (job != null) {
            job.setStatus(status);
        }
    }
}
