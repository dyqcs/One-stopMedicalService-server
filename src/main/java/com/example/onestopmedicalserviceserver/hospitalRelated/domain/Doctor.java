package com.example.onestopmedicalserviceserver.hospitalRelated.domain;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("医生")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @TableId(type = IdType.AUTO)
    Integer id;
    String name;
    String introduce;
    String beGoodAt;
    Integer smallDepartmentId;
}
