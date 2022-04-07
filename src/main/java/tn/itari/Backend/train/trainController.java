package tn.itari.Backend.train;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class trainController {

    @Autowired
    private trainRepository utilisateurRepository;

    @PostMapping("/trainList")
    public List<train> Register( ) {
        return utilisateurRepository.findAll();
    }
   
}