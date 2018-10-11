package com.zhaoyu.spingbootsecurity.practice1.condig;

import com.zhaoyu.spingbootsecurity.practice1.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启security注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //允许所有用户访问"/"和"/home"
        http.authorizeRequests()
                .antMatchers("/tologin","/h2/**").permitAll()
                //其他地址的访问均需验证权限
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //指定登录页是"/login"
                .loginPage("/login").failureUrl("/tologin")
                .defaultSuccessUrl("/Test")//登录成功后默认跳转到"/hello"
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/tologin")//退出登录后的默认url是"/index"
                .permitAll();

    }
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() { //密码加密
//        return new BCryptPasswordEncoder(4);
//    }

    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler loginSuccessHandler() { //登入处理
        return new SavedRequestAwareAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                User userDetails = (User) authentication.getPrincipal();
                logger.info("USER : " + userDetails.getUsername() + " LOGIN SUCCESS !  ");
                super.onAuthenticationSuccess(request, response, authentication);
            }
        };
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("123").password("123").roles("USER");
        //在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER
    }


}