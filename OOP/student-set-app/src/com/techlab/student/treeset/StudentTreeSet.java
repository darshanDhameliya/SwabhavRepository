package com.techlab.student.treeset;

import java.util.TreeSet;

import com.tchlab.student.Student;

public class StudentTreeSet {
private TreeSet<Student> students=new TreeSet<Student>();
	
	public void addStudent(Student student)
	{
		students.add(student);
	}
	public void removeStudent(Student student)
	{
		students.remove(student);
	}
	public TreeSet<Student> getStudents()
	{
		return students;
	}
	public int getSize()
	{
		return students.size();
	}
}
