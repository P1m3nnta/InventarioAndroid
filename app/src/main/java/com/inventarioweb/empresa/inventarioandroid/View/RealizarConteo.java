package com.inventarioweb.empresa.inventarioandroid.View;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.inventarioweb.empresa.inventarioandroid.Controller.articuloController;
import com.inventarioweb.empresa.inventarioandroid.Model.Articulo;
import com.inventarioweb.empresa.inventarioandroid.R;
import com.inventarioweb.empresa.inventarioandroid.View.google.zxing.integration.android.IntentIntegrator;
import com.inventarioweb.empresa.inventarioandroid.View.google.zxing.integration.android.IntentResult;

public class RealizarConteo extends Activity implements View.OnClickListener, View.OnKeyListener, CompoundButton.OnCheckedChangeListener {
    ImageButton BotonScaner;
    Button BtnGuardar, BtnTerminar;
    ToggleButton BtnAbrirUbicacion;
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
        BtnTerminar = (Button)findViewById(R.id.BtnTerminar);
        BtnAbrirUbicacion = (ToggleButton)findViewById(R.id.BtnAbrirUbicacion);
        BtnAbrirUbicacion.setOnCheckedChangeListener(this);
        BotonScaner.setOnClickListener(this);
        EdtCodigo.setOnKeyListener(this);
//        EdtCodigo.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//
//                return false;
//            }
//        });
    }
    //Escanner de codigos
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();
            //formatTxt.setText("FORMAT: " + scanFormat);
           EdtCodigo.setText(scanContent);
            articuloController controladorarticulo = new articuloController();
            Articulo arti = controladorarticulo.mGetArticulo(scanContent, RealizarConteo.this);
            if (arti != null){
                EdtDescripcion.setText(arti.getDescripcion());
            }
            //else{
//                Toast.makeText(RealizarConteo.this, "Articulo no encontrado", Toast.LENGTH_LONG).show();
//            }
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.IBbarcode:
                IntentIntegrator scanIntegrator = new IntentIntegrator(RealizarConteo.this);
                scanIntegrator.initiateScan();
                break;
//            case R.id.BtnAceptar:
//                Toast.makeText(RealizarConteo.this, "hola", Toast.LENGTH_SHORT).show();
//                break;
        }
    }
    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        articuloController controladorarticulo = new articuloController();
                Articulo arti = controladorarticulo.mGetArticulo(EdtCodigo.getText().toString(), RealizarConteo.this);
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    if (arti != null) {
                        if(!EdtCodigo.getText().toString().equals("")){
                            EdtCantidad.requestFocus();
                            EdtDescripcion.setText(arti.getDescripcion());
                        }else{
                            EdtCodigo.requestFocus();
                        }
//                        String codigo =  EdtCodigo.getText().toString();
//                        String mCadenaSinBlancos = null;
//                        for (int i=0; i < codigo.length(); i++) {
//                            if (codigo.charAt(i) != ' ')
//                                mCadenaSinBlancos += codigo.charAt(i);
//                        }
//                        EdtCodigo.setText(mCadenaSinBlancos
                    }else {
                        EdtDescripcion.setText("");
                        Toast.makeText(RealizarConteo.this, "Articulo no encontrado", Toast.LENGTH_LONG).show();
                    }
                }
        return false;
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Funciones funciones = new Funciones();
        if(isChecked){
            funciones.Alerta("Ubicacion "+EdtUbicacion.getText()+" abierta", RealizarConteo.this);
        }else{
            funciones.Alerta("Ubicacion cerrada", RealizarConteo.this);
        }
    }
//    public void AlertaPersonalizada(){
//        LayoutInflater inflater = getLayoutInflater();
//        final View dialogLayout = inflater.inflate(R.layout.dialog, null);
//        Button aceptar = (Button)findViewById(R.id.BtnAceptar);
//        aceptar.setOnClickListener(this);
//        AlertDialog.Builder builder = new AlertDialog.Builder(RealizarConteo.this);
//        builder.setView(dialogLayout);
//        builder.show();
//    }
}
