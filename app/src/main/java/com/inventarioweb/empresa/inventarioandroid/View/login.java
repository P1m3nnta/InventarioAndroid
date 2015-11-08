package com.inventarioweb.empresa.inventarioandroid.View;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.inventarioweb.empresa.inventarioandroid.R;

import org.json.JSONException;
import org.json.JSONObject;

public class login extends AppCompatActivity implements View.OnClickListener {

    private String url;
    private RequestQueue fRequestQueue;
    Context context;
    //final ProgressDialog progressDialog = ProgressDialog.show(this,"Espere...","Sincronizando.");
    private EditText txtUsuario;
    private EditText txtpass;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        context= this;
        url= getString(R.string.url_con);
        fRequestQueue= Volley.newRequestQueue(this);
        txtpass=(EditText)findViewById(R.id.txtPass);
        txtUsuario= (EditText)findViewById(R.id.txtUsuario);
        boton =(Button)findViewById(R.id.BtnAceptar);
        boton.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v) {
        String email= txtUsuario.getText().toString();
        String pass = txtpass.getText().toString();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url+"/Usuario/validarUsuario?user="+email+"&pass="+pass,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if(response.getBoolean("success")){
                                Intent principal = new Intent(login.this,app.class);
                                startActivity(principal);
                            }else {
                                Toast.makeText(context, "Usuario No Valido", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "ERROR: "+error.getMessage());
                        Toast.makeText(context, "Error en el servidor", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        fRequestQueue.add(jsonObjectRequest);
    }
}
