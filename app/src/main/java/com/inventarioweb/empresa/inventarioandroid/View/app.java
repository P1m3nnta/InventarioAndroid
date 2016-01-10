package com.inventarioweb.empresa.inventarioandroid.View;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.inventarioweb.empresa.inventarioandroid.Controller.articuloController;
import com.inventarioweb.empresa.inventarioandroid.Controller.planeacionUbicacionesController;
import com.inventarioweb.empresa.inventarioandroid.Controller.userController;
import com.inventarioweb.empresa.inventarioandroid.DataBase.DataBaseHelper;
import com.inventarioweb.empresa.inventarioandroid.Model.Articulo;
import com.inventarioweb.empresa.inventarioandroid.Model.PlaneacionUbicaciones;
import com.inventarioweb.empresa.inventarioandroid.Model.User;
import com.inventarioweb.empresa.inventarioandroid.R;
import com.inventarioweb.empresa.inventarioandroid.View.baraction.ListaArticulos;
import com.inventarioweb.empresa.inventarioandroid.View.baraction.ListaUbicaciones;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class app extends AppCompatActivity implements View.OnClickListener {
    private Button btnsincronizar, btnsubir, btncerrarsession, btnhacerinventario;
    private String url;
    private RequestQueue fRequestQueue = null;
    private RequestQueue fRequestQueueUbicaciones = null;
    JsonObjectRequest jsonObjectRequest = null;
    JsonObjectRequest jsonObjectRequestUbicaciones = null;
    User us;
    Context context;
    ProgressDialog progressDialog;
    TextView mUsuario, mCedula, mEmpresa, mNit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        context = this;
        url = getString(R.string.url_con);
        mUsuario = (TextView) findViewById(R.id.txtnombre);
        mCedula = (TextView) findViewById(R.id.txtcedula);
        mEmpresa = (TextView) findViewById(R.id.txtempresa);
        mNit = (TextView) findViewById(R.id.txtnit);

        userController controladorusuario = new userController();
        us = controladorusuario.mGetusuario(context);
        mUsuario.setText(us.getNombre());
        mCedula.setText(us.getCedula());
        mEmpresa.setText(us.getNombreempresa());
        mNit.setText(us.getNit());

        fRequestQueue = Volley.newRequestQueue(this);
        btnsincronizar = (Button) findViewById(R.id.btnSincronizar);
        btnsubir = (Button) findViewById(R.id.BtnSubirIventario);
        btncerrarsession = (Button) findViewById(R.id.btnCerrarSesion);
        btnhacerinventario = (Button) findViewById(R.id.BtnRealizarConteo);
        btnsincronizar.setOnClickListener(this);
        btnhacerinventario.setOnClickListener(this);
        btnsubir.setOnClickListener(this);
        btncerrarsession.setOnClickListener(this);
        articuloController controlerarticulo = new articuloController();
        List<Articulo> art = controlerarticulo.listaArticulos(context);
        if(art!=null){
            btnsincronizar.setTextColor(Color.parseColor("#B6B6B6"));
            btnsincronizar.setEnabled(false);
            btnsincronizar.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.syncgrey48,0);
        }else{
            btnhacerinventario.setTextColor(Color.parseColor("#B6B6B6"));
            btnhacerinventario.setEnabled(false);
            btnhacerinventario.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.addgrey48, 0);
            btnsubir.setTextColor(Color.parseColor("#B6B6B6"));
            btnsubir.setEnabled(false);
            btnsubir.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.uploadgrey48, 0);
        }
    }
    //    http://www.inventario2014.somee.com/Articulo/traerArticulos?nit=13722990
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        switch (item.getItemId()) {
            case R.id.action_articulos:
                startActivity(new Intent(app.this, ListaArticulos.class));
                Log.i("ActionBar", "Articulos!");
                return true;
            case R.id.action_ubicaciones:
                startActivity(new Intent(app.this, ListaUbicaciones.class));
                Log.i("ActionBar", "Ubicaciones!");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSincronizar:
                sincronizar();
                break;
            case R.id.BtnRealizarConteo:
                startActivity(new Intent(getBaseContext(), RealizarConteo.class));
                break;
            case R.id.BtnSubirIventario:
                Snackbar.make(v, "Este boton sube el inventario", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            case R.id.btnCerrarSesion:
                startActivity(new Intent(app.this, login.class));
                finish();
                break;
        }
    }
    public void sincronizar() {
        final Funciones funciones = new Funciones();
        progressDialog = ProgressDialog.show(app.this, "", "Danos un momento..");
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url + "/Articulo/traerArticulos?nit=" + us.getNit(),
                new Response.Listener<JSONObject>() {
                    Funciones funciones = new Funciones();
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response.getBoolean("success")) {
                                DataBaseHelper dataBaseHelper = new DataBaseHelper(app.this);
                                dataBaseHelper.onResetArticulos();
                                JSONArray art = response.getJSONArray("lista");
                                for (int i = 0; i < art.length(); i++) {
                                    JSONObject aux = art.getJSONObject(i);
                                    Articulo a = new Articulo();
                                    a.setDescripcion(aux.getString("descripcion"));
                                    a.setCantidad(Long.parseLong(aux.getString("cantidad")));
                                    a.setCodigobarras(aux.getString("codigobarras"));
                                    a.setCodigointerno(aux.getString("codigointerno"));
                                    a.setCantidadXP(Long.parseLong(aux.getString("cantidadXP")));
                                    a.setCodtipo(aux.getString("codtipo"));
                                    a.setTipo(aux.getString("tipo"));
                                    a.setCodigoSuperior(aux.getString("codigosuperior"));
                                    articuloController controladorart = new articuloController();
                                    controladorart.crear(a, app.this);
                                    btnsincronizar.setTextColor(Color.parseColor("#B6B6B6"));
                                    btnsincronizar.setEnabled(false);
                                    btnsincronizar.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.syncgrey48, 0);
                                    Log.w("SERVIDOR: ", a.toString());
                                }
                                funciones.Alerta("Terminado.", app.this);
                            } else {
                                funciones.Alerta("Lista vacia", app.this);
                            }
                            progressDialog.cancel();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "ERROR: " + error.getMessage());
                        progressDialog.cancel();
                        funciones.Alerta("Error en el servidor", app.this);
                    }
                }
        );
        fRequestQueue.add(jsonObjectRequest);
