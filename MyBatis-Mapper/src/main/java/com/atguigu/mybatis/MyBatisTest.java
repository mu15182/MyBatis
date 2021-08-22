package com.atguigu.mybatis;

import com.atguigu.mybatis.bean.Department;
import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.DepartmentMapper;
import com.atguigu.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }
    @Test
    public void test() throws IOException {

        SqlSession openSession = getSqlSessionFactory().openSession();
        try{
            Employee employee = openSession.selectOne("com.atguigu.mybatis.dao.getEmpById",1);
            System.out.println(employee);
        }finally {
            openSession.close();
        }
    }
    @Test
    public void test01() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            Employee empById = mapper.getEmpById("1");
            System.out.println(mapper.getClass());
            System.out.println(empById);
        }finally {
            openSession.close();
        }

    }
    @Test
    public void testCRUD() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //获取到的sqlsession不会自动提交数据
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            Employee empByIdStep = mapper.getEmpByIdStep(3);
            System.out.println(empByIdStep);
//            Employee empAndDept = mapper.getEmpAndDept(1);
//            System.out.println(empAndDept);
//            System.out.println(empAndDept.getDept());
//            Employee empById = mapper.getEmpById("1");
//            System.out.println(empById);

//            Employee employee = new Employee(null,"qumengna",8000.00,1002);
//            mapper.addEmp(employee);
//            System.out.println(employee.getId());
//            mapper.updateEmp(new Employee(1,"zhangyaxin",10000,1001));
//            mapper.deleteEmpById(2);
//            Employee zhangyaxin = mapper.getEmpByIdAndLastName(1, "zhangyaxin");
//            System.out.println(zhangyaxin);
//            List<Employee> emps = mapper.getEmpsByLastNameLike("%小%");
//            System.out.println(emps);
//            Map<String, Object> empByIdReturnMap = mapper.getEmpByIdReturnMap(1);
//            System.out.println(empByIdReturnMap);
//            Map<String, Employee> empsByLastNameLikeReturnMap = mapper.getEmpsByLastNameLikeReturnMap("%a%");
//            System.out.println(empsByLastNameLikeReturnMap);

            openSession.commit();
        }finally {
            openSession.close();
        }

    }
    @Test
    public void testPlus() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        DepartmentMapper mapper = openSession.getMapper(DepartmentMapper.class);
        Department deptyByIdPlus = mapper.getDeptyByIdPlus(10);
        System.out.println(deptyByIdPlus);

    }

//    public MyBatisTest() {
//    }
//
//    public SqlSessionFactory getSqlSessionFactory() throws IOException {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build();
//        return (new SqlSessionFactoryBuilder()).build(inputStream);
//    }
}
