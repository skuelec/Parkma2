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

    String[] parkingListHeaders = {"Parkplatznummer","Status"};
    String[][] parkingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);


        final TableView<String[]> tb= (TableView<String[]>) findViewById(R.id.tableView);
        tb.setColumnCount(2);
        tb.setHeaderBackgroundColor(Color.parseColor("#2ecc71"));

        //Tabelle wird befuellt
        populateData();


        //Adapter werden hinzugefuegt
        tb.setHeaderAdapter(new SimpleTableHeaderAdapter(this, parkingListHeaders));
        tb.setDataAdapter(new SimpleTableDataAdapter(this,parkingList));

    }

    private void populateData(){

        ParkingLot parkingLot = new ParkingLot();

        ArrayList<ParkingLot> parkingLotList = new ArrayList<>();


        parkingLot.setId("1");
        parkingLot.setStatus("FREI");
        parkingLotList.add(parkingLot);

        parkingLot = new ParkingLot();
        parkingLot.setId("2");
        parkingLot.setStatus("FREI");
        parkingLotList.add(parkingLot);

        parkingLot = new ParkingLot();
        parkingLot.setId("3");
        parkingLot.setStatus("FREI");
        parkingLotList.add(parkingLot);

        parkingLot = new ParkingLot();
        parkingLot.setId("4");
        parkingLot.setStatus("FREI");
        parkingLotList.add(parkingLot);


        parkingList = new String[parkingLotList.size()][2];


        for(int i=0; i<parkingLotList.size(); i++){

            ParkingLot p = parkingLotList.get(i);

            parkingList[i][0] = p.getId();
            parkingList[i][1] = p.getStatus();

        }

    }
}
