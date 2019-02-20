/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icusystem;

import com.placeholder.PlaceHolder;
import java.awt.Color;
import java.io.File;
import java.sql.*;
import java.text.DecimalFormat;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import jxl.*;
import jxl.write.*;
public class mainMenu extends javax.swing.JFrame {
    
Connection conn = null;
PreparedStatement pst = null;
ResultSet rs= null;
PlaceHolder p1,p2,p3,p4,p5,p6;
//if 0=insert  1=update
int checkUpdateOrInsert = 0;

int checkForBound=0;
DefaultListModel model = new DefaultListModel();
DefaultListModel model1 = new DefaultListModel();
DefaultListModel model2 = new DefaultListModel();
DefaultListModel model3 = new DefaultListModel();
DefaultListModel model4 = new DefaultListModel();
DefaultListModel model5 = new DefaultListModel();
DefaultTableModel model6 = new DefaultTableModel();
DefaultTableModel model7 = new DefaultTableModel();

DefaultListModel modelTrach1 = new DefaultListModel();
DefaultListModel modelTrach2 = new DefaultListModel();

DefaultListModel modelBperi1 = new DefaultListModel();
DefaultListModel modelBperi2 = new DefaultListModel();

DefaultListModel modelBcvp1 = new DefaultListModel();
DefaultListModel modelBcvp2 = new DefaultListModel();

DefaultListModel modelUrine1 = new DefaultListModel();
DefaultListModel modelUrine2 = new DefaultListModel();

DefaultListModel modelCsf1 = new DefaultListModel();
DefaultListModel modelCsf2 = new DefaultListModel();

DefaultListModel modelPeri1 = new DefaultListModel();
DefaultListModel modelPeri2 = new DefaultListModel();

DefaultListModel modelWound1 = new DefaultListModel();
DefaultListModel modelWound2 = new DefaultListModel();

// model6 search 
// model7 datewise search

String data1="";

