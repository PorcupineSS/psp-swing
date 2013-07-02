/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.view;

import com.porcupine.psp.controller.MainController;
import com.porcupine.psp.util.TipoEmpleado;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author andres
 */
public class HumanManagement extends javax.swing.JPanel {

    /**
     * Creates new form HumanManagement
     */
    public HumanManagement() {
        initComponents();
    }

    public JLabel getjLabelUsername() {
        return jLabelUsername;
    }

    public void setjLabelUsername(JLabel jLabelUsername) {
        this.jLabelUsername = jLabelUsername;
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
        jLabelUsername = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonLogout = new javax.swing.JButton();
        jPanelHumanManagement = new javax.swing.JPanel();
        jButtonFindPerson = new javax.swing.JButton();
        jButtonCreateEmployee = new javax.swing.JButton();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/porcupine/psp/resources/LogoPSPMin.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("GESTIÓN HUMANA");

        jLabelUsername.setText("Username");

        jButtonLogout.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonLogout.setForeground(new java.awt.Color(51, 51, 51));
        jButtonLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/porcupine/psp/resources/Logout.png"))); // NOI18N
        jButtonLogout.setText("Cerrar Sesión");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jButtonFindPerson.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonFindPerson.setForeground(new java.awt.Color(0, 51, 0));
        jButtonFindPerson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/porcupine/psp/resources/Find.png"))); // NOI18N
        jButtonFindPerson.setText("Buscar Persona");
        jButtonFindPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFindPersonActionPerformed(evt);
            }
        });

        jButtonCreateEmployee.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonCreateEmployee.setForeground(new java.awt.Color(0, 51, 0));
        jButtonCreateEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/porcupine/psp/resources/AddUser.png"))); // NOI18N
        jButtonCreateEmployee.setText("Crear Empleado");
        jButtonCreateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateEmployeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelHumanManagementLayout = new javax.swing.GroupLayout(jPanelHumanManagement);
        jPanelHumanManagement.setLayout(jPanelHumanManagementLayout);
        jPanelHumanManagementLayout.setHorizontalGroup(
            jPanelHumanManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHumanManagementLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHumanManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCreateEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFindPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHumanManagementLayout.setVerticalGroup(
            jPanelHumanManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHumanManagementLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButtonCreateEmployee)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonFindPerson)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLogout))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelHumanManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelUsername)
                                    .addComponent(jLabel2))
                                .addGap(0, 36, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelUsername)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLogout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelHumanManagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    private void jButtonFindPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFindPersonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFindPersonActionPerformed

    private void jButtonCreateEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateEmployeeActionPerformed
        // TODO add your handling code here:
        ArrayList<String> empleado = new ArrayList<String>();
        
        empleado.add(TipoEmpleado.DIRECTOR_GESTION_HUMANA);
        empleado.add(TipoEmpleado.DIRECTOR_COMERCIAL);
        empleado.add(TipoEmpleado.DIRECTOR_OPERACIONES);
        empleado.add(TipoEmpleado.COORDINADOR_CONTRATO);
        empleado.add(TipoEmpleado.COORDINADOR_TECNICO_TECNOLOGICO);
        empleado.add(TipoEmpleado.SUBGERENTE);
        empleado.add(TipoEmpleado.TEMPORAL_ESCOLTA);
        empleado.add(TipoEmpleado.TEMPORAL_GUARDA);

        MainController.mostrarFormularioCrearEmpleado(empleado);
    }//GEN-LAST:event_jButtonCreateEmployeeActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreateEmployee;
    private javax.swing.JButton jButtonFindPerson;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPanel jPanelHumanManagement;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
