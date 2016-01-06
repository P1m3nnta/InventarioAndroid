package com.inventarioweb.empresa.inventarioandroid.Controller;

import android.content.Context;
import android.util.Log;

import com.inventarioweb.empresa.inventarioandroid.DataBase.DataBaseHelper;
import com.inventarioweb.empresa.inventarioandroid.Model.PlaneacionEmpleados;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;

/**
 * Created by Henry on 6/01/16.
 */
public class planeacionEmpleadosController {
    private DataBaseHelper helper;
    public boolean crear(PlaneacionEmpleados planeacionempleados, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<PlaneacionEmpleados, Integer> planeacionempleadosDao = helper.getPlaneacionempleadosRuntimeDAO();
            planeacionempleadosDao.create(planeacionempleados); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("planeacionEmpController", "error: ", e);
        }
        return res;
    }
    public boolean borrar(PlaneacionEmpleados planeacionempleados, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<PlaneacionEmpleados, Integer> planeacionempleadosDao = helper.getPlaneacionempleadosRuntimeDAO();
            planeacionempleadosDao.delete(planeacionempleados); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("planeacionEmpController","error: ", e);
        }
        return res;
    }
    public boolean actualizar(PlaneacionEmpleados planeacionempleados, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<PlaneacionEmpleados, Integer> planeacionempleadosDao = helper.getPlaneacionempleadosRuntimeDAO();
            planeacionempleadosDao.update(planeacionempleados); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("planeacionEmpController","error: ", e);
        }
        return res;
    }
    public List<PlaneacionEmpleados> listaPlaneacionEmpleados(Context context){
        List<PlaneacionEmpleados> listaplaneacionempleados = null;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<PlaneacionEmpleados, Integer> planeacionempleadosDao = helper.getPlaneacionempleadosRuntimeDAO();
            listaplaneacionempleados = planeacionempleadosDao.queryForAll();
        }catch (Exception e){
            Log.e("planeacionEmpController","error: ", e);
        }
        return listaplaneacionempleados;
    }
}
