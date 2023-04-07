package com.example.onestopmedicalserviceserver.drugRelated.entry;

import com.example.onestopmedicalserviceserver.drugRelated.domain.Drug;
import com.example.onestopmedicalserviceserver.drugRelated.domain.DrugRotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugInfo extends Drug {
    List<DrugRotation> drugRotations;
}
