package com.example.springjwt;

import jakarta.servlet.DispatcherType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.CrossOrigin;
//will add jwt soon
@Configuration
@EnableWebSecurity(debug = true)
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin
public class SecurityCustomization {
    @Autowired
    CustomUserDetails customUserDetails;
    @Autowired
    RolesRepo rolesRepo;
    @Autowired
    UserRepo userRepo;

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
//    {
//        http
//                .csrf(cs-> cs.ignoringRequestMatchers("/req"))
//                .authorizeHttpRequests(auth ->
//
//               auth
//
//                       .requestMatchers("/getalluser","/admin").hasAuthority("admin")
//                       .anyRequest().permitAll()
//                )
//                .formLogin(form->form.defaultSuccessUrl("/index.html",true));
//                 http.httpBasic(Customizer.withDefaults());
//        return http.build();
//    }


    @Bean
    public SecurityFilterChain sfc(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .authorizeHttpRequests(auth->{
                    auth
//

                            .requestMatchers("/getallusers","/approvalwindow").hasAuthority("admin")
                            .requestMatchers("/onlyregistered").authenticated()
                            .anyRequest().permitAll();
                    ;



                })
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(form->form
                        .loginPage("/login")
                        .defaultSuccessUrl("/index.html",true));

        return httpSecurity.build();
    }


    @Bean
   public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return customUserDetails;
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider= new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userDetailsService());
        return authenticationProvider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }
}
