package at.se.fhcampus.parkma2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.drawable.AnimationDrawable;
import android.widget.RelativeLayout;

public class StartActivity extends AppCompatActivity {

    AnimationDrawable animationDrawable;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);
// onCreate
        animationDrawable =(AnimationDrawable)relativeLayout.getBackground();

        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);
// onResume
        animationDrawable.start();

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
