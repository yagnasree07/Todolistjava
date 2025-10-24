// src/TodoList.java
import java.util.ArrayList;

public class TodoList {
    // The internal list is PRIVATE for encapsulation (this was the source of the error)
    private ArrayList<Task> tasks = new ArrayList<>(); 

    // **FIX FOR THE ERROR**
    // This public method allows other classes to check the list status safely.
    public boolean isEmpty() {
        return tasks.isEmpty(); 
    }

    // 1. Add a new task
    public void addTask(String description) {
        tasks.add(new Task(description));
        System.out.println("Task added: " + description);
    }

    // 2. View all tasks
    public void viewTasks() {
        if (isEmpty()) { // Uses the new public method
            System.out.println("Your To-Do list is empty!");
            return;
        }

        System.out.println("\n--- TO-DO LIST ---");
        for (int i = 0; i < tasks.size(); i++) {
            // Display task index (1-based) and the task object
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.println("------------------\n");
    }

    // 3. Mark a task as done
    public boolean markTaskDone(int index) {
        // Convert user's 1-based index to 0-based index
        int taskIndex = index - 1;

        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            tasks.get(taskIndex).markAsDone();
            System.out.println("Task " + index + " marked as done.");
            return true;
        } else {
            System.out.println("Invalid task number.");
            return false;
        }
    }
    
    // 4. Remove a task
    public boolean removeTask(int index) {
        int taskIndex = index - 1;

        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            tasks.remove(taskIndex);
            System.out.println("Task " + index + " removed.");
            return true;
        } else {
            System.out.println("Invalid task number.");
            return false;
        }
    }
}
