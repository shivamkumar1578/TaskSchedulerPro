package core;

public class WorkerThread extends Thread {

    private final JobQueue jobQueue;
    private final JobManager jobManager;
    private boolean running = true;

    public WorkerThread(JobQueue jobQueue, JobManager jobManager, String name) {
        super(name);
        this.jobQueue = jobQueue;
        this.jobManager = jobManager;
    }

    @Override
    public void run() {
        while (running) {
            Job job = jobQueue.getJob();

            if (job != null) {
                jobManager.updateStatus(job.getId(), JobStatus.RUNNING);
                System.out.println("Executing task: " + job.getTask().getName());

                job.getTask().execute();

                jobManager.updateStatus(job.getId(), JobStatus.COMPLETED);
                System.out.println("Finished task: " + job.getTask().getName());
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}
