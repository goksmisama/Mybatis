package com.marui.test;

import com.marui.dao.IUserDao;
import com.marui.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author MaRui
 * @date 2021-05-18 21:17
 */
public class TestMybatis {
    @Test
    public void test1() throws IOException {
        //1. 读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 创建SqlSessionFactory工厂对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        //3. 使用工厂创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4. 使用SqlSession对象创建dao的代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        //5. 使用代理对象执行查询方法
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
        //6. 释放资源
        sqlSession.close();
        is.close();
    }
}
