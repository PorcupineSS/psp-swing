/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.view;

import com.porcupine.psp.controller.MainController;
import com.porcupine.psp.model.vo.EmpleadosVO;
import com.porcupine.psp.model.vo.TelefonosVO;
import com.porcupine.psp.util.TipoEmpleado;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.String;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author andres
 */
public class CreateEmployee extends javax.swing.JPanel {

    ArrayList<String> rolesDisponibles = new ArrayList<String>();

    /**
     * Creates new form CreateEmployee
     */
    public CreateEmployee() {
        initComponents();
    }

    public CreateEmployee(ArrayList<String> empleadosDisponibles) {
        rolesDisponibles = empleadosDisponibles;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        jLabelWindowName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNombres = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldSueldo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxTipoEmpleado = new javax.swing.JComboBox(rolesDisponibles.toArray());
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonAgregar = new javax.swing.JButton();
        jTextFieldContraseña = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonGuardar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListTelefono = new javax.swing.JList();
        jButtonRemover = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButtonEncontrarContratos = new javax.swing.JButton();

        jTextField5.setText("jTextField5");

        jLabelWindowName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelWindowName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/porcupine/psp/resources/AddUser.png"))); // NOI18N
        jLabelWindowName.setText("Nuevo Empleado");

        jLabel2.setText("C.C.:");

        jTextFieldCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCCActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombres:");

        jLabel4.setText("Apellidos:");

        jLabel5.setText("Contraseña:");

        jTextFieldSueldo.setEnabled(false);
        jTextFieldSueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSueldoActionPerformed(evt);
            }
        });

        jLabel6.setText("Tipo:");

        jComboBoxTipoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoEmpleadoActionPerformed(evt);
            }
        });

        jLabel7.setText("Sueldo:");

        jLabel8.setText("Teléfonos:");

        jButtonAgregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonAgregar.setForeground(new java.awt.Color(0, 102, 0));
        jButtonAgregar.setText("+");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jButtonGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonGuardar.setForeground(new java.awt.Color(0, 51, 0));
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jListTelefono.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jListTelefono);

        jButtonRemover.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonRemover.setForeground(new java.awt.Color(0, 102, 0));
        jButtonRemover.setText("-");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jLabel9.setText("COP");

        jButtonEncontrarContratos.setText("Encontrar Contratos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(jTextFieldApellidos)
                            .addComponent(jTextFieldCC, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelWindowName)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldContraseña)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(160, 160, 160)
                                        .addComponent(jButtonAgregar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTextFieldSueldo)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonEncontrarContratos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGuardar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(50, 50, 50)
                        .addComponent(jComboBoxTipoEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelWindowName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRemover))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonGuardar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonCancelar)
                        .addComponent(jButtonEncontrarContratos)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public boolean validarCampos() {
        if (jTextFieldNombres.getText().length() < 3 || jTextFieldNombres.getText().length() > 20) {
            return false;
        }
        if (jTextFieldApellidos.getText().length() < 3 || jTextFieldApellidos.getText().length() > 24) {
            return false;
        }
        if (jTextFieldSueldo.getText().length() < 6 || !jTextFieldSueldo.isEnabled()) {
            try {
                int s = Integer.parseInt(jTextFieldSueldo.getText());
            } catch (Exception e) {
                return false;
            }

        }
        if (jTextFieldCC.getText().length() < 2 || jTextFieldCC.getText().length() > 12) {
            try {
                int s = Integer.parseInt(jTextFieldCC.getText());
            } catch (Exception e) {
                return false;
            }

        }
        if (jTextFieldContraseña.getText().length() < 10 || jTextFieldContraseña.getText().length() > 16) {
            return false;
        }
        if (jListTelefono.getModel().getSize() == 0) {
            return false;
        }


        return true;
    }

    public JButton getjButtonAgregar() {
        return jButtonAgregar;
    }

    public void setjButtonAgregar(JButton jButtonAgregar) {
        this.jButtonAgregar = jButtonAgregar;
    }

    public JButton getjButtonCancelar() {
        return jButtonCancelar;
    }

    public void setjButtonCancelar(JButton jButtonCancelar) {
        this.jButtonCancelar = jButtonCancelar;
    }

    public JButton getjButtonEncontrarContratos() {
        return jButtonEncontrarContratos;
    }

    public void setjButtonEncontrarContratos(JButton jButtonEncontrarContratos) {
        this.jButtonEncontrarContratos = jButtonEncontrarContratos;
    }

    public JButton getjButtonRemover() {
        return jButtonRemover;
    }

    public void setjButtonRemover(JButton jButtonRemover) {
        this.jButtonRemover = jButtonRemover;
    }

    public JButton getjButtonGuardar() {
        return jButtonGuardar;
    }

    public void setjButtonGuardar(JButton jButtonGuardar) {
        this.jButtonGuardar = jButtonGuardar;
    }

    public JLabel getjLabelWindowName() {
        return jLabelWindowName;
    }

    public void setjLabelWindowName(JLabel jLabelWindowName) {
        this.jLabelWindowName = jLabelWindowName;
    }

    public JTextField getjTextFieldSueldo() {
        return jTextFieldSueldo;
    }

    public void setjTextFieldSueldo(JTextField jTextFieldSueldo) {
        this.jTextFieldSueldo = jTextFieldSueldo;
    }

    public JComboBox getjComboBoxTipoEmpleado() {
        return jComboBoxTipoEmpleado;
    }

    public void setjComboBoxTipoEmpleado(JComboBox jComboBoxTipoEmpleado) {
        this.jComboBoxTipoEmpleado = jComboBoxTipoEmpleado;
    }

    public JTextField getjTextField5() {
        return jTextField5;
    }

    public void setjTextField5(JTextField jTextField5) {
        this.jTextField5 = jTextField5;
    }

    public JTextField getjTextFieldApellidos() {
        return jTextFieldApellidos;
    }

    public void setjTextFieldApellidos(JTextField jTextFieldApellidos) {
        this.jTextFieldApellidos = jTextFieldApellidos;
    }

    public JTextField getjTextFieldCC() {
        return jTextFieldCC;
    }

    public void setjTextFieldCC(JTextField jTextFieldCC) {
        this.jTextFieldCC = jTextFieldCC;
    }

    public JTextField getjTextFieldContraseña() {
        return jTextFieldContraseña;
    }

    public void setjTextFieldContraseña(JTextField jTextFieldContraseña) {
        this.jTextFieldContraseña = jTextFieldContraseña;
    }

    public JTextField getjTextFieldDireccion() {
        return jTextFieldSueldo;
    }

    public void setjTextFieldDireccion(JTextField jTextFieldDireccion) {
        this.jTextFieldSueldo = jTextFieldDireccion;
    }

    public JTextField getjTextFieldNombres() {
        return jTextFieldNombres;
    }

    public void setjTextFieldNombres(JTextField jTextFieldNombres) {
        this.jTextFieldNombres = jTextFieldNombres;
    }

    public JList getjListTelefono() {
        return jListTelefono;
    }

    public void setjListTelefono(JList jListTelefono) {
        this.jListTelefono = jListTelefono;
    }

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        // TODO add your handling code here:
        String numero = JOptionPane.showInputDialog("Ingrese el número de teléfono");

        try {
            int s = Integer.parseInt(numero);
            DefaultListModel model;

            if (jListTelefono.getModel().getSize() != 0) {
                model = (DefaultListModel) jListTelefono.getModel();
            } else {
                model = new DefaultListModel();
            }
            model.addElement(numero);
            jListTelefono.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Revisa los valores ingresados, algo no esta bien!", "Error", JOptionPane.INFORMATION_MESSAGE, null);
        }


    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed

        if (jButtonGuardar.getText() == "Guardar") {
            if (validarCampos()) {
                MainController.registrarEmpleado();
                MainController.helper.setVisible(false);
                MainController.helper.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Revisa los valores ingresados, algo no esta bien!", "Error", JOptionPane.INFORMATION_MESSAGE, null);
            }
        }

        if (jButtonGuardar.getText() == "Modificar") {
            jButtonAgregar.setEnabled(true);
            jButtonGuardar.setText("Actualizar");
            jButtonRemover.setEnabled(true);
            jLabelWindowName.setText("Actualizar Empleado");
            jListTelefono.setEnabled(true);
            jTextFieldCC.setEnabled(true);
            jTextFieldApellidos.setEnabled(true);
            jTextFieldNombres.setEnabled(true);
            jTextFieldSueldo.setEnabled(true);
        }

        if (jButtonGuardar.getText() == "Actualizar") {
            if (validarCampos()) {
                MainController.actualizarEmpleado();
                MainController.helper.setVisible(false);
                MainController.helper.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Revisa los valores ingresados, algo no esta bien!", "Error", JOptionPane.INFORMATION_MESSAGE, null);
            }
        }


    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        MainController.helper.setVisible(false);
        MainController.helper.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCCActionPerformed

    private void jTextFieldSueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSueldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSueldoActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed

        DefaultListModel model;

        if (jListTelefono.getModel().getSize() != 0 && jListTelefono.getSelectedValue() != null) {
            model = (DefaultListModel) jListTelefono.getModel();
            model.removeElement(jListTelefono.getSelectedValue());
            jListTelefono.setModel(model);
        }

    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jComboBoxTipoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoEmpleadoActionPerformed
        if (jComboBoxTipoEmpleado.getSelectedItem().toString() == TipoEmpleado.TEMPORAL_ESCOLTA
                || jComboBoxTipoEmpleado.getSelectedItem().toString() == TipoEmpleado.TEMPORAL_GUARDA) {
            jTextFieldSueldo.setEnabled(true);
        } else {
            jTextFieldSueldo.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBoxTipoEmpleadoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEncontrarContratos;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JComboBox jComboBoxTipoEmpleado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelWindowName;
    private javax.swing.JList jListTelefono;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldCC;
    private javax.swing.JTextField jTextFieldContraseña;
    private javax.swing.JTextField jTextFieldNombres;
    private javax.swing.JTextField jTextFieldSueldo;
    // End of variables declaration//GEN-END:variables
}
