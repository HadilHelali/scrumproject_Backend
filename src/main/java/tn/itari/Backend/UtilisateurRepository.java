package tn.itari.Backend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
    Utilisateur findByEmailAndPassword(String email,String password);
}