package com.hss.exception;

import com.hss.exception.model.ErrorException;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.exceptions.HttpStatusException;

public class BasicException extends HttpStatusException {
    public BasicException(HttpStatus status, ErrorException message) {
        super(status, message);
    }
}
