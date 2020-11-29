package com.example.myapplication;

public class Todo {
    private String title;
    private String Des;

    public Todo(String title, String des) {
        this.title = title;
        Des = des;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return Des;
    }

    @Override
    public String toString() {
        return getTitle();
    }

    public void setDes(String des) {
        Des = des;
    }
}
