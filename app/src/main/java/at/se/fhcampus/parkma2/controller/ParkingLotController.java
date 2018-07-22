package at.se.fhcampus.parkma2.controller;


import android.app.Application;

import java.io.Serializable;
import java.util.ArrayList;

import at.se.fhcampus.parkma2.models.ParkingLot;

public class ParkingLotController{

    private final ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
    public static ParkingLotController parkingLotController = new ParkingLotController();

    public ParkingLotController(){
        populateData();
    }

    public ArrayList<ParkingLot> getParkingLots() {
        return parkingLots;
    }


    private void populateData(){
        parkingLots.add(new ParkingLot("1","frei"));
        parkingLots.add(new ParkingLot("2","frei"));
        parkingLots.add(new ParkingLot("3","frei"));
        parkingLots.add(new ParkingLot("4","besetzt"));
        parkingLots.add(new ParkingLot("5","frei"));
        parkingLots.add(new ParkingLot("6","frei"));
        parkingLots.add(new ParkingLot("7","frei"));
    }

}
