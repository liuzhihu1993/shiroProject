package com.github.liuzhihu.shiro_5.service;

import com.github.liuzhihu.shiro_5.entity.Permission;

public interface PermissionService
{
    public Permission createPermission(Permission permission);
    
    public void deletePermission(Long permissionId);
}
