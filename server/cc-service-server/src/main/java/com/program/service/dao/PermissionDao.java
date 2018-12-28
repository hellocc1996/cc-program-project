package com.program.service.dao;

import com.program.user.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by cuipp22399 on 17/1/20.
 */
@Mapper
public interface PermissionDao {
    public List<Permission> findAll();

    public List<Permission> findByAdminUserId(int userId);
}
