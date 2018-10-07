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

    public static class Users implements  BaseColumns{
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_NAME_USER_ID = "user_id";
        public static final String COLUMN_NAME_USER_NAME = "user_name";
        public static final String COLUMN_NAME_USER_PW = "user_password";

    }

}
