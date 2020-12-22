package com.differ.zxl.mybatisjdbc;

import com.differ.zxl.mybatisjdbc.dao.ZxlDao;
import com.differ.zxl.mybatisjdbc.plugin.SqlPrintInterceptor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SimpleMybatisMain {
    public static void main(String[] args) throws Exception{

        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        factory.getConfiguration().addInterceptor(new SqlPrintInterceptor());
        SqlSession sqlSession = factory.openSession();
        try{
            ZxlDao mapper = sqlSession.getMapper(ZxlDao.class);
            mapper.insertData(1);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }



    }
}
