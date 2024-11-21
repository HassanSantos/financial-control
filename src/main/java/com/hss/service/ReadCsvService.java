package com.hss.service;

import com.hss.model.FaturaModel;
import jakarta.inject.Singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

@Singleton
public record ReadCsvService() {

    public List<FaturaModel> buildObject(InputStream is) {
        List<FaturaModel> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, UTF_8))) {

            breakFile(records, br);
            return records;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void breakFile(List<FaturaModel> records, BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            var frtm = FaturaModel.builder()
                    .data(values[0])
                    .lancamento(values[1])
                    .categoria(values[2])
                    .tipo(values[3])
                    .valor(values[4])
                    .build();
            records.add(frtm);
        }
        records.removeFirst();
    }

}
