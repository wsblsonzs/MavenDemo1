package com.bdqn.test;


import com.bdqn.dao.EmpInfoMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test {

    public static void main(String[] args) {

        try {

            InputStream is= Resources.getResourceAsStream("mybatis-configuration.xml");
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession=sqlSessionFactory.openSession();

            EmpInfoMapper empInfoMapper=sqlSession.getMapper(EmpInfoMapper.class);

            System.out.println(empInfoMapper.selectByPrimaryKey(1).getEmpName());

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
