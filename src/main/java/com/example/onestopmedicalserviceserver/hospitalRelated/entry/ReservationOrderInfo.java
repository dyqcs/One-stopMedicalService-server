package com.example.onestopmedicalserviceserver.hospitalRelated.entry;

import com.example.onestopmedicalserviceserver.hospitalRelated.domain.ReservationOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationOrderInfo extends ReservationOrder {
    DoctorInfo doctorInfo;
}
