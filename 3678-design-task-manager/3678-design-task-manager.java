import java.util.*;

class TaskManager {

    private static class Task {
        int userId;
        int taskId;
        int priority;

        Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }

    private Map<Integer, Task> taskMap; // Maps taskId to Task object
    private TreeMap<Integer, TreeSet<Task>> priorityMap; // Maps priority to tasks with that priority

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        priorityMap = new TreeMap<>((a, b) -> b - a); // Sort priorities in descending order

        for (List<Integer> task : tasks) {
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);
            add(userId, taskId, priority);
        }
    }

    public void add(int userId, int taskId, int priority) {
        if (taskMap.containsKey(taskId)) {
            rmv(taskId); // Remove existing task before adding
        }

        Task newTask = new Task(userId, taskId, priority);
        taskMap.put(taskId, newTask);

        priorityMap.putIfAbsent(priority, new TreeSet<>((a, b) -> {
            // Larger taskId comes first for equal priorities
            if (a.taskId != b.taskId) {
                return b.taskId - a.taskId;
            }
            return 0; // This ensures no duplicates
        }));
        priorityMap.get(priority).add(newTask);
    }

    public void edit(int taskId, int newPriority) {
        if (!taskMap.containsKey(taskId)) return;

        Task task = taskMap.get(taskId);
        rmv(taskId); // Remove the task from its current priority group
        task.priority = newPriority; // Update priority
        add(task.userId, task.taskId, newPriority); // Re-add with the new priority
    }

    public void rmv(int taskId) {
        if (!taskMap.containsKey(taskId)) return;

        Task task = taskMap.get(taskId);
        int priority = task.priority;

        // Remove from priority map
        TreeSet<Task> tasksAtPriority = priorityMap.get(priority);
        tasksAtPriority.remove(task);
        if (tasksAtPriority.isEmpty()) {
            priorityMap.remove(priority); // Remove priority if empty
        }

        // Remove from task map
        taskMap.remove(taskId);
    }

    public int execTop() {
        if (priorityMap.isEmpty()) return -1;

        // Get the highest-priority group
        int highestPriority = priorityMap.firstKey();
        TreeSet<Task> tasksAtPriority = priorityMap.get(highestPriority);

        // Get and remove the task with the largest taskId
        Task topTask = tasksAtPriority.pollFirst();
        if (tasksAtPriority.isEmpty()) {
            priorityMap.remove(highestPriority); // Remove priority if empty
        }

        taskMap.remove(topTask.taskId);
        return topTask.userId;
    }
}
