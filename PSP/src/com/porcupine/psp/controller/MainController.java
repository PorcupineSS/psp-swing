/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.controller;

import com.porcupine.psp.controller.exceptions.InternalErrorException;
import com.porcupine.psp.model.service.ServiceFactory;
import com.porcupine.psp.model.vo.EmpleadosVO;
import com.porcupine.psp.util.DrawingUtilities;
import com.porcupine.psp.view.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.porcupine.psp.model.dao.exceptions.DataBaseException;
import com.porcupine.psp.util.ServidoresDisponibles;
import com.porcupine.psp.util.TipoEmpleado;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;

/**
 * El proposito de esta clase es tener un lugar integrado con todos los metodos
 * necesarios para la ejecución satisfactoria de la aplicación, y la logica de
 * carga de datos hacia la vista. La logica de base de datos esta implementada
 * en cada motor y en la capa de DAO's. Se usan objetos de valor para tratar
 * algunos objetos de arriba.
 *
 * @author Zergio
 */
public class MainController {

    //Variables de estado
    static Login login;
    static SelectDataBaseConnection sdb;
    public static Map connectionPropierties;
    static CreateEmployee crearEmpleado;
    static Psp psp;
    static Helper helper;
    public static EmpleadosVO empleadoActivo;
    public static String selectedDB;
    //VOS Temporales para hacer operaciones
    public static EmpleadosVO empleadoTemporal;

    //Constructores y cosas similares
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public static Login getLogin() {
        return login;
    }

    public static void setLogin(Login login) {
        MainController.login = login;
    }

    public static SelectDataBaseConnection getSdb() {
        return sdb;
    }

    public static void setSdb(SelectDataBaseConnection sdb) {
        MainController.sdb = sdb;
    }

    public static Psp getPsp() {
        return psp;
    }

    public static void setPsp(Psp psp) {
        MainController.psp = psp;
    }

    public static EmpleadosVO getEmpleadoActivo() {
        return empleadoActivo;
    }

    public static void setEmpleadoActivo(EmpleadosVO empleadoActivo) {
        MainController.empleadoActivo = empleadoActivo;
    }

    public static String getSelectedDB() {
        return selectedDB;
    }

    public static void setSelectedDB(String selectedDB) {
        MainController.selectedDB = selectedDB;
    }

    public static EmpleadosVO getEmpleadoTemporal() {
        return empleadoTemporal;
    }

    public static void setEmpleadoTemporal(EmpleadosVO empleadoTemporal) {
        MainController.empleadoTemporal = empleadoTemporal;
    }

