package it.epicode.w5.d3.le1;


import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.epicode.w5.d3.le1.config.Beans;
import it.epicode.w5.d3.le1.entities.Messaggio;
import it.epicode.w5.d3.le1.entities.Role;
import it.epicode.w5.d3.le1.entities.RoleType;
import it.epicode.w5.d3.le1.entities.Utente;
import it.epicode.w5.d3.le1.services.MessaggioSrv;
import it.epicode.w5.d3.le1.services.RoleSrv;
import it.epicode.w5.d3.le1.services.UtenteSrv;

//Realizzare un'app che consente di inviare messaggi dagli utenti
//Un Messaggio ha  id, testo, data, user_id
//Un Utente ha id, nickname (senza spazi)
//
//Costruisci l'apposita struttura in modo che:
///api/message/1   -> stampi i dati del messaggio
///api/user/bluerock/messages  -> stampi tutti i messaggi dell'utente con nickname 'bluerock'
//

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	RoleSrv rs;
	@Autowired
	UtenteSrv us;
	@Autowired
	MessaggioSrv ms;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		boolean populate = false;
		
		if(populate) {
			populateDB();
		}
		
//		us.updatePasswords();
		
	}
	
	public void populateDB() {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
		
		Utente u1 = (Utente)ctx.getBean("utente", "Mario Rossi", "mrossi", "test");
		Utente u2 = (Utente)ctx.getBean("utente", "Angelo Midolo", "amidolo", "test");
		Role r1 = (Role)ctx.getBean("role", RoleType.ROLE_ADMIN);
		Role r2 = (Role)ctx.getBean("role", RoleType.ROLE_USER);
		
		u1.setRoles(new HashSet<>() {{
			add(r1);
		}});
		
		u2.setRoles(new HashSet<>() {{
			add(r2);
		}});
		
		rs.saveRole(r1);
		rs.saveRole(r2);
		us.save(u1);
		us.save(u2);
		
		Messaggio m1 = (Messaggio)ctx.getBean("messaggio", "Messaggio 1", u1, "test");
		Messaggio m2 = (Messaggio)ctx.getBean("messaggio", "Messaggio 2", u2, "test");
		
		ms.save(m1);
		ms.save(m2);
		
		((AnnotationConfigApplicationContext)ctx).close();
		
	}

}
