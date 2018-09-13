package org.certificatic.spring.tx.pratica26.springtx.domain;

import lombok.Builder;

import lombok.Data;

@Data
@Builder
public class BusinessObject {
	private Long id;
	private String data;
}
