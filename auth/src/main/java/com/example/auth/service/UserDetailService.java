package com.example.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.auth.entity.User;
import com.example.auth.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userService.getOne(new QueryWrapper<User>().eq("user_account",s),false);
        if(user==null){
            return null;
        }
        String role;
        if(user.getUserRole().equals("user")){
            role="ROLE_USER";
        }else{
            role="ROLE_ADMIN";//管理员权限
        }
        UserDetails userDetails= org.springframework.security.core.userdetails.User.withUsername(user.getUserAccount())
                .password(user.getUserPassword()).authorities(role).build();
        return userDetails;
    }
}
