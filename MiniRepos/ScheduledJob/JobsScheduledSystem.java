package ScheduledJob;
import java.util.*;
class JobsScheduledSystem {
    HashMap<Integer,Job> jobs = new HashMap<>();
    ArrayList<Workers> worker = new ArrayList<>();
    PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparing(Job::getTime));

    public void addjob(Job job) {
        jobs.put(job.getId(),job);
        pq.add(job);
    }

    public void addworkers(Workers workers) {
        worker.add(workers);
    }

    public void showJobs() {
        for (int i: jobs.keySet()) {
            System.out.println("ID: "+i+", Job Name: "+jobs.get(i).getName()+" Job Status: "+jobs.get(i).getStatus());
        }
    }

    public void scheduleTheJob() {
        int currentTime = 0;
        int num = 0;
        while (!pq.isEmpty()) {
            System.out.println();
            System.out.println("[ Time "+currentTime +"]");
            while (!pq.isEmpty() && pq.peek().getTime() <= currentTime) {
                Job job = pq.poll();
                System.out.println("Job "+job.getName() + " is Ready");
                if (!worker.isEmpty()) {
                    Workers work = worker.get(num);
                    System.out.println("Worker "+work.getName()+ "is Ready For "+job.getName());
                    work.setStatus("BUSY");

                    Random rand = new Random();
                    boolean isSuccess = rand.nextBoolean();
                    if (isSuccess) {
                        System.out.println(job.getName()+" is Completed!");
                        job.setStatus("COMPLETED");
                        num++;
                    }
                    else {
                        System.out.println(job.getName()+" is Failed");
                        pq.add(job);
                    }
                    work.setStatus("ONLINE");
                }
                else {
                    System.out.println("No Workers Available!");
                }
            }
            currentTime++;
        }
    }
}
