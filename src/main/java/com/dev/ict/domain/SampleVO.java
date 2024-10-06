package com.dev.ict.domain;

import com.dev.fwk.domain.BaseVO;
import com.dev.fwk.domain.PayloadVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SampleVO extends BaseVO{

    private PayloadVO payload;
}
