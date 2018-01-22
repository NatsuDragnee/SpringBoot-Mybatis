package cn.yf.test.springboot01.mapper;

import cn.yf.test.springboot01.bean.User;

import java.util.List;

public interface UserMapper {
    void insert(User user);

    List<User> getAllUser();

    void deleteUser(Integer id);

    User getUserInfo(Integer id);

    void editUserInfo(User user);
}
