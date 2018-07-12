package at.se.fhcampus.parkma2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import at.se.fhcampus.parkma2.models.ParkingLot;
import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

/**
 * Created by kuele on 13.01.2018.
 */

public class ParkingActivity extends AppCompatActivity{

    String[] parkingListHeaders = {"Parkplatznummer","Status", "Besetzen", "Reservieren"};

    ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);

        populateData();

        final TableView<ParkingLot> tableView= (TableView<ParkingLot>) findViewById(R.id.tableView);
        tableView.setColumnCount(4);
        tableView.setHeaderBackgroundColor(Color.parseColor("#3F51B5"));

        ParkingAdapter parkingAdapter = new ParkingAdapter(this, parkingLots);
        SimpleTableHeaderAdapter simpleTableHeaderAdapter = new SimpleTableHeaderAdapter(this, parkingListHeaders);

        simpleTableHeaderAdapter.setTextColor(0xFFFFFFFF);

        //Adapter werden hinzugefuegt
        tableView.setHeaderAdapter(simpleTableHeaderAdapter);
        tableView.setDataAdapter(parkingAdapter);

    }

    private void populateData(){

        parkingLots.add(new ParkingLot("1","frei"));
        parkingLots.add(new ParkingLot("2","frei"));
        parkingLots.add(new ParkingLot("3","frei"));
        parkingLots.add(new ParkingLot("4","frei"));
        parkingLots.add(new ParkingLot("5","frei"));
        parkingLots.add(new ParkingLot("6","frei"));
        parkingLots.add(new ParkingLot("7","frei"));

    }

}
