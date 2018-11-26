package com.program.vo.users;

import com.program.vo.users.CcAdminUsers;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class SecurityUser extends CcAdminUsers implements UserDetails {
    private static final long serialVersionUID = 1L;

    public SecurityUser(CcAdminUsers user) {
        if (user != null) {
            this.setId(user.getId());
            this.setAccount(user.getAccount());
            this.setName(user.getName());
            this.setPassword(user.getPassword());
            this.setStatus(user.getStatus());
            this.setUserType(user.getUserType());
            this.setLastLoginFailTime(user.getLastLoginFailTime());
            this.setLastLoginIp(user.getLastLoginIp());
            this.setGmtCreate(user.getGmtCreate());
            this.setGmtModify(user.getGmtModify());
            this.setLastLoginTime(user.getLastLoginTime());
            this.setLoginNum(user.getLoginNum());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        String username = this.getUsername();
        if (username != null) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(username);
            authorities.add(authority);
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        return this.getAccount();
    }
}