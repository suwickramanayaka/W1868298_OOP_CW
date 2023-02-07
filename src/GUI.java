import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GUI extends JFrame {
    //sort button
    private JButton sortButton;
    //Add consultation button
    private JButton addConsultationButton;
    //View Consultations
    private JButton viewConsultationButton;
    //Label
    private JLabel titleLabel;

    //Doctor[] doctors = new Doctor[10];

    ArrayList<Consultation> consultationArrayList = new ArrayList<>();


    GUI(){
        WestminsterSkinConsultationManager westminsterSkinConsultationManager = new WestminsterSkinConsultationManager();
        westminsterSkinConsultationManager.setDoctors(westminsterSkinConsultationManager.loadDoctors2());

        ArrayList<Doctor> doctorArrayList = westminsterSkinConsultationManager.loadDoctors2();

        // Declare GUI Home
        setSize(500,500);
        setTitle("Westminster Skin Consultation");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(100,100);
        //setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Declare title label
        titleLabel = new JLabel("Available Doctors");
        titleLabel.setFont(new Font("",1,20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        // Declare sort button
        sortButton = new JButton("Sort");
        sortButton.setFont(new Font("",1,10));
        //sortButton.setPreferredSize(new Dimension(20,20));
        try {
            sortButton.addActionListener(new ActionListener() {

                static class sortDocName implements Comparator<Doctor>{


                    public int compare(Doctor o1, Doctor o2) {
                        return o1.getMedicalLicenceNumber().compareToIgnoreCase(o2.getMedicalLicenceNumber());
                    }
                }
                @Override
                public void actionPerformed(ActionEvent e) {
                    WestminsterSkinConsultationManager westminsterSkinConsultationManager1 = new WestminsterSkinConsultationManager();
                    westminsterSkinConsultationManager1.setDoctors(westminsterSkinConsultationManager1.loadDoctors2());


                    ArrayList<Doctor> doctorArrayList1 = westminsterSkinConsultationManager1.getDoctors();
                    Collections.sort(doctorArrayList1,new sortDocName());
                    //westminsterSkinConsultationManager1.sortSurname(doctorArrayList1);
                    /*Collections.sort(sortedDoctors, new Comparator<Doctor>() {
                        @Override
                        public int compare(Doctor o1, Doctor o2) {
                            return o1.getMedicalLicenceNumber().compareTo(o2.getMedicalLicenceNumber());
                        }
                    });*/
                    ArrayList<Doctor> sortedDoctors = new ArrayList<>(doctorArrayList1);


                    new DoctorInformation(sortedDoctors);

                }
            });
        }catch (IndexOutOfBoundsException e){
            System.out.println("Empty Table !");
        }



        // Declare Add Consultation Button
        addConsultationButton =  new JButton("Add Consultation");
        addConsultationButton.setFont(new Font("",1,10));
        addConsultationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddConsultation addConsultation = new AddConsultation(doctorArrayList);
                addConsultation.setVisible(true);
            }
        });

        // Declare View Consultation Button
        viewConsultationButton = new JButton("View Consultation");
        viewConsultationButton.setFont(new Font("",1,10));
        viewConsultationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewConsultation viewConsultation = new ViewConsultation(consultationArrayList);
                viewConsultation.setVisible(true);
            }
        });

        // New Panel inside boarder layout south
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(addConsultationButton);
        panel1.add(viewConsultationButton);
        panel1.add(sortButton);

        DoctorInformation doctorInformation = new DoctorInformation(doctorArrayList);



        //Creats a scrollpane for tabale
        JScrollPane scrollPane = new JScrollPane(doctorInformation.getDoctorDetails());


        add("North",titleLabel);
        add("South",panel1);
        add("Center",scrollPane);



    }



}
class DoctorInformation{

    private JTable doctorDetails;

    public DoctorInformation(ArrayList<Doctor> doctorArrayList){

        // Creating doctor table
        String[] doctorTableColumns = {"Medical Licence NO","First Name","Sure Name","Specialisation"};
        Object[][] doctorTableData = new Object[doctorArrayList.size()][4];
        doctorDetails = new JTable(doctorTableData,doctorTableColumns);
        doctorDetails.getTableHeader().setReorderingAllowed(false);
        doctorDetails.setEnabled(false);
        // Filling the table with driver data
        for (int i = 0; i < doctorArrayList.size();i++){
            doctorTableData[i][0] = doctorArrayList.get(i).getMedicalLicenceNumber();
            doctorTableData[i][1] = doctorArrayList.get(i).getName();
            doctorTableData[i][2] = doctorArrayList.get(i).getSurname();
            doctorTableData[i][3] = doctorArrayList.get(i).getSpecialisation();
        }

    }

    public JTable getDoctorDetails(){return doctorDetails;}

}

class ViewConsultation extends JFrame{

    public ViewConsultation(ArrayList<Consultation> consultationArrayList){
        setSize(500,500);
        setTitle("Westminster Skin Consultation");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocation(100,100);
        JTable viewTable;


        // Creating doctor table
        String[] doctorTableColumns = {"Medical Licence NO","First Name","Sure Name","Specialisation"};
        Object[][] doctorTableData = new Object[consultationArrayList.size()][4];
        viewTable = new JTable(doctorTableData,doctorTableColumns);
        viewTable.getTableHeader().setReorderingAllowed(false);
        viewTable.setEnabled(false);
        // Filling the table with driver data
        for (int i = 0; i < consultationArrayList.size();i++){
            //doctorTableData[i][0] = consultationArrayList.get(i).getMedicalLicenceNumber();
            //doctorTableData[i][1] = consultationArrayList.get(i).getName();
            //doctorTableData[i][2] = consultationArrayList.get(i).getSurname();
            //doctorTableData[i][3] = consultationArrayList.get(i).getSpecialisation();
        }
        add(viewTable);

    }
}

