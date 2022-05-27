package tn.itari.Backend.train;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class train {
    @Id
    @GeneratedValue
    Integer id;
    String TrainName ; 
    Date Departure;
    Date Arrival;
    String Type;
    Integer stationDep ;
    Integer stationArr ;
    Integer Line ;
}



