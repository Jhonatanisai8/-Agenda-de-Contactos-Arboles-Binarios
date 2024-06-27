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
}
