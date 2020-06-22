package com.chy.mall.user.service;

import com.chy.mall.model.User;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//此处的@Service是dubbo下的注解，不是spring的注解
@Service
@Component
public class UserServiceImpl implements UserService {
    @Value("${dubbo.protocol.port}")
    private int port;
    @Override
    public User findUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername("chy");
        System.err.println("findUserById server " + this.port);
        return user;
    }
}
