package com.hss.domain.usecase.activity.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseException extends RuntimeException {

    private static final Logger logger = LoggerFactory.getLogger(BaseException.class);

    private final String errorDetails;
    private final String title;

    public BaseException(String errorDetails, String title) {
        super(errorDetails);
        this.errorDetails = errorDetails;
        this.title = title;

        // Log da exception
        logger.error("Error: {} | details: {}", title,  errorDetails);
    }
}
