package com.inventarioweb.empresa.inventarioandroid.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Henry on 6/01/16.
 */
@DatabaseTable(tableName = "planeacionubicaciones")
public class PlaneacionUbicaciones {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String ubicacion;

    @DatabaseField
    private String conteos;

    @DatabaseField
    private String sede;

    @DatabaseField
    private String codinico;

    @DatabaseField
    private String codcierre;

    public PlaneacionUbicaciones() {

    }

    public PlaneacionUbicaciones(int id, String ubicacion, String conteos, String sede, String codinico, String codcierre) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.conteos = conteos;
        this.sede = sede;
        this.codinico = codinico;
        this.codcierre = codcierre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getConteos() {
        return conteos;
    }

    public void setConteos(String conteos) {
        this.conteos = conteos;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getCodinico() {
        return codinico;
    }

    public void setCodinico(String codinico) {
        this.codinico = codinico;
    }

    public String getCodcierre() {
        return codcierre;
    }

    public void setCodcierre(String codcierre) {
        this.codcierre = codcierre;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PlaneacionUbicaciones{" +
                "id=" + id +
                ", ubicacion='" + ubicacion + '\'' +
                ", conteos='" + conteos + '\'' +
                ", sede='" + sede + '\'' +
                ", codinico='" + codinico + '\'' +
                ", codcierre='" + codcierre + '\'' +
                '}';
    }
}
