package com.inventarioweb.empresa.inventarioandroid.View;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
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
import com.inventarioweb.empresa.inventarioandroid.Controller.planeacionUbicacionesController;
import com.inventarioweb.empresa.inventarioandroid.Model.Articulo;
import com.inventarioweb.empresa.inventarioandroid.Model.PlaneacionUbicaciones;
import com.inventarioweb.empresa.inventarioandroid.Model.ReporteConteo;
import com.inventarioweb.empresa.inventarioandroid.R;
import com.inventarioweb.empresa.inventarioandroid.View.google.zxing.integration.android.IntentIntegrator;
import com.inventarioweb.empresa.inventarioandroid.View.google.zxing.integration.android.IntentResult;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.inventarioweb.empresa.inventarioandroid.R.drawable.barcodegrey48;

public class RealizarConteo extends Activity implements View.OnClickListener, View.OnKeyListener, CompoundButton.OnCheckedChangeListener {
    ImageButton BotonScaner, BotonScanerUbicaciones;
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
        BotonScanerUbicaciones = (ImageButton)findViewById(R.id.imageButtonUbi);
        EdtDescripcion = (EditText)findViewById(R.id.EdtDescripcion);
        EdtCantidad = (EditText)findViewById(R.id.EdtCantidad);
        EdtUbicacion = (EditText)findViewById(R.id.EdtUbicacion);
        BtnGuardar = (Button)findViewById(R.id.BtnGuardar);
        BtnTerminar = (Button)findViewById(R.id.BtnTerminar);
        BtnAbrirUbicacion = (ToggleButton)findViewById(R.id.BtnAbrirUbicacion);
        BtnAbrirUbicacion.setOnCheckedChangeListener(this);
        BotonScaner.setOnClickListener(this);
        BotonScanerUbicaciones.setOnClickListener(this);
        EdtCodigo.setOnKeyListener(this);
        mComponentesEnables();
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
        if (EdtCodigo != null){
            if (scanningResult != null) {
                String scanContent = scanningResult.getContents();
//                String scanFormat = scanningResult.getFormatName();
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
        }else if (EdtUbicacion != null){
            if (scanningResult != null) {
                String scanContent = scanningResult.getContents();
                String scanFormat = scanningResult.getFormatName();
                //formatTxt.setText("FORMAT: " + scanFormat);
                EdtUbicacion.setText(scanContent);
//                planeacionUbicacionesController PUC = new planeacionUbicacionesController();
//                PlaneacionUbicaciones UbiApertura = PUC.mGetpuc(scanContent,RealizarConteo.this);
//                if(UbiApertura != null){
//                    if(UbiApertura.getCodinico() == EdtUbicacion.getText().toString()){
//                        onCheckedChanged(BtnAbrirUbicacion,true);
//                    }
//                }
            } else {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "No scan data received!", Toast.LENGTH_SHORT);
                toast.show();
            }
        }

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.IBbarcode:
                IntentIntegrator scanIntegrator = new IntentIntegrator(RealizarConteo.this);
                scanIntegrator.initiateScan();
                break;
            case R.id.imageButtonUbi:
                IntentIntegrator scanIntegrator2 = new IntentIntegrator(RealizarConteo.this);
                scanIntegrator2.initiateScan();
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
            planeacionUbicacionesController PUC = new planeacionUbicacionesController();
            PlaneacionUbicaciones UbiApertura = PUC.mGetpuc(EdtUbicacion.getText().toString(),RealizarConteo.this);
            if(UbiApertura != null){
                funciones.Alerta("Ubicacion " + EdtUbicacion.getText() + " abierta", RealizarConteo.this);
                EdtUbicacion.setText("");
                mHabilitarEnables();
                //Obtener fecha
//               String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
//                ReporteConteo reporteConteo=new ReporteConteo();
                //reporteConteo.set
            }else {
                funciones.Alerta("Ubicacion no existe", RealizarConteo.this);
                BtnAbrirUbicacion.setChecked(false);
            }
        }else{
            mComponentesEnables();
            funciones.Alerta("Ubicacion cerrada", RealizarConteo.this);
        }
    }
//  Metodo para establecer Enables False los botones
    public void mComponentesEnables(){
        EdtCodigo.setEnabled(false);
        EdtCodigo.setHintTextColor(Color.parseColor("#B6B6B6"));
        BotonScaner.setEnabled(false);
        BotonScaner.setImageResource(R.drawable.barcodegrey48);
        EdtDescripcion.setEnabled(false);
        EdtDescripcion.setHintTextColor(Color.parseColor("#B6B6B6"));
        EdtCantidad.setEnabled(false);
        EdtCantidad.setHintTextColor(Color.parseColor("#B6B6B6"));
        BtnGuardar.setEnabled(false);
        BtnGuardar.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.savegrey48, 0);
        BtnGuardar.setTextColor(Color.parseColor("#B6B6B6"));
    }
    public void mHabilitarEnables(){
        EdtCodigo.setEnabled(true);
        EdtCodigo.setHintTextColor(Color.parseColor("#ffffff"));
        BotonScaner.setEnabled(true);
        BotonScaner.setImageResource(R.drawable.barcode48);
        EdtDescripcion.setEnabled(true);
        EdtDescripcion.setHintTextColor(Color.parseColor("#ffffff"));
        EdtCantidad.setEnabled(true);
        EdtCantidad.setHintTextColor(Color.parseColor("#ffffff"));
        BtnGuardar.setEnabled(true);
        BtnGuardar.setTextColor(Color.parseColor("#ffffff"));
        BtnGuardar.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.save48, 0);
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
