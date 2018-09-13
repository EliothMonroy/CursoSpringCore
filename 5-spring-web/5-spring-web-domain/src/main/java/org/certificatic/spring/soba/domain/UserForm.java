package org.certificatic.spring.soba.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserForm extends User {

	private static final long serialVersionUID = -7007278593685020027L;

	private List<String> stringAuthorities = new ArrayList<>();

}
