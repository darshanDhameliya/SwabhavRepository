package com.tchlab.student;

public class Student implements Comparable<Student>{
	private int rollNo;
	private String name;
	private int std;
	private float cgpi;

	public Student(int rollNo, String name, int std, float cgpi) {
		this.rollNo = rollNo;
		this.name = name;
		this.std = std;
		this.cgpi = cgpi;
	}

	public int getRollNo() {
		return rollNo;
	}

	public String getName() {
		return name;
	}

	public int getStd() {
		return std;
	}

	public float getCgpi() {
		return cgpi;
	}

	
	@Override
	public int compareTo(Student o) {
		if (this.rollNo > o.rollNo) {
			return 1;
		}
		if (this.rollNo < o.rollNo) {
			return -1;
		}
		return 0;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rollNo;
		result = prime * result + std;

		return result;
	}
	
	 @Override
	 public boolean equals(Object obj) {
	 if (this == obj)
	 return true;
	 if (obj == null)
	 return false;
	 if (getClass() != obj.getClass())
	 return false;
	 Student other = (Student) obj;
	 if (rollNo != other.rollNo)
	 return false;
	 if (std != other.std)
	 return false;
	 return true;
	 }
}
