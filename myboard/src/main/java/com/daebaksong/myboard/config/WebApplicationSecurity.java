package com.daebaksong.myboard.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest; // Path 잘 기억해 두자
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// java config
// spring security에 대한 설정을 하기 위해서 WebSecurityConfigurerAdapter
// 를 상속받는다.
@Configuration
public class WebApplicationSecurity extends WebSecurityConfigurerAdapter {
    // 인증 처리를 아예 하지 않게 하고 싶을 경우
    // /css/** , /js/**, /images/** , /webjars/** 등
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .requestMatchers(PathRequest.toStaticResources()
                        .atCommonLocations())
                .requestMatchers(
                        new AntPathRequestMatcher("/**.html"));
    }

    // 특정 ROLE을 가진 사용자가 접근할 수 있는 경로를 지정
    // logoute경로를 지정한다던지 대부분의 인증 처리에 대한 설정
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // logout을 할경우에 /boards로 이동한다.
                .logout()
                    .logoutRequestMatcher(
                            new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/boards")
                    // HttpSecurity 객체를 리턴 해줌 이를 사용하여chaining 설정 가능.
                    .and()

                // 요청별 권한 설정.
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/members/joinform").permitAll()
                    .antMatchers(HttpMethod.POST,
                            "/members/join").permitAll()
                    .antMatchers("/members/welcome").permitAll()
                    .antMatchers("/members/login").permitAll()
                    .antMatchers("/members/**").hasRole("USER")
                    .antMatchers(HttpMethod.GET,"/boards").permitAll()
                    .antMatchers(HttpMethod.POST,"/boards").hasRole("USER")
                    .antMatchers("/boards/**").hasRole("USER")
                    .antMatchers("/api/**").hasRole("USER")
                    .antMatchers("/h2-console/**").permitAll()
                    .anyRequest().fullyAuthenticated()
                    .and()

                // h2 console을 쓰기위해 설정
                .headers().frameOptions().disable()
                .and()

                // 실제개발시에는 무시하면 안된다.
                .csrf().ignoringAntMatchers("/**") // post방식으로 값을 전달할 때 csrf를 무시
                .and()

                // 로그인 페이지 설정
                .formLogin()
                    // 로그인 form url (사용자가 만드는 경로)
                    .loginPage("/members/login")
                    // form에 값 설정 후 서버로 Post 요청으로 전달할때의 경로
                    .loginProcessingUrl("/members/login")
                    // 로그인 폼에서 사용하는 name 필드 이름
                    .usernameParameter("id")
                    // 로그인 폼에서 사용하는 password 필드 이름.
                    .passwordParameter("password");


    }
}
