package it.epicode.w5.d3.le1.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import it.epicode.w5.d3.le1.entities.Messaggio;
import it.epicode.w5.d3.le1.entities.Utente;
import it.epicode.w5.d3.le1.services.MessaggioSrv;
import it.epicode.w5.d3.le1.services.UtenteSrv;

@RestController
//@RequestMapping("/")
@CrossOrigin
public class MessageController {
	
	@Autowired
	MessaggioSrv ms;
	
	@GetMapping("/")
	public String hello() {
		return "hello";
	}
	@PostMapping("/logged")
	public String logged() {
		return "logged";
	}

	@PostMapping("/messages")
//	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> saveMessage(@RequestBody Messaggio m) {
		 
	Messaggio messaggio = ms.save(m);
	 return new ResponseEntity<>(messaggio, HttpStatus.CREATED);
	}
	
	@GetMapping("/messages/{id}")
	public Optional<Messaggio> getMessage(@PathVariable int id) {
		return ms.getMessage(id);
	}
	
	@PutMapping("/messages/{id}")
//	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Messaggio m) {
		Optional<Messaggio> messaggioObj = ms.getMessage(id);
		
		Messaggio messaggio = messaggioObj.get();
		
		messaggio.setTesto(m.getTesto());
		
		ms.save(messaggio);
		
		return new ResponseEntity<>(messaggio, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/messages/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id) {
		Optional<Messaggio> messaggioObj = ms.getMessage(id);
		
		ms.delete(messaggioObj.get());
		
		return new ResponseEntity<>(String.format("Messaggio con id %d elimiato", id), HttpStatus.OK);
	}
}
