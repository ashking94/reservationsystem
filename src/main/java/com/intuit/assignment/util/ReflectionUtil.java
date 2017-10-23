package com.intuit.assignment.util;

import java.lang.reflect.Field;
import java.util.Optional;

public class ReflectionUtil {

	public static <T> Object getValue(T entity, String fieldName) {
		Optional<Field> optField = ReflectionUtil.getField(entity.getClass(), fieldName);
		Object value = 0;
		if (optField.isPresent()) {
			optField.get().setAccessible(true);
			try {
				value = optField.get().get(entity);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				System.err.println("Faced exception while retrieving vale for field - " + fieldName + e);
			}
		}
		return value;
	}

	public static Optional<Field> getField(Class clazz, String fieldName) {
		Optional<Field> result = Optional.empty();
		Field field = null;
		try {
			field = clazz.getDeclaredField(fieldName);
		} catch (Exception e) {
			System.err.println("getField" + e.getMessage() + e);
		}

		if (null == field) {
			Class superClass = clazz.getSuperclass();
			while (superClass != null && Object.class != superClass) {
				try {
					field = superClass.getDeclaredField(fieldName);
					if (null != field) {
						break;
					}
					superClass = superClass.getSuperclass();
				} catch (Exception e) {
					System.err.println("getField" + e.getMessage() + e);
					superClass = superClass.getSuperclass();
				}
			}
		}

		if (null != field) {
			field.setAccessible(true);
			result = Optional.of(field);
		}
		return result;
	}

}
