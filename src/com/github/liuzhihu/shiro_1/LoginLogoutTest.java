package com.github.liuzhihu.shiro_1;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class LoginLogoutTest
{
    
    @Test
    public void testVolidate1()
    {
        //1.第一步：获取SecurityManager工厂类
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        
        //2.第二步：从共厂中获取SecurityManager
        SecurityManager securityManager = factory.getInstance();
        
        //3.第三步：将得到的securityManager实例，绑定给SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        //4.第四步：得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        
        try
        {
            //5.第五步：登录
            subject.login(token);
        }
        catch (AuthenticationException e)
        {
            System.out.println("AuthenticationException e:" + e);
        }
        
        //6.添加断言      
        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        
        //6、退出
        subject.logout();
        
    }
    
    //测试MyRealm_1
    @Test
    public void testCustomRealm()
    {
        //1.第一步：获取SecurityManager工厂类
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        
        //2.第二步：从共厂中获取SecurityManager
        SecurityManager securityManager = factory.getInstance();
        
        //3.第三步：将得到的securityManager实例，绑定给SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        
        //4.第四步：得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        
        try
        {
            //5.第五步：登录
            subject.login(token);
        }
        catch (AuthenticationException e)
        {
            System.out.println("AuthenticationException e:" + e);
        }
        
        //6.添加断言      
        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        
        //6、退出
        subject.logout();
    }
    
    //测试MyRealm_1/2
    @Test
    public void testCustomMultiRealm()
    {
        //1.第一步：获取SecurityManager工厂类
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-multi-realm.ini");
        
        //2.第二步：从共厂中获取SecurityManager
        SecurityManager securityManager = factory.getInstance();
        
        //3.第三步：将得到的securityManager实例，绑定给SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        
        //4.第四步：得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        
        try
        {
            //5.第五步：登录
            subject.login(token);
        }
        catch (AuthenticationException e)
        {
            System.out.println("AuthenticationException e:" + e);
        }
        
        //6.添加断言      
        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        
        //6、退出
        subject.logout();
    }
    
    //测试jdbc
    @Test
    public void testJdbcRealm()
    {
        //1.第一步：获取SecurityManager工厂类
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
        
        //2.第二步：从共厂中获取SecurityManager
        SecurityManager securityManager = factory.getInstance();
        
        //3.第三步：将得到的securityManager实例，绑定给SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        
        //4.第四步：得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        
        try
        {
            //5.第五步：登录
            subject.login(token);
        }
        catch (AuthenticationException e)
        {
            System.out.println("AuthenticationException e:" + e);
        }
        
        //6.添加断言      
        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        
        //7、退出
        subject.logout();
    }
    
    @After
    public void tearDown()
        throws Exception
    {
        //退出时请解除绑定Subject到线程 否则对下次测试造成影响
        ThreadContext.unbindSubject();
    }
    
}
