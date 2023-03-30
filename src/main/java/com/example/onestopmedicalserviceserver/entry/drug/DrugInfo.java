package com.example.onestopmedicalserviceserver.entry.drug;

import com.example.onestopmedicalserviceserver.domain.Drug;
import com.example.onestopmedicalserviceserver.domain.DrugRotation;
import com.example.onestopmedicalserviceserver.domain.weChat.Pics;
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
