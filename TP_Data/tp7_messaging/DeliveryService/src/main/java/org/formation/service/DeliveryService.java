package org.formation.service;

import java.time.Instant;

import org.formation.domain.Livraison;
import org.formation.domain.LivraisonRepository;
import org.formation.domain.Livreur;
import org.formation.domain.LivreurRepository;
import org.formation.domain.Status;
import org.formation.domain.event.DeliveryEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.java.Log;

@Service
@Log
@Transactional
public class DeliveryService {


	
	@Autowired
	LivraisonRepository livraisonRepository;
	
	@Autowired
	LivreurRepository livreurRepository;
	

	public Livraison affectLivreur(Long livraisonId, Long livreurId) {
		Livraison livraison = livraisonRepository.findById(livraisonId).orElseThrow();
		Livreur livreur = livreurRepository.findById(livreurId).orElseThrow();
		livraison.setLivreur(livreur);
		livraisonRepository.save(livraison);
		
		DeliveryEvent event = new DeliveryEvent(livraison,"AFFECTE");
		
		return livraison;
		
	}
	
	private Livraison _createDelivery(Long ticketId, Long orderId) {
		Livraison l = new Livraison();
		l.setCreationDate(Instant.now());
		l.setOrderId(orderId);
		l.setStatus(Status.CREE);

		return livraisonRepository.save(l);
	}
}
