public class Treatment {
    private String treatmentName;
    private Doctor doctor;
    private Patient patient;
    private String treatmentDetails;

    public Treatment(String treatmentName, Doctor doctor, Patient patient, String treatmentDetails) {
        this.treatmentName = treatmentName;
        this.doctor = doctor;
        this.patient = patient;
        this.treatmentDetails = treatmentDetails;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getTreatmentDetails() {
        return treatmentDetails;
    }
}