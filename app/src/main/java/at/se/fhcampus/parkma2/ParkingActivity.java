package at.se.fhcampus.parkma2;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.util.ArrayList;

import at.se.fhcampus.parkma2.controller.ParkingLotController;
import at.se.fhcampus.parkma2.models.ParkingLot;
import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

/**
 * Created by kuele on 13.01.2018.
 */

public class ParkingActivity extends AppCompatActivity{

    static String[] parkingListHeaders = {"Parkplatznummer","Status", "Besetzen", "Reservieren"};

   ParkingLotController parkingLots = new ParkingLotController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);


        final TableView<ParkingLot> tableView= (TableView<ParkingLot>) findViewById(R.id.tableView);
        tableView.setColumnCount(4);
        tableView.setHeaderBackgroundColor(Color.parseColor("#3F51B5"));

        ParkingAdapter parkingAdapter = new ParkingAdapter(this, parkingLots.getParkingLots());
        SimpleTableHeaderAdapter simpleTableHeaderAdapter = new SimpleTableHeaderAdapter(this, parkingListHeaders);

        simpleTableHeaderAdapter.setTextColor(0xFFFFFFFF);

        //Adapter werden hinzugefuegt
        tableView.setHeaderAdapter(simpleTableHeaderAdapter);
        tableView.setDataAdapter(parkingAdapter);

    }
}
