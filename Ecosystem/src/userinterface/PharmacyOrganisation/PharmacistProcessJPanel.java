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
import Business.Organization.ChildCareOrganization;
import Business.Organization.Organization;
import Business.Organization.PharmacistOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ChildCareWorkRequest;
import Business.WorkQueue.PharmacistWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Business.WorkQueue.WorkRequest;

/**
 *
 * @author snehaswaroop
 */
public class PharmacistProcessJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private EcoSystem business;
    PharmacistWorkRequest request ;
    private ChildDirectory childdirectory;
    private Child child;
    Network network;
    
    public PharmacistProcessJPanel(JPanel userProcessContainer, PharmacistWorkRequest request, UserAccount userAccount, Enterprise enterprise, Child child, ChildDirectory directory, EcoSystem business, PharmacistOrganization pharmacistOrganization) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.request= request;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        this.child = child;
        this.childdirectory=childdirectory;
        this.business = business;
        for(Network net: business.getNetworkList()){
        for(Enterprise ent: net.getEnterpriseDirectory().getEnterpriseList()){
        if(ent.equals(enterprise)){
            network= net;
        }
      }
    }
        valueLabel.setText(enterprise.getName());
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
        btnBack = new javax.swing.JButton();
        lblComments = new javax.swing.JLabel();
        txtComments = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PHARMACIST PROCESS");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 378, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/PharmacyLogo.jpeg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 180, 170));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BackIcon.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 60, 50));

        lblComments.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComments.setText("Comments");
        add(lblComments, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 100, 20));
        add(txtComments, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 310, 130));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, 100, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/PharmacyImage.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 590, 470));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Enterprise");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 100, -1));

        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 110, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        PharmacistJPanel panel = (PharmacistJPanel) component;
        panel.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if( txtComments.getText().isEmpty() )
        {
            JOptionPane.showMessageDialog(null,"Please enter message");
        }
        else {
            request.setTestResult(txtComments.getText());
            request.setStatus("Delivered");
            ChildCareWorkRequest temp = new ChildCareWorkRequest();
            temp.setStatus("Medically Fit");
            temp.setMessage("Child has been cured");
            temp.setSender(userAccount);
            temp.setTestResult("Completed");
            temp.setChildId(request.getChildId());
        
        Organization org = null;
            for (Network network : business.getNetworkList()){
                // getNetworkList().getOrganizationDirectory().getOrganizationList()
                for(Enterprise ent: network.getEnterpriseDirectory().getEnterpriseList()){
                    for(Organization organization: ent.getOrganizationDirectory().getOrganizationList()){
                      // if(this.network.equals(network)){
                            if (organization instanceof ChildCareOrganization){
				org = organization;
				break;
				}
                    }
                }
            }
            if (org!=null){
                org.getWorkQueue().getWorkRequestList().add(temp);
                userAccount.getWorkQueue().getWorkRequestList().add(temp);
                business.getWorkQueue().getWorkRequestList().add(temp);
            }
        }
        
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        PharmacistJPanel panel = (PharmacistJPanel) component;
        panel.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblComments;
    private javax.swing.JTextField txtComments;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
