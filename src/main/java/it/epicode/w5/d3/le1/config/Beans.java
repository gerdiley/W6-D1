package it.epicode.w5.d3.le1.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import it.epicode.w5.d3.le1.entities.Messaggio;
import it.epicode.w5.d3.le1.entities.Role;
import it.epicode.w5.d3.le1.entities.RoleType;
import it.epicode.w5.d3.le1.entities.Utente;

@Configuration
public class Beans {
	
	@Bean
	@Scope("prototype")
	public Utente utente(String nickname, String username, String password) {
		return Utente.builder()
				.nickname(nickname)
				.username(username)
				.password(password)
				.active(true)
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public Role role(RoleType rt) {
		return Role.builder()
				.type(rt)
				.build();
	}
	
	@Bean 
	@Scope("prototype")
	public Messaggio messaggio(String testo, Utente u, String code) {
		return Messaggio.builder()
				.testo(testo)
				.utente(u)
				.secretCode(code)
				.date(LocalDate.now())
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
