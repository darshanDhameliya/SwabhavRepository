package com.techlab.student.set.test;

import com.tchlab.student.Student;
import com.techlab.student.set.StudentSet;

public class StudentSetTest {
	public static void main(String args[]) {
		StudentSet studentSet = new StudentSet();

		Student student1 = new Student(101, "darshan", 11, 76.06f);
		Student student2 = new Student(102, "darshan", 11, 76.06f);
		Student student3 = new Student(103, "darshan", 11, 76.06f);

		studentSet.addStudent(student1);
		studentSet.addStudent(student2);
		studentSet.addStudent(student3);
		
		System.out.println(studentSet.getSize());
	}

}
