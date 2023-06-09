package com.example.onestopmedicalserviceserver.hospitalRelated.entry;

import com.example.onestopmedicalserviceserver.hospitalRelated.domain.Doctor;
import com.example.onestopmedicalserviceserver.hospitalRelated.domain.Hospital;
import com.example.onestopmedicalserviceserver.hospitalRelated.domain.MajorDepartment;
import com.example.onestopmedicalserviceserver.hospitalRelated.domain.SmallDepartment;
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
