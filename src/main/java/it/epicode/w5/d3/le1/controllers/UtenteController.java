package it.epicode.w5.d3.le1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.w5.d3.le1.entities.Utente;
import it.epicode.w5.d3.le1.services.UtenteSrv;

@RestController
public class UtenteController {

	@Autowired
	UtenteSrv us;
	
//	@PostMapping("/utente")
//	public ResponseEntity<Object> saveUtente(@RequestBody Utente u) {
//		Utente utente = us.save(u);
//		return new ResponseEntity<Object>(utente, HttpStatus.CREATED);
//	}
}
