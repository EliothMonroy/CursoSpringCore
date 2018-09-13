package org.certificatic.spring.core.practica20.test.resources.api;

import java.io.IOException;
import java.io.InputStream;

@FunctionalInterface
public interface IInputStreamResourceReader {

	String read(InputStream input) throws IOException;
}
