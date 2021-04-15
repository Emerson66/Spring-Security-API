package com.buritiscript.springSecurityAPI.configuration;

import static java.lang.String.format;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.buritiscript.springSecurityAPI.domain.repository.UserRepository;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private final UserRepository userRepository;
	
//    private final JwtTokenFilter jwtTokenFilter;

	
	public SecurityConfig(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO configure authentication manager

		auth.userDetailsService(usuario -> userRepository
	            .findByUsername(usuario)
	            .orElseThrow(
	                () -> new UsernameNotFoundException(
	                    format("User: %s, not found", usuario)
	                )
	            ));
	}
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO configure web security
	}

	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
