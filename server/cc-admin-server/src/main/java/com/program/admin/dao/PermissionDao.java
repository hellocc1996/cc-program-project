package com.program.admin.dao;

import com.program.admin.domain.Permission;

import java.util.List;

/**
 * Created by cuipp22399 on 17/1/20.
 */
public interface PermissionDao {
    public List<Permission> findAll();

    public List<Permission> findByAdminUserId(int userId);
}
