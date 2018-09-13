package org.certificatic.spring.aop.util.bean.api.impl;

import org.certificatic.spring.aop.util.Color;
import org.certificatic.spring.aop.util.bean.api.IColorWriter;
import org.fusesource.jansi.Ansi;
import org.springframework.stereotype.Component;

@Component
public class ColorWriter implements IColorWriter {

	@Override
	public String getColoredMessage(Color color, String mensaje) {
		return Ansi.ansi().eraseScreen()
				.render("@|" + color.getColor() + "    " + mensaje + "|@")
				.toString();
	}

}
