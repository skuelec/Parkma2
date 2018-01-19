package at.se.fhcampus.parkma2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        try {
            Thread.sleep(3000);

        }catch (Exception e){
            e.printStackTrace();
        }

        Intent getLoginScreen = new Intent(this,
                LoginActivity2.class);

        startActivity(getLoginScreen);
    }
}
