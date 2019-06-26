package com.techlab.student.treeset.test;

import java.util.TreeSet;

import com.tchlab.student.Student;
import com.tchlab.student.StudentCgpiCompare;
import com.tchlab.student.StudentNameCompare;
import com.techlab.student.treeset.StudentTreeSet;

public class StudentTreeSetTest {
	public static void main(String args[]) {
		StudentTreeSet studentTreeSet=new StudentTreeSet();

		Student student1 = new Student(101, "darshan", 11, 70.06f);
		Student student2 = new Student(103, "dhanraj", 11, 76.06f);
		Student student3 = new Student(102, "vivek", 11, 80.06f);

		TreeSet<Student> nameCompare=new TreeSet<>(new StudentNameCompare());
		nameCompare.add(student1);
		nameCompare.add(student2);
		nameCompare.add(student3);
		
		System.out.println("sorted by name");
		for (Student student : nameCompare) {
			System.out.println(student.getRollNo()+" "+student.getName()+" "+student.getStd()+" "+student.getCgpi());
		}
		TreeSet<Student> cgpiCompare=new TreeSet<>(new StudentCgpiCompare());
		cgpiCompare.add(student1);
		cgpiCompare.add(student2);
		cgpiCompare.add(student3);
		
		System.out.println("\nsorted by cgpi");
		for (Student student : cgpiCompare) {
			System.out.println(student.getRollNo()+" "+student.getName()+" "+student.getStd()+" "+student.getCgpi());
		}
	}
	

}
