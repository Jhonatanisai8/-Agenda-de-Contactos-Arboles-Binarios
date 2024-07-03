package org.jhonatan.app.Modelo;

import javax.swing.table.DefaultTableModel;

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
                System.out.println(contacto.getNombreCompleto() + " Se agrego al nodo derecho: ");
            } else {
                nodoContacto.setIzq(agregarContacto(nodoContacto.getIzq(), contacto));
                System.out.println(contacto.getNombreCompleto() + " Se agrego al nodo izquierdo: ");
            }
        }
        return nodoContacto;
    }

    public NodoContacto buscarContacto(int codigo) {
        NodoContacto auxiliar = raiz;
        while (auxiliar != null) {
            if (auxiliar.getContacto().getCodigo() == codigo) {
                return auxiliar;
            } else {
                if (codigo > auxiliar.getContacto().getCodigo()) {
                    auxiliar = auxiliar.getDere();
                } else {
                    auxiliar = auxiliar.getIzq();
                }
            }
        }
        return null;
    }

    public void listarInOrden(NodoContacto nodoContacto, DefaultTableModel modelo) {
        if (nodoContacto != null) {
            listarInOrden(nodoContacto.getIzq(), modelo);
            modelo.addRow(nodoContacto.getContacto().getRegistro());
            listarInOrden(nodoContacto.getDere(), modelo);
        }
    }

    public NodoContacto buscarMayorIzquierda(NodoContacto nodoContacto) {
        if (nodoContacto != null) {
            while (nodoContacto.getDere() != null) {
                nodoContacto = nodoContacto.getDere();
            }
        }
        return nodoContacto;
    }

    public NodoContacto eliminarMayorIzquierda(NodoContacto auxiliar) {
        if (auxiliar == null) {
            return null;
        } else if (auxiliar.getDere() != null) {
            auxiliar.setDere(eliminarMayorIzquierda(auxiliar.getDere()));
            return auxiliar;
        }
        return auxiliar.getIzq();
    }

    public NodoContacto eliminar(NodoContacto auxiliar, int dato) {
        if (auxiliar == null) {
            return null;
        }
        if (dato < auxiliar.getContacto().getCodigo()) {
            auxiliar.setIzq(eliminar(auxiliar.getIzq(), dato));

        } else if (dato > auxiliar.getContacto().getCodigo()) {
            auxiliar.setDere(eliminar(auxiliar.getDere(), dato));
        } else if (auxiliar.getIzq() != null && auxiliar.getDere() != null) {
            auxiliar.setContacto(buscarMayorIzquierda(auxiliar.getIzq()).getContacto());
            auxiliar.setIzq(eliminarMayorIzquierda(auxiliar.getIzq()));
        } else {
            auxiliar = (auxiliar.getIzq() != null) ? auxiliar.getIzq() : auxiliar.getDere();
        }
        return auxiliar;
    }
}
