import java.util.Date;

public class Consultation {
    // Instance Variables
    private Date dateAndTime;

    private String docName;

    private int docId;
    private double cost;
    private String notes;

    // Constructor
    public Consultation(String docName,int docId,Date dateAndTime, double cost, String notes){
        this.docName = docName;
        this.docId = docId;
        this.dateAndTime = dateAndTime;
        this.cost = cost;
        this.notes = notes;
    }

    // Setters
    public void setDateAndTime(Date dateAndTime){this.dateAndTime = dateAndTime;}

    public void setCost(double cost){this.cost = cost;}

    public void setNotes(String notes){this.notes = notes;}

    // Getters
    public Date getDateAndTime(){return dateAndTime;}

    public double getCost(){return cost;}

    public String getNotes(){return notes;}
}
