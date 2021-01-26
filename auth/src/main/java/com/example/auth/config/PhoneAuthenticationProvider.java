package com.example.auth.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.auth.entity.User;
import com.example.auth.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class PhoneAuthenticationProvider implements AuthenticationProvider,ProviderStrategy {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //认证代码，认证通过返回认证对象，失败返回null
        PhoneAuthenticationToken token = (PhoneAuthenticationToken) authentication;
        if(token.getPhone()==null || token.getCode()==null || token.getRealCode()==null){
            return null;
        }
        //检查验证码
        if(!token.getCode().equals(token.getRealCode())){
            return null;
        }
        //根据手机号获取用户信息
        User user=userService.getOne(new QueryWrapper<User>().eq("user_phone",token.getPhone()),false);
        if(user!=null){
            //授予用户权限
            String role;
            if(user.getUserRole().equals("user")){
                role="ROLE_USER";
            }else{
                role="ROLE_ADMIN";//管理员权限
            }
            //写入用户信息并返回认证类
            return new PhoneAuthenticationToken(user,
                    Arrays.asList(new SimpleGrantedAuthority(role)));
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        //Manager传递token给provider，调用本方法判断该provider是否支持该token。不支持则尝试下一个filter
        //本类支持的token类：UserPasswordAuthenticationToken
        return (PhoneAuthenticationToken.class.isAssignableFrom(aClass));
    }

    @Override
    public Authentication authenticate(HttpServletRequest request) {
        String phone=request.getParameter("phone");
        String code=request.getParameter("code");
        String realCode=(String) request.getSession().getAttribute("phoneCode");
        return new PhoneAuthenticationToken(phone,code,realCode);
    }
}
