package com.inventarioweb.empresa.inventarioandroid.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Henry on 6/01/16.
 */

@DatabaseTable(tableName = "ubicaciones")
public class Ubicacion {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String username;

    @DatabaseField
    private String password;

    @DatabaseField
    private String type;

    @DatabaseField
    private String nombre;

    @DatabaseField
    private String cedula;

    @DatabaseField
    private String nit;

    @DatabaseField
    private String nombreEmpresa;

    public Ubicacion(String username, String password, String type, String nombre, String cedula,
                     String nit, String nombreEmpresa) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.nombre = nombre;
        this.cedula = cedula;
        this.nit = nit;
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Ubicacion{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", nit='" + nit + '\'' +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                '}';
    }
}
