package com.example.onestopmedicalserviceserver.drugRelated.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugRotation {
    @TableId(type = IdType.AUTO)
    Integer id;
    String image;
    Integer drugId;
}
