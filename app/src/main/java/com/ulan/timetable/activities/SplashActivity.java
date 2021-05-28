package com.ulan.timetable.activities;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;


//SOURCE CODE CAN BE FOUND AT: https://github.com/SabithPkcMnr/SplashScreen
//GRAPHIC BY GREENLINES STUDIOS: https://www.pinterest.com.au/pin/745627282053059622/

import com.ulan.timetable.R;

import java.util.Calendar;

public class SplashActivity extends AppCompatActivity {

    ProgressBar splashProgress;
    int SPLASH_TIME = 2000; //This is 2 seconds
    Calendar c = Calendar.getInstance(); //Calls in device calendar for time info
    int timeOfDay = c.get(Calendar.HOUR_OF_DAY); //Creates timeOfDay int 00 to 23



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //This is additional feature, used to run a progress bar
        splashProgress = findViewById(R.id.splashProgress);
        playProgress();

        //Code to start timer and take action after the timer ends
        new Handler(getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do any action here. Now we are moving to next page
                Intent mySuperIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(mySuperIntent);

                //This 'finish()' is for exiting the app when back button pressed from Home page which is ActivityHome
                finish();

            }
        }, SPLASH_TIME);

        //Code to change greeting based off time
        TextView textViewGreet = (TextView) findViewById(R.id.greeting);
        if(timeOfDay >= 0 && timeOfDay < 12){
            textViewGreet.setText(R.string.good_morning);
        }else if(timeOfDay >= 12 && timeOfDay < 16){
            textViewGreet.setText(R.string.good_afternoon);
        }else if(timeOfDay >= 16 && timeOfDay < 21){
            textViewGreet.setText(R.string.good_evening);
        }else if(timeOfDay >= 21 && timeOfDay < 24){
            textViewGreet.setText(R.string.good_night);
        }
    }

    //Method to run progress bar for 5 seconds
    private void playProgress() {
        ObjectAnimator.ofInt(splashProgress, "progress", 100)
                .setDuration(5000)
                .start();
    }
}
