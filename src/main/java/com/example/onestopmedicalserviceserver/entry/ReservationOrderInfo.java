package com.example.onestopmedicalserviceserver.entry;

import com.example.onestopmedicalserviceserver.domain.ReservationOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationOrderInfo extends ReservationOrder {
    DoctorInfo doctorInfo;
}
