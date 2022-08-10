package rs.ac.bg.fon.osiguranja.security.config;

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
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import rs.ac.bg.fon.osiguranja.service.JwtAgentService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

   private final JwtAgentService jwtUserDetailsService;

    private final JwtRequestFilter jwtRequestFilter;
    
    @Autowired
    public WebSecurityConfig(JwtAuthenticationEntryPoint jwtaep, JwtAgentService jwtus,
            JwtRequestFilter jwtrf){
        this.jwtAuthenticationEntryPoint=jwtaep;
        this.jwtUserDetailsService=jwtus;
        this.jwtRequestFilter=jwtrf;
    
    }

    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
      //return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
       httpSecurity.csrf().disable()
                .authorizeRequests().antMatchers("/authenticate", "/").permitAll().
                        anyRequest().authenticated().and().
                        exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
      
      
   /*   httpSecurity
                .cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST, "/predmet").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.POST, "/polisa").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.GET, "/polisa").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.DELETE, "/polisa/{id}").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.GET, "/pokrice").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.GET, "/pokrice/{id}").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.POST, "/pokrice").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.PUT, "/pokrice/{id}").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.GET, "/klijent").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.POST, "/klijent").access("hasRole('ROLE_ADMIN')")
                .anyRequest().authenticated().and().
                exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
     */    
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {

        webSecurity
                .ignoring()
                .antMatchers(
                        HttpMethod.POST,"/**"
                )
                .antMatchers(HttpMethod.OPTIONS, "/**")
                .and()
                .ignoring()
                .antMatchers(
                        HttpMethod.GET,
                        "/"
                );

    }
}