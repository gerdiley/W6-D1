package it.epicode.w5.d3.le1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.epicode.w5.d3.le1.entities.Messaggio;

@Repository
public interface MessageRepo extends JpaRepository<Messaggio, Integer> {
	@Query(
			nativeQuery = true,
			value = "SELECT messages.testo, messages.date FROM messages INNER JOIN users ON users.id = message.user_id WHERE users.nickname = :n"
			)
	List<Messaggio> getMessagesByNickname(@Param("n") String nickname ); 
	
	
}
