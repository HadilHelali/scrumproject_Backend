package tn.itari.Backend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Utilisateur {
    @Id
    @GeneratedValue
    Integer id;
    String name ; 
    String email;
    String password;


}