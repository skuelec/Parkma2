package at.se.fhcampus.parkma2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        for(int i=0;i<300000000;i++){};

        Intent getLoginScreen = new Intent(this,
                LoginActivity.class);

        startActivity(getLoginScreen);
    }
}
