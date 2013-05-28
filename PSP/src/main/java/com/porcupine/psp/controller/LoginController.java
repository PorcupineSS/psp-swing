/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.controller;

import com.porcupine.psp.model.dao.exceptions.DataBaseException;
import com.porcupine.psp.model.service.ServiceFactory;
import com.porcupine.psp.model.vo.EmpleadosVO;
import com.porcupine.psp.view.Login;
import com.porcupine.psp.view.Psp;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JViewport;

/**
 *
 * @author jaevergarav
 */
public class LoginController {
    
    static Login login;
    static Psp psp;
    public static EmpleadosVO empleadoActivo;

    public static EmpleadosVO getEmpleadoLogin() {
        return empleadoActivo;
    }

    public static void setUsuarioLogin(EmpleadosVO empleadoLogin) {
        LoginController.empleadoActivo = empleadoLogin;
    } 
    
    public static void mostrarLogin() {
        psp = new Psp();
        psp.setLocationRelativeTo(null);
        login = new Login();
        psp.setVisible(true);
        cambiarPanel(psp.getViewport(), login);
    }

    public static void cerrar() {
        System.exit(0);
    }

    public static void cambiarPanel(JViewport contenedor, JPanel panel) {
        contenedor.getParent().setVisible(false);
        contenedor.setVisible(false);
        contenedor.removeAll();
        contenedor.add(panel);
        contenedor.setSize(panel.getPreferredSize().getSize());
        contenedor.getParent().setSize(panel.getPreferredSize().getSize());
        contenedor.getParent().revalidate();
        contenedor.getParent().repaint();
        contenedor.revalidate();
        contenedor.repaint();
        contenedor.getParent().setVisible(true);
        contenedor.setVisible(true);
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
