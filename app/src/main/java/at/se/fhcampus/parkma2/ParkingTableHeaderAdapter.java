package at.se.fhcampus.parkma2;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextClock;
import android.widget.TextView;

import org.w3c.dom.Text;

import de.codecrafters.tableview.TableHeaderAdapter;
import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.model.TableColumnModel;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class ParkingTableHeaderAdapter extends TableHeaderAdapter {

    private String[] headers;
    private int textSize = 11;
    //private int typeface = Typeface.BOLD;
    private int textColor = 0xFFFFFFFF;


    public  ParkingTableHeaderAdapter(Context context, String... headers){
        super(context);
        this.headers = headers;
    }

    @Override
    public View getHeaderView(int columnIndex, ViewGroup parentView) {
        //View view = getLayoutInflater().inflate(R.layout.activity_parking,parentView,false);

        TextView textView = new TextView(getContext());

        //TableColumnModel tableColumnModel = getColumnModel();

        textView.setText(headers[columnIndex]);
        //textView.setTypeface(textView.getTypeface(), typeface);
        textView.setTextSize(textSize);
        textView.setTextColor(textColor);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setLayoutParams(new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));

        return textView;
    }

}
