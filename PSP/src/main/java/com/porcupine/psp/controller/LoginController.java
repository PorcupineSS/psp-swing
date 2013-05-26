/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.controller;

import com.porcupine.psp.view.Login;
import com.porcupine.psp.view.Psp;
import javax.swing.JPanel;
import javax.swing.JViewport;

/**
 *
 * @author andres
 */
public class LoginController {
    
    static Login login;
    static Psp psp;
    
    public static void viewLogin() {
        psp= new Psp();
        psp.setLocationRelativeTo(null);
        login = new Login();
        psp.setVisible(true);
        changePanel(psp.getViewport(), login);
    }
    
    public static void changePanel(JViewport contenedor, JPanel panel) {
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
    
}
