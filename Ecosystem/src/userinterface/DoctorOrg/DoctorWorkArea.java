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
import Business.Organization.DoctorOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author snehaswaroop
 */
public class DoctorWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminWorkAreaJPanel
     */
    JPanel userProcessContainer;
    EcoSystem ecosystem;
    private DoctorOrganization doctororganization;
    //private OrganizationDirectory directory;
    Enterprise enterprise;
    Child child;
    private UserAccount userAccount;
    ChildDirectory directory;
    
    
    public DoctorWorkArea(JPanel userProcessContainer, UserAccount account, DoctorOrganization doctororganization, Enterprise enterprise ,EcoSystem ecosystem, ChildDirectory directory) {
        initComponents();
        System.out.println("here");
        this.userProcessContainer=userProcessContainer;   
        this.userAccount = account;
        this.enterprise = enterprise;
        this.ecosystem=ecosystem;
        this.doctororganization = (DoctorOrganization)doctororganization;
        this.enterprise = enterprise;
        this.directory = directory;
        this.userAccount = account;
        valueLabel.setText(enterprise.getName());
        manageDoctorWorkAreaJPanel();
        
    }
    
    private void manageDoctorWorkAreaJPanel(){
        DoctorJPanel panel = new DoctorJPanel(rightSystemAdminPanel, userAccount, doctororganization, enterprise, ecosystem, directory);
        rightSystemAdminPanel.add("ManageNetworkJPanel",panel);
        CardLayout layout = (CardLayout) rightSystemAdminPanel.getLayout();
        layout.next(rightSystemAdminPanel);
     }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        systemAdminPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        manageNetworkPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        DoctorWorkArea = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        rightSystemAdminPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(215, 81, 81));
        setPreferredSize(new java.awt.Dimension(1338, 840));
        setLayout(new java.awt.BorderLayout());

        systemAdminPanel.setBackground(new java.awt.Color(255, 204, 153));
        systemAdminPanel.setPreferredSize(new java.awt.Dimension(1338, 840));

        jPanel3.setBackground(new java.awt.Color(255, 204, 153));
        jPanel3.setMinimumSize(new java.awt.Dimension(280, 148));
        jPanel3.setPreferredSize(new java.awt.Dimension(280, 148));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageNetworkPanel.setBackground(new java.awt.Color(255, 204, 153));
        manageNetworkPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageNetworkPanelMousePressed(evt);
            }
        });
        manageNetworkPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/manageIcon.png"))); // NOI18N
        manageNetworkPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 37, -1));

        DoctorWorkArea.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        DoctorWorkArea.setText("Doctor Work Area");
        DoctorWorkArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DoctorWorkAreaMousePressed(evt);
            }
        });
        manageNetworkPanel.add(DoctorWorkArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 6, 225, 36));

        jPanel3.add(manageNetworkPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 280, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/doctorLogo.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 160, 150));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Enterprise");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 90, 30));

        valueLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel3.add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 90, 30));

        rightSystemAdminPanel.setBackground(new java.awt.Color(255, 255, 255));
        rightSystemAdminPanel.setPreferredSize(new java.awt.Dimension(1058, 840));
        rightSystemAdminPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout systemAdminPanelLayout = new javax.swing.GroupLayout(systemAdminPanel);
        systemAdminPanel.setLayout(systemAdminPanelLayout);
        systemAdminPanelLayout.setHorizontalGroup(
            systemAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(systemAdminPanelLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rightSystemAdminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        systemAdminPanelLayout.setVerticalGroup(
            systemAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(rightSystemAdminPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(systemAdminPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void DoctorWorkAreaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DoctorWorkAreaMousePressed
        manageDoctorWorkAreaJPanel();
    }//GEN-LAST:event_DoctorWorkAreaMousePressed

    private void manageNetworkPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageNetworkPanelMousePressed
        // TODO add your handling code here:
        manageDoctorWorkAreaJPanel();
    }//GEN-LAST:event_manageNetworkPanelMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DoctorWorkArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel manageNetworkPanel;
    private javax.swing.JPanel rightSystemAdminPanel;
    private javax.swing.JPanel systemAdminPanel;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
