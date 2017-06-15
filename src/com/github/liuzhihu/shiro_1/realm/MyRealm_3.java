package com.github.liuzhihu.shiro_1.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class MyRealm_3 implements Realm
{
    
    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
        throws AuthenticationException
    {
        //得到用户名
        String username = (String)token.getPrincipal();
        //得到密码
        String password = new String((char[])token.getCredentials());
        
        if (!"liu".equals(username))
        {
            //抛出用户名错误
            throw new UnknownAccountException();
        }
        
        if (!"123".equals(password))
        {
            //抛出密码错误
            throw new IncorrectCredentialsException();
        }
        
        //验证成功，返回一个AuthenticationInfo
        return new SimpleAuthenticationInfo(username + "@126.com", password, getName());
    }
    
    @Override
    public String getName()
    {
        
        return "MyRealm_3";
    }
    
    @Override
    public boolean supports(AuthenticationToken token)
    {
        //仅仅支持UsernamePasswordToken类型的token
        return token instanceof UsernamePasswordToken;
    }
    
}
