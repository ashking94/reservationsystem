package com.intuit.assignment.daolayer.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.intuit.assignment.daolayer.exception.AppException;
import com.intuit.assignment.util.ReflectionUtil;

public abstract class AbstractManager<T> {

	private List<T> lst = new ArrayList<T>();

	private Map<String, T> map = new HashMap<String, T>();

	public void insert(T ele, String keyColumn) throws AppException {
		validate(ele);
		Object value = ReflectionUtil.getValue(ele, keyColumn);
		String strValue;
		if (value.getClass() == Integer.class) {
			strValue = String.valueOf(value);
		} else {
			strValue = (String) value;
		}
		map.put(strValue, ele);
		lst.add(ele);
	}

	public void delete(T ele, String keyColumn) {
		Object value = ReflectionUtil.getValue(ele, keyColumn);
		String strValue;
		if (value.getClass() == Integer.class) {
			strValue = String.valueOf(value);
		} else {
			strValue = (String) value;
		}
		map.remove(strValue);
		lst.remove(ele);
	}

	public List<T> getList() {
		return lst;
	}

	public List<T> getList(Predicate<T> predicate) {
		return (List<T>) lst.stream().filter(predicate).collect(Collectors.toList());
	}

	public Map<String, T> getMap() {
		return map;
	}

	abstract void validate(T ele) throws AppException;

}
