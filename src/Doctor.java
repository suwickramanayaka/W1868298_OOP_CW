import java.io.Serializable;

public class Doctor extends Person implements Serializable {

    // instance variables
    private String medicalLicenceNumber;
    private String specialisation;

    // Parameterized Constructor
    public Doctor(String name, String surname, String dateOfBirth, int mobileNumber, String medicalLicenceNumber, String specialisation) {
        super(name, surname, dateOfBirth, mobileNumber);
        this.medicalLicenceNumber = medicalLicenceNumber;
        this.specialisation = specialisation;
    }

    // Setters
    public void setMedicalLicenceNumber(String medicalLicenceNumber){this.medicalLicenceNumber = medicalLicenceNumber;}

    public void setSpecialisation(String specialisation){this.specialisation = specialisation;}

    // Getters
    public String getMedicalLicenceNumber(){return medicalLicenceNumber;}

    public String getSpecialisation(){return specialisation;}

    /*public String toString(){
        return getName()+"\t\t"+getSurname()+"\t\t"+getDateOfBirth()+"\t\t"+getMobileNumber()+"\t\t"+medicalLicenceNumber+"\t\t"+specialisation;
    }*/
}
