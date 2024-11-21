package com.hss.exception;

import com.hss.exception.model.ErrorException;
import io.micronaut.http.HttpStatus;

public class TesteException extends BasicException{
    public TesteException(HttpStatus status, ErrorException message) {
        super(status, message);
    }
}
