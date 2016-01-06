package com.inventarioweb.empresa.inventarioandroid.Controller;

import android.content.Context;
import android.util.Log;

import com.inventarioweb.empresa.inventarioandroid.DataBase.DataBaseHelper;
import com.inventarioweb.empresa.inventarioandroid.Model.Ubicacion;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;
/**
 * Created by Henry on 6/01/16.
 */
public class ubicacionController {
    private DataBaseHelper helper;
    public boolean crear(Ubicacion ubicacion, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<Ubicacion, Integer> ubicacionDao = helper.getUbicacionRuntimeDao();
            ubicacionDao.create(ubicacion); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("ubicacionController", "error: ", e);
        }
        return res;
    }
    public boolean borrar(Ubicacion ubicacion, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<Ubicacion, Integer> ubicacionDao = helper.getUbicacionRuntimeDao();
            ubicacionDao.delete(ubicacion); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("ubicacionController","error: ", e);
        }
        return res;
    }
    public boolean actualizar(Ubicacion ubicacion, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<Ubicacion, Integer> ubicacionDao = helper.getUbicacionRuntimeDao();
            ubicacionDao.update(ubicacion); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("ubicacionController","error: ", e);
        }
        return res;
    }
    public List<Ubicacion> listaUbicaciones(Context context){
        List<Ubicacion> listaubicaciones = null;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<Ubicacion, Integer> ubicacionDao = helper.getUbicacionRuntimeDao();
            listaubicaciones = ubicacionDao.queryForAll();
        }catch (Exception e){
            Log.e("ubicacionController","error: ", e);
        }
        return listaubicaciones;
    }
}
