package com.marui.dao;

import com.marui.domain.User;

import java.util.List;

/**
 * 用户持久层接口
 * @author MaRui
 * @date 2021-05-18 12:50
 */
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();
}
