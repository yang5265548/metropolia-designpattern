package composite;

import java.util.ArrayList;
import java.util.List;

public class Organization {
    private String name;
    private List<Department> departments=new ArrayList<>();
    private List<Employee> employees=new ArrayList<>();
    private int orgSalary;

    public Organization(String name) {
        this.name = name;
    }

    public void addDepartment(Department dep) {
        departments.add(dep);
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public void removeDepartment(Department dep) {
        departments.remove(dep);
    }

    public void removeEmployee(Employee emp) {
        employees.remove(emp);
    }

    public void getOrgSalary() {
        orgSalary = 0;
        if (departments!=null) {
            for (Department dep : departments) {
                orgSalary += dep.getDepSalary();
            }
        }
        if (employees!=null) {
            for (Employee emp : employees) {
                orgSalary += emp.getSalary();
            }
        }
        System.out.println("Total Salary of the organization: " + orgSalary);

    }
    public void showOrg() {
        System.out.println("<OrgName> " + name + " </OrgName>");
        if (departments!=null) {
            for (Department dep : departments) {
                dep.showDep("  ");
            }
        }
        if (employees!=null) {
            for (Employee emp : employees) {
                emp.showEmp("  ");
            }
        }
    }

}
