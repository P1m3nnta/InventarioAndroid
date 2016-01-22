package com.inventarioweb.empresa.inventarioandroid.View;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.inventarioweb.empresa.inventarioandroid.Controller.userController;
import com.inventarioweb.empresa.inventarioandroid.DataBase.DataBaseHelper;
import com.inventarioweb.empresa.inventarioandroid.Model.User;
import com.inventarioweb.empresa.inventarioandroid.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.util.List;

public class login extends Activity implements View.OnClickListener {

    private String url;
    private RequestQueue fRequestQueue;
    private Context context;
    private ProgressDialog progressDialog;
    private EditText txtUsuario,txtpass;
    private Button boton;
    private CheckBox mCbShowPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        context = this;
        url = getString(R.string.url_con);
        inicializaobjetosenLogin();
        mostrarPassword();
    }
    @Override
    public void onClick(View v) {
        String email = txtUsuario.getText().toString();
        String pass = txtpass.getText().toString();
        if (email.equals("") || pass.equals("")) {
            Funciones funcion = new Funciones();
            funcion.Alerta("Ninguno de los campos deben estar vacios", context);
        } else {
            progressDialog = ProgressDialog.show(this, "", "Danos un momento..");
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                    url + "/Usuario/validarUsuario?user=" + email + "&pass=" + pass,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                if (response.getBoolean("success")) {
                                    JSONObject usu = response.getJSONObject("usuario");
                                    User u = new User();
                                    u.setNombre(usu.get("nombre").toString());
                                    u.setCedula(usu.get("cedula").toString());
                                    u.setNit(usu.get("nit").toString());
                                    u.setNombreempresa(usu.get("nombreempresa").toString());
                                    u.setPassword(usu.get("password").toString());
                                    u.setType(Integer.parseInt(usu.get("type").toString()));
                                    u.setUsername(usu.get("username").toString());
                                    userController usuarioController = new userController();
                                    usuarioController.crear(u, login.this);
                                    progressDialog.cancel();
                                    Intent principal = new Intent(login.this, app.class);
                                    startActivity(principal);
                                    finish();
                                } else {
                                    Funciones funciones = new Funciones();
                                    funciones.Alerta("Usuario invalido.", login.this);
                                    progressDialog.cancel();
//                                Toast.makeText(context, "Usuario No Valido", Toast.LENGTH_SHORT).show();
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
                            Funciones funciones = new Funciones();
                            funciones.Alerta("Revisa tu conexion.", login.this);
//                        Toast.makeText(context, "Revisa tu conexion", Toast.LENGTH_SHORT).show();
                            progressDialog.cancel();
                        }
                    }
            );
            fRequestQueue.add(jsonObjectRequest);
        }
    }
    public void mostrarPassword(){
        mCbShowPwd = (CheckBox) findViewById(R.id.cbShowPwd);
        mCbShowPwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // checkbox status is changed from uncheck to checked.
                if (!isChecked) {
                    // show password
                    txtpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // hide password
                    txtpass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }
    public void inicializaobjetosenLogin(){
        fRequestQueue = Volley.newRequestQueue(this);
        txtpass = (EditText) findViewById(R.id.txtPass);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        boton = (Button) findViewById(R.id.BtnAceptar);
        boton.setOnClickListener(this);
    }
}
