package org.jhonatan.app.Modelo;

public class NodoContacto {

    private Contacto contacto;
    private NodoContacto izq, dere;

    public NodoContacto(Contacto contacto) {
        this.contacto = contacto;
        izq = null;
        dere = null;
    }

}
