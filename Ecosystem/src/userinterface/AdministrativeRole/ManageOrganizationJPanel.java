/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdministrativeRole;



import Business.Enterprise.AdoptionEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.FosterCareEnterprise;
import Business.Enterprise.FundingEnterprise;

import Business.Enterprise.HospitalEnterprise;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Organization.OrganizationDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class ManageOrganizationJPanel extends javax.swing.JPanel {

    private OrganizationDirectory directory;
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ManageOrganizationJPanel(JPanel userProcessContainer,OrganizationDirectory directory, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.directory = directory;
        this.enterprise=enterprise;
        populateTable();
        //populateCombos();
         organizationJComboBox.removeAllItems();
        if(enterprise instanceof HospitalEnterprise){
             organizationJComboBox.addItem(Type.Doctor);
               organizationJComboBox.addItem(Type.Lab);
               organizationJComboBox.addItem(Type.Pharmacist);
        }
        if(enterprise instanceof FosterCareEnterprise){
          organizationJComboBox.addItem(Type.ChildCare);
               organizationJComboBox.addItem(Type.ChildRegistration);
        }
        if(enterprise instanceof AdoptionEnterprise){
           //organizationJComboBox.addItem(Type.Adopter);
               organizationJComboBox.addItem(Type.Adoption);
               organizationJComboBox.addItem(Type.FinanceCheck); 
                 organizationJComboBox.addItem(Type.CriminalCheck); 
        }
        if(enterprise instanceof FundingEnterprise){
           organizationJComboBox.addItem(Type.FinanceOrganization);
               //organizationJComboBox.addItem(Type.Donor);
               
        }
    }
    
    private void populateCombo(){
        organizationJComboBox.removeAllItems();
       
        for (Type type : Organization.Type.values()){
            if (!type.getValue().equals(Type.Admin.getValue()))
                organizationJComboBox.addItem(type);
        }
    }
    
    

    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
        model.setRowCount(0);
        for (Organization organization : directory.getOrganizationList()){
            Object[] row = new Object[2];
            row[0] = organization.getType();
            row[1] = organization.getName();
            
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

        jScrollPane1 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        orgInstanceName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        organizationJTable.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Organization Type", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(organizationJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 680, 130));

        addJButton.setBackground(new java.awt.Color(255, 255, 255));
        addJButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        addJButton.setText("Add Organization");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        add(addJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 490, 150, 33));

        add(organizationJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 210, 40));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setText("Organization Type ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, -1, 35));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel2.setText("Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, -1, -1));

        orgInstanceName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orgInstanceNameActionPerformed(evt);
            }
        });
        add(orgInstanceName, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 210, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/org.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 640, 570));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("MANAGE ORGANIZATION");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 370, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        Type type = (Type) organizationJComboBox.getSelectedItem();
        if ("".equals(orgInstanceName.getText())) {
            JOptionPane.showMessageDialog(null, "Enter organization name!");
        } else {
            if (directory.isUnique(orgInstanceName.getText())) {
                directory.createOrganization(orgInstanceName.getText(), type);
                JOptionPane.showMessageDialog(null, "Organization Successfully Created");
                orgInstanceName.setText("");
                populateTable();
            } else {
                JOptionPane.showMessageDialog(null, "Organization name already exists!");
            }

        }

    }//GEN-LAST:event_addJButtonActionPerformed

    private void orgInstanceNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orgInstanceNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orgInstanceNameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField orgInstanceName;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable organizationJTable;
    // End of variables declaration//GEN-END:variables
}
