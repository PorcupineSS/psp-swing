/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.view;

/**
 *
 * @author andres
 */
public class TTCordination extends javax.swing.JPanel {

    /**
     * Creates new form TTCordination
     */
    public TTCordination() {
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

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonLogout = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonAddImplement = new javax.swing.JButton();
        jButtonManageImplement = new javax.swing.JButton();
        jButtonAssignImplement = new javax.swing.JButton();
        jButtonAddProvider = new javax.swing.JButton();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/porcupine/psp/resources/LogoPSPMin.png"))); // NOI18N

        jLabel3.setText("¡Bienvenido XXX!");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("COORDINACIÓN");

        jButtonLogout.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonLogout.setForeground(new java.awt.Color(153, 0, 0));
        jButtonLogout.setText("Cerrar Sesión");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("TÉCNICA Y TECNOLÓGICA");

        jButtonAddImplement.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonAddImplement.setForeground(new java.awt.Color(0, 51, 0));
        jButtonAddImplement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/porcupine/psp/resources/Add.png"))); // NOI18N
        jButtonAddImplement.setText("Registrar Implemento");
        jButtonAddImplement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddImplementActionPerformed(evt);
            }
        });

        jButtonManageImplement.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonManageImplement.setForeground(new java.awt.Color(0, 51, 0));
        jButtonManageImplement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/porcupine/psp/resources/Manage.png"))); // NOI18N
        jButtonManageImplement.setText("Administrar Implementos");

        jButtonAssignImplement.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonAssignImplement.setForeground(new java.awt.Color(0, 51, 0));
        jButtonAssignImplement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/porcupine/psp/resources/Assign.png"))); // NOI18N
        jButtonAssignImplement.setText("Asignación de Implementos");
        jButtonAssignImplement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAssignImplementActionPerformed(evt);
            }
        });

        jButtonAddProvider.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonAddProvider.setForeground(new java.awt.Color(0, 51, 0));
        jButtonAddProvider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/porcupine/psp/resources/AddProvider.png"))); // NOI18N
        jButtonAddProvider.setText("Agregar Proveedor");
        jButtonAddProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddProviderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonAddProvider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonAddImplement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonManageImplement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAssignImplement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAddImplement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonManageImplement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAssignImplement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAddProvider)
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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonLogout)))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    private void jButtonAddImplementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddImplementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddImplementActionPerformed

    private void jButtonAssignImplementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAssignImplementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAssignImplementActionPerformed

    private void jButtonAddProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddProviderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddProviderActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddImplement;
    private javax.swing.JButton jButtonAddProvider;
    private javax.swing.JButton jButtonAssignImplement;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonManageImplement;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
