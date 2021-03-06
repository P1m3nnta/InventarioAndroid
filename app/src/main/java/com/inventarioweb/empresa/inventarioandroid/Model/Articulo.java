package com.inventarioweb.empresa.inventarioandroid.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Henry on 10/11/15.
 */
@DatabaseTable(tableName = "articulos")

public class Articulo {

        @DatabaseField(generatedId = true)
        private int id;

        @DatabaseField
        private String descripcion;

        @DatabaseField
        private long cantidad;

        @DatabaseField
        private long cantidadXP;

        @DatabaseField
        private String codigobarras;

        @DatabaseField
        private String codigointerno;

        @DatabaseField
        private String codigoSuperior;

        @DatabaseField
        private String codtipo;

        @DatabaseField
        private String tipo;

        @DatabaseField
        private String ubicaciones;

    public Articulo() {

        }

    public Articulo(String descripcion, long cantidad, long cantidadXP, String codigobarras,
                    String codigointerno, String codigoSuperior, String codtipo, String tipo, String ubicaciones) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.cantidadXP = cantidadXP;
        this.codigobarras = codigobarras;
        this.codigointerno = codigointerno;
        this.codigoSuperior = codigoSuperior;
        this.codtipo = codtipo;
        this.tipo = tipo;
        this.ubicaciones = ubicaciones;
    }

    public String getUbicaciones() {
        return ubicaciones;
    }

    public void setUbicaciones(String ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public long getCantidadXP() {
        return cantidadXP;
    }

    public void setCantidadXP(long cantidadXP) {
        this.cantidadXP = cantidadXP;
    }

    public String getCodigobarras() {
        return codigobarras;
    }

    public void setCodigobarras(String codigobarras) {
        this.codigobarras = codigobarras;
    }

    public String getCodigointerno() {
        return codigointerno;
    }

    public void setCodigointerno(String codigointerno) {
        this.codigointerno = codigointerno;
    }

    public String getCodtipo() {
        return codtipo;
    }

    public void setCodtipo(String codtipo) {
        this.codtipo = codtipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getCodigoSuperior() {
        return codigoSuperior;
    }

    public void setCodigoSuperior(String codigoSuperior) {
        this.codigoSuperior = codigoSuperior;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", cantidad=" + cantidad +
                ", cantidadXP=" + cantidadXP +
                ", codigobarras='" + codigobarras + '\'' +
                ", codigointerno='" + codigointerno + '\'' +
                ", codigoSuperior='" + codigoSuperior + '\'' +
                ", codtipo='" + codtipo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", ubicaciones='" + ubicaciones + '\'' +
                '}';
    }
}
