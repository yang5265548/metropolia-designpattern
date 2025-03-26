package composite;

public class Main {
    public static void main(String[] args) {
        Organization org = new Organization("ABC Corp");
        Department dep1 = new Department("HR");
        Department dep2 = new Department("Finance");
        Department dep3 = new Department("IT");
        Employee emp1 = new Employee("John", 1000);
        Employee emp2 = new Employee("Jane", 2000);
        Employee emp3 = new Employee("Jack", 3000);
        Employee emp4 = new Employee("Jill", 4000);
        Employee emp5 = new Employee("Joe", 5000);
        Employee emp6 = new Employee("Jenny", 6000);
        Employee emp7 = new Employee("Jesse", 7000);
        Employee emp8 = new Employee("Jasmine", 8000);
        Employee emp9 = new Employee("Jared", 9000);
        Employee emp10 = new Employee("Jocelyn", 10000);
        Employee emp11 = new Employee("Jasper", 11000);
        Employee emp12 = new Employee("Jenna", 12000);
        Employee emp13 = new Employee("Jared", 13000);
        org.addEmployee(emp11);
        org.addEmployee(emp12);
        dep1.addEmployee(emp1);
        dep1.addEmployee(emp2);
        dep1.addEmployee(emp3);
        dep1.addEmployee(emp4);
        dep1.addEmployee(emp5);
        dep2.addEmployee(emp6);
        dep2.addEmployee(emp7);
        dep2.addEmployee(emp8);
        dep2.addEmployee(emp9);
        dep2.addEmployee(emp10);
        org.addDepartment(dep1);
        org.addDepartment(dep2);
        dep1.addDepartment(dep3);
        dep3.addEmployee(emp13);
        org.getOrgSalary();
        org.showOrg();

        System.out.println("Removing Jasper from the organization");
        org.removeEmployee(emp11);
        org.getOrgSalary();
        org.showOrg();


    }
}
