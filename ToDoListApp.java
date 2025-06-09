import java.util.ArrayList;
import java.util.Scanner;

// Task class using OOP
class Task {
    private String title;
    private boolean isCompleted;

    public Task(String title) {
        this.title = title;
        this.isCompleted = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void markAsComplete() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[✔] " : "[ ] ") + title;
    }
}

// Main class with menu
public class ToDoListApp {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== TO-DO LIST MENU =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Mark Task as Complete");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = getIntInput();

            switch (choice) {
                case 1: addTask(); break;
                case 2: viewTasks(); break;
                case 3: updateTask(); break;
                case 4: deleteTask(); break;
                case 5: markTaskAsComplete(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    private static void addTask() {
        System.out.print("Enter task title: ");
        String title = sc.nextLine();
        tasks.add(new Task(title));
        System.out.println("Task added.");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("\nYour Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void updateTask() {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to update: ");
        int index = getIntInput() - 1;
        if (isValidIndex(index)) {
            System.out.print("Enter new title: ");
            String newTitle = sc.nextLine();
            tasks.get(index).setTitle(newTitle);
            System.out.println("Task updated.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void deleteTask() {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to delete: ");
        int index = getIntInput() - 1;
        if (isValidIndex(index)) {
            tasks.remove(index);
            System.out.println("Task deleted.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void markTaskAsComplete() {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to mark as complete: ");
        int index = getIntInput() - 1;
        if (isValidIndex(index)) {
            tasks.get(index).markAsComplete();
            System.out.println("Task marked as complete.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static boolean isValidIndex(int index) {
        return index >= 0 && index < tasks.size();
    }

    private static int getIntInput() {
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            sc.next();
        }
        int num = sc.nextInt();
        sc.nextLine(); // consume leftover newline
        return num;
    }
}
