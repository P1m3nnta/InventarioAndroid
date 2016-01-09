package com.inventarioweb.empresa.inventarioandroid.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Henry on 6/01/16.
 */
@DatabaseTable(tableName = "planeacionempleados")
public class PlaneacionEmpleados {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String tipoConteo;

    @DatabaseField
    private String tipoRegistro;

    @DatabaseField
    private String opcionRegistro;

    @DatabaseField
    private String supervisor;

    @DatabaseField
    private String permiso;

    public PlaneacionEmpleados(String tipoConteo,String tipoRegistro, String opcionRegistro,
                               String supervisor, String permiso) {
        this.tipoConteo = tipoConteo;
        this.tipoRegistro = tipoRegistro;
        this.opcionRegistro = opcionRegistro;
        this.supervisor = supervisor;
        this.permiso = permiso;
    }

    public PlaneacionEmpleados() {
    }

    public String getTipoConteo() {
        return tipoConteo;
    }

    public void setTipoConteo(String tipoConteo) {
        this.tipoConteo = tipoConteo;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public String getOpcionRegistro() {
        return opcionRegistro;
    }

    public void setOpcionRegistro(String opcionRegistro) {
        this.opcionRegistro = opcionRegistro;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PlaneacionEmpleados{" +
                "id=" + id +
                ", tipoConteo='" + tipoConteo + '\'' +
                ", tipoRegistro='" + tipoRegistro + '\'' +
                ", opcionRegistro='" + opcionRegistro + '\'' +
                ", supervisor='" + supervisor + '\'' +
                ", permiso='" + permiso + '\'' +
                '}';
    }
}
