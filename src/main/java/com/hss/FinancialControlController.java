package com.hss;

import io.micronaut.http.annotation.*;

@Controller("/financial-control")
public class FinancialControlController {

    @Get(uri = "/", produces = "text/plain")
    public String index() {
        return "Example Response";
    }
}