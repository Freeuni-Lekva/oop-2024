package studentsTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface Db {
    void add(Student st);
    void remove(Student st);
    List<Student> getAll();
}
