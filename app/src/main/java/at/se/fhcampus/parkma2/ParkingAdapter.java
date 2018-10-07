package at.se.fhcampus.parkma2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import at.se.fhcampus.parkma2.models.ParkingLot;
import de.codecrafters.tableview.TableDataAdapter;
import de.codecrafters.tableview.model.TableColumnModel;
import de.codecrafters.tableview.model.TableColumnWeightModel;

public class ParkingAdapter extends TableDataAdapter<ParkingLot>{

    private DatabaseHelper dbHelper = DatabaseHelper.getInstance(getContext());
    private final SQLiteDatabase db = dbHelper.getWritableDatabase();


    public ParkingAdapter(Context context, ArrayList<ParkingLot> parkingLotList)
    {
        super(context,parkingLotList);

    }

    @Override
    public View getCellView(int rowIndex, int columnIndex, ViewGroup parentView) {

        ParkingLot parkingLot = getRowData(rowIndex);

        View renderedView = null;

        switch (columnIndex){
            case 0:
                renderedView = renderId(parkingLot);
                break;
            case 1:
                renderedView = renderStatus(parkingLot);
                break;
            case 2:
                renderedView = renderBesetzenCheckbox(parkingLot);
                break;
            case 3:
                renderedView= renderReservierenCheckbox(parkingLot);
                break;
            case 4:
                renderedView = renderFreigeben(parkingLot);
                break;
        }
        return renderedView;
    }

    public View renderId (ParkingLot parkingLot){
        TextView textView = new TextView(getContext());
        textView.setText(parkingLot.getId());

        return textView;
    }

    public View renderStatus (ParkingLot parkingLot){
        TextView textView = new TextView(getContext());
        textView.setText(parkingLot.getStatus());

        return textView;
    }

    public View renderBesetzenCheckbox(final ParkingLot parkingLot){

        CheckBox checkBox = new CheckBox(getContext());

        if (parkingLot.getStatus().equals("frei")){
            checkBox.setEnabled(true);
        }
        else if (parkingLot.getStatus().equals("besetzt")  || parkingLot.getStatus().equals("reserviert")){
            if (parkingLot.getStatus().equals("besetzt")){
                checkBox.setChecked(true);
            }
            checkBox.setEnabled(false);
        }

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parkingLot.setStatus("besetzt");

                String var = "besetzt";
                ContentValues values = new ContentValues();
                values.put(ParkinglotContract.ParkinglotEntry.COLUMN_NAME_PARKINGLOT_STATE, var);

                String selection = ParkinglotContract.ParkinglotEntry.COLUMN_NAME_PARKINGLOT_ID + " = " + parkingLot.getId();

                int count = db.update(
                        ParkinglotContract.ParkinglotEntry.TABLE_NAME,
                        values,
                        selection,
                        null);

                System.out.println("Rows affected: " + count);


                notifyDataSetChanged();
            }
        });

        return checkBox;
    }

    public View renderReservierenCheckbox(final ParkingLot parkingLot){

        CheckBox checkBox = new CheckBox(getContext());

        if (parkingLot.getStatus().equals("frei")){
            checkBox.setEnabled(true);
        }
        else if (parkingLot.getStatus().equals("besetzt" )|| parkingLot.getStatus().equals("reserviert")){

            if (parkingLot.getStatus().equals("reserviert")){
                checkBox.setChecked(true);
            }
            checkBox.setEnabled(false);
        }


        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parkingLot.setStatus("reserviert");

                String var = "reserviert";
                ContentValues values = new ContentValues();
                values.put(ParkinglotContract.ParkinglotEntry.COLUMN_NAME_PARKINGLOT_STATE, var);

                String selection = ParkinglotContract.ParkinglotEntry.COLUMN_NAME_PARKINGLOT_ID + " = " + parkingLot.getId();

                int count = db.update(
                        ParkinglotContract.ParkinglotEntry.TABLE_NAME,
                        values,
                        selection,
                        null);

                System.out.println("Rows affected: " + count);

                notifyDataSetChanged();

            }
        });

        return checkBox;
    }

    public View renderFreigeben(final ParkingLot parkingLot){
        final CheckBox checkBox = new CheckBox(getContext());

        if (parkingLot.getStatus().equals("besetzt") || parkingLot.getStatus().equals("reserviert")){
            checkBox.setEnabled(true);
        }
        else{
            checkBox.setEnabled(false);
            return null;
        }

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parkingLot.setStatus("frei");

                checkBox.setChecked(true);

                String var = "frei";
                ContentValues values = new ContentValues();
                values.put(ParkinglotContract.ParkinglotEntry.COLUMN_NAME_PARKINGLOT_STATE, var);

                String selection = ParkinglotContract.ParkinglotEntry.COLUMN_NAME_PARKINGLOT_ID + " = " + parkingLot.getId();

                int count = db.update(
                        ParkinglotContract.ParkinglotEntry.TABLE_NAME,
                        values,
                        selection,
                        null);

                System.out.println("Rows affected: " + count);

                notifyDataSetChanged();
            }
        });

        return checkBox;
    }
}
