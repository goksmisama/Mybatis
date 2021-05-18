package com.marui.dao.impl;

import com.marui.dao.IUserDao;
import com.marui.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * 用户持久层接口的实现类
 * @author MaRui
 * @date 2021-05-18 22:38
 */
public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> findAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过"com.marui.dao.IUserDao.findAll"找到sql语句生成预处理器对象，执行查询后返回结果
        List<User> list = sqlSession.selectList("com.marui.dao.IUserDao.findAll");
        sqlSession.close();
        return list;
    }
}
