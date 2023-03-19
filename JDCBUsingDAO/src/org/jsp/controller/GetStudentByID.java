
package org.jsp.controller;

import java.util.Scanner;

import org.jsp.dao.StudentDao;
import org.jsp.dto.Student;

public class GetStudentByID {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Student ID to Fetch the Details : ");
		int id = sc.nextInt();
		sc.close();

		StudentDao studentDao = new StudentDao();
		Student student = studentDao.getStudent(id);
		if (student != null) {
			System.out.println("Student ID : " + student.getId());
			System.out.println("Student Name : " + student.getName());
			System.out.println("Student Dept : " + student.getDept());
			System.out.println("Student Perc : " + student.getPerc());
			System.out.println("---------------------------------");
		} else {
			System.out.println("Invalid ID");
		}
	}
}
