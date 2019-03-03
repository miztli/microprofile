package com.tutorial.demo.rest;

public class Task {
    private int id;
    private String name;

    public Task() {
        super();
    }

    public Task(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Task from(int id, String name) {
        return new Task(id, name);
    }
}
