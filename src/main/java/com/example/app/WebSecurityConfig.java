package com.example.app;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    @Override
    public UserDetailsService userDetailsService(){

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
                User.withDefaultPasswordEncoder() // Sử dụng mã hóa password đơn giản
                        .username("loda")
                        .password("loda")
                        .roles("USER") // phân quyền là người dùng.
                        .build()
        );
        return manager;
    }
@Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                    .antMatchers("/","home").permitAll()//Cho phep tat ca moi nguoi truy cap vao 2 dia chi nay
                    .anyRequest().authenticated()//Tất cả các request khác đều cần phải xác thực mới được truy cập
                    .and()
                .formLogin() // Cho phép người dùng xác thực bằng form login
                    .defaultSuccessUrl("/hello")
                    .permitAll()//Cho phep tat ca tru cap dia chi nay
                .and()
                    .logout()
                    .permitAll();
}

}
