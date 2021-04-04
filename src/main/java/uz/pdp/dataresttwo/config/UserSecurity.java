package uz.pdp.dataresttwo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class UserSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("SUPER_ADMIN")
                .and()
                .withUser("moderator").password(passwordEncoder().encode("moderator")).roles("MODERATOR")
                .and()
                .withUser("operator").password(passwordEncoder().encode("operator")).roles("OPERATOR");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()

//                =======Basket yo`liga murojaat======
                .antMatchers(HttpMethod.GET, "/api/basket/**").hasAnyRole("SUPER_ADMIN", "MODERATOR", "OPERATOR")
                .antMatchers(HttpMethod.POST,"/api/basket/**").hasAnyRole("SUPER_ADMIN", "MODERATOR", "OPERATOR")
                .antMatchers(HttpMethod.PUT,"/api/basket/**").hasAnyRole("SUPER_ADMIN", "MODERATOR")
                .antMatchers("/api/basket/**").hasRole("SUPER_ADMIN")

//                =======Blog yo`liga murojaat======
                .antMatchers(HttpMethod.GET, "/api/blog/**").hasAnyRole("SUPER_ADMIN", "MODERATOR", "OPERATOR")
                .antMatchers(HttpMethod.POST,"/api/blog/**").hasAnyRole("SUPER_ADMIN", "MODERATOR", "OPERATOR")
                .antMatchers(HttpMethod.PUT,"/api/blog/**").hasAnyRole("SUPER_ADMIN", "MODERATOR")
                .antMatchers("/api/blog/**").hasRole("SUPER_ADMIN")

//                =======Category yo`liga murojaat======
                .antMatchers(HttpMethod.GET, "/api/category/**").hasAnyRole("SUPER_ADMIN", "MODERATOR", "OPERATOR")
                .antMatchers(HttpMethod.POST,"/api/category/**").hasAnyRole("SUPER_ADMIN", "MODERATOR", "OPERATOR")
                .antMatchers(HttpMethod.PUT,"/api/category/**").hasAnyRole("SUPER_ADMIN", "MODERATOR")
                .antMatchers("/api/category/**").hasRole("SUPER_ADMIN")

//                =======Characteristic yo`liga murojaat======
                .antMatchers(HttpMethod.GET, "/api/characteristic/**").hasAnyRole("SUPER_ADMIN", "MODERATOR", "OPERATOR")
                .antMatchers(HttpMethod.POST,"/api/characteristic/**").hasAnyRole("SUPER_ADMIN", "MODERATOR", "OPERATOR")
                .antMatchers(HttpMethod.PUT,"/api/characteristic/**").hasAnyRole("SUPER_ADMIN", "MODERATOR")
                .antMatchers("/api/characteristic/**").hasRole("SUPER_ADMIN")

//                =======Comment yo`liga murojaat======
                .antMatchers(HttpMethod.GET, "/api/comment/**").hasAnyRole("SUPER_ADMIN", "MODERATOR", "OPERATOR")
                .antMatchers(HttpMethod.POST,"/api/comment/**").hasAnyRole("SUPER_ADMIN", "MODERATOR", "OPERATOR")
                .antMatchers(HttpMethod.PUT,"/api/comment/**").hasAnyRole("SUPER_ADMIN", "MODERATOR")
                .antMatchers("/api/comment/**").hasRole("SUPER_ADMIN")

//                =======Order yo`liga murojaat======
                .antMatchers(HttpMethod.GET, "/api/orders/**").hasAnyRole("SUPER_ADMIN", "MODERATOR", "OPERATOR")
                .antMatchers(HttpMethod.POST,"/api/orders/**").hasAnyRole("SUPER_ADMIN", "MODERATOR", "OPERATOR")
                .antMatchers(HttpMethod.PUT,"/api/orders/**").hasAnyRole("SUPER_ADMIN", "MODERATOR")
                .antMatchers("/api/orders/**").hasRole("SUPER_ADMIN")

//                =======Product yo`liga murojaat======
                .antMatchers(HttpMethod.GET, "/api/product/**").hasAnyRole("SUPER_ADMIN", "MODERATOR", "OPERATOR")
                .antMatchers(HttpMethod.POST,"/api/product/**").hasAnyRole("SUPER_ADMIN", "MODERATOR", "OPERATOR")
                .antMatchers(HttpMethod.PUT,"/api/product/**").hasAnyRole("SUPER_ADMIN", "MODERATOR")
                .antMatchers("/api/product/**").hasRole("SUPER_ADMIN")

//                =======Property yo`liga murojaat======
                .antMatchers(HttpMethod.GET, "/api/property/**").hasAnyRole("SUPER_ADMIN", "MODERATOR", "OPERATOR")
                .antMatchers(HttpMethod.POST,"/api/property/**").hasAnyRole("SUPER_ADMIN", "MODERATOR", "OPERATOR")
                .antMatchers(HttpMethod.PUT,"/api/property/**").hasAnyRole("SUPER_ADMIN", "MODERATOR")
                .antMatchers("/api/property/**").hasRole("SUPER_ADMIN")

//               ======Supplier yo`liga murojaat======
                .antMatchers(HttpMethod.GET, "/api/supplier/**").hasAnyRole("SUPER_ADMIN", "MODERATOR", "OPERATOR")
                .antMatchers(HttpMethod.POST,"/api/supplier/**").hasAnyRole("SUPER_ADMIN", "MODERATOR", "OPERATOR")
                .antMatchers(HttpMethod.PUT,"/api/supplier/**").hasAnyRole("SUPER_ADMIN", "MODERATOR")
                .antMatchers("/api/supplier/**").hasRole("SUPER_ADMIN")

//              ======User yo`liga murojaat======
                .antMatchers(HttpMethod.GET, "/api/users/**").hasAnyRole("SUPER_ADMIN", "MODERATOR", "OPERATOR")
                .antMatchers(HttpMethod.POST,"/api/users/**").hasAnyRole("SUPER_ADMIN", "MODERATOR", "OPERATOR")
                .antMatchers(HttpMethod.PUT,"/api/users/**").hasAnyRole("SUPER_ADMIN", "MODERATOR")
                .antMatchers("/api/users/**").hasRole("SUPER_ADMIN")

                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }


    @Bean
    PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

}
