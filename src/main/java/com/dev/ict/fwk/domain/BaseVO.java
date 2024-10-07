package com.dev.fwk.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class BaseVO implements Serializable{

	private static final long serialVersionUID = 1L;
    private HeaderVO header;
}
