public class Patient extends Person {
    private String patientID;
    private String medicalHistory;
    private boolean isAdmitted;

    public Patient(String name, int age, String gender, String contact, String patientID, String medicalHistory) {
        super(name, age, gender, contact);
        this.patientID = patientID;
        this.medicalHistory = medicalHistory;
        this.isAdmitted = false;
    }

    @Override
    public void displayInfo() {
        System.out.println("Patient Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Contact: " + getContact());
        System.out.println("Patient ID: " + patientID);
        System.out.println("Medical History: " + medicalHistory);
        System.out.println("Is Admitted: " + isAdmitted);
    }

    public String getPatientID() {
        return patientID;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public boolean isAdmitted() {
        return isAdmitted;
    }

    public void setAdmitted(boolean admitted) {
        isAdmitted = admitted;
    }
}