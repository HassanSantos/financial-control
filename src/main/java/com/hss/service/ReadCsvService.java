package com.hss.service;

import com.hss.model.FaturaModel;
import jakarta.inject.Singleton;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Singleton
public record ReadCsvService() {

    public void testes(){
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("/home/hassan/Downloads/jujutsu/compact/fatura-inter-2024-11.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
            records.removeFirst();
           List<FaturaModel> listFatura = records.stream().map(i -> FaturaModel.builder()
                    .data(i.get(0))
                    .lancamento(i.get(1))
                    .categoria(i.get(2))
                    .tipo(i.get(3))
                    .valor(i.get(4)).build()).toList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
