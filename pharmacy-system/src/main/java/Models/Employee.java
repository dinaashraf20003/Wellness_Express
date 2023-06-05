package Models;

import Models.Enums.Role;

import java.util.Date;

public class Employee extends User {
    protected float salary;
    private Date hireDate;
    public Role role;

    public Employee(String name, String email, String password, Role role) {
        super(name, email, password);
        this.hireDate = new Date();
        this.role = role;
    }
    public Employee(String name, String email, String id, String password, Role role) {
        super(name, email, id, password);
        this.hireDate = new Date();
        this.role = role;
    }

    public float getSalary() {
        return salary;
    }

    public Date getHireDate() {
        return hireDate;
    }


}
