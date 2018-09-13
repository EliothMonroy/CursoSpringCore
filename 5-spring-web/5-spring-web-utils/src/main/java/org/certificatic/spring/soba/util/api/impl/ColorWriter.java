package org.certificatic.spring.soba.util.api.impl;

import org.certificatic.spring.soba.util.Color;
import org.certificatic.spring.soba.util.api.IColorWriter;
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
