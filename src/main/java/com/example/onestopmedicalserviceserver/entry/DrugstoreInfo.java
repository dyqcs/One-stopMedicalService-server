package com.example.onestopmedicalserviceserver.entry;

import com.example.onestopmedicalserviceserver.domain.Drug;
import com.example.onestopmedicalserviceserver.domain.Drugstore;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@ApiModel("药店信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugstoreInfo extends Drugstore {
    List<Drug> drugs;
    Double distance;
}
