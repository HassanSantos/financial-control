package com.hss.service;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

import java.net.http.HttpResponse;

@Client("https://ec2-18-219-207-43.us-east-2.compute.amazonaws.com:8080/")
public interface ClientTeste {

    @Get
    HttpResponse<?> testes();
}
