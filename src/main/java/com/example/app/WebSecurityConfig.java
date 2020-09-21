package com.example.app;

import com.example.app.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        // Password encoder, để Spring Security sử dụng mã hóa mật khẩu người dùng
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.userDetailsService(userService)// Cung cáp userservice cho spring security
                .passwordEncoder(passwordEncoder());// cung cấp password encoder
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
