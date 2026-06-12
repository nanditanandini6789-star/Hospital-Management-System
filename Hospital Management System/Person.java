import java.util.ArrayList;
import java.util.Scanner;


class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


class Patient extends Person {
    private int patientId;
    private String gender;
    private String disease;

    public Patient(int patientId, String name, int age, String gender, String disease) {
        super(name, age);
        this.patientId = patientId;
        this.gender = gender;
        this.disease = disease;
    }

    public void displayPatient() {
        System.out.println("\nPatient ID: " + patientId);
        System.out.println("Name      : " + name);
        System.out.println("Age       : " + age);
        System.out.println("Gender    : " + gender);
        System.out.println("Disease   : " + disease);
    }
}

class Doctor extends Person {
    private int doctorId;
    private String specialization;
    private double fees;

    public Doctor(int doctorId, String name, int age,
                  String specialization, double fees) {
        super(name, age);
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.fees = fees;
    }

    public String getDoctorName() {
        return name;
    }

    public void displayDoctor() {
        System.out.println("\nDoctor ID      : " + doctorId);
        System.out.println("Name           : " + name);
        System.out.println("Age            : " + age);
        System.out.println("Specialization : " + specialization);
        System.out.println("Fees           : " + fees);
    }
}

class Appointment {
    private int appointmentId;
    private String patientName;
    private String doctorName;
    private String date;

    public Appointment(int appointmentId,
                       String patientName,
                       String doctorName,
                       String date) {

        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
    }

    public void displayAppointment() {
        System.out.println("\nAppointment ID : " + appointmentId);
        System.out.println("Patient Name   : " + patientName);
        System.out.println("Doctor Name    : " + doctorName);
        System.out.println("Date           : " + date);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Patient> patients = new ArrayList<>();
        ArrayList<Doctor> doctors = new ArrayList<>();
        ArrayList<Appointment> appointments = new ArrayList<>();

        int choice;

        do {

            System.out.println(" HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. Show All Patients");
            System.out.println("5. Show All Doctors");
            System.out.println("6. Show All Appointments");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Patient ID: ");
                    int pid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String pname = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int page = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Gender: ");
                    String gender = sc.nextLine();

                    System.out.print("Enter Disease: ");
                    String disease = sc.nextLine();

                    patients.add(new Patient(
                            pid, pname, page, gender, disease));

                    System.out.println("\nPatient Added Successfully!");
                    break;

                case 2:

                    System.out.print("Enter Doctor ID: ");
                    int did = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Doctor Name: ");
                    String dname = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int dage = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Specialization: ");
                    String specialization = sc.nextLine();

                    System.out.print("Enter Fees: ");
                    double fees = sc.nextDouble();

                    doctors.add(new Doctor(
                            did, dname, dage,
                            specialization, fees));

                    System.out.println("\nDoctor Added Successfully!");
                    break;

                case 3:

                    System.out.print("Enter Appointment ID: ");
                    int aid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String patientName = sc.nextLine();

                    System.out.print("Enter Doctor Name: ");
                    String doctorName = sc.nextLine();

                    System.out.print("Enter Appointment Date (DD-MM-YYYY): ");
                    String date = sc.nextLine();

                    appointments.add(new Appointment(
                            aid,
                            patientName,
                            doctorName,
                            date));

                    System.out.println("\nAppointment Booked Successfully!");
                    break;

                case 4:

                    System.out.println("\n PATIENT LIST ");

                    if (patients.isEmpty()) {
                        System.out.println("No Patient Found!");
                    } else {
                        for (Patient p : patients) {
                            p.displayPatient();
                        }
                    }
                    break;

                case 5:

                    System.out.println("\n DOCTOR LIST ");

                    if (doctors.isEmpty()) {
                        System.out.println("No Doctor Found!");
                    } else {
                        for (Doctor d : doctors) {
                            d.displayDoctor();
                        }
                    }
                    break;

                case 6:

                    System.out.println("\n APPOINTMENT LIST ");

                    if (appointments.isEmpty()) {
                        System.out.println("No Appointment Found!");
                    } else {
                        for (Appointment a : appointments) {
                            a.displayAppointment();
                        }
                    }
                    break;

                case 7:
                    System.out.println("\nThank You!");
                    break;

                default:
                    System.out.println("\nInvalid Choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}