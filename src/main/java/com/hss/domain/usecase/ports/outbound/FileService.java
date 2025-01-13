package com.hss.domain.usecase.ports.outbound;

public interface FileService {

    void saveFile(String bucketName, String fileName, byte[] bytesFile);
}
