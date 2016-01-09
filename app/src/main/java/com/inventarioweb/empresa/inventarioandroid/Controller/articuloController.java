package com.inventarioweb.empresa.inventarioandroid.Controller;

import android.content.Context;
import android.util.Log;

import com.inventarioweb.empresa.inventarioandroid.DataBase.DataBaseHelper;
import com.inventarioweb.empresa.inventarioandroid.Model.Articulo;
import com.inventarioweb.empresa.inventarioandroid.Model.User;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;

/**
 * Created by Henry on 10/11/15.
 */
public class articuloController {


    private DataBaseHelper helper;

    public boolean crear(Articulo articulo, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<Articulo, Integer> articuloDao = helper.getArticuloRuntimeDao();
            articuloDao.create(articulo); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("ArticuloController", "error: ", e);
        }

        return res;
    }

    public boolean borrar(Articulo articulo, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<Articulo, Integer> articuloDao = helper.getArticuloRuntimeDao();
            articuloDao.delete(articulo); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("ArticuloController","error: ", e);
        }

        return res;
    }
    public boolean actualizar(Articulo articulo, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<Articulo, Integer> articuloDao = helper.getArticuloRuntimeDao();
            articuloDao.update(articulo); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("ArticuloController","error: ", e);
        }

        return res;
    }

    public List<Articulo> listaArticulos(Context context){
        List<Articulo> listaarticulos = null;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<Articulo, Integer> articuloDao = helper.getArticuloRuntimeDao();
            listaarticulos = articuloDao.queryForAll();

        }catch (Exception e){
        }
        return listaarticulos;
    }
    public Articulo mGetArticulo(String codigobarras, Context context){
        Articulo articulo = null;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<Articulo, Integer> articuloDao = helper.getArticuloRuntimeDao();
            articulo = articuloDao.queryForEq("codigobarras",codigobarras).get(0);
        }catch (Exception e){
            articulo = null;
        }
        return articulo;
    }
}
