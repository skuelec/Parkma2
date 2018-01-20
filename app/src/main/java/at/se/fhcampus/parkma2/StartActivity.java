package at.se.fhcampus.parkma2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    @Override
    protected void onResume(){
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callLogin();
            }
        }, 3000);
    }

    private void callLogin(){

        Intent getLoginScreen = new Intent(this, LoginActivity2.class);

        startActivity(getLoginScreen);
    }


}
