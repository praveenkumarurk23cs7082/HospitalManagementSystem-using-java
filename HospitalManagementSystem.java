import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class HospitalManagementSystem {
    private JFrame frame;
    private Hospital hospital;
    private List<Doctor> doctors;
    private List<Patient> patients;
    private List<Appointment> appointments;

    public HospitalManagementSystem() {
        hospital = new Hospital();
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
        appointments = new ArrayList<>();

        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Hospital Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();
        frame.getContentPane().add(tabbedPane);

        // Doctor Management
        JPanel doctorPanel = new JPanel();
        tabbedPane.addTab("Doctor Management", doctorPanel);

        JLabel doctorNameLabel = new JLabel("Name:");
        doctorPanel.add(doctorNameLabel);

        JTextField doctorNameField = new JTextField(20);
        doctorPanel.add(doctorNameField);

        JLabel doctorAgeLabel = new JLabel("Age:");
        doctorPanel.add(doctorAgeLabel);

        JTextField doctorAgeField = new JTextField(20);
        doctorPanel.add(doctorAgeField);

        JLabel doctorGenderLabel = new JLabel("Gender:");
        doctorPanel.add(doctorGenderLabel);

        JTextField doctorGenderField = new JTextField(20);
        doctorPanel.add(doctorGenderField);

        JLabel doctorContactLabel = new JLabel("Contact:");
        doctorPanel.add(doctorContactLabel);

        JTextField doctorContactField = new JTextField(20);
        doctorPanel.add(doctorContactField);

        JLabel doctorSpecializationLabel = new JLabel("Specialization:");
        doctorPanel.add(doctorSpecializationLabel);

        JTextField doctorSpecializationField = new JTextField(20);
        doctorPanel.add(doctorSpecializationField);

        JLabel doctorIDLabel = new JLabel("ID:");
        doctorPanel.add(doctorIDLabel);

        JTextField doctorIDField = new JTextField(20);
        doctorPanel.add(doctorIDField);

        JButton addDoctorButton = new JButton("Add Doctor");
        addDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = doctorNameField.getText();
                int age;
                try {
                    age = Integer.parseInt(doctorAgeField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid age. Please enter a number.");
                    return;
                }
                String gender = doctorGenderField.getText();
                String contact = doctorContactField.getText();
                String specialization = doctorSpecializationField.getText();
                String doctorID = doctorIDField.getText();

                Doctor doctor = new Doctor(name, age, gender, contact, specialization, doctorID);
                hospital.addDoctor(doctor);
                doctors.add(doctor);

                // Clear input fields
                doctorNameField.setText("");
                doctorAgeField.setText("");
                doctorGenderField.setText("");
                doctorContactField.setText("");
                doctorSpecializationField.setText("");
                doctorIDField.setText("");

                // Show success message
                JOptionPane.showMessageDialog(frame, "Doctor added successfully!");
            }
        });
        doctorPanel.add(addDoctorButton);

        // Patient Management
        JPanel patientPanel = new JPanel();
        tabbedPane.addTab("Patient Management", patientPanel);

        JLabel patientNameLabel = new JLabel("Name:");
        patientPanel.add(patientNameLabel);

        JTextField patientNameField = new JTextField(20);
        patientPanel.add(patientNameField);

        JLabel patientAgeLabel = new JLabel("Age:");
        patientPanel.add(patientAgeLabel);

        JTextField patientAgeField = new JTextField(20);
        patientPanel.add(patientAgeField);

        JLabel patientGenderLabel = new JLabel("Gender:");
        patientPanel.add(patientGenderLabel);

        JTextField patientGenderField = new JTextField(20);
        patientPanel.add(patientGenderField);

        JLabel patientContactLabel = new JLabel("Contact:");
        patientPanel.add(patientContactLabel);

        JTextField patientContactField = new JTextField(20);
        patientPanel.add(patientContactField);

        JLabel patientIDLabel = new JLabel("ID:");
        patientPanel.add(patientIDLabel);

        JTextField patientIDField = new JTextField(20);
        patientPanel.add(patientIDField);

        JLabel patientMedicalHistoryLabel = new JLabel("Medical History:");
        patientPanel.add(patientMedicalHistoryLabel);

        JTextField patientMedicalHistoryField = new JTextField(20);
        patientPanel.add(patientMedicalHistoryField);

        JButton addPatientButton = new JButton("Add Patient");
        addPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = patientNameField.getText();
                int age;
                try {
                    age = Integer.parseInt(patientAgeField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid age. Please enter a number.");
                    return;
                }
                String gender = patientGenderField.getText();
                String contact = patientContactField.getText();
                String patientID = patientIDField.getText();
                String medicalHistory = patientMedicalHistoryField.getText();

                Patient patient = new Patient(name, age, gender, contact, patientID, medicalHistory);
                hospital.addPatient(patient);
                patients.add(patient);

                // Clear input fields
                patientNameField.setText("");
                patientAgeField.setText("");
                patientGenderField.setText("");
                patientContactField.setText("");
                patientIDField.setText("");
                patientMedicalHistoryField.setText("");

                // Show success message
                JOptionPane.showMessageDialog(frame, "Patient added successfully!");
            }
        });
        patientPanel.add(addPatientButton);

        // Appointment Management
        JPanel appointmentPanel = new JPanel();
        tabbedPane.addTab("Appointment Management", appointmentPanel);

        JLabel doctorLabel = new JLabel("Doctor ID:");
        appointmentPanel.add(doctorLabel);

        JTextField doctorField = new JTextField(20);
        appointmentPanel.add(doctorField);

        JLabel patientLabel = new JLabel("Patient ID:");
        appointmentPanel.add(patientLabel);

        JTextField patientField = new JTextField(20);
        appointmentPanel.add(patientField);

        JLabel dateLabel = new JLabel("Date:");
        appointmentPanel.add(dateLabel);

        JTextField dateField = new JTextField(20);
        appointmentPanel.add(dateField);

        JLabel timeLabel = new JLabel("Time:");
        appointmentPanel.add(timeLabel);

        JTextField timeField = new JTextField(20);
        appointmentPanel.add(timeField);

        JLabel purposeLabel = new JLabel("Purpose:");
        appointmentPanel.add(purposeLabel);

        JTextField purposeField = new JTextField(20);
        appointmentPanel.add(purposeField);

        JButton scheduleAppointmentButton = new JButton("Schedule Appointment");
        scheduleAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String doctorID = doctorField.getText();
                String patientID = patientField.getText();
                String date = dateField.getText();
                String time = timeField.getText();
                String purpose = purposeField.getText();

                Doctor doctor = hospital.getDoctorByID(doctorID);
                Patient patient = hospital.getPatientByID(patientID);

                if (doctor == null) {
                    JOptionPane.showMessageDialog(frame, "Doctor not found.");
                    return;
                }

                if (patient == null) {
                    JOptionPane.showMessageDialog(frame, "Patient not found.");
                    return;
                }

                try {
                    hospital.scheduleAppointment(doctor, patient, date, time, purpose);
                    appointments.add(new Appointment(doctor, patient, date, time, purpose));
                } catch (DoctorUnavailableException ex) {
                    JOptionPane.showMessageDialog(frame, "Doctor is unavailable at the specified time.");
                }

                // Clear input fields
                doctorField.setText("");
                patientField.setText("");
                dateField.setText("");
                timeField.setText("");
                purposeField.setText("");
            }
        });
        appointmentPanel.add(scheduleAppointmentButton);

        // Display Doctors by Specialization
        JPanel displayDoctorsPanel = new JPanel();
        tabbedPane.addTab("Display Doctors", displayDoctorsPanel);

        JLabel specializationLabel = new JLabel("Specialization:");
        displayDoctorsPanel.add(specializationLabel);

        JTextField specializationField = new JTextField(20);
        displayDoctorsPanel.add(specializationField);

        JButton displayDoctorsButton = new JButton("Display Doctors");
        displayDoctorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String specialization = specializationField.getText();
                List<Doctor> filteredDoctors = hospital.getDoctorsBySpecialization(specialization);
                StringBuilder doctorList = new StringBuilder("Doctors with specialization '" + specialization + "':\n");
                for (Doctor doc : filteredDoctors) {
                    doctorList.append(doc.getName()).append("\n");
                }
                JOptionPane.showMessageDialog(frame, doctorList.toString());
            }
        });
        displayDoctorsPanel.add(displayDoctorsButton);

        // Display Appointments
// Display Appointments
        JPanel displayAppointmentsPanel = new JPanel();
        tabbedPane.addTab("Display Appointments", displayAppointmentsPanel);

        JButton displayAppointmentsButton = new JButton("Display Appointments");
        displayAppointmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder appointmentList = new StringBuilder("Appointments:\n");
                for (Appointment appointment : appointments) {
                    appointmentList.append(appointment.getDoctor().getName()).append(" - ")
                                .append(appointment.getPatient().getName()).append(" - ")
                                .append(appointment.getDate()).append(" - ")
                                .append(appointment.getTime()).append(" - ")
                                .append(appointment.getPurpose()).append("\n");
                }
                JOptionPane.showMessageDialog(frame, appointmentList.toString());
            }
        });
        displayAppointmentsPanel.add(displayAppointmentsButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new HospitalManagementSystem();
    }
}