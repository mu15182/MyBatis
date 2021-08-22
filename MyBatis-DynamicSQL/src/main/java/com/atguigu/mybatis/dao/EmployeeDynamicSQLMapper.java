package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDynamicSQLMapper {
    List<Employee> getEmpsByConditionForeach(@Param("ids") List<Integer> ids);
    List<Employee> getEmpsByConditionIf(Employee employee);
    void updateEmp(Employee employee);
    void addEmps(@Param("emps") List<Employee> emps);
}
