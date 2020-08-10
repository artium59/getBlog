package com.web.blog.config;

import com.web.blog.security.oauth2.dao.HttpCookieOAuth2AuthorizationRequestDao;
import com.web.blog.security.jwt.AuthEntryPointJwt;
import com.web.blog.security.jwt.AuthTokenFilter;
import com.web.blog.security.oauth2.handler.OAuth2AuthenticationFailureHandler;
import com.web.blog.security.oauth2.handler.OAuth2AuthenticationSuccessHandler;
import com.web.blog.security.service.OAuth2UserServiceImpl;
import com.web.blog.security.service.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private OAuth2UserServiceImpl OAuth2UserServiceImpl;

    @Autowired
    private OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;

    @Autowired
    private OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;

    @Autowired
    private HttpCookieOAuth2AuthorizationRequestDao httpCookieOAuth2AuthorizationRequestDao;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public HttpCookieOAuth2AuthorizationRequestDao cookieOAuth2AuthorizationRequestDao() {
        return new HttpCookieOAuth2AuthorizationRequestDao();
    }

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().mvcMatchers(HttpMethod.OPTIONS, "/**");
        web.ignoring().mvcMatchers("/swagger-ui.html/**", "/configuration/**", "/swagger-resources/**", "/v2/api-docs","/webjars/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors()

            .and()

            .csrf().disable()

            .formLogin().disable()

            .httpBasic().disable()

            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

            .and()

            .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)

            .and()

            .authorizeRequests()
                // 로그인 없이 접속 가능한 주소들
                .antMatchers("/", "/error", "/favicon.ico", "/**/*.png", "/**/*.gif", "/**/*.svg", "/**/*.jpg", "/**/*.html", "/**/*.css", "/**/*.js").permitAll()

                .antMatchers("/auth/**", "/oauth2/**", "/account/**", "/api/post/**", "/api/reply/**").permitAll()

                // admin만 접속 가능한 주소들
                .antMatchers("/api/admin/**").hasRole("ADMIN")

                // user와 moderator(manager)만 접속 가능한 주소들
                .antMatchers("/api/temperary/**").hasAnyRole("USER", "MODERATOR")

                .anyRequest().authenticated()

            .and()

            .oauth2Login()
                // oauth2Login시 
                .authorizationEndpoint().baseUri("/oauth2/authorize").authorizationRequestRepository(cookieOAuth2AuthorizationRequestDao())

                .and()

                .redirectionEndpoint().baseUri("/oauth2/callback/*")

                .and()

                .userInfoEndpoint().userService(OAuth2UserServiceImpl)

                .and()

                .successHandler(oAuth2AuthenticationSuccessHandler)
                .failureHandler(oAuth2AuthenticationFailureHandler);

        // request 요청이 올 떄마다 UsernamePasswordAuthenticationFilter 이전에 authenticationJwtTokenFilter()를 실행
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
