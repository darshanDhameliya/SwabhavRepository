package com.techlab.reflaction.test;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;

public class Reflaction {
	public int getCountMethod(String className) {
		int countMethod = 0;
		try {
			Method[] method = Class.forName(className).getMethods();
			while (!method[countMethod].equals(null)) {
				countMethod++;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return countMethod;
	}

	public int getCountField(String className) {
		int countField = 0;
		try {
			Field[] field = Class.forName(className).getFields();
			while (!field[countField].equals(null)) {
				countField++;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return countField;
	}

	public int getCountConstructor(String className) {
		int countConstructor = 0;
		try {
			Constructor<?>[] constructor = Class.forName(className).getConstructors();
			while (!constructor[countConstructor].equals(null)) {
				countConstructor++;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return countConstructor;
	}
}
