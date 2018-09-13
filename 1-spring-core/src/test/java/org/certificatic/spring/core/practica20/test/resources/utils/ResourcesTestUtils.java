package org.certificatic.spring.core.practica20.test.resources.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.stream.Collectors;

import org.certificatic.spring.core.practica20.test.resources.api.IInputStreamResourceReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResourcesTestUtils {

	private static IInputStreamResourceReader isrr = (ir) -> {
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(ir))) {
			return buffer.lines().collect(Collectors.joining("\n"));
		}
	};

	@SneakyThrows
	public static void loadTextFile(Resource resource) {

		String expectedText = "Lorem ipsum dolor sit amet, \n"
				+ "consectetur adipiscing elit, \n"
				+ "sed eiusmod tempor incidunt ut labore et dolore magna aliqua. \n\n"
				+ "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

		String readText = isrr.read(resource.getInputStream());

		Assert.assertEquals(expectedText, readText);

		log.info("textFile: {}", readText);
	}

	@SneakyThrows
	public static void loadPropertiesFile(Resource resource) {

		String expectedText = "certificatic.curso=Spring Framework 4\n" +
				"certificatic.instructor=Ivan García";

		String readText = isrr.read(resource.getInputStream());

		Assert.assertEquals(expectedText, readText);

		log.info("propertiesFile: {}", readText);

		Properties properties = new Properties();
		properties.load(resource.getInputStream());

		Assert.assertEquals("Ivan García", properties.getProperty("certificatic.instructor"));

		log.info("certificatic.instructor: {}", properties.getProperty("certificatic.instructor"));
	}

	@SneakyThrows
	public static void loadURLFile(Resource resource) {
		String expectedText = "Spring";

		String readText = isrr.read(resource.getInputStream());

		log.info("URLFile: {}", readText);

		Document doc = Jsoup.parse(readText);

		Assert.assertEquals(expectedText, doc.title());

		log.info("HTML <title>: {}", doc.title());

	}

	@SneakyThrows
	public static void loadAndCopyImage(Resource resource, String copyPath) {
		String expectedText = "logo.png";

		FileCopyUtils.copy(resource.getInputStream(),
				new FileOutputStream(new File(copyPath, resource.getFilename())));

		Path path = Paths.get(copyPath + resource.getFilename());

		Assert.assertTrue(Files.exists(path, LinkOption.NOFOLLOW_LINKS));
		Assert.assertEquals(expectedText, path.getFileName().toString());
	}
}
