package com.airtribe.learntrack.exception;

import static com.airtribe.learntrack.util.AppConstants.COURSE_NOT_FOUND;

public class CourseNotFoundException extends LearnTrackException {
    public CourseNotFoundException(int id) {
        super(COURSE_NOT_FOUND + id);
    }
}
