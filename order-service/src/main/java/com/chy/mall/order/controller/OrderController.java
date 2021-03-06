package com.chy.mall.order.controller;

import com.chy.mall.model.User;
import com.chy.mall.user.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.cluster.loadbalance.ConsistentHashLoadBalance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {
    @Reference(loadbalance = ConsistentHashLoadBalance.NAME,sticky = true)  //注入要调用的服务
    private UserService userService;

    @RequestMapping("/user/{id}")
    @ResponseBody
    public User getUser(@PathVariable Integer id){
        //调用服务
        User user= userService.findUserById(id);
        return user;
    }

}
