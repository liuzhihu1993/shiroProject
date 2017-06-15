package com.github.liuzhihu.shiro_1;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class AuthenticatorTest
{
    @Test
    public void testAllSuccessfulStrategyWithSuccess()
    {
        login("classpath:shiro-authenticator-all-success.ini");
        Subject subject = SecurityUtils.getSubject();
        
        //得到一个身份集合，其包含了Realm验证成功的身份信息
        PrincipalCollection principalCollection = subject.getPrincipals();
        Assert.assertEquals(2, principalCollection.asList().size());
    }
    
    //公共方法
    private void login(String configFile)
    {
        //1.第一步：获取SecurityManager工厂类
        Factory<SecurityManager> factory =
            new IniSecurityManagerFactory("classpath:shiro-authenticator-all-success.ini");
        
        //2.第二步：从共厂中获取SecurityManager
        SecurityManager securityManager = factory.getInstance();
        
        //3.第三步：将得到的securityManager实例，绑定给SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        //4.第四步：得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("liu", "123");
        
        subject.login(token);
    }
    
    @After
    public void tearDown()
        throws Exception
    {
        //退出时请解除绑定Subject到线程 否则对下次测试造成影响
        ThreadContext.unbindSubject();
    }
}
