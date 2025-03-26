package composite;

public class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

//    public void showEmp() {
//        System.out.println("<Employee> " + name +" </Employee>");
////        System.out.println("<Salary> " + salary + " </Salary>");
//    }
    public void showEmp(String indent) {
        System.out.println(indent + "<Employee> " + name +" </Employee>");
    }
}
