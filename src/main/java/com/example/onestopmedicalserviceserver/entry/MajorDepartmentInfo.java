package com.example.onestopmedicalserviceserver.entry;

import com.example.onestopmedicalserviceserver.domain.MajorDepartment;
import com.example.onestopmedicalserviceserver.domain.SmallDepartment;
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
