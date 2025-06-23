package org.example;
import java.util.ArrayList;

public class TodoList {
    private final ArrayList<Task> tasks;

    public TodoList() {
        tasks = new ArrayList<Task>();
    }

    public boolean add(String description) {
        if (description == null || description.isEmpty()) {
            return false;
        }
        tasks.add(new Task(description));
        return true;
    }

    public boolean complete(String description) {
        if (description == null || description.isEmpty()) {
            return false;
        }
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                task.markComplete();
                return true;
            }
        }
        return false;
    }

    public void all() {
        if (tasks.isEmpty()) {
            System.out.println("Your to-do list is empty.");
        } else {
            System.out.println("All tasks:");
            for (Task task : tasks) {
                System.out.println(task.formatted());
            }
        }
    }

    public void complete() {
        System.out.println("Completed tasks:");
        boolean found = false;
        for (Task task : tasks) {
            if (task.isComplete()) {
                System.out.println(task.formatted());
                found = true;
            }
        }
        if (!found) {
            System.out.println("None.");
        }
    }

    public void incomplete() {
        System.out.println("Incomplete tasks:");
        boolean found = false;
        for (Task task : tasks) {
            if (!task.isComplete()) {
                System.out.println(task.formatted());
                found = true;
            }
        }
        if (!found) {
            System.out.println("None.");
        }
    }

    public void clear() {
        tasks.clear();
        System.out.println("To-do list cleared.");
    }

    public ArrayList<Task> getAllTasks() {
        return new ArrayList<Task>(tasks);
    }

    public ArrayList<Task> getCompletedTasks() {
        ArrayList<Task> completed = new ArrayList<Task>();
        for (Task t : tasks) {
            if (t.isComplete()) {
                completed.add(t);
            }
        }
        return completed;
    }

    public ArrayList<Task> getIncompleteTasks() {
        ArrayList<Task> incomplete = new ArrayList<Task>();
        for (Task t : tasks) {
            if (!t.isComplete()) {
                incomplete.add(t);
            }
        }
        return incomplete;
    }
}