/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zergio
 */
public final class ServidoresDisponibles {

    public static final String ORA = "com.porcupine.psp.pu.oracle";
    public static final String SQL = "com.porcupine.psp.pu.sqlserver";
    public static final String SYB = "com.porcupine.psp.pu.sybase";

    public ServidoresDisponibles() {
    }

    public static List<String> obtenerListaServidores() {
        ArrayList<String> lista = new ArrayList<String>();



        lista.add(ORA);
        lista.add(SQL);
        lista.add(SYB);

        return lista;
    }
}
