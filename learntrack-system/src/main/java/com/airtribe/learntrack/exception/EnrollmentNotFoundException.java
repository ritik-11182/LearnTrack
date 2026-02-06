package com.airtribe.learntrack.exception;

import static com.airtribe.learntrack.util.AppConstants.ENROLLMENT_NOT_FOUND;

public class EnrollmentNotFoundException extends LearnTrackException {
    public EnrollmentNotFoundException(int id) {
        super(ENROLLMENT_NOT_FOUND + id);
    }
}
