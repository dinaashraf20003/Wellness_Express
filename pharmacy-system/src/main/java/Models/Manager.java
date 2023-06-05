package Models;

import Models.Enums.Role;
import Models.Interfaces.Salary;

public class Manager extends Employee implements Salary {
    public Manager(String name, String email, String ID, String password, Role role, String email1) {
        super(name, email, password, role);
    }

    @Override
    public void calculateSalary() {
        this.salary = baseSalary *4;
    }
}
