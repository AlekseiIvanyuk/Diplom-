package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TodoServer {

    int port;
    Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            final String clientTaskJson = in.readLine();

            //Parser
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            Todos todos1 = gson.fromJson(clientTaskJson, Todos.class);
            System.out.println("type " + todos1.type + " task " + todos1.task);

            if (todos1.type.equals("ADD")) {
                todos.addTask(todos1.task);
            } else {
                if (todos1.type.equals("REMOVE")) {
                    todos.removeTask(todos1.task);
                } else {
                }
            }
            //sent to client
            out.println(String.format(todos.getAllTasks()));
        }
    }
}
