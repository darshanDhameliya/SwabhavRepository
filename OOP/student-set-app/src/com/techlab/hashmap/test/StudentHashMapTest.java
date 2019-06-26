package com.techlab.hashmap.test;


import com.tchlab.student.Student;
import com.tchlab.student.hashmap.StudentHashMap;

public class StudentHashMapTest {

	public static void main(String args[]) {

		Student student1 = new Student(101, "darshan", 11, 70.06f);
		Student student2 = new Student(101, "darshan", 11, 70.06f);
		
		StudentHashMap studentHashMap=new StudentHashMap();

		studentHashMap.addStudent(student2, student2);
		studentHashMap.addStudent(student1, student1);
		
		System.out.println(studentHashMap.getSize());
		
		System.out.println(studentHashMap.getStudentList());
	}
}
