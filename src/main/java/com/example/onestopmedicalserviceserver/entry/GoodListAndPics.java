package com.example.onestopmedicalserviceserver.entry;

import com.example.onestopmedicalserviceserver.domain.weChat.GoodList;
import com.example.onestopmedicalserviceserver.domain.weChat.Pics;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@ApiModel("GoodListAndPics")
@AllArgsConstructor
@NoArgsConstructor
public class GoodListAndPics extends GoodList {
    private List<Pics> pics;

}
