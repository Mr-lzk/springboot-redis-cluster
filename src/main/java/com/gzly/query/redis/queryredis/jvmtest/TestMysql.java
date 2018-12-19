package com.gzly.query.redis.queryredis.jvmtest;

import java.sql.*;

/**
 * @author lzk
 * @date 2018/8/13
 */
public class TestMysql {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String URL="jdbc:mysql://127.0.0.1:3306/admin_manage?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&useSSL=false";
        String USER="root";
        String PASSWORD="111111";
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库链接
        Connection conn= DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from user");
        //4.处理数据库的返回结果(使用ResultSet类)
        while(rs.next()){
            System.out.println(rs.getString("username")+" "
                    +rs.getString("password"));
        }

        //关闭资源
        rs.close();
        st.close();
        conn.close();
    }
}
