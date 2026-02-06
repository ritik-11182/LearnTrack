package com.airtribe.learntrack.entity;

public class Trainer extends Person {

    private String expertise;
    private int experienceInYears;
    private boolean active;

    public Trainer(int id,
                   String firstName,
                   String lastName,
                   String email,
                   String expertise,
                   int experienceInYears) {

        super(id, firstName, lastName, email);
        this.expertise = expertise;
        this.experienceInYears = experienceInYears;
        this.active = true;
    }

    public String getExpertise() {
        return expertise;
    }

    public int getExperienceInYears() {
        return experienceInYears;
    }

    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        this.active = false;
    }

    @Override
    public String getDisplayName() {
        return "Trainer: " + super.getDisplayName() +
                " | Expertise: " + expertise;
    }
}
