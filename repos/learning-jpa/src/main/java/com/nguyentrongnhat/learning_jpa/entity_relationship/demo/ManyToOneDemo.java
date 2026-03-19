package com.nguyentrongnhat.learning_jpa.entity_relationship.demo;

import com.nguyentrongnhat.learning_jpa.entity_relationship.entity.Doctor;
import com.nguyentrongnhat.learning_jpa.entity_relationship.entity.MedicalRecord;
import com.nguyentrongnhat.learning_jpa.entity_relationship.entity.Patient;
import com.nguyentrongnhat.learning_jpa.entity_relationship.repository.DoctorRepository;
import com.nguyentrongnhat.learning_jpa.entity_relationship.repository.MedicalRecordRepository;
import com.nguyentrongnhat.learning_jpa.entity_relationship.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ManyToOneDemo {
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final MedicalRecordRepository medicalRecordRepository;

    public void saveEntityDemo() {
        Patient patient1 = new Patient();
        patient1.setName("John Doe");
        patient1.setAge(30);
        patientRepository.save(patient1);

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setDiagnosis("Flu");
        medicalRecord.setPatient(patient1);
        medicalRecordRepository.save(medicalRecord);

        //@ManyToOne

        Doctor doctor1 = new Doctor();
        doctor1.setName("Doctor Harry");
        doctorRepository.save(doctor1);

        Patient patient2 = new Patient();
        patient2.setAge(20);
        patient2.setName("Jane");
        patient2.setDoctor(doctor1);

        patient1.setDoctor(doctor1);

        patientRepository.saveAll(List.of(patient1, patient2));
    }

    @Transactional
    public void bidirectionalDemo() {
        Optional<Doctor> doctorFromDBOpt = doctorRepository.findById(1L);
        Doctor doctorFromDB;
        if(doctorFromDBOpt.isPresent()) {
            doctorFromDB = doctorFromDBOpt.get();
            List<Patient> patients = doctorFromDB.getPatients();
            patients.forEach(patient -> log.info("patient name: {}", patient.getName()));
        }
    }
}
