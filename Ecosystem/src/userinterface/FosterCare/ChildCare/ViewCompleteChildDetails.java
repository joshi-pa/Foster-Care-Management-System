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
import Business.Organization.Organization;
//pjpjp import Business.Organization.Orphanage.ChildCareOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DoctorWorkRequest;
//pjpj import Business.WorkQueue.DoctorWorkRequest;
//pjpj import Business.WorkQueue.FinanceCCWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 12013
 */
public class ViewCompleteChildDetails extends javax.swing.JPanel {

    /**
     * Creates new form ViewCompleteChildDetails
     */
    JPanel userProcessContainer;
    Child child;
   UserAccount account;
    ChildCareOrganization organization;
   Enterprise enterprise;
   EcoSystem business;
   ChildDirectory directory;
       Network network;
	
    ViewCompleteChildDetails(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, ChildDirectory directory, Child child) {
          initComponents();
        this.userProcessContainer=userProcessContainer;
        this.child = child;
        this.account=account;
        this.organization=(ChildCareOrganization) organization;
        this.enterprise=enterprise;
        this.business=business;
        this.directory=directory;        
          for(Network net: business.getNetworkList()){
      for(Enterprise ent: net.getEnterpriseDirectory().getEnterpriseList()){
          if(ent.equals(enterprise)){
              network= net;
          }
      }
  }
        disableInput();
         nameTextField.setText(child.getName());
//        ageComboBox.setSelectedIndex(child.getChildAge());
//pjpj        txtDOB.setText(child.getChildAge());
        if(child.getGender().equalsIgnoreCase("Male")){
            maleRDB.setSelected(true);
        }
        else if(child.getGender().equalsIgnoreCase("female")){
            femaleRDB.setSelected(true);
        }
        jXDatePicker1.setDate(child.getRegistrationDate());
        txtIdentficationMark.setText(child.getIdentificationMark());
        bpText.setText(String.valueOf(child.getBP()));
        pulseText.setText(String.valueOf(child.getPulseRate()));
        tempText.setText(String.valueOf(child.getBodytemp()));
        respRateText.setText(String.valueOf(child.getRespirationRate()));
        medicalTextArea.setText(child.getMedicalStatus());
       // imageTextField.setText(child.getImageDetails());
        displayImage();
        populaterequestTable();
        System.out.println(child.isBed()+" "+child.isTable()+" "+child.isCloset());
        
        
        
    }
    public void displayImage(){
        BufferedImage image = null; //Buffered image object
        String filename = child.getImageDetails(); //Getting the filepath and storing into the string
        
        
        try{
            image = ImageIO.read(new File(filename));  //Reading the filename and storing it in image
        }catch(Exception e){ //Generic exception if something goes wrong while reading the image
            JOptionPane.showMessageDialog(null, "File not found");
        }
       
  //Setting the image to the icon and then passing it ot he image JLabel    
  
ImageIcon icon = new ImageIcon(image);
   imageLable.setIcon(icon);
    
    }
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator4 = new javax.swing.JSeparator();
        buttonGroup1 = new javax.swing.ButtonGroup();
        nameTextField = new javax.swing.JTextField();
        lblDOB = new javax.swing.JLabel();
        maleRDB = new javax.swing.JRadioButton();
        femaleRDB = new javax.swing.JRadioButton();
        lblGender = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        imageLable = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tempText = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        respRateText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        medicalTextArea = new javax.swing.JTextArea();
        lblRegistDate = new javax.swing.JLabel();
        lblIdenMark = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtIdentficationMark = new javax.swing.JTextArea();
        jSeparator5 = new javax.swing.JSeparator();
        btnRequestFunds = new javax.swing.JButton();
        requestMedicalHelpBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        bpText = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        pulseText = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtDOB = new javax.swing.JTextField();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();

        setMinimumSize(new java.awt.Dimension(50, 50));

        lblDOB.setText("Date of Birth:");

