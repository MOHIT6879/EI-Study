package main.java.com.factories;

import java.time.LocalTime;
import main.java.com.models.Task; // Import the Task class

public class TaskFactory {
    public static Task createTask(String description, String startTime, String endTime, String priorityLevel) {
        LocalTime start = LocalTime.parse(startTime);
        LocalTime end = LocalTime.parse(endTime);
        return new Task(description, start, end, priorityLevel);
    }
}
