/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorOrg;

import Business.Child.Child;
import Business.Child.ChildDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PharmacistOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.MedicalHelpWorkRequest;
import Business.WorkQueue.PharmacistWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author snehaswaroop
 */
public class DoctorPrescibeMedicine extends javax.swing.JPanel {

    /**
     * Creates new form DoctorPrescibeMedicineJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private ChildDirectory childdirectory;
    private Child child;
    private  MedicalHelpWorkRequest request;
    private  EcoSystem business;
    Network network;
    
    
    public DoctorPrescibeMedicine(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise, Child child, ChildDirectory childdirectory, MedicalHelpWorkRequest request, EcoSystem business) {
        initComponents();
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        this.child = child;
        this.childdirectory = childdirectory;
        this.business = business;
        this.request = request;
        for (Network net : business.getNetworkList()) {
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
                if (ent.equals(enterprise)) {
                    network = net;
                }
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
        lblPrescription = new javax.swing.JLabel();
        txtPrescription = new javax.swing.JTextField();
        Save = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRESCRIBE MEDICINE");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 309, -1));

        lblPrescription.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lblPrescription.setText("Prescription");
        add(lblPrescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 160, 20));
        add(txtPrescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 270, 90));

        Save.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        add(Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 470, 120, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/prescribtion.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 100, 550, 570));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/BackIcon.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 60, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
        String prescription = txtPrescription.getText();
        if (prescription.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter medicines to be prescribed");
        } else {
            PharmacistWorkRequest pharrequest = new PharmacistWorkRequest();
            pharrequest.setMessage("Medicine Prescribed");
            pharrequest.setSender(userAccount);
            pharrequest.setChildId(request.getChildId());
            pharrequest.setChildName(request.getChildName());
            pharrequest.setStatus("Prescription Sent");
            pharrequest.setPrescription(prescription);
            request.setStatus("Medicine Prescribed");
            request.setTestResult("Child Treated and medicines Prescribed");
            JOptionPane.showMessageDialog(this, "Medicines prescribed! ");
            Organization org = null;
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof PharmacistOrganization) {
                    org = organization;
                    break;
                }
            }
            if (org != null) {
                org.getWorkQueue().getWorkRequestList().add(pharrequest);
                userAccount.getWorkQueue().getWorkRequestList().add(pharrequest);
            }
        }
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        AssignChildJPanel panel = (AssignChildJPanel) component;
        panel.populateMedicationTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_SaveActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        AssignChildJPanel panel = (AssignChildJPanel) component;
        panel.populateLabTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Save;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblPrescription;
    private javax.swing.JTextField txtPrescription;
    // End of variables declaration//GEN-END:variables
}
