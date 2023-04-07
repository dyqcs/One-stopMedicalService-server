package com.example.onestopmedicalserviceserver.drugRelated.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("药品")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drug {
    @TableId(type = IdType.AUTO)
    Integer id;
    String name;
    String image;
    String introduce;
    Double price;
    Integer drugstoreId;
    String standards;
    String richText;
    Integer num;
}
