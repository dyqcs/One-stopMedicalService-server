package com.example.onestopmedicalserviceserver.other.pdf.entry;

import com.example.onestopmedicalserviceserver.other.pdf.Prescription;
import com.example.onestopmedicalserviceserver.other.pdf.PrescriptionInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@ApiModel("处方单信息表")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionForm extends Prescription {
    @ApiModelProperty("处方信息内容")
    List<PrescriptionInfo> infos;
    @ApiModelProperty("处方单药品id")
    List<Integer> drugsId;
}
