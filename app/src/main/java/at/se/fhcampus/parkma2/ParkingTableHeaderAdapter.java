package at.se.fhcampus.parkma2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import de.codecrafters.tableview.TableHeaderAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public final class ParkingTableHeaderAdapter extends TableHeaderAdapter {


    public  ParkingTableHeaderAdapter(Context context){
        super(context);
    }

    @Override
    public View getHeaderView(int columnIndex, ViewGroup parentView) {
        return null;
    }
}
