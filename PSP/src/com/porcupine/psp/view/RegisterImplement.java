/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.view;

import com.porcupine.psp.controller.MainController;
import static com.porcupine.psp.controller.MainController.psp;
import com.porcupine.psp.model.dao.DAOFactory;
import com.porcupine.psp.model.entity.ImplSeguridad;
import com.porcupine.psp.model.service.ServiceFactory;
import com.porcupine.psp.model.vo.ImplSeguridadVO;
import com.porcupine.psp.util.DrawingUtilities;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;

/**
 *
 * @author andres
 */
public class RegisterImplement extends javax.swing.JPanel {

    public static final String NOMBRE_VACIO_IMPL_VALIDACION = "¡El campo Nombre no debe estar vacío!";
    public static final String NOMBRE_INCORRECTO_IMPL_VALIDACION = "¡Ya existe un implemento con ese nombre, por favor seleccione otro!";
    public static final String CANTIDAD_IMPL_VALIDACION = "¡La cantidad debe ser un número entero mayor o igual a 0!";
    public static final String VALOR_UNITARIO_IMPL_VALIDACION = "¡El valor unitario debe ser un número mayor o igual a $0.0!";
    public static final String DESCRIPCION_IMPL_VALIDACION = "¡Debe ingresar una descripción!";

    public RegisterImplement() {
        initComponents();
    }

    public JButton getjButtonCancelar() {
        return jButtonCancelar;
    }

    public void setjButtonCancelar(JButton jButtonCancelar) {
        this.jButtonCancelar = jButtonCancelar;
    }

    public JButton getjButtonGuardar() {
        return jButtonGuardar;
    }

    public void setjButtonGuardar(JButton jButtonGuardar) {
        this.jButtonGuardar = jButtonGuardar;
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

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
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

    public JTextArea getjTextAreaDescripcion() {
        return jTextAreaDescripcion;
    }

    public void setjTextAreaDescripcion(JTextArea jTextAreaDescripcion) {
        this.jTextAreaDescripcion = jTextAreaDescripcion;
    }

    public JTextField getjTextFieldCantidad() {
        return jTextFieldCantidad;
    }

    public void setjTextFieldCantidad(JTextField jTextFieldCantidad) {
        this.jTextFieldCantidad = jTextFieldCantidad;
    }

    public JTextField getjTextFieldNombre() {
        return jTextFieldNombre;
    }

    public void setjTextFieldNombre(JTextField jTextFieldNombre) {
        this.jTextFieldNombre = jTextFieldNombre;
    }

    public JTextField getjTextFieldValorUnitario() {
        return jTextFieldValorUnitario;
    }

    public void setjTextFieldValorUnitario(JTextField jTextFieldValorUnitario) {
        this.jTextFieldValorUnitario = jTextFieldValorUnitario;
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

    public JComboBox getjComboBoxProveedor() {
        return jComboBoxProveedor;
    }

    public void setjComboBoxProveedor(JComboBox jComboBoxProveedor) {
        this.jComboBoxProveedor = jComboBoxProveedor;
    }

    public JComboBox getjComboBoxEstado() {
        return jComboBoxEstado;
    }

    public void setjComboBoxEstado(JComboBox jComboBoxEstado) {
        this.jComboBoxEstado = jComboBoxEstado;
    }

    public boolean validarNombreIncorrecto(String str) {
        List<ImplSeguridadVO> implementos = ServiceFactory.getInstance().getImplSeguridadService().findByName(str);
        if (implementos.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validarNombreVacio(String str) {
        if (str.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validarCantidad(String str) {
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

    public boolean validarDescripcion(String str) {
        if (str.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validarValorUnitario(String str) {
        BigDecimal precio;
        try {
            precio = new BigDecimal(str);
            if (precio.signum() < 0) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
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

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldValorUnitario = new javax.swing.JTextField();
        jTextFieldCantidad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonGuardar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxProveedor = new javax.swing.JComboBox(MainController.obtenerListaProveedores().toArray());
        jComboBoxEstado = new javax.swing.JComboBox();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/porcupine/psp/resources/RegisterImplement.png"))); // NOI18N
        jLabel1.setText("Nuevo Implemento");

        jLabel2.setText("Nombre:");

        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jTextFieldValorUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValorUnitarioActionPerformed(evt);
            }
        });

        jTextFieldCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCantidadActionPerformed(evt);
            }
        });

        jTextAreaDescripcion.setColumns(20);
        jTextAreaDescripcion.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescripcion);

        jLabel3.setText("Valor Unitario:");

        jLabel4.setText("Cantidad:");

        jLabel5.setText("Estado:");

        jLabel6.setText("Descripción:");

        jButtonGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonGuardar.setForeground(new java.awt.Color(0, 102, 0));
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

        jLabel7.setText("Proveedor:");

        jComboBoxProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProveedorActionPerformed(evt);
            }
        });

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "OPTIMO", "MANTENIMIENTO" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldValorUnitario)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                    .addComponent(jTextFieldCantidad)
                                    .addComponent(jTextFieldNombre)
                                    .addComponent(jComboBoxProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
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
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBoxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jTextFieldValorUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValorUnitarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldValorUnitarioActionPerformed

    private void jTextFieldCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCantidadActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        if (validarNombreVacio(getjTextFieldNombre().getText())) {
            if (validarNombreIncorrecto(getjTextFieldNombre().getText())) {
                if (validarValorUnitario(getjTextFieldValorUnitario().getText())) {
                    if (validarCantidad(getjTextFieldCantidad().getText())) {
                        if (validarDescripcion(getjTextAreaDescripcion().getText())) {
                            MainController.crearImplemento();
                        } else {
                            JOptionPane.showMessageDialog(this, DESCRIPCION_IMPL_VALIDACION, "¡Advertencia!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, CANTIDAD_IMPL_VALIDACION, "¡Advertencia!", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, VALOR_UNITARIO_IMPL_VALIDACION, "¡Advertencia!", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, NOMBRE_INCORRECTO_IMPL_VALIDACION, "¡Advertencia!", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, NOMBRE_VACIO_IMPL_VALIDACION, "¡Advertencia!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jComboBoxProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxProveedorActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        MainController.helper.setVisible(false);
        MainController.helper.dispose();                   
    }//GEN-LAST:event_jButtonCancelarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JComboBox jComboBoxEstado;
    private javax.swing.JComboBox jComboBoxProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextAreaDescripcion;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldValorUnitario;
    // End of variables declaration//GEN-END:variables
}
