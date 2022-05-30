package tn.itari.Backend.train;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


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

   @GetMapping("/search")
   public List<train> searchTrain(@RequestParam(name = "date")String date,@RequestParam(name = "type")String type,
   @RequestParam(name = "depStat")Integer depStat,@RequestParam(name = "arrStat")Integer arrStat){
       List<train> trains = this.trainRepository.searchTrains(type, depStat, arrStat, date);
       return trains ;
   }

   @PostMapping("/add")
    public train Register(@RequestBody train Train) {
        return this.trainRepository.save(Train);
    }

    @GetMapping("/getIdTrain")
    public Integer getId(@RequestParam(name = "trainName") String trainName) {
        Integer idTrain = this.trainRepository.findByTrainName(trainName).id;
        return idTrain ;
    }

    @GetMapping("/getTrainInfo")
    public train getTrainInfo(@RequestParam(name = "TrainName") String trainName) {
        return this.trainRepository.findByTrainName(trainName);
    }

    @DeleteMapping("/delete")
    public Integer delete(@RequestParam(name = "id") Integer id) {
         this.trainRepository.deleteById(id);
         return 1 ;
    }

    @PostMapping("/updateTrain")
    public train update(@RequestParam(name = "TrainName") String oldName,@RequestBody train newTrain){
        train oldTrain = trainRepository.findById(getId(oldName)).get();
        System.out.println(oldTrain.id);
        oldTrain.TrainName = newTrain.TrainName ;
        oldTrain.Departure = newTrain.Departure ;
        oldTrain.Arrival = newTrain.Arrival ;
        oldTrain.Type = newTrain.Type ;
        oldTrain.stationDep = newTrain.stationDep ;
        oldTrain.stationArr = newTrain.stationArr ;
        oldTrain.Line = newTrain.Line ;
        trainRepository.save(oldTrain);
        return oldTrain ;
    }
}