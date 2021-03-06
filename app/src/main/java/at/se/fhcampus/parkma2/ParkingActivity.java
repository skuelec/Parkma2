package at.se.fhcampus.parkma2;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;

import at.se.fhcampus.parkma2.controller.ParkingLotController;
import at.se.fhcampus.parkma2.models.ParkingLot;
import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.model.TableColumnWeightModel;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

/**
 * Created by kuele on 13.01.2018.
 */

public class ParkingActivity extends AppCompatActivity{

    static String[] parkingListHeaders = {"Parkplatznr.","Status", "Besetzen", "Reservieren","Freigeben"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);

        final TableView<ParkingLot> tableView= (TableView<ParkingLot>) findViewById(R.id.tableView);
        tableView.setColumnCount(5);
        tableView.setHeaderBackgroundColor(Color.parseColor("#3F51B5"));

        DatabaseHelper dbHelper = DatabaseHelper.getInstance(getApplicationContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        ParkingLotController.parkingLotController = new ParkingLotController(db);

        ParkingAdapter parkingAdapter = new ParkingAdapter(this, ParkingLotController.parkingLotController.getDatabaseEntries());

        //ParkingAdapter parkingAdapter = new ParkingAdapter(this, ParkingLotController.parkingLotController.getParkingLotResults());


        ParkingTableHeaderAdapter parkingTableHeaderAdapter = new ParkingTableHeaderAdapter(this,parkingListHeaders);

        tableView.setWeightSum(5);
        TableColumnWeightModel tableColumnWeightModel = new TableColumnWeightModel(5);
        tableColumnWeightModel.setColumnWeight(0, 1);
        tableColumnWeightModel.setColumnWeight(1, 1);
        tableColumnWeightModel.setColumnWeight(2, 1);
        tableColumnWeightModel.setColumnWeight(3, 1);
        tableColumnWeightModel.setColumnWeight(4, 1);

        tableView.setColumnModel(tableColumnWeightModel);

        //Adapter werden hinzugefuegt
        tableView.setHeaderAdapter(parkingTableHeaderAdapter);
        tableView.setDataAdapter(parkingAdapter);

    }
}
