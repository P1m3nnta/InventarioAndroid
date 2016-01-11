package com.inventarioweb.empresa.inventarioandroid.View.baraction;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.inventarioweb.empresa.inventarioandroid.Controller.articuloController;
import com.inventarioweb.empresa.inventarioandroid.Controller.planeacionUbicacionesController;
import com.inventarioweb.empresa.inventarioandroid.Model.Articulo;
import com.inventarioweb.empresa.inventarioandroid.Model.PlaneacionUbicaciones;
import com.inventarioweb.empresa.inventarioandroid.R;

import java.util.ArrayList;
import java.util.List;

public class ListaUbicaciones extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ubicaciones);
        Context context = this;
         planeacionUbicacionesController PUC = new planeacionUbicacionesController();
        List<PlaneacionUbicaciones> pu = PUC.listaPlaneacionUbicaicones(context);
        ListView lv = (ListView)findViewById(R.id.listViewArticulos);
        ArrayAdapter<PlaneacionUbicaciones> adap = new ArrayAdapter<PlaneacionUbicaciones>(this, R.layout.support_simple_spinner_dropdown_item, pu);
        lv.setAdapter(adap);

//        planeacionUbicacionesController PUC = new planeacionUbicacionesController();
//        List<PlaneacionUbicaciones> PU = PUC.listaPlaneacionUbicaicones(context);
//        ListView lv = (ListView)findViewById(R.id.listViewUbicaciones);
//        ArrayList<PlaneacionUbicaciones> itemsUbicaciones= obtenerItems();
//        PUCAdapter adapter = new PUCAdapter(this, itemsUbicaciones);
//        lv.setAdapter(adapter);
    }
    private ArrayList<PlaneacionUbicaciones> obtenerItems() {
        ArrayList<PlaneacionUbicaciones> items = new ArrayList<PlaneacionUbicaciones>();

        items.add(new PlaneacionUbicaciones(2,"dsfsdkfs","Patatas", "Tuberculo", "patatas","dasdsad"));
        items.add(new PlaneacionUbicaciones(2,"fsdggsgs", "Naranja", "Fruta", "naranjas","dadsad"));
        items.add(new PlaneacionUbicaciones(3,"dasdada", "Lechuga", "Verdura", "lechuga","fsdfsdfsd"));

        return items;
    }
    public class PUCAdapter extends BaseAdapter {
        protected Activity activity;
        protected ArrayList<PlaneacionUbicaciones> items;

        public PUCAdapter(Activity activity, ArrayList<PlaneacionUbicaciones> items) {
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
            PlaneacionUbicaciones item = items.get(position);

            TextView Ubi = (TextView) vi.findViewById(R.id.txtDesc);
            Ubi.setText(item.getUbicacion());

            TextView conteos = (TextView) vi.findViewById(R.id.txtCb);
            conteos.setText(item.getConteos());

            TextView codini = (TextView) vi.findViewById(R.id.txtCi);
            codini.setText(item.getCodinico());

            TextView codcierre = (TextView) vi.findViewById(R.id.txtCs);
            codcierre.setText(item.getCodcierre());

            return vi;
        }

    }

}