/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Adoption.Adoption;

import Business.Adopter.Adopter;
import Business.Adopter.AdopterDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.AdoptionOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AdoptionProcessWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author snehaswaroop
 */
public class AdoptionRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdoptionCheckTable
     */
    
    JPanel userProcessContainer;
    UserAccount account;
    Enterprise enterprise;
    EcoSystem business;
    AdopterDirectory adopterdirectory;
    AdoptionOrganization adoptionOrganization;
    Adopter adopter;
    
    public AdoptionRequestJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, AdopterDirectory adopterdirectory) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.adopterdirectory=adopterdirectory;
        this.account=account;
        this.enterprise=enterprise;
        this.business = business;
        this.adoptionOrganization = (AdoptionOrganization)organization;
        populateWorkRequest();
    }
    
    public void populateWorkRequest() {

        DefaultTableModel dtm = (DefaultTableModel) tblAdoptersRequest.getModel();
        dtm.setRowCount(0);
        for (WorkRequest request : this.business.getWorkQueue().getWorkRequestList()) {

            if (request instanceof AdoptionProcessWorkRequest) {
                Object[] row = new Object[dtm.getColumnCount()];
                row[0] = request;
                row[1] = request.getName();
                row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                row[3] = request.getUserId();
                row[4] = request.getStatus();

                dtm.addRow(row);
            }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAdoptersRequest = new javax.swing.JTable();
        btnAssignToMe = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADOPTION REQUEST");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 357, -1));

        tblAdoptersRequest.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblAdoptersRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Message", "Adopter Name", "Receiver", "Adopter ID", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblAdoptersRequest);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 830, 160));

        btnAssignToMe.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnAssignToMe.setText("Assign To Me");
        btnAssignToMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignToMeActionPerformed(evt);
            }
        });
        add(btnAssignToMe, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 132, -1));

        btnProcess.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnProcess.setText("Process");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });
        add(btnProcess, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, 112, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/adopt.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 730, 530));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignToMeActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblAdoptersRequest.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request to process");
            return;
        }
        Object receiverval = tblAdoptersRequest.getValueAt(selectedRow, 2);
        Object statusval = tblAdoptersRequest.getValueAt(selectedRow, 4);
        if (receiverval == null && (statusval == null || "".equalsIgnoreCase((String) statusval))) {
            WorkRequest re = (WorkRequest) tblAdoptersRequest.getValueAt(selectedRow, 0);
            re.setReceiver(account);
            re.setStatus("Pending with Adoption Organization");
            JOptionPane.showMessageDialog(null, "Request has been assigned to you");
            populateWorkRequest();
        } else if ("Initialized BGC".equals(statusval))
            JOptionPane.showMessageDialog(null, "Please select some other request, this work request is already processed");
        else if (!receiverval.equals(account.getUsername()))
            JOptionPane.showMessageDialog(null, "Work request is assigned to someone else");
        else if (receiverval.equals(account.getUsername())) {
            JOptionPane.showMessageDialog(null, "Work request is already assigned to you");
        }
    }//GEN-LAST:event_btnAssignToMeActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblAdoptersRequest.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
        WorkRequest req = (WorkRequest) tblAdoptersRequest.getValueAt(selectedRow, 0);
        Object receiverval = tblAdoptersRequest.getValueAt(selectedRow, 2);
        Object statusval = tblAdoptersRequest.getValueAt(selectedRow, 4);
        for (Adopter a : adopterdirectory.getAdoptersList()) {
            if (a.getUserId() == req.getUserId()) {
                adopter = a;
            }
        }
        if (receiverval == null) {
            JOptionPane.showMessageDialog(null, "Please first assign it to yourself");
        } else {
            if (receiverval.equals(account.getUsername()) && "Pending with Adoption Organization".equals(statusval)) {
                AdoptionCheckProcess panel = new AdoptionCheckProcess(userProcessContainer, account, adoptionOrganization, enterprise, business, adopterdirectory, (AdoptionProcessWorkRequest) req, adopter);
                this.userProcessContainer.add("AdoptionCheckProcessRequestJPanel", panel);
                CardLayout layout = (CardLayout) this.userProcessContainer.getLayout();
                layout.next(userProcessContainer);
//            } else if (!receiverval.equals(account.getUsername())) {
//                JOptionPane.showMessageDialog(null, "Please select the work request assigned to you to proceed");
//            } else if (!"Pending with Adoption Organization".equals(statusval)) {
//                JOptionPane.showMessageDialog(null, "The selected workrequest assigned to you is already processed");
            }
        }
    }//GEN-LAST:event_btnProcessActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignToMe;
    private javax.swing.JButton btnProcess;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAdoptersRequest;
    // End of variables declaration//GEN-END:variables
}
