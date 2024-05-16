package studentsTable;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SqlDb implements Db{
    private BasicDataSource dataSource;
    public SqlDb(BasicDataSource dataSource){
     this.dataSource = dataSource;
    }
    @Override
    public void add(Student st) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "insert into students (idnumber, firstname, lastname)" +
                    " values (?, ?, ?);");
            statement.setString(1, st.getId());
            statement.setString(2, st.getFirstName());
            statement.setString(3, st.getLastName());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(Student st) {

    }

    @Override
    public List<Student> getAll() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from students");
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                Student student = new Student(
                        resultSet.getString("idnumber"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        10
                );
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;

    }
}
