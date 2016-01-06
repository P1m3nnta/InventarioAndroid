package com.inventarioweb.empresa.inventarioandroid.View;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.inventarioweb.empresa.inventarioandroid.Model.Articulo;
import com.inventarioweb.empresa.inventarioandroid.Model.User;
import com.inventarioweb.empresa.inventarioandroid.R;
import com.inventarioweb.empresa.inventarioandroid.RealizarConteo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class app extends AppCompatActivity implements View.OnClickListener {
    private Button btnsoncronizar;
    private String url;
    private RequestQueue fRequestQueue;
    Context context;
    private User user;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        context= this;
        url= getString(R.string.url_con);
        fRequestQueue= Volley.newRequestQueue(this);
        btnsoncronizar= (Button)findViewById(R.id.btnSincronizar);
        btnsoncronizar.setOnClickListener(this);
        Button btnsubir = (Button)findViewById(R.id.BtnSubirIventario);
        btnsubir.setOnClickListener(this);
        Button btncerrarsession =(Button)findViewById(R.id.btnCerrarSesion);
        btncerrarsession.setOnClickListener(this);
        Button btnhacerinventario = (Button)findViewById(R.id.BtnRealizarConteo);
        btnhacerinventario.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSincronizar:

                DateFormat hourdateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //recibe el json y lo guarda en el objeto de la clase
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                        url+"/Articulo/traerArticulos?fecha="+ hourdateFormat + "&nit="+ user.getNit()  ,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    if(response.getBoolean("success")){
                                        JSONArray art =response.getJSONArray("lista");
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
                                        }
                                    }else {
                                        Alerta("Lista vacia.");
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e("Volley", "ERROR: " + error.getMessage());
                                Alerta("Error en el servidor");
                            }
                        }
                );
                fRequestQueue.add(jsonObjectRequest);
                break;

            case R.id.BtnRealizarConteo:
                startActivity(new Intent(getBaseContext(), RealizarConteo.class));
                break;
            case R.id.BtnSubirIventario:
                Snackbar.make(v, "Este boton sube el inventario", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            case R.id.btnCerrarSesion:
                Snackbar.make(v, "Este boton cierra la session", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
        }

    }
    public void Alerta(String mensaje){
        final AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(this).create();
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
    class TareaAsincrona extends AsyncTask<Void, Void, Void>{
        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(app.this, "", "Danos un momento..", true);
            super.onPreExecute();
        }
        @Override
        protected Void doInBackground(Void... params) {

            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            progressDialog.cancel();
            super.onPostExecute(aVoid);
        }
    }

}
