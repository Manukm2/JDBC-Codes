package org.jsp.controller;

import java.util.Scanner;
import org.jsp.dao.StudentDao;
import org.jsp.dto.Student;

public class SaveStudent {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Student ID to Save the Data : ");
		int id = sc.nextInt();
		System.out.println("Enter the Student Name : ");
		String name = sc.next();
		System.out.println("Enter the Student Department : ");
		String dept = sc.next();
		System.out.println("Enter the Student Percentage : ");
		double per = sc.nextDouble();
		sc.close();

		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setDept(dept);
		student.setPerc(per);
		StudentDao dao = new StudentDao();
		dao.saveStudent(student);
		System.out.println("Record is Saved");
	}
}