    public mainMenu() {
        initComponents();
        
        try{
            modelTrach1.removeAllElements();
            conn = ICUsystem.getconnection();
            String sql="select org_type_id from org_type_table ";
            PreparedStatement pstcom = conn.prepareStatement(sql);
            ResultSet rs = pstcom.executeQuery(sql);
            while(rs.next()){ 
            modelTrach1.addElement(rs.getString("org_type_id"));
            }
        }catch(Exception e){}
        
        try{
            modelBperi1.removeAllElements();
            conn = ICUsystem.getconnection();
            String sql="select org_type_id from org_type_table ";
            PreparedStatement pstcom = conn.prepareStatement(sql);
            ResultSet rs = pstcom.executeQuery(sql);
            while(rs.next()){
            
            modelBperi1.addElement(rs.getString("org_type_id"));
            }
        }catch(Exception e){}
        
        try{
            modelBcvp1.removeAllElements();
            conn = ICUsystem.getconnection();
            String sql="select org_type_id from org_type_table ";
            PreparedStatement pstcom = conn.prepareStatement(sql);
            ResultSet rs = pstcom.executeQuery(sql);
            while(rs.next()){
            
            modelBcvp1.addElement(rs.getString("org_type_id"));
            }
        }catch(Exception e){}
        
        try{
            modelUrine1.removeAllElements();
            conn = ICUsystem.getconnection();
            String sql="select org_type_id from org_type_table ";
            PreparedStatement pstcom = conn.prepareStatement(sql);
            ResultSet rs = pstcom.executeQuery(sql);
            while(rs.next()){
            
            modelUrine1.addElement(rs.getString("org_type_id"));
            }
        }catch(Exception e){}
        
        try{
            modelCsf1.removeAllElements();
            conn = ICUsystem.getconnection();
            String sql="select org_type_id from org_type_table ";
            PreparedStatement pstcom = conn.prepareStatement(sql);
            ResultSet rs = pstcom.executeQuery(sql);
            while(rs.next()){
            
            modelCsf1.addElement(rs.getString("org_type_id"));
            }
        }catch(Exception e){}
        
        try{
            modelPeri1.removeAllElements();
            conn = ICUsystem.getconnection();
            String sql="select org_type_id from org_type_table ";
            PreparedStatement pstcom = conn.prepareStatement(sql);
            ResultSet rs = pstcom.executeQuery(sql);
            while(rs.next()){
            
            modelPeri1.addElement(rs.getString("org_type_id"));
            }
        }catch(Exception e){}
        
        try{
            modelWound1.removeAllElements();
            conn = ICUsystem.getconnection();
            String sql="select org_type_id from org_type_table ";
            PreparedStatement pstcom = conn.prepareStatement(sql);
            ResultSet rs = pstcom.executeQuery(sql);
            while(rs.next()){
            
            modelWound1.addElement(rs.getString("org_type_id"));
            }
        }catch(Exception e){}
        
        
        
        
      
        try{
            model5.removeAllElements();
            conn = ICUsystem.getconnection();
            String sql="select antibiotic_type_id from antibiotic_type_table ";
            PreparedStatement pstcom = conn.prepareStatement(sql);
            ResultSet rs = pstcom.executeQuery(sql);
            while(rs.next()){
            
            model5.addElement(rs.getString("antibiotic_type_id"));
            }
            
        }catch(Exception e){}
        try{
            conn = ICUsystem.getconnection();
            String sql="select comorbids_type from comorbids_table ";
            PreparedStatement pstcom = conn.prepareStatement(sql);
            ResultSet rs = pstcom.executeQuery(sql);
            while(rs.next()){
            model.addElement(rs.getString("comorbids_type"));
            }
            jlistComorbids.setModel(model);
        }catch(Exception e){}
        try{
            conn = ICUsystem.getconnection();
            String sql="select admission_type from admission_type_table ";
            PreparedStatement pstcom = conn.prepareStatement(sql);
            ResultSet rs = pstcom.executeQuery(sql);
            while(rs.next()){
            model1.addElement(rs.getString("admission_type"));
            }
            jlistAdmittedtype.setModel(model1);
        }catch(Exception e){}
        //initial screen
        mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();
        //Add panels
        mainpanel.add(addpatient);
        mainpanel.repaint();
        mainpanel.revalidate();
        //placeholders for textfields
        p1 = new PlaceHolder(timeAdmission,"time in hr(s)");
        p2 = new PlaceHolder(hospitalNo,"e.g : 2018/123456");
        p3 = new PlaceHolder(weight,"weight in Kg(s)");
        p4 = new PlaceHolder(height,"height in Cm(s)");
        p5 = new PlaceHolder(diagnosisPrimary,"Primary diagnosis");
        p6 = new PlaceHolder(diagnosisSecondary,"Secondary diagnosis"); 
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel3 = new javax.swing.JPanel();
        formula = new javax.swing.JComboBox();
        sidebar = new javax.swing.JPanel();
        btn_1 = new javax.swing.JPanel();
        ind_1 = new javax.swing.JPanel();
        addPatient = new javax.swing.JLabel();
        btn_2 = new javax.swing.JPanel();
        ind_2 = new javax.swing.JPanel();
        addPatient1 = new javax.swing.JLabel();
        btn_3 = new javax.swing.JPanel();
        ind_3 = new javax.swing.JPanel();
        addPatient2 = new javax.swing.JLabel();
        btn_5 = new javax.swing.JPanel();
        ind_5 = new javax.swing.JPanel();
        addPatient3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        mainpanel = new javax.swing.JPanel();
        printreport = new javax.swing.JPanel();
        exit2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        rep = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel85 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        generateExcel = new javax.swing.JButton();
        jLabel99 = new javax.swing.JLabel();
        generateExcel1 = new javax.swing.JButton();
        calculator = new javax.swing.JPanel();
        exit3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        addpatient = new javax.swing.JPanel();
        exit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        hospitalNo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        timeAdmission = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        code = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        sex = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        weight = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        height = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        bmi = new javax.swing.JTextField();
        admittedFrom = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlistAdmittedtype = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlistComorbids = new javax.swing.JList();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        diagnosisPrimary = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        diagnosisSecondary = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        surgery = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        redoSurgery = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        icuOutcome = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        los = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lifeTherapy = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        reasonWithdrawn = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        reasonReadmission = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        hospitalOutcome = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        apache = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        saps = new javax.swing.JTextField();
        qSofa = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        nutRiskScore = new javax.swing.JTextField();
        airwayType = new javax.swing.JComboBox();
        jLabel35 = new javax.swing.JLabel();
        intubationAt = new javax.swing.JComboBox();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        extubationTime = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        selfExtubation = new javax.swing.JComboBox();
        jLabel40 = new javax.swing.JLabel();
        ventilationDays = new javax.swing.JTextField();
        vap = new javax.swing.JComboBox();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        cvpDays = new javax.swing.JTextField();
        clabsi = new javax.swing.JComboBox();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        complication = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        reasonOfDeath = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        brainScan = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        repeatBrainScan = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        e = new javax.swing.JTextField();
        m = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        b = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        r = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        nextpage = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        reAdmission = new javax.swing.JComboBox();
        vent = new javax.swing.JComboBox();
        jLabel65 = new javax.swing.JLabel();
        doaHospital = new org.jdesktop.swingx.JXDatePicker();
        doaICU = new org.jdesktop.swingx.JXDatePicker();
        dateSurgery = new org.jdesktop.swingx.JXDatePicker();
        dateRedo = new org.jdesktop.swingx.JXDatePicker();
        dateDischarge = new org.jdesktop.swingx.JXDatePicker();
        dateReadmission = new org.jdesktop.swingx.JXDatePicker();
        hospitalDate = new org.jdesktop.swingx.JXDatePicker();
        reIntubation = new org.jdesktop.swingx.JXDatePicker();
        dateExtubation = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane13 = new javax.swing.JScrollPane();
        jListSelectAdmission = new javax.swing.JList();
        jScrollPane14 = new javax.swing.JScrollPane();
        jListSelectComorbid = new javax.swing.JList();
        jLabel93 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        addpatient1 = new javax.swing.JPanel();
        exit4 = new javax.swing.JLabel();
        Insert = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabeltracheal2 = new javax.swing.JLabel();
        cvpMin = new javax.swing.JTextField();
        cvpMax = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        dopplr = new javax.swing.JComboBox();
        jLabel74 = new javax.swing.JLabel();
        pocus = new javax.swing.JComboBox();
        aLine = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabelrr4 = new javax.swing.JLabel();
        route = new javax.swing.JComboBox();
        jLabelsbp2 = new javax.swing.JLabel();
        formula1 = new javax.swing.JComboBox();
        Calorie = new javax.swing.JLabel();
        Calorie1 = new javax.swing.JLabel();
        calorie = new javax.swing.JTextField();
        protein = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        day = new javax.swing.JLabel();
        days = new javax.swing.JTextField();
        jLabelrr3 = new javax.swing.JLabel();
        jLabelsbp3 = new javax.swing.JLabel();
        jLabeldbp3 = new javax.swing.JLabel();
        temp = new javax.swing.JTextField();
        jLabelmap4 = new javax.swing.JLabel();
        jLabelmap5 = new javax.swing.JLabel();
        jLabelgcs2 = new javax.swing.JLabel();
        rr = new javax.swing.JTextField();
        jLabelrass2 = new javax.swing.JLabel();
        painscore = new javax.swing.JTextField();
        jLabeldelirium2 = new javax.swing.JLabel();
        delirium = new javax.swing.JComboBox();
        jLabelpainscore2 = new javax.swing.JLabel();
        ph = new javax.swing.JTextField();
        jLabelph2 = new javax.swing.JLabel();
        paco2 = new javax.swing.JTextField();
        jLabelpaco4 = new javax.swing.JLabel();
        pao = new javax.swing.JTextField();
        jLabelpao2 = new javax.swing.JLabel();
        flo2 = new javax.swing.JTextField();
        jLabelflo4 = new javax.swing.JLabel();
        hco3 = new javax.swing.JTextField();
        jLabelhco5 = new javax.swing.JLabel();
        na = new javax.swing.JTextField();
        cl = new javax.swing.JTextField();
        wbc = new javax.swing.JTextField();
        jLabelflo5 = new javax.swing.JLabel();
        jLabeldbp4 = new javax.swing.JLabel();
        jLabelpaco5 = new javax.swing.JLabel();
        jLabelpao3 = new javax.swing.JLabel();
        hb = new javax.swing.JTextField();
        plateletes = new javax.swing.JTextField();
        jLabelrr5 = new javax.swing.JLabel();
        jLabelmap6 = new javax.swing.JLabel();
        ptinr = new javax.swing.JTextField();
        po4 = new javax.swing.JTextField();
        urea = new javax.swing.JTextField();
        mg = new javax.swing.JTextField();
        jLabelhco6 = new javax.swing.JLabel();
        jLabelgcs3 = new javax.swing.JLabel();
        creatinine = new javax.swing.JTextField();
        jLabelph3 = new javax.swing.JLabel();
        jLabelmap7 = new javax.swing.JLabel();
        jLabelrass3 = new javax.swing.JLabel();
        baseexcess = new javax.swing.JTextField();
        jLabeldelirium3 = new javax.swing.JLabel();
        jLabelsbp4 = new javax.swing.JLabel();
        k = new javax.swing.JTextField();
        ddimer = new javax.swing.JTextField();
        jLabelpainscore3 = new javax.swing.JLabel();
        ldh = new javax.swing.JTextField();
        jLabelmap14 = new javax.swing.JLabel();
        alkphos = new javax.swing.JTextField();
        jLabelrr9 = new javax.swing.JLabel();
        albumen = new javax.swing.JTextField();
        jLabelph7 = new javax.swing.JLabel();
        ast = new javax.swing.JTextField();
        ggt = new javax.swing.JTextField();
        bnp = new javax.swing.JTextField();
        alt = new javax.swing.JTextField();
        jLabelpao7 = new javax.swing.JLabel();
        jLabelpainscore7 = new javax.swing.JLabel();
        jLabelflo9 = new javax.swing.JLabel();
        jLabeldelirium7 = new javax.swing.JLabel();
        jLabelpaco9 = new javax.swing.JLabel();
        lipase = new javax.swing.JTextField();
        amylase = new javax.swing.JTextField();
        cpk = new javax.swing.JTextField();
        jLabelhco10 = new javax.swing.JLabel();
        jLabelrass7 = new javax.swing.JLabel();
        jLabelsbp8 = new javax.swing.JLabel();
        jLabeldbp11 = new javax.swing.JLabel();
        jLabelmap15 = new javax.swing.JLabel();
        bilrubin = new javax.swing.JTextField();
        trop1 = new javax.swing.JTextField();
        jLabelgcs7 = new javax.swing.JLabel();
        lactate = new javax.swing.JTextField();
        jLabelrass8 = new javax.swing.JLabel();
        dbp = new javax.swing.JTextField();
        jLabelpaco10 = new javax.swing.JLabel();
        jLabeldelirium8 = new javax.swing.JLabel();
        jLabelsbp9 = new javax.swing.JLabel();
        jLabelpao8 = new javax.swing.JLabel();
        jLabelmap16 = new javax.swing.JLabel();
        jLabelgcs8 = new javax.swing.JLabel();
        jLabelmap17 = new javax.swing.JLabel();
        jLabelhco11 = new javax.swing.JLabel();
        jLabelrr10 = new javax.swing.JLabel();
        bsrmin = new javax.swing.JTextField();
        jLabelph8 = new javax.swing.JLabel();
        jLabelflo10 = new javax.swing.JLabel();
        jLabeldbp12 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        bsrmax = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        sbp = new javax.swing.JTextField();
        hr = new javax.swing.JTextField();
        map = new javax.swing.JTextField();
        hct = new javax.swing.JTextField();
        ca = new javax.swing.JTextField();
        caion = new javax.swing.JTextField();
        pct = new javax.swing.JTextField();
        crp = new javax.swing.JTextField();
        jLabelmap8 = new javax.swing.JLabel();
        gcs = new javax.swing.JTextField();
        rass = new javax.swing.JTextField();
        jLabelpao1 = new javax.swing.JLabel();
        fibrinog = new javax.swing.JTextField();
        dialysis = new javax.swing.JComboBox();
        vasopressors = new javax.swing.JComboBox();
        steriodsld = new javax.swing.JComboBox();
        jLabel71 = new javax.swing.JLabel();
        spotUSodium = new javax.swing.JTextField();
        dvtpropylaxis = new javax.swing.JComboBox();
        norepinephrine = new javax.swing.JTextField();
        dopamine = new javax.swing.JTextField();
        epinephrine = new javax.swing.JTextField();
        dobutamine = new javax.swing.JTextField();
        phenylephrine = new javax.swing.JTextField();
        jLabelflo11 = new javax.swing.JLabel();
        Sofa = new javax.swing.JTextField();
        pbyf = new javax.swing.JTextField();
        jLabelflo7 = new javax.swing.JLabel();
        PAO2 = new javax.swing.JTextField();
        jLabelflo8 = new javax.swing.JLabel();
        jLabelflo12 = new javax.swing.JLabel();
        gradient = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        day1 = new javax.swing.JLabel();
        jLabelrr6 = new javax.swing.JLabel();
        jLabelsbp5 = new javax.swing.JLabel();
        jLabeldbp5 = new javax.swing.JLabel();
        ppeak = new javax.swing.JTextField();
        jLabelmap9 = new javax.swing.JLabel();
        jLabelmap10 = new javax.swing.JLabel();
        jLabelgcs4 = new javax.swing.JLabel();
        jLabeldelirium4 = new javax.swing.JLabel();
        pplat = new javax.swing.JTextField();
        jLabelrass4 = new javax.swing.JLabel();
        ventilate = new javax.swing.JComboBox();
        jLabelpainscore4 = new javax.swing.JLabel();
        jLabelph4 = new javax.swing.JLabel();
        jLabelpaco6 = new javax.swing.JLabel();
        urineOutput = new javax.swing.JTextField();
        jLabelpao4 = new javax.swing.JLabel();
        otherLosses = new javax.swing.JTextField();
        jLabelflo6 = new javax.swing.JLabel();
        outputTotal = new javax.swing.JTextField();
        jLabelhco7 = new javax.swing.JLabel();
        jLabeldbp6 = new javax.swing.JLabel();
        bloodPRCBS = new javax.swing.JTextField();
        ffps = new javax.swing.JTextField();
        jLabelrr7 = new javax.swing.JLabel();
        jLabelmap11 = new javax.swing.JLabel();
        balance = new javax.swing.JTextField();
        jLabelgcs5 = new javax.swing.JLabel();
        cumBalance = new javax.swing.JTextField();
        jLabelph5 = new javax.swing.JLabel();
        jLabelmap12 = new javax.swing.JLabel();
        jLabelrass5 = new javax.swing.JLabel();
        intakeTotal = new javax.swing.JTextField();
        jLabeldelirium5 = new javax.swing.JLabel();
        jLabelsbp6 = new javax.swing.JLabel();
        jLabelpainscore5 = new javax.swing.JLabel();
        ps = new javax.swing.JTextField();
        vt = new javax.swing.JTextField();
        peep = new javax.swing.JTextField();
        plateletunit = new javax.swing.JTextField();
        jLabelmap13 = new javax.swing.JLabel();
        cstat = new javax.swing.JTextField();
        ETTcuffpress = new javax.swing.JTextField();
        weaning = new javax.swing.JComboBox();
        complicat = new javax.swing.JComboBox();
        fluidBalance = new javax.swing.JComboBox();
        ivFluids = new javax.swing.JComboBox();
        crystalloid = new javax.swing.JComboBox();
        colloid = new javax.swing.JComboBox();
        mode = new javax.swing.JComboBox();
        extubniv = new javax.swing.JComboBox();
        tpiece = new javax.swing.JComboBox();
        jLabelpainscore6 = new javax.swing.JLabel();
        cryoppt = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabeltracheal1 = new javax.swing.JLabel();
        tracheal = new javax.swing.JComboBox();
        jLabelrr2 = new javax.swing.JLabel();
        jLabeltracheal3 = new javax.swing.JLabel();
        bloodPeriph = new javax.swing.JComboBox();
        jLabeltracheal4 = new javax.swing.JLabel();
        jLabeltracheal5 = new javax.swing.JLabel();
        jLabeltracheal6 = new javax.swing.JLabel();
        jLabeltracheal7 = new javax.swing.JLabel();
        jLabeltracheal8 = new javax.swing.JLabel();
        jLabeltracheal9 = new javax.swing.JLabel();
        urine = new javax.swing.JComboBox();
        csf = new javax.swing.JComboBox();
        peritoneal = new javax.swing.JComboBox();
        wound = new javax.swing.JComboBox();
        bloodCvp = new javax.swing.JComboBox();
        others = new javax.swing.JComboBox();
        jLabel73 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jlistAntibiotic = new javax.swing.JList();
        jScrollPane15 = new javax.swing.JScrollPane();
        jListSelectAntibiotic = new javax.swing.JList();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jListTrach = new javax.swing.JList();
        TrachFrwd = new javax.swing.JLabel();
        TrachBck = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jListSelectTrach = new javax.swing.JList();
        jScrollPane18 = new javax.swing.JScrollPane();
        jListBperi = new javax.swing.JList();
        BperiFwrd = new javax.swing.JLabel();
        TrachBck1 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jListSelectBperi = new javax.swing.JList();
        jScrollPane20 = new javax.swing.JScrollPane();
        jListBcvp = new javax.swing.JList();
        TrachFrwd2 = new javax.swing.JLabel();
        TrachBck2 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        jListUrine = new javax.swing.JList();
        jScrollPane30 = new javax.swing.JScrollPane();
        jListCsf = new javax.swing.JList();
        jScrollPane32 = new javax.swing.JScrollPane();
        jListSelectBcvp = new javax.swing.JList();
        jScrollPane33 = new javax.swing.JScrollPane();
        jListSelectUrine = new javax.swing.JList();
        jScrollPane34 = new javax.swing.JScrollPane();
        jListSelectCsf = new javax.swing.JList();
        jScrollPane35 = new javax.swing.JScrollPane();
        jListSelectPeri = new javax.swing.JList();
        jScrollPane39 = new javax.swing.JScrollPane();
        jListWound = new javax.swing.JList();
        jScrollPane40 = new javax.swing.JScrollPane();
        jListPeri = new javax.swing.JList();
        jTextField1 = new javax.swing.JTextField();
        TrachFrwd4 = new javax.swing.JLabel();
        TrachBck7 = new javax.swing.JLabel();
        TrachFrwd7 = new javax.swing.JLabel();
        TrachBck9 = new javax.swing.JLabel();
        TrachFrwd8 = new javax.swing.JLabel();
        TrachBck10 = new javax.swing.JLabel();
        TrachFrwd9 = new javax.swing.JLabel();
        TrachBck11 = new javax.swing.JLabel();
        jScrollPane37 = new javax.swing.JScrollPane();
        jListSelectWound = new javax.swing.JList();
        jLabelrr8 = new javax.swing.JLabel();
        addNew = new javax.swing.JButton();
        update = new javax.swing.JButton();
        showData = new javax.swing.JPanel();
        exit5 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        patient_table = new javax.swing.JTable();
        braindeath = new javax.swing.JLabel();
        viewreport = new javax.swing.JButton();
        filter = new javax.swing.JButton();
        search = new javax.swing.JPanel();
        exit1 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        deliriumSearch = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        clabsiSearch = new javax.swing.JButton();
        brainSearch = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        selfExtubationSearch = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        reItubationSearch = new javax.swing.JButton();
        jLabel68 = new javax.swing.JLabel();
        DiagnosisSearch = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        reAdmissionSearch = new javax.swing.JButton();
        reAdmissionSearch1 = new javax.swing.JButton();
        jLabel75 = new javax.swing.JLabel();
        ETTSearch = new javax.swing.JButton();
        jLabel76 = new javax.swing.JLabel();
        pctSearch = new javax.swing.JButton();
        jLabel77 = new javax.swing.JLabel();
        surgerySearch = new javax.swing.JButton();
        jLabel78 = new javax.swing.JLabel();
        airwaySearch = new javax.swing.JButton();
        jLabel79 = new javax.swing.JLabel();
        airwaySearch1 = new javax.swing.JButton();
        jLabel80 = new javax.swing.JLabel();
        ETTSearch1 = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        cardiacSearch = new javax.swing.JButton();
        tlcSearch = new javax.swing.JButton();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        vapSearch = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        update_patient = new javax.swing.JTable();
        jLabel92 = new javax.swing.JLabel();
        HospNoSearch = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        formula.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ensure", "Glucern" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setUndecorated(true);
        setResizable(false);

        sidebar.setBackground(new java.awt.Color(54, 33, 89));
        sidebar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sidebar.setPreferredSize(new java.awt.Dimension(142, 520));

        btn_1.setBackground(new java.awt.Color(41, 57, 80));
        btn_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_1MouseClicked(evt);
            }
        });

        ind_1.setPreferredSize(new java.awt.Dimension(5, 48));

        javax.swing.GroupLayout ind_1Layout = new javax.swing.GroupLayout(ind_1);
        ind_1.setLayout(ind_1Layout);
        ind_1Layout.setHorizontalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        ind_1Layout.setVerticalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        addPatient.setBackground(new java.awt.Color(255, 255, 255));
        addPatient.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addPatient.setForeground(new java.awt.Color(255, 255, 255));
        addPatient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Add_User_Male_30px.png"))); // NOI18N
        addPatient.setText("Add Patient");
        addPatient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addPatientKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout btn_1Layout = new javax.swing.GroupLayout(btn_1);
        btn_1.setLayout(btn_1Layout);
        btn_1Layout.setHorizontalGroup(
            btn_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_1Layout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addPatient)
                .addContainerGap())
        );
        btn_1Layout.setVerticalGroup(
            btn_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addPatient)
                .addContainerGap())
        );

        btn_2.setBackground(new java.awt.Color(23, 35, 51));
        btn_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_2MouseClicked(evt);
            }
        });

        ind_2.setOpaque(false);
        ind_2.setPreferredSize(new java.awt.Dimension(5, 48));

        javax.swing.GroupLayout ind_2Layout = new javax.swing.GroupLayout(ind_2);
        ind_2.setLayout(ind_2Layout);
        ind_2Layout.setHorizontalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        ind_2Layout.setVerticalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        addPatient1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addPatient1.setForeground(new java.awt.Color(255, 255, 255));
        addPatient1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Search_30px.png"))); // NOI18N
        addPatient1.setText("Search");

        javax.swing.GroupLayout btn_2Layout = new javax.swing.GroupLayout(btn_2);
        btn_2.setLayout(btn_2Layout);
        btn_2Layout.setHorizontalGroup(
            btn_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_2Layout.createSequentialGroup()
                .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addPatient1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_2Layout.setVerticalGroup(
            btn_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addPatient1)
                .addContainerGap())
        );

        btn_3.setBackground(new java.awt.Color(23, 35, 51));
        btn_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_3MouseClicked(evt);
            }
        });

        ind_3.setOpaque(false);
        ind_3.setPreferredSize(new java.awt.Dimension(5, 48));

        javax.swing.GroupLayout ind_3Layout = new javax.swing.GroupLayout(ind_3);
        ind_3.setLayout(ind_3Layout);
        ind_3Layout.setHorizontalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        ind_3Layout.setVerticalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        addPatient2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addPatient2.setForeground(new java.awt.Color(255, 255, 255));
        addPatient2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Print_30px.png"))); // NOI18N
        addPatient2.setText("Print Report");

        javax.swing.GroupLayout btn_3Layout = new javax.swing.GroupLayout(btn_3);
        btn_3.setLayout(btn_3Layout);
        btn_3Layout.setHorizontalGroup(
            btn_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_3Layout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addPatient2)
                .addContainerGap())
        );
        btn_3Layout.setVerticalGroup(
            btn_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addPatient2)
                .addContainerGap())
        );

        btn_5.setBackground(new java.awt.Color(23, 35, 51));
        btn_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_5MouseClicked(evt);
            }
        });

        ind_5.setOpaque(false);
        ind_5.setPreferredSize(new java.awt.Dimension(5, 48));

        javax.swing.GroupLayout ind_5Layout = new javax.swing.GroupLayout(ind_5);
        ind_5.setLayout(ind_5Layout);
        ind_5Layout.setHorizontalGroup(
            ind_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        ind_5Layout.setVerticalGroup(
            ind_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        addPatient3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addPatient3.setForeground(new java.awt.Color(255, 255, 255));
        addPatient3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Calculator_30px.png"))); // NOI18N
        addPatient3.setText("Contact Us");

        javax.swing.GroupLayout btn_5Layout = new javax.swing.GroupLayout(btn_5);
        btn_5.setLayout(btn_5Layout);
        btn_5Layout.setHorizontalGroup(
            btn_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_5Layout.createSequentialGroup()
                .addComponent(ind_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addPatient3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_5Layout.setVerticalGroup(
            btn_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ind_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addPatient3)
                .addContainerGap())
        );

        jButton2.setText("Add New Patient");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidebarLayout = new javax.swing.GroupLayout(sidebar);
        sidebar.setLayout(sidebarLayout);
        sidebarLayout.setHorizontalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(sidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        sidebarLayout.setVerticalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btn_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        mainpanel.setMaximumSize(new java.awt.Dimension(1176, 670));
        mainpanel.setMinimumSize(new java.awt.Dimension(1176, 670));
        mainpanel.setPreferredSize(new java.awt.Dimension(1176, 670));
        mainpanel.setLayout(new java.awt.CardLayout());

        printreport.setBackground(new java.awt.Color(255, 255, 255));
        printreport.setMinimumSize(new java.awt.Dimension(1176, 670));

        exit2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Cancel_25px_2.png"))); // NOI18N
        exit2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(236, 236, 255));

        rep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repActionPerformed(evt);
            }
        });

        jButton1.setText("Generate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel85.setText("Enter Hospital No to generate report");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(rep, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel85)
                .addGap(88, 88, 88))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel85)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(236, 236, 255));

        generateExcel.setText("Generate");
        generateExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateExcelActionPerformed(evt);
            }
        });

        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setText("Click to generate Excel File");

        generateExcel1.setText("Generate Daywise");
        generateExcel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateExcel1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(generateExcel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(generateExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel99)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(generateExcel)
                .addGap(18, 18, 18)
                .addComponent(generateExcel1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout printreportLayout = new javax.swing.GroupLayout(printreport);
        printreport.setLayout(printreportLayout);
        printreportLayout.setHorizontalGroup(
            printreportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(printreportLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exit2))
            .addGroup(printreportLayout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addGroup(printreportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 502, Short.MAX_VALUE))
        );
        printreportLayout.setVerticalGroup(
            printreportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(printreportLayout.createSequentialGroup()
                .addComponent(exit2)
                .addGap(219, 219, 219)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 157, Short.MAX_VALUE))
        );

        mainpanel.add(printreport, "card4");

        calculator.setBackground(new java.awt.Color(255, 255, 255));
        calculator.setMinimumSize(new java.awt.Dimension(1176, 670));
        calculator.setPreferredSize(new java.awt.Dimension(1176, 670));

        exit3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Cancel_25px_2.png"))); // NOI18N
        exit3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(236, 236, 255));

        jLabel86.setText("Name : Bilal Shamim");

        jLabel87.setText("Email: bilalshamim526@gmail.com");

        jLabel88.setText("Phone no : 03343092071");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel86)
                    .addComponent(jLabel87)
                    .addComponent(jLabel88))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel86)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel87)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel88)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(236, 236, 255));

        jLabel89.setText("Name : Syed Kashan");

        jLabel90.setText("Email: syedkashancs305@gmail.com");

        jLabel91.setText("Phone no : 03312834089");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel89)
                    .addComponent(jLabel90)
                    .addComponent(jLabel91))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel89)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel90)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel91)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout calculatorLayout = new javax.swing.GroupLayout(calculator);
        calculator.setLayout(calculatorLayout);
        calculatorLayout.setHorizontalGroup(
            calculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calculatorLayout.createSequentialGroup()
                .addGap(0, 1151, Short.MAX_VALUE)
                .addComponent(exit3))
            .addGroup(calculatorLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(calculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        calculatorLayout.setVerticalGroup(
            calculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calculatorLayout.createSequentialGroup()
                .addComponent(exit3)
                .addGap(73, 73, 73)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 322, Short.MAX_VALUE))
        );

        mainpanel.add(calculator, "card5");

        addpatient.setBackground(new java.awt.Color(255, 255, 255));
        addpatient.setMaximumSize(new java.awt.Dimension(1176, 670));
        addpatient.setMinimumSize(new java.awt.Dimension(1176, 670));
        addpatient.setPreferredSize(new java.awt.Dimension(1176, 670));

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Cancel_25px_2.png"))); // NOI18N
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        jLabel1.setText("Hosp. No.");

        hospitalNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hospitalNoActionPerformed(evt);
            }
        });

        jLabel2.setText("DOA in Hospital");

        jLabel3.setText("DOA in ICU");

        timeAdmission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeAdmissionActionPerformed(evt);
            }
        });

        jLabel4.setText("Time");

        jLabel5.setText("Code");

        code.setMaximumRowCount(4);
        code.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Full", "Pharmacy", "DNR", "Full to DNR" }));
        code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeActionPerformed(evt);
            }
        });

        jLabel6.setText("Age");

        age.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ageFocusLost(evt);
            }
        });
        age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageActionPerformed(evt);
            }
        });

        jLabel7.setText("Sex");

        sex.setMaximumRowCount(2);
        sex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        sex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexActionPerformed(evt);
            }
        });

        jLabel8.setText("Weight");

        jLabel9.setText("Height");

        jLabel10.setText("BMI");

        bmi.setEditable(false);
        bmi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bmiMouseClicked(evt);
            }
        });
        bmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmiActionPerformed(evt);
            }
        });

        admittedFrom.setMaximumRowCount(9);
        admittedFrom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "ER", "OR", "HDU", "PACU", "Hospital Floor", "Other ICU", "CCU", "Other Hospital", "Other City" }));
        admittedFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admittedFromActionPerformed(evt);
            }
        });

        jLabel21.setText("Admitted From");

        jLabel22.setText("Admitted Type");

        jLabel23.setText("Comorbids");

        jScrollPane1.setMinimumSize(new java.awt.Dimension(23, 260));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(135, 260));

        jlistAdmittedtype.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Surgical Elect", "Surgical emergency", "Medical", "Trauma", "Ob Gyn", "Cardiac", "Neuro", "GS", "Pulmo", "Nephro", "Thoracic", "Ortho", "Plastic", "Maxsac" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jlistAdmittedtype.setMaximumSize(new java.awt.Dimension(116, 300));
        jlistAdmittedtype.setMinimumSize(new java.awt.Dimension(116, 300));
        jlistAdmittedtype.setPreferredSize(new java.awt.Dimension(116, 280));
        jScrollPane1.setViewportView(jlistAdmittedtype);

        jlistComorbids.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "IDDM", "NIDDM", "COPD", "NYHA III-IV", "CRF", "CLD", "HIV", "Ca with mets", "Hematologic Malignancy", "Chemotherapy", "Radiotherapy", "ImnnunoSupression", "HTN", "Carcmoma", "Steroid Therapy" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jlistComorbids);

        jLabel11.setText("Diagnosis");

        diagnosisPrimary.setColumns(20);
        diagnosisPrimary.setRows(5);
        jScrollPane3.setViewportView(diagnosisPrimary);

        diagnosisSecondary.setColumns(20);
        diagnosisSecondary.setRows(5);
        jScrollPane4.setViewportView(diagnosisSecondary);

        surgery.setColumns(20);
        surgery.setRows(5);
        jScrollPane5.setViewportView(surgery);

        jLabel12.setText("Surgery");

        jLabel13.setText("Date");

        jLabel14.setText("Redo");

        redoSurgery.setColumns(20);
        redoSurgery.setRows(5);
        jScrollPane6.setViewportView(redoSurgery);

        jLabel15.setText("Date");

        jLabel24.setText("ICU Outcome");

        icuOutcome.setMaximumRowCount(2);
        icuOutcome.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "HDU", "Ward", "Other Hospital", "Other ICU", "CCU", "LAMA", "death" }));

        jLabel25.setText("Date Discharge");

        los.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                losFocusLost(evt);
            }
        });
        los.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                losActionPerformed(evt);
            }
        });

        jLabel26.setText("LOS");

        jLabel27.setText("Was Life sustaining therapy withdrawn");

        lifeTherapy.setMaximumRowCount(2);
        lifeTherapy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));

        jLabel16.setText("Reason");

        reasonWithdrawn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reasonWithdrawnActionPerformed(evt);
            }
        });

        jLabel17.setText("ICU ReAdmission");

        reasonReadmission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reasonReadmissionActionPerformed(evt);
            }
        });

        jLabel18.setText("Date");

        jLabel28.setText("Hospital Outcome");

        hospitalOutcome.setMaximumRowCount(2);
        hospitalOutcome.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Discharged Alive", "Death", "LAMA" }));

        jLabel19.setText("Date");

        jLabel20.setText("ICU SCORES");

        jLabel29.setText("Apache II");

        apache.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                apacheFocusLost(evt);
            }
        });

        jLabel30.setText("Saps II");

        saps.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sapsFocusLost(evt);
            }
        });

        qSofa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                qSofaFocusLost(evt);
            }
        });

        jLabel32.setText("qSofa");

        jLabel33.setText("Airway");

        jLabel34.setText("NUTRIC Score");

        nutRiskScore.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nutRiskScoreFocusLost(evt);
            }
        });

        airwayType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Mask", "Prongs", "ETT", "ETT Wsuct", "Trache" }));

        jLabel35.setText("Intubation at");

        intubationAt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "ER", "OR", "HDU", "ward", "ICU", "Other Hospital" }));
        intubationAt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intubationAtActionPerformed(evt);
            }
        });

        jLabel36.setText("Extubation");

        jLabel37.setText("Time");

        jLabel38.setText("ReIntubation");

        jLabel39.setText("Self Extubation");

        selfExtubation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));

        jLabel40.setText("Ventilation");

        ventilationDays.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ventilationDaysFocusLost(evt);
            }
        });

        vap.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));

        jLabel41.setText("VAP");

        jLabel42.setText("CVP days");

        cvpDays.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cvpDaysFocusLost(evt);
            }
        });

        clabsi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));

        jLabel43.setText("Clabsi");

        jLabel44.setText("Complications");

        jLabel45.setText("Reason Of death");

        jLabel46.setText("Brain Scan");

        jLabel47.setText("Repeat Brain Scan");

        jLabel48.setText("FOUR SCORES");

        jLabel49.setText("E");

        e.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                eFocusLost(evt);
            }
        });

        m.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mFocusLost(evt);
            }
        });

        jLabel50.setText("M");

        b.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bFocusLost(evt);
            }
        });

        jLabel51.setText("B");

        r.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rFocusLost(evt);
            }
        });

        jLabel52.setText("R");

        total.setEditable(false);
        total.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                totalMouseClicked(evt);
            }
        });

        jLabel53.setText("Total");

        nextpage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Forward_30px_2.png"))); // NOI18N
        nextpage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextpageMouseClicked(evt);
            }
        });

        jLabel69.setText("Reason");

        reAdmission.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));
        reAdmission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reAdmissionActionPerformed(evt);
            }
        });

        vent.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));
        vent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventActionPerformed(evt);
            }
        });

        jLabel65.setText("days");

        hospitalDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hospitalDateActionPerformed(evt);
            }
        });

        jScrollPane13.setViewportView(jListSelectAdmission);

        jScrollPane14.setViewportView(jListSelectComorbid);

        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Forward_30px_2.png"))); // NOI18N
        jLabel93.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel93MouseClicked(evt);
            }
        });

        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Back_30px_1.png"))); // NOI18N
        jLabel95.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel95MouseClicked(evt);
            }
        });

        jLabel94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Forward_30px_2.png"))); // NOI18N
        jLabel94.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel94MouseClicked(evt);
            }
        });

        jLabel96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Back_30px_1.png"))); // NOI18N
        jLabel96.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel96MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout addpatientLayout = new javax.swing.GroupLayout(addpatient);
        addpatient.setLayout(addpatientLayout);
        addpatientLayout.setHorizontalGroup(
            addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addpatientLayout.createSequentialGroup()
                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(1094, 1094, 1094)
                        .addComponent(nextpage)
                        .addGap(6, 6, 6)
                        .addComponent(exit))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(hospitalNo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(doaHospital, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(doaICU, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(timeAdmission, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel8)
                        .addGap(10, 10, 10)
                        .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel9)
                        .addGap(4, 4, 4)
                        .addComponent(height, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(bmi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel21)
                        .addGap(4, 4, 4)
                        .addComponent(admittedFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addpatientLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel22)
                                .addGap(4, 4, 4)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel93)
                                    .addComponent(jLabel95)))
                            .addGroup(addpatientLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel23)
                                .addGap(24, 24, 24)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel94)
                                    .addComponent(jLabel96))))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addpatientLayout.createSequentialGroup()
                                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(15, 15, 15))
                            .addGroup(addpatientLayout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)))
                        .addGap(0, 0, 0)
                        .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane5))
                        .addGap(30, 30, 30)
                        .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addpatientLayout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(dateRedo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addpatientLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateSurgery, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(addpatientLayout.createSequentialGroup()
                                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(addpatientLayout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel29)
                                        .addGap(10, 10, 10)
                                        .addComponent(apache, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel30)
                                        .addGap(10, 10, 10)
                                        .addComponent(saps, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(addpatientLayout.createSequentialGroup()
                                        .addGap(321, 321, 321)
                                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32)
                                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(addpatientLayout.createSequentialGroup()
                                        .addComponent(jLabel32)
                                        .addGap(4, 4, 4)
                                        .addComponent(qSofa, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel34)
                                        .addGap(10, 10, 10)
                                        .addComponent(nutRiskScore, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(addpatientLayout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(addpatientLayout.createSequentialGroup()
                                                .addComponent(jLabel26)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(los, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(addpatientLayout.createSequentialGroup()
                                                .addComponent(jLabel24)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(icuOutcome, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(15, 15, 15)
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dateDischarge, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 46, Short.MAX_VALUE))
                            .addGroup(addpatientLayout.createSequentialGroup()
                                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(complication, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(brainScan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel47)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(reasonOfDeath, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                                    .addComponent(repeatBrainScan)))))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel27)
                        .addGap(10, 10, 10)
                        .addComponent(lifeTherapy, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(reasonWithdrawn, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17)
                        .addGap(4, 4, 4)
                        .addComponent(reAdmission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel69)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reasonReadmission, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateReadmission, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hospitalOutcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hospitalDate, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addpatientLayout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel65)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ventilationDays, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(vap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cvpDays, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clabsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addpatientLayout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addGap(24, 24, 24)
                                .addComponent(airwayType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel35)
                                .addGap(10, 10, 10)
                                .addComponent(intubationAt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateExtubation, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel37)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(extubationTime, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel38)
                        .addGap(10, 10, 10)
                        .addComponent(reIntubation, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel39)
                        .addGap(18, 18, 18)
                        .addComponent(selfExtubation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel48)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel49)
                        .addGap(10, 10, 10)
                        .addComponent(e, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel50)
                        .addGap(10, 10, 10)
                        .addComponent(m, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel51)
                        .addGap(10, 10, 10)
                        .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel52)
                        .addGap(4, 4, 4)
                        .addComponent(r, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel53)
                        .addGap(10, 10, 10)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        addpatientLayout.setVerticalGroup(
            addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addpatientLayout.createSequentialGroup()
                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nextpage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit))
                .addGap(5, 5, 5)
                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(hospitalNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2))
                    .addComponent(doaHospital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(doaICU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel4))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(timeAdmission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel5))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel6))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7))
                    .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel8))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel9))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(height, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel10))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(bmi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel21))
                    .addComponent(admittedFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addpatientLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(addpatientLayout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel11)
                                        .addGap(66, 66, 66)
                                        .addComponent(jLabel12))
                                    .addGroup(addpatientLayout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(addpatientLayout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(dateSurgery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13)))))
                            .addGroup(addpatientLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel93)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel95)))
                        .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addpatientLayout.createSequentialGroup()
                                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addpatientLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                        .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addpatientLayout.createSequentialGroup()
                                                .addComponent(jLabel94)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel96)
                                                .addGap(43, 43, 43))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addpatientLayout.createSequentialGroup()
                                                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(los, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel26))
                                                .addGap(8, 8, 8))))
                                    .addGroup(addpatientLayout.createSequentialGroup()
                                        .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(addpatientLayout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(jLabel15))
                                            .addGroup(addpatientLayout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(dateRedo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(addpatientLayout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel14)
                                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel24)
                                                    .addComponent(icuOutcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel25)
                                                    .addComponent(dateDischarge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(9, 9, 9)
                                .addComponent(jLabel16))
                            .addGroup(addpatientLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel23))))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lifeTherapy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(reasonWithdrawn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addpatientLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel27)))))
                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel17))
                    .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(reAdmission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel69)
                        .addComponent(reasonReadmission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)
                        .addComponent(dateReadmission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28)
                        .addComponent(hospitalOutcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19)
                        .addComponent(hospitalDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(apache, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qSofa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nutRiskScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel29)
                            .addComponent(jLabel32)
                            .addComponent(jLabel34)
                            .addComponent(jLabel30))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel33))
                    .addComponent(airwayType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel35))
                    .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(intubationAt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel36)
                        .addComponent(dateExtubation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel37)
                        .addComponent(extubationTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel38))
                    .addComponent(reIntubation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel39))
                    .addComponent(selfExtubation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(vent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65)
                    .addComponent(ventilationDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(vap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(cvpDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(clabsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(complication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel45)
                        .addComponent(reasonOfDeath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel46))
                    .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(brainScan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel47)
                        .addComponent(repeatBrainScan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addpatientLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(addpatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50)
                            .addComponent(jLabel51)
                            .addComponent(jLabel52)
                            .addComponent(jLabel53))))
                .addGap(32, 32, 32))
        );

        mainpanel.add(addpatient, "card2");

        addpatient1.setBackground(new java.awt.Color(255, 255, 255));
        addpatient1.setMaximumSize(new java.awt.Dimension(1176, 670));
        addpatient1.setMinimumSize(new java.awt.Dimension(1176, 670));
        addpatient1.setPreferredSize(new java.awt.Dimension(1176, 670));

        exit4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Cancel_25px_2.png"))); // NOI18N
        exit4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit4MouseClicked(evt);
            }
        });

        Insert.setText("Insert");
        Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(236, 236, 255));
        jPanel1.setForeground(new java.awt.Color(204, 204, 255));

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel59.setText("Monitoring:");

        jLabeltracheal2.setText("CVP:");

        jLabel60.setText("min");

        jLabel61.setText("max");

        jLabel58.setText("A-line:");

        jLabel72.setText("EsopDopplr:");

        dopplr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));
        dopplr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dopplrActionPerformed(evt);
            }
        });

        jLabel74.setText("POCUS:");

        pocus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));
        pocus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pocusActionPerformed(evt);
            }
        });

        aLine.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabeltracheal2)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel58)
                        .addGap(18, 18, 18)))
                .addComponent(jLabel60)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cvpMin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cvpMax, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(aLine, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pocus, javax.swing.GroupLayout.Alignment.LEADING, 0, 47, Short.MAX_VALUE)
                        .addComponent(dopplr, javax.swing.GroupLayout.Alignment.LEADING, 0, 47, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72)
                    .addComponent(jLabel74))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabeltracheal2)
                    .addComponent(jLabel60)
                    .addComponent(cvpMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cvpMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(aLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel72)
                    .addComponent(dopplr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(pocus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(236, 236, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(230, 173));

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel63.setText("Nutrition:");

        jLabelrr4.setText("Route:");

        route.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Enternal", "Oral", "TPN" }));

        jLabelsbp2.setText("Formula:");

        formula1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Ensure", "Glucerna", "Isocal", "Beneprotein", "Other" }));
        formula1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formula1ActionPerformed(evt);
            }
        });

        Calorie.setText("Calorie /kg");
        Calorie.setName("Calorie"); // NOI18N

        Calorie1.setText("Protein /kg");
        Calorie1.setName("Calorie"); // NOI18N

        protein.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proteinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabelrr4)
                        .addGap(60, 60, 60)
                        .addComponent(route, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelsbp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Calorie1)
                            .addComponent(Calorie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(formula1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(protein, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calorie, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelrr4)
                    .addComponent(route, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formula1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelsbp2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Calorie)
                    .addComponent(calorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Calorie1)
                    .addComponent(protein, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jScrollPane8.setName(""); // NOI18N

        jPanel8.setBackground(new java.awt.Color(236, 236, 255));
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel8.setMaximumSize(new java.awt.Dimension(453, 1870));
        jPanel8.setMinimumSize(new java.awt.Dimension(453, 1870));
        jPanel8.setPreferredSize(new java.awt.Dimension(200, 1870));

        day.setText("Day:");

        days.setEditable(false);
        days.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daysActionPerformed(evt);
            }
        });

        jLabelrr3.setText("HR:");

        jLabelsbp3.setText("SBP:");

        jLabeldbp3.setText("DBP:");

        jLabelmap4.setText("MAP:");

        jLabelmap5.setText("Temp:");

        jLabelgcs2.setText("GCS(min):");

        jLabelrass2.setText("RASS:");

        jLabeldelirium2.setText("Delirium");

        delirium.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));

        jLabelpainscore2.setText("Pain Score():");

        jLabelph2.setText("pH:");

        jLabelpaco4.setText(" PaCO₂");

        jLabelpao2.setText("PaO:");

        jLabelflo4.setText(" Fl0₂");

        jLabelhco5.setText("HCO3:");

        jLabelflo5.setText("Mg:");

        jLabeldbp4.setText("Creatinine:");
        jLabeldbp4.setAlignmentY(0.0F);

        jLabelpaco5.setText("PT-INR:");

        jLabelpao3.setText("D-dimer:");

        jLabelrr5.setText("Base Excess:");

        jLabelmap6.setText("Na:");

        jLabelhco6.setText("P04:");

        jLabelgcs3.setText("Cl:");

        jLabelph3.setText("WBC (x1000):");

        jLabelmap7.setText("K:");

        jLabelrass3.setText("Hb:");

        jLabeldelirium3.setText("Hct%");

        jLabelsbp4.setText("Urea:");

        jLabelpainscore3.setText("Platelets (x1000):");

        jLabelmap14.setText("ALT:");

        jLabelrr9.setText("Ca:");

        jLabelph7.setText("Albumen:");

        jLabelpao7.setText("CPK:");

        jLabelpainscore7.setText("Lipase:");

        jLabelflo9.setText("Trop-I:");

        jLabeldelirium7.setText("Amylase:");

        jLabelpaco9.setText("LDH:");

        jLabelhco10.setText("BNP:");

        jLabelrass7.setText("GGT:");

        jLabelsbp8.setText("Ca ion:");

        jLabeldbp11.setText("Bilirubin");

        jLabelmap15.setText("AST:");

        jLabelgcs7.setText("AlkPhos:");

        jLabelrass8.setText("Vasopressors:");

        jLabelpaco10.setText("Epinephrine:");

        jLabeldelirium8.setText("Norepinephrine:");

        jLabelsbp9.setText("PCT:");

        jLabelpao8.setText("Dobutamine:");

        jLabelmap16.setText("BSR:");

        jLabelgcs8.setText("Dialysis:");

        jLabelmap17.setText("DVTprophylaxis");

        jLabelhco11.setText("SteriodsLD:");

        jLabelrr10.setText("Lactate (in mmol):");

        jLabelph8.setText("Dopamine:");

        jLabelflo10.setText("Phenylephrine:");

        jLabeldbp12.setText("CRP:");

        jLabel54.setText("min");

        jLabel56.setText("max");

        jLabelmap8.setText("RR:");

        jLabelpao1.setText("Fibrinog:");

        dialysis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));

        vasopressors.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));
        vasopressors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vasopressorsActionPerformed(evt);
            }
        });

        steriodsld.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));

        jLabel71.setText("spot USodium:");

        dvtpropylaxis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4", "5" }));

        jLabelflo11.setText("Sofa");

        pbyf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pbyfMouseClicked(evt);
            }
        });
        pbyf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pbyfActionPerformed(evt);
            }
        });
        pbyf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pbyfKeyPressed(evt);
            }
        });

        jLabelflo7.setText(" Pao2/Fl0₂:");

        PAO2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PAO2MouseClicked(evt);
            }
        });
        PAO2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PAO2ActionPerformed(evt);
            }
        });
        PAO2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PAO2KeyPressed(evt);
            }
        });

        jLabelflo8.setText("PAO2");

        jLabelflo12.setText("Gradient:");

        gradient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradientMouseClicked(evt);
            }
        });
        gradient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gradientKeyPressed(evt);
            }
        });

        jLabel31.setText("mcg/kg/m");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelrass2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabelrr3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(86, 86, 86))
                            .addComponent(jLabelsbp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                    .addComponent(day)
                                    .addGap(7, 7, 7))
                                .addComponent(jLabeldbp3)
                                .addComponent(jLabelmap5)
                                .addComponent(jLabelmap4))
                            .addComponent(jLabelgcs2)
                            .addComponent(jLabelmap8))
                        .addGap(339, 339, 339))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelpainscore2)
                            .addComponent(jLabelflo4)
                            .addComponent(jLabelpao2)
                            .addComponent(jLabelpaco4)
                            .addComponent(jLabelph2)
                            .addComponent(jLabeldelirium2)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelflo9)
                                    .addComponent(jLabelrr10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bnp, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lactate, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(trop1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabelhco10)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabelmap16)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel54)
                                .addGap(2, 2, 2)
                                .addComponent(bsrmin, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bsrmax, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabeldbp12)
                                    .addComponent(jLabelsbp9))
                                .addGap(72, 72, 72)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(crp, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pct, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabelflo7)
                            .addComponent(jLabelflo8)
                            .addComponent(jLabelflo12)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(gradient, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabeldelirium3)
                                        .addComponent(jLabelpao1)
                                        .addComponent(jLabelpao3)
                                        .addComponent(jLabelsbp8)
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                            .addGap(3, 3, 3)
                                            .addComponent(jLabelmap7))
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                            .addGap(4, 4, 4)
                                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabelrass3)
                                                .addComponent(jLabelgcs3)))
                                        .addComponent(jLabelph3)
                                        .addComponent(jLabelrr5)
                                        .addComponent(jLabelsbp4)
                                        .addComponent(jLabelmap6)
                                        .addComponent(jLabelpainscore3)
                                        .addComponent(jLabelpaco5)
                                        .addComponent(jLabelflo5)
                                        .addComponent(jLabelhco6)
                                        .addComponent(jLabelrr9)
                                        .addComponent(jLabeldbp11)
                                        .addComponent(jLabelrass7)
                                        .addComponent(jLabelgcs7)
                                        .addComponent(jLabelmap15)
                                        .addComponent(jLabeldelirium7)
                                        .addComponent(jLabelpainscore7)
                                        .addComponent(jLabeldbp4)
                                        .addComponent(jLabelmap14)
                                        .addComponent(jLabelhco5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pbyf)
                                        .addComponent(bilrubin, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(wbc, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(baseexcess, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(cl, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(k, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(na, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(creatinine, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(urea, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(hct, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(plateletes, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(ptinr, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(ddimer, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(mg, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(po4, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(ca, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(caion, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(fibrinog, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(alt, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(ast, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(alkphos, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(ggt, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                        .addComponent(amylase)
                                        .addComponent(lipase)
                                        .addComponent(hb, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(hco3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                            .addComponent(flo2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                            .addComponent(pao, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(paco2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                                .addComponent(ph, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                                .addComponent(delirium, 0, 50, Short.MAX_VALUE)
                                                .addComponent(painscore, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                                .addComponent(rass, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                                .addComponent(gcs, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                                .addComponent(rr, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                                .addComponent(temp, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                                .addComponent(map, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                                .addComponent(dbp, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                                .addComponent(sbp, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                                .addComponent(hr, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                                .addComponent(days, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)))
                                        .addComponent(PAO2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelpaco9)
                                        .addComponent(jLabelpao7))
                                    .addGap(73, 73, 73)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ldh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cpk, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(albumen, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelgcs8, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabelflo11)
                                    .addGap(78, 78, 78)
                                    .addComponent(Sofa, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabelph8)
                                                .addComponent(jLabelpaco10)
                                                .addComponent(jLabelrass8)
                                                .addComponent(jLabelpao8)
                                                .addComponent(jLabelflo10)
                                                .addComponent(jLabelhco11))
                                            .addGap(5, 5, 5))
                                        .addComponent(jLabeldelirium8, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(vasopressors, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dopamine)
                                        .addComponent(norepinephrine)
                                        .addComponent(epinephrine)
                                        .addComponent(dobutamine)
                                        .addComponent(phenylephrine)
                                        .addComponent(steriodsld, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(dialysis, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelph7)
                            .addComponent(jLabel31)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelmap17)
                                    .addComponent(jLabel71))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dvtpropylaxis, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spotUSodium, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bnp, cpk, ldh, trop1});

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {alkphos, alt, ast, baseexcess, bilrubin, ca, caion, cl, creatinine, days, dbp, ddimer, delirium, fibrinog, flo2, gcs, ggt, hb, hco3, hct, hr, k, map, mg, na, paco2, painscore, pao, ph, plateletes, po4, ptinr, rass, rr, sbp, temp, urea, wbc});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(day)
                    .addComponent(days, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelrr3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelsbp3)
                    .addComponent(sbp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabeldbp3)
                    .addComponent(dbp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelmap4)
                    .addComponent(map, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelmap5)
                    .addComponent(temp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelmap8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelgcs2)
                    .addComponent(gcs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelrass2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delirium, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabeldelirium2))
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelpainscore2)
                    .addComponent(painscore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelph2)
                    .addComponent(ph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelpaco4)
                    .addComponent(paco2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelpao2)
                    .addComponent(pao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelflo4)
                    .addComponent(flo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelflo7)
                    .addComponent(pbyf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelflo8)
                    .addComponent(PAO2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelflo12)
                    .addComponent(gradient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelhco5)
                    .addComponent(hco3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(baseexcess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(urea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(creatinine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabeldbp4)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabelrr5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelsbp4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(na, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelmap6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelmap7)
                    .addComponent(k, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelgcs3)
                    .addComponent(cl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelrass3)
                    .addComponent(hb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabeldelirium3)
                    .addComponent(hct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelpainscore3)
                    .addComponent(plateletes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelph3)
                    .addComponent(wbc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelpaco5)
                    .addComponent(ptinr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fibrinog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelpao1))
                .addGap(7, 7, 7)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelpao3)
                    .addComponent(ddimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelflo5)
                    .addComponent(mg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelhco6)
                    .addComponent(po4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelrr9)
                    .addComponent(ca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelsbp8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabeldbp11)
                    .addComponent(bilrubin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelmap14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ast, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelmap15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alkphos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelgcs7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ggt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelrass7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amylase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabeldelirium7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lipase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelpainscore7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelpaco9)
                    .addComponent(ldh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelpao7)
                    .addComponent(cpk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelph7)
                    .addComponent(albumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trop1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelflo9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelhco10)
                    .addComponent(bnp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabeldbp12))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelrr10)
                            .addComponent(lactate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelsbp9)
                            .addComponent(pct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(crp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelmap16)
                    .addComponent(jLabel54)
                    .addComponent(bsrmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56)
                    .addComponent(bsrmax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(spotUSodium, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dvtpropylaxis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelmap17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelgcs8)
                    .addComponent(dialysis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelrass8)
                    .addComponent(vasopressors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabeldelirium8)
                    .addComponent(norepinephrine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelph8)
                    .addComponent(dopamine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelpaco10)
                    .addComponent(epinephrine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelpao8)
                    .addComponent(dobutamine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelflo10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phenylephrine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelhco11)
                    .addComponent(steriodsld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Sofa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelflo11, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97))
        );

        jScrollPane8.setViewportView(jPanel8);

        jScrollPane7.setMinimumSize(new java.awt.Dimension(23, 850));
        jScrollPane7.setPreferredSize(new java.awt.Dimension(200, 850));

        jPanel9.setBackground(new java.awt.Color(236, 236, 255));
        jPanel9.setMaximumSize(new java.awt.Dimension(453, 800));
        jPanel9.setMinimumSize(new java.awt.Dimension(453, 800));
        jPanel9.setPreferredSize(new java.awt.Dimension(200, 800));

        day1.setText("Ventilate");

        jLabelrr6.setText("Mode:");

        jLabelsbp5.setText("Vt/kg");

        jLabeldbp5.setText("PS/PC:");

        jLabelmap9.setText("PEEP:");

        jLabelmap10.setText("P peak:");

        jLabelgcs4.setText("C stat:");

        jLabeldelirium4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabeldelirium4.setText("Weaning:");

        jLabelrass4.setText("ETT cuff press:");

        ventilate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));
        ventilate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventilateActionPerformed(evt);
            }
        });

        jLabelpainscore4.setText("Extub - NIV:");

        jLabelph4.setText("T-piece:");

        jLabelpaco6.setText("Fluid Balance:");

        jLabelpao4.setText("Urine output:");

        jLabelflo6.setText("Other losses:");

        outputTotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                outputTotalMouseClicked(evt);
            }
        });
        outputTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                outputTotalKeyPressed(evt);
            }
        });

        jLabelhco7.setText("Output total:");

        jLabeldbp6.setText("Cum balance:");

        jLabelrr7.setText("Intake total:");

        jLabelmap11.setText("IV Fuilds:");

        balance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                balanceMouseClicked(evt);
            }
        });
        balance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                balanceKeyPressed(evt);
            }
        });

        jLabelgcs5.setText("Colloid:");

        jLabelph5.setText("Complicat:");

        jLabelmap12.setText("Crystalloid:");

        jLabelrass5.setText("Blood / PRBCs:");

        jLabeldelirium5.setText("Plateletes units:");

        jLabelsbp6.setText("Balance (ml):");

        jLabelpainscore5.setText("FFPs");

        jLabelmap13.setText("P plat:");

        cstat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cstatActionPerformed(evt);
            }
        });

        weaning.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        weaning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weaningActionPerformed(evt);
            }
        });

        complicat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));

        fluidBalance.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yes", "No" }));
        fluidBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fluidBalanceActionPerformed(evt);
            }
        });

        ivFluids.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yes", "No" }));
        ivFluids.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ivFluids.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ivFluidsActionPerformed(evt);
            }
        });

        crystalloid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4", "5" }));
        crystalloid.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        crystalloid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crystalloidActionPerformed(evt);
            }
        });

        colloid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4" }));
        colloid.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        colloid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colloidActionPerformed(evt);
            }
        });

        mode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8" }));
        mode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeActionPerformed(evt);
            }
        });

        extubniv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Yes", "No" }));

        tpiece.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Yes", "No" }));

        jLabelpainscore6.setText("Cryoppt:");

        cryoppt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cryopptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabeldbp5)
                    .addComponent(jLabelsbp5)
                    .addComponent(jLabelmap9)
                    .addComponent(jLabelrr6)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelmap13)
                            .addComponent(day1)
                            .addComponent(jLabelmap10))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pplat)
                            .addComponent(ppeak)
                            .addComponent(peep)
                            .addComponent(ps)
                            .addComponent(vt)
                            .addComponent(ventilate, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelgcs4)
                            .addComponent(jLabelrass4)
                            .addComponent(jLabeldelirium4)
                            .addComponent(jLabelph4)
                            .addComponent(jLabelpaco6)
                            .addComponent(jLabelpao4)
                            .addComponent(jLabelflo6)
                            .addComponent(jLabelhco7)
                            .addComponent(jLabeldbp6)
                            .addComponent(jLabelrr7)
                            .addComponent(jLabelpainscore4)
                            .addComponent(jLabelsbp6)
                            .addComponent(jLabelph5)
                            .addComponent(jLabelpainscore6)
                            .addComponent(jLabelmap11)
                            .addComponent(jLabelmap12)
                            .addComponent(jLabelgcs5)
                            .addComponent(jLabelrass5)
                            .addComponent(jLabeldelirium5)
                            .addComponent(jLabelpainscore5))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ivFluids, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(crystalloid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(colloid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bloodPRCBS)
                            .addComponent(plateletunit)
                            .addComponent(ffps)
                            .addComponent(cumBalance)
                            .addComponent(balance)
                            .addComponent(intakeTotal)
                            .addComponent(outputTotal)
                            .addComponent(otherLosses)
                            .addComponent(urineOutput)
                            .addComponent(ETTcuffpress)
                            .addComponent(cstat)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(fluidBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(weaning, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tpiece, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(extubniv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(complicat, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cryoppt, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(297, 297, 297))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(day1)
                    .addComponent(ventilate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelrr6)
                    .addComponent(mode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelsbp5)
                    .addComponent(vt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabeldbp5)
                    .addComponent(ps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelmap9)
                    .addComponent(peep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelmap10)
                    .addComponent(ppeak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pplat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelmap13))
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelgcs4)
                    .addComponent(cstat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelrass4)
                    .addComponent(ETTcuffpress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabeldelirium4)
                            .addComponent(weaning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(extubniv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelpainscore4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tpiece, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelph4))
                .addGap(5, 5, 5)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelpaco6)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(fluidBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(urineOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelpao4))))
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(otherLosses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelflo6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outputTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelhco7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(intakeTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelrr7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelsbp6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cumBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabeldbp6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ivFluids, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelmap11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crystalloid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelmap12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colloid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelgcs5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bloodPRCBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelrass5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plateletunit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabeldelirium5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ffps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelpainscore5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cryoppt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelpainscore6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(complicat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelph5))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jScrollPane7.setViewportView(jPanel9);

        jScrollPane9.setMaximumSize(new java.awt.Dimension(250, 650));
        jScrollPane9.setMinimumSize(new java.awt.Dimension(23, 650));
        jScrollPane9.setPreferredSize(new java.awt.Dimension(232, 650));

        jPanel2.setBackground(new java.awt.Color(236, 236, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(244, 750));
        jPanel2.setMinimumSize(new java.awt.Dimension(244, 750));
        jPanel2.setPreferredSize(new java.awt.Dimension(244, 750));

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel57.setText("Microbiology:");

        jLabeltracheal1.setText("Trach:");

        tracheal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));
        tracheal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trachealActionPerformed(evt);
            }
        });

        jLabelrr2.setText("Org: MDR?");

        jLabeltracheal3.setText("Blood periph");

        bloodPeriph.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));
        bloodPeriph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloodPeriphActionPerformed(evt);
            }
        });

        jLabeltracheal4.setText("Urine:");

        jLabeltracheal5.setText("CSF:");

        jLabeltracheal6.setText("Peritoneal:");

        jLabeltracheal7.setText("Wound:");

        jLabeltracheal8.setText("Blood CVP");

        jLabeltracheal9.setText("Others:");

        urine.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));
        urine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urineActionPerformed(evt);
            }
        });

        csf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));
        csf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                csfActionPerformed(evt);
            }
        });

        peritoneal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));
        peritoneal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peritonealActionPerformed(evt);
            }
        });

        wound.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));
        wound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                woundActionPerformed(evt);
            }
        });

        bloodCvp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));
        bloodCvp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloodCvpActionPerformed(evt);
            }
        });

        others.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));
        others.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                othersActionPerformed(evt);
            }
        });

        jLabel73.setText("Antiboitics:");

        jlistAntibiotic.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jlistAntibiotic.setPreferredSize(new java.awt.Dimension(63, 550));
        jScrollPane12.setViewportView(jlistAntibiotic);

        jScrollPane15.setViewportView(jListSelectAntibiotic);

        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Forward_30px_2.png"))); // NOI18N
        jLabel97.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel97MouseClicked(evt);
            }
        });

        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Back_30px_1.png"))); // NOI18N
        jLabel98.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel98MouseClicked(evt);
            }
        });

        jListTrach.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane16.setViewportView(jListTrach);

        TrachFrwd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Forward_30px_2.png"))); // NOI18N
        TrachFrwd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TrachFrwdMouseClicked(evt);
            }
        });

        TrachBck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Back_30px_1.png"))); // NOI18N
        TrachBck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TrachBckMouseClicked(evt);
            }
        });

        jScrollPane17.setViewportView(jListSelectTrach);

        jListBperi.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane18.setViewportView(jListBperi);

        BperiFwrd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Forward_30px_2.png"))); // NOI18N
        BperiFwrd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BperiFwrdMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BperiFwrdMouseEntered(evt);
            }
        });

        TrachBck1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Back_30px_1.png"))); // NOI18N
        TrachBck1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TrachBck1MouseClicked(evt);
            }
        });

        jScrollPane19.setViewportView(jListSelectBperi);

        jListBcvp.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane20.setViewportView(jListBcvp);

        TrachFrwd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Forward_30px_2.png"))); // NOI18N
        TrachFrwd2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TrachFrwd2MouseClicked(evt);
            }
        });

        TrachBck2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Back_30px_1.png"))); // NOI18N
        TrachBck2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TrachBck2MouseClicked(evt);
            }
        });

        jListUrine.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane22.setViewportView(jListUrine);

        jListCsf.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane30.setViewportView(jListCsf);

        jScrollPane32.setViewportView(jListSelectBcvp);

        jScrollPane33.setViewportView(jListSelectUrine);

        jScrollPane34.setViewportView(jListSelectCsf);

        jScrollPane35.setViewportView(jListSelectPeri);

        jListWound.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane39.setViewportView(jListWound);

        jListPeri.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane40.setViewportView(jListPeri);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        TrachFrwd4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Forward_30px_2.png"))); // NOI18N
        TrachFrwd4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TrachFrwd4MouseClicked(evt);
            }
        });

        TrachBck7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Back_30px_1.png"))); // NOI18N
        TrachBck7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TrachBck7MouseClicked(evt);
            }
        });

        TrachFrwd7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Forward_30px_2.png"))); // NOI18N
        TrachFrwd7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TrachFrwd7MouseClicked(evt);
            }
        });

        TrachBck9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Back_30px_1.png"))); // NOI18N
        TrachBck9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TrachBck9MouseClicked(evt);
            }
        });

        TrachFrwd8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Forward_30px_2.png"))); // NOI18N
        TrachFrwd8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TrachFrwd8MouseClicked(evt);
            }
        });

        TrachBck10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Back_30px_1.png"))); // NOI18N
        TrachBck10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TrachBck10MouseClicked(evt);
            }
        });

        TrachFrwd9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Forward_30px_2.png"))); // NOI18N
        TrachFrwd9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TrachFrwd9MouseClicked(evt);
            }
        });

        TrachBck11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Back_30px_1.png"))); // NOI18N
        TrachBck11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TrachBck11MouseClicked(evt);
            }
        });

        jScrollPane37.setViewportView(jListSelectWound);

        jLabelrr8.setText("Org: MDR?");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jLabelrr2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel97)
                            .addComponent(jLabel98))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabeltracheal3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BperiFwrd)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(jLabeltracheal1)
                                            .addGap(61, 61, 61)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(bloodPeriph, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tracheal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(bloodCvp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabeltracheal4)
                                                .addComponent(jLabeltracheal6)
                                                .addComponent(jLabeltracheal7)
                                                .addComponent(jLabeltracheal9))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(others, 0, 50, Short.MAX_VALUE)
                                                .addComponent(urine, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(csf, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(peritoneal, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(wound, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGap(36, 36, 36)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(TrachBck)
                                                .addComponent(TrachFrwd))
                                            .addGap(18, 18, 18)
                                            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(TrachBck1)
                                            .addGap(58, 58, 58))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabeltracheal8)
                                                .addComponent(jLabeltracheal5))
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(TrachFrwd7)
                                                                    .addComponent(TrachBck9))
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(TrachFrwd8)
                                                                    .addComponent(TrachBck10)))
                                                            .addGap(18, 18, 18)
                                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jScrollPane34, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jScrollPane35, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(TrachFrwd9)
                                                                .addComponent(TrachBck11))
                                                            .addGap(18, 18, 18)
                                                            .addComponent(jScrollPane37, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGap(132, 132, 132)
                                                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(TrachFrwd4)
                                                            .addComponent(TrachBck7))
                                                        .addGap(17, 17, 17)
                                                        .addComponent(jScrollPane33, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                        .addGap(165, 165, 165)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(TrachFrwd2)
                                                            .addComponent(TrachBck2))
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jScrollPane32, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addComponent(jLabelrr8, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addGap(93, 93, 93)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGap(1, 1, 1))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelrr2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 437, Short.MAX_VALUE)
                        .addComponent(TrachFrwd9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TrachBck11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabeltracheal1)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(TrachFrwd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(TrachBck))
                                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tracheal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabeltracheal3)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(BperiFwrd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(TrachBck1))
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(bloodPeriph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabeltracheal8)
                                        .addComponent(bloodCvp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(TrachFrwd2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(TrachBck2))
                                            .addComponent(jScrollPane20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(jScrollPane32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jScrollPane33, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(urine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabeltracheal4))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(TrachFrwd4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(TrachBck7)))
                                            .addComponent(jScrollPane22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                                .addComponent(jScrollPane34, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(TrachFrwd7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(TrachBck9))
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGap(6, 6, 6)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(csf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabeltracheal5)
                                                            .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(peritoneal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabeltracheal6))
                                                    .addComponent(jScrollPane40, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(TrachFrwd8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(TrachBck10))))
                                            .addComponent(jScrollPane35, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane39, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(wound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabeltracheal7))
                            .addComponent(jScrollPane37, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabeltracheal9)
                    .addComponent(others, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelrr8)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel97)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel98))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel73)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18))
        );

        jScrollPane9.setViewportView(jPanel2);

        addNew.setText("Add New");
        addNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewActionPerformed(evt);
            }
        });

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addpatient1Layout = new javax.swing.GroupLayout(addpatient1);
        addpatient1.setLayout(addpatient1Layout);
        addpatient1Layout.setHorizontalGroup(
            addpatient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addpatient1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(addpatient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addGroup(addpatient1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addpatient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exit4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addpatient1Layout.createSequentialGroup()
                        .addGroup(addpatient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(update, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Insert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        addpatient1Layout.setVerticalGroup(
            addpatient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addpatient1Layout.createSequentialGroup()
                .addGroup(addpatient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addpatient1Layout.createSequentialGroup()
                        .addGroup(addpatient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addpatient1Layout.createSequentialGroup()
                                .addComponent(exit4)
                                .addGap(501, 501, 501)
                                .addComponent(update)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Insert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addNew))
                            .addGroup(addpatient1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addpatient1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addpatient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );

        mainpanel.add(addpatient1, "card6");

        showData.setBackground(new java.awt.Color(255, 255, 255));
        showData.setMaximumSize(new java.awt.Dimension(1176, 670));
        showData.setMinimumSize(new java.awt.Dimension(1176, 670));
        showData.setPreferredSize(new java.awt.Dimension(1176, 670));

        exit5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Cancel_25px_2.png"))); // NOI18N
        exit5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit5exitMouseClicked(evt);
            }
        });

        patient_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hospital No", "ICU Outcome", "Hospital Outcome", "Admission Date"
            }
        ));
        patient_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patient_tableMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(patient_table);

        viewreport.setText("View / Print Report");
        viewreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewreportActionPerformed(evt);
            }
        });

        filter.setText("Filter by Date");
        filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout showDataLayout = new javax.swing.GroupLayout(showData);
        showData.setLayout(showDataLayout);
        showDataLayout.setHorizontalGroup(
            showDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showDataLayout.createSequentialGroup()
                .addGap(0, 1151, Short.MAX_VALUE)
                .addComponent(exit5))
            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showDataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(braindeath, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(359, 359, 359))
            .addGroup(showDataLayout.createSequentialGroup()
                .addGap(377, 377, 377)
                .addComponent(viewreport, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        showDataLayout.setVerticalGroup(
            showDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showDataLayout.createSequentialGroup()
                .addComponent(exit5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(braindeath)
                .addGap(38, 38, 38)
                .addGroup(showDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewreport, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        mainpanel.add(showData, "card5");

        search.setBackground(new java.awt.Color(255, 255, 255));
        search.setMaximumSize(new java.awt.Dimension(1176, 670));
        search.setMinimumSize(new java.awt.Dimension(1176, 670));
        search.setPreferredSize(new java.awt.Dimension(1176, 670));

        exit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icusystem/icons8_Cancel_25px_2.png"))); // NOI18N
        exit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        jLabel55.setText("Incidence of Delirium.");

        deliriumSearch.setText("Search By");
        deliriumSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliriumSearchActionPerformed(evt);
            }
        });

        jLabel64.setText("Incidence of CLABSI.");

        clabsiSearch.setText("Search By");
        clabsiSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clabsiSearchActionPerformed(evt);
            }
        });

        brainSearch.setText("Search By");
        brainSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brainSearchActionPerformed(evt);
            }
        });

        jLabel66.setText("Incidence of brain death");

        jLabel62.setText("Incidence of Self Extubation.");

        selfExtubationSearch.setText("Search By");
        selfExtubationSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selfExtubationSearchActionPerformed(evt);
            }
        });

        jLabel67.setText("Incidence of ReIntubation.");

        reItubationSearch.setText("Search By");
        reItubationSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reItubationSearchActionPerformed(evt);
            }
        });

        jLabel68.setText("Diagnosis.");

        DiagnosisSearch.setText("Search By");
        DiagnosisSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiagnosisSearchActionPerformed(evt);
            }
        });

        jLabel70.setText("Incidence and Cause of Readdmission.");

        reAdmissionSearch.setText("Search By");
        reAdmissionSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reAdmissionSearchActionPerformed(evt);
            }
        });

        reAdmissionSearch1.setText("Search By");
        reAdmissionSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reAdmissionSearch1ActionPerformed(evt);
            }
        });

        jLabel75.setText("Admitted Type.");

        ETTSearch.setText("Search By");
        ETTSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ETTSearchActionPerformed(evt);
            }
        });

        jLabel76.setText("ETT Cuff pressure.");

        pctSearch.setText("Search By");
        pctSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pctSearchActionPerformed(evt);
            }
        });

        jLabel77.setText("PCT.");

        surgerySearch.setText("Search By");
        surgerySearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surgerySearchActionPerformed(evt);
            }
        });

        jLabel78.setText("Surgery.");

        airwaySearch.setText("Search By");
        airwaySearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airwaySearchActionPerformed(evt);
            }
        });

        jLabel79.setText("Airway.");

        airwaySearch1.setText("Search By");
        airwaySearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airwaySearch1ActionPerformed(evt);
            }
        });

        jLabel80.setText("Diagnosis in Mechanically Ventilated paitents.");

        ETTSearch1.setText("Search By");
        ETTSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ETTSearch1ActionPerformed(evt);
            }
        });

        jLabel81.setText("colomycin induced in nephrotoxicity.");

        jLabel82.setText("In Hospital Cardiac Arrest admitted from ER.");

        cardiacSearch.setText("Search By");
        cardiacSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardiacSearchActionPerformed(evt);
            }
        });

        tlcSearch.setText("Search By");
        tlcSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tlcSearchActionPerformed(evt);
            }
        });

        jLabel83.setText("who donot show rise in TLC value.");

        jLabel84.setText("Incidence of VAP with evacuation lumen ETT.");

        vapSearch.setText("Search By");
        vapSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vapSearchActionPerformed(evt);
            }
        });

        update_patient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hospital No", "Sex", "Age", "Diagnosis"
            }
        ));
        update_patient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                update_patientMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(update_patient);

        jLabel92.setText("Hospital no.");

        HospNoSearch.setText("Search By");
        HospNoSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HospNoSearchActionPerformed(evt);
            }
        });

        jButton3.setText("Delete A Record");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchLayout = new javax.swing.GroupLayout(search);
        search.setLayout(searchLayout);
        searchLayout.setHorizontalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchLayout.createSequentialGroup()
                        .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(searchLayout.createSequentialGroup()
                                .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(airwaySearch1)
                                    .addComponent(clabsiSearch, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                                .addGap(8, 8, 8))
                            .addGroup(searchLayout.createSequentialGroup()
                                .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(brainSearch, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(selfExtubationSearch)
                                    .addComponent(reItubationSearch)
                                    .addComponent(deliriumSearch)
                                    .addComponent(reAdmissionSearch)
                                    .addComponent(vapSearch)
                                    .addComponent(reAdmissionSearch1)
                                    .addComponent(ETTSearch)
                                    .addComponent(ETTSearch1)
                                    .addComponent(pctSearch)
                                    .addComponent(surgerySearch)
                                    .addComponent(airwaySearch)
                                    .addComponent(cardiacSearch)
                                    .addComponent(tlcSearch))
                                .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(searchLayout.createSequentialGroup()
                                        .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(searchLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(searchLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(searchLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(searchLayout.createSequentialGroup()
                        .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(searchLayout.createSequentialGroup()
                                .addComponent(HospNoSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(searchLayout.createSequentialGroup()
                                .addComponent(DiagnosisSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exit1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchLayout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addContainerGap())))
        );
        searchLayout.setVerticalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchLayout.createSequentialGroup()
                .addComponent(exit1)
                .addGap(12, 12, 12)
                .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HospNoSearch)
                    .addGroup(searchLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel92)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DiagnosisSearch)
                    .addGroup(searchLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel68)))
                .addGap(1, 1, 1)
                .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(searchLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(airwaySearch1)
                            .addComponent(jLabel80))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clabsiSearch)
                            .addComponent(jLabel64))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(brainSearch)
                            .addComponent(jLabel66))
                        .addGap(11, 11, 11)
                        .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(searchLayout.createSequentialGroup()
                                .addComponent(selfExtubationSearch)
                                .addGap(6, 6, 6)
                                .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(reItubationSearch)
                                    .addComponent(jLabel67)))
                            .addComponent(jLabel62))
                        .addGap(6, 6, 6)
                        .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deliriumSearch)
                            .addComponent(jLabel55))
                        .addGap(6, 6, 6)
                        .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reAdmissionSearch)
                            .addComponent(jLabel70))
                        .addGap(6, 6, 6)
                        .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(vapSearch)
                            .addComponent(jLabel84))
                        .addGap(6, 6, 6)
                        .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reAdmissionSearch1)
                            .addComponent(jLabel75))
                        .addGap(6, 6, 6)
                        .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ETTSearch)
                            .addComponent(jLabel76))
                        .addGap(1, 1, 1)
                        .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ETTSearch1)
                            .addComponent(jLabel81))
                        .addGap(2, 2, 2)
                        .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pctSearch)
                            .addComponent(jLabel77))
                        .addGap(0, 0, 0)
                        .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(surgerySearch)
                            .addComponent(jLabel78))
                        .addGap(6, 6, 6)
                        .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(airwaySearch)
                            .addComponent(jLabel79))
                        .addGap(6, 6, 6)
                        .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cardiacSearch)
                            .addComponent(jLabel82))
                        .addGap(6, 6, 6)
                        .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tlcSearch)
                            .addComponent(jLabel83))))
                .addGap(14, 14, 14)
                .addComponent(jButton3)
                .addContainerGap())
        );

        mainpanel.add(search, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_1MouseClicked
        // TODO add your handling code here:
        setColor(btn_1);
        ind_1.setOpaque(true);
        reset(btn_2);
        reset(btn_3);
        reset(btn_5);
        resetIndicator(ind_2);
        resetIndicator(ind_3);
        resetIndicator(ind_5);
        //Remove panels
        mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();
        //Add panels
        mainpanel.add(addpatient);
        mainpanel.repaint();
        mainpanel.revalidate();
    }//GEN-LAST:event_btn_1MouseClicked

    private void btn_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_2MouseClicked
        // TODO add your handling code here:
        conn = ICUsystem.getconnection();
        setColor(btn_2);
        ind_2.setOpaque(true);
        reset(btn_1);
        reset(btn_3);
        reset(btn_5);
        resetIndicator(ind_1);
        resetIndicator(ind_3);
        resetIndicator(ind_5);
        try{
        String sql ="Select * from patientinfo";
        PreparedStatement ps=conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);
        Object[] row = new Object[4];
        
            DefaultTableModel model1= (DefaultTableModel) update_patient.getModel();
            model1.setRowCount(0);
            while(rs.next()){
            
            row[0]=rs.getString("hospno");
            row[1]=rs.getString("sex");
            row[2]=rs.getInt("age");
            row[3]=rs.getString("pdiagnosis");
            model1.addRow(row);
            
            }
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);   
        }
        
        //Remove panels
        mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();
        //Add panels
        mainpanel.add(search);
        mainpanel.repaint();
        mainpanel.revalidate();
        
    }//GEN-LAST:event_btn_2MouseClicked

    private void btn_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_3MouseClicked
        // TODO add your handling code here:
        setColor(btn_3);
        ind_3.setOpaque(true);
        reset(btn_2);
        reset(btn_1);
        reset(btn_5);
        resetIndicator(ind_2);
        resetIndicator(ind_1);
        resetIndicator(ind_5);
        //Remove panels
        mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();
        //Add panels
        mainpanel.add(printreport);
        mainpanel.repaint();
        mainpanel.revalidate();
        btn_3.setEnabled(false);
    }//GEN-LAST:event_btn_3MouseClicked

    private void btn_5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_5MouseClicked
        // TODO add your handling code here:
        setColor(btn_5);
        ind_5.setOpaque(true);
        reset(btn_1);
        reset(btn_3);
        reset(btn_2);
        resetIndicator(ind_2);
        resetIndicator(ind_3);
        resetIndicator(ind_1);
        //Remove panels
        mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();
        //Add panels
        mainpanel.add(calculator);
        mainpanel.repaint();
        mainpanel.revalidate();
        btn_5.setEnabled(false);
        
    }//GEN-LAST:event_btn_5MouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitMouseClicked

 
    private void InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertActionPerformed
        // TODO add your handling code here:
        //typecasting
        String modeValue = mode.getSelectedItem().toString();
        String crystalloidValue = crystalloid.getSelectedItem().toString();
        String colloidValue = colloid.getSelectedItem().toString();
        String deliriumValue = delirium.getSelectedItem().toString();
        String dvtpropylaxisValue = dvtpropylaxis.getSelectedItem().toString();
        String dialysisValue = dialysis.getSelectedItem().toString();
        String steriodsldValue = steriodsld.getSelectedItem().toString();
        String ventilateValue = ventilate.getSelectedItem().toString();
        String weaningValue = weaning.getSelectedItem().toString();
        String fluidbalanceValue = fluidBalance.getSelectedItem().toString();
        String ivFluidsValue = ivFluids.getSelectedItem().toString();
        String comlicatValue = complicat.getSelectedItem().toString();
        String routeValue = route.getSelectedItem().toString();
        String formula1Value = formula1.getSelectedItem().toString();
        String dopplrValue = dopplr.getSelectedItem().toString();
        String trachealValue = tracheal.getSelectedItem().toString();
        String bloodPeriphValue = bloodPeriph.getSelectedItem().toString();
        String urineValue = urine.getSelectedItem().toString();
        String csfValue = csf.getSelectedItem().toString();
        String peritonealValue = peritoneal.getSelectedItem().toString();
        String woundValue = wound.getSelectedItem().toString();
        String bloodCvpValue = bloodCvp.getSelectedItem().toString();
        String othersValue = others.getSelectedItem().toString(); 
        String pocusValue = pocus.getSelectedItem().toString();
        String vasopressorsValue=vasopressors.getSelectedItem().toString();
        String extub = extubniv.getSelectedItem().toString();
        String tpc= tpiece.getSelectedItem().toString();
        String aline = aLine.getSelectedItem().toString();
        conn = ICUsystem.getconnection();
        int daysVal = Integer.parseInt(days.getText());
        if(checkUpdateOrInsert == 0){
        String sql = "Insert into daywisecheckup(hospno,day,hr,sbp, dbp, map, temp ,rr,gcs,rass,delirium,painscore,ph,paco2,pao,flo2,hco3,baseexcess,urea,creatinine,na,k,cl,hb,hct,plateletes,wbc,ptinr,"
                + "fibrinog,ddimer,mg,po4,ca,caion,bilirubin,alt,ast,alkphos, ggt,amylase,lipase,albumen,ldh,cpk,trop1,bnp,lactate,pct,crp,bsrmin,bsrmax,spotUSodium,dvtpropylaxis,dialysis,vasopressors,norepinephrine"
                + ",dopamine,epinephrine,dobutamine,phenylephrine,steriodsld,ventilate, mode, vt, ps, peep, ppeak, pplat, cstat, ETTcuffpress,weaning, extubniv, tpiece,fluidBalance, urineOutput,otherlosses, outputTotal, "
                + "intakeTotal, balance, cumbalance,ivFluids, crystalloid,colloid, bloodPRCBS, plateletunit, ffps,complicat,cvpmin,cvpmax,Aline,dopplr,pocus,route,formula"
                + ",tracheal,bloodPeripheral,urine,csf,peritoneal,wound,bloodCvp,others,cal,Protein,Sofa,pbyf,PAO2,gradient,cryoppt) "
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
              pst  = conn.prepareStatement(sql);
              pst.setString(1, hospitalNo.getText());
              pst.setInt(2, daysVal);
          
            if ( hr.getText().equals("") ) {
            pst.setNull(3, Types.INTEGER);
            } else {
                pst.setInt(3,Integer.parseInt(hr.getText()));
            } 
              
              if ( sbp.getText().equals("") ) {
            pst.setNull(4, Types.INTEGER);
            } else {
                pst.setInt(4,Integer.parseInt(sbp.getText()));
            } 
            if ( dbp.getText().equals("") ) {
            pst.setNull(5, Types.INTEGER);
            } else {
                pst.setInt(5,Integer.parseInt(dbp.getText()));
            } 
            if ( map.getText().equals("") ) {
            pst.setNull(6, Types.INTEGER);
            } else {
                pst.setInt(6,Integer.parseInt(map.getText()));
            } 
            if ( temp.getText().equals("") ) {
            pst.setNull(7, Types.INTEGER);
            } else {
                pst.setInt(7,Integer.parseInt(temp.getText()));
            }
            
            if ( rr.getText().equals("") ) {
            pst.setNull(8, Types.INTEGER);
            } else {
                pst.setInt(8,Integer.parseInt(rr.getText()));
            }
            
            if ( gcs.getText().equals("") ) {
            pst.setNull(9, Types.INTEGER);
            } else {
                pst.setInt(9,Integer.parseInt(gcs.getText()));
            }
            if ( rass.getText().equals("") ) {
            pst.setNull(10, Types.INTEGER);
            } else {
                pst.setInt(10,Integer.parseInt(rass.getText()));
            }
            pst.setString(11,deliriumValue);
         
            if ( painscore.getText().equals("") ) {
            pst.setNull(12, Types.INTEGER);
            } else {
                pst.setInt(12,Integer.parseInt(painscore.getText()));
            }
            if ( ph.getText().equals("") ) {
            pst.setNull(13, Types.INTEGER);
            } else {
                pst.setDouble(13,Double.parseDouble(ph.getText()));
            }
            if ( paco2.getText().equals("") ) {
            pst.setNull(14, Types.INTEGER);
            } else {
                pst.setInt(14,Integer.parseInt(paco2.getText()));
            }
            if ( pao.getText().equals("") ) {
            pst.setNull(15, Types.INTEGER);
            } else {
                pst.setInt(15,Integer.parseInt(pao.getText()));
            }
            if ( flo2.getText().equals("") ) {
            pst.setNull(16, Types.DOUBLE);
            } else {
                pst.setDouble(16,Double.parseDouble(flo2.getText()));
            }
            if ( hco3.getText().equals("") ) {
            pst.setNull(17, Types.INTEGER);
            } else {
                pst.setInt(17,Integer.parseInt(hco3.getText()));
            }
            if ( baseexcess.getText().equals("") ) {
            pst.setNull(18, Types.DOUBLE);
            } else {
                pst.setDouble(18,Double.parseDouble(baseexcess.getText()));
            }
            if ( urea.getText().equals("") ) {
            pst.setNull(19, Types.INTEGER);
            } else {
                pst.setInt(19,Integer.parseInt(urea.getText()));
            }
            if ( creatinine.getText().equals("") ) {
            pst.setNull(20, Types.DOUBLE);
            } else {
                pst.setDouble(20,Double.parseDouble(creatinine.getText()));
            }
            if ( na.getText().equals("") ) {
            pst.setNull(21, Types.INTEGER);
            } else {
                pst.setInt(21,Integer.parseInt(na.getText()));
            }
            if ( k.getText().equals("") ) {
            pst.setNull(22, Types.DOUBLE);
            } else {
                pst.setDouble(22,Double.parseDouble(k.getText()));
            }
            if ( cl.getText().equals("") ) {
            pst.setNull(23, Types.INTEGER);
            } else {
                pst.setInt(23,Integer.parseInt(cl.getText()));
            }
            if ( hb.getText().equals("") ) {
            pst.setNull(24, Types.DOUBLE);
            } else {
                pst.setDouble(24,Double.parseDouble(hb.getText()));
            }
            if ( hct.getText().equals("") ) {
            pst.setNull(25, Types.INTEGER);
            } else {
                pst.setInt(25,Integer.parseInt(hct.getText()));
            }
            if ( plateletes.getText().equals("") ) {
            pst.setNull(26, Types.DOUBLE);
            } else {
                pst.setDouble(26,Double.parseDouble(plateletes.getText()));
            }
            if ( wbc.getText().equals("") ) {
            pst.setNull(27, Types.DOUBLE);
            } else {
                pst.setDouble(27,Double.parseDouble(wbc.getText()));
            }
            if ( ptinr.getText().equals("") ) {
            pst.setNull(28, Types.DOUBLE);
            } else {
                pst.setDouble(28,Double.parseDouble(ptinr.getText()));
            }
            if ( fibrinog.getText().equals("") ) {
            pst.setNull(29, Types.INTEGER);
            } else {
                pst.setInt(29,Integer.parseInt(fibrinog.getText()));
            }
            if ( ddimer.getText().equals("") ) {
            pst.setNull(30, Types.DOUBLE);
            } else {
                pst.setDouble(30,Double.parseDouble(ddimer.getText()));
            }
            if ( mg.getText().equals("") ) {
            pst.setNull(31, Types.DOUBLE);
            } else {
                pst.setDouble(31,Double.parseDouble(mg.getText()));
            } 
            if ( po4.getText().equals("") ) {
            pst.setNull(32, Types.DOUBLE);
            } else {
                pst.setDouble(32,Double.parseDouble(po4.getText()));
            }
            if ( ca.getText().equals("") ) {
            pst.setNull(33, Types.DOUBLE);
            } else {
                pst.setDouble(33,Double.parseDouble(ca.getText()));
            }
            if ( caion.getText().equals("") ) {
            pst.setNull(34, Types.INTEGER);
            } else {
                pst.setInt(34,Integer.parseInt(caion.getText()));
            }
            if ( bilrubin.getText().equals("") ) {
            pst.setNull(35, Types.DOUBLE);
            } else {
                pst.setDouble(35,Double.parseDouble(bilrubin.getText()));
            }
            if ( alt.getText().equals("") ) {
            pst.setNull(36, Types.INTEGER);
            } else {
                pst.setInt(36,Integer.parseInt(alt.getText()));
            }
            
            if ( ast.getText().equals("") ) {
            pst.setNull(37, Types.INTEGER);
            } else {
                pst.setInt(37,Integer.parseInt(ast.getText()));
            }
            if ( alkphos.getText().equals("") ) {
            pst.setNull(38, Types.INTEGER);
            } else {
                pst.setInt(38,Integer.parseInt(alkphos.getText()));
            }
            if ( ggt.getText().equals("") ) {
            pst.setNull(39, Types.INTEGER);
            } else {
                pst.setInt(39,Integer.parseInt(ggt.getText()));
            }
            
            if ( amylase.getText().equals("") ) {
            pst.setNull(40, Types.INTEGER);
            } else {
                pst.setInt(40,Integer.parseInt(amylase.getText()));
            }
            
            if ( lipase.getText().equals("") ) {
            pst.setNull(41, Types.INTEGER);
            } else {
                pst.setInt(41,Integer.parseInt(lipase.getText()));
            }
            if ( albumen.getText().equals("") ) {
            pst.setNull(42, Types.INTEGER);
            } else {
                pst.setInt(42,Integer.parseInt(albumen.getText()));
            }
            if ( ldh.getText().equals("") ) {
            pst.setNull(43, Types.INTEGER);
            } else {
                pst.setInt(43,Integer.parseInt(ldh.getText()));
            }
            
            if ( cpk.getText().equals("") ) {
            pst.setNull(44, Types.INTEGER);
            } else {
                pst.setInt(44,Integer.parseInt(cpk.getText()));
            }
            if ( trop1.getText().equals("") ) {
            pst.setNull(45, Types.INTEGER);
            } else {
                pst.setInt(45,Integer.parseInt(trop1.getText()));
            }
            
            if ( bnp.getText().equals("") ) {
            pst.setNull(46, Types.INTEGER);
            } else {
                pst.setInt(46,Integer.parseInt(bnp.getText()));
            }
            if ( lactate.getText().equals("") ) {
            pst.setNull(47, Types.INTEGER);
            } else {
                pst.setInt(47,Integer.parseInt(lactate.getText()));
            }
            if ( pct.getText().equals("") ) {
            pst.setNull(48, Types.DOUBLE);
            } else {
                pst.setDouble(48,Double.parseDouble(pct.getText()));
            }
            if ( crp.getText().equals("") ) {
            pst.setNull(49, Types.INTEGER);
            } else {
                pst.setInt(49,Integer.parseInt(crp.getText()));
            }
            if ( bsrmin.getText().equals("") ) {
            pst.setNull(50, Types.INTEGER);
            } else {
                pst.setInt(50,Integer.parseInt(bsrmin.getText()));
            }
            if ( bsrmax.getText().equals("") ) {
            pst.setNull(51, Types.INTEGER);
            } else {
                pst.setInt(51,Integer.parseInt(bsrmax.getText()));
            }
            if ( spotUSodium.getText().equals("") ) {
            pst.setNull(52, Types.DOUBLE);
            } else {
                pst.setDouble(52,Double.parseDouble(spotUSodium.getText()));
            }
            
            pst.setString(53,dvtpropylaxisValue);
            pst.setString(54,dialysisValue);
            pst.setString(55,vasopressorsValue);
            if (norepinephrine.getText().equals("") ) {
            pst.setNull(56, Types.DOUBLE);
            } else {
                pst.setDouble(56,Double.parseDouble(norepinephrine.getText()));
            }
             if (dopamine.getText().equals("") ) {
            pst.setNull(57, Types.DOUBLE);
            } else {
                pst.setDouble(57,Double.parseDouble(dopamine.getText()));
            }
             if (epinephrine.getText().equals("") ) {
            pst.setNull(58, Types.DOUBLE);
            } else {
                pst.setDouble(58,Double.parseDouble(epinephrine.getText()));
            }
             if (dobutamine.getText().equals("") ) {
            pst.setNull(59, Types.DOUBLE);
            } else {
                pst.setDouble(59,Double.parseDouble(dobutamine.getText()));
            }
             if (phenylephrine.getText().equals("") ) {
            pst.setNull(60, Types.DOUBLE);
            } else {
                pst.setDouble(60,Double.parseDouble(phenylephrine.getText()));
            }
            pst.setString(61,steriodsldValue);
            pst.setString(62,ventilateValue);
            pst.setString(63,modeValue);
            
            
            if ( vt.getText().equals("") ) {
            pst.setNull(64, Types.DOUBLE);
            } else {
                pst.setDouble(64,Double.parseDouble(vt.getText()));
            }
            if ( ps.getText().equals("") ) {
            pst.setNull(65, Types.INTEGER);
            } else {
                pst.setInt(65,Integer.parseInt(ps.getText()));
            }
            
            if ( peep.getText().equals("") ) {
            pst.setNull(66, Types.INTEGER);
            } else {
                pst.setInt(66,Integer.parseInt(peep.getText()));
            }
            if ( ppeak.getText().equals("") ) {
            pst.setNull(67, Types.INTEGER);
            } else {
                pst.setInt(67,Integer.parseInt(ppeak.getText()));
            }
            if ( pplat.getText().equals("") ) {
            pst.setNull(68, Types.INTEGER);
            } else {
                pst.setInt(68,Integer.parseInt(pplat.getText()));
            }
            if ( cstat.getText().equals("") ) {
            pst.setNull(69, Types.INTEGER);
            } else {
                pst.setInt(69,Integer.parseInt(cstat.getText()));
            }
            if ( ETTcuffpress.getText().equals("") ) {
            pst.setNull(70, Types.INTEGER);
            } else {
                pst.setInt(70,Integer.parseInt(ETTcuffpress.getText()));
            }
            pst.setString(71,weaningValue);
            pst.setString(72,extub);
            pst.setString(73,tpc);
            pst.setString(74,fluidbalanceValue);
         
            
            if (urineOutput.getText().equals("") ) {
            pst.setNull(75, Types.INTEGER);
            } else {
                pst.setInt(75,Integer.parseInt(urineOutput.getText()));
            }
            if ( otherLosses.getText().equals("") ) {
            pst.setNull(76, Types.INTEGER);
            } else {
                pst.setInt(76,Integer.parseInt(otherLosses.getText()));
            }
            if ( outputTotal.getText().equals("") ) {
            pst.setNull(77, Types.INTEGER);
            } else {
                pst.setInt(77,Integer.parseInt(outputTotal.getText()));
            }
            if ( intakeTotal.getText().equals("") ) {
            pst.setNull(78, Types.INTEGER);
            } else {
                pst.setInt(78,Integer.parseInt(intakeTotal.getText()));
            }
            if ( balance.getText().equals("") ) {
            pst.setNull(79, Types.INTEGER);
            } else {
                pst.setInt(79,Integer.parseInt(balance.getText()));
            }
            if ( cumBalance.getText().equals("") ) {
            pst.setNull(80, Types.INTEGER);
            } else {
                pst.setInt(80,Integer.parseInt(cumBalance.getText()));
            }
             pst.setString(81,ivFluidsValue);
             pst.setString(82,crystalloidValue);
            pst.setString(83,colloidValue);
            if (bloodPRCBS.getText().equals("") ) {
            pst.setNull(84, Types.INTEGER);
            } else {
                pst.setInt(84,Integer.parseInt(bloodPRCBS.getText()));
            }
            if ( plateletunit.getText().equals("") ) {
            pst.setNull(85, Types.INTEGER);
            } else {
                pst.setInt(85,Integer.parseInt(plateletunit.getText()));
            }
            if ( ffps.getText().equals("") ) {
            pst.setNull(86, Types.INTEGER);
            } else {pst.setInt(86,Integer.parseInt(ffps.getText()));}
            pst.setString(87,comlicatValue);
            if ( cvpMin.getText().equals("") ) { pst.setNull(88, Types.INTEGER);}
            else {pst.setInt(88,Integer.parseInt(cvpMin.getText()));}
            if ( cvpMax.getText().equals("") ) {
            pst.setNull(89, Types.INTEGER);
            } else {
                pst.setInt(89,Integer.parseInt(cvpMax.getText()));
            }
            pst.setString(90,aline);
            pst.setString(91,dopplrValue);
            pst.setString(92,pocusValue);
            pst.setString(93,routeValue);
            pst.setString(94,formula1Value);
            pst.setString(95,trachealValue);
            pst.setString(96,bloodPeriphValue);
            pst.setString(97,urineValue);
            pst.setString(98,csfValue);
            pst.setString(99,peritonealValue);
            pst.setString(100,woundValue);
            pst.setString(101,bloodCvpValue);
            pst.setString(102,othersValue);
            
            if ( calorie.getText().equals("") ) {
            pst.setNull(103, Types.DOUBLE);
            } else {
                pst.setDouble(103,Double.parseDouble(calorie.getText()));
            }
            
            if ( protein.getText().equals("") ) {
            pst.setNull(104, Types.DOUBLE);
            } else {
                pst.setDouble(104,Double.parseDouble(protein.getText()));
            }
            if ( Sofa.getText().equals("") ) {
            pst.setNull(105, Types.INTEGER);
            } else {
                pst.setInt(105,Integer.parseInt(Sofa.getText()));
            }
            
            if ( pbyf.getText().equals("") ) {
            pst.setNull(106, Types.DOUBLE);
            } else {
                pst.setDouble(106,Double.parseDouble(pbyf.getText()));
            }
            if ( PAO2.getText().equals("") ) {
            pst.setNull(107, Types.DOUBLE);
            } else {
                pst.setDouble(107,Double.parseDouble(PAO2.getText()));
            }
             if (gradient.getText().equals("") ) {
            pst.setNull(108, Types.DOUBLE);
            } else {
                pst.setDouble(108,Double.parseDouble(gradient.getText()));
            }
             
            if ( cryoppt.getText().equals("") ) {
            pst.setNull(109, Types.INTEGER);
            } else {
                pst.setInt(109,Integer.parseInt(cryoppt.getText()));
            }    
            pst.execute();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);   
        }
        
    int listAddition = jListSelectAntibiotic.getModel().getSize();
    for (int i=0;i<listAddition;i++) {
        String option = jListSelectAntibiotic.getModel().getElementAt(i).toString();
                try{   
                String sqli = "Insert into patient_antibiotic_table(hospno,patient_antibiotic_value,day) values('"+hospitalNo.getText()+"','"+option+"','"+Integer.parseInt(days.getText())+"')";
                pst = conn.prepareStatement(sqli);
                pst.execute();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);}
    } 
    
    int listAddition1 = jListSelectTrach.getModel().getSize();
    for (int i=0;i<listAddition1;i++) {
        String option = jListSelectTrach.getModel().getElementAt(i).toString();
                try{   
                String name = "Tracheal";    
                String sqli = "Insert into org(hospno,org_value,org_name,day) values('"+hospitalNo.getText()+"','"+option+"','"+name+"','"+Integer.parseInt(days.getText())+"')";
                pst = conn.prepareStatement(sqli);
                pst.execute();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);}
    }
    
    int listAddition2 = jListSelectBperi.getModel().getSize();
    for (int i=0;i<listAddition2;i++) {
        String option = jListSelectBperi.getModel().getElementAt(i).toString();
                try{   
                String name = "Blood Peripheral";    
                String sqli = "Insert into org(hospno,org_value,org_name,day) values('"+hospitalNo.getText()+"','"+option+"','"+name+"','"+Integer.parseInt(days.getText())+"')";
                pst = conn.prepareStatement(sqli);
                pst.execute();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);}
    }
    
    int listAddition3 = jListSelectBcvp.getModel().getSize();
    for (int i=0;i<listAddition3;i++) {
        String option = jListSelectBcvp.getModel().getElementAt(i).toString();
                try{   
                String name = "Blood CVP"; 
                String sqli = "Insert into org(hospno,org_value,org_name,day) values('"+hospitalNo.getText()+"','"+option+"','"+name+"','"+Integer.parseInt(days.getText())+"')";
                pst = conn.prepareStatement(sqli);
                pst.execute();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);}
    }
    
    int listAddition4 = jListSelectUrine.getModel().getSize();
    for (int i=0;i<listAddition4;i++) {
        String option = jListSelectUrine.getModel().getElementAt(i).toString();
                try{   
                String name = "Urine";    
                String sqli = "Insert into org(hospno,org_value,org_name,day) values('"+hospitalNo.getText()+"','"+option+"','"+name+"','"+Integer.parseInt(days.getText())+"')";
                pst = conn.prepareStatement(sqli);
                pst.execute();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);}
    }
    
    int listAddition5 = jListSelectCsf.getModel().getSize();
    for (int i=0;i<listAddition5;i++) {
        String option = jListSelectCsf.getModel().getElementAt(i).toString();
                try{   
                String name = "CSF";    
                String sqli = "Insert into org(hospno,org_value,org_name,day) values('"+hospitalNo.getText()+"','"+option+"','"+name+"','"+Integer.parseInt(days.getText())+"')";
                pst = conn.prepareStatement(sqli);
                pst.execute();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);}
    }
    
    int listAddition6 = jListSelectPeri.getModel().getSize();
    for (int i=0;i<listAddition6;i++) {
        String option = jListSelectPeri.getModel().getElementAt(i).toString();
                try{   
                String name = "Peritoneal";    
                String sqli = "Insert into org(hospno,org_value,org_name,day) values('"+hospitalNo.getText()+"','"+option+"','"+name+"','"+Integer.parseInt(days.getText())+"')";
                pst = conn.prepareStatement(sqli);
                pst.execute();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);}
    }
    
    int listAddition7 = jListSelectWound.getModel().getSize();
    for (int i=0;i<listAddition7;i++) {
        String option = jListSelectWound.getModel().getElementAt(i).toString();
                try{   
                String name = "Wound";    
                String sqli = "Insert into org(hospno,org_value,org_name,day) values('"+hospitalNo.getText()+"','"+option+"','"+name+"','"+Integer.parseInt(days.getText())+"')";
                pst = conn.prepareStatement(sqli);
                pst.execute();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);}
    }
    
    try{   
                String name = "Others";    
                String sqli = "Insert into org(hospno,org_name,org_value,day) values('"+hospitalNo.getText()+"','"+name+"','"+jTextField1.getText()+"','"+Integer.parseInt(days.getText())+"')";
                pst = conn.prepareStatement(sqli);
                pst.execute();
              
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);}
    
    
    
    try{
        String sqlday="select max(day) from daywisecheckup where hospno='"+hospitalNo.getText()+"'";
        pst=conn.prepareStatement(sqlday);
        rs=pst.executeQuery(sqlday);
        while(rs.next()){int daycount = Integer.parseInt(rs.getString("max(day)"));
        daycount++;
        days.setText(String.valueOf(daycount));
        }
        }
       catch(Exception e){JOptionPane.showMessageDialog(null, e);}
       
       }
        
       if(checkUpdateOrInsert == 1){  
           
       int listCom = jListSelectAntibiotic.getModel().getSize();
        if(listCom == 0){}else{
        try{
            String sqldel="delete from patient_antibiotic_table where hospno='"+hospitalNo.getText()+"' and day = '"+days.getText()+"' ";
                   pst=conn.prepareStatement(sqldel);
                   pst.execute();}catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    
        for (int i=0;i<listCom;i++) {
        String option = jListSelectAntibiotic.getModel().getElementAt(i).toString();
                try{
                String sql1 = "Insert into patient_antibiotic_table(hospno,patient_antibiotic_value,day) values('"+hospitalNo.getText()+"','"+option+"','"+Integer.parseInt(days.getText())+"')";
                pst = conn.prepareStatement(sql1);
                pst.execute();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);}}
        } 
        
        int list1 = jListSelectTrach.getModel().getSize();
        if(list1 == 0){}else{
        try{
            String name1 = "Tracheal";
            String sqldel="delete from org where hospno='"+hospitalNo.getText()+"' and day = '"+days.getText()+"' and org_name = '"+name1+"' ";
            pst=conn.prepareStatement(sqldel);
            pst.execute();}catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    
        for (int i=0;i<list1;i++) {
        String option = jListSelectTrach.getModel().getElementAt(i).toString();
                try{
                String name1 = "Tracheal";
                String sql1 = "Insert into org(hospno,org_value,day,org_name) values('"+hospitalNo.getText()+"','"+option+"','"+Integer.parseInt(days.getText())+"', '"+name1+"')";
                pst = conn.prepareStatement(sql1);
                pst.execute();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);}}
        }
        
        int list2 = jListSelectBperi.getModel().getSize();
        if(list2 == 0){}else{
        try{
            String name1 = "Blood Peripheral";
            String sqldel="delete from org where hospno='"+hospitalNo.getText()+"' and day = '"+days.getText()+"' and org_name = '"+name1+"' ";
            pst=conn.prepareStatement(sqldel);
            pst.execute();}catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    
        for (int i=0;i<list2;i++) {
        String option = jListSelectBperi.getModel().getElementAt(i).toString();
                try{
                String name1 = "Blood Peripheral";
                String sql1 = "Insert into org(hospno,org_value,day,org_name) values('"+hospitalNo.getText()+"','"+option+"','"+Integer.parseInt(days.getText())+"', '"+name1+"')";
                pst = conn.prepareStatement(sql1);
                pst.execute();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);}}
        }
        
        
        
        int list3 = jListSelectBcvp.getModel().getSize();
        if(list3 == 0){}else{
        try{
            String name1 = "Blood CVP";
            String sqldel="delete from org where hospno='"+hospitalNo.getText()+"' and day = '"+days.getText()+"' and org_name = '"+name1+"' ";
            pst=conn.prepareStatement(sqldel);
            pst.execute();}catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    
        for (int i=0;i<list3;i++) {
        String option = jListSelectBcvp.getModel().getElementAt(i).toString();
                try{
                String name1 = "Blood CVP";
                String sql1 = "Insert into org(hospno,org_value,day,org_name) values('"+hospitalNo.getText()+"','"+option+"','"+Integer.parseInt(days.getText())+"', '"+name1+"')";
                pst = conn.prepareStatement(sql1);
                pst.execute();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);}}
        }
        
        
        int list4 = jListSelectUrine.getModel().getSize();
        if(list4 == 0){}else{
        try{
            String name1 = "Urine";
            String sqldel="delete from org where hospno='"+hospitalNo.getText()+"' and day = '"+days.getText()+"' and org_name = '"+name1+"' ";
            pst=conn.prepareStatement(sqldel);
            pst.execute();}catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    
        for (int i=0;i<list4;i++) {
        String option = jListSelectUrine.getModel().getElementAt(i).toString();
                try{
                String name1 = "Urine";
                String sql1 = "Insert into org(hospno,org_value,day,org_name) values('"+hospitalNo.getText()+"','"+option+"','"+Integer.parseInt(days.getText())+"', '"+name1+"')";
                pst = conn.prepareStatement(sql1);
                pst.execute();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);}}
        }
        
        int list5 = jListSelectCsf.getModel().getSize();
        if(list5 == 0){}else{
        try{
            String name1 = "CSF";
            String sqldel="delete from org where hospno='"+hospitalNo.getText()+"' and day = '"+days.getText()+"' and org_name = '"+name1+"' ";
            pst=conn.prepareStatement(sqldel);
            pst.execute();}catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    
        for (int i=0;i<list5;i++) {
        String option = jListSelectCsf.getModel().getElementAt(i).toString();
                try{
                String name1 = "CSF";
                String sql1 = "Insert into org(hospno,org_value,day,org_name) values('"+hospitalNo.getText()+"','"+option+"','"+Integer.parseInt(days.getText())+"', '"+name1+"')";
                pst = conn.prepareStatement(sql1);
                pst.execute();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);}}
        }
        
        
        int list6 = jListSelectPeri.getModel().getSize();
        if(list6 == 0){}else{
        try{
            String name1 = "Peritoneal";
            String sqldel="delete from org where hospno='"+hospitalNo.getText()+"' and day = '"+days.getText()+"' and org_name = '"+name1+"' ";
            pst=conn.prepareStatement(sqldel);
            pst.execute();}catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    
        for (int i=0;i<list6;i++) {
        String option = jListSelectPeri.getModel().getElementAt(i).toString();
                try{
                String name1 = "Peritoneal";
                String sql1 = "Insert into org(hospno,org_value,day,org_name) values('"+hospitalNo.getText()+"','"+option+"','"+Integer.parseInt(days.getText())+"', '"+name1+"')";
                pst = conn.prepareStatement(sql1);
                pst.execute();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);}}
        }
        
        int list7 = jListSelectWound.getModel().getSize();
        if(list7 == 0){}else{
        try{
            String name1 = "Wound";
            String sqldel="delete from org where hospno='"+hospitalNo.getText()+"' and day = '"+days.getText()+"' and org_name = '"+name1+"' ";
            pst=conn.prepareStatement(sqldel);
            pst.execute();}catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    
        for (int i=0;i<list7;i++) {
        String option = jListSelectWound.getModel().getElementAt(i).toString();
                try{
                String name1 = "Wound";
                String sql1 = "Insert into org(hospno,org_value,day,org_name) values('"+hospitalNo.getText()+"','"+option+"','"+Integer.parseInt(days.getText())+"', '"+name1+"')";
                pst = conn.prepareStatement(sql1);
                pst.execute();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);}}
        }
        
        
    ///       
    try{    
        
        String sql = "UPDATE daywisecheckup SET hr =?,sbp=?, dbp=?, map=?, temp=? ,rr=?,gcs=?,rass=?,delirium=?,painscore=?,ph=?,paco2=?,pao=?,flo2=?,hco3=?,baseexcess=?,urea=?,creatinine=?,na=?,k=?,cl=?,hb=?,hct=?,plateletes=?,wbc=?,ptinr=?,"
                + "fibrinog=?,ddimer=?,mg=?,po4=?,ca=?,caion=?,bilirubin=?,alt=?,ast=?,alkphos=?, ggt=?,amylase=?,lipase=?,albumen=?,ldh=?,cpk=?,trop1=?,bnp=?,lactate=?,pct=?,crp=?,bsrmin=?,bsrmax=?,spotUSodium=?,dvtpropylaxis=?,dialysis=?,vasopressors=?,norepinephrine=?"
                + ",dopamine=?,epinephrine=?,dobutamine=?,phenylephrine=?,steriodsld=?,ventilate=?, mode=?, vt=?, ps=?, peep=?, ppeak=?, pplat=?, cstat=?, ETTcuffpress=?,weaning=?, extubniv=?, tpiece=?,fluidBalance=?, urineOutput=?,otherlosses=?, outputTotal=?, "
                + "intakeTotal=?, balance=?, cumbalance=?,ivFluids=?, crystalloid=?,colloid=?, bloodPRCBS=?, plateletunit=?, ffps=?,complicat=?,cvpmin=?,cvpmax=?,Aline=?,dopplr=?,pocus=?,route=?,formula=?"
                + ",tracheal=?,bloodPeripheral=?,urine=?,csf=?,peritoneal=?,wound=?,bloodCvp=?,others=?,cal=?,Protein=?,Sofa =?,pbyf=?,PAO2=?,gradient=?,cryoppt = ? WHERE (hospno = '"+(hospitalNo.getText())+"' and day = '"+daysVal+"');";
              pst  = conn.prepareStatement(sql);
            if ( hr.getText().equals("") ) {
            pst.setNull(1, Types.INTEGER);
            } else {
                pst.setInt(1,Integer.parseInt(hr.getText()));
            } 
              
              if ( sbp.getText().equals("") ) {
            pst.setNull(2, Types.INTEGER);
            } else {
                pst.setInt(2,Integer.parseInt(sbp.getText()));
            } 
            if ( dbp.getText().equals("") ) {
            pst.setNull(3, Types.INTEGER);
            } else {
                pst.setInt(3,Integer.parseInt(dbp.getText()));
            } 
            if ( map.getText().equals("") ) {
            pst.setNull(4, Types.INTEGER);
            } else {
                pst.setInt(4,Integer.parseInt(map.getText()));
            } 
            if ( temp.getText().equals("") ) {
            pst.setNull(5, Types.INTEGER);
            } else {
                pst.setInt(5,Integer.parseInt(temp.getText()));
            }
            
            if ( rr.getText().equals("") ) {
            pst.setNull(6, Types.INTEGER);
            } else {
                pst.setInt(6,Integer.parseInt(rr.getText()));
            }
            
            if ( gcs.getText().equals("") ) {
            pst.setNull(7, Types.INTEGER);
            } else {
                pst.setInt(7,Integer.parseInt(gcs.getText()));
            }
            if ( rass.getText().equals("") ) {
            pst.setNull(8, Types.INTEGER);
            } else {
                pst.setInt(8,Integer.parseInt(rass.getText()));
            }
            pst.setString(9,deliriumValue);
         
            if ( painscore.getText().equals("") ) {
            pst.setNull(10, Types.INTEGER);
            } else {
                pst.setInt(10,Integer.parseInt(painscore.getText()));
            }
            if ( ph.getText().equals("") ) {
            pst.setNull(11, Types.DOUBLE);
            } else {
                pst.setDouble(11,Double.parseDouble(ph.getText()));
            }
            if ( paco2.getText().equals("") ) {
            pst.setNull(12, Types.INTEGER);
            } else {
                pst.setInt(12,Integer.parseInt(paco2.getText()));
            }
            if ( pao.getText().equals("") ) {
            pst.setNull(13, Types.INTEGER);
            } else {
                pst.setInt(13,Integer.parseInt(pao.getText()));
            }
            if ( flo2.getText().equals("") ) {
            pst.setNull(14, Types.DOUBLE);
            } else {
                pst.setDouble(14,Double.parseDouble(flo2.getText()));
            }
            if ( hco3.getText().equals("") ) {
            pst.setNull(15, Types.INTEGER);
            } else {
                pst.setInt(15,Integer.parseInt(hco3.getText()));
            }
            if ( baseexcess.getText().equals("") ) {
            pst.setNull(16, Types.DOUBLE);
            } else {
                pst.setDouble(16,Double.parseDouble(baseexcess.getText()));
            }
            if ( urea.getText().equals("") ) {
            pst.setNull(17, Types.INTEGER);
            } else {
                pst.setInt(17,Integer.parseInt(urea.getText()));
            }
            if ( creatinine.getText().equals("") ) {
            pst.setNull(18, Types.DOUBLE);
            } else {
                pst.setDouble(18,Double.parseDouble(creatinine.getText()));
            }
            if ( na.getText().equals("") ) {
            pst.setNull(19, Types.INTEGER);
            } else {
                pst.setInt(19,Integer.parseInt(na.getText()));
            }
            if ( k.getText().equals("") ) {
            pst.setNull(20, Types.DOUBLE);
            } else {
                pst.setDouble(20,Double.parseDouble(k.getText()));
            }
            if ( cl.getText().equals("") ) {
            pst.setNull(21, Types.INTEGER);
            } else {
                pst.setInt(21,Integer.parseInt(cl.getText()));
            }
            if ( hb.getText().equals("") ) {
            pst.setNull(22, Types.DOUBLE);
            } else {
                pst.setDouble(22,Double.parseDouble(hb.getText()));
            }
            if ( hct.getText().equals("") ) {
            pst.setNull(23, Types.DOUBLE);
            } else {
                pst.setDouble(23,Double.parseDouble(hct.getText()));
            }
            if ( plateletes.getText().equals("") ) {
            pst.setNull(24, Types.DOUBLE);
            } else {
                pst.setDouble(24,Double.parseDouble(plateletes.getText()));
            }
            if ( wbc.getText().equals("") ) {
            pst.setNull(25, Types.DOUBLE);
            } else {
                pst.setDouble(25,Double.parseDouble(wbc.getText()));
            }
            if ( ptinr.getText().equals("") ) {
            pst.setNull(26, Types.DOUBLE);
            } else {
                pst.setDouble(26,Double.parseDouble(ptinr.getText()));
            }
            if ( fibrinog.getText().equals("") ) {
            pst.setNull(27, Types.DOUBLE);
            } else {
                pst.setDouble(27,Double.parseDouble(fibrinog.getText()));
            }
            if ( ddimer.getText().equals("") ) {
            pst.setNull(28, Types.DOUBLE);
            } else {
                pst.setDouble(28,Double.parseDouble(ddimer.getText()));
            }
            if ( mg.getText().equals("") ) {
            pst.setNull(29, Types.DOUBLE);
            } else {
                pst.setDouble(29,Double.parseDouble(mg.getText()));
            } 
            if ( po4.getText().equals("") ) {
            pst.setNull(30, Types.DOUBLE);
            } else {
                pst.setDouble(30,Double.parseDouble(po4.getText()));
            }
            if ( ca.getText().equals("") ) {
            pst.setNull(31, Types.DOUBLE);
            } else{ 
                pst.setDouble(31,Double.parseDouble(ca.getText()));
            }
            if ( caion.getText().equals("") ) {
            pst.setNull(32, Types.DOUBLE);
            } else {
                pst.setDouble(32,Double.parseDouble(caion.getText()));
            }
            if ( bilrubin.getText().equals("") ) {
            pst.setNull(33, Types.DOUBLE);
            } else {
                pst.setDouble(33,Double.parseDouble(bilrubin.getText()));
            }
            if ( alt.getText().equals("") ) {
            pst.setNull(34, Types.INTEGER);
            } else {
                pst.setInt(34,Integer.parseInt(alt.getText()));
            }
            
            if ( ast.getText().equals("") ) {
            pst.setNull(35, Types.INTEGER);
            } else {
                pst.setInt(35,Integer.parseInt(ast.getText()));
            }
            if ( alkphos.getText().equals("") ) {
            pst.setNull(36, Types.INTEGER);
            } else {
                pst.setInt(36,Integer.parseInt(alkphos.getText()));
            }
            if ( ggt.getText().equals("") ) {
            pst.setNull(37, Types.INTEGER);
            } else {
                pst.setInt(37,Integer.parseInt(ggt.getText()));
            }
            if ( amylase.getText().equals("") ) {
            pst.setNull(38, Types.INTEGER);
            } else {
                pst.setInt(38,Integer.parseInt(amylase.getText()));
            }
            
            if ( lipase.getText().equals("") ) {
            pst.setNull(39, Types.INTEGER);
            } else {
                pst.setInt(39,Integer.parseInt(lipase.getText()));
            }
            if ( albumen.getText().equals("") ) {
            pst.setNull(40, Types.DOUBLE);
            } else {
                pst.setDouble(40,Double.parseDouble(albumen.getText()));
            }
            if ( ldh.getText().equals("") ) {
            pst.setNull(41, Types.INTEGER);
            } else {
                pst.setInt(41,Integer.parseInt(ldh.getText()));
            }
            
            if ( cpk.getText().equals("") ) {
            pst.setNull(42, Types.INTEGER);
            } else {
                pst.setInt(42,Integer.parseInt(cpk.getText()));
            }
            
        if ( trop1.getText().equals("") ) {
            pst.setNull(43, Types.DOUBLE);
            } else {
                pst.setDouble(43,Double.parseDouble(trop1.getText()));
            }
            
            if ( bnp.getText().equals("") ) {
            pst.setNull(44, Types.INTEGER);
            } else {
                pst.setInt(44,Integer.parseInt(bnp.getText()));
            }
            if ( lactate.getText().equals("") ) {
            pst.setNull(45, Types.DOUBLE);
            } else {
                pst.setDouble(45,Double.parseDouble(lactate.getText()));
            }
            if ( pct.getText().equals("") ) {
            pst.setNull(46, Types.DOUBLE);
            } else {
                pst.setDouble(46,Double.parseDouble(pct.getText()));
            }
            if ( crp.getText().equals("") ) {
            pst.setNull(47, Types.DOUBLE);
            } else {
                pst.setDouble(47,Double.parseDouble(crp.getText()));
            }
            if ( bsrmin.getText().equals("") ) {
            pst.setNull(48, Types.INTEGER);
            } else {
                pst.setInt(48,Integer.parseInt(bsrmin.getText()));
            }
            if ( bsrmax.getText().equals("") ) {
            pst.setNull(49, Types.INTEGER);
            } else {
                pst.setInt(49,Integer.parseInt(bsrmax.getText()));
            }
            if ( spotUSodium.getText().equals("") ) {
            pst.setNull(50, Types.DOUBLE);
            } else {
                pst.setDouble(50,Double.parseDouble(spotUSodium.getText()));
            }
            
            pst.setString(51,dvtpropylaxisValue);
            pst.setString(52,dialysisValue);
            pst.setString(53,vasopressorsValue);
            if (norepinephrine.getText().equals("") ) {
            pst.setNull(54, Types.DOUBLE);
            } else {
                pst.setDouble(54,Double.parseDouble(norepinephrine.getText()));
            }
             if (dopamine.getText().equals("") ) {
            pst.setNull(55, Types.DOUBLE);
            } else {
                pst.setDouble(55,Double.parseDouble(dopamine.getText()));
            }
             if (epinephrine.getText().equals("") ) {
            pst.setNull(56, Types.DOUBLE);
            } else {
                pst.setDouble(56,Double.parseDouble(epinephrine.getText()));
            }
             if (dobutamine.getText().equals("") ) {
            pst.setNull(57, Types.DOUBLE);
            } else {
                pst.setDouble(57,Double.parseDouble(dobutamine.getText()));
            }
             if (phenylephrine.getText().equals("") ) {
            pst.setNull(58, Types.DOUBLE);
            } else {
                pst.setDouble(58,Double.parseDouble(phenylephrine.getText()));
            }
            pst.setString(59,steriodsldValue);
            pst.setString(60,ventilateValue);
            pst.setString(61,modeValue);
            if ( vt.getText().equals("") ) {
            pst.setNull(62, Types.DOUBLE);
            } else {
                pst.setDouble(62,Double.parseDouble(vt.getText()));
            }
            if ( ps.getText().equals("") ) {
            pst.setNull(63, Types.INTEGER);
            } else {
                pst.setInt(63,Integer.parseInt(ps.getText()));
            }
            
            if ( peep.getText().equals("") ) {
            pst.setNull(64, Types.INTEGER);
            } else {
                pst.setInt(64,Integer.parseInt(peep.getText()));
            }
            if ( ppeak.getText().equals("") ) {
            pst.setNull(65, Types.INTEGER);
            } else {
                pst.setInt(65,Integer.parseInt(ppeak.getText()));
            }
            if ( pplat.getText().equals("") ) {
            pst.setNull(66, Types.INTEGER);
            } else {
                pst.setInt(66,Integer.parseInt(pplat.getText()));
            }
            if ( cstat.getText().equals("") ) {
            pst.setNull(67, Types.INTEGER);
            } else {
                pst.setInt(67,Integer.parseInt(cstat.getText()));
            }
            if ( ETTcuffpress.getText().equals("") ) {
            pst.setNull(68, Types.INTEGER);
            } else {
                pst.setInt(68,Integer.parseInt(ETTcuffpress.getText()));
            }
            pst.setString(69,weaningValue);
            
            pst.setString(70,extub);
            pst.setString(71,tpc);
            pst.setString(72,fluidbalanceValue);
            
            if (urineOutput.getText().equals("") ) {
            pst.setNull(73, Types.INTEGER);
            } else {
                pst.setInt(73,Integer.parseInt(urineOutput.getText()));
            }
            if ( otherLosses.getText().equals("") ) {
            pst.setNull(74, Types.INTEGER);
            } else {
                pst.setInt(74,Integer.parseInt(otherLosses.getText()));
            }
            if ( outputTotal.getText().equals("") ) {
            pst.setNull(75, Types.INTEGER);
            } else {
                pst.setInt(75,Integer.parseInt(outputTotal.getText()));
            }
            if ( intakeTotal.getText().equals("") ) {
            pst.setNull(76, Types.INTEGER);
            } else {
                pst.setInt(76,Integer.parseInt(intakeTotal.getText()));
            }
            if ( balance.getText().equals("") ) {
            pst.setNull(77, Types.INTEGER);
            } else {
                pst.setInt(77,Integer.parseInt(balance.getText()));
            }
            if ( cumBalance.getText().equals("") ) {
            pst.setNull(78, Types.INTEGER);
            } else {
                pst.setInt(78,Integer.parseInt(cumBalance.getText()));
            }
             pst.setString(79,ivFluidsValue);
             pst.setString(80,crystalloidValue);
            pst.setString(81,colloidValue);
            if (bloodPRCBS.getText().equals("") ) {
            pst.setNull(82, Types.INTEGER);
            } else {
                pst.setInt(82,Integer.parseInt(bloodPRCBS.getText()));
            }
            if ( plateletunit.getText().equals("") ) {
            pst.setNull(83, Types.INTEGER);
            } else {
                pst.setInt(83,Integer.parseInt(plateletunit.getText()));
            }
            if ( ffps.getText().equals("") ) {
            pst.setNull(84, Types.INTEGER);
            } else {pst.setInt(84,Integer.parseInt(ffps.getText()));}
            pst.setString(85,comlicatValue);
            if ( cvpMin.getText().equals("") ) { pst.setNull(86, Types.INTEGER);}
            else {pst.setInt(86,Integer.parseInt(cvpMin.getText()));}
            if ( cvpMax.getText().equals("") ) {
            pst.setNull(87, Types.INTEGER);
            } else {
                pst.setInt(87,Integer.parseInt(cvpMax.getText()));
            }
            pst.setString(88, aline);
            pst.setString(89,dopplrValue);
            pst.setString(90,pocusValue);
            pst.setString(91,routeValue);
            pst.setString(92,formula1Value);
            pst.setString(93,trachealValue);
            pst.setString(94,bloodPeriphValue);
            pst.setString(95,urineValue);
            pst.setString(96,csfValue);
            pst.setString(97,peritonealValue);
            pst.setString(98,woundValue);
            pst.setString(99,bloodCvpValue);
            pst.setString(100,othersValue);
            
            
            
            if ( calorie.getText().equals("") ) {
            pst.setNull(101, Types.DOUBLE);
            } else {
                pst.setDouble(101,Double.parseDouble(calorie.getText()));
            }
            
            if ( protein.getText().equals("") ) {
            pst.setNull(102, Types.DOUBLE);
            } else {
                pst.setDouble(102,Double.parseDouble(protein.getText()));
            }
            
            if ( Sofa.getText().equals("") ) {
            pst.setNull(103, Types.INTEGER);
            } else {
                pst.setInt(103,Integer.parseInt(Sofa.getText()));
            }
            
            if ( pbyf.getText().equals("") ) {
            pst.setNull(104, Types.DOUBLE);
            } else {
                pst.setDouble(104,Double.parseDouble(pbyf.getText()));
            }
            if ( PAO2.getText().equals("") ) {
            pst.setNull(105, Types.DOUBLE);
            } else {
                pst.setDouble(105,Double.parseDouble(PAO2.getText()));
            }
             if ( gradient.getText().equals("") ) {
            pst.setNull(106, Types.DOUBLE);
            } else {
                pst.setDouble(106,Double.parseDouble(gradient.getText()));
            }
            
            if ( cryoppt.getText().equals("") ) {
            pst.setNull(107, Types.INTEGER);
            } else {
                pst.setInt(107,Integer.parseInt(cryoppt.getText()));
            }
            
            
            
            
            pst.execute();
            JOptionPane.showMessageDialog(null,"Updated");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e); 
        }
    try{
        String sqlday="select max(day) from daywisecheckup where hospno='"+hospitalNo.getText()+"'";
        pst=conn.prepareStatement(sqlday);
        rs=pst.executeQuery(sqlday);
        while(rs.next()){int daycount = Integer.parseInt(rs.getString("max(day)"));
        daycount++;
        days.setText(String.valueOf(daycount));
        }
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
       checkUpdateOrInsert=0;
       }
        try{
            model5.removeAllElements();
            conn = ICUsystem.getconnection();
            String sqli="select antibiotic_type_id from antibiotic_type_table ";
            PreparedStatement pstcom = conn.prepareStatement(sqli);
            ResultSet rs = pstcom.executeQuery(sqli);
            while(rs.next()){
            
            model5.addElement(rs.getString("antibiotic_type_id"));
            }
            
        }catch(Exception e){}
        try{
            modelTrach1.removeAllElements();
            modelBperi1.removeAllElements();
            modelBcvp1.removeAllElements();
            modelUrine1.removeAllElements();
            modelCsf1.removeAllElements();
            modelPeri1.removeAllElements();
            modelWound1.removeAllElements();
            
            conn = ICUsystem.getconnection();
            String sqli="select org_type_id from org_type_table ";
            PreparedStatement pstcom = conn.prepareStatement(sqli);
            ResultSet rs = pstcom.executeQuery(sqli);
            while(rs.next()){
            modelTrach1.addElement(rs.getString("org_type_id"));
            modelBperi1.addElement(rs.getString("org_type_id"));
            modelBcvp1.addElement(rs.getString("org_type_id"));
            modelUrine1.addElement(rs.getString("org_type_id"));
            modelCsf1.addElement(rs.getString("org_type_id"));
            modelPeri1.addElement(rs.getString("org_type_id"));
            modelWound1.addElement(rs.getString("org_type_id"));
            }
            
        }catch(Exception e){}
        
        
        
        
        clearall();

    }//GEN-LAST:event_InsertActionPerformed

    
    void clearallfrontpage(){
    doaHospital.setDate(null);
    doaICU.setDate(null);
    dateSurgery.setDate(null);
    dateRedo.setDate(null);
    dateReadmission.setDate(null);
    dateDischarge.setDate(null);
    dateExtubation.setDate(null);
    reIntubation.setDate(null);
    hospitalDate.setDate(null);
    timeAdmission.setText("");
    bmi.setText("");
    diagnosisPrimary.setText("");
    diagnosisSecondary.setText("");
    surgery.setText("");
    redoSurgery.setText("");
    reasonWithdrawn.setText("");
    reasonReadmission.setText("");
    apache.setText("");
    saps.setText("");
    reAdmission.setSelectedIndex(0);
    qSofa.setText("");
    nutRiskScore.setText("");
    extubationTime.setText("");
    ventilationDays.setText("");
    cvpDays.setText("");
    complication.setText("");
    reasonOfDeath.setText("");
    brainScan.setText("");
    repeatBrainScan.setText("");
    e.setText("");
    m.setText("");
    b.setText("");
    r.setText("");
    total.setText("");
    age.setText("");
    admittedFrom.setSelectedIndex(0);
    jlistAdmittedtype.clearSelection();
    jlistComorbids.clearSelection();
    model2.removeAllElements();
    model3.removeAllElements();
    icuOutcome.setSelectedIndex(0);
    hospitalOutcome.setSelectedIndex(0);
    airwayType.setSelectedIndex(0);
    intubationAt.setSelectedIndex(0);
    height.setText("");
    weight.setText("");
    los.setText("");
    vent.setSelectedIndex(0);
    vap.setSelectedIndex(0);
    clabsi.setSelectedIndex(0);
    selfExtubation.setSelectedIndex(0);
    lifeTherapy.setSelectedIndex(0);
    
    }
    
    void clearall(){
        
            cryoppt.setText("");
            
            jlistAntibiotic.clearSelection();
            model4.removeAllElements();
            
            modelTrach2.removeAllElements();
            
            jTextField1.setText("");
            modelBperi2.removeAllElements();
            modelBcvp2.removeAllElements();
            modelUrine2.removeAllElements();
            modelCsf2.removeAllElements();
            modelPeri2.removeAllElements();
            modelWound2.removeAllElements();
            
            
            
            mode.setEditable(false);
            vt.setEditable(false);
            ps.setEditable(false);
            peep.setEditable(false);
            ppeak.setEditable(false);
            pplat.setEditable(false);
            cstat.setEditable(false);
            
            crystalloid.setEditable(false);
            colloid.setEditable(false);
            bloodPRCBS.setEditable(false);
            plateletunit.setEditable(false);
            ffps.setEditable(false);
            urineOutput.setEditable(false);
            otherLosses.setEditable(false);
            outputTotal.setEditable(false);
            intakeTotal.setEditable(false);
            balance.setEditable(false);
            cumBalance.setEditable(false);
            extubniv.setEditable(false);
            tpiece.setEditable(false);
            ventilate.setSelectedIndex(0);
            calorie.setText("");
            protein.setText("");
            vt.setText("");
            ps.setText("");
          peep.setText("");
          ppeak.setText("");
          pplat.setText("");
          cstat.setText("");
          ETTcuffpress.setText("");
          weaning.setSelectedIndex(0);
          extubniv.setSelectedIndex(0);
          crystalloid.setSelectedIndex(0);
          colloid.setSelectedIndex(0);
          tpiece.setSelectedIndex(0);
          fluidBalance.setSelectedIndex(0);
          urineOutput.setText("");
          otherLosses.setText("");
          intakeTotal.setText("");
          balance.setText("");
          outputTotal.setText("");
          cumBalance.setText("");
          bloodPRCBS.setText("");
          plateletunit.setText("");
          ffps.setText("");
          ivFluids.setSelectedIndex(0);
          complicat.setSelectedIndex(0);
          
          hr.setText(""); 
          sbp.setText("");
          dbp.setText("");
          map.setText("");
        
          temp.setText("");
          rr.setText("");
          gcs.setText("");
          rass.setText("");
          painscore.setText("");
          ph.setText("");
          pao.setText("");
          paco2.setText("");
          flo2.setText("");
          hco3.setText("");
          delirium.setSelectedIndex(0);
         dvtpropylaxis.setSelectedIndex(0);
        baseexcess.setText("");   
        urea.setText("");          
        creatinine.setText("");
        na.setText("");
        k.setText("");
        cl.setText("");
        hb.setText("");
        hct.setText("");
        plateletes.setText("");
        wbc.setText("");
        
        ptinr.setText("");
        fibrinog.setText("");
        ddimer.setText("");
        mg.setText("");
        po4.setText(""); // 
        ca.setText(""); //
        caion.setText("");
        bilrubin.setText("");
        alt.setText("");
        ast.setText("");
        alkphos.setText("");
        ggt.setText("");
        amylase.setText("");
        lipase.setText("");
        spotUSodium.setText("");
        albumen.setText("");
        ldh.setText("");
        cpk.setText(""); // 
        trop1.setText(""); // 
        bnp.setText("");
        lactate.setText("");
        pct.setText("");
        crp.setText("");
        bsrmin.setText("");
        bsrmax.setText("");
       
        dialysis.setSelectedIndex(0);
        vasopressors.setSelectedIndex(0);//'"+vasopressors.getText()+"','"+norepinephrine.getText()+"','"+dobutamine.getText()+"','"+dopamine.getText()+"','"+epinephrine.getText()+"',
        vasopressors.setSelectedIndex(0);
        norepinephrine.setText("");
        dobutamine.setText("");
        dopamine.setText("");
        epinephrine.setText(""); // '"+phenylephrine.getText()+"','"+steriodsld.getText()+"',
        phenylephrine.setText("");
        steriodsld.setSelectedIndex(0);
       
        //nutrition
        formula.setSelectedIndex(0);
        route.setSelectedIndex(0);
        //microbiology
        
        tracheal.setSelectedIndex(0);
        bloodPeriph.setSelectedIndex(0);
        urine.setSelectedIndex(0);
        csf.setSelectedIndex(0);
        peritoneal.setSelectedIndex(0);
        wound.setSelectedIndex(0);
        bloodCvp.setSelectedIndex(0);
        others.setSelectedIndex(0);
        
        //monitoring
        
        cvpMin.setText("");
        cvpMax.setText("");
        aLine.setSelectedIndex(0);
        pocus.setSelectedIndex(0); 
        
        
        Sofa.setText("");
        pbyf.setText("");
        PAO2.setText("");
        gradient.setText("");
        
    }
    
    
    private void exit4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit4MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exit4MouseClicked

    private void daysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_daysActionPerformed

    private void vasopressorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vasopressorsActionPerformed
        // TODO add your handling code here:
        String vas = vasopressors.getSelectedItem().toString();
        if(vas == "No"){
            norepinephrine.setEditable(false);
            dopamine.setEditable(false);
            epinephrine.setEditable(false);
            dobutamine.setEditable(false);
            phenylephrine.setEditable(false);
            
        }
        else{
            norepinephrine.setEditable(true);
            dopamine.setEditable(true);
            epinephrine.setEditable(true);
            dobutamine.setEditable(true);
            phenylephrine.setEditable(true);
            
        }
        
        
        
        
        
    }//GEN-LAST:event_vasopressorsActionPerformed

                            

    private void ventilateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventilateActionPerformed
        // TODO add your handling code here:
        
        String vent = ventilate.getSelectedItem().toString();
        if(vent == "No"){
            mode.setEditable(false);
            vt.setEditable(false);
            ps.setEditable(false);
            peep.setEditable(false);
            ppeak.setEditable(false);
            pplat.setEditable(false);
            cstat.setEditable(false);
           
        }
        else{
            mode.setEditable(true);
            vt.setEditable(true);
            ps.setEditable(true);
            peep.setEditable(true);
            ppeak.setEditable(true);
            pplat.setEditable(true);
            cstat.setEditable(true);
           
        }
    }//GEN-LAST:event_ventilateActionPerformed

    private void fluidBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fluidBalanceActionPerformed

