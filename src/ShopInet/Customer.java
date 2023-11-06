package ShopInet;

public class Customer {
    private String Name;
    private String FirstName;
    private int NumPhone;
    public Customer(String name, String firstName, int numPhone) {
        Name = name;
        FirstName = firstName;
        NumPhone = numPhone;
    }
    public String getName() {
        return Name;
    }

    public String getFirstName() {
        return FirstName;
    }

    public int getNumPhone() {
        return NumPhone;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setNumPhone(int numPhone) {
        NumPhone = numPhone;
    }

}
