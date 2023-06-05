package Models;
import Models.Enums.Priority;

public class Client extends User {
    private String address;
    private String phoneNumber;
    private Priority priority;


    public Client(String name, String email, String password, String address, String phoneNumber) {
        super(name, email, password);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.priority = Priority.NORMAL;
    }
    public Client(String name, String email, String id, String password, String address, String phoneNumber) {
        super(name, email, id, password);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.priority = Priority.NORMAL;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return this.getName() + "\n" + this.address + "\n" + this.phoneNumber;
    }


}
