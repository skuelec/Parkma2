package at.se.fhcampus.parkma2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.drawable.AnimationDrawable;
import android.widget.RelativeLayout;

import at.se.fhcampus.parkma2.controller.ParkingLotController;

public class StartActivity extends AppCompatActivity {

    AnimationDrawable animationDrawable;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);

        animationDrawable =(AnimationDrawable)relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);

        animationDrawable.start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callLogin();
            }
        }, 3000);
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
