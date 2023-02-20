package it.epicode.w5.d3.le1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.w5.d3.le1.entities.Role;
import it.epicode.w5.d3.le1.repositories.RoleRepo;

@Service
public class RoleSrv {
	
	@Autowired
	RoleRepo rp;
	
	public Role saveRole(Role r) {
		return rp.save(r);
	}
}
