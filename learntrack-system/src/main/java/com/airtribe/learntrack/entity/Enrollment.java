package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.EnrollmentStatus;

import java.time.LocalDate;

public class Enrollment {

    private int id;
    private int studentId;
    private int courseId;
    private EnrollmentStatus status;
    private LocalDate localDate;

    public Enrollment(int id, int studentId, int courseId, LocalDate now) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = EnrollmentStatus.ACTIVE;
        this.localDate=now;
    }

    public int getStudentId() {
        return studentId;
    }

    public void updateStatus(EnrollmentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EnrollmentId=" + id +
                ", StudentId=" + studentId +
                ", CourseId=" + courseId +
                ", Status=" + status;
    }

    public int getId() {
        return id;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getStatus() {
        return status.toString();
    }
}
