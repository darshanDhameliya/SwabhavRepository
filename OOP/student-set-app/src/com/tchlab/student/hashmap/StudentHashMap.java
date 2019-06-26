package com.tchlab.student.hashmap;

import java.util.HashMap;

import com.tchlab.student.Student;

public class StudentHashMap {

	private HashMap<Student,Student> students=new HashMap<Student,Student>();
	
	public void addStudent(Student studentKey,Student studentValue)
	{
		students.put(studentKey, studentValue);
	}
	public void removeStudent(Student studentKey)
	{
		students.remove(studentKey);
	}
	public int getSize()
	{
		return students.size();
	}
	public HashMap<Student, Student> getStudentList()
	{
		return students;
	}
	
}
