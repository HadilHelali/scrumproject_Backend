package tn.itari.Backend.utilisateur;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
    Utilisateur findByEmailAndPassword(String email,String password);
    Utilisateur findByEmail(String email);
    Optional<Utilisateur> findById(Integer id);
}