public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String date;
    private String time;
    private String purpose;

    public Appointment(Doctor doctor, Patient patient, String date, String time, String purpose) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.time = time;
        this.purpose = purpose;
        
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getPurpose() {
        return purpose;
    }
}