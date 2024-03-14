package inheritance;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();
        Parent childP = new Child();
        parent.go();
        child.go();
        childP.go();

        Object a = new Parent();
        // runtime error: can't cast from parent (fewer functions) to child (more functions)
//        ((Child)a).go();
    }
}