    //</editor-fold>
    //Clases de muestra
    public static void mostrarLogin() {
        psp = new Psp();
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

    public static void mostrarFormularioCrearEmpleado(ArrayList<String> empleadosDisponibles) {
        helper = new Helper();
        helper.setLocationRelativeTo(null);
        crearEmpleado = new CreateEmployee(empleadosDisponibles);
        helper.setVisible(true);
        DrawingUtilities.drawPanel(helper, helper.getViewport(), crearEmpleado);
    }

    //utilidades
    public static void cerrar() {
        System.exit(0);
    }

    //requerimientos
    public static void login() {
        EmpleadosVO empleado = new EmpleadosVO();
        String cedulaEmpleado = login.getUsuarioTF().getText();
        String password = new String(login.getContrasenaPF().getPassword());

        empleado.setCedulaEmpleado(Integer.parseInt(cedulaEmpleado));
        empleado.setContraseniaEmpleado(password);

        EmpleadosVO empleadoLogin;
        try {
            empleadoLogin = ServiceFactory.getInstance().getEmpleadosService().login(empleado);
        } catch (DataBaseException ex) {
            reportarError(ex, login);
            return;
        }

        if (empleadoLogin != null) {
            switch (empleadoLogin.getRol()) {
                case TipoEmpleado.COORDINADOR_CONTRATO:
                    ContractCordination cCordination = new ContractCordination();
                    DrawingUtilities.drawPanel(psp, psp.getViewport(), cCordination);
                    break;
                case TipoEmpleado.COORDINADOR_TECNICO_TECNOLOGICO:
                    TTCordination ttcordination = new TTCordination();
                    DrawingUtilities.drawPanel(psp, psp.getViewport(), ttcordination);
                    break;
                case TipoEmpleado.DIRECTOR_COMERCIAL:
                    //TODO
                    break;
                case TipoEmpleado.DIRECTOR_GESTION_HUMANA:
                    HumanManagement hmanagement = new HumanManagement();
                    DrawingUtilities.drawPanel(psp, psp.getViewport(), hmanagement);
                    break;
                case TipoEmpleado.DIRECTOR_OPERACIONES:
                    OperationsManagement omanagement = new OperationsManagement();
                    DrawingUtilities.drawPanel(psp, psp.getViewport(), omanagement);
                    break;
                case TipoEmpleado.SUBGERENTE:
                    BusinessManagement bmanagement = new BusinessManagement();
                    DrawingUtilities.drawPanel(psp, psp.getViewport(), bmanagement);
                    break;
                case TipoEmpleado.TEMPORAL:
                    TemporaryEmployee temployee = new TemporaryEmployee();
                    DrawingUtilities.drawPanel(psp, psp.getViewport(), temployee);
                    break;
                default:
                    reportarError(new InternalErrorException("Rol erroneo"), login);
                    break;
            }
            empleadoActivo = empleadoLogin;
        } else {
            JOptionPane.showMessageDialog(login, "¡Usuario o contraseña incorrectos!", "Error", JOptionPane.ERROR_MESSAGE, null);
        }
    }

    public static void reportarError(Exception ex, JPanel parent) {
        int opcion = JOptionPane.showOptionDialog(parent, ex.getMessage() + "\n" + ex.getCause().getMessage(), "Error", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[]{"Reportar Error", "Cancelar"}, "Cancelar");
        switch (opcion) {
            case JOptionPane.OK_OPTION:
                //TODO Reportar Error
                break;
            case JOptionPane.CANCEL_OPTION:
                break;
        }
    }

    /**
     * Disponible para: Director de Gestion Humana Guardias y escoltas,
     * coordinador de contrato, tecnico y operaciones Modelo gestionado por
     * vista TODO metodo para obtener la restriccion desde base de datos
     *
     */
    public static void registrarEmpleado() {

        try {
            ServiceFactory.getInstance().getEmpleadosService().create(empleadoTemporal);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            int opcion = JOptionPane.showOptionDialog(crearEmpleado, ex.getMessage() + "\n" + ex.getCause().getMessage(), "Error", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[]{"Reportar Error", "Cancelar"}, "Cancelar");
            switch (opcion) {
                case JOptionPane.OK_OPTION:
                    //TODO Reportar Error
                    break;
                case JOptionPane.CANCEL_OPTION:
                    break;
            }
            return;
        }

    }

    public static void saveConnectionValues() {
        //TODO edit with values obtained from the view

        MainController.selectedDB = sdb.getjComboBox1().getModel().getSelectedItem().toString();
        String username = sdb.getjTextFieldUserName().getText();
        String password = new String(sdb.getjPasswordField().getPassword());
        Map propsSQL = new HashMap();

        propsSQL.put("javax.persistence.jdbc.user", username);
        propsSQL.put("javax.persistence.jdbc.password", password);
        propsSQL.put("javax.persistence.jdbc.driver", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        propsSQL.put("javax.persistence.jdbc.url", "jdbc:sqlserver://168.176.36.26:1433;databaseName=dbd_2");

        Map propsSYB = new HashMap();

        propsSYB.put("javax.persistence.jdbc.user", username);
        propsSYB.put("javax.persistence.jdbc.password", password);
        propsSYB.put("javax.persistence.jdbc.driver", "net.sourceforge.jtds.jdbc.Driver");
        propsSYB.put("javax.persistence.jdbc.url", "jdbc:jtds:sybase://168.176.36.25:8101/dbd_2");

        Map propsORA = new HashMap();

        propsSYB.put("javax.persistence.jdbc.user", username);
        propsSYB.put("javax.persistence.jdbc.password", password);
        propsSYB.put("javax.persistence.jdbc.driver", "oracle.jdbc.OracleDriver");
        propsSYB.put("javax.persistence.jdbc.url", "jdbc:oracle:thin:@168.176.36.14:1521:UNBDS7");

        Map members = new HashMap();
        members.put(ServidoresDisponibles.ORA, propsORA);
        members.put(ServidoresDisponibles.SYB, propsSYB);
        members.put(ServidoresDisponibles.SQL, propsSQL);

        Map propierties = new HashMap();
        propierties.put("eclipselink.logging.level", "FINEST");
        propierties.put("eclipselink.composite-unit.properties", members);

        connectionPropierties = propierties;
    }

    /**
     * Disponible para: Coordinador tecnico y tecnologico Modelo gestionado por
     * vista TODO metodo para obtener la restriccion desde base de datos Vista
     * principal para este coordinador
     */
    public static void listarInventario() {
    }

    public static void crearImplemento() {
    }

    public static void borrarImplemento() {
    }

    public static void asignarImplemento() {
    }

    /**
     * Disponible para: Wachiturros Vista principal para este coordinador
     */
    public static void consultarCondicionesContrato() {
    }

    public static void listarContratosAsignados() {
    }

    public static void consultarDotacion() {
    }

    //Coordinador de contrato
    public static void crearContrato() {
    }

    public static void borrarContrato() {
    }

    public static void asignarContrato() {
    }

    public static void crearComunicacion() {
    }

    public static void listarComunicacion() {
    }

    public static void listarEmpleados() {
    }

    public static void eliminarEmpleado() {
    }

    public static void consultarEmpleado() {
    }

    public static void consultarBitacora() {
    }
    //Validación de datos
}
