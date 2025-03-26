package composite;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private int depSalary;
    private List<Employee> employees=new ArrayList<>();
    private List<Department> departments=new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }


    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public void addDepartment(Department dep) {
        departments.add(dep);
    }

    public void removeEmployee(Employee emp) {
        employees.remove(emp);
    }

    public void removeDepartment(Department dep) {
        departments.remove(dep);
    }

    public int getDepSalary() {
        depSalary = 0;

        if (employees!=null) {
            for (Employee emp : employees) {
                depSalary += emp.getSalary();
            }
        }
        if (departments!=null) {
            for (Department dep : departments) {
                depSalary += dep.getDepSalary();
            }
        }
        return depSalary;
    }

public void showDep(String indent) {

    System.out.println(indent + "<Department name=\"" + name + "\">");


    for (Department dep : departments) {
        dep.showDep(indent + "    ");
    }


    for (Employee emp : employees) {
        emp.showEmp(indent + "    ");
    }


    System.out.println(indent + "</Department>");
}

}
