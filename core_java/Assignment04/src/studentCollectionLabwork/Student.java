package studentCollectionLabwork;

import java.util.Objects;

 class Student implements Comparable<Student>{
	String name;
	int rollNo;
	double marks;
	
	public Student() {
		
	}
	
	
	public Student(String name, int rollNo, double marks) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.marks = marks;
	}


	@Override
	public String toString() {
		return "Students [name=" + name + ", rollNo=" + rollNo + ", marks=" + marks + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(marks, name, rollNo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		return rollNo == other.rollNo;
	}


	@Override
	public int compareTo(Student s) {
		return this.rollNo - s.rollNo;
	}


	public int getRollNo() {
		return rollNo;
	}


	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	public double percentage() {
		double per = (marks / 200) * 100;;
		return per;
		
	}
	
	
}
