import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEmployeeCatalog {

    private static EmployeeCatalog catalog;

    @Before
    public void init(){
        ArrayList<Employee> employeesList = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            int salary = new Random().nextInt(900) + 100;
            employeesList.add(new Employee("f","s", Employee.Department.DATA_SCIENCE, salary));
        }
        employeesList.add(new Employee("Elon","Musk", Employee.Department.INFRASTRUCTURE, 1100));
        employeesList.add(new Employee("Elon","Musk1", Employee.Department.INFRASTRUCTURE, 90));
        employeesList.add(new Employee("Erekle","Meore", Employee.Department.DATA_SCIENCE, 100000));

        catalog = new EmployeeCatalog(employeesList);

    }

    @Test
    public void findEmployeeWithHighestSalary(){
        Employee e = new Employee("Elon","Musk", Employee.Department.INFRASTRUCTURE, 100000);
        assertEquals(catalog.findEmployeeWithHighestSalary().getSalary(), e.getSalary());
    }

    @Test
    public void getSalaryGapInDepartment(){
        assertEquals(catalog.getSalaryGapInDepartment1(Employee.Department.INFRASTRUCTURE), 1010);
        assertEquals(catalog.getSalaryGapInDepartment2(Employee.Department.INFRASTRUCTURE), 1010);
    }

    @Test
    public void findDepartmentWithHighestCumulativeSalary(){
        assertEquals(catalog.findDepartmentWithHighestCumulativeSalary(), Employee.Department.DATA_SCIENCE);
    }
}