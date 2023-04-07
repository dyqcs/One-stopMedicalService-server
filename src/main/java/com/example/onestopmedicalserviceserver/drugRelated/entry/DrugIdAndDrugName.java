package com.example.onestopmedicalserviceserver.drugRelated.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugIdAndDrugName {
    Integer drugId;
    String drugName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DrugIdAndDrugName)) return false;
        DrugIdAndDrugName that = (DrugIdAndDrugName) o;
        return drugName.equals(that.drugName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drugName);
    }
}
