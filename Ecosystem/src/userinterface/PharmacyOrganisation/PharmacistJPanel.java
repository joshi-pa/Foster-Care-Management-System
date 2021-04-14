/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PharmacyOrganisation;

import Business.Child.Child;
import Business.Child.ChildDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.PharmacistOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PharmacistWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author snehaswaroop
 */
public class PharmacistJPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private PharmacistOrganization pharmacistOrganization;
    private Enterprise enterprise;
    private EcoSystem business;
    private UserAccount userAccount;
    private ChildDirectory directory;
    private Child child;
    Network network;

    /**
     * Creates new form PharmacistJPanel
     */
    public PharmacistJPanel(JPanel userProcessContainer, UserAccount account, PharmacistOrganization pharmacistOrganization, Enterprise enterprise, EcoSystem business,ChildDirectory directory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.pharmacistOrganization = (PharmacistOrganization)pharmacistOrganization;
        this.enterprise= enterprise;
        this.business = business;
        this.directory = directory;
	for(Network net: business.getNetworkList()){
        for(Enterprise e: net.getEnterpriseDirectory().getEnterpriseList()){
            if(e.equals(enterprise)){
            network = net;
            }
        }
    }
        valueLabel.setText(enterprise.getName());
        btnProcess.setEnabled(false);
        populateTable();
    }
    
    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel)tblPharmacist.getModel();
        model.setRowCount(0);
        for(WorkRequest request : pharmacistOrganization.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[model.getColumnCount()];
            row[0] = request;
            row[1] = request.getChildId();
            row[2] = request.getChildName();
            row[3] = request.getSender().getEmployee().getName();
            row[4] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[5] = request.getStatus();
            model.addRow(row);
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

        lblLogo = new javax.swing.JLabel();
        lblPharmacist = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPharmacist = new javax.swing.JTable();
        btnAssignToMe = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 153, 255)));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/PharmacyLogo.jpeg"))); // NOI18N
        add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 180, 170));

        lblPharmacist.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblPharmacist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPharmacist.setText("PHARMACIST ORGANISATION");
        add(lblPharmacist, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 450, -1));

        tblPharmacist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Message", "Patient's ID", "Patients Name", "Doctor", "Receiver", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPharmacist);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 850, 150));

        btnAssignToMe.setText("Assign To Me");
        btnAssignToMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignToMeActionPerformed(evt);
            }
        });
        add(btnAssignToMe, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 500, 170, 30));

        btnProcess.setText("Process");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });
        add(btnProcess, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 500, 140, -1));

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refreshIcon.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 120, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/PharmacyImage.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 500, 460));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Enterprise");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 80, 20));

        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 100, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnAssignToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignToMeActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblPharmacist.getSelectedRow();
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null,"Please select a child from table to assign");
            return;
        }
        WorkRequest request = (WorkRequest)tblPharmacist.getValueAt(selectedRow, 0);
///        request.setReceiver(userAccount);
///        request.setStatus("Pending");
        if (request.getStatus().equalsIgnoreCase("Delivered")) {
                JOptionPane.showMessageDialog(null, "Request already completed.");
                return;
                } else {
                request.setReceiver(userAccount);
                request.setStatus("Pending");
                btnProcess.setEnabled(true);
                }
        populateTable();
        //btnProcess.setEnabled(true);
    }//GEN-LAST:event_btnAssignToMeActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblPharmacist.getSelectedRow();
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null,"Please select a child from table before proceeding");
            return;
        }
        PharmacistWorkRequest request = (PharmacistWorkRequest)tblPharmacist.getValueAt(selectedRow, 0);
        if (request.getStatus().equalsIgnoreCase("Delivered")) {
                JOptionPane.showMessageDialog(null, "Request already completed.");
                return;
                } else {
        request.setStatus("Processing");
        }
        PharmacistProcessJPanel processWorkRequestJPanel = new PharmacistProcessJPanel(userProcessContainer, request, userAccount, enterprise,child, directory,business,pharmacistOrganization);
        userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnProcessActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignToMe;
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPharmacist;
    private javax.swing.JTable tblPharmacist;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}