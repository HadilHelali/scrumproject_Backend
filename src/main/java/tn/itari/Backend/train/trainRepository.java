package tn.itari.Backend.train;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface trainRepository extends JpaRepository<train,Integer> {
    @Query(value = "SELECT * FROM train t WHERE t.type = ?1", nativeQuery = true)
    List<train> findByType(String type);
    
}