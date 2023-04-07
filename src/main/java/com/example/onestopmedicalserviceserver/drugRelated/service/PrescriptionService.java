package com.example.onestopmedicalserviceserver.drugRelated.service;

import com.example.onestopmedicalserviceserver.other.pdf.Prescription;
import com.example.onestopmedicalserviceserver.other.pdf.entry.PrescriptionForm;

import java.util.List;

public interface PrescriptionService {
    List<Prescription> selectAll();
    PrescriptionForm selectOneById(String id);
    String createPrescriptionForm(PrescriptionForm pf);
}
