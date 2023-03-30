package com.example.onestopmedicalserviceserver.service;

import com.example.onestopmedicalserviceserver.domain.Prescription;
import com.example.onestopmedicalserviceserver.entry.prescription.PrescriptionForm;

import java.util.List;

public interface PrescriptionService {
    List<Prescription> selectAll();
    PrescriptionForm selectOneById(String id);
    String createPrescriptionForm(PrescriptionForm pf);
}
