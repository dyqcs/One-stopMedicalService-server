package com.example.onestopmedicalserviceserver.drugRelated.entry;

import com.example.onestopmedicalserviceserver.other.pdf.PrescriptionInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@ApiModel("地理信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeographicInfo {
    @ApiModelProperty("经度")
    Double longitude;
    @ApiModelProperty("纬度")
    Double latitude;
    @ApiModelProperty("半径（km）")
    Integer distance;
    @ApiModelProperty("查询数量")
    Integer limit;
    @ApiModelProperty("药品名称")
    String drugName;
    @ApiModelProperty("处方信息(查询最短路径或者最少金额使用)")
    List<PrescriptionInfo> prescriptionInfos;
}
