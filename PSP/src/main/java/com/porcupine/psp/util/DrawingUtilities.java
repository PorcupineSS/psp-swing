/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.util;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JViewport;

/**
 *
 * @author SC
 */
public class DrawingUtilities {

    public static void drawPanel(JFrame objetivo, JViewport contenedor, JPanel panel) {
        objetivo.setSize(fixedFrameSize(panel));
        changePanel(contenedor, panel);
        objetivo.setLocationRelativeTo(objetivo.getParent());
    }

    private static void changePanel(JViewport contenedor, JPanel panel) {
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

    private static Dimension fixedFrameSize(JPanel panel) {
        int fix = 50;
        return new Dimension(panel.getPreferredSize().width + fix, panel.getPreferredSize().height + fix);
    }
}
