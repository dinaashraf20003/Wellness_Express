package Models;

public abstract class User {
    //Declaring variables
    private String name;
    private String email;
    private String id;
    protected String password;

    //Constructors
    public User(){}
    public User (String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User (String name, String email, String id, String password){
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name){
        this.name = Name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String Email){
        this.email = Email;
    }

    public String getID() {
        return id;
    }

    public void setID(String ID) {
        this.id = ID;
    }
    public String getPassword() {
        return this.password;
    }
}
