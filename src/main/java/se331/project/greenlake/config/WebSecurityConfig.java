package se331.project.greenlake.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import se331.project.greenlake.security.controller.JwtAuthenticationEntryPoint;
import se331.project.greenlake.security.controller.JwtAuthenticationTokenFilter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .cors().and()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/auth/**", "/refresh", "/registers/**").permitAll()
                .antMatchers(HttpMethod.POST,"/uploadFile").permitAll()
                .antMatchers(
                        HttpMethod.GET,
                        "/doctors/**"
                ).hasAnyRole("ADMIN","DOCTOR")
                .antMatchers(
                        HttpMethod.GET,
                        "/all-users",
                        "/un-verify-users",
                        "/patients/**"
                        ).hasRole("ADMIN")
                .antMatchers(
                        HttpMethod.POST,
                        "/verify-user/**",
                        "/update-vaccine",
                        "/update-doctor"
                ).hasRole("ADMIN")
                .antMatchers(
                        HttpMethod.GET,
                        "/get-patients/{id}"
                ).hasRole("DOCTOR")
                .antMatchers(
                        HttpMethod.POST,
                        "/comment"
                ).hasRole("DOCTOR")
                .antMatchers(
                        HttpMethod.GET,
                        "patient/{id}"
                ).hasRole("PATIENT")
                .anyRequest().authenticated();

        // Custom JWT based security filter
        httpSecurity
                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

        httpSecurity.headers().frameOptions().disable();
        // disable page caching
        httpSecurity.headers().cacheControl();
    }


}