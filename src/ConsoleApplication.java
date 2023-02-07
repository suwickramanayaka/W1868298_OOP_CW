//import java.util.Scanner;
//
//public class ConsoleApplication {
//
//    static Scanner input = new Scanner(System.in);
//
//    static WestminsterSkinConsultationManager westminsterSkinConsultationManager = new WestminsterSkinConsultationManager();
//
//    public static void main(String[] args) {
//        Menu();
//    }
//
//    public static void Menu(){
//        System.out.println();
//        System.out.println("\t\t\t\t\t\t\t\t\t\t|----------------------------------------------------------------|");
//        System.out.println("\t\t\t\t\t\t\t\t\t\t|-----------------WESTMINSTER SKIN CONSULTATION------------------|");
//        System.out.println("\t\t\t\t\t\t\t\t\t\t|----------------------------------------------------------------|");
//        System.out.println();
//        //System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//        System.out.println("\t\t\t\t\t\t\t\t\t\t\t[1] Add a new doctor\t\t\t\t\t\t[4] Save in file");
//        System.out.println("\t\t\t\t\t\t\t\t\t\t\t[2] Delete a doctor\t\t\t\t\t\t\t[5] GUI");
//        System.out.println("\t\t\t\t\t\t\t\t\t\t\t[3] Print the list of doctors\t\t\t\t[6] Exit");
//        //System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//        System.out.println();
//        System.out.println();
//        validate();
//    }
//    public static void validate(){
//        System.out.println();
//        System.out.println("Enter 1,2,3,4,5 or 6 to select a option");
//        System.out.println("Choose an option : ");
//        int option = input.nextInt();
//
//        while (true){
//            if (option == 1){
//                addDoctor();
//                break;
//            } else if (option == 2) {
//                westminsterSkinConsultationManager.deleteDoctor();
//                break;
//            } else if (option == 3) {
//                westminsterSkinConsultationManager.printDoctor();
//                break;
//            } else if (option == 4) {
//                westminsterSkinConsultationManager.saveInFile();
//                break;
//            } else if (option == 5) {
//                westminsterSkinConsultationManager.Gui();
//                break;
//            } else if (option == 6) {
//                System.exit(0);
//            } else {
//                System.out.println("Invalid input");
//                break;
//            }
//            System.out.println();
//            // Ask whether user need to continue the program.
//            System.out.println("Would you like to continue ? \nY-[Yes] or N-[No] : ");
//            String answer = input.next();
//            answer = answer.toLowerCase();
//            if (answer.equals("y") || answer.equals("yes")){
//                Menu();
//            } else if (answer.equals("n") || answer.equals("no")) {
//                System.out.println("|-----THANK YOU-----|");
//                System.exit(0);
//            }else {
//                System.out.println("Invalid input !!");
//                System.exit(0);
//            }
//        }
//    }
//    public static void addDoctor(){
//        Doctor doctor;
//        westminsterSkinConsultationManager.addDoctor();
//
//    }
//}
