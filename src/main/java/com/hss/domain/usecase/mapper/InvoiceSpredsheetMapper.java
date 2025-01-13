package com.hss.domain.usecase.mapper;

import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Singleton
@Slf4j
public record InvoiceSpredsheetMapper() {

    public static List<Map<String, String>> buildObject(byte[] bytes) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bytes)))) {
            var splitString = "\",\"";
            var header = Arrays.asList(br.readLine().split(splitString));

            return br.lines()
                    .map(line -> getStringMap(line, splitString, header))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
//            TODO: CREATE NEW CLASS EXCEPTION
        }
    }

    private static Map<String, String> getStringMap(String line, String splitString, List<String> header) {
        var values = Arrays.asList(line.split(splitString));
        return IntStream.range(0, header.size())
                .boxed()
                .collect(Collectors.toMap(header::get, values::get));
    }
}
