package com.sunbeam.cpmc;

import java.util.List;

public interface UserDao extends AutoCloseable {
    User findById(int userId) throws Exception;
    List<User> findAll() throws Exception;
    User findByEmail(String email) throws Exception;
    
    int save(User user) throws Exception;
    int update(User user) throws Exception;
    int changePassword(int userId, String newPassword) throws Exception;
    int deleteById(int userId) throws Exception;
}