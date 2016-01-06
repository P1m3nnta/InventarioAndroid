package com.inventarioweb.empresa.inventarioandroid.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.inventarioweb.empresa.inventarioandroid.Model.Articulo;
import com.inventarioweb.empresa.inventarioandroid.Model.PlaneacionEmpleados;
import com.inventarioweb.empresa.inventarioandroid.Model.PlaneacionUbicaciones;
import com.inventarioweb.empresa.inventarioandroid.Model.Ubicacion;
import com.inventarioweb.empresa.inventarioandroid.Model.User;
import com.inventarioweb.empresa.inventarioandroid.R;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 *
 * Created by Henry on 5/11/15.
 */
public class DataBaseHelper extends OrmLiteSqliteOpenHelper {


    private static final String DATABASE_NAME="Inventarioandroid.sql";
    private static final int DATABASE_VERSION= 1;

    private Dao<User, Integer> userDAO = null;
    private RuntimeExceptionDao<User, Integer> userRuntimeDao = null;

    private Dao<Articulo, Integer> articuloDAO = null;
    private RuntimeExceptionDao<Articulo, Integer> articuloRuntimeDao = null;

    private Dao<Ubicacion, Integer> ubicacionDAO = null;
    private RuntimeExceptionDao<Ubicacion, Integer> ubicacionRuntimeDao = null;

    private Dao<PlaneacionEmpleados, Integer> planeacionempleadosDAO = null;
    private RuntimeExceptionDao<PlaneacionEmpleados, Integer> planeacionempleadosRuntimeDAO =null;

    private Dao<PlaneacionUbicaciones, Integer> planeacionubicacionesDAO = null;
    private RuntimeExceptionDao<PlaneacionUbicaciones, Integer> planeacionubicacionesRuntimeDAO = null;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null ,DATABASE_VERSION, R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, User.class);
        }catch (SQLException e){
            Log.e(DataBaseHelper.class.getSimpleName(), "No se pudo crear la base de datos", e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

        try {
            TableUtils.dropTable(connectionSource, User.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        super.close();
        userDAO = null;
        userRuntimeDao = null;

        articuloDAO = null;
        articuloRuntimeDao = null;

        ubicacionDAO = null;
        ubicacionRuntimeDao = null;

        planeacionempleadosDAO = null;
        planeacionempleadosRuntimeDAO = null;

        planeacionubicacionesDAO = null;
        planeacionubicacionesRuntimeDAO = null;
    }

    public Dao<User, Integer> getUserDAO() throws SQLException{
        if (userDAO == null) userDAO = getDao(User.class);
        return userDAO;
    }

    public RuntimeExceptionDao<User, Integer> getUserRuntimeDao() throws SQLException{
        if (userRuntimeDao == null) userRuntimeDao = getRuntimeExceptionDao(User.class);
        return userRuntimeDao;
    }

    public Dao<Articulo, Integer> getArticuloDAO() throws SQLException{
        if (articuloDAO == null) articuloDAO = getDao(Articulo.class);
        return articuloDAO;
    }

    public RuntimeExceptionDao<Articulo, Integer> getArticuloRuntimeDao() throws SQLException{
        if (articuloRuntimeDao == null) articuloRuntimeDao = getRuntimeExceptionDao(Articulo.class);
        return articuloRuntimeDao;
    }

    public Dao<Ubicacion, Integer> getUbicacionDAO() throws SQLException{
        if (ubicacionDAO == null) ubicacionDAO = getDao(Ubicacion.class);
        return ubicacionDAO;
    }
    public RuntimeExceptionDao<Ubicacion, Integer> getUbicacionRuntimeDao() throws SQLException{
        if (ubicacionRuntimeDao == null) ubicacionRuntimeDao = getRuntimeExceptionDao(Ubicacion.class);
        return ubicacionRuntimeDao;
    }

    public Dao<PlaneacionEmpleados, Integer> getPlaneacionempleadosDAO() throws SQLException{
        if (planeacionempleadosDAO == null) planeacionempleadosDAO = getDao(PlaneacionEmpleados.class);
        return planeacionempleadosDAO;
    }
    public RuntimeExceptionDao<PlaneacionEmpleados, Integer> getPlaneacionempleadosRuntimeDAO() throws SQLException{
        if (planeacionempleadosRuntimeDAO == null) planeacionempleadosRuntimeDAO = getRuntimeExceptionDao(PlaneacionEmpleados.class);
        return planeacionempleadosRuntimeDAO;
    }
    public Dao<PlaneacionUbicaciones, Integer> getPlaneacionubicacionesDAO() throws SQLException{
        if (planeacionubicacionesDAO == null) planeacionubicacionesDAO = getDao(PlaneacionUbicaciones.class);
        return planeacionubicacionesDAO;
    }
    public RuntimeExceptionDao<PlaneacionUbicaciones, Integer> getPlaneacionubicacionesRuntimeDAO() throws SQLException{
        if (planeacionubicacionesRuntimeDAO == null) planeacionubicacionesRuntimeDAO = getRuntimeExceptionDao(PlaneacionUbicaciones.class);
        return planeacionubicacionesRuntimeDAO;
    }
}

