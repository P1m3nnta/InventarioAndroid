package com.inventarioweb.empresa.inventarioandroid.View.baraction;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.inventarioweb.empresa.inventarioandroid.Controller.articuloController;
import com.inventarioweb.empresa.inventarioandroid.Controller.userController;
import com.inventarioweb.empresa.inventarioandroid.DataBase.DataBaseHelper;
import com.inventarioweb.empresa.inventarioandroid.Model.Articulo;
import com.inventarioweb.empresa.inventarioandroid.Model.User;
import com.inventarioweb.empresa.inventarioandroid.R;
import com.inventarioweb.empresa.inventarioandroid.View.Funciones;
import com.j256.ormlite.stmt.mapped.MappedQueryForId;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
public class ListaArticulos extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_articulos);
        Context context = this;
        articuloController controlerarticulo = new articuloController();

        List<Articulo> arti = controlerarticulo.listaArticulos(context);
        ListView lv = (ListView)findViewById(R.id.listViewArticulos);
        ArrayAdapter<Articulo> adap = new ArrayAdapter<Articulo>(this, R.layout.support_simple_spinner_dropdown_item, arti);
        lv.setAdapter(adap);

        List<Articulo> art = controlerarticulo.listaArticulos(context);
//        ListView lv = (ListView)findViewById(R.id.listViewArticulos);
        ArrayList<Articulo> itemsArticulos= obtenerItems();
        ArticuloAdapter adapter = new ArticuloAdapter(this, itemsArticulos);
//        lv.setAdapter(adapter);
    }
    private ArrayList<Articulo> obtenerItems() {
        ArrayList<Articulo> items = new ArrayList<Articulo>();

        items.add(new Articulo("sadasda",2,1,"dsfsdkfs","Patatas", "Tuberculo", "patatas","dasdsad"));
        items.add(new Articulo("fsdfsd",2,8,"fsdggsgs", "Naranja", "Fruta", "naranjas","dadsad"));
        items.add(new Articulo("dasda",2,3,"dasdada", "Lechuga", "Verdura", "lechuga","fsdfsdfsd"));

        return items;
    }
    public class ArticuloAdapter extends BaseAdapter {
        protected Activity activity;
        protected ArrayList<Articulo> items;

        public ArticuloAdapter(Activity activity, ArrayList<Articulo> items) {
            this.activity = activity;
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return items.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View vi=convertView;

            if(convertView == null) {
                LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                vi = inflater.inflate(R.layout.dialog, null);
            }
            Articulo item = items.get(position);

            TextView desc = (TextView) vi.findViewById(R.id.txtDesc);
            desc.setText(item.getDescripcion());

            TextView codigo = (TextView) vi.findViewById(R.id.txtCb);
            codigo.setText(item.getCodigobarras());

            TextView cod1 = (TextView) vi.findViewById(R.id.txtCi);
            cod1.setText(item.getCodigointerno());

            TextView codsup = (TextView) vi.findViewById(R.id.txtCs);
            codsup.setText(item.getCodigoSuperior());

            TextView codt = (TextView) vi.findViewById(R.id.txtCt);
            codt.setText(item.getCodtipo());

            TextView tipo = (TextView) vi.findViewById(R.id.txtTipo);
            tipo.setText(item.getTipo());

            TextView cant = (TextView) vi.findViewById(R.id.txtCant);
            cant.setText(String.valueOf(item.getCantidad()));

            TextView cantxp = (TextView) vi.findViewById(R.id.txtCantXp);
            cantxp.setText(String.valueOf(item.getCantidadXP()));
            return vi;
        }

    }

}
