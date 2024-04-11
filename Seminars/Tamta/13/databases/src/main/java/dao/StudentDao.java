package dao;

import bean.Course;
import bean.Student;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;

public class StudentDao {
    private final BasicDataSource dataSource;
    public StudentDao(BasicDataSource dataSource){
        this.dataSource = dataSource;
    }
    public ArrayList<Student> getStudents() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from students");
        ArrayList<Student> results = new ArrayList<>();
        while (resultSet.next()) {
            convertToStudent(resultSet);
            results.add(convertToStudent(resultSet));
        }
        return results;
    }

    public Student getStudentById(int studentId) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from students where students.id = ?");
        statement.setInt(1, studentId);
        ResultSet resultSet = statement.executeQuery();
        return convertToStudent(resultSet);
    }

    public ArrayList<Course> getStudentCourses(int studentId){
        return null;
    }

    private Student convertToStudent(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setStudentId(resultSet.getInt("id"));
        student.setIdNumber(resultSet.getString("idnumber"));
        student.setFirstName(resultSet.getString("firstname"));
        student.setLastName(resultSet.getString("lastname"));
        student.setRegisterDate(resultSet.getDate("register_date"));
        return student;
    }

}
