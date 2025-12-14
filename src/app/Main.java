package app;

import core.Scheduler;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scheduler scheduler = new Scheduler(3);

        while (true) {
            System.out.println("\n==== TASK SCHEDULER ====");
            System.out.println("1. Submit Task");
            System.out.println("2. Check Job Status");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            String choice = sc.nextLine().trim();

            switch (choice) {

                case "1":
                    System.out.print("Enter task name: ");
                    String name = sc.nextLine();

                    String id = scheduler.submitTask(name);
                    System.out.println("Job submitted. ID: " + id);

                    System.out.print("\nPress Enter to continue...");
                    sc.nextLine();   // 👈 PAUSE MENU
                    break;

                case "2":
                    System.out.print("Enter Job ID: ");
                    String jobId = sc.nextLine();

                    System.out.println("Status: " + scheduler.getJobStatus(jobId));

                    System.out.print("\nPress Enter to continue...");
                    sc.nextLine();   // 👈 PAUSE MENU
                    break;

                case "3":
                    scheduler.shutdown();
                    System.out.println("Scheduler stopped. Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
