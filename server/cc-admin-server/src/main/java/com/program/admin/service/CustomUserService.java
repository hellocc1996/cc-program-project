package com.program.admin.service;

import com.program.admin.dao.PermissionDao;
import com.program.admin.dao.CcAdminUsersDao;
import com.program.admin.domain.CcAdminUsers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuipp22399 on 17/1/18.
 */
@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口

    @Autowired
    CcAdminUsersDao ccAdminUsersDao;
    @Autowired(required = false)
    PermissionDao permissionDao;

    private static final Logger log = LoggerFactory.getLogger(CustomUserService.class);

    @Override
    public UserDetails loadUserByUsername(String username) {
        log.info("{}登录验证中", username);
        CcAdminUsers user = ccAdminUsersDao.findByUserAccount(username);
        if (user != null) {
//            List<Permission> permissions = permissionDao.findByAdminUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//            for (Permission permission : permissions) {
//                if (permission != null && permission.getName() != null) {
//
//                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
//                    grantedAuthorities.add(grantedAuthority);
//                }
//            }
            return new User(user.getName(), user.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }

}
