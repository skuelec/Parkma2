package at.se.fhcampus.parkma2.models;

/**
 * Created by kuele on 27.12.2017.
 */

public class ParkingLot {

    /* Attribute/Variablen */
    private int id;
    private String status;

    /* Konstruktoren */
    public ParkingLot(){

    }

    public ParkingLot(int id, String status){
        this.id = id;
        this.status = status;
    }

    /* Methoden */
    public void setId(Integer id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
