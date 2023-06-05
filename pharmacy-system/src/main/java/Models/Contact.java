package Models;

public abstract class Contact {
    public String address;
    public String phoneNumber;
    public String email;

    public Contact(String address, String phoneNumber, String email) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