// TODO add your handling code here:
        String fluid = fluidBalance.getSelectedItem().toString();
        
        if(fluid == "No" )
        {
            urineOutput.setEditable(false);
            otherLosses.setEditable(false);
            outputTotal.setEditable(false);
            intakeTotal.setEditable(false);
            balance.setEditable(false);
            cumBalance.setEditable(false);
        }
        else{
            urineOutput.setEditable(true);
            otherLosses.setEditable(true);
            outputTotal.setEditable(true);
            intakeTotal.setEditable(true);
            balance.setEditable(true);
            cumBalance.setEditable(true);
        }
    }//GEN-LAST:event_fluidBalanceActionPerformed

    private void ivFluidsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ivFluidsActionPerformed
        // TODO add your handling code here:
        String iv = ivFluids.getSelectedItem().toString();
        
       if(iv == "No"){
           crystalloid.setEditable(false);
           colloid.setEditable(false);
           bloodPRCBS.setEditable(false);
           plateletunit.setEditable(false);
           ffps.setEditable(false);
       }
       else{
           crystalloid.setEditable(true);
           colloid.setEditable(true);
           bloodPRCBS.setEditable(true);
           plateletunit.setEditable(true);
           ffps.setEditable(true);
       }
        
    }//GEN-LAST:event_ivFluidsActionPerformed

    private void outputTotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outputTotalMouseClicked
        // TODO add your handling code here:
       int bal = Integer.valueOf(urineOutput.getText()) + Integer.valueOf(otherLosses.getText());
       outputTotal.setText(String.valueOf(bal));
       outputTotal.setEditable(false);
    }//GEN-LAST:event_outputTotalMouseClicked

    private void balanceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_balanceKeyPressed
        // TODO add your handling code here:
       int bala = Integer.valueOf(intakeTotal.getText()) - Integer.valueOf(outputTotal.getText());
       balance.setText(String.valueOf(bala));
       balance.setEditable(false);
    }//GEN-LAST:event_balanceKeyPressed

    private void balanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_balanceMouseClicked
        // TODO add your handling code here:
       int bala = Integer.valueOf(intakeTotal.getText()) - Integer.valueOf(outputTotal.getText());
       balance.setText(String.valueOf(bala));
       balance.setEditable(false);
    }//GEN-LAST:event_balanceMouseClicked

    private void outputTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_outputTotalKeyPressed
        // TODO add your handling code here:
       int bal = Integer.valueOf(urineOutput.getText()) + Integer.valueOf(otherLosses.getText());
       outputTotal.setText(String.valueOf(bal));
       outputTotal.setEditable(false);
    }//GEN-LAST:event_outputTotalKeyPressed

    private void weaningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weaningActionPerformed
      // TODO add your handling code here:
        String wean = weaning.getSelectedItem().toString();
        
        if(wean == "No"){
            extubniv.setEditable(false);
            tpiece.setEditable(false);
        
        }
        else{
             extubniv.setEditable(true);
            tpiece.setEditable(true);
        }
    }//GEN-LAST:event_weaningActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String print  = rep.getText();
        
        try {           
            
            JasperDesign jd = JRXmlLoader.load("C:\\Users\\Bilal\\Desktop\\ICUsystem\\src\\report\\paitentinfo.jrxml");
            String sql="select * from patientinfo where hospno='"+print+"'";
            JRDesignQuery query = new JRDesignQuery();
            query.setText(sql);
            jd.setQuery(query);
            JasperReport jasperReport = JasperCompileManager.compileReport(jd);
            HashMap parameters = new HashMap();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ICUsystem.getconnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (JRException ex) {
            Logger.getLogger(ICUsystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void repActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repActionPerformed
    String patientIds[],icuOutcomes[],hospOutcomes[];
    int ages[];
    private void deliriumSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliriumSearchActionPerformed
        // TODO add your handling code here:
        int ages[];    
        String input = JOptionPane.showInputDialog(null,"Please enter Delirium value:");
        conn = ICUsystem.getconnection();
           try{
            String sql = "Select * from patientinfo,daywisecheckup where patientinfo.hospno = daywisecheckup.hospno and delirium = '"+input+"' order by doaInHosp desc";
            pst  = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            Object[] row = new Object[4];
            model6= (DefaultTableModel) patient_table.getModel();
            model6.setRowCount(0);
            int i=0;
            while(rs.next()){
            i++;
            row[0]=rs.getString("hospno");
            row[1]=rs.getString("ICUoutcome");
            row[2]=rs.getString("hospOutcome");
            row[3]=rs.getDate("doaInHosp");
            model6.addRow(row);
           }
            braindeath.setText("Number of such hospital numbers are: "+Integer.toString(i)+"");
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);   
        }
           mainpanel.removeAll();
           mainpanel.repaint();
           mainpanel.revalidate();
           mainpanel.add(showData);
           mainpanel.repaint();
           mainpanel.revalidate();
        
    }//GEN-LAST:event_deliriumSearchActionPerformed

    private void exit5exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit5exitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exit5exitMouseClicked

    private void clabsiSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clabsiSearchActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(null,"Please enter CLABSI Value:");
        conn = ICUsystem.getconnection();
           try{
            String sql = "Select * FROM patientinfo where clabsi = '"+input+"' order by doaInHosp desc";
            pst  = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            Object[] row = new Object[4];
            model6= (DefaultTableModel) patient_table.getModel();
            model6.setRowCount(0);
            int i=0;
            while(rs.next()){
            i++;  
            row[0]=rs.getString("hospno");
            row[1]=rs.getString("ICUoutcome");
            row[2]=rs.getString("hospOutcome");
            row[3]=rs.getDate("doaInHosp");
            model6.addRow(row);
            }
              braindeath.setText("Number of such hospital numbers are: "+Integer.toString(i)+"");
          
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);   
        }
           mainpanel.removeAll();
           mainpanel.repaint();
           mainpanel.revalidate();
           mainpanel.add(showData);
           mainpanel.repaint();
           mainpanel.revalidate();
       
    }//GEN-LAST:event_clabsiSearchActionPerformed

    private void brainSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brainSearchActionPerformed
        // TODO add your handling code here:
        conn = ICUsystem.getconnection();
           try{ //like '%"+input+"%'
            String sql = "Select * from patientinfo where reason like '%brain death%' order by doaInHosp desc  ";
            pst  = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            Object[] row = new Object[4];
            model6= (DefaultTableModel) patient_table.getModel();
            model6.setRowCount(0);
            int i =0;
            while(rs.next()){
            i++;
            row[0]=rs.getString("hospno");
            row[1]=rs.getString("ICUoutcome");
            row[2]=rs.getString("hospOutcome");
            row[3]=rs.getDate("doaInHosp");
            model6.addRow(row);
            }
            braindeath.setText("Number of brain death patients are: "+Integer.toString(i)+"");
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);   
        }
           mainpanel.removeAll();
           mainpanel.repaint();
           mainpanel.revalidate();
           mainpanel.add(showData);
           mainpanel.repaint();
           mainpanel.revalidate();
        
        
    }//GEN-LAST:event_brainSearchActionPerformed

    private void selfExtubationSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selfExtubationSearchActionPerformed
        // TODO add your handling code here:
        
        String input = JOptionPane.showInputDialog(null,"Please enter Self Extubation value:");
        conn = ICUsystem.getconnection();
           try{
            String sql = "Select * from patientinfo where selfextubation = '"+input+"'  order by doaInHosp desc";
            pst  = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            Object[] row = new Object[4];
            model6= (DefaultTableModel) patient_table.getModel();
            model6.setRowCount(0);
            int i=0;
            while(rs.next()){
                i++;
            row[0]=rs.getString("hospno");
            row[1]=rs.getString("ICUoutcome");
            row[2]=rs.getString("hospOutcome");
            row[3]=rs.getDate("doaInHosp");
            model6.addRow(row);
            }
            
            braindeath.setText("Number of such patients are: "+Integer.toString(i)+"");
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);   
        }
           mainpanel.removeAll();
           mainpanel.repaint();
           mainpanel.revalidate();
           mainpanel.add(showData);
           mainpanel.repaint();
           mainpanel.revalidate();
    }//GEN-LAST:event_selfExtubationSearchActionPerformed

    private void reItubationSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reItubationSearchActionPerformed
        // TODO add your handling code here:
         String input = JOptionPane.showInputDialog(null,"Please enter ReIntubation value:");
        conn = ICUsystem.getconnection();
           try{
            String sql = "Select * from patientinfo where reintubation like '%"+input+"%' order by doaInHosp desc ";
            pst  = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            Object[] row = new Object[4];
            model6= (DefaultTableModel) patient_table.getModel();
            model6.setRowCount(0);
            int i = 0;
            while(rs.next()){
            i++;
            row[0]=rs.getString("hospno");
            row[1]=rs.getString("ICUoutcome");
            row[2]=rs.getString("hospOutcome");
            row[3]=rs.getDate("doaInHosp");
            model6.addRow(row);
            }
            braindeath.setText("Number of such patients are: "+Integer.toString(i)+"");
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);   
        }
           mainpanel.removeAll();
           mainpanel.repaint();
           mainpanel.revalidate();
           mainpanel.add(showData);
           mainpanel.repaint();
           mainpanel.revalidate();
        
    }//GEN-LAST:event_reItubationSearchActionPerformed

    private void DiagnosisSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiagnosisSearchActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(null,"Please enter Diagnosis:");
        conn = ICUsystem.getconnection();
           try{
            String sql = "Select * from patientinfo where pdiagnosis like '%"+input+"%' or sdiagnosis like '%"+input+"%' order by doaInHosp desc";
            pst  = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            Object[] row = new Object[4];
            model6= (DefaultTableModel) patient_table.getModel();
            model6.setRowCount(0);
            int i =0;
            while(rs.next()){
            i++;
            row[0]=rs.getString("hospno");
            row[1]=rs.getString("ICUoutcome");
            row[2]=rs.getString("hospOutcome");
            row[3]=rs.getDate("doaInHosp");
            model6.addRow(row);
            }
            
            braindeath.setText("Number of such hospital numbers are: "+Integer.toString(i)+"");
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);   
        }
           mainpanel.removeAll();
           mainpanel.repaint();
           mainpanel.revalidate();
           mainpanel.add(showData);
           mainpanel.repaint();
           mainpanel.revalidate();
        
    }//GEN-LAST:event_DiagnosisSearchActionPerformed

    private void reAdmissionSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reAdmissionSearchActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(null,"Search for Readdmision [yes/no]:");
        conn = ICUsystem.getconnection();
           try{
            String sql = "Select * from patientinfo where reAdmission = '"+input+"' order by doaInHosp desc ";
            pst  = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            Object[] row = new Object[4];
            model6= (DefaultTableModel) patient_table.getModel();
            model6.setRowCount(0);
            int i =0;
            while(rs.next()){
            i++;
            row[0]=rs.getString("hospno");
            row[1]=rs.getString("ICUoutcome");
            row[2]=rs.getString("hospOutcome");
            row[3]=rs.getDate("doaInHosp");
            model6.addRow(row);
            }
            
            braindeath.setText("Number of such patients are: "+Integer.toString(i)+"");
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);   
        }
           mainpanel.removeAll();
           mainpanel.repaint();
           mainpanel.revalidate();
           mainpanel.add(showData);
           mainpanel.repaint();
           mainpanel.revalidate();
        
        
        
    }//GEN-LAST:event_reAdmissionSearchActionPerformed

    private void dopplrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dopplrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dopplrActionPerformed

    private void crystalloidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crystalloidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crystalloidActionPerformed

    private void colloidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colloidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_colloidActionPerformed

    private void cstatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cstatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cstatActionPerformed

    private void modeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modeActionPerformed

    private void pocusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pocusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pocusActionPerformed

    private void reAdmissionSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reAdmissionSearch1ActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(null,"Please enter Admitted type:");
        conn = ICUsystem.getconnection();
            try{
            String sql = "Select * from patientinfo,patient_admission_type where patientinfo.hospno = patient_admission_type.hospno and patient_admission_type.patient_admission_type_id like '%"+input+"%' order by doaInHosp desc";
            pst  = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            Object[] row = new Object[4];
            model6= (DefaultTableModel) patient_table.getModel();
            model6.setRowCount(0);
            int i = 0;
            while(rs.next()){
            i++;
            row[0]=rs.getString("hospno");
            row[1]=rs.getString("ICUoutcome");
            row[2]=rs.getString("hospOutcome");
            row[3]=rs.getDate("doaInHosp");
            model6.addRow(row);
            }
            braindeath.setText("Number of such patients are: "+Integer.toString(i)+"");
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);   
        }
           mainpanel.removeAll();
           mainpanel.repaint();
           mainpanel.revalidate();
           mainpanel.add(showData);
           mainpanel.repaint();
           mainpanel.revalidate();
        
    }//GEN-LAST:event_reAdmissionSearch1ActionPerformed

    private void ETTSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ETTSearchActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(null,"Please enter VAP value:");
        conn = ICUsystem.getconnection();
           try{
            String sql = "Select * from patientinfo,daywisecheckup where patientinfo.hospno = daywisecheckup.hospno and vap = '"+input+"' order by doaInHosp desc";
            pst  = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            Object[] row = new Object[4];
            model6= (DefaultTableModel) patient_table.getModel();
            model6.setRowCount(0);
            int i=0;
            while(rs.next()){
                i++;
            row[0]=rs.getString("hospno");
            row[1]=rs.getString("ICUoutcome");
            row[2]=rs.getString("hospOutcome");
            row[3]=rs.getDate("doaInHosp");
            model6.addRow(row);
            }
             braindeath.setText("Number of such patients are: "+Integer.toString(i)+"");
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);   
        }
           mainpanel.removeAll();
           mainpanel.repaint();
           mainpanel.revalidate();
           mainpanel.add(showData);
           mainpanel.repaint();
           mainpanel.revalidate();
        
        
        
        
    }//GEN-LAST:event_ETTSearchActionPerformed

    private void pctSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pctSearchActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(null,"Search PCT value Less than:");
        conn = ICUsystem.getconnection();
           try{
            String sql = "Select * from patientinfo,daywisecheckup where patientinfo.hospno = daywisecheckup.hospno and pct <= '"+input+"' order by doaInHosp desc";
            pst  = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            Object[] row = new Object[4];
            model6= (DefaultTableModel) patient_table.getModel();
            model6.setRowCount(0);
            int i=0;
            while(rs.next()){
           i++;
            row[0]=rs.getString("hospno");
            row[1]=rs.getString("ICUoutcome");
            row[2]=rs.getString("hospOutcome");
            row[3]=rs.getDate("doaInHosp");
            model6.addRow(row);
            }
            braindeath.setText("Number of outputs are : "+Integer.toString(i)+"");
          
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);   
        }
           mainpanel.removeAll();
           mainpanel.repaint();
           mainpanel.revalidate();
           mainpanel.add(showData);
           mainpanel.repaint();
           mainpanel.revalidate();
        
        
    }//GEN-LAST:event_pctSearchActionPerformed

    private void surgerySearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surgerySearchActionPerformed
        // TODO add your handling code here:
               String input = JOptionPane.showInputDialog(null,"Please enter Surgery:");
        conn = ICUsystem.getconnection();
           try{
            String sql = "Select * from patientinfo where surgery like '%"+input+"%' order by doaInHosp desc";
            pst  = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            Object[] row = new Object[4];
            model6= (DefaultTableModel) patient_table.getModel();
            model6.setRowCount(0);
            int i = 0;
            while(rs.next()){
           
            i++;
            row[0]=rs.getString("hospno");
            row[1]=rs.getString("ICUoutcome");
            row[2]=rs.getString("hospOutcome");
            row[3]=rs.getDate("doaInHosp");
            model6.addRow(row);
            }
            
            braindeath.setText("Number of such patients are: "+Integer.toString(i)+"");
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);   
        }
           mainpanel.removeAll();
           mainpanel.repaint();
           mainpanel.revalidate();
           mainpanel.add(showData);
           mainpanel.repaint();
           mainpanel.revalidate();
        
 
    }//GEN-LAST:event_surgerySearchActionPerformed

    private void airwaySearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airwaySearchActionPerformed
        // TODO add your handling code here:
        
                     String input = JOptionPane.showInputDialog(null,"Please enter Airway:");
        conn = ICUsystem.getconnection();
           try{
            String sql = "Select * from patientinfo where airwaytype like '%"+input+"%' order by doaInHosp desc";
            pst  = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            Object[] row = new Object[4];
            model6= (DefaultTableModel) patient_table.getModel();
            model6.setRowCount(0);
            int i = 0;
            while(rs.next()){
           
            i++;
            row[0]=rs.getString("hospno");
            row[1]=rs.getString("ICUoutcome");
            row[2]=rs.getString("hospOutcome");
            row[3]=rs.getDate("doaInHosp");
            model6.addRow(row);
            }
            braindeath.setText("Number of such patients are: "+Integer.toString(i)+"");
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);   
        }
           mainpanel.removeAll();
           mainpanel.repaint();
           mainpanel.revalidate();
           mainpanel.add(showData);
           mainpanel.repaint();
           mainpanel.revalidate();
        
 
    }//GEN-LAST:event_airwaySearchActionPerformed

    private void airwaySearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airwaySearch1ActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(null,"Please enter Diagnosis for Mechanically ventalited paitent:");
        conn = ICUsystem.getconnection();
           try{
            String sql = "Select * from patientinfo where vent = 'yes' and pdiagnosis like '%"+input+"%' or sdiagnosis like '%"+input+"%' order by doaInHosp desc";
            pst  = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            Object[] row = new Object[4];
            model6= (DefaultTableModel) patient_table.getModel();
            model6.setRowCount(0);
            int i =0;
            while(rs.next()){
            i++;
            row[0]=rs.getString("hospno");
            row[1]=rs.getString("ICUoutcome");
            row[2]=rs.getString("hospOutcome");
            row[3]=rs.getDate("doaInHosp");
            model6.addRow(row);
            }
            braindeath.setText("Number of such patients are: "+Integer.toString(i)+"");
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);   
        }
           mainpanel.removeAll();
           mainpanel.repaint();
           mainpanel.revalidate();
           mainpanel.add(showData);
           mainpanel.repaint();
           mainpanel.revalidate();
        
    }//GEN-LAST:event_airwaySearch1ActionPerformed

    private void ETTSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ETTSearch1ActionPerformed
        // TODO add your handling code here:        
        conn = ICUsystem.getconnection();
           try{
            String sql = "Select *  from patientinfo,daywisecheckup,patient_antibiotic_table where patientinfo.hospno = daywisecheckup.hospno  and patientinfo.hospno = patient_antibiotic_table.hospno and( pdiagnosis = 'nephrotoxicity' or sdiagnosis = 'nephrotoxicity') and patient_antibiotic_value = '11' order by doaInHosp desc";
            pst  = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            Object[] row = new Object[4];
            model6= (DefaultTableModel) patient_table.getModel();
            model6.setRowCount(0);
            int i = 0;
            while(rs.next()){
            i++;
            
            row[0]=rs.getString("hospno");
            row[1]=rs.getString("ICUoutcome");
            row[2]=rs.getString("hospOutcome");
            row[3]=rs.getDate("doaInHosp");
            model6.addRow(row);
            }
            
            braindeath.setText("Number of such hospital number are: "+Integer.toString(i)+"");
           
            
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);   
        }
           mainpanel.removeAll();
           mainpanel.repaint();
           mainpanel.revalidate();
           mainpanel.add(showData);
           mainpanel.repaint();
           mainpanel.revalidate();
        
        
        
        

    }//GEN-LAST:event_ETTSearch1ActionPerformed

    private void cardiacSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardiacSearchActionPerformed
        // TODO add your handling code here:
        
        
        conn = ICUsystem.getconnection();
           try{
            String sql = "Select * from patientinfo where admittedfrom = 'ER' and pdiagnosis like 'cardiac arrest' or sdiagnosis like 'cardiac arrest' order by doaInHosp desc ";
            pst  = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            Object[] row = new Object[4];
            model6= (DefaultTableModel) patient_table.getModel();
            model6.setRowCount(0);
            int i = 0;
            while(rs.next()){
           
            i++;
            row[0]=rs.getString("hospno");
            row[1]=rs.getString("ICUoutcome");
            row[2]=rs.getString("hospOutcome");
            row[3]=rs.getDate("doaInHosp");
            model6.addRow(row);
            }
            
            braindeath.setText("Number of such patients are: "+Integer.toString(i)+"");
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);   
        }
           mainpanel.removeAll();
           mainpanel.repaint();
           mainpanel.revalidate();
           mainpanel.add(showData);
           mainpanel.repaint();
           mainpanel.revalidate();
        
    }//GEN-LAST:event_cardiacSearchActionPerformed

    private void tlcSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tlcSearchActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(null,"Search for WBC less than:");
        conn = ICUsystem.getconnection();
           try{
            String sql = "Select * from patientinfo,daywisecheckup where patientinfo.hospno = daywisecheckup.hospno and daywisecheckup.wbc <= '"+input+"' order by doaInHosp desc";
            pst  = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            Object[] row = new Object[4];
            model6= (DefaultTableModel) patient_table.getModel();
            model6.setRowCount(0);
            int i = 0;
            
            while(rs.next()){
            i++;
            
            row[0]=rs.getString("hospno");
            row[1]=rs.getString("ICUoutcome");
            row[2]=rs.getString("hospOutcome");
            row[3]=rs.getDate("doaInHosp");
            model6.addRow(row);
            }
            
             braindeath.setText("Number of hospital numbers are: "+Integer.toString(i)+"");
           
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);   
        }
           mainpanel.removeAll();
           mainpanel.repaint();
           mainpanel.revalidate();
           mainpanel.add(showData);
           mainpanel.repaint();
           mainpanel.revalidate();
        
    }//GEN-LAST:event_tlcSearchActionPerformed

    private void vapSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vapSearchActionPerformed
        // TODO add your handling code here:
            String input = JOptionPane.showInputDialog(null,"Please enter VAP Value:");
           conn = ICUsystem.getconnection();
           try{
            String sql = "Select *  FROM patientinfo,daywisecheckup where patientinfo.hospno = daywisecheckup.hospno and (pdiagnosis = 'evacuation lumen ETT' or sdiagnosis = 'evacuation lumen ETT') and vap = '"+input+"' order by doaInHosp desc ";
            pst  = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            Object[] row = new Object[4];
            model6= (DefaultTableModel) patient_table.getModel();
            model6.setRowCount(0);
            int i = 0;
            while(rs.next()){
            i++;    
            row[0]=rs.getString("hospno");
            row[1]=rs.getString("ICUoutcome");
            row[2]=rs.getString("hospOutcome");
            row[3]=rs.getDate("doaInHosp");
            model6.addRow(row);
            }
            braindeath.setText("Number of such patients are: "+Integer.toString(i)+"");
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);   
        }
           mainpanel.removeAll();
           mainpanel.repaint();
           mainpanel.revalidate();
           mainpanel.add(showData);
           mainpanel.repaint();
           mainpanel.revalidate();
       
 
        
        
    }//GEN-LAST:event_vapSearchActionPerformed

    private void addNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewActionPerformed
        // TODO add your handling code here:
        
        model1.removeAllElements();
        model.removeAllElements();
        try{
            conn = ICUsystem.getconnection();
            String sql="select comorbids_type from comorbids_table ";
            PreparedStatement pstcom = conn.prepareStatement(sql);
            ResultSet rs = pstcom.executeQuery(sql);
            while(rs.next()){
            model.addElement(rs.getString("comorbids_type"));
            }
            jlistComorbids.setModel(model);
        }catch(Exception e){}
        try{
            conn = ICUsystem.getconnection();
            String sql="select admission_type from admission_type_table ";
            PreparedStatement pstcom = conn.prepareStatement(sql);
            ResultSet rs = pstcom.executeQuery(sql);
            while(rs.next()){
            model1.addElement(rs.getString("admission_type"));
            }
            jlistAdmittedtype.setModel(model1);
        }catch(Exception e){}
        
        
        
        setColor(btn_1);
        ind_1.setOpaque(true);
        reset(btn_2);
        reset(btn_3);
        reset(btn_5);
        resetIndicator(ind_2);
        resetIndicator(ind_3);
        resetIndicator(ind_5);
        //Remove panels
        mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();
        //Add panels
        mainpanel.add(addpatient);
        mainpanel.repaint();
        mainpanel.revalidate();
        hospitalNo.setText("");
        addPatient.setText("Add Patient");
        hospitalNo.setEditable(true);
        checkUpdateOrInsert=0;
        clearallfrontpage();
        
        
    }//GEN-LAST:event_addNewActionPerformed

    private void dateExtubationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateExtubationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateExtubationActionPerformed

    private void update_patientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_patientMouseClicked
        // TODO add your handling code here:
        int row=update_patient.getSelectedRow();
        String data = update_patient.getModel().getValueAt(row,0).toString();
        conn=ICUsystem.getconnection();
        try{
        String sql ="select * from patientinfo where hospno = '"+data+"'";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery(sql);
        while(rs.next()){
    hospitalNo.setText(rs.getString("hospno"));
    code.setSelectedItem(rs.getString("code"));
    sex.setSelectedItem(rs.getString("sex"));
    if("1970-01-01".equals(rs.getDate("doaInHosp").toString())){}else{doaHospital.setDate(rs.getDate("doaInHosp"));}
    if("1970-01-01".equals(rs.getDate("doaInIcu").toString())){}else{doaICU.setDate(rs.getDate("doaInIcu"));}
    if("1970-01-01".equals(rs.getDate("surgerydate").toString())){}else{dateSurgery.setDate(rs.getDate("surgerydate"));}
    if("1970-01-01".equals(rs.getDate("redodate").toString())){}else{dateRedo.setDate(rs.getDate("redodate"));}
    if("1970-01-01".equals(rs.getDate("readmissionDate").toString())){}else{dateReadmission.setDate(rs.getDate("readmissionDate"));}
    if("1970-01-01".equals(rs.getDate("dodischarge").toString())){}else{dateDischarge.setDate(rs.getDate("dodischarge"));}
    if("1970-01-01".equals(rs.getDate("extubation").toString())){}else{dateExtubation.setDate(rs.getDate("extubation"));}
    if("1970-01-01".equals(rs.getDate("reintubation").toString())){}else{reIntubation.setDate(rs.getDate("reintubation"));}
    if("1970-01-01".equals(rs.getDate("DOD").toString())){}else{hospitalDate.setDate(rs.getDate("DOD"));}
    timeAdmission.setText(rs.getString("time"));
    bmi.setText(rs.getString("bmi"));
    diagnosisPrimary.setText(rs.getString("pdiagnosis"));
    diagnosisSecondary.setText(rs.getString("sdiagnosis"));
    surgery.setText(rs.getString("surgery"));
    redoSurgery.setText(rs.getString("redo"));
    reasonWithdrawn.setText(rs.getString("reason"));
    reasonReadmission.setText(rs.getString("reasonofreadmission"));
    apache.setText(rs.getString("APACHEII"));
    saps.setText(rs.getString("SAPS"));
    qSofa.setText(rs.getString("qSOFA"));
    nutRiskScore.setText(rs.getString("nutritionriskscore"));
    extubationTime.setText(rs.getString("extubationtime"));
    ventilationDays.setText(rs.getString("ventilationdays"));
    cvpDays.setText(rs.getString("cvpdays"));
    complication.setText(rs.getString("complications"));
    reasonOfDeath.setText(rs.getString("pcauseofdeath"));
    brainScan.setText(rs.getString("Brainscan"));
    repeatBrainScan.setText(rs.getString("repeatscan"));
    e.setText(rs.getString("Escore"));
    m.setText(rs.getString("Mscore"));
    b.setText(rs.getString("Bscore"));
    r.setText(rs.getString("Rscore"));
    total.setText(rs.getString("totalscore"));
    age.setText(rs.getString("age"));
    admittedFrom.setSelectedItem(rs.getString("admittedfrom"));
    icuOutcome.setSelectedItem(rs.getString("ICUoutcome"));
    hospitalOutcome.setSelectedItem(rs.getString("hospOutcome"));
    airwayType.setSelectedItem(rs.getString("airwaytype"));
    intubationAt.setSelectedItem(rs.getString("intubationat"));
    height.setText(rs.getString("height"));
    weight.setText(rs.getString("weight"));
    los.setText(rs.getString("LOS"));
    vent.setSelectedItem(rs.getString("vent"));
    vap.setSelectedItem(rs.getString("vap"));
    clabsi.setSelectedItem(rs.getString("clabsi"));
    selfExtubation.setSelectedItem(rs.getString("selfextubation"));
    lifeTherapy.setSelectedItem(rs.getString("lifeSustainingTherapyWithdrawn"));
    
    
        }
        model2.removeAllElements();
        String sql2="select * from patient_admission_type where hospno = '"+data+"'";
        PreparedStatement psmt=conn.prepareStatement(sql2);
        ResultSet rst= psmt.executeQuery(sql2);
        while(rst.next()){
        model2.addElement(rst.getString("patient_admission_type_id"));
        }
        model3.removeAllElements();
        String sql3="select * from patient_comorbid where hospno = '"+data+"'";
        PreparedStatement psmt1=conn.prepareStatement(sql3);
        ResultSet rst1= psmt.executeQuery(sql3);
        while(rst1.next()){
        model3.addElement(rst1.getString("patient_comorbid_id"));
        }
        jListSelectComorbid.setModel(model3);
        jListSelectAdmission.setModel(model2);
    setColor(btn_1);
        ind_1.setOpaque(true);
        reset(btn_2);
        reset(btn_3);
        reset(btn_5);
        resetIndicator(ind_2);
        resetIndicator(ind_3);
        resetIndicator(ind_5);
        //Remove panels
        mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();
        //Add panels
        mainpanel.add(addpatient);
        mainpanel.repaint();
        mainpanel.revalidate();
        addPatient.setText("Update");
        checkUpdateOrInsert=1;
        hospitalNo.setEditable(false);
        
        }
        catch(Exception e){
       JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_update_patientMouseClicked

    private void formula1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formula1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_formula1ActionPerformed

    private void addPatientKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addPatientKeyPressed
        // TODO add your handling code here:
        
    
    }//GEN-LAST:event_addPatientKeyPressed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        
        checkForBound=0;
        String input = JOptionPane.showInputDialog(null,"Please Enter day to update: ");
         try{
        String sqlday="select max(day) from daywisecheckup where hospno='"+hospitalNo.getText()+"'";
        pst=conn.prepareStatement(sqlday);
        rs=pst.executeQuery(sqlday);
        if(rs.next()){   
        int daycount = Integer.parseInt(rs.getString("max(day)"));
        daycount++;
        days.setText(String.valueOf(daycount));
        clearall();
        
        }else{
        days.setText("0");
        
        }
        }
        catch(Exception e)
        {days.setText("0");}
        
         try{
         String sqlcheck="select day from daywisecheckup where hospno='"+hospitalNo.getText()+"'";
         pst=conn.prepareStatement(sqlcheck);
         rs=pst.executeQuery(sqlcheck);
         while(rs.next()){
             if(input.equals(rs.getString("day"))){
             checkForBound=1;
             }
         
         }
         }
        catch(Exception e){}
        conn = ICUsystem.getconnection();
        if(checkForBound == 1){
           try{
            String sql = "Select * from daywisecheckup where hospno='"+hospitalNo.getText()+"' and day = '"+input+"'";
            pst  = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            if(days.getText().equals("0")){}else{
            checkUpdateOrInsert = 1;}
            while(rs.next()){
            days.setText(rs.getString("day"));
            hr.setText(rs.getString("hr"));
            sbp.setText(rs.getString("sbp"));
          dbp.setText(rs.getString("dbp"));
          map.setText(rs.getString("map"));
          temp.setText(rs.getString("temp"));
          rr.setText(rs.getString("rr"));
          gcs.setText(rs.getString("gcs"));
          rass.setText(rs.getString("rass"));
          painscore.setText(rs.getString("painscore"));
          ph.setText(rs.getString("ph"));
          pao.setText(rs.getString("pao"));
          paco2.setText(rs.getString("paco2"));
          flo2.setText(rs.getString("flo2"));
          hco3.setText(rs.getString("hco3"));
          delirium.setSelectedItem(rs.getString("delirium"));
         dvtpropylaxis.setSelectedItem(rs.getString("dvtpropylaxis"));
        baseexcess.setText(rs.getString("baseexcess"));   
        urea.setText(rs.getString("urea"));          
        creatinine.setText(rs.getString("creatinine"));
        na.setText(rs.getString("na"));
        k.setText(rs.getString("k"));
        cl.setText(rs.getString("cl"));
        hb.setText(rs.getString("hb"));
        hct.setText(rs.getString("hct"));
        plateletes.setText(rs.getString("plateletes"));
        wbc.setText(rs.getString("wbc"));
        ptinr.setText(rs.getString("ptinr"));
        fibrinog.setText(rs.getString("fibrinog"));
        ddimer.setText(rs.getString("ddimer"));
        mg.setText(rs.getString("mg"));
        po4.setText(rs.getString("po4")); // 
        ca.setText(rs.getString("ca")); //
        caion.setText(rs.getString("caion"));
        bilrubin.setText(rs.getString("bilirubin"));
        alt.setText(rs.getString("alt"));
        ast.setText(rs.getString("ast"));
        alkphos.setText(rs.getString("alkphos"));
        ggt.setText(rs.getString("ggt"));
        amylase.setText(rs.getString("amylase"));
        lipase.setText(rs.getString("lipase"));
        albumen.setText(rs.getString("albumen"));
        Sofa.setText(rs.getString("sofa"));
        ldh.setText(rs.getString("ldh"));
        cpk.setText(rs.getString("cpk")); // 
        trop1.setText(rs.getString("trop1")); // 
        bnp.setText(rs.getString("bnp"));
        lactate.setText(rs.getString("lactate"));
        pct.setText(rs.getString("pct"));
        crp.setText(rs.getString("crp"));
        bsrmin.setText(rs.getString("bsrmin"));
        bsrmax.setText(rs.getString("bsrmax"));
        spotUSodium.setText(rs.getString("spotUSodium"));
        dialysis.setSelectedItem(rs.getString("dialysis"));
        vasopressors.setSelectedItem(rs.getString("vasopressors"));  //'"+vasopressors.getText()+"','"+norepinephrine.getText()+"','"+dobutamine.getText()+"','"+dopamine.getText()+"','"+epinephrine.getText()+"',
        norepinephrine.setText(rs.getString("norepinephrine"));
        dobutamine.setText(rs.getString("dobutamine"));
        dopamine.setText(rs.getString("dopamine"));
        epinephrine.setText(rs.getString("epinephrine")); // '"+phenylephrine.getText()+"','"+steriodsld.getText()+"',
        phenylephrine.setText(rs.getString("phenylephrine"));
        steriodsld.setSelectedItem(rs.getString("steriodsld"));
        vt.setText(rs.getString("vt"));
        ps.setText(rs.getString("ps"));
        peep.setText(rs.getString("peep"));
        ppeak.setText(rs.getString("ppeak"));
        pplat.setText(rs.getString("pplat"));
        cstat.setText(rs.getString("cstat"));
        ETTcuffpress.setText(rs.getString("ETTcuffpress"));
        weaning.setSelectedItem(rs.getString("weaning"));
        extubniv.setSelectedItem(rs.getString("extubniv"));
        crystalloid.setSelectedItem(rs.getString("crystalloid"));
        ventilate.setSelectedItem(rs.getString("ventilate"));
      mode.setSelectedItem(rs.getString("mode"));
        colloid.setSelectedItem(rs.getString("colloid"));
        tpiece.setSelectedItem(rs.getString("tpiece"));
        fluidBalance.setSelectedItem(rs.getString("fluidbalance"));
        urineOutput.setText(rs.getString("urineOutput"));
        otherLosses.setText(rs.getString("otherLosses"));
        intakeTotal.setText(rs.getString("intakeTotal"));
          balance.setText(rs.getString("balance"));
          outputTotal.setText(rs.getString("outputTotal"));
          cumBalance.setText(rs.getString("cumbalance"));
          bloodPRCBS.setText(rs.getString("bloodPRCBS"));
          plateletunit.setText(rs.getString("plateletunit"));
          ffps.setText(rs.getString("ffps"));
          ivFluids.setSelectedItem(rs.getString("ivFluids"));
          complicat.setSelectedItem(rs.getString("complicat"));
          hr.setText(rs.getString("hr"));
        //nutrition
        formula.setSelectedItem(rs.getString("formula"));
        route.setSelectedItem(rs.getString("route"));
        //microbiology
        tracheal.setSelectedItem(rs.getString("tracheal"));
        bloodPeriph.setSelectedItem(rs.getString("bloodPeripheral"));
        urine.setSelectedItem(rs.getString("urine"));
        csf.setSelectedItem(rs.getString("csf"));
        peritoneal.setSelectedItem(rs.getString("peritoneal"));
        wound.setSelectedItem(rs.getString("wound"));
        bloodCvp.setSelectedItem(rs.getString("bloodCvp"));
        others.setSelectedItem(rs.getString("others"));
        //monitoring
        cvpMin.setText(rs.getString("cvpMin"));
        cvpMax.setText(rs.getString("cvpMax"));
        aLine.setSelectedItem(rs.getString("Aline"));
        pocus.setSelectedItem(rs.getString("pocus"));
        cryoppt.setText(rs.getString("cryoppt"));
        
        pbyf.setText(rs.getString("pbyf"));
        PAO2.setText(rs.getString("PAO2"));
        gradient.setText(rs.getString("gradient"));
        
        calorie.setText(rs.getString("cal"));
        protein.setText(rs.getString("Protein"));
        
        
           }
            
            model4.removeAllElements();
            String sqlAnti="Select * from patient_antibiotic_table where hospno='"+hospitalNo.getText()+"' and day = '"+input+"'";
            PreparedStatement pst = conn.prepareStatement(sqlAnti);
            ResultSet rst = pst.executeQuery(sqlAnti);
            
            while(rst.next()){
                
                model4.addElement(rst.getString("patient_antibiotic_value"));
            }
            jListSelectAntibiotic.setModel(model4);
           
            modelTrach2.removeAllElements();
            modelBperi2.removeAllElements();
            modelBcvp2.removeAllElements();
            modelUrine2.removeAllElements();
            modelCsf2.removeAllElements();
            modelPeri2.removeAllElements();
            modelWound2.removeAllElements();
            String name1 = "Tracheal";
            String name2 = "Blood Peripheral";
            String name3 = "Blood CVP";
            String name4 = "Urine";
            String name5 = "CSF";
            String name6 = "Peritoneal";
            String name7 = "Wound";
            
            String sql1="Select * from org where hospno= '"+hospitalNo.getText()+"' and day = '"+input+"' and org_name = '"+name1+"' ";
            PreparedStatement pst1 = conn.prepareStatement(sql1);
            ResultSet rst1 = pst1.executeQuery(sql1);
            
            while(rst1.next()){
                
                modelTrach2.addElement(rst1.getString("org_value"));
            }
            jListSelectTrach.setModel(modelTrach2);         
           
            
            
            
            String sql2="Select * from org where hospno= '"+hospitalNo.getText()+"' and day = '"+input+"' and org_name = '"+name2+"' ";
            PreparedStatement pst2 = conn.prepareStatement(sql2);
            ResultSet rst2 = pst2.executeQuery(sql2);
            
            while(rst2.next()){
                
                modelBperi2.addElement(rst2.getString("org_value"));
            }
            jListSelectBperi.setModel(modelBperi2);
           
            String sql3="Select * from org where hospno= '"+hospitalNo.getText()+"' and day = '"+input+"' and org_name = '"+name3+"' ";
            PreparedStatement pst3 = conn.prepareStatement(sql3);
            ResultSet rst3 = pst3.executeQuery(sql3);
            
            while(rst3.next()){
                
                modelBcvp2.addElement(rst3.getString("org_value"));
            }
            jListSelectBcvp.setModel(modelBcvp2);
           
            String sql4="Select * from org where hospno= '"+hospitalNo.getText()+"' and day = '"+input+"' and org_name = '"+name4+"' ";
            PreparedStatement pst4 = conn.prepareStatement(sql4);
            ResultSet rst4 = pst4.executeQuery(sql4);
            
            while(rst4.next()){
                
                modelUrine2.addElement(rst4.getString("org_value"));
            }
            jListSelectUrine.setModel(modelUrine2);
           
            String sql5="Select * from org where hospno= '"+hospitalNo.getText()+"' and day = '"+input+"' and org_name = '"+name5+"' ";
            PreparedStatement pst5 = conn.prepareStatement(sql5);
            ResultSet rst5 = pst1.executeQuery(sql5);
            
            while(rst5.next()){
                
                modelCsf2.addElement(rst5.getString("org_value"));
            }
            jListSelectCsf.setModel(modelCsf2);
           
            String sql6="Select * from org where hospno= '"+hospitalNo.getText()+"' and day = '"+input+"' and org_name = '"+name6+"' ";
            PreparedStatement pst6 = conn.prepareStatement(sql6);
            ResultSet rst6 = pst1.executeQuery(sql6);
            
            while(rst6.next()){
                
                modelPeri2.addElement(rst6.getString("org_value"));
            }
            jListSelectPeri.setModel(modelPeri2);
           
            String sql7="Select * from org where hospno= '"+hospitalNo.getText()+"' and day = '"+input+"' and org_name = '"+name7+"' ";
            PreparedStatement pst7 = conn.prepareStatement(sql7);
            ResultSet rst7 = pst1.executeQuery(sql7);
            
                        
            while(rst7.next()){
                
                modelWound2.addElement(rst7.getString("org_value"));
            }
            jListSelectWound.setModel(modelWound2);
           
           }
           catch(Exception e )
           {
               JOptionPane.showMessageDialog(null, e);    
           }
        }
    
    }//GEN-LAST:event_updateActionPerformed

    private void patient_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patient_tableMouseClicked
        int row=patient_table.getSelectedRow();
        data1 = patient_table.getModel().getValueAt(row,0).toString();
                
    }//GEN-LAST:event_patient_tableMouseClicked

    private void viewreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewreportActionPerformed
        // TODO add your handling code here:
         conn=ICUsystem.getconnection();
        try {           
            
            JasperDesign jd = JRXmlLoader.load("E:\\LNH\\ICUsystem\\src\\report\\paitentinfo.jrxml");
            String sql="select * from patientinfo where hospno='"+data1+"'";
            JRDesignQuery query = new JRDesignQuery();
            query.setText(sql);
            jd.setQuery(query);
            JasperReport jasperReport = JasperCompileManager.compileReport(jd);
            
            HashMap parameters = new HashMap();
           
           JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ICUsystem.getconnection());
           
            JasperViewer.viewReport(jasperPrint,false);
            
        } catch (JRException ex) {
            Logger.getLogger(ICUsystem.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_viewreportActionPerformed

    private void proteinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proteinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proteinActionPerformed

    private void HospNoSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HospNoSearchActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(null,"Please enter Hospital No:");
        conn = ICUsystem.getconnection();
           try{
            String sql = "Select * from patientinfo where hospno like '%"+input+"%' order by doaInHosp desc";
            pst  = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            Object[] row = new Object[4];
          
            model6= (DefaultTableModel) patient_table.getModel();
            model6.setRowCount(0);
            int i =0;
            while(rs.next()){
            i++;
            row[0]=rs.getString("hospno");
            row[1]=rs.getString("ICUoutcome");
            row[2]=rs.getString("hospOutcome");
            row[3]=rs.getDate("doaInHosp");
            model6.addRow(row);
            }
            
            braindeath.setText("Number of such patients are: "+Integer.toString(i)+"");
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);   
        }
           mainpanel.removeAll();
           mainpanel.repaint();
           mainpanel.revalidate();
           mainpanel.add(showData);
           mainpanel.repaint();
           mainpanel.revalidate();
        
        
    }//GEN-LAST:event_HospNoSearchActionPerformed

    private void pbyfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pbyfMouseClicked
        // TODO add your handling code here:
        double result = Double.valueOf(pao.getText()) / Double.valueOf(flo2.getText());
        DecimalFormat df = new DecimalFormat("#.##");
        pbyf.setText(String.valueOf(df.format(result)));
        pbyf.setEditable(false);
        
        
        
    }//GEN-LAST:event_pbyfMouseClicked

    private void pbyfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pbyfKeyPressed
        // TODO add your handling code here:

        //       double result = Double.valueOf(pao.getText()) / Double.valueOf(flo2.getText());
        //       pbyf.setText(String.valueOf(result));
        //       pbyf.setEditable(false);

    }//GEN-LAST:event_pbyfKeyPressed

    private void PAO2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PAO2MouseClicked
        // TODO add your handling code here:
        double result = Double.valueOf(flo2.getText())*713 - Double.valueOf(paco2.getText())/0.8;
        float result1 = (float)result;
        
        DecimalFormat df = new DecimalFormat("#.##");
        
        PAO2.setText(String.valueOf(df.format(result1)));
        PAO2.setEditable(false);

    }//GEN-LAST:event_PAO2MouseClicked

    private void PAO2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PAO2KeyPressed
        // TODO add your handling code here:
        //       double result = Double.valueOf(flo2.getText())*713 - Double.valueOf(paco2.getText())/0.8;
        //       float result1 = (float)result;
        //       PAO2.setText(String.valueOf(result1));
        //       PAO2.setEditable(false);
    }//GEN-LAST:event_PAO2KeyPressed

    private void gradientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradientMouseClicked
        // TODO add your handling code here:
        double result = Double.valueOf(PAO2.getText()) - Double.valueOf(pao.getText());
        float result1 = (float)result;
        DecimalFormat df = new DecimalFormat("#.##");
        gradient.setText(String.valueOf(df.format(result1)));
        gradient.setEditable(false);
    }//GEN-LAST:event_gradientMouseClicked

    private void gradientKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gradientKeyPressed
        // TODO add your handling code here:
        //       double result = Double.valueOf(PAO2.getText()) - Double.valueOf(pao.getText());
        //       float result1 = (float)result;
        //       gradient.setText(String.valueOf(result1));
        //       gradient.setEditable(false);

    }//GEN-LAST:event_gradientKeyPressed

    private void jLabel96MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel96MouseClicked
        // TODO add your handling code here:
        java.util.List listComorbidRemove;
        int listComorbidIndex[];
        listComorbidIndex= jListSelectComorbid.getSelectedIndices();
        listComorbidRemove = jListSelectComorbid.getSelectedValuesList();
    for (Object list2 : listComorbidRemove) {
        String option = list2.toString();
               model.addElement(option);
    }
    for (Integer list1 : listComorbidIndex) {
            model3.remove(list1);
        
    }
    jlistComorbids.setModel(model);
    jListSelectComorbid.setModel(model3);
    }//GEN-LAST:event_jLabel96MouseClicked

    private void jLabel94MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel94MouseClicked
        // TODO add your handling code here:
        java.util.List listComorbid;
        int listComorbidIndex[];
        listComorbidIndex= jlistComorbids.getSelectedIndices();
        listComorbid = jlistComorbids.getSelectedValuesList();
    for (Object list2 : listComorbid) {
        String option = list2.toString();
               model3.addElement(option);
    }
    for (Integer list1 : listComorbidIndex) {
            model.remove(list1);
        
    }
    jlistComorbids.setModel(model);
    jListSelectComorbid.setModel(model3);
    }//GEN-LAST:event_jLabel94MouseClicked

    private void jLabel95MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel95MouseClicked
        // TODO add your handling code here:

        java.util.List listRemoveAdd;
        int listAddIndex[];
        listRemoveAdd = jListSelectAdmission.getSelectedValuesList();
        listAddIndex=jListSelectAdmission.getSelectedIndices();

        for (Object list1 : listRemoveAdd) {
            String option = list1.toString();

            model1.addElement(option);
        }
        for (Integer list1 : listAddIndex) {
            model2.remove(list1);

        }
        jlistAdmittedtype.setModel(model1);
        jListSelectAdmission.setModel(model2);
    }//GEN-LAST:event_jLabel95MouseClicked

    private void jLabel93MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel93MouseClicked
        // TODO add your handling code here:
        java.util.List listAdd;
        int listAddIndex[];
        listAdd = jlistAdmittedtype.getSelectedValuesList();
        listAddIndex=jlistAdmittedtype.getSelectedIndices();

        for (Object list1 : listAdd) {
            String option = list1.toString();

            model2.addElement(option);
        }
        for (Integer list1 : listAddIndex) {
            model1.remove(list1);
        }
        jlistAdmittedtype.setModel(model1);
        jListSelectAdmission.setModel(model2);
    }//GEN-LAST:event_jLabel93MouseClicked

    private void hospitalDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hospitalDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hospitalDateActionPerformed

    private void ventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ventActionPerformed

    private void reAdmissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reAdmissionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reAdmissionActionPerformed

    private void nextpageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextpageMouseClicked
        clearall();
        if (timeAdmission.getText().equals(p1.getTextoHolder())){
        timeAdmission.setText("");}
        if (hospitalNo.getText().equals(p2.getTextoHolder())){
        JOptionPane.showMessageDialog(null, "Please Enter Hospital#");}
        if (hospitalNo.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Please Enter Hospital#");}
        if (diagnosisPrimary.getText().equals(p5.getTextoHolder())){
        diagnosisPrimary.setText("");}
        if (diagnosisSecondary.getText().equals(p6.getTextoHolder())){
        diagnosisSecondary.setText("");}
        if (weight.getText().equals(p3.getTextoHolder())){weight.setText("");}
        if (height.getText().equals(p4.getTextoHolder())){height.setText("");}
//inserting patient info to patient Table
        conn = ICUsystem.getconnection();
       
        java.sql.Date doaInHosp,doaInIcu,surgerydate,redodate,dodischarge,readmissionDate,DOD,extubation,reintub;
        try{doaInHosp = new java.sql.Date(doaHospital.getDate().getTime());}catch(Exception e){doaInHosp = new java.sql.Date(0000-00-00);}
        try{doaInIcu = new java.sql.Date(doaICU.getDate().getTime());}catch(Exception e){doaInIcu = new java.sql.Date(0000-00-00);}
        try{surgerydate = new java.sql.Date(dateSurgery.getDate().getTime());}catch(Exception e){surgerydate = new java.sql.Date(0000-00-00);}
        try{redodate = new java.sql.Date(dateRedo.getDate().getTime());}catch(Exception e){redodate = new java.sql.Date(0000-00-00);}
        try{dodischarge = new java.sql.Date(dateDischarge.getDate().getTime());}catch(Exception e){dodischarge = new java.sql.Date(0000-00-00);}
        try{readmissionDate = new java.sql.Date(dateReadmission.getDate().getTime());}catch(Exception e){readmissionDate = new java.sql.Date(0000-00-00);}
        try{DOD = new java.sql.Date(hospitalDate.getDate().getTime());}catch(Exception e){DOD = new java.sql.Date(0000-00-00);}
        try{reintub = new java.sql.Date(reIntubation.getDate().getTime());}catch(Exception e){reintub = new java.sql.Date(0000-00-00);}
        try{extubation = new java.sql.Date(dateExtubation.getDate().getTime());}catch(Exception e){extubation = new java.sql.Date(0000-00-00);}
        
        if (checkUpdateOrInsert == 0){
//inserting comorbids and admission type
        
        int listAddition = jListSelectAdmission.getModel().getSize();
    for (int i=0;i<listAddition;i++) {
        String option = jListSelectAdmission.getModel().getElementAt(i).toString();
                try{   
                String sql = "Insert into patient_admission_type(hospno,patient_admission_type_id) values('"+hospitalNo.getText()+"','"+option+"')";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);}
    }
    int listCom = jListSelectComorbid.getModel().getSize();
    for (int i=0;i<listCom;i++) {
        String option = jListSelectComorbid.getModel().getElementAt(i).toString();
                try{
                String sql1 = "Insert into patient_comorbid(hospno,patient_comorbid_id) values('"+hospitalNo.getText()+"','"+option+"')";
                pst = conn.prepareStatement(sql1);
                pst.execute();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);}
    }
    if (hospitalNo.getText().equals(p2.getTextoHolder())){
       }else{
        
        try{
            String sql2 = "Insert into patientinfo(hospno,time,code,age,sex,weight,height,bmi,admittedfrom,LOS,pdiagnosis,sdiagnosis,surgery,ICUoutcome,redo,lifeSustainingTherapyWithdrawn,reason,reAdmission,reasonofreadmission,hospOutcome,ApacheII,SAPS,qSOFA,nutritionriskscore,airwaytype,extubationtime,selfextubation,vent,ventilationdays,vap,cvpdays,clabsi,complications,pcauseofdeath,Brainscan,repeatscan,Escore,Mscore,Bscore,Rscore,totalscore,intubationat) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst  = conn.prepareStatement(sql2);
            pst.setString(1,hospitalNo.getText());
            pst.setString(2,timeAdmission.getText());
            pst.setString(3,code.getSelectedItem().toString());
            if ( age.getText().equals("") ) {pst.setNull(4, Types.INTEGER);} else {pst.setInt(4,Integer.parseInt(age.getText()));}
            pst.setString(5,sex.getSelectedItem().toString());
            if (weight.getText().equals("")) {pst.setNull(6, Types.DOUBLE);} else {pst.setDouble(6,Double.parseDouble(weight.getText()));}
            if (height.getText().equals("")) {pst.setNull(7, Types.DOUBLE);} else {pst.setDouble(7,Double.parseDouble(height.getText()));}
            if ( bmi.getText().equals("") ) {pst.setNull(8, Types.DOUBLE);} else {pst.setDouble(8,Double.parseDouble(bmi.getText()));}
            pst.setString(9,admittedFrom.getSelectedItem().toString());
            if ( los.getText().equals("") ) {pst.setNull(10, Types.INTEGER);} else {pst.setInt(10,Integer.parseInt(los.getText()));}
            pst.setString(11,diagnosisPrimary.getText());
            pst.setString(12,diagnosisSecondary.getText());
            pst.setString(13,surgery.getText());
            pst.setString(14,icuOutcome.getSelectedItem().toString());
            pst.setString(15,redoSurgery.getText());
            pst.setString(16,lifeTherapy.getSelectedItem().toString());
            pst.setString(17,reasonWithdrawn.getText());
            pst.setString(18,reAdmission.getSelectedItem().toString());
            pst.setString(19,reasonReadmission.getText());
            pst.setString(20,hospitalOutcome.getSelectedItem().toString());
            if ( apache.getText().equals("") ) {pst.setNull(21, Types.INTEGER);} else {pst.setInt(21,Integer.parseInt(apache.getText()));}
            if ( saps.getText().equals("") ) {pst.setNull(22, Types.INTEGER);} else {pst.setInt(22,Integer.parseInt(saps.getText()));}
//            if ( sofa.getText().equals("") ) {pst.setNull(23, Types.INTEGER);} else {pst.setInt(23,Integer.parseInt(sofa.getText()));}
            if ( qSofa.getText().equals("") ) {pst.setNull(23, Types.INTEGER);} else {pst.setInt(23,Integer.parseInt(qSofa.getText()));}
           if ( nutRiskScore.getText().equals("") ) {pst.setNull(24, Types.INTEGER);} else {pst.setInt(24,Integer.parseInt(nutRiskScore.getText()));} 
           pst.setString(25,airwayType.getSelectedItem().toString());
           pst.setString(26,extubationTime.getText());
           pst.setString(27,selfExtubation.getSelectedItem().toString());
           pst.setString(28,vent.getSelectedItem().toString());
           if ( ventilationDays.getText().equals("") ) {pst.setNull(29, Types.INTEGER);} else {pst.setInt(29,Integer.parseInt(ventilationDays.getText()));}
           pst.setString(30,vap.getSelectedItem().toString());
           if ( cvpDays.getText().equals("") ) {pst.setNull(31, Types.INTEGER);} else {pst.setInt(31,Integer.parseInt(cvpDays.getText()));}
           pst.setString(32,clabsi.getSelectedItem().toString());
           pst.setString(33,complication.getText());
           pst.setString(34,reasonOfDeath.getText());
           pst.setString(35,brainScan.getText());
           pst.setString(36,repeatBrainScan.getText());
           if ( e.getText().equals("") ) {pst.setNull(37, Types.INTEGER);} else {pst.setInt(37,Integer.parseInt(e.getText()));} 
           if ( m.getText().equals("") ) {pst.setNull(38, Types.INTEGER);} else {pst.setInt(38,Integer.parseInt(m.getText()));}
           if ( b.getText().equals("") ) {pst.setNull(39, Types.INTEGER);} else {pst.setInt(39,Integer.parseInt(b.getText()));}
           if ( r.getText().equals("") ) {pst.setNull(40, Types.INTEGER);} else {pst.setInt(40,Integer.parseInt(r.getText()));}
           if ( total.getText().equals("") ) {pst.setNull(41, Types.INTEGER);} else {pst.setInt(41,Integer.parseInt(total.getText()));}
           pst.setString(42,intubationAt.getSelectedItem().toString());
           pst.execute();
           
           String sql3 = "update patientinfo set doaInHosp=?,doaInIcu=?,surgerydate=?,redodate=?,dodischarge=?,readmissionDate=?,DOD=?,extubation=?,reintubation=? where hospno = '"+hospitalNo.getText()+"'";
           PreparedStatement ps = conn.prepareStatement(sql3);
           ps.setDate(1,doaInHosp);
           ps.setDate(2,doaInIcu);
           ps.setDate(3,surgerydate);
           ps.setDate(4,redodate);
           ps.setDate(5,dodischarge);
           ps.setDate(6,readmissionDate);
           ps.setDate(7,DOD);
           ps.setDate(8,extubation);
           ps.setDate(9,reintub);
           ps.execute();
           days.setText("0");
            //moving to new page
            //Remove panels
            mainpanel.removeAll();
            mainpanel.repaint();
            mainpanel.revalidate();
            //Add panels
            mainpanel.add(addpatient1);
            mainpanel.repaint();
            mainpanel.revalidate();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);   
        }
    }
    
    }
    if(checkUpdateOrInsert == 1){
    try{
        int listAddition = jListSelectAdmission.getModel().getSize();
        if(listAddition == 0){
} else {    try{
            String sqldel="delete from patient_admission_type where hospno='"+hospitalNo.getText()+"'";
                   pst=conn.prepareStatement(sqldel);
                   pst.execute();}catch(Exception e){JOptionPane.showMessageDialog(null, e);
                   }
            for (int i=0;i<listAddition;i++) {
        String option = jListSelectAdmission.getModel().getElementAt(i).toString();
                try{   
                String sql = "Insert into patient_admission_type(hospno,patient_admission_type_id) values('"+hospitalNo.getText()+"','"+option+"')";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);}
    } }
    int listCom = jListSelectComorbid.getModel().getSize();
        if(listCom == 0){}else{
        try{
            String sqldel="delete from patient_comorbid where hospno='"+hospitalNo.getText()+"'";
                   pst=conn.prepareStatement(sqldel);
                   pst.execute();}catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    
        for (int i=0;i<listCom;i++) {
        String option = jListSelectComorbid.getModel().getElementAt(i).toString();
                try{
                String sql1 = "Insert into patient_comorbid(hospno,patient_comorbid_id) values('"+hospitalNo.getText()+"','"+option+"')";
                pst = conn.prepareStatement(sql1);
                pst.execute();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);}}
        }
    String sql1Update = "Update patientinfo set time=?,code=?,age=?,sex=?,weight=?,height=?,bmi=?,admittedfrom=?,LOS=?,pdiagnosis=?,sdiagnosis=?,surgery=?,ICUoutcome=?,redo=?,lifeSustainingTherapyWithdrawn=?,reason=?,reAdmission=?,reasonofreadmission=?,hospOutcome=?,ApacheII=?,SAPS=?,qSOFA=?,nutritionriskscore=?,airwaytype=?,extubationtime=?,selfextubation=?,vent=?,ventilationdays=?,vap=?,cvpdays=?,clabsi=?,complications=?,pcauseofdeath=?,Brainscan=?,repeatscan=?,Escore=?,Mscore=?,Bscore=?,Rscore=?,totalscore=?,intubationat=? where hospno='"+hospitalNo.getText()+"' ";
    pst  = conn.prepareStatement(sql1Update);
            pst.setString(1,timeAdmission.getText());
            pst.setString(2,code.getSelectedItem().toString());
            if ( age.getText().equals("") ) {pst.setNull(3, Types.INTEGER);} else {pst.setInt(3,Integer.parseInt(age.getText()));}
            pst.setString(4,sex.getSelectedItem().toString());
            if (weight.getText().equals("")) {pst.setNull(5, Types.DOUBLE);} else {pst.setDouble(5,Double.parseDouble(weight.getText()));}
            if (height.getText().equals("")) {pst.setNull(6, Types.DOUBLE);} else {pst.setDouble(6,Double.parseDouble(height.getText()));}
            if ( bmi.getText().equals("") ) {pst.setNull(7, Types.DOUBLE);} else {pst.setDouble(7,Double.parseDouble(bmi.getText()));}
            pst.setString(8,admittedFrom.getSelectedItem().toString());
            if ( los.getText().equals("") ) {pst.setNull(9, Types.INTEGER);} else {pst.setInt(9,Integer.parseInt(los.getText()));}
            pst.setString(10,diagnosisPrimary.getText());
            pst.setString(11,diagnosisSecondary.getText());
            pst.setString(12,surgery.getText());
            pst.setString(13,icuOutcome.getSelectedItem().toString());
            pst.setString(14,redoSurgery.getText());
            pst.setString(15,lifeTherapy.getSelectedItem().toString());
            pst.setString(16,reasonWithdrawn.getText());
            pst.setString(17,reAdmission.getSelectedItem().toString());
            pst.setString(18,reasonReadmission.getText());
            pst.setString(19,hospitalOutcome.getSelectedItem().toString());
            if ( apache.getText().equals("") ) {pst.setNull(20, Types.INTEGER);} else {pst.setInt(20,Integer.parseInt(apache.getText()));}
            if ( saps.getText().equals("") ) {pst.setNull(21, Types.INTEGER);} else {pst.setInt(21,Integer.parseInt(saps.getText()));}
