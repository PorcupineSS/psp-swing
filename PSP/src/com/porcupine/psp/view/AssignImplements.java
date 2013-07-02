/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.view;

import com.porcupine.psp.controller.MainController;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;

/**
 *
 * @author Jeisson Andrés Vergara
 */
public class AssignImplements extends javax.swing.JPanel {
    
    public static final String CANTIDAD_ASIG_IMPL_VALIDACION = "¡La cantidad debe ser un número entero mayor o igual a 0!";
    public static final String CANTIDAD_DISP_ASIG_IMPL_VALIDACION = "¡La cantidad a asignar debe ser menor o igual a la cantidad disponible!";
    
    /**
     * Creates new form AssignImplements
     */
    public AssignImplements() {
        initComponents();
    }

    public ButtonGroup getButtonGroupOpcion() {
        return buttonGroupOpcion;
    }

    public void setButtonGroupOpcion(ButtonGroup buttonGroupOpcion) {
        this.buttonGroupOpcion = buttonGroupOpcion;
    }

    public JButton getjButton1() {
        return jButtonDespojar;
    }

    public void setjButton1(JButton jButton1) {
        this.jButtonDespojar = jButton1;
    }

    public JButton getjButtonAsignar() {
        return jButtonAsignar;
    }

    public void setjButtonAsignar(JButton jButtonAsignar) {
        this.jButtonAsignar = jButtonAsignar;
    }

    public JButton getjButtonCancelar() {
        return jButtonCancelar;
    }

    public void setjButtonCancelar(JButton jButtonCancelar) {
        this.jButtonCancelar = jButtonCancelar;
    }

    public JComboBox getjComboBoxEmpleado() {
        return jComboBoxEmpleado;
    }

    public void setjComboBoxEmpleado(JComboBox jComboBoxEmpleado) {
        this.jComboBoxEmpleado = jComboBoxEmpleado;
    }

    public JComboBox getjComboBoxImplemento() {
        return jComboBoxImplemento;
    }

