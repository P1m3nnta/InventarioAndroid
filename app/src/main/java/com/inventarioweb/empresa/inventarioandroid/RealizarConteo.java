package com.inventarioweb.empresa.inventarioandroid;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.inventarioweb.empresa.inventarioandroid.View.google.zxing.integration.android.IntentIntegrator;
import com.inventarioweb.empresa.inventarioandroid.View.google.zxing.integration.android.IntentResult;

public class RealizarConteo extends AppCompatActivity {
    ImageButton BotonScaner;
    Button BtnGuardar, BtnAbrirUbicacion, BtnTerminar;
    EditText EdtCodigo, EdtDescripcion, EdtCantidad, EdtUbicacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar_conteo);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        EdtCodigo = (EditText)findViewById(R.id.EdtCodigo);
        BotonScaner = (ImageButton)findViewById(R.id.IBbarcode);
        EdtDescripcion = (EditText)findViewById(R.id.EdtDescripcion);
        EdtCantidad = (EditText)findViewById(R.id.EdtCantidad);
        EdtUbicacion = (EditText)findViewById(R.id.EdtUbicacion);
        BtnGuardar = (Button)findViewById(R.id.BtnGuardar);
        BtnAbrirUbicacion = (Button)findViewById(R.id.BtnAbrirUbicacion);
        BtnTerminar = (Button)findViewById(R.id.BtnTerminar);
        BotonScaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.IBbarcode){
                    IntentIntegrator scanIntegrator = new IntentIntegrator(RealizarConteo.this);
                    scanIntegrator.initiateScan();
                }
            }
        });

    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();
            //formatTxt.setText("FORMAT: " + scanFormat);
           EdtCodigo.setText(scanContent);
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
