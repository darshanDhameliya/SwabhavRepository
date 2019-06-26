package com.tchlab.student;

import java.util.Comparator;

public class StudentCgpiCompare implements Comparator<Student>{
	
	
	@Override
	public int compare(Student o1, Student o2) {
		if (o1.getCgpi()> o2.getCgpi()) {
			return 1;
		}
		if (o1.getCgpi() < o2.getCgpi()) {
			return -1;
		}
		return 0;
	}
}
