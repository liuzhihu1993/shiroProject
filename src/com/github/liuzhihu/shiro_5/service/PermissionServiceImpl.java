package com.github.liuzhihu.shiro_5.service;

import com.github.liuzhihu.shiro_5.dao.PermissionDao;
import com.github.liuzhihu.shiro_5.dao.PermissionDaoImpl;
import com.github.liuzhihu.shiro_5.entity.Permission;

public class PermissionServiceImpl implements PermissionService
{
    
    private PermissionDao permissionDao = new PermissionDaoImpl();
    
    public Permission createPermission(Permission permission)
    {
        return permissionDao.createPermission(permission);
    }
    
    public void deletePermission(Long permissionId)
    {
        permissionDao.deletePermission(permissionId);
    }
}
