package com.example.onestopmedicalserviceserver.drugRelated.entry;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("俩个药店的id")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TwoDrugstoreId {
    Integer drugstore01Id;
    Integer drugstore02Id;
}
