/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.controller;

import com.porcupine.psp.model.dao.exceptions.DataBaseException;
import com.porcupine.psp.model.service.ServiceFactory;
import com.porcupine.psp.model.vo.EmpleadosVO;
import com.porcupine.psp.util.DrawingUtilities;
import com.porcupine.psp.view.Login;
import com.porcupine.psp.view.Psp;
import com.porcupine.psp.view.SelectDataBaseConnection;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JViewport;

/**
 *
 * @author jaevergarav
 */
public class LoginController {

    static Login login;
    static SelectDataBaseConnection sdb;
    static Psp psp;
    public static EmpleadosVO empleadoActivo;
    public static String selectedDB;

    public String getSelectedDB() {
        return selectedDB;
    }

    public void setSelectedDB(String selectedDB) {
        this.selectedDB = selectedDB;
    }

    
    
    public static EmpleadosVO getEmpleadoLogin() {
        return empleadoActivo;
    }

    public static void setUsuarioLogin(EmpleadosVO empleadoLogin) {
        LoginController.empleadoActivo = empleadoLogin;
    }

    public static void mostrarLogin() {
        psp.setLocationRelativeTo(null);
        login = new Login();
        psp.setVisible(true);
        DrawingUtilities.drawPanel(psp, psp.getViewport(), login);
    }
    
    public static void mostrarSeleccionDB() {
        psp = new Psp();
        psp.setLocationRelativeTo(null);
        sdb = new SelectDataBaseConnection();
        psp.setVisible(true);
        DrawingUtilities.drawPanel(psp, psp.getViewport(), sdb);
    }

    public static void cerrar() {
        System.exit(0);
    }

    public static void login() {
        EmpleadosVO empleado = new EmpleadosVO();
        String cedulaEmpleado = login.getUsuarioTF().getText();
        String password = new String(login.getContrasenaPF().getPassword());

        empleado.setCedulaE(Long.parseLong(cedulaEmpleado.toString()));
        empleado.setContrasenaE(password);

        EmpleadosVO empleadoLogin;
        try {
            empleadoLogin = ServiceFactory.getInstance().getEmpleadosService().login(empleado);
        } catch (DataBaseException ex) {
            int opcion = JOptionPane.showOptionDialog(login, ex.getMessage() + "\n" + ex.getCause().getMessage(), "Error", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[]{"Reportar Error", "Cancelar"}, "Cancelar");
            switch (opcion) {
                case JOptionPane.OK_OPTION:
                    //TODO Reportar Error
                    break;
                case JOptionPane.CANCEL_OPTION:
                    break;
            }
            return;
        }

        if (empleadoLogin != null) {
            //TODO
        } else {
            JOptionPane.showMessageDialog(login, "¡Usuario o contraseña incorrectos!", "Error", JOptionPane.ERROR_MESSAGE, null);
        }
    }
}
