/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.view;

import com.porcupine.psp.controller.MainController;
import com.porcupine.psp.util.ServidoresDisponibles;
import com.porcupine.psp.util.TipoEmpleado;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Zergio
 */
public class SelectDataBaseConnection extends javax.swing.JPanel {

    /**
     * Creates new form SelectDataBaseConnection
     */
    public SelectDataBaseConnection() {
        initComponents();
        getjComboBox1().setSelectedItem(MainController.selectedDB);
        getjTextFieldUserName().setText(MainController.username);
        getjPasswordField().setText(MainController.password);

    }

    public JComboBox getjComboBox1() {
        return jComboBox1;
    }

    public void setjComboBox1(JComboBox jComboBox1) {
        this.jComboBox1 = jComboBox1;
    }

    public JPasswordField getjPasswordField() {
        return jPasswordField;
    }

    public void setjPasswordField(JPasswordField jPasswordField) {
        this.jPasswordField = jPasswordField;
    }

    public JTextField getjTextFieldUserName() {
        return jTextFieldUserName;
    }

    public void setjTextFieldUserName(JTextField jTextFieldUserName) {
        this.jTextFieldUserName = jTextFieldUserName;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox(ServidoresDisponibles.obtenerListaServidores().toArray());
        jSeparator1 = new javax.swing.JSeparator();
        jButton_OK = new javax.swing.JButton();
        jButton_close = new javax.swing.JButton();
        jButtonNewDirGH = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldUserName = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setText("PSPConnector: Selector de motor de conexión");

        jLabel2.setText("Por favor seleccione la conexión con la que le gustaría trabajar en esta sesión:");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton_OK.setText("Vale");
        jButton_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_OKActionPerformed(evt);
            }
        });

        jButton_close.setText("Cerrar");
        jButton_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_closeActionPerformed(evt);
            }
        });

        jButtonNewDirGH.setText("Crear nuevo Director de Gestión Humana...");
        jButtonNewDirGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewDirGHActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/porcupine/psp/resources/LogoPSPMin.png"))); // NOI18N

        jLabel4.setText("UserName");

        jLabel5.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonNewDirGH)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_OK)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_close))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldUserName)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                                    .addComponent(jPasswordField))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNewDirGH)
                    .addComponent(jButton_close)
                    .addComponent(jButton_OK))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_closeActionPerformed
        MainController.helper1.setVisible(false);
        MainController.helper1.dispose();
    }//GEN-LAST:event_jButton_closeActionPerformed

    private void jButton_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_OKActionPerformed
        try {
            MainController.modificarFicheroSeguridad();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(SelectDataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SelectDataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        MainController.saveConnectionValues();
        try {
            MainController.leerFicherosConfiguracion();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(SelectDataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SelectDataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SelectDataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        MainController.helper1.setVisible(false);
        MainController.helper1.dispose();


    }//GEN-LAST:event_jButton_OKActionPerformed

    private void jButtonNewDirGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewDirGHActionPerformed

        try {
            MainController.modificarFicheroSeguridad();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(SelectDataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SelectDataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        MainController.saveConnectionValues();
        try {
            MainController.leerFicherosConfiguracion();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(SelectDataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SelectDataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SelectDataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> empleado = new ArrayList<String>();
        empleado.add(TipoEmpleado.DIRECTOR_GESTION_HUMANA);
        MainController.mostrarFormularioCrearEmpleado(empleado);
    }//GEN-LAST:event_jButtonNewDirGHActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonNewDirGH;
    private javax.swing.JButton jButton_OK;
    private javax.swing.JButton jButton_close;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldUserName;
    // End of variables declaration//GEN-END:variables
}
