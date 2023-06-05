package Models;

import Models.Enums.Role;
import Models.Interfaces.Salary;

public class Pharmacist extends Employee implements Salary {
    public Pharmacist(String name, String email, String ID, String password, Role role) {
        super(name, email, ID, password, role);
    }

    @Override
    public void calculateSalary() {
        this.salary = baseSalary *3;
    }
}
