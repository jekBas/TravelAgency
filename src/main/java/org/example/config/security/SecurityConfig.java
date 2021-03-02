package org.example.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private UserDetailsService userDetailsService;



    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(passwordEncoder)
                .usersByUsernameQuery("select username,password, 'true' "
                        + " from user "
                        + " where username =? ")
                .authoritiesByUsernameQuery(" select username,role "
                        + " from user "
                        + " where username =? ");
        auth.userDetailsService(userDetailsService);


    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .passwordEncoder(passwordEncoder)
//                .withUser("user").password(passwordEncoder.encode("123456")).roles("USER")
//                .and()
//                .withUser("admin").password(passwordEncoder.encode("123456")).roles("USER", "ADMIN");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/", "/aboutUs","/signIn").permitAll()
                    .antMatchers("/signUp").not().fullyAuthenticated()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/signIn")
                .defaultSuccessUrl("/")
                .failureUrl("/signIn?error=true")
                .and()
                .logout()
                .logoutSuccessUrl("/signIn?logout=true")
                .invalidateHttpSession(true)
                    .permitAll();
    }

//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("pass")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
}