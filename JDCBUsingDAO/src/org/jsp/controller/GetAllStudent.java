package org.jsp.controller;

import java.util.List;
import org.jsp.dao.StudentDao;
import org.jsp.dto.Student;

public class GetAllStudent {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		List<Student> students = studentDao.getAllStudent();
		for (Student s : students) {
			System.out.println("Student ID : " + s.getId());
			System.out.println("Student Name : " + s.getName());
			System.out.println("Student Dept : " + s.getDept());
			System.out.println("Student Perc : " + s.getPerc());
			System.out.println("---------------------------------");
		}
	}
}