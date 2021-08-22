package com.atguigu.mybatis.bean;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias(value = "employee")
public class Employee {
    private String id;
    private String lastName;
    private double sal;
    private String deptno;


}
