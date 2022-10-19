package org.formation.service;

import org.formation.domain.event.TicketStatusEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EventService {


	
	public void notify(TicketStatusEvent ticketEvent) {
	}
}
