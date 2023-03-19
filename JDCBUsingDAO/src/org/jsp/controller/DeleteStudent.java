package org.jsp.controller;

import java.util.Scanner;
import org.jsp.dao.StudentDao;
import org.jsp.dto.Student;

public class DeleteStudent {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Student ID to Delete the Details : ");
		int id = sc.nextInt();
		sc.close();

		StudentDao studentDao = new StudentDao();
		Student student = studentDao.getStudent(id);
		if (student != null) {
			new StudentDao().deleteStudent(id);
			System.out.println("Student ID=" + id + " is Deleted");
		} else {
			System.out.println("Student ID is not Found !");
		}
	}
}