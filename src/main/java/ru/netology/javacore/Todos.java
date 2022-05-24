package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {

    public String getType() {
        return type;
    }

    public String getTask() {
        return task;
    }

    private String type;
    private String task;

    ArrayList<String> spisok = new ArrayList<>();

    public void addTask(String task) {
        spisok.add(task);
    }

    public void removeTask(String task) {
        spisok.remove(task);
    }

    public String getAllTasks() {
        Collections.sort(spisok);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < spisok.size(); i++) {
            sb.append(spisok.get(i) + " ");
        }
        return sb.toString();
    }

}
