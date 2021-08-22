package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Department;

public interface DepartmentMapper {
    Department getDeptyById(Integer id);
    Department getDeptyByIdPlus(Integer id);

}