        maleRDB.setText("Male");
        maleRDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRDBActionPerformed(evt);
            }
        });

        femaleRDB.setText("Female");

        lblGender.setText("Gender:");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("View Child Details");

        lblName.setText("Name:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Personal Info");

        jLabel7.setText("Temperature");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Medical Details");

        tempText.setMinimumSize(new java.awt.Dimension(50, 50));

        jLabel9.setText("Respiration Rate: ");

        respRateText.setMinimumSize(new java.awt.Dimension(50, 50));

        jLabel10.setText("Medical History:");

        medicalTextArea.setColumns(20);
        medicalTextArea.setRows(5);
        jScrollPane1.setViewportView(medicalTextArea);

        lblRegistDate.setText("Registration Date:");

        lblIdenMark.setText("Identification mark");

        txtIdentficationMark.setColumns(20);
        txtIdentficationMark.setRows(5);
        jScrollPane2.setViewportView(txtIdentficationMark);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnRequestFunds.setText("Request Funds");
        btnRequestFunds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestFundsActionPerformed(evt);
            }
        });

        requestMedicalHelpBtn.setText("Request medical help");
        requestMedicalHelpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestMedicalHelpBtnActionPerformed(evt);
            }
        });

        jButton3.setText("< back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel13.setText("BP:");

        bpText.setMinimumSize(new java.awt.Dimension(50, 50));

        jLabel15.setText("Pulse Rate:");

        pulseText.setMinimumSize(new java.awt.Dimension(50, 50));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Child Id", "Sender", "Receiver", "Result", "Remarks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tempText, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(respRateText, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bpText, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(pulseText, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(requestMedicalHelpBtn)
                                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(87, 87, 87)
                                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnRequestFunds, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(imageLable, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(23, 23, 23)
                                                        .addComponent(lblDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(maleRDB)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(femaleRDB, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(153, 153, 153)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblIdenMark, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(jScrollPane2))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblRegistDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jXDatePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(6, 6, 6)))))
                                .addGap(112, 112, 112)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 38, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageLable, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maleRDB)
                            .addComponent(femaleRDB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegistDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdenMark, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(respRateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bpText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pulseText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tempText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(requestMedicalHelpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnRequestFunds, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ChildCareWorkAreaJPanel dwjp = (ChildCareWorkAreaJPanel) component;
        dwjp.populateChildTable();
        dwjp.populateWorkRequest();

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void requestMedicalHelpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestMedicalHelpBtnActionPerformed
     RequestMedicalHelp rqmh = new RequestMedicalHelp(userProcessContainer, account, organization, enterprise, business, directory, child);
     this.userProcessContainer.add("RequestMedicalHelp", rqmh);
     CardLayout layout = (CardLayout) this.userProcessContainer.getLayout();
     layout.next(userProcessContainer);
    }//GEN-LAST:event_requestMedicalHelpBtnActionPerformed

    private void btnRequestFundsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestFundsActionPerformed
         
       String data = "";
       
       
        //System.out.println("date:"+data);
        RequestFinanceHelp rfhp = new RequestFinanceHelp(userProcessContainer,  account,  organization,  enterprise,  business,  directory, child, data);
       this.userProcessContainer.add("RequestFinanceHelp", rfhp);
       CardLayout layout = (CardLayout)userProcessContainer.getLayout();
       layout.next(userProcessContainer);
       
       
       
    }//GEN-LAST:event_btnRequestFundsActionPerformed

    private void maleRDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRDBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleRDBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bpText;
    private javax.swing.JButton btnRequestFunds;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton femaleRDB;
    private javax.swing.JLabel imageLable;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JLabel lblDOB;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblIdenMark;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblRegistDate;
    private javax.swing.JRadioButton maleRDB;
    private javax.swing.JTextArea medicalTextArea;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField pulseText;
    private javax.swing.JButton requestMedicalHelpBtn;
    private javax.swing.JTextField respRateText;
    private javax.swing.JTextField tempText;
    private javax.swing.JTextField txtDOB;
    private javax.swing.JTextArea txtIdentficationMark;
    // End of variables declaration//GEN-END:variables

    public void disableInput(){
      txtDOB.setEnabled(false);
    femaleRDB.setEnabled(false);
      bpText.setEnabled(false);
      txtIdentficationMark.setEnabled(false);
      jXDatePicker1.setEnabled(false);
      maleRDB.setEnabled(false);
      medicalTextArea.setEnabled(false);
      nameTextField.setEnabled(false);
    pulseText.setEnabled(false);
    
    respRateText.setEnabled(false);
    
    tempText.setEnabled(false);
    }
    
    public void populaterequestTable() {
        DefaultTableModel dtms = (DefaultTableModel) jTable1.getModel();
        dtms.setRowCount(0);
        
        for(WorkRequest request: account.getWorkQueue().getWorkRequestList()){
           if(request.getChildId()==child.getChildId()){
            Object[] row = new Object[dtms.getColumnCount()];
           row[0]=request;
           row[1]=request.getChildId();
           row[2]=request.getSender();
           row[3]=request.getReceiver();
         
            System.out.println("did i print in the viewcompletechilddetaisl populate function");
           if(request instanceof DoctorWorkRequest){
             String result = ((DoctorWorkRequest) request).getTestResult();
            String remarks = ((DoctorWorkRequest) request).getRemarks();
             row[5]=remarks;
            row[4] = result == null ? "Waiting" : result;
           }
           
           
           dtms.addRow(row);
           }
        }
    }
}
