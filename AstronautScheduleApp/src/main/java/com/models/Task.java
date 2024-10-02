package main.java.com.models;

import java.time.LocalTime;

public class Task {
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private String priorityLevel;
    private boolean isCompleted;

    public Task(String description, LocalTime startTime, LocalTime endTime, String priorityLevel) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priorityLevel = priorityLevel;
        this.isCompleted = false;
    }

    public String getDescription() {
        return description;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return startTime + " - " + endTime + ": " + description + " [" + priorityLevel + "]";
    }
}
