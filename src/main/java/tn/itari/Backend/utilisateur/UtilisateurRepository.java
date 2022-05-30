package tn.itari.Backend.utilisateur;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
    @Query(value = "SELECT * FROM utilisateur u WHERE u.email = ?1 AND u.password = ?2", nativeQuery = true)
    Utilisateur findByEmailAndPassword(String email,String password);
    @Query(value = "SELECT * FROM utilisateur u WHERE u.email = ?1", nativeQuery = true)
    Utilisateur findByEmail(String email);
    Optional<Utilisateur> findById(Integer id);
}