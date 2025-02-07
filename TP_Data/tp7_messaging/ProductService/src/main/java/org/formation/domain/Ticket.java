package org.formation.domain;

import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ticket {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	String orderId;
	
	@Enumerated(EnumType.STRING)
	private TicketStatus status;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	List<ProductRequest> productRequests;
	
	
}
