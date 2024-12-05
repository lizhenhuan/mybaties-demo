package com.lzh.mybaties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // 加载 MyBatis 配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);

            List<User> userList1 = new ArrayList<>();
            List<User> userList2 = new ArrayList<>();
            List<User> userList3 = new ArrayList<>();
            List<User> userList4 = new ArrayList<>();
            List<User> userList5 = new ArrayList<>();
            List<User> userList6 = new ArrayList<>();
            List<User> userList7 = new ArrayList<>();
            List<User> userList8 = new ArrayList<>();
            for (int i = 0; i < 2000; i++) {
                // 插入数据
                User user = new User();
                user.setName("Alice" + i);
                user.setEmail(i + "alice@example.com");
                userList1.add(user);
                userList2.add(user);
                userList3.add(user);
                userList4.add(user);
                userList5.add(user);
                userList6.add(user);
                userList7.add(user);
                userList8.add(user);
            }

            userMapper.insertUserBatch(userList1);
            userMapper.insertUserBatch(userList2);
            userMapper.insertUserBatch(userList3);
            userMapper.insertUserBatch(userList4);
            userMapper.insertUserBatch(userList5);
            userMapper.insertUserBatch(userList6);
            userMapper.insertUserBatch(userList7);
            userMapper.insertUserBatch(userList8);
            session.commit();

            // 查询所有用户
            List<User> users = userMapper.findAll();
            users.forEach(System.out::println);

            // 根据 ID 查询用户
            User user = userMapper.findById(1);
            System.out.println("Found User: " + user);
        }
    }
}
