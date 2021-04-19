/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdopterRoleAdmin;

import Business.Adopter.Adopter;
import Business.Adopter.AdopterDirectory;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.AdoptionOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Role.AdopterRole;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.AdoptionWorkRequest;
import Business.WorkQueue.AdopterRegistrationRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kunjan
 */
public class AdoptionUnitWorkRequestJPanel extends javax.swing.JPanel {

    
    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private Network network;
    private OrganizationDirectory organizationDirectory;
    AdopterDirectory udirectory;
    public AdoptionUnitWorkRequestJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, EcoSystem system,AdopterDirectory udirectory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.enterprise = enterprise;
        //this.network = network;
        this.business = system.getInstance();
        this.udirectory = udirectory;
       //this.organizationDirectory = (OrganizationDirectory) organizationDirectory;
        this.organizationDirectory = enterprise.getOrganizationDirectory();
        this.business = system.getInstance();
        //workRequestJTable.getTableHeader().setDefaultRenderer(new HeaderColors());
        populateTable();
    }
    
    public void populateTable() {
        
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);

        for (WorkRequest workRequest : enterprise.getWorkQueue().getWorkRequestList()) {

            if (workRequest instanceof AdopterRegistrationRequest) {
                Object[] row = new Object[model.getColumnCount()];
                row[0] = workRequest;
                row[1] = ((AdopterRegistrationRequest) workRequest).getName();
                row[2] = ((AdopterRegistrationRequest) workRequest).getUserEmailId();
                row[3] = ((AdopterRegistrationRequest) workRequest).getGender();
                row[4] = ((AdopterRegistrationRequest) workRequest).getAnnualIncome();
                row[5] = ((AdopterRegistrationRequest) workRequest).getSsn();
                row[6] = ((AdopterRegistrationRequest) workRequest).getStatus();

                model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        assignJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1058, 840));
        setPreferredSize(new java.awt.Dimension(1058, 840));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        workRequestJTable.setForeground(new java.awt.Color(25, 56, 82));
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "UserName", "Name", "Email ID", "Gender", "Income", "SSN", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workRequestJTable.setSelectionBackground(new java.awt.Color(56, 90, 174));
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 980, 170));

        assignJButton.setBackground(new java.awt.Color(255, 255, 255));
        assignJButton.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        assignJButton.setForeground(new java.awt.Color(25, 56, 82));
        assignJButton.setText("Assign To Me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, -1, -1));

        processJButton.setBackground(new java.awt.Color(255, 255, 255));
        processJButton.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        processJButton.setForeground(new java.awt.Color(25, 56, 82));
        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, 120, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(25, 56, 82));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADOPTION WORK REQUEST");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 41, 431, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/funds.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 870, 300));
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow >= 0) {
            WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
            if("Completed".equalsIgnoreCase(request.getStatus())) {
                JOptionPane.showMessageDialog(null, "Request already processed.");
                return;
            } else {
                request.setReceiver(userAccount);
                request.setStatus("Pending");
                
                populateTable();
                JOptionPane.showMessageDialog(null, "Request has successfully assigned");
           }
        } else {
            JOptionPane.showMessageDialog(null, "Choose a request to process.");
            return;
        }
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();
        //try{
        if (selectedRow >= 0) {
            AdopterRegistrationRequest request = (AdopterRegistrationRequest) workRequestJTable.getValueAt(selectedRow, 0);
            /*Employee emp = new Employee();
            emp.setName(request.getName());*/
            if("Completed".equalsIgnoreCase(request.getStatus())) {
                JOptionPane.showMessageDialog(null, "Request already processed.");
                return;
            } else {
         
                Organization org = organizationDirectory.createOrganization(request.getName(),Organization.Type.Adopter );
                Employee emp = org.getEmployeeDirectory().createEmployee(request.getName());
                UserAccount ua1 = org.getUserAccountDirectory().createUserAccount(request.getUserName(), request.getUserPassword(), emp, new AdopterRole());
                Adopter adopter = new Adopter();//create instance of Adopter
      int  uid = udirectory.getAdoptersList().size()+1;// user id
        
            adopter = this.udirectory.addAdopter();
        //feed this input to the directory
        //adopter.setAge(age);
//        adopter.setAnnualIncome(Long.parseLong(request.getUserContact()));
        adopter.setAnnualIncome(Long.parseLong(request.getAnnualIncome()));
        //adopter.setAnnualIncome(request.getAnnualIncome());
        adopter.setEmailId(request.getUserEmailId());
        adopter.setGender(request.getGender());
        adopter.setName(request.getName());
        adopter.setSsn(request.getSsn());
        adopter.setUserId(uid);
        adopter.setUsername(ua1.getUsername());
        adopter.setFlag(false);
        adopter.setName(request.getName());
            AdoptionWorkRequest awr = new AdoptionWorkRequest();
            awr.setStatus("");
            awr.setMessage("I want to adopt");
            awr.setSender(ua1);
            awr.setUserId(adopter.getUserId());
            awr.setName(adopter.getName());

            request.setStatus("Completed");
            JOptionPane.showMessageDialog(null, "User account has been activated successfully");
            
                  
       
        /*
        The below set of code iterates through the network list and get the network
        Once the network is received then it iterates over all the enterprises present in the network
        It goes thought every organization in the enterprise.
        
        Once it has found the Doctor organization, it sets the organization as Doctor organization
        
        */
        Organization org1 = null;
        List<Organization> list = new ArrayList<>();
        for (Network network : this.business.getNetworkList()){
           // getNetworkList().getOrganizationDirectory().getOrganizationList()
            System.out.println("ye hai network: "+network);
            for(Enterprise ent: network.getEnterpriseDirectory().getEnterpriseList()){
                System.out.println("ye hai enterprise: "+ent);
                for(Organization organization: ent.getOrganizationDirectory().getOrganizationList()){
                    System.out.println("ye hai org: "+organization);
                       
                    if (organization instanceof AdoptionOrganization){

                        org1 = organization;
                        System.out.println("ye hai org: "+org1);
                        list.add(organization);
                       org1.getWorkQueue().getWorkRequestList().add(awr);
                       
                    } 
                }
            }
        //}
        }
            
        /*The below if code checks if there is some value for org. If there is then add the work request 
        - At the organization level, where other organization in the same enterprise can access it
        -At the account level, so the adopter can also see see the request created
        - At the business level, as the request has to be transferred to a different organization in a different enterprise.
        */
        if (!list.isEmpty() && list.size()>0){
            ua1.getWorkQueue().getWorkRequestList().add(awr);
            business.getWorkQueue().getWorkRequestList().add(awr);
            populateTable();
            } else {
            JOptionPane.showMessageDialog(null, "Please select a request message to process.");
            return;
            }
            }
        }
    }//GEN-LAST:event_processJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
