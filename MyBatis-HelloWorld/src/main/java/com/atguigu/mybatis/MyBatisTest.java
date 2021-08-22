package com.atguigu.mybatis;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

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
