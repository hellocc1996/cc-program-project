package com.program.service.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.program.service.dao.CcAdminUsersDao;
import com.program.user.entity.*;
import com.program.user.req.AdminUserQueryReq;
import com.program.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0")
@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService {

    @Autowired
    private CcAdminUsersDao usersDao;

    /**
     * 用户表主键的前缀
     */
    private static final String USER_KEY_PREFIX = "USER";

    @Override
    public CcAdminUsers queryAdminUserInfo(AdminUserQueryReq req) {
        CcAdminUsers user = usersDao.findByUserAccount(req.getAccount());
        return user;
    }
}
