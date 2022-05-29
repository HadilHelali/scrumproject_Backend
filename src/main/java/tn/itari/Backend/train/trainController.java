package tn.itari.Backend.train;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class trainController {

    @Autowired
    private trainRepository trainRepository;

    @GetMapping("/trainList")
    public List<train> Register( ) {
        return trainRepository.findAll();
    }

    @GetMapping("/filter")
   public List<train> filterType(@RequestParam(name = "type") String type){
       List<train> trains = this.trainRepository.findByType(type);
       return trains ;
   }
}