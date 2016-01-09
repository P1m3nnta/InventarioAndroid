package com.inventarioweb.empresa.inventarioandroid.Controller;

import android.content.Context;
import android.util.Log;

import com.inventarioweb.empresa.inventarioandroid.DataBase.DataBaseHelper;
import com.inventarioweb.empresa.inventarioandroid.Model.Articulo;
import com.inventarioweb.empresa.inventarioandroid.Model.ArticuloSerial;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;

/**
 * Created by Henry on 8/01/16.
 */
public class articuloSerialController {
    private DataBaseHelper helper;

    public boolean crear(ArticuloSerial articulo_serial, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<ArticuloSerial, Integer> articulo_serialDao = helper.getArticuloSerialRuntimeDao();
            articulo_serialDao.create(articulo_serial); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("ArticuloSerController", "error: ", e);
        }

        return res;
    }

    public boolean borrar(ArticuloSerial articulo_serial, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<ArticuloSerial, Integer> articulo_serialDao = helper.getArticuloSerialRuntimeDao();
            articulo_serialDao.delete(articulo_serial); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("ArticuloSerController","error: ", e);
        }

        return res;
    }
    public boolean actualizar(ArticuloSerial articulo_serial, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<ArticuloSerial, Integer> articulo_serialDao = helper.getArticuloSerialRuntimeDao();
            articulo_serialDao.update(articulo_serial); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("ArticuloSerController","error: ", e);
        }
        return res;
    }

    public List<ArticuloSerial> listaArticuloSerial(Context context){
        List<ArticuloSerial> listaarticuloSerial= null;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<ArticuloSerial, Integer> articulo_serialDao = helper.getArticuloSerialRuntimeDao();
            listaarticuloSerial = articulo_serialDao.queryForAll();
        }catch (Exception e){
        }
        return listaarticuloSerial;
    }
//    public ArticuloSerial mGetArticuloSerial(String codigobarras, Context context){
//        ArticuloSerial articulo_serial = new ArticuloSerial();
//        try {
//            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
//            RuntimeExceptionDao<ArticuloSerial, Integer> articulo_serialDao = helper.getArticuloSerialRuntimeDao();
//            articulo_serial = articulo_serialDao.queryForEq("codigobarras",codigobarras).get(0);
//        }catch (Exception e){
//        }
//        return articulo_serial;
//    }
}
