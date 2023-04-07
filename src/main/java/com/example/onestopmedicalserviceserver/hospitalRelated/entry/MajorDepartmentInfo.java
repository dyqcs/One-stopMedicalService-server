package com.example.onestopmedicalserviceserver.hospitalRelated.entry;

import com.example.onestopmedicalserviceserver.hospitalRelated.domain.MajorDepartment;
import com.example.onestopmedicalserviceserver.hospitalRelated.domain.SmallDepartment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MajorDepartmentInfo extends MajorDepartment {
    Set<SmallDepartment> smallDepartments;
}
