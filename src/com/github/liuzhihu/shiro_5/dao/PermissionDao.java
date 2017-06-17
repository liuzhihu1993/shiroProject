package com.github.liuzhihu.shiro_5.dao;

import com.github.liuzhihu.shiro_5.entity.Permission;

public interface PermissionDao
{
    
    public Permission createPermission(Permission permission);
    
    public void deletePermission(Long permissionId);
    
}
