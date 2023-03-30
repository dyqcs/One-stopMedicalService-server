package com.example.onestopmedicalserviceserver.domain.weChat;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel("Pics")
@AllArgsConstructor
@NoArgsConstructor
public class Pics {
    private int picsId;
    private int goodsId;
    private String picsMid;
}
