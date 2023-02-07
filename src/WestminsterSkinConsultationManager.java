import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    public static int maximumDoctors = 10;

    public static int availableDoctors = 0;

    private ArrayList<Doctor> doctorList = new ArrayList<>(maximumDoctors);

    static Scanner input = new Scanner(System.in);

    //static WestminsterSkinConsultationManager westminsterSkinConsultationManager = new WestminsterSkinConsultationManager();

    // geeters
    public ArrayList<Doctor> getDoctorList(){
        return doctorList;
    }

    public ArrayList<Doctor> getDoctors() {return doctorList;}

    //setters
    public void setDoctors(ArrayList<Doctor> doctors){this.doctorList=doctors;}

    public void docToString(){
        System.out.println("************************");
        for (int i = 0; i < doctorList.size();i++){
            System.out.println("Doctor's Medical License No :"+doctorList.get(i).getMedicalLicenceNumber());
            System.out.println("Doctor's Name :"+doctorList.get(i).getName());
            System.out.println("Doctor's Sure Name :"+doctorList.get(i).getSurname());
            System.out.println("Doctor's date of birthday :"+doctorList.get(i).getDateOfBirth());
            System.out.println("Doctor's mobile number :"+doctorList.get(i).getMobileNumber());
            System.out.println("Doctor's Specialisation :"+doctorList.get(i).getSpecialisation());
        }
        System.out.println("************************");
    }


    @Override
    public void addDoctor(WestminsterSkinConsultationManager westminsterSkinConsultationManager) {
        System.out.println("Enter doctor's Medical Licence number :");
        String docMedicalLicenseNumber = input.next();
        for (Doctor doctor : doctorList){
            if (docMedicalLicenseNumber.equalsIgnoreCase(doctor.getMedicalLicenceNumber())){
                System.out.println("Sorry !, "+ docMedicalLicenseNumber +" is already exist.!!!\n");
                System.out.println("Do you want to continue or leave to main menu?\nIf so, Enter Y-[Yes] or Enter N-[No] : ");
                String answer = input.next();
                answer = answer.toLowerCase();
                if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")){
                    addDoctor(westminsterSkinConsultationManager);
                }else {
                    Menu(westminsterSkinConsultationManager);
                }
            }
        }
        System.out.println("Enter the Doctor's Name : ");
        String docName = input.next();

        System.out.println("Enter the Doctor's Surname : ");
        String docSurname = input.next();

        System.out.println("Enter the Doctor's date of birthday :");
        String docDOB = input.next();

        System.out.println("Enter the Doctor's mobile number : ");
        int docMobileNumber = input.nextInt();

        System.out.println("Enter the Doctor's Specialization : ");
        String docSpecialization = input.next();

        Doctor doctor = new Doctor(docName, docSurname, docDOB, docMobileNumber, docMedicalLicenseNumber, docSpecialization);


        if (doctorList.size() <= maximumDoctors){
            if (doctor instanceof Doctor){
                doctorList.add(doctor);
                this.availableDoctors += 1;
                System.out.println("Doctor has been added to the list.");
                System.out.println("Total doctors available in the center : "+ availableDoctors);
            }else {
                System.out.println("Invalid !");
            }

        }else {
            System.out.println("No space available for doctors in the center..");
        }

        System.out.println("\n");
        System.out.println("Do you want to add another doctor ? If so, Enter Y-[Yes] or Enter N-[No] :");
        String answer = input.next();
        answer = answer.toLowerCase();
        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")){
            addDoctor(westminsterSkinConsultationManager);
        }else {
            Menu(westminsterSkinConsultationManager);
        }

    }

    @Override
    public void deleteDoctor(WestminsterSkinConsultationManager westminsterSkinConsultationManager) {
        System.out.println("Input Doctor's Medical licence number to delete :");
        String answerMedicalNumber = input.next();
        boolean foundDoctor = false;
        for (Doctor doctor : doctorList){
            if (answerMedicalNumber.equalsIgnoreCase(doctor.getMedicalLicenceNumber())){
                if (doctor instanceof Doctor){
                    doctorList.remove(doctor);
                    foundDoctor = true;
                    availableDoctors -= 1;
                    System.out.println("==============================================================================");
                    System.out.println("Medical licence number "+doctor.getMedicalLicenceNumber()+" has been deleted successfully.");
                    System.out.println("Doctor's specialisation :"+doctor.getSpecialisation());
                    System.out.println("Doctor's name : "+doctor.getName());
                    System.out.println("Doctor's surname : "+doctor.getSurname());
                    System.out.println("Doctor's date of birthday :"+doctor.getDateOfBirth());
                    System.out.println("Doctor's mobile number : "+doctor.getMobileNumber());
                    System.out.println("Total available doctors in the center now : "+availableDoctors);
                    System.out.println("==============================================================================");
                    break;
                }else {
                    System.out.println("Invalid input.!");
                }

            }
            foundDoctor = false;
        }
        if (!foundDoctor){
            System.out.println("Corresponding doctor is not available");
        }
        System.out.println("\n");
        System.out.println("Do you want to delete a another doctor ? If so, Enter Y-[Yes] or Enter N-[No] :");
        String answer = input.next();
        answer = answer.toLowerCase();
        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")){
            deleteDoctor(westminsterSkinConsultationManager);
        }else {
            Menu(westminsterSkinConsultationManager);
        }



    }

    public static class sortDoctorName implements Comparator<Doctor>{


        public int compare(Doctor o1, Doctor o2) {
            return o1.getSurname().compareToIgnoreCase(o2.getSurname());
        }
    }

    @Override
    public void printDoctor(WestminsterSkinConsultationManager westminsterSkinConsultationManager) {
        System.out.println("Doctor's in the clinic========================>>>>>>>>>>");
        Collections.sort(doctorList,new sortDoctorName());
        /*Collections.sort(doctorList, new Comparator<Doctor>() {
            @Override
            public int compare(Doctor o1, Doctor o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });*/
        for (Doctor doctor : doctorList){
            if (doctor.getMedicalLicenceNumber().isEmpty()){
                System.out.println("No Doctor's in the clinic right now.!");
                break;
            }else {
                System.out.println("=============================================================");
                System.out.println("Doctor's Medical Licence number :  "+doctor.getMedicalLicenceNumber());
                System.out.println("Doctor's Name : "+ doctor.getName());
                System.out.println("Doctor's surname :"+doctor.getSurname());
                System.out.println("Doctor's date of birthday : "+ doctor.getDateOfBirth());
                System.out.println("Doctor's mobile number : "+doctor.getMobileNumber());
                System.out.println("Doctor's Specialization : "+ doctor.getSpecialisation());
                System.out.println("=============================================================");
            }
        }
        System.out.println("\n");
        System.out.println("Do you want to print the doctor's details again? If so, Enter Y-[Yes] or Enter N-[No] :");
        String answer = input.next();
        answer = answer.toLowerCase();
        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")){
            printDoctor(westminsterSkinConsultationManager);
        }else {
            Menu(westminsterSkinConsultationManager);
        }

    }

    @Override
    public void saveInFile(WestminsterSkinConsultationManager westminsterSkinConsultationManager) {
        try{
            FileWriter fileWriter = new FileWriter("ReadableDoctors.txt");
            for (Doctor doctor : doctorList){
                fileWriter.write("Doctor Licence number :"+ doctor.getName()+"\n"+
                        "Doctor's name : "+doctor.getSurname()+"\n"+
                        "Doctor's date of birthday : "+doctor.getDateOfBirth()+"\n"+
                        "Doctor's mobile number : "+ doctor.getMobileNumber()+"\n"+
                        "Doctor's licence :"+doctor.getMedicalLicenceNumber()+"\n"+
                        "Doctor's specialization : "+ doctor.getSpecialisation());
            }
            fileWriter.close();
            System.out.println("File created and wrote doctor's details successfully.");
            System.out.println("");

            FileOutputStream fileOutputStream = new FileOutputStream("Doctors.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(doctorList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*File file = new File("Drivers.txt");
        if (file.createNewFile()){
            System.out.println(file.getName()+" created !!!");
        }else {
            System.out.println(file.getName()+" already exists !!!");
        }
        FileWriter writer = new FileWriter(file);
        for (Formula1Driver driver:drivers){
            writer.write(driver.getName()+"," +
                    driver.getLocation()+"," +
                    driver.getTeam()+"," +
                    driver.getFirstPositions()+"," +
                    driver.getSecondPositions()+"," +
                    driver.getThirdPositions()+"," +
                    driver.getRaces()+"," +
                    driver.getPoints()+"\n");
        }
        writer.close();
        return "Drivers saved successfully !";*/



        System.out.println("\n");
        System.out.println("Do you want to save the doctor's details again? If so, Enter Y-[Yes] or Enter N-[No] :");
        String answer = input.next();
        answer = answer.toLowerCase();
        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")){
            printDoctor(westminsterSkinConsultationManager);
        }else {
            Menu(westminsterSkinConsultationManager);
        }
    }

    public void loadDoctors() {
        File file = new File("Doctors.txt");
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream("Doctors.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                doctorList = (ArrayList<Doctor>) objectInputStream.readObject();
                System.out.println(doctorList.toString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    // This is for to load doctor details to GUI class
    public ArrayList<Doctor> loadDoctors2() {
        File file = new File("Doctors.txt");
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream("Doctors.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                doctorList = (ArrayList<Doctor>) objectInputStream.readObject();
                //System.out.println(doctorList.toString());
                return doctorList;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }


    public ArrayList<Doctor> loadDoctorsss(){
        File file = new File("ReadableDoctors.txt");
        ArrayList<Doctor> doctorArrayList = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextLine()) {
            String loadedData = scanner.nextLine();
            String[] splitData = loadedData.split(",");
            Doctor doctor = new Doctor(splitData[0], splitData[1], splitData[2], Integer.parseInt(splitData[3]), splitData[4], splitData[5]);
            doctorArrayList.add(doctor);
        }
        scanner.close();
        return doctorArrayList;
    }

    public void Gui(){
        GUI gui = new GUI();
        gui.setVisible(true);

    }

    public static void main(String[] args) {
        //******
        WestminsterSkinConsultationManager westminsterSkinConsultationManager = new WestminsterSkinConsultationManager();
        //ArrayList<Doctor> doctorList = new ArrayList<>(maximumDoctors);
        westminsterSkinConsultationManager.loadDoctors2();
        westminsterSkinConsultationManager.loadDoctors();
        Menu(westminsterSkinConsultationManager);
    }

    public static void Menu(WestminsterSkinConsultationManager westminsterSkinConsultationManager){
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\t\t\t|----------------------------------------------------------------|");
        System.out.println("\t\t\t\t\t\t\t\t\t\t|-----------------WESTMINSTER SKIN CONSULTATION------------------|");
        System.out.println("\t\t\t\t\t\t\t\t\t\t|----------------------------------------------------------------|");
        System.out.println();
        //System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t[1] Add a new doctor\t\t\t\t\t\t[4] Save in file");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t[2] Delete a doctor\t\t\t\t\t\t\t[5] GUI");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t[3] Print the list of doctors\t\t\t\t[6] Exit");
        //System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println();
        System.out.println();
        validate(westminsterSkinConsultationManager);
    }
    public static void validate(WestminsterSkinConsultationManager westminsterSkinConsultationManager){
        System.out.println();
        System.out.println("Enter 1,2,3,4,5 or 6 to select a option");
        System.out.println("Choose an option : ");
        int option = input.nextInt();

        while (true){
            if (option == 1){
                westminsterSkinConsultationManager.addDoctor(westminsterSkinConsultationManager);
                break;
            } else if (option == 2) {
                westminsterSkinConsultationManager.deleteDoctor(westminsterSkinConsultationManager);
                break;
            } else if (option == 3) {
                westminsterSkinConsultationManager.printDoctor(westminsterSkinConsultationManager);
                break;
            } else if (option == 4) {
                westminsterSkinConsultationManager.saveInFile(westminsterSkinConsultationManager);
                break;
            } else if (option == 5) {
                westminsterSkinConsultationManager.Gui();
                break;
            } else if (option == 6) {
                System.out.println("|-----------------THANK YOU------------------|");
                System.exit(0);
            } else {
                System.out.println("Invalid input");
                break;
            }
            System.out.println();
            // Ask whether user need to continue the program.
            System.out.println("Would you like to continue ? \nY-[Yes] or N-[No] : ");
            String answer = input.next();
            answer = answer.toLowerCase();
            if (answer.equals("y") || answer.equals("yes")){
                Menu(westminsterSkinConsultationManager);
            } else if (answer.equals("n") || answer.equals("no")) {
                System.out.println("|-----THANK YOU-----|");
                System.exit(0);
            }else {
                System.out.println("Invalid input !!");
                System.exit(0);
            }
        }
    }

    public void sortSurname (ArrayList<Doctor> doctorsListtt){
        doctorsListtt.sort(new Comparator<Doctor>() {
            @Override
            public int compare(Doctor o1, Doctor o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });
    }
    /*public static void addDoctor(){
        Doctor doctor;
        westminsterSkinConsultationManager.addDoctor();

    }*/
}
