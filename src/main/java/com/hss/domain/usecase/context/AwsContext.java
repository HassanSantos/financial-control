package com.hss.domain.usecase.context;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AwsContext {

    private byte[] bytesFile;
}
