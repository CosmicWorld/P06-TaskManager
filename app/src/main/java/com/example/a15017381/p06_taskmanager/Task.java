package com.example.a15017381.p06_taskmanager;

import java.io.Serializable;

/**
 * Created by 15017381 on 26/5/2017.
 */

public class Task implements Serializable {
    private int id;
    private String name;
    private String content;

    public Task (int id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
