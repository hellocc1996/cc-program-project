package com.program.service.dao;

import com.program.vo.users.CcAdminUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface CcAdminUsersRepository extends JpaRepository<CcAdminUsers, Integer> {

    CcAdminUsers findByAccount(String account);
}
