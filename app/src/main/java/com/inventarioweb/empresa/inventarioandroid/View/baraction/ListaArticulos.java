package com.inventarioweb.empresa.inventarioandroid.View.baraction;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.inventarioweb.empresa.inventarioandroid.Controller.articuloController;
import com.inventarioweb.empresa.inventarioandroid.Model.Articulo;
import com.inventarioweb.empresa.inventarioandroid.R;

import java.util.List;

public class ListaArticulos extends Activity {
Context context;
    ListView lv;
    List<Articulo> art;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_articulos);
        lv = (ListView)findViewById(R.id.listViewArticulos);
        context = this;
        articuloController controlerarticulo = new articuloController();
        art = controlerarticulo.listaArticulos(context);
        ArrayAdapter<Articulo> adapter = new ArrayAdapter<>(ListaArticulos.this,
                R.layout.support_simple_spinner_dropdown_item,art);
        lv.setAdapter(adapter);
    }

}
