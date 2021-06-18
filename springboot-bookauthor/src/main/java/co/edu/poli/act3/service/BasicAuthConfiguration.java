package co.edu.poli.act3.service;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class BasicAuthConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.
			inMemoryAuthentication().
			withUser("user").
			password("{noop}password").
			roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			csrf().
			disable().
			authorizeRequests().
			antMatchers(HttpMethod.OPTIONS, "/**").permitAll().
			anyRequest().
			authenticated().
			and().
			httpBasic();
	}
	

}