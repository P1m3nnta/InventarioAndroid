package com.inventarioweb.empresa.inventarioandroid.Controller;

import android.content.Context;
import android.util.Log;

import com.inventarioweb.empresa.inventarioandroid.DataBase.DataBaseHelper;
import com.inventarioweb.empresa.inventarioandroid.Model.User;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;

/**
 * Created by Henry on 10/11/15.
 */
public class userController {
    private DataBaseHelper helper;

    public boolean crear(User user, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<User, Integer> userDao = helper.getUserRuntimeDao();
            userDao.create(user); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("userController", "error: ", e);
        }

        return res;
    }

    public boolean borrar(User user, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<User, Integer> userDao = helper.getUserRuntimeDao();
            userDao.delete(user); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("userController","error: ", e);
        }

        return res;
    }

    public boolean actualizar(User contac, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<User, Integer> userDao = helper.getUserRuntimeDao();
            userDao.update(contac); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("userController","error: ", e);
        }

        return res;
    }

    public List<User> listaUsuarios(Context context){

        List<User> listausuarios = null;

        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<User, Integer> userDao = helper.getUserRuntimeDao();
            listausuarios = userDao.queryForAll();

        }catch (Exception e){

        }

        return listausuarios;
    }
}
