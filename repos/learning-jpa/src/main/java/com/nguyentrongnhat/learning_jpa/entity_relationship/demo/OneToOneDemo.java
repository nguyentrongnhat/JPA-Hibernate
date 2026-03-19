package com.nguyentrongnhat.learning_jpa.entity_relationship.demo;

import com.nguyentrongnhat.learning_jpa.entity_relationship.entity.MedicalRecord;
import com.nguyentrongnhat.learning_jpa.entity_relationship.entity.Patient;
import com.nguyentrongnhat.learning_jpa.entity_relationship.repository.MedicalRecordRepository;
import com.nguyentrongnhat.learning_jpa.entity_relationship.repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class OneToOneDemo {
    private final PatientRepository patientRepository;
    private final MedicalRecordRepository medicalRecordRepository;

    public void runDemo() {
        Patient patient1 = new Patient();
        patient1.setName("John Doe");
        patient1.setAge(30);
        patientRepository.save(patient1);

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setDiagnosis("Flu");
        medicalRecord.setPatient(patient1);
        medicalRecordRepository.save(medicalRecord);

        log.info("medical record id: " + String.valueOf(medicalRecord.getId()));

        //ACCESS BIDIRECTIONAL

        Optional<MedicalRecord> medicalRecord1Opt = medicalRecordRepository.findById(medicalRecord.getId());
        medicalRecord1Opt.ifPresent(medicalRecord1
                -> log.info("Patient name: {}", medicalRecord1.getPatient().getName()));

        Optional<Patient> patient1Opt = patientRepository.findById(patient1.getId());
        patient1Opt.ifPresent(patient
                -> log.info("Record diagnosis: {}", patient.getMedicalRecord().getDiagnosis()));
    }
}
