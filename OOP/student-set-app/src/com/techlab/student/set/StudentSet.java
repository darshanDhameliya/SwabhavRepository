package com.techlab.student.set;

import java.util.HashSet;

import com.tchlab.student.Student;

public class StudentSet {

	private HashSet<Student> students=new HashSet<Student>();
	
	public void addStudent(Student student)
	{
			students.add(student);
	}
	public void removeStudent(Student student)
	{
		students.remove(student);
	}
	public int getSize()
	{
		return students.size();
	}
	
}