//            if ( sofa.getText().equals("") ) {pst.setNull(22, Types.INTEGER);} else {pst.setInt(22,Integer.parseInt(sofa.getText()));}
            if ( qSofa.getText().equals("") ) {pst.setNull(22, Types.INTEGER);} else {pst.setInt(22,Integer.parseInt(qSofa.getText()));}
           if ( nutRiskScore.getText().equals("") ) {pst.setNull(23, Types.INTEGER);} else {pst.setInt(23,Integer.parseInt(nutRiskScore.getText()));} 
           pst.setString(24,airwayType.getSelectedItem().toString());
           pst.setString(25,extubationTime.getText());
           pst.setString(26,selfExtubation.getSelectedItem().toString());
           pst.setString(27,vent.getSelectedItem().toString());
           if ( ventilationDays.getText().equals("") ) {pst.setNull(28, Types.INTEGER);} else {pst.setInt(28,Integer.parseInt(ventilationDays.getText()));}
           pst.setString(29,vap.getSelectedItem().toString());
           if ( cvpDays.getText().equals("") ) {pst.setNull(30, Types.INTEGER);} else {pst.setInt(30,Integer.parseInt(cvpDays.getText()));}
           pst.setString(31,clabsi.getSelectedItem().toString());
           pst.setString(32,complication.getText());
           pst.setString(33,reasonOfDeath.getText());
           pst.setString(34,brainScan.getText());
           pst.setString(35,repeatBrainScan.getText());
           if ( e.getText().equals("") ) {pst.setNull(36, Types.INTEGER);} else {pst.setInt(36,Integer.parseInt(e.getText()));} 
           if ( m.getText().equals("") ) {pst.setNull(37, Types.INTEGER);} else {pst.setInt(37,Integer.parseInt(m.getText()));}
           if ( b.getText().equals("") ) {pst.setNull(38, Types.INTEGER);} else {pst.setInt(38,Integer.parseInt(b.getText()));}
           if ( r.getText().equals("") ) {pst.setNull(39, Types.INTEGER);} else {pst.setInt(39,Integer.parseInt(r.getText()));}
           if ( total.getText().equals("") ) {pst.setNull(40, Types.INTEGER);} else {pst.setInt(40,Integer.parseInt(total.getText()));}
           pst.setString(41,intubationAt.getSelectedItem().toString());
           pst.execute();
           
           String sql3 = "update patientinfo set doaInHosp=?,doaInIcu=?,surgerydate=?,redodate=?,dodischarge=?,readmissionDate=?,DOD=?,extubation=?,reintubation=? where hospno = '"+hospitalNo.getText()+"'";
           PreparedStatement ps = conn.prepareStatement(sql3);
           ps.setDate(1,doaInHosp);
           ps.setDate(2,doaInIcu);
           ps.setDate(3,surgerydate);
           ps.setDate(4,redodate);
           ps.setDate(5,dodischarge);
           ps.setDate(6,readmissionDate);
           ps.setDate(7,DOD);
           ps.setDate(8,extubation);
           ps.setDate(9,reintub);
           ps.execute();
           checkUpdateOrInsert=0;
           
           //moving to new page
            //Remove panels
            mainpanel.removeAll();
            mainpanel.repaint();
            mainpanel.revalidate();
            //Add panels
            mainpanel.add(addpatient1);
            mainpanel.repaint();
            mainpanel.revalidate();
    }catch(Exception e){JOptionPane.showMessageDialog(null,e);}    
 
    try{
        String sqlday="select max(day) from daywisecheckup where hospno='"+hospitalNo.getText()+"'";
        pst=conn.prepareStatement(sqlday);
        rs=pst.executeQuery(sqlday);
        if(rs.next()){   
        int daycount = Integer.parseInt(rs.getString("max(day)"));
        daycount++;
        days.setText(String.valueOf(daycount));
        
        }else{
        days.setText("0");
        
        }
        }catch(Exception e){days.setText("0");}
        checkUpdateOrInsert=0;
       }

    }//GEN-LAST:event_nextpageMouseClicked

    private void totalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalMouseClicked
        // TODO add your handling code here:
        int evalue = Integer.valueOf(e.getText());
        int mvalue = Integer.valueOf(m.getText());
        int bvalue = Integer.valueOf(b.getText());
        int rvalue = Integer.valueOf(r.getText());
        total.setText(String.valueOf(evalue+mvalue+bvalue+rvalue));
    }//GEN-LAST:event_totalMouseClicked

    private void rFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rFocusLost
        // TODO add your handling code here:
        try{ int rs=Integer.valueOf(r.getText());}catch(NumberFormatException n){JOptionPane.showMessageDialog(null, "Enter Valid R Value");}
    }//GEN-LAST:event_rFocusLost

    private void bFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bFocusLost
        // TODO add your handling code here:
        try{ int bs=Integer.valueOf(b.getText());}catch(NumberFormatException n){JOptionPane.showMessageDialog(null, "Enter Valid B Value");}
    }//GEN-LAST:event_bFocusLost

    private void mFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mFocusLost
        // TODO add your handling code here:
        try{ int ms=Integer.valueOf(m.getText());}catch(NumberFormatException n){JOptionPane.showMessageDialog(null, "Enter Valid M Value");}
    }//GEN-LAST:event_mFocusLost

    private void eFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_eFocusLost
        // TODO add your handling code here:
        try{ int es=Integer.valueOf(e.getText());}catch(NumberFormatException n){JOptionPane.showMessageDialog(null, "Enter Valid E Value");}

    }//GEN-LAST:event_eFocusLost

    private void cvpDaysFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cvpDaysFocusLost
        // TODO add your handling code here:
        try{ int cvD=Integer.valueOf(cvpDays.getText());}catch(NumberFormatException n){JOptionPane.showMessageDialog(null, "Enter Valid CVP Value");}
    }//GEN-LAST:event_cvpDaysFocusLost

    private void ventilationDaysFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ventilationDaysFocusLost
        // TODO add your handling code here:
        try{ int vD=Integer.valueOf(ventilationDays.getText());}catch(NumberFormatException n){JOptionPane.showMessageDialog(null, "Enter Valid Ventilation Days Value");}
    }//GEN-LAST:event_ventilationDaysFocusLost

    private void intubationAtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intubationAtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_intubationAtActionPerformed

    private void nutRiskScoreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nutRiskScoreFocusLost
        // TODO add your handling code here:
        try{ int nurRisk=Integer.valueOf(nutRiskScore.getText());}catch(NumberFormatException n){JOptionPane.showMessageDialog(null, "Enter Valid Nutrition Score");}
    }//GEN-LAST:event_nutRiskScoreFocusLost

    private void qSofaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_qSofaFocusLost
        // TODO add your handling code here:
        try{ int qSofas=Integer.valueOf(qSofa.getText());}catch(NumberFormatException n){JOptionPane.showMessageDialog(null, "Enter Valid qSofa Value");}
    }//GEN-LAST:event_qSofaFocusLost

    private void sapsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sapsFocusLost
        // TODO add your handling code here:
        try{ int sapss=Integer.valueOf(saps.getText());}catch(NumberFormatException n){JOptionPane.showMessageDialog(null, "Enter Valid Saps Value");}
    }//GEN-LAST:event_sapsFocusLost

    private void apacheFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_apacheFocusLost
        // TODO add your handling code here:
        try{ int apaches=Integer.valueOf(apache.getText());}catch(NumberFormatException n){JOptionPane.showMessageDialog(null, "Enter Valid Apache value");}
    }//GEN-LAST:event_apacheFocusLost

    private void reasonReadmissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reasonReadmissionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reasonReadmissionActionPerformed

    private void reasonWithdrawnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reasonWithdrawnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reasonWithdrawnActionPerformed

    private void losActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_losActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_losActionPerformed

    private void losFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_losFocusLost
        // TODO add your handling code here:
        try{ int loss=Integer.valueOf(los.getText());}catch(NumberFormatException n){JOptionPane.showMessageDialog(null, "Enter Valid Value Of Los");}
    }//GEN-LAST:event_losFocusLost

    private void admittedFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admittedFromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_admittedFromActionPerformed

    private void bmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bmiActionPerformed

    private void bmiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bmiMouseClicked
        double weightbmi = Double.valueOf(weight.getText());
        double heightbmi = Double.valueOf(height.getText());
        double heightInM = heightbmi/100;
        DecimalFormat df = new DecimalFormat("#.##");
        bmi.setText(String.valueOf(df.format((weightbmi)/(heightInM*heightInM))));
        bmi.setEditable(false);

    }//GEN-LAST:event_bmiMouseClicked

    private void sexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexActionPerformed

    private void ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageActionPerformed

    private void ageFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ageFocusLost
        // TODO add your handling code here:
        try{ int ages=Integer.valueOf(age.getText());}catch(NumberFormatException n){JOptionPane.showMessageDialog(null, "Enter Valid Age");}
    }//GEN-LAST:event_ageFocusLost

    private void codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeActionPerformed

    private void timeAdmissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeAdmissionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeAdmissionActionPerformed

    private void hospitalNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hospitalNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hospitalNoActionPerformed

    private void generateExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateExcelActionPerformed
        // TODO add your handling code here:
        try{
            String sql="select * from patientinfo";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            File f= new File("C:\\Users\\Bilal\\Desktop\\reportExcel.csv");
            WritableWorkbook myexcel = Workbook.createWorkbook(f);
            WritableSheet sheet = myexcel.createSheet("Patient Sheet", 0);
            Label label = new Label(0,0,"Hospital No");
            Label label1 = new Label(1,0,"DOA Hospital");
            Label label2 = new Label(2,0,"DOA ICU");
            Label label3 = new Label(3,0,"Time");
            Label label4 = new Label(4,0,"Code");
            Label label5 = new Label(5,0,"Age");
            Label label6 = new Label(6,0,"Sex");
            Label label7 = new Label(7,0,"Weight");
            Label label8 = new Label(8,0,"Height");
            Label label9 = new Label(9,0,"BMI");
            Label label10 = new Label(10,0,"Admitted From");
            Label label11 = new Label(11,0,"Admission Type 1");
            Label label12 = new Label(12,0,"Admission Type 2");
            Label label13 = new Label(13,0,"Admission Type 3");
            Label label14 = new Label(14,0,"Comorbids 1");
            Label label15 = new Label(15,0,"Comorbids 2");
            Label label16 = new Label(16,0,"Comorbids 3");
            Label label17 = new Label(17,0,"Comorbids 4");
            Label label18 = new Label(18,0,"Comorbids 5");
            Label label19 = new Label(19,0,"Comorbids 6");
            Label label20 = new Label(20,0,"Comorbids 7");
            Label label21 = new Label(21,0,"Comorbids 8");
            Label label22 = new Label(22,0,"Pri. Diagnosis");
            Label label23 = new Label(23,0,"Sec. Diagnosis");
            Label label24 = new Label(24,0,"Surgery");
            Label label25 = new Label(25,0,"Date Surgery");
            Label label26 = new Label(26,0,"Redo Surgery");
            Label label27 = new Label(27,0,"Date Redo");
            Label label28 = new Label(28,0,"ICU Outcome");
            Label label29 = new Label(29,0,"Discharge Date");
            Label label30 = new Label(30,0,"LOS");
            Label label31 = new Label(31,0,"Life therapy");
            Label label32 = new Label(32,0,"Reason");
            Label label33 = new Label(33,0,"ICU Readmission");
            Label label34 = new Label(34,0,"Reason");
            Label label35 = new Label(35,0,"Date");
            Label label36 = new Label(36,0,"Hospital Outcome");
            Label label37 = new Label(37,0,"Hospital Out Date");
            Label label38 = new Label(38,0,"Apache II");
            Label label39 = new Label(39,0,"SAPS II");
            Label label40 = new Label(40,0,"qSOFA");
            Label label41 = new Label(41,0,"NUTRIC Score");
            Label label42 = new Label(42,0,"Airway");
            Label label43 = new Label(43,0,"Intubation At");
            Label label44 = new Label(44,0,"Extubation");
            Label label45 = new Label(45,0,"Time Extubation");
            Label label46 = new Label(46,0,"Re Intubation");
            Label label47 = new Label(47,0,"Self Extubation");
            Label label48 = new Label(48,0,"Ventilation Days");
            Label label49 = new Label(49,0,"VAP");
            Label label50 = new Label(50,0,"CVP Days");
            Label label51 = new Label(51,0,"Clabsi");
            Label label52 = new Label(52,0,"Complication");
            Label label53 = new Label(53,0,"Cause Of Death");
            Label label54 = new Label(54,0,"Brain Scan");
            Label label55 = new Label(55,0,"Repeat Scan");
            Label label56 = new Label(56,0,"E Value");
            Label label57 = new Label(57,0,"M Value");
            Label label58 = new Label(58,0,"B Value");
            Label label59 = new Label(59,0,"R Value");
            Label label60 = new Label(60,0,"Total");

            //        Label label60 = new Label(60,0,"Hospital No");
            //        Label label61 = new Label(61,0,"Hospital No");
            sheet.addCell(label);
            sheet.addCell(label1);
            sheet.addCell(label2);
            sheet.addCell(label3);
            sheet.addCell(label4);
            sheet.addCell(label5);
            sheet.addCell(label6);
            sheet.addCell(label7);
            sheet.addCell(label8);
            sheet.addCell(label9);
            sheet.addCell(label10);
            sheet.addCell(label11);
            sheet.addCell(label12);
            sheet.addCell(label13);
            sheet.addCell(label14);
            sheet.addCell(label15);
            sheet.addCell(label16);
            sheet.addCell(label17);
            sheet.addCell(label18);
            sheet.addCell(label19);
            sheet.addCell(label20);
            sheet.addCell(label21);
            sheet.addCell(label22);
            sheet.addCell(label23);
            sheet.addCell(label24);
            sheet.addCell(label25);
            sheet.addCell(label26);
            sheet.addCell(label27);
            sheet.addCell(label28);
            sheet.addCell(label29);
            sheet.addCell(label30);
            sheet.addCell(label31);
            sheet.addCell(label32);
            sheet.addCell(label33);
            sheet.addCell(label34);
            sheet.addCell(label35);
            sheet.addCell(label36);
            sheet.addCell(label37);
            sheet.addCell(label38);
            sheet.addCell(label39);
            sheet.addCell(label40);
            sheet.addCell(label41);
            sheet.addCell(label42);
            sheet.addCell(label43);
            sheet.addCell(label44);
            sheet.addCell(label45);
            sheet.addCell(label46);
            sheet.addCell(label47);
            sheet.addCell(label48);
            sheet.addCell(label49);
            sheet.addCell(label50);
            sheet.addCell(label51);
            sheet.addCell(label52);
            sheet.addCell(label53);
            sheet.addCell(label54);
            sheet.addCell(label55);
            sheet.addCell(label56);
            sheet.addCell(label57); 
            sheet.addCell(label58);
            sheet.addCell(label59);
            sheet.addCell(label60);
            int i=1;
            while(rs.next()){
                Label l=new Label(0,i,rs.getString("hospno"));
                Label l1 = new Label(1,i,rs.getString("doaInHosp"));
                Label l2 = new Label(2,i,rs.getString("doaInIcu"));
                Label l3 = new Label(3,i,rs.getString("time"));
                Label l4 = new Label(4,i,rs.getString("code"));
                Label l5 = new Label(5,i,rs.getString("age"));
                Label l6 = new Label(6,i,rs.getString("sex"));
                Label l7 = new Label(7,i,rs.getString("weight"));
                Label l8 = new Label(8,i,rs.getString("height"));
                Label l9 = new Label(9,i,rs.getString("bmi"));
                Label l10 = new Label(10,i,rs.getString("admittedfrom"));
                try{
                    String sqlAdmittedType = "select * from patient_admission_type where hospno='"+rs.getString("hospno")+"'";
                    PreparedStatement pstj=conn.prepareStatement(sqlAdmittedType);
                    ResultSet rsj=pstj.executeQuery(sqlAdmittedType);
                    int j=11;
                    while(rsj.next()){
                        Label l11 = new Label(j,i,rsj.getString("patient_admission_type_id"));
                        j++;
                        sheet.addCell(l11);
                    }
                }catch(Exception e)
                {JOptionPane.showMessageDialog(null, e);}
                try{
                    String sqlComorbidsType = "select * from patient_comorbid where hospno='"+rs.getString("hospno")+"'";
                    PreparedStatement pstk=conn.prepareStatement(sqlComorbidsType);
                    ResultSet rsk=pstk.executeQuery(sqlComorbidsType);
                    int k=14;
                    while(rsk.next()){
                        Label l12 = new Label(k,i,rsk.getString("patient_comorbid_id"));
                        k++;
                        sheet.addCell(l12);
                    }
                }catch(Exception e)
                {}

                Label l13 = new Label(22,i,rs.getString("pdiagnosis"));
                Label l14 = new Label(23,i,rs.getString("sdiagnosis"));
                Label l15 = new Label(24,i,rs.getString("surgery"));
                Label l16 = new Label(25,i,rs.getString("surgerydate"));
                Label l17 = new Label(26,i,rs.getString("redo"));
                Label l18 = new Label(27,i,rs.getString("redodate"));
                Label l19 = new Label(28,i,rs.getString("ICUoutcome"));
                Label l20 = new Label(29,i,rs.getString("dodischarge"));
                Label l21 = new Label(30,i,rs.getString("LOS"));
                Label l22 = new Label(31,i,rs.getString("lifeSustainingTherapyWithdrawn"));
                Label l23 = new Label(32,i,rs.getString("reason"));
                Label l24 = new Label(33,i,rs.getString("reAdmission"));
                Label l25 = new Label(34,i,rs.getString("reasonofreadmission"));
                Label l26 = new Label(35,i,rs.getString("readmissionDate"));
                Label l27 = new Label(36,i,rs.getString("hospOutcome"));
                Label l28 = new Label(37,i,rs.getString("DOD"));
                Label l29 = new Label(38,i,rs.getString("ApacheII"));
                Label l30 = new Label(39,i,rs.getString("SAPS"));
                Label l31 = new Label(40,i,rs.getString("qSOFA"));
                Label l32 = new Label(41,i,rs.getString("nutritionriskscore"));
                Label l33 = new Label(42,i,rs.getString("airwaytype"));
                Label l34 = new Label(43,i,rs.getString("intubationat"));
                Label l35 = new Label(44,i,rs.getString("extubation"));
                Label l36 = new Label(45,i,rs.getString("extubationtime"));
                Label l37 = new Label(46,i,rs.getString("reintubation"));
                Label l38 = new Label(47,i,rs.getString("selfextubation"));
                Label l39 = new Label(48,i,rs.getString("ventilationdays"));
                Label l40 = new Label(49,i,rs.getString("vap"));
                Label l41 = new Label(50,i,rs.getString("cvpdays"));
                Label l42 = new Label(51,i,rs.getString("clabsi"));
                Label l43 = new Label(52,i,rs.getString("complications"));
                Label l44 = new Label(53,i,rs.getString("pcauseofdeath"));
                Label l45 = new Label(54,i,rs.getString("Brainscan"));
                Label l46 = new Label(55,i,rs.getString("repeatscan"));
                Label l47 = new Label(56,i,rs.getString("Escore"));
                Label l48 = new Label(57,i,rs.getString("Mscore"));
                Label l49 = new Label(58,i,rs.getString("Bscore"));
                Label l50 = new Label(59,i,rs.getString("Rscore"));
                Label l51 = new Label(60,i,rs.getString("totalscore"));
                sheet.addCell(l);
                sheet.addCell(l1);
                sheet.addCell(l2);
                sheet.addCell(l3);
                sheet.addCell(l4);
                sheet.addCell(l5);
                sheet.addCell(l6);
                sheet.addCell(l7);
                sheet.addCell(l8);
                sheet.addCell(l9);
                sheet.addCell(l10);
                sheet.addCell(l13);
                sheet.addCell(l14);
                sheet.addCell(l15);
                sheet.addCell(l16);
                sheet.addCell(l17);
                sheet.addCell(l18);
                sheet.addCell(l19);
                sheet.addCell(l20);
                sheet.addCell(l21);
                sheet.addCell(l22);
                sheet.addCell(l23);
                sheet.addCell(l24);
                sheet.addCell(l25);
                sheet.addCell(l26);
                sheet.addCell(l27);
                sheet.addCell(l28);
                sheet.addCell(l29);
                sheet.addCell(l30);
                sheet.addCell(l31);
                sheet.addCell(l32);
                sheet.addCell(l33);
                sheet.addCell(l34);
                sheet.addCell(l35);
                sheet.addCell(l36);
                sheet.addCell(l37);
                sheet.addCell(l38);
                sheet.addCell(l39);
                sheet.addCell(l40);
                sheet.addCell(l41);
                sheet.addCell(l42);
                sheet.addCell(l43);
                sheet.addCell(l44);
                sheet.addCell(l45);
                sheet.addCell(l46);
                sheet.addCell(l47);
                sheet.addCell(l48);
                sheet.addCell(l49);
                sheet.addCell(l50);
                sheet.addCell(l51);
                
                
                i++;
            }
            myexcel.write();
            myexcel.close();

        }catch(Exception e){}
    }//GEN-LAST:event_generateExcelActionPerformed

    private void generateExcel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateExcel1ActionPerformed
        // TODO add your handling code here:
        
        try{
            String sql="select * from daywisecheckup" ;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            File f= new File("C:\\Users\\Bilal\\Desktop\\reportExcel1.csv");
            WritableWorkbook myexcel = Workbook.createWorkbook(f);
            WritableSheet sheet = myexcel.createSheet("Daily Sheet", 0);
            Label label0 = new Label(0,0,"HospNo");
            Label label1 = new Label(1,0,"day");
            Label label2 = new Label(2,0,"hr");
            Label label3 = new Label(3,0,"sbp");
            Label label4 = new Label(4,0,"dbp");
            Label label5 = new Label(5,0,"map");
            Label label6 = new Label(6,0,"temp");
            Label label7 = new Label(7,0,"rr");
            Label label8 = new Label(8,0,"gcs");
            Label label9 = new Label(9,0,"rass");
            Label label10 = new Label(10,0,"delirium");
            Label label11 = new Label(11,0,"painscore");
            Label label12 = new Label(12,0,"ph");
            Label label13 = new Label(13,0,"paco2");
            Label label14 = new Label(14,0,"pao");
            Label label15 = new Label(15,0,"flo2");
            Label label16 = new Label(16,0,"hco3");
            Label label17 = new Label(17,0,"baseexcess");
            Label label18 = new Label(18,0,"urea");
            Label label19 = new Label(19,0,"creatinine");
            Label label20 = new Label(20,0,"na");
            Label label21 = new Label(21,0,"k");
            Label label22 = new Label(22,0,"cl");
            Label label23 = new Label(23,0,"hb");
            Label label24 = new Label(24,0,"hct");
            Label label25 = new Label(25,0,"plateletes");
            Label label26 = new Label(26,0,"wbc");
            Label label27 = new Label(27,0,"ptinr");
            Label label28 = new Label(28,0,"fibrinog");
            Label label29 = new Label(29,0,"ddimer");
            Label label30 = new Label(30,0,"mg");
            
            Label label31 = new Label(31,0,"po4");
            Label label32 = new Label(32,0,"ca");
            Label label33 = new Label(33,0,"caion");
            Label label34 = new Label(34,0,"bilirubin");
            Label label35 = new Label(35,0,"alt");
            Label label36 = new Label(36,0,"ast");
            Label label37 = new Label(37,0,"alkphos");
            Label label38 = new Label(38,0,"ggt");
            Label label39 = new Label(39,0,"amylase");
            Label label40 = new Label(40,0,"lipase");
            
            Label label41 = new Label(41,0,"albumen");
            Label label42 = new Label(42,0,"ldh");
            Label label43 = new Label(43,0,"cpk");
            Label label44 = new Label(44,0,"trop1");
            Label label45 = new Label(45,0,"bnp");
            Label label46 = new Label(46,0,"lactate");
            Label label47 = new Label(47,0,"pct");
            Label label48 = new Label(48,0,"crp");
            Label label49 = new Label(49,0,"bsrmin");
            Label label50 = new Label(50,0,"bsrmax");
            
            Label label51 = new Label(51,0,"spotUSodium");
            Label label52 = new Label(52,0,"dvtpropylaxis");
            Label label53 = new Label(53,0,"dialysis");
            Label label54 = new Label(54,0,"vasopressors");
            Label label55 = new Label(55,0,"norepinephrine");
            Label label56 = new Label(56,0,"dobutamine");
            Label label57 = new Label(57,0,"dopamine");
            Label label58 = new Label(58,0,"epinephrine");
            Label label59 = new Label(59,0,"phenylephrine");
            Label label60 = new Label(60,0,"steriodsld");
            
            Label label61 = new Label(61,0,"ventilate");
            Label label62 = new Label(62,0,"mode");
            Label label63 = new Label(63,0,"vt");
            Label label64 = new Label(64,0,"ps");
            Label label65 = new Label(65,0,"peep");
            Label label66 = new Label(66,0,"ppeak");
            Label label67 = new Label(67,0,"pplat");
            Label label68 = new Label(68,0,"cstat");
            Label label69 = new Label(69,0,"ETTcuffpress");
            Label label70 = new Label(70,0,"weaning");
            
            Label label71 = new Label(71,0,"extubniv");
            Label label72 = new Label(72,0,"tpiece");
            Label label73 = new Label(73,0,"fluidbalance");
            Label label74 = new Label(74,0,"urineOutput");
            Label label75 = new Label(75,0,"otherlosses");
            Label label76 = new Label(76,0,"otherlosses");
            Label label77 = new Label(77,0,"outputTotal");
            Label label78 = new Label(78,0,"intakeTotal");
            Label label79 = new Label(79,0,"balance");
            Label label80 = new Label(80,0,"cumbalance");
            
            Label label81 = new Label(81,0,"IVFluids");
            Label label82 = new Label(82,0,"crystalloid");
            Label label83 = new Label(83,0,"colloid");
            Label label84 = new Label(84,0,"bloodPRCBS");
            Label label85 = new Label(85,0,"plateletunit");
            Label label86 = new Label(86,0,"ffps");
            Label label87 = new Label(87,0,"complicat");
            Label label88 = new Label(88,0,"Aline");
            Label label89 = new Label(89,0,"cvpmin");
            Label label90 = new Label(90,0,"cvpmax");
              
            Label label91 = new Label(91,0,"route");
            Label label92 = new Label(92,0,"formula");
            Label label93 = new Label(93,0,"dopplr");
            Label label94 = new Label(94,0,"pocus");
            Label label95 = new Label(95,0,"cvpmax");
            Label label96 = new Label(96,0,"tracheal");
            Label label97 = new Label(97,0,"bloodPeripheral");
            Label label98 = new Label(98,0,"urine");
            Label label99 = new Label(99,0,"csf");
            Label label100 = new Label(100,0,"peritoneal");
            Label label101 = new Label(101,0,"wound");
            Label label102 = new Label(102,0,"bloodCvp");
            Label label103 = new Label(103,0,"others");
            Label label104 = new Label(104,0,"cal");
            Label label105 = new Label(105,0,"Protein");
            Label label106 = new Label(106,0,"Sofa");
            Label label107 = new Label(107,0,"paco3/fio2");
            Label label108 = new Label(108,0,"PAO2");
            
            Label label109 = new Label(109,0,"gradient");
            Label label110 = new Label(110,0,"cryoppt");
             
            sheet.addCell(label0);
            sheet.addCell(label1);
            sheet.addCell(label2);
            sheet.addCell(label3);
            sheet.addCell(label4);
            sheet.addCell(label5);
            sheet.addCell(label6);
            sheet.addCell(label7);
            sheet.addCell(label8);
            sheet.addCell(label9);
            sheet.addCell(label10);
            sheet.addCell(label11);
            sheet.addCell(label12);
            sheet.addCell(label13);
            sheet.addCell(label14);
            sheet.addCell(label15);
            sheet.addCell(label16);
            sheet.addCell(label17);
            sheet.addCell(label18);
            sheet.addCell(label19);
            sheet.addCell(label20);
            
            sheet.addCell(label21);
            sheet.addCell(label22);
            sheet.addCell(label23);
            sheet.addCell(label24);
            sheet.addCell(label25);
            sheet.addCell(label26);
            sheet.addCell(label27);
            sheet.addCell(label28);
            sheet.addCell(label29);
            sheet.addCell(label30);
            
            sheet.addCell(label31);
            sheet.addCell(label32);
            sheet.addCell(label33);
            sheet.addCell(label34);
            sheet.addCell(label35);
            sheet.addCell(label36);
            sheet.addCell(label37);
            sheet.addCell(label38);
            sheet.addCell(label39);
            sheet.addCell(label40);
            
            sheet.addCell(label41);
            sheet.addCell(label42);
            sheet.addCell(label43);
            sheet.addCell(label44);
            sheet.addCell(label45);
            sheet.addCell(label46);
            sheet.addCell(label47);
            sheet.addCell(label48);
            sheet.addCell(label49);
            sheet.addCell(label50);
            
            sheet.addCell(label51);
            sheet.addCell(label52);
            sheet.addCell(label53);
            sheet.addCell(label54);
            sheet.addCell(label55);
            sheet.addCell(label56);
            sheet.addCell(label57);
            sheet.addCell(label58);
            sheet.addCell(label59);
            sheet.addCell(label60);
            
            sheet.addCell(label61);
            sheet.addCell(label62);
            sheet.addCell(label63);
            sheet.addCell(label64);
            sheet.addCell(label65);
            sheet.addCell(label66);
            sheet.addCell(label67);
            sheet.addCell(label68);
            sheet.addCell(label69);
            sheet.addCell(label70);
            
            sheet.addCell(label71);
            sheet.addCell(label72);
            sheet.addCell(label73);
            sheet.addCell(label74);
            sheet.addCell(label75);
            sheet.addCell(label76);
            sheet.addCell(label77);
            sheet.addCell(label78);
            sheet.addCell(label79);
            sheet.addCell(label80);
            
            sheet.addCell(label81);
            sheet.addCell(label82);
            sheet.addCell(label83);
            sheet.addCell(label84);
            sheet.addCell(label85);
            sheet.addCell(label86);
            sheet.addCell(label87);
            sheet.addCell(label88);
            sheet.addCell(label89);
            sheet.addCell(label90);
            
            sheet.addCell(label91);
            sheet.addCell(label92);
            sheet.addCell(label93);
            sheet.addCell(label94);
            sheet.addCell(label95);
            sheet.addCell(label96);
            sheet.addCell(label97);
            sheet.addCell(label98);
            
            sheet.addCell(label99);
            sheet.addCell(label100);
            sheet.addCell(label101);
            sheet.addCell(label102);
            sheet.addCell(label103);
            
            sheet.addCell(label104);
            sheet.addCell(label105);
            sheet.addCell(label106);
            sheet.addCell(label107);
            sheet.addCell(label108);
            sheet.addCell(label109);
            sheet.addCell(label110);
            
            int i=1;
            while(rs.next()){
            Label l0 = new Label(0,i,rs.getString("hospno"));    
            Label l1 = new Label(1,i,rs.getString("day"));
            Label l2 = new Label(2,i,rs.getString("hr"));
            Label l3 = new Label(3,i,rs.getString("sbp"));
            Label l4 = new Label(4,i,rs.getString("dbp"));
            Label l5 = new Label(5,i,rs.getString("map"));
            Label l6 = new Label(6,i,rs.getString("temp"));
            Label l7 = new Label(7,i,rs.getString("rr"));
            Label l8 = new Label(8,i,rs.getString("gcs"));
            Label l9 = new Label(9,i,rs.getString("rass"));
            Label l10 = new Label(10,i,rs.getString("delirium"));            
            Label l11 = new Label(11,i,rs.getString("painscore"));
            Label l12 = new Label(12,i,rs.getString("ph"));
            Label l13 = new Label(13,i,rs.getString("paco2"));
            Label l14 = new Label(14,i,rs.getString("pao"));
            Label l15 = new Label(15,i,rs.getString("flo2"));
            Label l16 = new Label(16,i,rs.getString("hco3"));
            Label l17 = new Label(17,i,rs.getString("baseexcess"));
            Label l18 = new Label(18,i,rs.getString("urea"));
            Label l19 = new Label(19,i,rs.getString("creatinine"));
            Label l20 = new Label(20,i,rs.getString("na"));
          
            Label l21 = new Label(21,i,rs.getString("k"));
            Label l22 = new Label(22,i,rs.getString("cl"));
            Label l23 = new Label(23,i,rs.getString("hb"));
            Label l24 = new Label(24,i,rs.getString("hct"));
            Label l25 = new Label(25,i,rs.getString("plateletes"));
            Label l26 = new Label(26,i,rs.getString("wbc"));
            Label l27 = new Label(27,i,rs.getString("ptinr"));
            Label l28 = new Label(28,i,rs.getString("fibrinog"));
            Label l29 = new Label(29,i,rs.getString("ddimer"));
            Label l30 = new Label(30,i,rs.getString("mg"));
           
            Label l31 = new Label(31,i,rs.getString("po4"));
            Label l32 = new Label(32,i,rs.getString("ca"));
            Label l33 = new Label(33,i,rs.getString("caion"));
            Label l34 = new Label(34,i,rs.getString("bilirubin"));
            Label l35 = new Label(35,i,rs.getString("alt"));
            Label l36 = new Label(36,i,rs.getString("ast"));
            Label l37 = new Label(37,i,rs.getString("alkphos"));
            Label l38 = new Label(38,i,rs.getString("ggt"));
            Label l39 = new Label(39,i,rs.getString("amylase"));
            Label l40 = new Label(40,i,rs.getString("lipase"));
          
            Label l41 = new Label(41,i,rs.getString("albumen"));
            Label l42 = new Label(42,i,rs.getString("ldh"));
            Label l43 = new Label(43,i,rs.getString("cpk"));
            Label l44 = new Label(44,i,rs.getString("trop1"));
            Label l45 = new Label(45,i,rs.getString("bnp"));
            Label l46 = new Label(46,i,rs.getString("lactate"));
            Label l47 = new Label(47,i,rs.getString("pct"));
            Label l48 = new Label(48,i,rs.getString("crp"));
            Label l49 = new Label(49,i,rs.getString("bsrmin"));
            Label l50 = new Label(50,i,rs.getString("bsrmax"));
           
            Label l51 = new Label(51,i,rs.getString("spotUSodium"));
            Label l52 = new Label(52,i,rs.getString("dvtpropylaxis"));
            Label l53 = new Label(53,i,rs.getString("dialysis"));
            Label l54 = new Label(54,i,rs.getString("vasopressors"));
            Label l55 = new Label(55,i,rs.getString("norepinephrine"));
            Label l56 = new Label(56,i,rs.getString("dobutamine"));
            Label l57 = new Label(57,i,rs.getString("dopamine"));
            Label l58 = new Label(58,i,rs.getString("epinephrine"));
            Label l59 = new Label(59,i,rs.getString("phenylephrine"));
            Label l60 = new Label(60,i,rs.getString("steriodsld"));
           
            Label l61 = new Label(61,i,rs.getString("ventilate"));
            Label l62 = new Label(62,i,rs.getString("mode"));
            Label l63 = new Label(63,i,rs.getString("vt"));
            Label l64 = new Label(64,i,rs.getString("ps"));
            Label l65 = new Label(65,i,rs.getString("peep"));
            Label l66 = new Label(66,i,rs.getString("ppeak"));
            Label l67 = new Label(67,i,rs.getString("pplat"));
            Label l68 = new Label(68,i,rs.getString("cstat"));
            Label l69 = new Label(69,i,rs.getString("ETTcuffpress"));
            Label l70 = new Label(70,i,rs.getString("weaning"));
          
            Label l71 = new Label(71,i,rs.getString("extubniv"));
            Label l72 = new Label(72,i,rs.getString("tpiece"));
            Label l73 = new Label(73,i,rs.getString("fluidbalance"));
            Label l74 = new Label(74,i,rs.getString("urineOutput"));
            Label l75 = new Label(75,i,rs.getString("otherlosses"));
            Label l76 = new Label(76,i,rs.getString("otherlosses"));
            Label l77 = new Label(77,i,rs.getString("outputTotal"));
            Label l78 = new Label(78,i,rs.getString("intakeTotal"));
            Label l79 = new Label(79,i,rs.getString("balance"));
            Label l80 = new Label(80,i,rs.getString("cumbalance"));
            
            Label l81 = new Label(81,i,rs.getString("IVFluids"));
            Label l82 = new Label(82,i,rs.getString("crystalloid"));
            Label l83 = new Label(83,i,rs.getString("colloid"));
            Label l84 = new Label(84,i,rs.getString("bloodPRCBS"));
            Label l85 = new Label(85,i,rs.getString("plateletunit"));
            Label l86 = new Label(86,i,rs.getString("ffps"));
            Label l87 = new Label(87,i,rs.getString("complicat"));
            Label l88 = new Label(88,i,rs.getString("Aline"));
            Label l89 = new Label(89,i,rs.getString("cvpmin"));
            Label l90 = new Label(90,i,rs.getString("cvpmax"));
            Label l91 = new Label(91,i,rs.getString("route"));
            Label l92 = new Label(92,i,rs.getString("formula"));
            Label l93 = new Label(93,i,rs.getString("dopplr"));
            Label l94 = new Label(94,i,rs.getString("pocus"));
            Label l95 = new Label(95,i,rs.getString("cvpmax"));
            Label l96 = new Label(96,i,rs.getString("tracheal"));
            Label l97 = new Label(97,i,rs.getString("bloodPeripheral"));
            Label l98 = new Label(98,i,rs.getString("urine"));
            Label l99 = new Label(99,i,rs.getString("csf"));
            Label l100 = new Label(100,i,rs.getString("peritoneal"));
            Label l101 = new Label(101,i,rs.getString("wound"));
            Label l102 = new Label(102,i,rs.getString("bloodCvp"));
            Label l103 = new Label(103,i,rs.getString("others"));
            Label l104 = new Label(104,i,rs.getString("cal"));
            Label l105 = new Label(105,i,rs.getString("Protein"));
            Label l106 = new Label(106,i,rs.getString("Sofa"));
            Label l107 = new Label(107,i,rs.getString("pbyf"));
            Label l108 = new Label(108,i,rs.getString("PAO2"));
            Label l109 = new Label(109,i,rs.getString("gradient"));
            Label l110 = new Label(110,i,rs.getString("cryoppt"));
            
            sheet.addCell(l0);
            sheet.addCell(l1);
            sheet.addCell(l2);
            sheet.addCell(l3);
            sheet.addCell(l4);
            sheet.addCell(l5);
            sheet.addCell(l6);
            sheet.addCell(l7);
            sheet.addCell(l8);
            sheet.addCell(l9);
            sheet.addCell(l10);
            
            sheet.addCell(l11);
            sheet.addCell(l12);
            sheet.addCell(l13);
            sheet.addCell(l14);
            sheet.addCell(l15);
            sheet.addCell(l16);
            sheet.addCell(l17);
            sheet.addCell(l18);
            sheet.addCell(l19);
            sheet.addCell(l20);
            
            sheet.addCell(l21);
            sheet.addCell(l22);
            sheet.addCell(l23);
            sheet.addCell(l24);
            sheet.addCell(l25);
            sheet.addCell(l26);
            sheet.addCell(l27);
            sheet.addCell(l28);
            sheet.addCell(l29);
            sheet.addCell(l30);
            
            sheet.addCell(l31);
            sheet.addCell(l32);
            sheet.addCell(l33);
            sheet.addCell(l34);
            sheet.addCell(l35);
            sheet.addCell(l36);
            sheet.addCell(l37);
            sheet.addCell(l38);
            sheet.addCell(l39);
            sheet.addCell(l40);
            
            sheet.addCell(l41);
            sheet.addCell(l42);
            sheet.addCell(l43);
            sheet.addCell(l44);
            sheet.addCell(l45);
            sheet.addCell(l46);
            sheet.addCell(l47);
            sheet.addCell(l48);
            sheet.addCell(l49);
            sheet.addCell(l50);
            
            sheet.addCell(l51);
            sheet.addCell(l52);
            sheet.addCell(l53);
            sheet.addCell(l54);
            sheet.addCell(l55);
            sheet.addCell(l56);
            sheet.addCell(l57);
            sheet.addCell(l58);
            sheet.addCell(l59);
            sheet.addCell(l60);
                        
            sheet.addCell(l61);
            sheet.addCell(l62);
            sheet.addCell(l63);
            sheet.addCell(l64);
            sheet.addCell(l65);
            sheet.addCell(l66);
            sheet.addCell(l67);
            sheet.addCell(l68);
            sheet.addCell(l69);
            sheet.addCell(l70);
            
            sheet.addCell(l71);
            sheet.addCell(l72);
            sheet.addCell(l73);
            sheet.addCell(l74);
            sheet.addCell(l75);
            sheet.addCell(l76);
            sheet.addCell(l77);
            sheet.addCell(l78);
            sheet.addCell(l79);
            sheet.addCell(l80);
            
            sheet.addCell(l81);
            sheet.addCell(l82);
            sheet.addCell(l83);
            sheet.addCell(l84);
            sheet.addCell(l85);
            sheet.addCell(l86);
            sheet.addCell(l87);
            sheet.addCell(l88);
            sheet.addCell(l89);
            sheet.addCell(l90);
            
            sheet.addCell(l91);
            sheet.addCell(l92);
            sheet.addCell(l93);
            sheet.addCell(l94);
            sheet.addCell(l95);
            sheet.addCell(l96);
            sheet.addCell(l97);
            sheet.addCell(l98);
            
            sheet.addCell(l99);
            sheet.addCell(l100);
            sheet.addCell(l101);
            sheet.addCell(l102);
            sheet.addCell(l103);
            
            sheet.addCell(l104);
            sheet.addCell(l105);
            sheet.addCell(l106);
            sheet.addCell(l107);
            sheet.addCell(l108);
            
            sheet.addCell(l109);
            sheet.addCell(l110);
            
//            try{
//                    String sql1 = "select * from daywisecheckup left join patient_antibiotic_table on daywisecheckup.hospno = patient_antibiotic_table.hospno and daywisecheckup.day = patient_antibiotic_table.day; ";
//                    PreparedStatement pstk=conn.prepareStatement(sql1);
//                    ResultSet rsk=pstk.executeQuery(sql1);
//                    
//                    int k=119;
//                    while(rsk.next()){
//                        if (rsk.getString("day").equals(rs.getString("day")) && rsk.getString("hospno").equals(rs.getString("hospno")) ){
//                        Label l119 = new Label(k,i,rsk.getString("patient_antibiotic_value"));
//                        k++;
//                        sheet.addCell(l119);}
//                        else{}
//                    }
//                }catch(Exception e)
//                {}
           
            i++;
            }
            
            WritableSheet sheet2 = myexcel.createSheet("Antibiotic", 1);
            
            Label l0 = new Label(0,0,"HospNo");
            Label l1 = new Label(1,0,"day");
            Label l2 = new Label(2,0,"Anti");
            sheet2.addCell(l0);
            sheet2.addCell(l1);
            sheet2.addCell(l2);
            
            String sql1="select * from patient_antibiotic_table" ;
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ResultSet rs1 = ps1.executeQuery(sql1);
            
            int a=1;
            while(rs1.next()){
            Label a0 = new Label(0,a,rs1.getString("hospno"));    
            Label a1 = new Label(1,a,rs1.getString("day"));
            Label a2 = new Label(2,a,rs1.getString("patient_antibiotic_value"));
            
            sheet2.addCell(a0);
            sheet2.addCell(a1);
            sheet2.addCell(a2);
            a++;
            }
            
            WritableSheet sheet3 = myexcel.createSheet("Microbiology", 2);
            
            Label t0 = new Label(0,0,"HospNo");
            Label t1 = new Label(1,0,"day");
            Label t2 = new Label(2,0,"Name");
            Label t3 = new Label(3,0,"Value");
           
            sheet3.addCell(t0);
            sheet3.addCell(t1);
            sheet3.addCell(t2);
            sheet3.addCell(t3);
////            
            String sql2="select * from org" ;
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ResultSet rs2 = ps2.executeQuery(sql2);
            
            int b=1;
            while(rs2.next()){
            Label c0 = new Label(0,b,rs2.getString("hospno"));    
            Label c1 = new Label(1,b,rs2.getString("day"));
            Label c2 = new Label(2,b,rs2.getString("org_name"));
            Label c3 = new Label(3,b,rs2.getString("org_value"));
            sheet3.addCell(c0);
            sheet3.addCell(c1);
            sheet3.addCell(c2);
            sheet3.addCell(c3);   
            
            b++;
            }
            
            myexcel.write();
            myexcel.close();

        }catch(Exception e){}
       
    }//GEN-LAST:event_generateExcel1ActionPerformed

    private void pbyfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pbyfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pbyfActionPerformed

    private void PAO2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PAO2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PAO2ActionPerformed

    private void cryopptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cryopptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cryopptActionPerformed

    private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(null,"Please enter Date:");
        
       try{
           
           DefaultTableModel model8 = (DefaultTableModel) patient_table.getModel();
           int counts = model8.getRowCount();
           System.out.println(counts);
           Object[] hospIds= new Object[counts];
           
           for (int i=0;i<counts;i++){
           hospIds[i] = model8.getValueAt(i,0).toString();
           } 
           model7= (DefaultTableModel) patient_table.getModel();
           model7.setRowCount(0);
           
           Object[] row = new Object[4];
           int j=0;
        for(int count = 0; count < counts; count++){
            System.out.println(counts);
            String dataId = hospIds[count].toString();
            System.out.println(counts);
            String sqlday="select * from patientinfo where hospno = '"+dataId+"' and doaInIcu >= '"+input+"'";
            System.out.println(counts);
            pst=conn.prepareStatement(sqlday);
            rs=pst.executeQuery(sqlday);
            
            while(rs.next()){
            j++;
            row[0]=rs.getString("hospno");
            row[1]=rs.getString("ICUoutcome");
            row[2]=rs.getString("hospOutcome");
            row[3]=rs.getDate("doaInHosp");
            model7.addRow(row);
            }
        
        }
        braindeath.setText("Number of such patients are: "+Integer.toString(j)+"");
  }
       catch(Exception e) {
           JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_filterActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
        model1.removeAllElements();
        model.removeAllElements();
        try{
            conn = ICUsystem.getconnection();
            String sql="select comorbids_type from comorbids_table ";
            PreparedStatement pstcom = conn.prepareStatement(sql);
            ResultSet rs = pstcom.executeQuery(sql);
            while(rs.next()){
            model.addElement(rs.getString("comorbids_type"));
            }
            jlistComorbids.setModel(model);
        }catch(Exception e){}
        try{
            conn = ICUsystem.getconnection();
            String sql="select admission_type from admission_type_table ";
            PreparedStatement pstcom = conn.prepareStatement(sql);
            ResultSet rs = pstcom.executeQuery(sql);
            while(rs.next()){
            model1.addElement(rs.getString("admission_type"));
            }
            jlistAdmittedtype.setModel(model1);
        }catch(Exception e){}
        
        
        
        setColor(btn_1);
        ind_1.setOpaque(true);
        reset(btn_2);
        reset(btn_3);
        reset(btn_5);
        resetIndicator(ind_2);
        resetIndicator(ind_3);
        resetIndicator(ind_5);
        //Remove panels
        mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();
        //Add panels
        mainpanel.add(addpatient);
        mainpanel.repaint();
        mainpanel.revalidate();
        hospitalNo.setText("");
        addPatient.setText("Add Patient");
        hospitalNo.setEditable(true);
        checkUpdateOrInsert=0;
        clearallfrontpage();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void TrachBck2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrachBck2MouseClicked
        // TODO add your handling code here:
        java.util.List listAdd;
        int listAddIndex[];
        listAdd = jListSelectBcvp.getSelectedValuesList();
        listAddIndex=jListSelectBcvp.getSelectedIndices();

        for (Object list1 : listAdd) {
            String option = list1.toString();
            modelBcvp1.addElement(option);
        }
        for (Integer list1 : listAddIndex) {
            modelBcvp2.remove(list1);
        }
        jListBcvp.setModel(modelBcvp1);
        jListSelectBcvp.setModel(modelBcvp2);
        
        
        
    }//GEN-LAST:event_TrachBck2MouseClicked

    private void TrachFrwd2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrachFrwd2MouseClicked
        // TODO add your handling code here:
        
               java.util.List listAdd;
        int listAddIndex[];
        listAdd = jListBcvp.getSelectedValuesList();
        listAddIndex=jListBcvp.getSelectedIndices();

        for (Object list1 : listAdd) {
            String option = list1.toString();
            modelBcvp2.addElement(option);
        }
        for (Integer list1 : listAddIndex) {
            modelBcvp1.remove(list1);
        }
        jListBcvp.setModel(modelBcvp1);
        jListSelectBcvp.setModel(modelBcvp2);
 
    }//GEN-LAST:event_TrachFrwd2MouseClicked

    private void TrachBck1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrachBck1MouseClicked
        // TODO add your handling code here:
        
        java.util.List listAdd;
        int listAddIndex[];
        listAdd = jListSelectBperi.getSelectedValuesList();
        listAddIndex=jListSelectBperi.getSelectedIndices();

        for (Object list1 : listAdd) {
            String option = list1.toString();
            modelBperi1.addElement(option);
        }
        for (Integer list1 : listAddIndex) {
            modelBperi2.remove(list1);
        }
        jListBperi.setModel(modelBperi1);
        jListSelectBperi.setModel(modelBperi2);
    }//GEN-LAST:event_TrachBck1MouseClicked

    private void BperiFwrdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BperiFwrdMouseClicked
        // TODO add your handling code here:
               java.util.List listAdd;
        int listAddIndex[];
        listAdd = jListBperi.getSelectedValuesList();
        listAddIndex=jListBperi.getSelectedIndices();

        for (Object list1 : listAdd) {
            String option = list1.toString();
            modelBperi2.addElement(option);
        }
        for (Integer list1 : listAddIndex) {
            modelBperi1.remove(list1);
        }
        jListBperi.setModel(modelBperi1);
        jListSelectBperi.setModel(modelBperi2);
 
        
        
        
    }//GEN-LAST:event_BperiFwrdMouseClicked

    private void TrachBckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrachBckMouseClicked
        // TODO add your handling code here:
        
        java.util.List listAdd;
        int listAddIndex[];
        listAdd = jListSelectTrach.getSelectedValuesList();
        listAddIndex=jListSelectTrach.getSelectedIndices();

        for (Object list1 : listAdd) {
            String option = list1.toString();
            modelTrach1.addElement(option);
        }
        for (Integer list1 : listAddIndex) {
            modelTrach2.remove(list1);
        }
        jListTrach.setModel(modelTrach1);
        jListSelectTrach.setModel(modelTrach2);
        
    }//GEN-LAST:event_TrachBckMouseClicked

    
    private void TrachFrwdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrachFrwdMouseClicked
        // TODO add your handling code here:

        java.util.List listAdd;
        int listAddIndex[];
        listAdd = jListTrach.getSelectedValuesList();
        listAddIndex=jListTrach.getSelectedIndices();

        for (Object list1 : listAdd) {
            String option = list1.toString();
            modelTrach2.addElement(option);
        }
        for (Integer list1 : listAddIndex) {
            modelTrach1.remove(list1);
        }
        jListTrach.setModel(modelTrach1);
        jListSelectTrach.setModel(modelTrach2);
    }//GEN-LAST:event_TrachFrwdMouseClicked

    private void jLabel98MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel98MouseClicked
        // TODO add your handling code here:
        java.util.List listAdd;
        int listAddIndex[];
        listAdd = jListSelectAntibiotic.getSelectedValuesList();
        listAddIndex=jListSelectAntibiotic.getSelectedIndices();

        for (Object list1 : listAdd) {
            String option = list1.toString();
            model5.addElement(option);
        }
        for (Integer list1 : listAddIndex) {
            model4.remove(list1);

        }
        jListSelectAntibiotic.setModel(model4);
        jlistAntibiotic.setModel(model5);
    }//GEN-LAST:event_jLabel98MouseClicked

    private void jLabel97MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel97MouseClicked
        // TODO add your handling code here:

        java.util.List listAdd;
        int listAddIndex[];
        listAdd = jlistAntibiotic.getSelectedValuesList();
        listAddIndex=jlistAntibiotic.getSelectedIndices();

        for (Object list1 : listAdd) {
            String option = list1.toString();
            model4.addElement(option);
        }
        for (Integer list1 : listAddIndex) {
            model5.remove(list1);
        }
        jListSelectAntibiotic.setModel(model4);
        jlistAntibiotic.setModel(model5);
    }//GEN-LAST:event_jLabel97MouseClicked

    private void othersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_othersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_othersActionPerformed

    private void bloodCvpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloodCvpActionPerformed
        // TODO add your handling code here:
        String org = bloodCvp.getSelectedItem().toString();
        if(org == "No"){
            jListBcvp.setEnabled(false);
        }
        else{
            jListBcvp.setEnabled(true);
        }
        
        
    }//GEN-LAST:event_bloodCvpActionPerformed

    private void woundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_woundActionPerformed
        // TODO add your handling code here:
        String org = wound.getSelectedItem().toString();
        if(org == "No"){
            jListWound.setEnabled(false);
        }
        else{
            jListWound.setEnabled(true);
        }
    }//GEN-LAST:event_woundActionPerformed

    private void peritonealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peritonealActionPerformed
        // TODO add your handling code here:
        String org = peritoneal.getSelectedItem().toString();
        if(org == "No"){
            jListPeri.setEnabled(false);
        }
        else{
            jListPeri.setEnabled(true);
        }
        
    }//GEN-LAST:event_peritonealActionPerformed

    private void csfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_csfActionPerformed
        // TODO add your handling code here:String org = bloodPeriph.getSelectedItem().toString();
       
        String org = csf.getSelectedItem().toString();
        if(org == "No"){
            jListCsf.setEnabled(false);
        }
        else{
            jListCsf.setEnabled(true);
        }
    }//GEN-LAST:event_csfActionPerformed

    private void urineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urineActionPerformed
        // TODO add your handling code here:
         String org = urine.getSelectedItem().toString();
        if(org == "No"){
            jListUrine.setEnabled(false);
        }
        else{
            jListUrine.setEnabled(true);
        }
    }//GEN-LAST:event_urineActionPerformed

    private void bloodPeriphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloodPeriphActionPerformed
        // TODO add your handling code here:
        String org = bloodPeriph.getSelectedItem().toString();
        if(org == "No"){
            jListBperi.setEnabled(false);
        }
        else{
            jListBperi.setEnabled(true);
        }
        
        
    }//GEN-LAST:event_bloodPeriphActionPerformed

    private void trachealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trachealActionPerformed
        // TODO add your handling code here:
        
        
        String org = tracheal.getSelectedItem().toString();
        if(org == "No"){
            jListTrach.setEnabled(false);
        }
        else{
            jListTrach.setEnabled(true);
        }
        
    }//GEN-LAST:event_trachealActionPerformed

    private void TrachFrwd4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrachFrwd4MouseClicked
        // TODO add your handling code here:
        
        
               java.util.List listAdd;
        int listAddIndex[];
        listAdd = jListUrine.getSelectedValuesList();
        listAddIndex=jListUrine.getSelectedIndices();

        for (Object list1 : listAdd) {
            String option = list1.toString();
            modelUrine2.addElement(option);
        }
        for (Integer list1 : listAddIndex) {
            modelUrine1.remove(list1);
        }
        jListUrine.setModel(modelUrine1);
        jListSelectUrine.setModel(modelUrine2);
    }//GEN-LAST:event_TrachFrwd4MouseClicked

    private void TrachBck7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrachBck7MouseClicked
        // TODO add your handling code here:
        java.util.List listAdd;
        int listAddIndex[];
        listAdd = jListSelectUrine.getSelectedValuesList();
        listAddIndex=jListSelectUrine.getSelectedIndices();

        for (Object list1 : listAdd) {
            String option = list1.toString();
            modelUrine1.addElement(option);
        }
        for (Integer list1 : listAddIndex) {
            modelUrine2.remove(list1);
        }
        jListUrine.setModel(modelUrine1);
        jListSelectUrine.setModel(modelUrine2);

    }//GEN-LAST:event_TrachBck7MouseClicked

    private void TrachFrwd7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrachFrwd7MouseClicked
        // TODO add your handling code here:
        
        
               java.util.List listAdd;
        int listAddIndex[];
        listAdd = jListCsf.getSelectedValuesList();
        listAddIndex=jListCsf.getSelectedIndices();

        for (Object list1 : listAdd) {
            String option = list1.toString();
            modelCsf2.addElement(option);
        }
        for (Integer list1 : listAddIndex) {
            modelCsf1.remove(list1);
        }
        jListCsf.setModel(modelCsf1);
        jListSelectCsf.setModel(modelCsf2);
    }//GEN-LAST:event_TrachFrwd7MouseClicked

    private void TrachBck9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrachBck9MouseClicked
        // TODO add your handling code here:
                       java.util.List listAdd;
        int listAddIndex[];
        listAdd = jListSelectCsf.getSelectedValuesList();
        listAddIndex=jListSelectCsf.getSelectedIndices();

        for (Object list1 : listAdd) {
            String option = list1.toString();
            modelCsf1.addElement(option);
        }
        for (Integer list1 : listAddIndex) {
            modelCsf2.remove(list1);
        }
        jListCsf.setModel(modelCsf1);
        jListSelectCsf.setModel(modelCsf2);
        
        
    }//GEN-LAST:event_TrachBck9MouseClicked

    private void TrachFrwd8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrachFrwd8MouseClicked
        // TODO add your handling code here:
        
               java.util.List listAdd;
        int listAddIndex[];
        listAdd = jListPeri.getSelectedValuesList();
        listAddIndex=jListPeri.getSelectedIndices();

        for (Object list1 : listAdd) {
            String option = list1.toString();
            modelPeri2.addElement(option);
        }
        for (Integer list1 : listAddIndex) {
            modelPeri1.remove(list1);
        }
        jListPeri.setModel(modelPeri1);
        jListSelectPeri.setModel(modelPeri2);
        
        
    }//GEN-LAST:event_TrachFrwd8MouseClicked

    private void TrachBck10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrachBck10MouseClicked
        // TODO add your handling code here:
        
                
               java.util.List listAdd;
        int listAddIndex[];
        listAdd = jListSelectPeri.getSelectedValuesList();
        listAddIndex=jListSelectPeri.getSelectedIndices();

        for (Object list1 : listAdd) {
            String option = list1.toString();
            modelPeri1.addElement(option);
        }
        for (Integer list1 : listAddIndex) {
            modelPeri2.remove(list1);
        }
        jListPeri.setModel(modelPeri1);
        jListSelectPeri.setModel(modelPeri2);
        
        

        
    }//GEN-LAST:event_TrachBck10MouseClicked

    private void TrachFrwd9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrachFrwd9MouseClicked
        // TODO add your handling code here:
        
               java.util.List listAdd;
        int listAddIndex[];
        listAdd = jListWound.getSelectedValuesList();
        listAddIndex=jListWound.getSelectedIndices();

        for (Object list1 : listAdd) {
            String option = list1.toString();
            modelWound2.addElement(option);
        }
        for (Integer list1 : listAddIndex) {
            modelWound1.remove(list1);
        }
        jListWound.setModel(modelWound1);
        jListSelectWound.setModel(modelWound2);
        
        
    }//GEN-LAST:event_TrachFrwd9MouseClicked

    private void TrachBck11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrachBck11MouseClicked
        // TODO add your handling code here:
        
                       java.util.List listAdd;
        int listAddIndex[];
        listAdd = jListSelectWound.getSelectedValuesList();
        listAddIndex=jListSelectWound.getSelectedIndices();

        for (Object list1 : listAdd) {
            String option = list1.toString();
            modelWound1.addElement(option);
        }
        for (Integer list1 : listAddIndex) {
            modelWound2.remove(list1);
        }
        jListWound.setModel(modelWound1);
        jListSelectWound.setModel(modelWound2);
               
        
    }//GEN-LAST:event_TrachBck11MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void BperiFwrdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BperiFwrdMouseEntered
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_BperiFwrdMouseEntered

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(null,"Please enter Hospital No to Delete:");
        int option = JOptionPane.showConfirmDialog(null,"Are you sure you want to Delete","Delete",JOptionPane.YES_NO_OPTION);
        if(option == 0)
        {
        conn = ICUsystem.getconnection();
           try{
            String sql = "Delete from patientinfo where hospno = '"+input+"' ";
            pst = conn.prepareStatement(sql);
            pst.execute();
            
            String sql1 = "Delete from daywisecheckup where hospno = '"+input+"' ";
            pst = conn.prepareStatement(sql1);
            pst.execute();
            
            String sql2 = "Delete from patient_antibiotic_table where hospno = '"+input+"' ";
            pst = conn.prepareStatement(sql2);
            pst.execute();
            
            String sql3 = "Delete from org where hospno = '"+input+"' ";
            pst = conn.prepareStatement(sql3);
            pst.execute();
            
            String sql4 = "Delete from patient_admission_type where hospno = '"+input+"' ";
            pst = conn.prepareStatement(sql4);
            pst.execute();
            
            String sql5 = "Delete from patient_comorbid where hospno = '"+input+"' ";
            pst = conn.prepareStatement(sql5);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Deleted");
           }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);   
        }
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

       
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainMenu().setVisible(true);
            }
        });
    }
    
    private void setColor(JPanel pane){
    pane.setBackground(new Color(41,57,80));
}
//    private void resetColor(JPanel[] pane,JPanel [] indicators){
//        for(int i =0;i<pane.length;i++){
//            pane[i].setBackground(new Color(23,35,51));
//        }
//        for(int i=0;i<indicators.length;i++){
//        indicators[i].setOpaque(false);
//        }
//                
//    }
    private void reset(JPanel pane){
    pane.setBackground(new Color(23,35,51));
    }
    private void resetIndicator(JPanel pane){
    pane.setOpaque(false);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BperiFwrd;
    private javax.swing.JLabel Calorie;
    private javax.swing.JLabel Calorie1;
    private javax.swing.JButton DiagnosisSearch;
    private javax.swing.JButton ETTSearch;
    private javax.swing.JButton ETTSearch1;
    private javax.swing.JTextField ETTcuffpress;
    private javax.swing.JButton HospNoSearch;
    private javax.swing.JButton Insert;
    private javax.swing.JTextField PAO2;
    private javax.swing.JTextField Sofa;
    private javax.swing.JLabel TrachBck;
    private javax.swing.JLabel TrachBck1;
    private javax.swing.JLabel TrachBck10;
    private javax.swing.JLabel TrachBck11;
    private javax.swing.JLabel TrachBck2;
    private javax.swing.JLabel TrachBck7;
    private javax.swing.JLabel TrachBck9;
    private javax.swing.JLabel TrachFrwd;
    private javax.swing.JLabel TrachFrwd2;
    private javax.swing.JLabel TrachFrwd4;
    private javax.swing.JLabel TrachFrwd7;
    private javax.swing.JLabel TrachFrwd8;
    private javax.swing.JLabel TrachFrwd9;
    private javax.swing.JComboBox aLine;
    private javax.swing.JButton addNew;
    private javax.swing.JLabel addPatient;
    private javax.swing.JLabel addPatient1;
    private javax.swing.JLabel addPatient2;
    private javax.swing.JLabel addPatient3;
    private javax.swing.JPanel addpatient;
    private javax.swing.JPanel addpatient1;
    private javax.swing.JComboBox admittedFrom;
    private javax.swing.JTextField age;
    private javax.swing.JButton airwaySearch;
    private javax.swing.JButton airwaySearch1;
    private javax.swing.JComboBox airwayType;
    private javax.swing.JTextField albumen;
    private javax.swing.JTextField alkphos;
    private javax.swing.JTextField alt;
    private javax.swing.JTextField amylase;
    private javax.swing.JTextField apache;
    private javax.swing.JTextField ast;
    private javax.swing.JTextField b;
    private javax.swing.JTextField balance;
    private javax.swing.JTextField baseexcess;
    private javax.swing.JTextField bilrubin;
    private javax.swing.JComboBox bloodCvp;
    private javax.swing.JTextField bloodPRCBS;
    private javax.swing.JComboBox bloodPeriph;
    private javax.swing.JTextField bmi;
    private javax.swing.JTextField bnp;
    private javax.swing.JTextField brainScan;
    private javax.swing.JButton brainSearch;
    private javax.swing.JLabel braindeath;
    private javax.swing.JTextField bsrmax;
    private javax.swing.JTextField bsrmin;
    private javax.swing.JPanel btn_1;
    private javax.swing.JPanel btn_2;
    private javax.swing.JPanel btn_3;
    private javax.swing.JPanel btn_5;
    private javax.swing.JTextField ca;
    private javax.swing.JTextField caion;
    private javax.swing.JPanel calculator;
    private javax.swing.JTextField calorie;
    private javax.swing.JButton cardiacSearch;
    private javax.swing.JTextField cl;
    private javax.swing.JComboBox clabsi;
    private javax.swing.JButton clabsiSearch;
    private javax.swing.JComboBox code;
    private javax.swing.JComboBox colloid;
    private javax.swing.JComboBox complicat;
    private javax.swing.JTextField complication;
    private javax.swing.JTextField cpk;
    private javax.swing.JTextField creatinine;
    private javax.swing.JTextField crp;
    private javax.swing.JTextField cryoppt;
    private javax.swing.JComboBox crystalloid;
    private javax.swing.JComboBox csf;
    private javax.swing.JTextField cstat;
    private javax.swing.JTextField cumBalance;
    private javax.swing.JTextField cvpDays;
    private javax.swing.JTextField cvpMax;
    private javax.swing.JTextField cvpMin;
    private org.jdesktop.swingx.JXDatePicker dateDischarge;
    private org.jdesktop.swingx.JXDatePicker dateExtubation;
    private org.jdesktop.swingx.JXDatePicker dateReadmission;
    private org.jdesktop.swingx.JXDatePicker dateRedo;
    private org.jdesktop.swingx.JXDatePicker dateSurgery;
    private javax.swing.JLabel day;
    private javax.swing.JLabel day1;
    private javax.swing.JTextField days;
    private javax.swing.JTextField dbp;
    private javax.swing.JTextField ddimer;
    private javax.swing.JComboBox delirium;
    private javax.swing.JButton deliriumSearch;
    private javax.swing.JTextArea diagnosisPrimary;
    private javax.swing.JTextArea diagnosisSecondary;
    private javax.swing.JComboBox dialysis;
    private org.jdesktop.swingx.JXDatePicker doaHospital;
    private org.jdesktop.swingx.JXDatePicker doaICU;
    private javax.swing.JTextField dobutamine;
    private javax.swing.JTextField dopamine;
    private javax.swing.JComboBox dopplr;
    private javax.swing.JComboBox dvtpropylaxis;
    private javax.swing.JTextField e;
    private javax.swing.JTextField epinephrine;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel exit1;
    private javax.swing.JLabel exit2;
    private javax.swing.JLabel exit3;
    private javax.swing.JLabel exit4;
    private javax.swing.JLabel exit5;
    private javax.swing.JTextField extubationTime;
    private javax.swing.JComboBox extubniv;
    private javax.swing.JTextField ffps;
    private javax.swing.JTextField fibrinog;
    private javax.swing.JButton filter;
    private javax.swing.JTextField flo2;
    private javax.swing.JComboBox fluidBalance;
    private javax.swing.JComboBox formula;
    private javax.swing.JComboBox formula1;
    private javax.swing.JTextField gcs;
    private javax.swing.JButton generateExcel;
    private javax.swing.JButton generateExcel1;
    private javax.swing.JTextField ggt;
    private javax.swing.JTextField gradient;
    private javax.swing.JTextField hb;
    private javax.swing.JTextField hco3;
    private javax.swing.JTextField hct;
    private javax.swing.JTextField height;
    private org.jdesktop.swingx.JXDatePicker hospitalDate;
    private javax.swing.JTextField hospitalNo;
    private javax.swing.JComboBox hospitalOutcome;
    private javax.swing.JTextField hr;
    private javax.swing.JComboBox icuOutcome;
    private javax.swing.JPanel ind_1;
    private javax.swing.JPanel ind_2;
    private javax.swing.JPanel ind_3;
    private javax.swing.JPanel ind_5;
    private javax.swing.JTextField intakeTotal;
    private javax.swing.JComboBox intubationAt;
    private javax.swing.JComboBox ivFluids;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JLabel jLabeldbp11;
    private javax.swing.JLabel jLabeldbp12;
    private javax.swing.JLabel jLabeldbp3;
    private javax.swing.JLabel jLabeldbp4;
    private javax.swing.JLabel jLabeldbp5;
    private javax.swing.JLabel jLabeldbp6;
    private javax.swing.JLabel jLabeldelirium2;
    private javax.swing.JLabel jLabeldelirium3;
    private javax.swing.JLabel jLabeldelirium4;
    private javax.swing.JLabel jLabeldelirium5;
    private javax.swing.JLabel jLabeldelirium7;
    private javax.swing.JLabel jLabeldelirium8;
    private javax.swing.JLabel jLabelflo10;
    private javax.swing.JLabel jLabelflo11;
    private javax.swing.JLabel jLabelflo12;
    private javax.swing.JLabel jLabelflo4;
    private javax.swing.JLabel jLabelflo5;
    private javax.swing.JLabel jLabelflo6;
    private javax.swing.JLabel jLabelflo7;
    private javax.swing.JLabel jLabelflo8;
    private javax.swing.JLabel jLabelflo9;
    private javax.swing.JLabel jLabelgcs2;
    private javax.swing.JLabel jLabelgcs3;
    private javax.swing.JLabel jLabelgcs4;
    private javax.swing.JLabel jLabelgcs5;
    private javax.swing.JLabel jLabelgcs7;
    private javax.swing.JLabel jLabelgcs8;
    private javax.swing.JLabel jLabelhco10;
    private javax.swing.JLabel jLabelhco11;
    private javax.swing.JLabel jLabelhco5;
    private javax.swing.JLabel jLabelhco6;
    private javax.swing.JLabel jLabelhco7;
    private javax.swing.JLabel jLabelmap10;
    private javax.swing.JLabel jLabelmap11;
    private javax.swing.JLabel jLabelmap12;
    private javax.swing.JLabel jLabelmap13;
    private javax.swing.JLabel jLabelmap14;
    private javax.swing.JLabel jLabelmap15;
    private javax.swing.JLabel jLabelmap16;
    private javax.swing.JLabel jLabelmap17;
    private javax.swing.JLabel jLabelmap4;
    private javax.swing.JLabel jLabelmap5;
    private javax.swing.JLabel jLabelmap6;
    private javax.swing.JLabel jLabelmap7;
    private javax.swing.JLabel jLabelmap8;
    private javax.swing.JLabel jLabelmap9;
    private javax.swing.JLabel jLabelpaco10;
    private javax.swing.JLabel jLabelpaco4;
    private javax.swing.JLabel jLabelpaco5;
    private javax.swing.JLabel jLabelpaco6;
    private javax.swing.JLabel jLabelpaco9;
    private javax.swing.JLabel jLabelpainscore2;
    private javax.swing.JLabel jLabelpainscore3;
    private javax.swing.JLabel jLabelpainscore4;
    private javax.swing.JLabel jLabelpainscore5;
    private javax.swing.JLabel jLabelpainscore6;
    private javax.swing.JLabel jLabelpainscore7;
    private javax.swing.JLabel jLabelpao1;
    private javax.swing.JLabel jLabelpao2;
    private javax.swing.JLabel jLabelpao3;
    private javax.swing.JLabel jLabelpao4;
    private javax.swing.JLabel jLabelpao7;
    private javax.swing.JLabel jLabelpao8;
    private javax.swing.JLabel jLabelph2;
    private javax.swing.JLabel jLabelph3;
    private javax.swing.JLabel jLabelph4;
    private javax.swing.JLabel jLabelph5;
    private javax.swing.JLabel jLabelph7;
    private javax.swing.JLabel jLabelph8;
    private javax.swing.JLabel jLabelrass2;
    private javax.swing.JLabel jLabelrass3;
    private javax.swing.JLabel jLabelrass4;
    private javax.swing.JLabel jLabelrass5;
    private javax.swing.JLabel jLabelrass7;
    private javax.swing.JLabel jLabelrass8;
    private javax.swing.JLabel jLabelrr10;
    private javax.swing.JLabel jLabelrr2;
    private javax.swing.JLabel jLabelrr3;
    private javax.swing.JLabel jLabelrr4;
    private javax.swing.JLabel jLabelrr5;
    private javax.swing.JLabel jLabelrr6;
    private javax.swing.JLabel jLabelrr7;
    private javax.swing.JLabel jLabelrr8;
    private javax.swing.JLabel jLabelrr9;
    private javax.swing.JLabel jLabelsbp2;
    private javax.swing.JLabel jLabelsbp3;
    private javax.swing.JLabel jLabelsbp4;
    private javax.swing.JLabel jLabelsbp5;
    private javax.swing.JLabel jLabelsbp6;
    private javax.swing.JLabel jLabelsbp8;
    private javax.swing.JLabel jLabelsbp9;
    private javax.swing.JLabel jLabeltracheal1;
    private javax.swing.JLabel jLabeltracheal2;
    private javax.swing.JLabel jLabeltracheal3;
    private javax.swing.JLabel jLabeltracheal4;
    private javax.swing.JLabel jLabeltracheal5;
    private javax.swing.JLabel jLabeltracheal6;
    private javax.swing.JLabel jLabeltracheal7;
    private javax.swing.JLabel jLabeltracheal8;
    private javax.swing.JLabel jLabeltracheal9;
    private javax.swing.JList jListBcvp;
    private javax.swing.JList jListBperi;
    private javax.swing.JList jListCsf;
    private javax.swing.JList jListPeri;
    private javax.swing.JList jListSelectAdmission;
    private javax.swing.JList jListSelectAntibiotic;
    private javax.swing.JList jListSelectBcvp;
    private javax.swing.JList jListSelectBperi;
    private javax.swing.JList jListSelectComorbid;
    private javax.swing.JList jListSelectCsf;
    private javax.swing.JList jListSelectPeri;
    private javax.swing.JList jListSelectTrach;
    private javax.swing.JList jListSelectUrine;
    private javax.swing.JList jListSelectWound;
    private javax.swing.JList jListTrach;
    private javax.swing.JList jListUrine;
    private javax.swing.JList jListWound;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JScrollPane jScrollPane35;
    private javax.swing.JScrollPane jScrollPane37;
    private javax.swing.JScrollPane jScrollPane39;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane40;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JList jlistAdmittedtype;
    private javax.swing.JList jlistAntibiotic;
    private javax.swing.JList jlistComorbids;
    private javax.swing.JTextField k;
    private javax.swing.JTextField lactate;
    private javax.swing.JTextField ldh;
    private javax.swing.JComboBox lifeTherapy;
    private javax.swing.JTextField lipase;
    private javax.swing.JTextField los;
    private javax.swing.JTextField m;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JTextField map;
    private javax.swing.JTextField mg;
    public javax.swing.JComboBox mode;
    private javax.swing.JTextField na;
    private javax.swing.JLabel nextpage;
    private javax.swing.JTextField norepinephrine;
    private javax.swing.JTextField nutRiskScore;
    private javax.swing.JTextField otherLosses;
    private javax.swing.JComboBox others;
    private javax.swing.JTextField outputTotal;
    private javax.swing.JTextField paco2;
    private javax.swing.JTextField painscore;
    private javax.swing.JTextField pao;
    private javax.swing.JTable patient_table;
    private javax.swing.JTextField pbyf;
    private javax.swing.JTextField pct;
    private javax.swing.JButton pctSearch;
    private javax.swing.JTextField peep;
    private javax.swing.JComboBox peritoneal;
    private javax.swing.JTextField ph;
    private javax.swing.JTextField phenylephrine;
    private javax.swing.JTextField plateletes;
    private javax.swing.JTextField plateletunit;
    private javax.swing.JTextField po4;
    private javax.swing.JComboBox pocus;
    private javax.swing.JTextField ppeak;
    private javax.swing.JTextField pplat;
    private javax.swing.JPanel printreport;
    private javax.swing.JTextField protein;
    private javax.swing.JTextField ps;
    private javax.swing.JTextField ptinr;
    private javax.swing.JTextField qSofa;
    private javax.swing.JTextField r;
    private javax.swing.JTextField rass;
    private javax.swing.JComboBox reAdmission;
    private javax.swing.JButton reAdmissionSearch;
    private javax.swing.JButton reAdmissionSearch1;
    private org.jdesktop.swingx.JXDatePicker reIntubation;
    private javax.swing.JButton reItubationSearch;
    private javax.swing.JTextField reasonOfDeath;
    private javax.swing.JTextField reasonReadmission;
    private javax.swing.JTextField reasonWithdrawn;
    private javax.swing.JTextArea redoSurgery;
    private javax.swing.JTextField rep;
    private javax.swing.JTextField repeatBrainScan;
    private javax.swing.JComboBox route;
    private javax.swing.JTextField rr;
    private javax.swing.JTextField saps;
    private javax.swing.JTextField sbp;
    private javax.swing.JPanel search;
    private javax.swing.JComboBox selfExtubation;
    private javax.swing.JButton selfExtubationSearch;
    private javax.swing.JComboBox sex;
    private javax.swing.JPanel showData;
    private javax.swing.JPanel sidebar;
    private javax.swing.JTextField spotUSodium;
    private javax.swing.JComboBox steriodsld;
    private javax.swing.JTextArea surgery;
    private javax.swing.JButton surgerySearch;
    private javax.swing.JTextField temp;
    private javax.swing.JTextField timeAdmission;
    private javax.swing.JButton tlcSearch;
    private javax.swing.JTextField total;
    private javax.swing.JComboBox tpiece;
    private javax.swing.JComboBox tracheal;
    private javax.swing.JTextField trop1;
    private javax.swing.JButton update;
    private javax.swing.JTable update_patient;
    private javax.swing.JTextField urea;
    private javax.swing.JComboBox urine;
    private javax.swing.JTextField urineOutput;
    private javax.swing.JComboBox vap;
    private javax.swing.JButton vapSearch;
    private javax.swing.JComboBox vasopressors;
    private javax.swing.JComboBox vent;
    public javax.swing.JComboBox ventilate;
    private javax.swing.JTextField ventilationDays;
    private javax.swing.JButton viewreport;
    private javax.swing.JTextField vt;
    private javax.swing.JTextField wbc;
    private javax.swing.JComboBox weaning;
    private javax.swing.JTextField weight;
    private javax.swing.JComboBox wound;
    // End of variables declaration//GEN-END:variables

  

    
}