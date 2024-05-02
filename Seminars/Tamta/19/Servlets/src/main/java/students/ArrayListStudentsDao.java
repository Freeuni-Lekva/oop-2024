package students;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListStudentsDao {
    private List<Student> students;

    public ArrayListStudentsDao() {
        this.students = new ArrayList<>();
    }

    public synchronized void add(Student st) {
        students.add(st);
    }

    public synchronized void remove(Student st) {
        for (int i = 0; i < students.size(); i++) {
            if (st == students.get(i)) {
                students.remove(i);
                return;
            }
        }
    }

    public List<Student> getAll() {
        return Collections.unmodifiableList(students);
    }
}