class AddConsultation extends JFrame{

    public void saveConsultationDate(){}
    public AddConsultation(ArrayList<Doctor> doctorArrayList){
        // Creates the Frame
        setSize(500,500);
        setTitle("Add Consultation");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocation(700,100);
        //setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //create label for check doctor
        JLabel checkDoctorLabel = new JLabel("Doctor Name :");
        checkDoctorLabel.setFont(new Font("",1,15));

        //create text field for doctor name
        JTextField doctorTextField = new JTextField(5);
        doctorTextField.setFont(new Font("",1,15));
        /////////////////////////////////////////
        String docName = doctorTextField.getText();

        //create label for patient id
        JLabel patientIdLabel = new JLabel("Patient Id: ");
        patientIdLabel.setFont(new Font("",1,15));

        //create textarea for patient id
        JTextField patientIdTextArea = new JTextField();
        patientIdTextArea.setFont(new Font("",1,15));
        ////////////////////////////////////////////
        String patientIdInt = patientIdTextArea.getText();

        //create date label
        JLabel dateLabel = new JLabel("Date : ");
        dateLabel.setFont(new Font("",1,15));

        //create text field for date
        JTextField dateTextField = new JTextField(5);
        dateTextField.setFont(new Font("",1,15));
        /////////////////////////////////////////
        String docDate = dateTextField.getText();
        
        //create button for search
        JButton searchButton = new JButton("SEARCH");
        searchButton.setFont(new Font("",1,15));

        // create patient name
        JLabel patientLabel = new JLabel("First Name :");
        patientLabel.setFont(new Font("",1,15));

        // create patient textfield
        JTextField nameTextField = new JTextField(5);
        nameTextField.setFont(new Font("",1,15));
        /////////////////////////////////////
        String patientName = nameTextField.getText();

        //create paitent sue name label
        JLabel surenameLabel = new JLabel("Sure Name :");
        surenameLabel.setFont(new Font("",1,15));

        //  create label for paitient surename
        JTextField surenameTextField = new JTextField(5);
        surenameTextField.setFont(new Font("",1,15));
        //////////////////////////////////
        String patientSureName = surenameTextField.getText();

        //create date of birthday label
        JLabel dobLabel = new JLabel("Date of birthday :");
        dobLabel.setFont(new Font("",1,15));

        //create textFiels for date of birthday
        JTextField dobTextField = new JTextField(5);
        dobTextField.setFont(new Font("",1,15));
        ///////////////////////////////////////////
        String patientDob = dobTextField.getText();

        // create label for mobile number
        JLabel mobileNumberLabel =  new JLabel("Mobile Number :");
        mobileNumberLabel.setFont(new Font("",1,15));

        //create textfield for mobile number
        JTextField mobileTextField = new JTextField(5);
        mobileTextField.setFont(new Font("",1,15));
        //int patientMobileNumber = Integer.parseInt(mobileTextField.getText());

        //create label for notes
        JLabel noteLabel = new JLabel("Notes :");
        noteLabel.setFont(new Font("",1,15));

        // create text area for notes
        JTextArea noteArea = new JTextArea();
        noteArea.setFont(new Font("",1,15));
        String patientNotes = noteArea.getText();

        // create submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("",1,15));

        // create submit button
        JButton refreshButton = new JButton("Refresh");
        submitButton.setFont(new Font("",1,15));

        // create submit button
        JButton backButton = new JButton("Back");
        submitButton.setFont(new Font("",1,15));

        JPanel jPanelSouth = new JPanel();
        jPanelSouth.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jPanelSouth.add(backButton);
        jPanelSouth.add(refreshButton);
        jPanelSouth.add(submitButton);

        add("South",jPanelSouth);

        //add elemets to the frame
        JPanel jPanelNorth = new JPanel();
        jPanelNorth.setLayout(new GridLayout(3,2));
        jPanelNorth.add(checkDoctorLabel);
        jPanelNorth.add(doctorTextField);
        jPanelNorth.add(dateLabel);
        jPanelNorth.add(dateTextField);
        jPanelNorth.add(searchButton);
        //jPanelNorth.add(patientLabel);
        //jPanelNorth.add(nameTextField);

        add("North",jPanelNorth);

        JPanel jPanelCenter = new JPanel();
        jPanelCenter.setLayout(new GridLayout(6,2));
        jPanelCenter.add(patientLabel);
        jPanelCenter.add(nameTextField);
        jPanelCenter.add(surenameLabel);
        jPanelCenter.add(surenameTextField);
        jPanelCenter.add(patientIdLabel);
        jPanelCenter.add(patientIdTextArea);
        jPanelCenter.add(dobLabel);
        jPanelCenter.add(dobTextField);
        jPanelCenter.add(mobileNumberLabel);
        jPanelCenter.add(mobileTextField);
        jPanelCenter.add(noteLabel);
        jPanelCenter.add(noteArea);

        add("Center",jPanelCenter);

        /*// patient object and arraylist
        ArrayList<Patient> patientArrayList = new ArrayList<>();
        Patient patient = new Patient(patientName,patientSureName,patientDob,patientMobileNumber,patientIdInt);
        patientArrayList.add(patient);*/

        //Consultation object and arraylist

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveConsultationDate();
            }
        });



    }
}
