package com.inventarioweb.empresa.inventarioandroid.View;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.inventarioweb.empresa.inventarioandroid.R;

/**
 * Created by Henry on 7/01/16.
 */
public class Funciones {

    public void Alerta(String mensaje, Context context){
        final AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(context).create();
//        alertDialog.setTitle("UPS!, Hemos tenido un problema");
        alertDialog.setMessage(mensaje);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.cancel();
            }
        });
        alertDialog.show();
    }


}
