package org.jhonatan.app.Modelo;

public class Contacto {

    private int codigo;
    private String apellidos;
    private String nombres;

    public Contacto(Object[] registro) {
        this.codigo = (int) registro[0];
        this.apellidos = registro[1].toString();
        this.nombres = registro[2].toString();
    }

    public Object[] getRegistro() {
        Object[] registro = {codigo, apellidos, nombres};
        return registro;
    }

    public String getNombreCompleto() {
        return apellidos + " " + nombres;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

}
