import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class EmployeeCatalog {
    ArrayList<Employee> employees;

    public EmployeeCatalog(ArrayList<Employee> employees){
        this.employees = employees;
    }

    public Employee findEmployeeWithHighestSalary() {
        return employees
                .stream()
                .reduce(new Employee(0), (resultEmployee, currentEmployee) -> {
                    if (currentEmployee.getSalary() > resultEmployee.getSalary()){
                        return currentEmployee;
                    }
                    return resultEmployee;
                });
    }

    public int getSalaryGapInDepartment1(Employee.Department department){
        int max = employees
                .stream()
                .filter((x) -> x.getDepartment().equals(department))
                .reduce(new Employee(0), (resultEmployee, currentEmployee) -> {
                    if (currentEmployee.getSalary() > resultEmployee.getSalary()){
                        return currentEmployee;
                    }
                    return resultEmployee;
                }).getSalary();

        int min = employees
                .stream()
                .filter((x) -> x.getDepartment().equals(department))
                .reduce(new Employee(Integer.MAX_VALUE), (resultEmployee, currentEmployee) -> {
                    if (currentEmployee.getSalary() < resultEmployee.getSalary()){
                        return currentEmployee;
                    }
                    return resultEmployee;
                }).getSalary();

        return max-min;
    }

    private class MinMax{
        int min;
        int max;
        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public int getSalaryGapInDepartment2(Employee.Department department){
        MinMax result = employees
                .stream()
                .filter((x) -> x.getDepartment().equals(department))
                .map((x) -> new MinMax(x.getSalary(), x.getSalary()))
                .reduce(new MinMax(Integer.MAX_VALUE, 0), (resultMinMax, currMinMax) -> {

                    resultMinMax.min = min(resultMinMax.min, currMinMax.min);
                    resultMinMax.max = max(resultMinMax.max, currMinMax.max);

                    return resultMinMax;
                });

        return result.max-result.min;
    }

    public Employee.Department findDepartmentWithHighestCumulativeSalary(){
        return Arrays.stream(Employee.Department.values())
                .map((depp) ->
                    employees
                            .stream()
                            .filter((emp) -> emp.getDepartment() == depp)
                            .reduce(new Employee(0, depp), (resultEmp, curEmp) -> {
                                resultEmp.setSalary(resultEmp.getSalary() + curEmp.getSalary());
                                return resultEmp;
                            })
                ).reduce(new Employee(0), (resultEmp, curEmp) -> {
                    if( resultEmp.getSalary() < curEmp.getSalary()) {
                        resultEmp.setDepartment(curEmp.getDepartment());
                        resultEmp.setSalary(curEmp.getSalary());
                    }
                   return resultEmp;
                })
                .getDepartment();
    }

}
