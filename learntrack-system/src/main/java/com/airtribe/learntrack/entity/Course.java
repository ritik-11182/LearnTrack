package com.airtribe.learntrack.entity;

public class Course {

    private int id;
    private String name;
    private String description;
    private boolean active;

    public Course(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.active = true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }

    public String getDescription() {
        return description;
    }
}
