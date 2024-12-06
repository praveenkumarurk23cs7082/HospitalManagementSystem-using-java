public class Doctor extends Person implements MedicalService {
    private String specialization;
    private String doctorID;

    public Doctor(String name, int age, String gender, String contact, String specialization, String doctorID) {
        super(name, age, gender, contact);
        this.specialization = specialization;
        this.doctorID = doctorID;
    }

    @Override
    public void displayInfo() {
        System.out.println("Doctor Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Contact: " + getContact());
        System.out.println("Specialization: " + specialization);
        System.out.println("Doctor ID: " + doctorID);
    }

    @Override
    public void provideMedicalService(Patient patient) {
        System.out.println("Providing medical service to " + patient.getName());
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getDoctorID() {
        return doctorID;
    }
}