package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TodoServer {

    private int port;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        JSONParser parser = new JSONParser();
        try (ServerSocket serverSocket = new ServerSocket(port);) {

            while (true) {
                try (
                        Socket clientSocket = serverSocket.accept();
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {
                    final String clientTaskJson = in.readLine();

                    //Parser

                    Object obj = parser.parse(clientTaskJson);
                    JSONObject jsonObject = (JSONObject) obj;
                    String typeParse = (String) jsonObject.get("type");
                    String taskParse = (String) jsonObject.get("task");

                    if (typeParse.equals("ADD")) {
                        todos.addTask(taskParse);
                    } else {
                        if (typeParse.equals("REMOVE")) {
                            todos.removeTask(taskParse);
                        }
                    }
                    //sent to client
                    out.println(String.format(todos.getAllTasks()));
                }
            }
        } catch (IOException | ParseException e) {
            System.out.println("WRONG!");
            e.printStackTrace();
        }
    }
}
