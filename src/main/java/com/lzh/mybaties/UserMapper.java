package com.lzh.mybaties;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
    User findById(int id);
    void insertUser(User user);
    void insertUserBatch(List<User> user);
}
