package org.certificatic.spring.soba.mvc.util;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public interface IMapUtils {

	public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
		for (Entry<T, E> entry : map.entrySet()) {
			if (Objects.equals(value, entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;
	}

}
