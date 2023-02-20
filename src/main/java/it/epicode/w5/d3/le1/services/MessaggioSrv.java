package it.epicode.w5.d3.le1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.w5.d3.le1.entities.Messaggio;
import it.epicode.w5.d3.le1.repositories.MessageRepo;

@Service
public class MessaggioSrv {
	
	@Autowired
	MessageRepo mr;
	
	public Messaggio save(Messaggio m) {
		return mr.save(m);
	}
	
	public Optional<Messaggio> getMessage(int id) {
		return mr.findById(id);
	}
	
	public List<Messaggio> getAll(String nickname) {
		return mr.findAll();
	}
	
	public void delete(Messaggio m) {
		mr.delete(m);
	}
}
