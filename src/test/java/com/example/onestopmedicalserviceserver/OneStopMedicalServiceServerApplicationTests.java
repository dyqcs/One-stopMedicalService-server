package com.example.onestopmedicalserviceserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class OneStopMedicalServiceServerApplicationTests {

    @Test
    void contextLoads() throws ParseException {
        String str= "2022-12-28";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(str);
        System.out.println(date);
    }

}
