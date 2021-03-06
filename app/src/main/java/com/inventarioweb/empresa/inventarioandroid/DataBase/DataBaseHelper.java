package com.inventarioweb.empresa.inventarioandroid.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.inventarioweb.empresa.inventarioandroid.Model.Articulo;
import com.inventarioweb.empresa.inventarioandroid.Model.ArticuloSerial;
import com.inventarioweb.empresa.inventarioandroid.Model.PlaneacionEmpleados;
import com.inventarioweb.empresa.inventarioandroid.Model.PlaneacionUbicaciones;
import com.inventarioweb.empresa.inventarioandroid.Model.ReporteConteo;
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

    private Dao<ArticuloSerial, Integer> articulo_serialDAO = null;
    private RuntimeExceptionDao<ArticuloSerial, Integer> articulo_serialRuntimeDao = null;

    private Dao<PlaneacionEmpleados, Integer> planeacionempleadosDAO = null;
    private RuntimeExceptionDao<PlaneacionEmpleados, Integer> planeacionempleadosRuntimeDAO =null;

    private Dao<PlaneacionUbicaciones, Integer> planeacionubicacionesDAO = null;
    private RuntimeExceptionDao<PlaneacionUbicaciones, Integer> planeacionubicacionesRuntimeDAO = null;

    private Dao<ReporteConteo, Integer> reporteconteoDAO = null;
    private RuntimeExceptionDao<ReporteConteo, Integer> reporteconteoRuntimeDAO = null;

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

    public void onResetArticulos(){
        try {
            ConnectionSource source = this.getConnectionSource();
            TableUtils.dropTable(source, Articulo.class, true);
            TableUtils.createTable(source, Articulo.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onResetUsuario(){
        try {
            ConnectionSource source = this.getConnectionSource();
            TableUtils.dropTable(source, User.class, true);
            TableUtils.createTable(source, User.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onResetUbicaciones(){
        try {
            ConnectionSource source = this.getConnectionSource();
            TableUtils.dropTable(source, PlaneacionUbicaciones.class, true);
            TableUtils.createTable(source,PlaneacionUbicaciones.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void close(){
        super.close();
        userDAO = null;
        userRuntimeDao = null;

        articuloDAO = null;
        articuloRuntimeDao = null;

        articulo_serialDAO = null;
        articulo_serialRuntimeDao = null;

        planeacionempleadosDAO = null;
        planeacionempleadosRuntimeDAO = null;

        planeacionubicacionesDAO = null;
        planeacionubicacionesRuntimeDAO = null;

        reporteconteoDAO = null;
        reporteconteoRuntimeDAO = null;
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

    public Dao<ArticuloSerial, Integer> getArticuloSerialDAO() throws SQLException{
        if (articulo_serialDAO == null) articulo_serialDAO = getDao(ArticuloSerial.class);
        return articulo_serialDAO;
    }

    public RuntimeExceptionDao<ArticuloSerial, Integer> getArticuloSerialRuntimeDao() throws SQLException{
        if (articulo_serialRuntimeDao == null) articulo_serialRuntimeDao = getRuntimeExceptionDao(ArticuloSerial.class);
        return articulo_serialRuntimeDao;
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

    public Dao<ReporteConteo, Integer> getReporteConteoDAO() throws SQLException{
        if (reporteconteoDAO == null) reporteconteoDAO = getDao(ReporteConteo.class);
        return reporteconteoDAO;
    }
    public RuntimeExceptionDao<ReporteConteo, Integer> getReporteconteoRuntimeDAO() throws SQLException{
        if (reporteconteoRuntimeDAO == null) reporteconteoRuntimeDAO = getRuntimeExceptionDao(ReporteConteo.class);
        return reporteconteoRuntimeDAO;
    }
}

