package com.xinjingjie.restudy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasRole("user");
        http.formLogin().usernameParameter("username").passwordParameter("password").loginPage("/loginUser");
        http.logout().logoutSuccessUrl("/");
        http.rememberMe();
    }
    @Autowired
    private DataSource dataSource;
    //管理登录
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select username,password,enabled from users WHERE username=?")
//                .authoritiesByUsernameQuery("select username,authority from authorities where username=?")
//                .passwordEncoder(new MyPassEncoded());



        auth.inMemoryAuthentication().passwordEncoder(new MyPassEncoded())
                .withUser("zxy").password("123").roles("user")
        .and()
        .withUser("ghz").password("123").roles("user","admin");
    }

}
class MyPassEncoded implements PasswordEncoder{

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
