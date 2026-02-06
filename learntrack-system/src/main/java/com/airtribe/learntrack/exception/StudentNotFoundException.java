package com.airtribe.learntrack.exception;

public class StudentNotFoundException extends LearnTrackException {
    public StudentNotFoundException(int id) {
        super("Student not found with ID: " + id);
    }
}
