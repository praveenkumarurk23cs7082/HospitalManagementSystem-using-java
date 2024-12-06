import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private List<Doctor> doctors;
    private List<Patient> patients;
    private List<Appointment> appointments;

    public Hospital() {
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
        appointments = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        List<Doctor> filteredDoctors = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (doctor.getSpecialization().equals(specialization)) {
                filteredDoctors.add(doctor);
            }
        }
        return filteredDoctors;
    }

    public Doctor getDoctorByID(String doctorID) {
        for (Doctor doctor : doctors) {
            if (doctor.getDoctorID().equals(doctorID)) {
                return doctor;
            }
        }
        return null;
    }

    public Patient getPatientByID(String patientID) {
        for (Patient patient : patients) {
            if (patient.getPatientID().equals(patientID)) {
                return patient;
            }
        }
        return null;
    }

    public void scheduleAppointment(Doctor doctor, Patient patient, String date, String time, String purpose) throws DoctorUnavailableException {
        // Check if doctor is available at the specified time
 for (Appointment appointment : appointments) {
            if (appointment.getDoctor().equals(doctor) && appointment.getDate().equals(date) && appointment.getTime().equals(time)) {
                throw new DoctorUnavailableException("Doctor is unavailable at the specified time.");
            }
        }

        // Schedule appointment
        Appointment appointment = new Appointment(doctor, patient, date, time, purpose);
        appointments.add(appointment);
    }

    public void displayAppointments() {
        for (Appointment appointment : appointments) {
            System.out.println("Doctor: " + appointment.getDoctor().getName());
            System.out.println("Patient: " + appointment.getPatient().getName());
            System.out.println("Date: " + appointment.getDate());
            System.out.println("Time: " + appointment.getTime());
            System.out.println("Purpose: " + appointment.getPurpose());
            System.out.println();
        }
    }
}