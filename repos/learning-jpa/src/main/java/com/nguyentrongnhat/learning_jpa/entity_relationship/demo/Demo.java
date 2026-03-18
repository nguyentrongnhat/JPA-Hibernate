package com.nguyentrongnhat.learning_jpa.entity_relationship.demo;

import com.nguyentrongnhat.learning_jpa.entity_relationship.entity.MedicalRecord;
import com.nguyentrongnhat.learning_jpa.entity_relationship.entity.Patient;
import com.nguyentrongnhat.learning_jpa.entity_relationship.repository.MedicalRecordRepository;
import com.nguyentrongnhat.learning_jpa.entity_relationship.repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Component
public class Demo implements CommandLineRunner {

    private final PatientRepository patientRepository;
    private final MedicalRecordRepository medicalRecordRepository;

    @Override
    public void run(String... args) throws Exception {
        Patient patient = new Patient();
        patient.setName("John Doe");
        patient.setAge(30);
        patientRepository.save(patient);

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setDiagnosis("Flu");
        medicalRecord.setPatient(patient);
        medicalRecordRepository.save(medicalRecord);

        log.info("medical record id: " + String.valueOf(medicalRecord.getId()));

        //ACCESS BIDIRECTIONAL

        Optional<MedicalRecord> medicalRecord1Opt = medicalRecordRepository.findById(medicalRecord.getId());
        medicalRecord1Opt.ifPresent(medicalRecord1
                -> log.info("Patient name: {}", medicalRecord1.getPatient().getName()));

        Optional<Patient> patient1Opt = patientRepository.findById(patient.getId());
        patient1Opt.ifPresent(patient1
                -> log.info("Record diagnosis: {}", patient1.getMedicalRecord().getDiagnosis()));


    }
}
