package at.se.fhcampus.parkma2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import at.se.fhcampus.parkma2.models.ParkingLot;
import de.codecrafters.tableview.TableDataAdapter;

public class ParkingAdapter extends TableDataAdapter<ParkingLot>{


    public ParkingAdapter(Context context, List<ParkingLot> parkingLotList)
    {
        super(context,parkingLotList);

    }

    @Override
    public View getCellView(int rowIndex, int columnIndex, ViewGroup parentView) {

        ParkingLot parkingLot = getRowData(rowIndex);

        View renderedView = null;

        switch (columnIndex){

            case 0:
                renderedView = renderId(parkingLot,parentView);
                break;

            case 1:
                renderedView = renderStatus(parkingLot,parentView);
                break;
            case 2:
                renderedView = renderBesetzenCheckbox(parkingLot, parentView);
                break;
            case 3:
                renderedView= renderBesetzenCheckbox(parkingLot, parentView);
                break;
        }
        return renderedView;
    }

    public View renderId (ParkingLot parkingLot, ViewGroup parentView){
        TextView textView = new TextView(getContext());
        textView.setText(parkingLot.getId());

        return textView;
    }

    public View renderStatus (ParkingLot parkingLot, ViewGroup parentView){
        TextView textView = new TextView(getContext());
        textView.setText(parkingLot.getStatus());

        return textView;
    }

    public View renderBesetzenCheckbox(final ParkingLot parkingLot, ViewGroup parentView){

        View view = getLayoutInflater().inflate(R.layout.checkbox,parentView,false);

        CheckBox checkBox = view.findViewById(R.id.checkbox);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parkingLot.setStatus("besetzt");
            }
        });

        if (parkingLot.getStatus() == "frei"){
            checkBox.setEnabled(true);
        }
        else if (parkingLot.getStatus() == "besetzt"){
            checkBox.setEnabled(false);

        }


        return view;
    }

    public View renderReservierenCheckbox(final ParkingLot parkingLot, ViewGroup parentView){

        View view = getLayoutInflater().inflate(R.layout.checkbox,parentView,false);

        CheckBox checkBox = view.findViewById(R.id.checkbox);


        if (parkingLot.getStatus() == "frei"){
            checkBox.setEnabled(true);
        }
        else if (parkingLot.getStatus() == "besetzt"){
            checkBox.setEnabled(false);

        }

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parkingLot.setStatus("besetzt");
            }
        });


        return view;
    }
}