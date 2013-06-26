/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.controller;

import com.porcupine.psp.model.dao.exceptions.DataBaseException;
import com.porcupine.psp.model.dao.exceptions.InternalErrorException;
import com.porcupine.psp.model.service.ServiceFactory;
import com.porcupine.psp.model.vo.ComunicadoVO;
import com.porcupine.psp.model.vo.ContratoVO;
import com.porcupine.psp.model.vo.EmpleadosVO;
import com.porcupine.psp.model.vo.ImplSeguridadVO;
import com.porcupine.psp.model.vo.TelefonosVO;
import com.porcupine.psp.util.DrawingUtilities;
import com.porcupine.psp.util.ServidoresDisponibles;
import com.porcupine.psp.util.TipoEmpleado;
import com.porcupine.psp.view.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
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
    static AddImplement agregarImplemento;
    static AddContract agregarContrato;
    static WriteNotice agregarWriteNotice;
    static Psp psp;
    static Helper helper;
    public static EmpleadosVO empleadoActivo;
    public static String selectedDB;
    static AddImplement addImplement;
    static AddContract addContract;
    static WriteNotice writeNotice;
    static Secondary secondary;
    //VOS Temporales para hacer operaciones
    public static EmpleadosVO empleadoTemporal;

    public static Map getConnectionPropierties() {
        return connectionPropierties;
    }

    public static void setConnectionPropierties(Map connectionPropierties) {
        MainController.connectionPropierties = connectionPropierties;
    }

    public static CreateEmployee getCrearEmpleado() {
        return crearEmpleado;
    }

    public static void setCrearEmpleado(CreateEmployee crearEmpleado) {
        MainController.crearEmpleado = crearEmpleado;
    }

    public static Helper getHelper() {
        return helper;
    }

    public static void setHelper(Helper helper) {
        MainController.helper = helper;
    }

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
    
    public static void mostrarFormuariosImplementos() {
        helper = new Helper();
        helper.setLocationRelativeTo(null);
        agregarImplemento = new AddImplement();
        helper.setVisible(true);
        DrawingUtilities.drawPanel(helper, helper.getViewport(), agregarImplemento);
    }
    
    public static void mostrarFormularioContratos() {
        helper = new Helper();
        helper.setLocationRelativeTo(null);
        agregarContrato = new AddContract();
        helper.setVisible(true);
        DrawingUtilities.drawPanel(helper, helper.getViewport(), agregarContrato);
    }
    
    public static void mostrarFormularioWriteNotice() {
        helper = new Helper();
        helper.setLocationRelativeTo(null);
        agregarWriteNotice = new WriteNotice();
        helper.setVisible(true);
        DrawingUtilities.drawPanel(helper, helper.getViewport(), agregarWriteNotice);
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
                //TODO set parameters
                case TipoEmpleado.COORDINADOR_CONTRATO:
                    ContractCordination cCordination = new ContractCordination();
                    DrawingUtilities.drawPanel(psp, psp.getViewport(), cCordination);
                    break;
                case TipoEmpleado.COORDINADOR_TECNICO_TECNOLOGICO:
                    TTCordination ttcordination = new TTCordination();
                    DrawingUtilities.drawPanel(psp, psp.getViewport(), ttcordination);
                    break;
                case TipoEmpleado.DIRECTOR_COMERCIAL:
                    AddClient addclient = new AddClient();
                    DrawingUtilities.drawPanel(psp, psp.getViewport(), addclient);
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
                //no es mi codigo mas bonito pero parece funcionar
                case TipoEmpleado.TEMPORAL_ESCOLTA:
                    TemporaryEmployee temployee = new TemporaryEmployee();
                    DrawingUtilities.drawPanel(psp, psp.getViewport(), temployee);
                    break;
                case TipoEmpleado.TEMPORAL_GUARDA:
                    TemporaryEmployee temployee2 = new TemporaryEmployee();
                    DrawingUtilities.drawPanel(psp, psp.getViewport(), temployee2);
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

        EmpleadosVO empleado = new EmpleadosVO();
        empleado.setNombreEmpleado(crearEmpleado.getjTextFieldNombres().getText());
        empleado.setApellidoEmpleado(crearEmpleado.getjTextFieldApellidos().getText());
        empleado.setCedulaEmpleado(Integer.parseInt(crearEmpleado.getjTextFieldCC().getText()));
        empleado.setContraseniaEmpleado(crearEmpleado.getjTextFieldContraseña().getText());
        empleado.setRol(crearEmpleado.getjComboBoxTipoEmpleado().getSelectedItem().toString());

        //No hay problema en bd si es nulo
        if (getEmpleadoActivo() != null) {
            empleado.setCedulaDirector(getEmpleadoActivo().getCedulaEmpleado());
        }
        //Vos Externos

        DefaultListModel model = (DefaultListModel) crearEmpleado.getjListTelefono().getModel();

        ArrayList<String> tels = new ArrayList<String>();
        for (int x = 0; x < model.size(); x++) {
            String tel = (String) model.elementAt(x);
            tels.add(tel);
        }



        //Se agrega cada telefono
        List<TelefonosVO> telefonos = new ArrayList<TelefonosVO>();
        for (String each : tels) {
//            //TODO Obtener los empleados por este telefono y agrega el nuevo
//            ArrayList empTels = new ArrayList<Short>();
//            empTels.add(empleado.getCedulaEmpleado());
//            TelefonosVO telefonos = new TelefonosVO();
//            //Hace falta obtener los otros usuarios en la bd y "concatenar" el que se ingresa
//            telefonos.setUsersList(empTels);
//            telefonos.setNumeroTelefonoEmpleado((each));
//            List<TelefonosVO> newTels = empleado.getTelsEmpList();
//            if (newTels == null) {
//                newTels = new ArrayList<TelefonosVO>();
//            }
//            newTels.add(telefonos);
//            empleado.setTelsEmpList(newTels);

            TelefonosVO temp = new TelefonosVO();
            temp.setNumeroTelefonoEmpleado(each);
            telefonos.add(temp);

        }

        empleado.setTelsEmpList(telefonos);

       try {
            ServiceFactory.getInstance().getEmpleadosService().create(empleado);
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
        Map dbprops = new HashMap();

        //http://java-persistence.blogspot.com/2008/02/testing-eclipselink-jpa-in-javase.html

        dbprops.put("javax.persistence.jdbc.user", username);
        dbprops.put("javax.persistence.jdbc.password", password);

        if (selectedDB == ServidoresDisponibles.SQL) {

            dbprops.put("javax.persistence.jdbc.driver", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
            dbprops.put("javax.persistence.jdbc.url", "jdbc:sqlserver://168.176.36.26:1433;databaseName=dbd_2");
        } else if (selectedDB == ServidoresDisponibles.SYB) {

            dbprops.put("javax.persistence.jdbc.driver", "net.sourceforge.jtds.jdbc.Driver");
            dbprops.put("javax.persistence.jdbc.url", "jdbc:jtds:sybase://168.176.36.25:8101/dbd_2");
        } else {

            dbprops.put("javax.persistence.jdbc.driver", "oracle.jdbc.OracleDriver");
            dbprops.put("javax.persistence.jdbc.url", "jdbc:oracle:thin:@168.176.36.14:1521:UNBDS7");
        }

        dbprops.put("eclipselink.logging.level", "FINEST");
        connectionPropierties = dbprops;
    }

    /**
     * Disponible para: Coordinador tecnico y tecnologico Modelo gestionado por
     * vista TODO metodo para obtener la restriccion desde base de datos Vista
     * principal para este coordinador
     */
    public static void listarInventario() {
    }

    public static void crearImplemento() {   
       ImplSeguridadVO implSeguridadVO = new ImplSeguridadVO();
       implSeguridadVO.setNombreI(addImplement.getjTextFieldNombre().getText());
       implSeguridadVO.setPrecioUnitarioI(new BigDecimal(addImplement.getjTextFieldValorUnitario().getText()));
       implSeguridadVO.setCantidad(new Short(addImplement.getjTextFieldCantidad().getText()));
       implSeguridadVO.setEstadoI(addImplement.getjTextFieldEstado().getText());
       implSeguridadVO.setDescripcionI(addImplement.getjTextAreaDescripcion().getText());
       implSeguridadVO.setIdPro(new Short(addImplement.getjTextFieldIdProveedor().getText()));
       
       try {
           ServiceFactory.getInstance().getImplSeguridadService().create(implSeguridadVO);
       } catch (Exception e) {
           JOptionPane.showMessageDialog(addImplement, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
           return;
       }
       JOptionPane.showMessageDialog(addImplement, "¡Implemento agregado satisfactoriamente!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
       secondary.setVisible(false);
       secondary = new Secondary();
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
        ContratoVO contratoVO = new ContratoVO();
        
        contratoVO.setTipoCont(addContract.getjComboBoxTipoContrato().getSelectedItem().toString());
        contratoVO.setFechaInicioCont(addContract.getjDateChooserFechaInicio().getDate());
        contratoVO.setTipoPersonalCont(addContract.getjComboBoxTipoPersonal().getSelectedItem().toString());
        contratoVO.setCantPersonalCont(new Short (addContract.getjTextFieldCantPerson().getText()));
        contratoVO.setCostoMensual(new BigDecimal(addContract.getjTextFieldCosto().getText()));
        contratoVO.setUbicacionCont(addContract.getjTextFieldUbicacion().getText());
        contratoVO.setHorarioCont(addContract.getjTextFieldHorario().getText());
        contratoVO.setTiempoCont(new Integer (addContract.getjTextFieldTiempo().getText()));
        contratoVO.setCelularCont(addContract.getjTextFieldCelularC().getText());
        contratoVO.setTelefonoCont(addContract.getjTextFieldTelefonoC().getText());
        
        try{
            ServiceFactory.getInstance().getContratoService().create(contratoVO);
        }catch (Exception e) {
           JOptionPane.showMessageDialog(addContract, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
           return;
       }
       JOptionPane.showMessageDialog(addContract, "¡Contrato agregado satisfactoriamente!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
       //No estoy seguro de para que sirven estos de abajo, los dejo comentariados
       //secondary.setVisible(false);
       //secondary = new Secondary();
    }

    public static void borrarContrato() {
    }

    public static void asignarContrato() {
    }

    public static void crearComunicacion() {
        ComunicadoVO comunicadoVO = new ComunicadoVO();
        
        comunicadoVO.setTipoCom(writeNotice.getjComboBoxTipo().getSelectedItem().toString());
        comunicadoVO.setContenidoCom(writeNotice.getjTextAreaComunicado().getText());
        //Revisar que este bien manejado el CheckBox
        comunicadoVO.setUrgente(writeNotice.getjCheckBoxUrgente().isSelected());
        
        try{
            ServiceFactory.getInstance().getComunicadoService().create(comunicadoVO);
        }catch (Exception e) {
           JOptionPane.showMessageDialog(writeNotice, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
           return;
       }
       JOptionPane.showMessageDialog(writeNotice, "¡Comunicado agregado satisfactoriamente!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
       //No estoy seguro de para que sirven estos de abajo, los dejo comentariados
       //secondary.setVisible(false);
       //secondary = new Secondary();
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
