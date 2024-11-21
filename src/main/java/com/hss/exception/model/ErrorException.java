package com.hss.exception.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorException {

    private Integer code;
    private String messager;
}
