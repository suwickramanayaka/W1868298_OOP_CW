public class Patient extends Person{
    // Instance variables
    private String patientID;

    // Parameterized Constructor
    public Patient(String name, String surname, String dateOfBirth, int mobileNumber, String patientID) {
        super(name, surname, dateOfBirth, mobileNumber);
        this.patientID = patientID;
    }

    // Setters
    public void setPatientID(String patientID){this.patientID = patientID;}

    // Getters
    public String getPatientID(){return patientID;}
}
