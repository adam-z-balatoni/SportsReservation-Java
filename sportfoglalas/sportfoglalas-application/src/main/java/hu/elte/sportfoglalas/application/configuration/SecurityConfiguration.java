package hu.elte.sportfoglalas.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/h2-console/**").permitAll()
//                .antMatchers("/adminAddCourt/**").permitAll()
//                .antMatchers("/adminVerifyCoach/**").permitAll()
                .antMatchers("/registration/**").permitAll()
//                .antMatchers("/playerReservation/**").permitAll()
//                .antMatchers("/playerMyReservations/**").permitAll()
//                .antMatchers("/playerPass/**").permitAll()
//                .antMatchers("/playerInvoice/**").permitAll()
//                .antMatchers("/coachClasses/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().ignoringAntMatchers("/h2-console/**")
                .and()
                .headers().frameOptions().sameOrigin()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/login/success")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }
}
