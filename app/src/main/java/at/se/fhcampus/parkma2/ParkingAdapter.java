package at.se.fhcampus.parkma2;

import android.content.Context;
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

        //View view = getLayoutInflater().inflate(R.layout.checkbox,parentView,false);

        CheckBox checkBox = new CheckBox(getContext());

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parkingLot.setStatus("besetzt");
                notifyDataSetChanged();
            }
        });

        if (parkingLot.getStatus() == "frei"){
            checkBox.setEnabled(true);
        }
        else if (parkingLot.getStatus() == "besetzt" || parkingLot.getStatus()=="reserviert"){
            if (parkingLot.getStatus() == "besetzt"){
                checkBox.setChecked(true);
            }
            checkBox.setEnabled(false);
        }



        return checkBox;
    }

    public View renderReservierenCheckbox(final ParkingLot parkingLot){

        //View view = getLayoutInflater().inflate(R.layout.checkbox,parentView,false);

        CheckBox checkBox = new CheckBox(getContext());

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parkingLot.setStatus("reserviert");
                notifyDataSetChanged();

            }
        });

        if (parkingLot.getStatus() == "frei"){
            checkBox.setEnabled(true);
        }
        else if (parkingLot.getStatus() == "besetzt" || parkingLot.getStatus() == "reserviert"){

            if (parkingLot.getStatus() == "reserviert"){
                checkBox.setChecked(true);
            }
            checkBox.setEnabled(false);
        }



        return checkBox;
    }

    public View renderFreigeben(final ParkingLot parkingLot){
        CheckBox checkBox = new CheckBox(getContext());

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parkingLot.setStatus("frei");
                notifyDataSetChanged();
            }
        });

        if (parkingLot.getStatus()=="besetzt" || parkingLot.getStatus()=="reserviert"){
            checkBox.setEnabled(true);
        }
        else{
            checkBox.setEnabled(false);
            return null;
        }

        return checkBox;
    }
}
