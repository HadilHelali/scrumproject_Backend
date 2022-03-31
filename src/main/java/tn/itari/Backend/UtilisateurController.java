package tn.itari.Backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UtilisateurController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @PostMapping("/register")
    public Utilisateur Register(@RequestBody Utilisateur user) {
        return utilisateurRepository.save(user);
    }
    @PostMapping("/login")
    public Utilisateur Login(@RequestBody Utilisateur user) {
        Utilisateur oldUSer = utilisateurRepository.findByEmailAndPassword(user.email, user.password);
        return oldUSer;
    }
}