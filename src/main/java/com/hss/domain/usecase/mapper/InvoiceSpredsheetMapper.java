package com.hss.domain.usecase.mapper;

import com.hss.domain.usecase.model.InvoiceModel;
import jakarta.inject.Singleton;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

@Singleton
public record InvoiceSpredsheetMapper() {

    public static List<InvoiceModel> buildObject(byte[] bytes) {
        List<InvoiceModel> records = new ArrayList<>();

        InputStream is = new ByteArrayInputStream(bytes);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, UTF_8))) {

            breakFile(records, br);
            return records;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void breakFile(List<InvoiceModel> records, BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            var frtm = InvoiceModel.builder()
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
