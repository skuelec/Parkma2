package at.se.fhcampus.parkma2.models;

import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;

import at.se.fhcampus.parkma2.DatabaseHelper;

/**
 * Created by kuele on 27.12.2017.
 */

public class ParkingLot{

    private String id;
    private String status;
    private int checkBesetzt = NO_CHECK;
    private int checkReserviert = NO_CHECK;

    private static final int NO_CHECK = -1;
    private static final int CHECK = 0;


    public ParkingLot(){

    }

    public ParkingLot(String id, String status){
        this.id = id;
        this.status = status;
    }

    public ParkingLot(String id, String status, int checkBesetzt, int checkReserviert){
        this.id = id;
        this.status = status;
        this.checkBesetzt = checkBesetzt;
        this.checkReserviert = checkReserviert;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public int getCheckBesetzt() {
        return checkBesetzt;
    }

    public void setCheckBesetzt(int checkBesetzt) {
        this.checkBesetzt = checkBesetzt;

    }

    public int getCheckReserviert() {
        return checkReserviert;
    }

    public void setCheckReserviert(int checkReserviert) {
        this.checkReserviert = checkReserviert;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
