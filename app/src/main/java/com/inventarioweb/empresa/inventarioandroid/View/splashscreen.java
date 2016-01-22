package com.inventarioweb.empresa.inventarioandroid.View;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.inventarioweb.empresa.inventarioandroid.Controller.userController;
import com.inventarioweb.empresa.inventarioandroid.Model.User;
import com.inventarioweb.empresa.inventarioandroid.R;

import java.util.List;
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
    private User us = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splahsscreen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        BarProgress = (ProgressBar)findViewById(R.id.progressBar);
//        Animacion();
//        BarProgress.setMax(max_progress());
//
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                userController controladorusuario = new userController();
//                List<User> usuarios = controladorusuario.listaUsuarios(splashscreen.this);
                User usuario = controladorusuario.mGetusuario(splashscreen.this);
                Log.w("login usarios ", usuario.toString());
                if (usuario != null){
                    startActivity(new Intent(splashscreen.this , app.class));
                    finish();
                }else{
                    Intent mainIntent = new Intent().setClass(splashscreen.this, login.class);
                    startActivity(mainIntent);
                    finish();
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0);
    }
//    private void Animacion() {
//        new CountDownTimer(milisengundos,1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                BarProgress.setProgress(progress(millisUntilFinished));
//            }
//
//            @Override
//            public void onFinish() {
//                startActivity(new Intent(getBaseContext(), login.class));
//                finish();
//            }
//        }.start();
//    }
//
//    public int progress(long miliseconds){
//        return (int)((milisengundos-miliseconds)/1000);
//    }
//    public int max_progress(){
//        return segundos - DELAY;
//    }
}
