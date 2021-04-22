/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdopterRegisteration;

import Business.Adopter.Adopter;
import Business.Adopter.AdopterDirectory;
import Business.Child.Child;
import Business.Child.ChildDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.AdopterOrganization;
import Business.Organization.ChildCareOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Utils.CommonMail;
import Business.WorkQueue.ChildCareAdoptionWorkRequest;
import Business.WorkQueue.ChildCareWorkRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author snehaswaroop
 */
public class ChildSelectionJpanel extends javax.swing.JPanel {

    /**
     * Creates new form childStatusJpanel
     */
    
    JPanel userProcessContainer;
    UserAccount account;
    Enterprise enterprise;
    EcoSystem business;
    AdopterDirectory udirectory;
    AdopterOrganization adopterorganization;
    Adopter adopter;
    String bgcstatus,financestatus;
    int uid;
    ChildDirectory directory;
    ChildCareWorkRequest request;
    
    public ChildSelectionJpanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, AdopterDirectory udirectory, int uid, ChildDirectory directory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.udirectory = udirectory;
        this.account = account;
        this.enterprise = enterprise;
        this.business = business;
        this.adopterorganization = (AdopterOrganization) organization;
        this.uid = uid;
        this.directory = directory;
        for (Adopter a : udirectory.getAdoptersList()) {
            if (a.getUsername().equals(account.getUsername())) {
                adopter = a;
            }
        }
        populateChildTable();
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
        tblChild = new javax.swing.JTable();
        btnAdopt = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHILD SELECTION");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 383, -1));

        tblChild.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblChild.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Child ID", "Child Name", "Gender", "Age", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblChild);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 790, 120));

        btnAdopt.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnAdopt.setText("Adopt");
        btnAdopt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdoptActionPerformed(evt);
            }
        });
        add(btnAdopt, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 100, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/adopt.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 830, 520));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdoptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdoptActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblChild.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }
        Child ch = (Child) tblChild.getValueAt(selectedRow, 0);
        ChildCareAdoptionWorkRequest adc = new ChildCareAdoptionWorkRequest();
        adc.setChildId(ch.getChildId());
        adc.setUserId(uid);
        adc.setUserName(adopter.getName());
        adc.setMessage("I want to adopt");
        adc.setStatus("Adopted");
        adc.setChildName(ch.getName());
        adc.setEmailId(adopter.getEmailId());
        Organization org = null;
        for (Network network : business.getNetworkList()) {
            for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization organization : ent.getOrganizationDirectory().getOrganizationList()) {
                    if (organization instanceof ChildCareOrganization) {
                        org = organization;
                        break;
                    }
                }
            }
        }
        if (org != null) {
            org.getWorkQueue().getWorkRequestList().add(adc);
            account.getWorkQueue().getWorkRequestList().add(adc);
            business.getWorkQueue().getWorkRequestList().add(adc);
        }
        adopter.setFlag(false);
        JOptionPane.showMessageDialog(null, "Request has been sent to Child Care");
    }//GEN-LAST:event_btnAdoptActionPerformed

    public void populateChildTable() {
        DefaultTableModel dtms = (DefaultTableModel) tblChild.getModel();
        dtms.setRowCount(0);
        for (Child child : directory.getChildList()) {
            if ("Acquired".equalsIgnoreCase(child.getStatus()) || ("Adopted by " + adopter.getName()).startsWith(child.getStatus())) {
                Object[] row = new Object[dtms.getColumnCount()];
                row[0] = child;
                row[1] = child.getName();
                row[2] = child.getGender();
                row[3] = child.getChildAge();
                row[4] = child.getStatus();
                dtms.addRow(row);
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdopt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblChild;
    // End of variables declaration//GEN-END:variables
}
