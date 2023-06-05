package Models;

import Models.Enums.Role;
import Models.Interfaces.Salary;

public class Delivery extends Employee implements Salary {
    public Delivery(String name, String email, String ID, String password, Role role) {
        super(name, email, password, role);
    }

    @Override
    public void calculateSalary() {
        this.salary = baseSalary *2;
    }
}
