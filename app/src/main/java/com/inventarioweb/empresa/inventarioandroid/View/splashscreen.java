package com.inventarioweb.empresa.inventarioandroid.View;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.inventarioweb.empresa.inventarioandroid.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Henry on 24/10/15.
 */
public class splashscreen extends Activity {
    public static int segundos = 6;
    public static int milisengundos= segundos * 1000;
    private ProgressBar BarProgress;
    public static int DELAY= 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splahsscreen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        BarProgress = (ProgressBar)findViewById(R.id.progressBar);
        Animacion();
        BarProgress.setMax(max_progress());
    }
    private void Animacion() {
        new CountDownTimer(milisengundos,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                BarProgress.setProgress(progress(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(getBaseContext(), login.class));
                finish();
            }
        }.start();
    }

    public int progress(long miliseconds){
        return (int)((milisengundos-miliseconds)/1000);
    }
    public int max_progress(){
        return segundos - DELAY;
    }
}
