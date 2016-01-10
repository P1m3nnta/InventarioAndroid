package com.inventarioweb.empresa.inventarioandroid.View.baraction;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.inventarioweb.empresa.inventarioandroid.Controller.articuloController;
import com.inventarioweb.empresa.inventarioandroid.Controller.planeacionUbicacionesController;
import com.inventarioweb.empresa.inventarioandroid.Model.Articulo;
import com.inventarioweb.empresa.inventarioandroid.Model.PlaneacionUbicaciones;
import com.inventarioweb.empresa.inventarioandroid.R;

import java.util.List;

public class ListaUbicaciones extends Activity {
    ListView lv1;
    Context context;
    List<PlaneacionUbicaciones> PU;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ubicaciones);
        lv1 = (ListView)findViewById(R.id.listViewUbicaciones);
        context = this;
        planeacionUbicacionesController controlerubi = new planeacionUbicacionesController();
        PU = controlerubi.listaPlaneacionUbicaicones(context);
        if(PU != null){
            ArrayAdapter<PlaneacionUbicaciones> adapter = new ArrayAdapter<>(ListaUbicaciones.this,
                    R.layout.support_simple_spinner_dropdown_item,PU);
            lv1.setAdapter(adapter);
        }else{
            Toast.makeText(ListaUbicaciones.this, "LISTA VACIA", Toast.LENGTH_LONG).show();
        }
    }
}

