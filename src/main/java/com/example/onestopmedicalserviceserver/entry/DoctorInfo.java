package com.example.onestopmedicalserviceserver.entry;

import com.example.onestopmedicalserviceserver.domain.Doctor;
import com.example.onestopmedicalserviceserver.domain.Hospital;
import com.example.onestopmedicalserviceserver.domain.MajorDepartment;
import com.example.onestopmedicalserviceserver.domain.SmallDepartment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorInfo extends Doctor {
    Hospital hospital;
    MajorDepartment majorDepartment;
    SmallDepartment smallDepartment;
}
