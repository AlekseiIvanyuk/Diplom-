package ru.netology.javacore;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodosTests {

    Todos sut = new Todos();

    @org.junit.jupiter.api.Test
    public void addTaskTest() {
        // given:
        String task = "D";
        ArrayList<String> list1 = new ArrayList<>();
        list1.add(task);

        // when:
        sut.addTask(task);

        // then:
        assertTrue(list1.equals(sut.getListTasks()));
    }

    @org.junit.jupiter.api.Test
    public void removeTaskTest() {
        // given:
        String task = "D";
        ArrayList<String> list1 = new ArrayList<>();
        list1.remove(task);

        // when:
        sut.removeTask(task);

        // then:
        assertTrue(list1.equals(sut.getListTasks()));
    }

    @org.junit.jupiter.api.Test
    public void getAllTasksTest() {
        // given:
        ArrayList<String> list1 = new ArrayList<>();
        String task = "D";
        String task1 = "A";
        list1.add(task);
        list1.add(task1);

        Collections.sort(list1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list1.size(); i++) {
            sb.append(list1.get(i) + " ");
        }
        String result = sb.toString();

        // when:
        sut.addTask("D");
        sut.addTask("A");
        sut.getAllTasks();

        // then:
        assertTrue(result.equals(sut.getAllTasks()));
    }
}
