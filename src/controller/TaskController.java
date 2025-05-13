package controller;

import dao.TaskDAO;
import model.Task;

import java.util.List;

public class TaskController {
    private TaskDAO taskDAO = new TaskDAO();

    public void addTask(String title, String description, String status) {
        Task task = new Task(title, description, status);
        taskDAO.addTask(task);
    }

    public List<Task> getAllTasks() {
        return taskDAO.getAllTasks();
    }
}