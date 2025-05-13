package view;

import controller.TaskController;
import model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TaskBoardGUI extends JFrame {
    private TaskController controller;
    private DefaultListModel<String> listModel;
    private JList<String> taskList;

    public TaskBoardGUI() {
        controller = new TaskController();

        setTitle("Agenda de Tarefas");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Agenda de Tarefas", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskList.setFont(new Font("Arial", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(taskList);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JButton addButton = new JButton("Adicionar Nova Tarefa");
        addButton.setFont(new Font("Arial", Font.BOLD, 16));
        addButton.setBackground(new Color(100, 149, 237));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        mainPanel.add(addButton, BorderLayout.SOUTH);

        add(mainPanel);

        refreshTaskList();
    }

    private void addTask() {
        JTextField titleField = new JTextField();
        JTextField descriptionField = new JTextField();
        String[] options = {"Pendente", "Em Progresso", "Concluída"};
        JComboBox<String> statusBox = new JComboBox<>(options);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Título:"));
        panel.add(titleField);
        panel.add(new JLabel("Descrição:"));
        panel.add(descriptionField);
        panel.add(new JLabel("Status:"));
        panel.add(statusBox);

        int result = JOptionPane.showConfirmDialog(this, panel, "Adicionar Tarefa",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String title = titleField.getText();
            String description = descriptionField.getText();
            String status = (String) statusBox.getSelectedItem();

            if (title != null && !title.isEmpty()) {
                controller.addTask(title, description, status);
                refreshTaskList();
            }
        }
    }

    private void refreshTaskList() {
        listModel.clear();
        List<Task> tasks = controller.getAllTasks();
        for (Task task : tasks) {
            listModel.addElement(task.getId() + " - " + task.getTitle() + " (" + task.getStatus() + ")");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TaskBoardGUI().setVisible(true));
    }
}