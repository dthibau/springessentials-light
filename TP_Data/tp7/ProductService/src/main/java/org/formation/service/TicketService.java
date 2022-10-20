package org.formation.service;

import org.formation.domain.ResultDomain;
import org.formation.domain.Ticket;
import org.formation.domain.TicketRepository;
import org.formation.domain.event.TicketStatusEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.java.Log;

@Service
@Transactional
@Log
public class TicketService {


	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	TicketStatusEventRepository eventRepository;
	
	public Ticket readyToPickUp(Long ticketId) {
		
		Ticket t = ticketRepository.findById(ticketId).orElseThrow();	
		ResultDomain resultDomain = t.readyToPickUp();
		
		ticketRepository.save(resultDomain.getTicket());
		eventRepository.save(resultDomain.getStatusEvent());

		return resultDomain.getTicket();
		

	}
	
}
