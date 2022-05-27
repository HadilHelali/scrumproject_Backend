package tn.itari.Backend.utilisateur;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/userInfo")
    public String UserInfo (@RequestParam(name = "email") String email){
        String Name = utilisateurRepository.findByEmail(email).name;
        return Name ;
    }

    @GetMapping("/getId")
    public Integer getUserId(@RequestParam(name = "email") String email){
        Integer id = utilisateurRepository.findByEmail(email).id ;
        return id ;
    }

    @PostMapping("/update")
    public Utilisateur update(@RequestBody Utilisateur user){
        Utilisateur oldUser = utilisateurRepository.findById(user.id).get();
        System.out.println(oldUser.id);
        oldUser.name = user.name ;
        oldUser.email = user.email ;
        utilisateurRepository.save(oldUser);
        return oldUser ;
    }
}