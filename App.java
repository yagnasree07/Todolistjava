// src/App.java
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TodoList list = new TodoList();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        System.out.println("Welcome to the Java Console To-Do List!");

        // Main program loop
        while (choice != 5) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            // Input handling and validation
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline left by nextInt()

                switch (choice) {
                    case 1:
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        list.addTask(description);
                        break;
                    case 2:
                        list.viewTasks();
                        break;
                    case 3:
                        list.viewTasks();
                        if (list.isEmpty()) break; // **FIXED ERROR LINE**
                        System.out.print("Enter the number of the task to mark as done: ");
                        if (scanner.hasNextInt()) {
                            list.markTaskDone(scanner.nextInt());
                        } else {
                            System.out.println("Invalid input. Please enter a number.");
                        }
                        scanner.nextLine();
                        break;
                    case 4:
                        list.viewTasks();
                        if (list.isEmpty()) break; // **FIXED ERROR LINE**
                        System.out.print("Enter the number of the task to remove: ");
                        if (scanner.hasNextInt()) {
                            list.removeTask(scanner.nextInt());
                        } else {
                            System.out.println("Invalid input. Please enter a number.");
                        }
                        scanner.nextLine();
                        break;
                    case 5:
                        System.out.println("Goodbye! Have a productive day.");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose a number from 1 to 5.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
                choice = -1;
            }
        }
        scanner.close(); // Close the scanner when the program exits
    }
}