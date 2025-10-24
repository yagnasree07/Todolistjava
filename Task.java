// src/Task.java
public class Task {
    private String description;
    private boolean isDone;

    // Constructor to create a new task
    public Task(String description) {
        this.description = description;
        this.isDone = false; // New task is initially not done
    }

    // Method to mark the task as complete
    public void markAsDone() {
        this.isDone = true;
    }

    // toString() method for easy printing
    @Override
    public String toString() {
        // Returns [X] for done, [ ] for not done
        String status = isDone ? "[X]" : "[ ]";
        return status + " " + description;
    }

    // Optional: Getter for status (needed for robust systems, but not strictly required for this console app)
    public boolean isDone() {
        return isDone;
    }
}