//        progressDialog = ProgressDialog.show(app.this, "", "Danos un momento..");
//        jsonObjectRequestUbicaciones = new JsonObjectRequest(Request.Method.GET,
//                url + "/Planeacion/buscarPlanUbicacionEmpleado?nit=" + us.getNit() + "&usuario=" + us.getNombre(),
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            if (response.getBoolean("success")){
////                                DataBaseHelper dataBaseHelper = new DataBaseHelper(app.this);
////                                dataBaseHelper.onResetArticulos();
//                                JSONArray ubi = response.getJSONArray("PlaneacionEmpleados");
//                                for (int i = 0; i < ubi.length() ; i++) {
//                                    JSONObject aux = ubi.getJSONObject(i);
//                                    PlaneacionUbicaciones Pu = new PlaneacionUbicaciones();
//                                    Pu.setUbicacion(aux.getString("ubicacion"));
//                                    Pu.setCodinico(aux.getString("codInicio"));
//                                    Pu.setCodcierre(aux.getString("codCierre"));
//                                    Pu.setConteos(aux.getString("conteos"));
//                                    Pu.setSede(aux.getString("sede"));
//                                    planeacionUbicacionesController PUC = new planeacionUbicacionesController();
//                                    PUC.crear(Pu, app.this);
//                                    Log.w("UBICACIONES",Pu.toString());
//                                }
//                                funciones.Alerta("Terminado", app.this);
//                                progressDialog.cancel();
//                            }
//                        }catch (Exception e){
//
//                        }
//                    }
//                } ,new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("Volley", "ERROR: " + error.getMessage());
//                funciones.Alerta("Error en el servidor", app.this);
//                progressDialog.cancel();
//            }
//        });
//        fRequestQueue.add(jsonObjectRequestUbicaciones);
    }

}
