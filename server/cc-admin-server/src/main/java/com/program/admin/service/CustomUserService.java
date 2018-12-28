package com.program.admin.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.program.user.entity.CcAdminUsers;
import com.program.user.req.AdminUserQueryReq;
import com.program.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    @Reference(version = "1.0.0")
    private UserService userService;

    private static final Logger log = LoggerFactory.getLogger(CustomUserService.class);

    @Override
    public UserDetails loadUserByUsername(String username) {
        log.info("{}登录验证中", username);
        AdminUserQueryReq req = new AdminUserQueryReq();
        req.setAccount(username);
        CcAdminUsers user = userService.queryAdminUserInfo(req);
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
