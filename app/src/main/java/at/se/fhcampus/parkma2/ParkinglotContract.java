package at.se.fhcampus.parkma2;

import android.provider.BaseColumns;

public final class ParkinglotContract {

    private ParkinglotContract(){}


    public static class ParkinglotEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "parkinglots";
        public static final String COLUMN_NAME_PARKINGLOT_ID = "parkinglot_id";
        public static final String COLUMN_NAME_PARKINGLOT_STATE = "parkinglot_status";

    }


}
