package com.ideas2it.employeemanagement.configuration;

import com.ideas2it.employeemanagement.logger.LoggerConfiguration;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class AuthenticationSecurityConfiguration extends WebSecurityConfigurerAdapter{

    private static Logger logger = LoggerConfiguration
            .getInstance("AuthenticationSecurityConfiguration.class");
    @Autowired
    public UserDetailsService userDetailsService;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        logger.info("In AuthConfig authenticationProvider()");
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

        return daoAuthenticationProvider;
    }

    // For in-memory
    /*@Bean
    @Override
    protected UserDetailsService userDetailsService() {
        logger.info("In AuthConfig userDetailsService()");
        List<UserDetails> userDetails = new ArrayList<UserDetails>();
        userDetails.add(User.withDefaultPasswordEncoder().username("pradeep")
                .password("1234").roles("user").build());
        return new InMemoryUserDetailsManager(userDetails);
    }*/

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        logger.info("In AuthConfig config() auth");
        auth.inMemoryAuthentication()
                .withUser("pradeep")
                .password("1234")
                .roles("user");
    }*/

    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.inMemoryAuthentication()
                .withUser("pradeep")
                .password("1234")
                .roles("USER");
    }*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        logger.info("In AuthConfig configure method");
        httpSecurity.csrf().disable()
                .authorizeRequests().antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/").permitAll()
                .and().logout().invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutUrl("login").permitAll();

    }


}



