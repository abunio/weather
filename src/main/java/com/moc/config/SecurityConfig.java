package com.moc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Description
 * @Author huangW
 * @Date 2020/4/16
 * @Version V1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin().defaultSuccessUrl("/index")
            .permitAll()  //表单登录，permitAll()表示这个不需要验证 登录页面，登录失败页面
            .and()
            .authorizeRequests().anyRequest().authenticated()
            .and()
            .logout()//自定义登出
            .logoutUrl("/logout") //自定义登出api，无需自己实现
            .logoutSuccessUrl("/login").permitAll()
            .and()
            .csrf().disable();
    }
}
