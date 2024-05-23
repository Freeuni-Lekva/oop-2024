public class Employee {
    private String firstname;
    private String lastname;
    private Department department;
    private int salary;


    public Employee(int salary){
        this("dummy", "none", Department.OPERATIONS, salary);
    }

    public Employee(int salary, Department depp){
        this("dummy", "none", depp, salary);
    }

    public Employee(String firstname, String lastname, Department department, int salary) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
        this.salary = salary;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Department getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    enum Department {
        INFRASTRUCTURE,
        DATA_SCIENCE,
        OPERATIONS,
        HUMAN_RESOURCES
    }

}
