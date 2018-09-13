package org.certificatic.spring.orm.domain.vo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDate extends Date {

	private DateFormat formater = new SimpleDateFormat("dd/MM/YYY hh:mm:ss");

	private static final long serialVersionUID = -6805138980991776091L;

	public CustomDate() {
		super();
	}

	public CustomDate(long time) {
		super(time);
	}

	@Override
	public String toString() {
		return formater.format(this);
	}

}
