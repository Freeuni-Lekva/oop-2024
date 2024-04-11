import bean.Student;
import dao.StudentDao;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test_db");
        dataSource.setUsername("root");
        dataSource.setPassword("rootroot");

        StudentDao studentDao = new StudentDao(dataSource);
        ArrayList<Student> students = studentDao.getStudents();
        for (Student student: students) {
            System.out.println(student);
        }

    }
}
