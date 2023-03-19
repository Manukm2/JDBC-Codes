package org.jsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jsp.dto.Student;

public class StudentDao {
	static Connection connection;
	PreparedStatement preparedStatement;
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/btm";
	public static final String USER = "root";
	public static final String PASSWORD = "admin";
	{
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void saveStudent(Student student) {
		try {
			preparedStatement = connection.prepareStatement("insert into student values(?,?,?,?)");
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getDept());
			preparedStatement.setDouble(4, student.getPerc());
			preparedStatement.executeUpdate();
			System.out.println("Resource opened");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(connection, preparedStatement, null);
			System.out.println("Resource Closed");
		}
	}

	public void updateStudent(Student student) {
		try {
			preparedStatement = connection.prepareStatement("update student set name=?, dept=?, perc=? where id=?");
			preparedStatement.setInt(4, student.getId());
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getDept());
			preparedStatement.setDouble(3, student.getPerc());
			preparedStatement.executeUpdate();
			System.out.println("Resource opened");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(connection, preparedStatement, null);
			System.out.println("Resource Closed");
		}
	}

	public void deleteStudent(int id) {
		String query = "delete from student where id=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("Resource opened");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(connection, preparedStatement, null);
			System.out.println("Resource Closed");
		}
	}

	public Student getStudent(int id) {
		String query = "select * from student where id=?";
		Student student = new Student();
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				student.setId(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setDept(resultSet.getString(3));
				student.setPerc(resultSet.getDouble(4));
			} else
				student = null;
			System.out.println("Resource opened");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(connection, preparedStatement, resultSet);
			System.out.println("Resource Closed");
		}
		return student;
	}
	public Student verifyStudent(double perc, String dept) {
		String query = "select * from student where perc=? and dept=?";
		Student student = new Student();
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDouble(1, perc);
			preparedStatement.setString(2, dept);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				student.setId(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setDept(resultSet.getString(3));
				student.setPerc(resultSet.getDouble(4));
			} else
				student = null;
			System.out.println("Resource opened");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(connection, preparedStatement, resultSet);
			System.out.println("Resource Closed");
		}
		return student;
	}

	public List<Student> getAllStudent() {
		String query = "select * from student";
		List<Student> students = new ArrayList<Student>();
		ResultSet resultSet = null;
		try {

			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setDept(resultSet.getString(3));
				student.setPerc(resultSet.getDouble(4));
				students.add(student);
			}
			System.out.println("Resource opened");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(connection, preparedStatement, resultSet);
			System.out.println("Resource Closed");
		}
		return students;
	}

	public void closeResources(Connection con, PreparedStatement pst, ResultSet rs) {
		try {
			if (con != null)
				con.close();
			if (pst != null)
				pst.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
