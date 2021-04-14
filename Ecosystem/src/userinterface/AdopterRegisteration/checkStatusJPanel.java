/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdopterRegisteration;

import Business.Adopter.Adopter;
import Business.Adopter.AdopterDirectory;
import Business.Child.ChildDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.AdopterOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AdopterWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author snehaswaroop
 */
public class checkStatusJPanel extends javax.swing.JPanel {

    /**
     * Creates new form checkStatusJPanel
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
    
    public checkStatusJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, AdopterDirectory udirectory,int uid, ChildDirectory directory) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.udirectory=udirectory;
        this.account=account;
        this.enterprise=enterprise;
        this.business = business;
        this.adopterorganization =(AdopterOrganization) organization;
        this.uid = uid;
        this.directory = directory;
        //if condition for enabling proceed with adoption button if BGC and fin checks are approved
       for(Adopter a: udirectory.getAdoptersList()){
           if(a.getUsername().equals(account.getUsername())){
               adopter=a;
           }
       }
       populateTable();
    }
    
    private void populateTable() {
       DefaultTableModel dtms = (DefaultTableModel) tblReq.getModel();
       dtms.setRowCount(0);
       
       for(WorkRequest req: adopterorganization.getWorkQueue().getWorkRequestList()){
           System.out.println("check status, uid, account"+req.getUserId()+" "+uid+" "+account.getUsername());
           if(req instanceof AdopterWorkRequest ) {
               if(req.getUserId()==adopter.getUserId()){
               Object[] row = new Object[dtms.getColumnCount()];
               row[0]=req;
               row[1]=((AdopterWorkRequest) req).getBgcStatus();
               row[2]=((AdopterWorkRequest) req).getFinanceStatus();
               dtms.addRow(row);
               
               bgcstatus = ((AdopterWorkRequest) req).getBgcStatus();
               financestatus = ((AdopterWorkRequest) req).getFinanceStatus();
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
        tblRequest = new javax.swing.JScrollPane();
        tblReq = new javax.swing.JTable();
        btnProceed = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("TRACK YOUR STATUS");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 240, 20));

        tblReq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Message", "BGC Status", "Criminal Check Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRequest.setViewportView(tblReq);

        add(tblRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 720, 130));

        btnProceed.setText("Proceed");
        btnProceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceedActionPerformed(evt);
            }
        });
        add(btnProceed, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 150, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceedActionPerformed
        // TODO add your handling code here:
        if(tblReq.getRowCount()<1){
            JOptionPane.showMessageDialog(null, "Adoption request is still in process with the Investigation team");
        }
        if(bgcstatus.equals("Approved")&& financestatus.equals("Approved")){
            
        childSelectionJpanel csjp = new childSelectionJpanel(userProcessContainer, account, adopterorganization, enterprise, business, udirectory, uid, directory);
        this.userProcessContainer.add("ChildSelectionJPanel", csjp);
        CardLayout layout = (CardLayout) this.userProcessContainer.getLayout();
        layout.next(userProcessContainer); 
        }
        else if(bgcstatus.equals("Pending")|| financestatus.equals("Pending")){
            JOptionPane.showMessageDialog(null, "Adoption request is still in process with the Investigation team");
        }
        else
            JOptionPane.showMessageDialog(null, "Adoption request denied by Investigation Team");
    }//GEN-LAST:event_btnProceedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProceed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable tblReq;
    private javax.swing.JScrollPane tblRequest;
    // End of variables declaration//GEN-END:variables
}