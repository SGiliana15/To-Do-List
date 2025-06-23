package org.example;

public class Task {
    private final String description;
    private boolean isComplete;

    public Task(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be empty");
        }
        this.description = description.trim();
        this.isComplete = false;
    }

    public void markComplete() {
        isComplete = true;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public String getDescription() {
        return description;
    }

    public String formatted() {
        String status;
        if (isComplete) {
            status = "[X]";
        } else {
            status = "[ ]";
        }
        return status + " " + description;
    }
}