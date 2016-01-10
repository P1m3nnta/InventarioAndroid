package com.inventarioweb.empresa.inventarioandroid.Controller;

import android.content.Context;
import android.util.Log;

import com.inventarioweb.empresa.inventarioandroid.DataBase.DataBaseHelper;
import com.inventarioweb.empresa.inventarioandroid.Model.Articulo;
import com.inventarioweb.empresa.inventarioandroid.Model.PlaneacionUbicaciones;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;

/**
 * Created by Henry on 6/01/16.
 */
public class planeacionUbicacionesController {
    private DataBaseHelper helper;
    public boolean crear(PlaneacionUbicaciones planeacionubicaciones, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<PlaneacionUbicaciones, Integer> planeacionubicacionesDao = helper.getPlaneacionubicacionesRuntimeDAO();
            planeacionubicacionesDao.create(planeacionubicaciones); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("planeacionUbiController", "error: ", e);
        }
        return res;
    }
    public boolean borrar(PlaneacionUbicaciones planeacionubicaciones, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<PlaneacionUbicaciones, Integer> planeacionubicaiconesDao = helper.getPlaneacionubicacionesRuntimeDAO();
            planeacionubicaiconesDao.delete(planeacionubicaciones); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("planeacionUbiController","error: ", e);
        }
        return res;
    }
    public boolean actualizar(PlaneacionUbicaciones planeacionubicaciones, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<PlaneacionUbicaciones, Integer> planeacionubicacionesDao = helper.getPlaneacionubicacionesRuntimeDAO();
            planeacionubicacionesDao.update(planeacionubicaciones); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("planeacionEmpController","error: ", e);
        }
        return res;
    }
    public List<PlaneacionUbicaciones> listaPlaneacionUbicaicones(Context context){
        List<PlaneacionUbicaciones> listaplaubi = null;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<PlaneacionUbicaciones, Integer> planeacionUbicacionesDao = helper.getPlaneacionubicacionesRuntimeDAO();
            listaplaubi = planeacionUbicacionesDao.queryForAll();
        }catch (Exception e){
            Log.e("planeacionEmpController","error: ", e);
        }
        return listaplaubi;
    }
//
//    public List<PlaneacionUbicaciones> listaPlaneacionUbicaicones(Context context){
//        List<PlaneacionUbicaciones> listaplaneacionubicaciones = null;
//        try {
//            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
//            RuntimeExceptionDao<PlaneacionUbicaciones, Integer> planeacionubicacionesDao = helper.getPlaneacionubicacionesRuntimeDAO();
//            listaplaneacionubicaciones = planeacionubicacionesDao.queryForAll();
//        }catch (Exception e){
//            Log.e("planeacionEmpController","error: ", e);
//        }
//        return listaplaneacionubicaciones;
//    }
}
