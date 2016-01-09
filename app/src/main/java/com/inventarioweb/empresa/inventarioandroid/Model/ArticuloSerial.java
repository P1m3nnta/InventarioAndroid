package com.inventarioweb.empresa.inventarioandroid.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Henry on 8/01/16.
 */
@DatabaseTable(tableName = "articuloserial")
public class ArticuloSerial {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String serial;

    @DatabaseField
    private String codigo_barras;

    @DatabaseField
    private String valor;

    public ArticuloSerial() {

    }

    public ArticuloSerial(String serial, String codigo_barras, String valor) {
        this.serial = serial;
        this.codigo_barras = codigo_barras;
        this.valor = valor;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ArticuloSerial{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                ", codigo_barras='" + codigo_barras + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }
}
