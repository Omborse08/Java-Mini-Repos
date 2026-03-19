package ScheduledJob;
import java.util.*;
public class Job_Schedule_Cli_Base{
    static void showMenu(){
        System.out.println("1.Add Job\n2.Add Worker\n3.View All Jobs\n4.Start Timer\n5.Exit");
    }
    static void main(String[] args) {
        int JobID = 1;
        int WorkerID = 11;
        JobsScheduledSystem jobs = new JobsScheduledSystem();
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        showMenu();
        while(isRunning) {
            System.out.println("Choose Option: ");
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    System.out.println("<+><+><+><+> Add Jobs <+><+><+><+>");
                    System.out.println();
                    System.out.println("Enter Job: ");
                    String jobname = sc.nextLine();
                    System.out.println("Enter Job Timer: ");
                    int time = sc.nextInt();
                    if (time <= 12 && time > 0) {
                        Job job = new Job(JobID, jobname, time);
                        jobs.addjob(job);
                        System.out.println("Job Added Successfully!");
                        System.out.println("Job ID: " + JobID++);
                    } else {
                        System.out.println("No Job Added!");
                    }
                    break;

                case 2:
                    System.out.println("<+><+><+><+> Add Workers <+><+><+><+>");
                    System.out.println();
                    System.out.println("Enter Worker Name: ");
                    String name = sc.nextLine();
                    Workers workers = new Workers(WorkerID, name);
                    jobs.addworkers(workers);
                    System.out.println("Worker Added Successfully!");
                    System.out.println("Worker ID: " + WorkerID++);
                    break;

                case 3:
                    System.out.println("<+><+><+><+> All Jobs <+><+><+><+>");
                    System.out.println();
                    jobs.showJobs();
                    break;

                case 4:
                    System.out.println("<+><+><+><+> Start Schedules Jobs <+><+><+><+>");
                    System.out.println();
                    jobs.scheduleTheJob();
                    break;

                case 5:
                    System.out.println();
                    System.out.println("Thank You Bye!");
                    isRunning = false;
                    break;
            }
        }
    }
}
