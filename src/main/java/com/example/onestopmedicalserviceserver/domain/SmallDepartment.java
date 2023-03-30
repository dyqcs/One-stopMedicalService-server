package com.example.onestopmedicalserviceserver.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@ApiModel("小科室")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmallDepartment {
    @TableId(type = IdType.AUTO)
    Integer id;
    String name;
    @ApiModelProperty("大科室id")
    Integer majorDepartmentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmallDepartment that = (SmallDepartment) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
