package Models;

import Models.Enums.Type;

public class Supplier extends Contact {
    public String name;
    public Type type;

    public Supplier(String address, String phoneNumber, String email, String name, Type type) {
        super(address, phoneNumber, email);
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return this.name + "\n" + this.address + "\n" + "Specialization: " + this.type;
    }

 }
