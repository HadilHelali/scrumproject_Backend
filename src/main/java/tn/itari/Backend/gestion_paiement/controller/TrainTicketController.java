package tn.itari.Backend.gestion_paiement.controller;

import java.util.List;

import com.stripe.util.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.itari.Backend.gestion_paiement.http.Messages;
import tn.itari.Backend.gestion_paiement.model.TrainTicket;
import tn.itari.Backend.gestion_paiement.service.TrainTicketService;

@RestController
@RequestMapping("/trainticket")
@CrossOrigin
public class TrainTicketController {
    @Autowired
    TrainTicketService trainTicketService;

    @GetMapping("/list")
    public ResponseEntity<List<TrainTicket>> lista(){
        List<TrainTicket> list = trainTicketService.list();
        return new ResponseEntity<List<TrainTicket>>(HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<TrainTicket> detail(@PathVariable("id") long id){
        if(!trainTicketService.existsId(id))
        return new ResponseEntity(new Messages("no existe"), HttpStatus.NOT_FOUND);
        TrainTicket trainticket = trainTicketService.getById(id).get();
        return new ResponseEntity<TrainTicket>(trainticket, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody TrainTicket trainTicket){
        if( trainTicket.getName() == null)
            return new ResponseEntity(new Messages("nom obligatoire"), HttpStatus.BAD_REQUEST);
        if((Integer)trainTicket.getPrix() == null || trainTicket.getPrix() < 1)
            return new ResponseEntity(new Messages("prix obligatoire"), HttpStatus.BAD_REQUEST);
        if(trainTicketService.existsName(trainTicket.getName()))
            return new ResponseEntity(new Messages("ce nom existe deja"), HttpStatus.BAD_REQUEST);
            trainTicketService.save(trainTicket);
        return new ResponseEntity(new Messages("ticketTrain crée"), HttpStatus.CREATED);
    }
}
