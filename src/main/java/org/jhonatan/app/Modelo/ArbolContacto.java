package org.jhonatan.app.Modelo;

public class ArbolContacto {

    private NodoContacto raiz;

    public ArbolContacto() {
        raiz = null;
    }

    public NodoContacto getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoContacto raiz) {
        this.raiz = raiz;
    }

    public NodoContacto agregarContacto(NodoContacto nodoContacto, Contacto contacto) {
        if (nodoContacto == null) {
            NodoContacto nuevo = new NodoContacto(contacto);
            return nuevo;
        } else {
            if (contacto.getNombreCompleto().compareTo(nodoContacto.getContacto().getNombreCompleto()) > 0) {
                nodoContacto.setDere(agregarContacto(nodoContacto.getDere(), contacto));
            } else {
                nodoContacto.setIzq(agregarContacto(nodoContacto.getIzq(), contacto));
            }
        }
        return nodoContacto;
    }

}
