package com.inventarioweb.empresa.inventarioandroid.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Henry on 5/11/15.
 */

@DatabaseTable(tableName = "users")
public class User {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(index = true, canBeNull = false)
    private String username;

    @DatabaseField(canBeNull = false)
    private String password;

    @DatabaseField
    private int type;

    @DatabaseField
    private String nombre;

    @DatabaseField
    private String cedula;

    @DatabaseField
    private String nit;

    @DatabaseField
    private String nombreempresa;

    public User() {

    }

    public User(String username, String password, int type, String nombre, String cedula, String nit, String nombreempresa) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.nombre = nombre;
        this.cedula = cedula;
        this.nit = nit;
        this.nombreempresa = nombreempresa;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public void setNombreempresa(String nombreempresa) {
        this.nombreempresa = nombreempresa;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getType() {
        return type;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNit() {
        return nit;
    }

    public String getNombreempresa() {
        return nombreempresa;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", nit='" + nit + '\'' +
                ", nombreempresa='" + nombreempresa + '\'' +
                '}';
    }
}
