package org.jhonatan.app.Modelo;

public class NodoContacto {

    private Contacto contacto;
    private NodoContacto izq, dere;

    public NodoContacto(Contacto contacto) {
        this.contacto = contacto;
        izq = null;
        dere = null;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public NodoContacto getIzq() {
        return izq;
    }

    public void setIzq(NodoContacto izq) {
        this.izq = izq;
    }

    public NodoContacto getDere() {
        return dere;
    }

    public void setDere(NodoContacto dere) {
        this.dere = dere;
    }

}
