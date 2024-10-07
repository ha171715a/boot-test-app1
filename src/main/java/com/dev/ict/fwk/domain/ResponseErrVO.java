package com.dev.fwk.domain;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@SuperBuilder
@NoArgsConstructor
public class ResponseErrVO extends BaseResVO{

    private Map<String, Object> payload = new HashMap<>();

}
