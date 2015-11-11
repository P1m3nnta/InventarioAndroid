package com.inventarioweb.empresa.inventarioandroid.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.StringTokenizer;

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
        private String codigobarras;

        @DatabaseField
        private String codigointerno;

        public Articulo() {

        }

    public Articulo(String descripcion, long cantidad, String codigobarras, String codigointerno) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.codigobarras = codigobarras;
        this.codigointerno = codigointerno;
    }


    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public long getCantidad() {
        return cantidad;
    }

    public String getCodigobarras() {
        return codigobarras;
    }

    public String getCodigointerno() {
        return codigointerno;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public void setCodigobarras(String codigobarras) {
        this.codigobarras = codigobarras;
    }

    public void setCodigointerno(String codigointerno) {
        this.codigointerno = codigointerno;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", cantidad=" + cantidad +
                ", codigobarras='" + codigobarras + '\'' +
                ", codigointerno='" + codigointerno + '\'' +
                '}';
    }
}
