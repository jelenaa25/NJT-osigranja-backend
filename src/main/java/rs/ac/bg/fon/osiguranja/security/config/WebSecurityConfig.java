package rs.ac.bg.fon.osiguranja.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
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

     @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider
                 = new DaoAuthenticationProvider();
        provider.setUserDetailsService(jwtUserDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return  provider;
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
       httpSecurity.csrf().disable()
                .authorizeRequests().antMatchers("/authenticate", "/").permitAll()
       .
                       anyRequest().authenticated().and().
                      exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
      
      
   /*   httpSecurity
                .cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST, "/predmet").permitAll()
                .antMatchers(HttpMethod.POST, "/polisa").permitAll()
                .antMatchers(HttpMethod.GET, "/polisa").permitAll()
                .antMatchers(HttpMethod.DELETE, "/polisa/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/pokrice").permitAll()
                .antMatchers(HttpMethod.GET, "/pokrice/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/pokrice").permitAll()
                .antMatchers(HttpMethod.PUT, "/pokrice/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/klijent").permitAll()
                .antMatchers(HttpMethod.POST, "/klijent").permitAll()
                .anyRequest().authenticated().and().
                exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        
*/    
}

  
    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        System.out.println("OVDE");
        webSecurity
                .ignoring()
                .antMatchers(
                        HttpMethod.POST,"/**"
                ).and().ignoring().antMatchers(HttpMethod.GET,"/**")
                .and().ignoring().antMatchers(HttpMethod.PUT, "/**")
                .and().ignoring().antMatchers(HttpMethod.OPTIONS, "/**")
                .and().ignoring().antMatchers(HttpMethod.DELETE,"/**");
                

    }
}