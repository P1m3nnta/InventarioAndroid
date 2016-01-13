package com.inventarioweb.empresa.inventarioandroid.Controller;

import android.content.Context;
import android.util.Log;

import com.inventarioweb.empresa.inventarioandroid.DataBase.DataBaseHelper;
import com.inventarioweb.empresa.inventarioandroid.Model.ReporteConteo;
import com.inventarioweb.empresa.inventarioandroid.Model.User;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;

/**
 * Created by Henry on 12/01/16.
 */
public class reporteConteoController {
    private DataBaseHelper helper;

    public boolean crear(ReporteConteo repoconteo, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<ReporteConteo, Integer> repoconteoDao = helper.getReporteconteoRuntimeDAO();
            repoconteoDao.create(repoconteo); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("reporteConteoController", "error: ", e);
        }
        return res;
    }

    public boolean borrar(ReporteConteo repoconteo, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<ReporteConteo, Integer> repoconteoDao = helper.getReporteconteoRuntimeDAO();
            repoconteoDao.delete(repoconteo); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("reporteConteoController","error: ", e);
        }
        return res;
    }

    public boolean actualizar(ReporteConteo reporteConteo, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<ReporteConteo, Integer> repoconteoDao = helper.getReporteconteoRuntimeDAO();
            repoconteoDao.update(reporteConteo); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("ReporteConteoController","error: ", e);
        }
        return res;
    }

    public List<ReporteConteo> listaReportesConteos(Context context){
        List<ReporteConteo> listarepoconteo = null;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<ReporteConteo, Integer> reporteConteosDao = helper.getReporteconteoRuntimeDAO();
            listarepoconteo = reporteConteosDao.queryForAll();

        }catch (Exception e){
            Log.e("ReporteConteoController","error", e);
        }
        return listarepoconteo;
    }
}
