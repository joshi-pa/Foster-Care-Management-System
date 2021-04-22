/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.WorkQueue.AdoptionProcessWorkRequest;
import Business.WorkQueue.MedicalHelpWorkRequest;
import Business.WorkQueue.EducationalHelpWorkRequest;

import Business.WorkQueue.WorkRequest;
import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Kunjan
 */
public class Services extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    EcoSystem system;
    JFreeChart barChart;

    public Services(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        populateBarGraph();
    }
    
    public void populateBarGraph() {
        ArrayList<AdoptionProcessWorkRequest> adpReqList = new ArrayList<>();
        ArrayList<MedicalHelpWorkRequest> medReqList = new ArrayList<>();
        ArrayList<EducationalHelpWorkRequest> finReqList = new ArrayList<>();
        Map<String, Integer> workReqMap = new HashMap<>();
        for (WorkRequest workQue : system.getWorkQueue().getWorkRequestList()) {
            if (workQue instanceof AdoptionProcessWorkRequest) {
                adpReqList.add((AdoptionProcessWorkRequest) workQue);
            } else if (workQue instanceof MedicalHelpWorkRequest) {
                medReqList.add((MedicalHelpWorkRequest) workQue);
            } else if (workQue instanceof EducationalHelpWorkRequest) {
                finReqList.add((EducationalHelpWorkRequest) workQue);
            }

        }
        workReqMap.put("Adoption Services", adpReqList.size());
        workReqMap.put("Medical Help Services", medReqList.size());
        workReqMap.put("Financial Services", finReqList.size());

        barChart = ChartFactory.createPieChart(
                "Services At a Glance",
                createDataset(workReqMap),
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        jPanel1.removeAll();
        jPanel1.add(chartPanel, BorderLayout.CENTER);
        jPanel1.validate();
    }
    
    private PieDataset createDataset(Map<String, Integer> workReqMap) {
        final DefaultPieDataset dataset = new DefaultPieDataset();
        for (String r : workReqMap.keySet()) {
            dataset.setValue(r, workReqMap.get(r));
        }
        return dataset;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1058, 840));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.BorderLayout());
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 860, 600));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(25, 56, 82));
        jButton1.setText("Download Graph");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(25, 56, 82));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("SERVICES AT A GLANCE");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 594, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int width = 640;
            /* Width of the image */
            int height = 480;
            /* Height of the image */
            File BarChart = new File("BarChart.jpeg");
            ChartUtilities.saveChartAsJPEG(BarChart, barChart, width, height);
            JOptionPane.showMessageDialog(null, "A JPEG image file named BarChart.jpeg is downloaded in your current directory.");
        } catch (IOException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}