package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    List<Employee> getEmpsByDeptno(Integer deptno);
    Employee getEmpByIdStep(Integer id);
    Employee getEmpAndDept(Integer id);
    @MapKey("lastName")
    Map<String,Employee> getEmpsByLastNameLikeReturnMap(String lastName);
    Map<String,Object> getEmpByIdReturnMap(Integer id);
    List<Employee> getEmpsByLastNameLike(String lastName);
    Employee getEmpByIdAndLastName(@Param("id") Integer id,@Param("lastName") String lastName);
    public Employee getEmpById(String id);
    void addEmp(Employee employee);
    void updateEmp(Employee employee);
    void deleteEmpById(Integer id);

}
