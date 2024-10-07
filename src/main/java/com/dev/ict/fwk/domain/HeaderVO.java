package com.dev.fwk.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeaderVO {
    @Schema(example = "abcdefg1234567")
    private String txId;

    private long txTime;
}
