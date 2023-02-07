import java.io.Serializable;

public class Person implements Serializable {
    // instance variables
    private String name;
    private String surname;
    private String dateOfBirth; // if need you need to change this, whether you use API
    private int mobileNumber;

    // Parameterized Constructor
    public Person(String name,String surname,String dateOfBirth,int mobileNumber){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
    }

    // Setters
    public void setName(String name){this.name = name;}

    public void setSurname(String surname){this.surname = surname;}

    public void setDateOfBirth(String dateOfBirth){this.dateOfBirth = dateOfBirth;}

    public void setMobileNumber(int mobileNumber){this.mobileNumber = mobileNumber;}

    // Getters
    public String getName(){return name;}

    public String getSurname(){return surname;}

    public String getDateOfBirth(){return dateOfBirth;}

    public int getMobileNumber(){return mobileNumber;}
}