    public void setjComboBoxImplemento(JComboBox jComboBoxImplemento) {
        this.jComboBoxImplemento = jComboBoxImplemento;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JRadioButton getjRadioButtonAsignar() {
        return jRadioButtonAsignar;
    }

    public void setjRadioButtonAsignar(JRadioButton jRadioButtonAsignar) {
        this.jRadioButtonAsignar = jRadioButtonAsignar;
    }

    public JRadioButton getjRadioButtonDespojar() {
        return jRadioButtonDespojar;
    }

    public void setjRadioButtonDespojar(JRadioButton jRadioButtonDespojar) {
        this.jRadioButtonDespojar = jRadioButtonDespojar;
    }

    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    public JSeparator getjSeparator2() {
        return jSeparator2;
    }

    public void setjSeparator2(JSeparator jSeparator2) {
        this.jSeparator2 = jSeparator2;
    }

    public JSeparator getjSeparator3() {
        return jSeparator3;
    }

    public void setjSeparator3(JSeparator jSeparator3) {
        this.jSeparator3 = jSeparator3;
    }

    public JTextField getjTextFieldCantidad() {
        return jTextFieldCantidad;
    }

    public void setjTextFieldCantidad(JTextField jTextFieldCantidad) {
        this.jTextFieldCantidad = jTextFieldCantidad;
    }

    public ComponentUI getUi() {
        return ui;
    }

    public void setUi(ComponentUI ui) {
        this.ui = ui;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }

     public boolean validarCantidadAsignada(String str) {
        Short cantidad;
        try {
            cantidad = new Short(str);
            if (cantidad < 0) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
     
     public boolean validarCantidadDisponible(String str) {
         Short cantidadDisponible = MainController.obtenerCantidadImplementos(jComboBoxImplemento.getSelectedItem().toString());
         Short cantidadAAsignar = new Short(str);
         if (cantidadDisponible >= cantidadAAsignar) {
             return true;
         } else {
             return false;
         } 
     }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupOpcion = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxEmpleado = new javax.swing.JComboBox(MainController.obtenerListaEmpTemp().toArray());
        jComboBoxImplemento = new javax.swing.JComboBox(MainController.obtenerListaImplementos().toArray());
        jButtonAsignar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jRadioButtonAsignar = new javax.swing.JRadioButton();
        jRadioButtonDespojar = new javax.swing.JRadioButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCantidad = new javax.swing.JTextField();
        jButtonDespojar = new javax.swing.JButton();
        jLabelCantidadActual = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/porcupine/psp/resources/Assign.png"))); // NOI18N
        jLabel1.setText("Asignación de Implementos");

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel2.setText("Seleccionar Empleado:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel3.setText("Seleccionar Implemento:");

        jComboBoxEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEmpleadoActionPerformed(evt);
            }
        });

        jComboBoxImplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxImplementoActionPerformed(evt);
            }
        });

        jButtonAsignar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonAsignar.setForeground(new java.awt.Color(0, 102, 0));
        jButtonAsignar.setText("Asignar");
        jButtonAsignar.setToolTipText("");
        jButtonAsignar.setEnabled(false);
        jButtonAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAsignarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        buttonGroupOpcion.add(jRadioButtonAsignar);
        jRadioButtonAsignar.setText("Asignar");
        jRadioButtonAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAsignarActionPerformed(evt);
            }
        });

        buttonGroupOpcion.add(jRadioButtonDespojar);
        jRadioButtonDespojar.setText("Despojar");
        jRadioButtonDespojar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDespojarActionPerformed(evt);
            }
        });

        jLabel4.setText("Cantidad:");

        jButtonDespojar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonDespojar.setForeground(new java.awt.Color(153, 0, 0));
        jButtonDespojar.setText("Despojar");
        jButtonDespojar.setEnabled(false);

        jLabelCantidadActual.setForeground(new java.awt.Color(0, 51, 102));
        jLabelCantidadActual.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator3)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jComboBoxEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(124, 124, 124))
                                    .addComponent(jComboBoxImplemento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jRadioButtonAsignar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonDespojar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelCantidadActual, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDespojar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAsignar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonAsignar)
                    .addComponent(jRadioButtonDespojar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxImplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelCantidadActual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAsignar)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonDespojar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAsignarActionPerformed
        this.jButtonAsignar.setEnabled(true);
        this.jButtonDespojar.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonAsignarActionPerformed

    private void jComboBoxEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEmpleadoActionPerformed

    private void jComboBoxImplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxImplementoActionPerformed
        String cantidadActual = MainController.obtenerCantidadImplementos(jComboBoxImplemento.getSelectedItem().toString()).toString();
        jLabelCantidadActual.setText("'" + cantidadActual + " disponibles'");
    }//GEN-LAST:event_jComboBoxImplementoActionPerformed

    private void jRadioButtonDespojarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDespojarActionPerformed
        this.jButtonDespojar.setEnabled(true);
        this.jButtonAsignar.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonDespojarActionPerformed

    private void jButtonAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAsignarActionPerformed
        if (validarCantidadAsignada(jTextFieldCantidad.getText())) {
            if (validarCantidadDisponible(jTextFieldCantidad.getText())) {
                MainController.asignarImplemento();
            } else {
               JOptionPane.showMessageDialog(this, CANTIDAD_DISP_ASIG_IMPL_VALIDACION, "¡Advertencia!", JOptionPane.INFORMATION_MESSAGE);
            }    
        } else {
            JOptionPane.showMessageDialog(this, CANTIDAD_ASIG_IMPL_VALIDACION, "¡Advertencia!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAsignarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        MainController.helper.setVisible(false);
        MainController.helper.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupOpcion;
    private javax.swing.JButton jButtonAsignar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonDespojar;
    private javax.swing.JComboBox jComboBoxEmpleado;
    private javax.swing.JComboBox jComboBoxImplemento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCantidadActual;
    private javax.swing.JRadioButton jRadioButtonAsignar;
    private javax.swing.JRadioButton jRadioButtonDespojar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextFieldCantidad;
    // End of variables declaration//GEN-END:variables
}
