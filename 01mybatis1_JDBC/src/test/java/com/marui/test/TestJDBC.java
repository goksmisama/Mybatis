package com.marui.test;

import java.sql.*;

/**
 * 原生JDBC的测试类
 *
 * @author MaRui
 * @date 2021-04-14 15:24
 */
public class TestJDBC {
    /**
     * 用于测试原生的JDBC查询数据库
     *
     * @param args
     */
    public static void main(String[] args) {
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;

        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //通过驱动管理类获取连接对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db",
                    "root",
                    "root");
            //定义sql语句
            String sql = "select * from user where id = ?";
            //获取预处理对象
            statement = connection.prepareStatement(sql);
            //设置占位符参数
            statement.setString(1,"1");
            //执行查询,获得结果集
            resultSet = statement.executeQuery();
            //遍历结果集
            while (resultSet.next()) {
                System.out.printf("%-3s%-8s%4s%n",
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("age")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}