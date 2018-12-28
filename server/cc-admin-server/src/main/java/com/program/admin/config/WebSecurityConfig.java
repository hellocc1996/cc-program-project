package com.program.admin.config;

import com.program.util.encrypt.EncryptAndDecryptUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * Created by cuipp22399 on 17/1/18.
 */


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsService customUserService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //user Details Service验证,自定义加密方式--md5
        auth.userDetailsService(customUserService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                logger.debug("登录密码md5加密...");
                return EncryptAndDecryptUtils.md5Encrypt((String) charSequence);
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                logger.debug("校验已加密密码...");
                //MD5
                boolean bool = s.equals(EncryptAndDecryptUtils.md5Encrypt((String) charSequence));
                logger.debug("登录密码校验结果为：{}", bool);
                return bool;
            }
        });

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/static/**", "/checkCode/**").permitAll()//设置允许访问static静态资源以及验证码生成及校验接口
                .anyRequest().authenticated() //任何请求,登录后可以访问
                .and()
                .formLogin()
                .loginPage("/login")
                .successForwardUrl("/index")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error")
                .permitAll()//登录页面用户任意访问
                .and()
                .csrf().disable();// 禁用跨站攻击;

        http.headers().frameOptions().disable();//关闭iframe禁用

//        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers(
                        HttpMethod.GET,
                        "/**/*.png",
                        "/**/*.gif",
                        "/**/*.svg",
                        "/**/*.jpg",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.woff",
                        "/**/*.ttf",
                        "/**/*.js"
                );

    }
}

