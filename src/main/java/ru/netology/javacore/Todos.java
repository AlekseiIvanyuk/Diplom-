package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {

    private ArrayList<String> listTasks = new ArrayList<>();

    public ArrayList<String> getListTasks() {
        return listTasks;
    }

    public void setListTasks(ArrayList<String> listTasks) {
        this.listTasks = listTasks;
    }


    public void addTask(String task) {
        listTasks.add(task);
    }

    public void removeTask(String task) {
        listTasks.remove(task);
    }

    public String getAllTasks() {
        Collections.sort(listTasks);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listTasks.size(); i++) {
            sb.append(listTasks.get(i) + " ");
        }
        return sb.toString();
    }

}
