package main.java.com.managers;

import main.java.com.models.Task; // Import the Task class
import main.java.com.observers.Observer; // Import the Observer class

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;
    private List<Observer> observers;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void addTask(Task task) {
        for (Task existingTask : tasks) {
            if (task.getStartTime().isBefore(existingTask.getEndTime()) && task.getEndTime().isAfter(existingTask.getStartTime())) {
                notifyObservers("Task conflicts with existing task: " + existingTask.getDescription());
                return;
            }
        }
        tasks.add(task);
        notifyObservers("Task added successfully: " + task.getDescription());
    }

    public void removeTask(String description) {
        Task taskToRemove = null;
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                taskToRemove = task;
                break;
            }
        }
        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            notifyObservers("Task removed successfully: " + description);
        } else {
            notifyObservers("Task not found: " + description);
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }

        Collections.sort(tasks, Comparator.comparing(Task::getStartTime));

        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void viewTasksByPriority(String priorityLevel) {
        boolean found = false;
        for (Task task : tasks) {
            if (task.getPriorityLevel().equalsIgnoreCase(priorityLevel)) {
                System.out.println(task);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No tasks with priority level: " + priorityLevel);
        }
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.notify(message);
        }
    }
}
