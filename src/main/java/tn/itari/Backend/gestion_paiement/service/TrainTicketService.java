package tn.itari.Backend.gestion_paiement.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.itari.Backend.gestion_paiement.model.TrainTicket;
import tn.itari.Backend.gestion_paiement.repository.TrainTicketRepository;


@Service
@org.springframework.transaction.annotation.Transactional(readOnly = true)
public class TrainTicketService {
    @Autowired
    TrainTicketRepository trainTicketRepository;

    public List<TrainTicket> list(){
        List<TrainTicket> list = trainTicketRepository.findAll();
        return list;
    }

    public Optional<TrainTicket> getById(long id){
        return trainTicketRepository.findById(id);
    }

    public Optional<TrainTicket> getByName(String name){
        return trainTicketRepository.findByName(name);
    }

    public void save(TrainTicket trainticket){
        trainTicketRepository.save(trainticket);
    }

    public void delete(long id){
        trainTicketRepository.deleteById(id);
    }

    public boolean existsId(long id){
        return trainTicketRepository.existsById(id);
    }

    public boolean existsName(String name){
        return trainTicketRepository.existsByName(name);
    }
}
