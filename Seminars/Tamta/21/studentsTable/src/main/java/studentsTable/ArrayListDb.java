package studentsTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDb {
    private List<Student> students;

    public ArrayListDb() {
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
