/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.FosterCare.ChildCare;

import Business.Child.Child;
import Business.Child.ChildDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.ChildCareOrganization;
import Business.Organization.FinanceOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EducationalHelpWorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author 12013
 */
public class RequestFinanceHelp extends javax.swing.JPanel {

    /**
     * Creates new form RequestFinanceHelp
     */
  JPanel userProcessContainer;
  UserAccount account;
  ChildCareOrganization organization;
  Enterprise enterprise;
  EcoSystem business;
  ChildDirectory directory;
  Child child;
  String data;
    Network network;

   public RequestFinanceHelp(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, ChildDirectory directory, Child child, String data) {
     initComponents();
     this.userProcessContainer=userProcessContainer;
     this.account=account;
     this.organization = (ChildCareOrganization) organization;
     this.enterprise=enterprise;
     this.business=business;
     this.directory=directory;
     this.child=child;
     
     	
	 for(Network net: business.getNetworkList()){
      for(Enterprise ent: net.getEnterpriseDirectory().getEnterpriseList()){
          if(ent.equals(enterprise)){
              network= net;
          }
      }
  }
  
     
//     jTextArea1.removeAll();;
//     jTextArea1.setText("Amentities requested: "+data);
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEduFunds = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEduFunds = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtFundsMedExp = new javax.swing.JTextField();
        txtFundsLiving = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFundsMisc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEduFunds.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblEduFunds.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEduFunds.setText("Funds for Education");
        add(lblEduFunds, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 190, 40));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Miscellaneous");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 213, 38));
        add(txtEduFunds, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 222, 27));

        btnSubmit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSubmit.setText("Request");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 480, 133, 33));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Funds for Medical Expenses");
        jLabel4.setToolTipText("");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 240, 36));

        txtFundsMedExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFundsMedExpActionPerformed(evt);
            }
        });
        add(txtFundsMedExp, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 222, 27));
        add(txtFundsLiving, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 222, 27));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Funds for Living Expenses");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 230, 36));
        add(txtFundsMisc, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 222, 27));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REQUEST FOR FUNDS");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 870, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/funds.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 860, 380));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if (txtEduFunds.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Message for finance team");
            return;
        }
        EducationalHelpWorkRequest fccwr = new EducationalHelpWorkRequest();
        try {
            Long amt = Long.parseLong(txtEduFunds.getText()) + Long.parseLong(txtFundsMedExp.getText())  + Long.parseLong(txtFundsLiving.getText())
                    + Long.parseLong(txtFundsMisc.getText());
            fccwr.setAmt(amt.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter numeric amount");
            return;
        }
        fccwr.setMessage("Requesting funds");
        fccwr.setStatus("Initiated");
        //fccwr.setAmt(data);
        fccwr.setSender(account);
        fccwr.setChildId(child.getChildId());

        fccwr.setRemarks("Request for Finance Team");

        List<Organization> org = new ArrayList<>();
        for (Network network : business.getNetworkList()) {
            // getNetworkList().getOrganizationDirectory().getOrganizationList()
            System.out.println("network: " + network);
            for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {

                for (Organization organization : ent.getOrganizationDirectory().getOrganizationList()) {

                    // if(this.network.equals(network)){
                    if (organization instanceof FinanceOrganization) {
                        org.add(organization);
                        organization.getWorkQueue().getWorkRequestList().add(fccwr);
                    }
                    //}

                }
            }
        }

        if (org.size() > 0) {

            account.getWorkQueue().getWorkRequestList().add(fccwr);
            business.getWorkQueue().getWorkRequestList().add(fccwr);

        }

        JOptionPane.showMessageDialog(null, "Request raised to Funding team");

        ViewCompleteChildDetails vccd = new ViewCompleteChildDetails(userProcessContainer, account, organization, enterprise, business, directory, child);
        this.userProcessContainer.add("ViewCompleteChildDetails", vccd);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
        
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtFundsMedExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFundsMedExpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFundsMedExpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblEduFunds;
    private javax.swing.JTextField txtEduFunds;
    private javax.swing.JTextField txtFundsLiving;
    private javax.swing.JTextField txtFundsMedExp;
    private javax.swing.JTextField txtFundsMisc;
    // End of variables declaration//GEN-END:variables
}
