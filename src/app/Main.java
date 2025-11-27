package app;

import entities.Task;
import entities.User;
import services.TaskService;
import services.UserService;

import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();
        TaskService taskService = new TaskService();

        User logged = null;

        while (true) {
            System.out.println("\n1 - Register");
            System.out.println("2 - Login");
            System.out.println("3 - Exit");
            System.out.print("Select: ");

            int opc = Integer.parseInt(sc.nextLine());

            if (opc == 1) {

                System.out.print("Username: ");
                String username = sc.nextLine();

                System.out.print("Password: ");
                String password = sc.nextLine();

                if (userService.register(username, password)) {
                    System.out.println("User registered successfully");
                } else {
                    System.out.println("Username already exists.");
                }

            } else if (opc == 2) {

                System.out.print("Username: ");
                String username = sc.nextLine();

                System.out.print("Password: ");
                String password = sc.nextLine();

                logged = userService.login(username, password);

                if (logged == null) {
                    System.out.println("Invalid login.");
                } else {
                    System.out.println("Login successfully!");
                    break;
                }

            } else {
                return;
            }
        }

        while (true) {
            System.out.println("\n--- TASK MANAGER ---");
            System.out.println("1 - Add Task");
            System.out.println("2 - List Tasks");
            System.out.println("3 - Exit");

            int opc = Integer.parseInt(sc.nextLine());

            if (opc == 1) {
                System.out.print("Task description: ");
                String desc = sc.nextLine();
                taskService.addTask(logged.getId(), desc);
                System.out.println("Task added.");
            }
            else if (opc == 2) {
                Vector<Task> tasks = taskService.listTasks(logged.getId());
                for (Task t : tasks) {
                    System.out.println("- " + t.getDescription());
                }
            }
            else if (opc == 3) {
                break;
            }
        }
    }
}
