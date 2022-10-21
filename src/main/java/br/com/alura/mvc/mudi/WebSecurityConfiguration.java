package br.com.alura.mvc.mudi;

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
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;


@Override
protected  void configure(HttpSecurity http) throws Exception {

    http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/home/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin(form -> form
                    .loginPage("/login")
                    .defaultSuccessUrl("/usuario/pedido", true)
                    .permitAll()

            )
            .logout(logout -> {
                logout.logoutUrl("/logout")
                        .logoutSuccessUrl("/home");

            });

}
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        UserDetails user =
                User.builder()
                        .username("maria")
                        .password(encoder.encode("maria"))
                        .roles("ADM")
                        .build();


        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .passwordEncoder(encoder);




    }

//    @Override
//    @Bean
//
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("username")
//                        .password("password")
//                        .roles("ADM")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }



}


