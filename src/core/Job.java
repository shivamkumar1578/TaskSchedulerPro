package core;

public class Job {

    private final String id;
    private final Task task;
    private JobStatus status = JobStatus.PENDING;

    public Job(String id, Task task) {
        this.id = id;
        this.task = task;
    }

    public String getId() {
        return id;
    }

    public Task getTask() {
        return task;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }
}
