package com.example.onestopmedicalserviceserver.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugstoreInfoDrugMoney extends DrugstoreInfo implements Comparable<DrugstoreInfoDrugMoney>{
    Double price;

    @Override
    public int compareTo(DrugstoreInfoDrugMoney o) {
        //这里是按照orderNum字段升序排序，如果要降序，只需要调换1和-1 的位置即可
        return (this.getPrice()>o.getPrice())?1:((this.getPrice()==o.getPrice())?0:-1);
    }
}
