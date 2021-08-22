package com.atguigu.mybatis;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeDynamicSQLMapper;
import com.atguigu.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MyBatisTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String path = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(path);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }
    @Test
    public void testPlugin() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            Employee emp = mapper.getEmpById(1);


        }finally {
            openSession.close();
        }
    }
//    @Test
//    public void testSecondLevelCache() throws IOException {
//        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        SqlSession openSession1 = sqlSessionFactory.openSession();
//        SqlSession openSession2 = sqlSessionFactory.openSession();
//        try{
//            EmployeeMapper mapper1 = openSession1.getMapper(EmployeeMapper.class);
//            EmployeeMapper mapper2 = openSession2.getMapper(EmployeeMapper.class);
//            Employee emp1 = mapper1.getEmpById(1);
////            mapper1.deleteEmpById(3);
////            openSession1.close();
//            Employee emp2 = mapper1.getEmpById(1);
//
//            System.out.println(emp1==emp2);
//
//        }finally {
//
//            openSession2.close();
//        }
//    }
//    @Test
//    public void testFirstLevelCache() throws IOException {
//        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        SqlSession openSession1 = sqlSessionFactory.openSession();
//        SqlSession openSession2 = sqlSessionFactory.openSession();
//        try{
//            EmployeeMapper mapper1 = openSession1.getMapper(EmployeeMapper.class);
//            EmployeeMapper mapper2 = openSession2.getMapper(EmployeeMapper.class);
//            Employee emp1 = mapper1.getEmpById(1);
//            openSession1.clearCache();
////            mapper1.deleteEmpById(3);
//            Employee emp2 = mapper1.getEmpById(1);
//
//            System.out.println(emp1==emp2);
//
//        }finally {
//            openSession1.close();
//            openSession2.close();
//        }
//    }
//    @Test
//    public void testDynamicSQL() throws IOException {
//        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        SqlSession openSession = sqlSessionFactory.openSession();
//        EmployeeDynamicSQLMapper mapper = openSession.getMapper(EmployeeDynamicSQLMapper.class);
//        try {
//            Employee employee1= new Employee(null,"songxianqi",8000.0,50);
//            Employee employee2= new Employee(null,"liushengyuan",5000.0,1002);
//            Employee employee3= new Employee(null,"qumengna",1200.0,1001);
//            Employee employee4= new Employee(null,"lixiaotian",800.0,10);
//            List<Employee> employees = new ArrayList<>();
//            employees.add(employee1);
//            employees.add(employee2);
//            employees.add(employee3);
//            employees.add(employee4);
////            List<Employee> empsByConditionIf = mapper.getEmpsByConditionIf(employee);
////            System.out.println(empsByConditionIf);
////            mapper.updateEmp(employee);
////            List<Employee> empsByConditionForeach = mapper.getEmpsByConditionForeach(Arrays.asList(1, 3, 4));
////            System.out.println(empsByConditionForeach);
//            mapper.addEmps(employees);
//        }finally {
//            openSession.commit();
//            openSession.close();
//        }
//    }
}
