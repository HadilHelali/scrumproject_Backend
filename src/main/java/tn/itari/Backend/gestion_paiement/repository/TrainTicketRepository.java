package tn.itari.Backend.gestion_paiement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.itari.Backend.gestion_paiement.model.TrainTicket;

@Repository
public interface TrainTicketRepository extends JpaRepository<TrainTicket,Long> {
    Optional<TrainTicket> findByName(String name);
    boolean existsByName(String name);
}
