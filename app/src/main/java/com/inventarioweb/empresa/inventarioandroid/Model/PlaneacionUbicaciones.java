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
    private String fecha;

    @DatabaseField
    private String usuarioEmpresa;

    @DatabaseField
    private String usuarioEmpleado;

    @DatabaseField
    private String nitEmpresa;

    @DatabaseField
    private String ubicacion;

    @DatabaseField
    private String conteos;

    @DatabaseField
    private String supervisor;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUsuarioEmpresa() {
        return usuarioEmpresa;
    }

    public void setUsuarioEmpresa(String usuarioEmpresa) {
        this.usuarioEmpresa = usuarioEmpresa;
    }

    public String getUsuarioEmpleado() {
        return usuarioEmpleado;
    }

    public void setUsuarioEmpleado(String usuarioEmpleado) {
        this.usuarioEmpleado = usuarioEmpleado;
    }

    public String getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(String nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
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

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PlaneacionUbicaciones{" +
                "id=" + id +
                ", fecha='" + fecha + '\'' +
                ", usuarioEmpresa='" + usuarioEmpresa + '\'' +
                ", usuarioEmpleado='" + usuarioEmpleado + '\'' +
                ", nitEmpresa='" + nitEmpresa + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", conteos='" + conteos + '\'' +
                ", supervisor='" + supervisor + '\'' +
                '}';
    }
}
