package it.epicode.w5.d3.le1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.epicode.w5.d3.le1.entities.Role;
import it.epicode.w5.d3.le1.entities.Utente;
import it.epicode.w5.d3.le1.repositories.UtenteRepo;

@Service
public class UtenteSrv {
	
	@Autowired
	UtenteRepo ur;
	
	@Autowired
	PasswordEncoder pe;
	
	public Utente save(Utente u) {
		return ur.save(u);
	}
	
	public Optional<Utente> getById(int id) {
		return ur.findById(id);
	}
	
	public void updatePasswords() {
		List<Utente> lista = ur.findAll();
		
		for(Utente u: lista) {
			Optional<Utente> corrObj = ur.findById(u.getId());
			Utente corr = corrObj.get();
			String pw = corr.getPassword();
			String cryptedPw = pe.encode(pw);
			corr.setPassword(cryptedPw);
			ur.save(corr);
		}
	}
	
	
}
