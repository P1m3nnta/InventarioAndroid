package com.inventarioweb.empresa.inventarioandroid.View;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class app extends AppCompatActivity implements View.OnClickListener {
    private Button btnsoncronizar;
    private String url;
    private RequestQueue fRequestQueue;
    Context context;
    private User user;
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
        btnsubir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Este boton sube el inventario", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button btncerrarsession =(Button)findViewById(R.id.btnCerrarSesion);
        btncerrarsession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Este boton cierra la session", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button btnhacerinventario = (Button)findViewById(R.id.BtnRealizarConteo);
        btnhacerinventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Este boton realiza el inventario", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public void onClick(View v) {
        //obtiene la fecha y la hora actual
        DateFormat hourdateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //recibe el json y lo guarda en el objeto de la clase
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url+"/Articulo/traerArticulos?fecha="+ hourdateFormat + "&nit="+ user.getNit()  ,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if(response.getBoolean("success")){

                                JSONObject art =response.getJSONObject("articulo");
                                Articulo a = new Articulo();
                                a.setDescripcion(art.get("descripcion").toString());
                                a.setCantidad(Long.parseLong(art.get("cantidad").toString()));
                                a.setCodigobarras(art.get("codigobarras").toString());
                                a.setCodigointerno(art.get("codigointerno").toString());

                            }else {
                                Toast.makeText(context, "Lista vacia", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(context, "Error en el servidor", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        fRequestQueue.add(jsonObjectRequest);

    }








}
