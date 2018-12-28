package com.program.service.dao;

import com.program.user.entity.CcAdminUsers;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CcAdminUsersDao {
    public CcAdminUsers findByUserAccount(String account);
}
