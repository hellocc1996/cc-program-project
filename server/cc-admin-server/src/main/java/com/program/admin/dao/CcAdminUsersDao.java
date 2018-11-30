package com.program.admin.dao;

import com.program.admin.domain.CcAdminUsers;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CcAdminUsersDao {
    public CcAdminUsers findByUserAccount(String account);
}
