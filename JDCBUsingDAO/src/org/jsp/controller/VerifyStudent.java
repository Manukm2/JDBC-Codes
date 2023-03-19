package org.jsp.controller;

import java.util.Scanner;

import org.jsp.dao.StudentDao;
import org.jsp.dto.Student;
//Student Dept : cs
//Student Perc : 55.66


//Student Dept : xjkdh
//Student Perc : 3.36

public class VerifyStudent 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the percentage of the Student : ");
		double perc = sc.nextDouble();
		System.out.println("Enter the Department of the Student : ");
		String dept = sc.next();
		sc.close();
		
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.verifyStudent(perc, dept);
		if (student != null) {
			System.out.println("Student ID : " + student.getId());
			System.out.println("Student Name : " + student.getName());
			System.out.println("Student Dept : " + student.getDept());
			System.out.println("Student Perc : " + student.getPerc());
			System.out.println("---------------------------------");
		} else {
			System.out.println("Invalid Percentage and Department !");
		}
	}
}
