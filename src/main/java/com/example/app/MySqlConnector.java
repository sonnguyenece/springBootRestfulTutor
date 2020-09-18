package com.example.app;

public class MySqlConnector extends DatabaseConnector {
    @Override
    public void connect() {
        System.out.println("MySql connected" +getUrl());
    }
}
