import java.util.Scanner;
public class Q2 {
    public static void main(String[] args) {
        double[] salaries = {40000, 55000, 62000, 48000};
        Employee[] employees = new Employee[salaries.length];
        
        for (int i = 0; i < salaries.length; i++) {
            employees[i] = new Employee(salaries[i]);
            employees[i].raiseSalary(5000);
            System.out.println("E-10" + (i + 1) + " | Final Salary: Rs " + employees[i].salary);
        }
    }
}
class Employee {
    double salary;
    public Employee(double salary) {
        this.salary = salary;
    }
    public void raiseSalary(double salary) {
        this.salary += salary;
    }
}
