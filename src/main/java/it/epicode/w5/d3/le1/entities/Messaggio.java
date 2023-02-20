package it.epicode.w5.d3.le1.entities;

import java.time.LocalDate;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import it.epicode.w5.d3.le1.config.SecretCodeConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name="messages")
public class Messaggio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String testo;
	
	private LocalDate date;
	
	@Convert(converter = SecretCodeConverter.class)
	private String secretCode;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private Utente utente;
}
