package com.example.onestopmedicalserviceserver.drugRelated.entry;

import com.example.onestopmedicalserviceserver.drugRelated.domain.DrugOrder;
import com.example.onestopmedicalserviceserver.drugRelated.domain.DrugOrderInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrugOrderForm extends DrugOrder {
    List<DrugOrderInfo> drugOrderInfos;
}
