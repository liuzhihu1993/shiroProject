package com.github.liuzhihu.shiro_2;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;

public abstract class BaseTest
{
    
    protected void login(String configFile, String username, String password)
    {
        //1.第一步：获取SecurityManager工厂类
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);
        
        //2.第二步：从共厂中获取SecurityManager
        SecurityManager securityManager = factory.getInstance();
        
        //3.第三步：将得到的securityManager实例，绑定给SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        
        //4.第四步：得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        
        subject.login(token);
    }
    
    @After
    public void tearDown()
        throws Exception
    {
        //退出时请解除绑定Subject到线程 否则对下次测试造成影响
        ThreadContext.unbindSubject();
    }
    
    public Subject subject()
    {
        return SecurityUtils.getSubject();
    }
}
