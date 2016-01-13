package com.inventarioweb.empresa.inventarioandroid.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Henry on 12/01/16.
 */
@DatabaseTable(tableName = "reporteconteo")
public class ReporteConteo {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String fechaInv;

    @DatabaseField
    private String nitEmpresa;

    @DatabaseField
    private String usuario;

    @DatabaseField
    private String ubicacion;

    @DatabaseField
    private String fechaInicio;

    @DatabaseField
    private String fechaCierre;

    @DatabaseField
    private String conteo;

    @DatabaseField
    private String diferencia;

    @DatabaseField
    private String descripcionUbica;

    public ReporteConteo(String fechaInv, String nitEmpresa, String usuario, String ubicacion,
                         String fechaInicio, String fechaCierre, String conteo, String diferencia, String descripcionUbica) {
        this.fechaInv = fechaInv;
        this.nitEmpresa = nitEmpresa;
        this.usuario = usuario;
        this.ubicacion = ubicacion;
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.conteo = conteo;
        this.diferencia = diferencia;
        this.descripcionUbica = descripcionUbica;
    }
    public ReporteConteo(){
    }

    public String getFechaInv() {
        return fechaInv;
    }

    public void setFechaInv(String fechaInv) {
        this.fechaInv = fechaInv;
    }

    public String getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(String nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getConteo() {
        return conteo;
    }

    public void setConteo(String conteo) {
        this.conteo = conteo;
    }

    public String getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(String diferencia) {
        this.diferencia = diferencia;
    }

    public String getDescripcionUbica() {
        return descripcionUbica;
    }

    public void setDescripcionUbica(String descripcionUbica) {
        this.descripcionUbica = descripcionUbica;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ReporteConteo{" +
                "id=" + id +
                ", fechaInv='" + fechaInv + '\'' +
                ", nitEmpresa='" + nitEmpresa + '\'' +
                ", usuario='" + usuario + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaCierre='" + fechaCierre + '\'' +
                ", conteo='" + conteo + '\'' +
                ", diferencia='" + diferencia + '\'' +
                ", descripcionUbica='" + descripcionUbica + '\'' +
                '}';
    }
}
