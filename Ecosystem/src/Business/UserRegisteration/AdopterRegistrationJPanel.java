/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserRegisteration;


import Business.EcoSystem;
import Business.Enterprise.Enterprise;

import Business.Network.Network;
import Business.Utils.CommonMail;



import Business.WorkQueue.WorkQueue;
import java.awt.Color;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import Business.WorkQueue.UserRegistrationRequest;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 *
 * @author Kunjan
 */
public class AdopterRegistrationJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;
    private ActionListener eventListener;
    private boolean emailValid;
    private boolean contactValid;
    private boolean userUnique;
    /**
     * Creates new form AdopterRegistrationJPanel
     */
    public AdopterRegistrationJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        usernameExistsMessage.setVisible(false);
        emailValidateMessage.setVisible(false);
        emailSuccessLabel.setVisible(false);
        userNameSuccessLabel.setVisible(false);
        

    }
    
    public static boolean isValidEmail(String email) {
        Pattern pattern;
        Matcher matcher;
        String EMAIL_PATTERN = "^[\\w!#$%&‘*+/=?`{|}~^-]+(?:\\.[\\w!#$%&‘*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
    

//    public void populateNetworkComboBox() {
//        stateCombo.removeAllItems();
//        for (Network network : system.getNetworkList()) {
//            stateCombo.addItem(network);
//        }
//    }
//
//    public void populateCarrierComboBox() {
//        contactCarrier.removeAllItems();
//        contactCarrier.addItem("ATT");
//        contactCarrier.addItem("Sprint");
//        contactCarrier.addItem("TMobile");
//        contactCarrier.addItem("Verizon");
//    }
    
    

  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblUserName = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPwd = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtSSN = new javax.swing.JTextField();
        lblSSN = new javax.swing.JLabel();
        lblIncome = new javax.swing.JLabel();
        txtIncome = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        usernameExistsMessage = new javax.swing.JLabel();
        emailValidateMessage = new javax.swing.JLabel();
        emailSuccessLabel = new javax.swing.JLabel();
        userNameSuccessLabel = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        rdbMale = new javax.swing.JRadioButton();
        rdbFemale = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1338, 900));
        setPreferredSize(new java.awt.Dimension(1338, 900));
        setRequestFocusEnabled(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(25, 56, 82));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADOPTION REQUEST");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 370, -1));

        lblName.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblName.setForeground(new java.awt.Color(25, 56, 82));
        lblName.setText("Name");
        add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, -1, -1));

        txtName.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtName.setForeground(new java.awt.Color(25, 56, 82));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 250, 35));

        lblUserName.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(25, 56, 82));
        lblUserName.setText("Username");
        add(lblUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, -1, -1));

        txtUserName.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtUserName.setForeground(new java.awt.Color(25, 56, 82));
        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUserNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserNameKeyTyped(evt);
            }
        });
        add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 250, 40));

        txtPwd.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtPwd.setForeground(new java.awt.Color(25, 56, 82));
        txtPwd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPwdKeyTyped(evt);
            }
        });
        add(txtPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 250, 40));

        lblPassword.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(25, 56, 82));
        lblPassword.setText("Password");
        add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 62, 20));

        lblEmail.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(25, 56, 82));
        lblEmail.setText("Email Id");
        add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, -1, 20));

        txtEmail.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(25, 56, 82));
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 250, 40));

        txtSSN.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtSSN.setForeground(new java.awt.Color(25, 56, 82));
        txtSSN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSSNKeyTyped(evt);
            }
        });
        add(txtSSN, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 500, 250, 40));

        lblSSN.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblSSN.setForeground(new java.awt.Color(25, 56, 82));
        lblSSN.setText("SSN");
        add(lblSSN, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 510, 50, -1));

        lblIncome.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblIncome.setForeground(new java.awt.Color(25, 56, 82));
        lblIncome.setText("Annual Income");
        add(lblIncome, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 570, -1, 30));

        txtIncome.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtIncome.setForeground(new java.awt.Color(25, 56, 82));
        txtIncome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIncomeActionPerformed(evt);
            }
        });
        txtIncome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIncomeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIncomeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIncomeKeyTyped(evt);
            }
        });
        add(txtIncome, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 570, 250, 35));

        btnRegister.setBackground(new java.awt.Color(255, 255, 255));
        btnRegister.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(25, 56, 82));
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 650, 130, -1));

        usernameExistsMessage.setForeground(new java.awt.Color(255, 0, 0));
        usernameExistsMessage.setText("Username already exists");
        add(usernameExistsMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 210, -1, -1));

        emailValidateMessage.setForeground(new java.awt.Color(255, 0, 0));
        emailValidateMessage.setText("Email format incorrect");
        add(emailValidateMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 320, -1, -1));

        emailSuccessLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tick1.4.gif"))); // NOI18N
        add(emailSuccessLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 310, -1, -1));

        userNameSuccessLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tick1.4.gif"))); // NOI18N
        add(userNameSuccessLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 210, -1, -1));

        lblAge.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblAge.setText("Age");
        add(lblAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 386, 60, 20));
        add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 250, 40));

        lblGender.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblGender.setText("Gender");
        add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 450, 90, 20));

        rdbMale.setText("Male");
        add(rdbMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, -1, -1));

        rdbFemale.setText("Female");
        add(rdbFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 450, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/adp.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 870, 610));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed

        if (txtUserName.getText().isEmpty()) {
            txtUserName.setBorder(BorderFactory.createLineBorder(Color.RED));
            txtUserName.setForeground(Color.red);

        }
        if (txtName.getText().isEmpty()) {
            txtName.setBorder(BorderFactory.createLineBorder(Color.RED));
            txtName.setForeground(Color.red);

        }
        if (txtPwd.getText().isEmpty()) {
            txtPwd.setBorder(BorderFactory.createLineBorder(Color.RED));
            txtPwd.setForeground(Color.red);

        }
        if (txtEmail.getText().isEmpty()) {
            txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED));
            txtEmail.setForeground(Color.red);

        }
        if (txtSSN.getText().isEmpty()) {
            txtSSN.setBorder(BorderFactory.createLineBorder(Color.RED));
            txtSSN.setForeground(Color.red);

        }

        if (txtIncome.getText().isEmpty()) {
            txtIncome.setBorder(BorderFactory.createLineBorder(Color.RED));
            txtIncome.setForeground(Color.red);

        }
        
        if (txtName.getText().isEmpty() || txtPwd.getText().isEmpty() || txtEmail.getText().isEmpty()
                || txtSSN.getText().isEmpty()
              
                || txtIncome.getText().isEmpty()
                
                ) {
            JOptionPane.showMessageDialog(null, "Enter all fields");
//        } else if(!contactValidity(uContact.getText())){
//            JOptionPane.showMessageDialog(null, "Phone format incorrect");
        } 
        else if (emailValid && userUnique) {
            UserRegistrationRequest registrationRequest = new UserRegistrationRequest();
            //AdopterRequest registrationRequest = new AdopterRequest();
            //UserRegistrationRequ registrationRequest = new Adopter();
            
                //Gender
                String gender = "";
                if(rdbMale.isSelected()){
                    gender = "Male";
                }
                else if(rdbFemale.isSelected()){
                    gender = "Female";
                }
            registrationRequest.setName(txtName.getText());
            registrationRequest.setUserName(txtUserName.getText());
            registrationRequest.setUserPassword(txtPwd.getText());
            registrationRequest.setUserEmailId(txtEmail.getText());
            registrationRequest.setGender(gender);
            //registrationRequest.setNetwork(network);
            registrationRequest.setSsn(txtSSN.getText());
            //registrationRequest.setOrgType(type);
            //registrationRequest.setStatus("Requested");
            registrationRequest.setAnnualIncome(txtIncome.getText());
            String contact = "";

//            if (contactCarrier.getSelectedItem().equals("ATT")) {
//                contact = uContact.getText() + "@txt.att.net";
//            } else if (contactCarrier.getSelectedItem().equals("Verizon")) {
//                contact = uContact.getText() + "@vmobl.com";
//            } else if (contactCarrier.getSelectedItem().equals("Sprint")) {
//                contact = uContact.getText() + "@messaging.sprintpcs.com";
//            } else if (contactCarrier.getSelectedItem().equals("TMobile")) {
//                contact = uContact.getText() + "@tmomail.net";
//            }
            //registrationRequest.setContactCarrierName(contact);
            String subject = "Adopter Registeration";
            String content = "Thank you for registering with us. Your account will be activated within 24 hours. We will keep you posted in case of emergencies.";
            CommonMail.sendEmailMessage(txtEmail.getText(),subject,content);
           // sendTextMessage(contact);
            for (Network network1 : system.getNetworkList()) {
                for (Enterprise enterprise : network1.getEnterpriseDirectory().getEnterpriseList()) {
                    if (enterprise.getEnterpriseType() == Enterprise.EnterpriseType.Adoption) {
                        if (enterprise.getWorkQueue() == null) {
                            enterprise.setWorkQueue(new WorkQueue());
                        }
                        enterprise.getWorkQueue().getWorkRequestList().add(registrationRequest);
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "You have been registered succesfully");
            txtUserName.setText("");
            txtName.setText("");
            txtPwd.setText("");
            txtEmail.setText("");
            txtSSN.setText("");
            txtIncome.setText("");
            txtAge.setText("");
            
            
//        } else if (!emailValid || !contactValid || !userUnique) {
//            JOptionPane.showMessageDialog(null, "Invalid credentials");
//        }
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameKeyPressed

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        // TODO add your handling code here:
        txtName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txtName.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtNameKeyTyped

    private void txtUserNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameKeyTyped

    private void txtPwdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPwdKeyTyped
        // TODO add your handling code here:
        txtPwd.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txtPwd.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtPwdKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        // TODO add your handling code here:
        if (!isValidEmail(txtEmail.getText())) {
            emailValidateMessage.setVisible(true);
            emailValid = false;
        } else {
            txtEmail.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            txtEmail.setForeground(Color.BLACK);
            emailValidateMessage.setVisible(false);
            emailSuccessLabel.setVisible(true);
            emailValid = true;
            int delay = 2500; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    emailSuccessLabel.setVisible(false);
                }
            };
            javax.swing.Timer tick = new javax.swing.Timer(delay, taskPerformer);
            tick.setRepeats(false);
            tick.start();
        }
    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtSSNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSSNKeyTyped
        // TODO add your handling code here:
        txtSSN.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txtSSN.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtSSNKeyTyped

    private void txtUserNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyReleased
        // TODO add your handling code here:
        if (!system.checkIfUserIsUnique(txtUserName.getText())) {
            usernameExistsMessage.setVisible(true);
            userNameSuccessLabel.setVisible(false);
            userUnique = false;
        } else {
            txtUserName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            txtUserName.setForeground(Color.BLACK);
            usernameExistsMessage.setVisible(false);
            userNameSuccessLabel.setVisible(true);
            userUnique = true;
            int delay = 2500; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    userNameSuccessLabel.setVisible(false);
                }
            };
            javax.swing.Timer tick = new javax.swing.Timer(delay, taskPerformer);
            tick.setRepeats(false);
            tick.start();
        }
    }//GEN-LAST:event_txtUserNameKeyReleased


    private void txtIncomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIncomeKeyReleased
        // TODO add your handling code here:
        //        if(uContact.getText().trim().length() != 11){
            //          contactFormatMessage.setVisible(true);
            //          contactValid = false;
            //        }
        //        else if (!contactValidity(uContact.getText())) {
            //            contactFormatMessage.setVisible(true);
            //            contactValid = false;
            //        } else {
            //            uContact.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            //            uContact.setForeground(Color.BLACK);
            //            contactFormatMessage.setVisible(false);
            //            contactSuccessLabel.setVisible(true);
            //            contactValid = true;
            //            int delay = 2500; //milliseconds
            //            ActionListener taskPerformer = new ActionListener() {
                //                public void actionPerformed(ActionEvent evt) {
                    //                    contactSuccessLabel.setVisible(false);
                    //                }
                //            };
            //            javax.swing.Timer tick = new javax.swing.Timer(delay, taskPerformer);
            //            tick.setRepeats(false);
            //            tick.start();
            //        }
    }//GEN-LAST:event_txtIncomeKeyReleased

    private void txtIncomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIncomeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIncomeKeyPressed

    private void txtIncomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIncomeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIncomeKeyTyped

    private void txtIncomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIncomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIncomeActionPerformed


    public static void sendEmailMessage(String emailId) {
// Recipient's email ID needs to be mentioned.
        String to = emailId;
        String from = "donotreplyers@gmail.com";
        String pass = "devhuskies";
// Assuming you are sending email from localhost
// String host = "192.168.0.16";

// Get system properties
        Properties properties = System.getProperties();
        String host = "smtp.gmail.com";

        properties.put("mail.smtp.starttls.enable", "true");

        properties.put("mail.smtp.ssl.trust", host);
        properties.put("mail.smtp.user", from);
// properties.put("mail.smtp.password", pass);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

// Setup mail server
// properties.setProperty("mail.smtp.host", host);
// properties.put("mail.smtp.starttls.enable", "true");
// Get the default Session object.
//        Session session = Session.getDefaultInstance(properties);
//
//        try {
// Create a default MimeMessage object.
//            MimeMessage message = new MimeMessage(session);

// Set From: header field of the header.
//            message.setFrom(new InternetAddress(from));

// Set To: header field of the header.
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

// Set Subject: header field
//            message.setSubject("Volunteer Registration");
//            message.setText("Thank you for registering with us. Your account will be activated within 24 hours. We will keep you posted in case of emergencies.");
// Send message
//            Transport transport = session.getTransport("smtp");
//            transport.connect(host, from, pass);
//            transport.sendMessage(message, message.getAllRecipients());
//            transport.close();
//            System.out.println("Sent message successfully....");
//        } catch (MessagingException mex) {
//            mex.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Invalid email id");
//        }
    }

    public static void sendTextMessage(String contact) {
        // Recipient's email ID needs to be mentioned.
        String to = contact;
        System.out.println(contact);
        String from = "donotreplyers@gmail.com";
        String pass = "devhuskies";
        // Assuming you are sending email from localhost
        // String host = "192.168.0.16";
        // Get system properties
        Properties properties = System.getProperties();
        String host = "smtp.gmail.com";
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", host);
        properties.put("mail.smtp.user", from);
        // properties.put("mail.smtp.password", pass);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        // Setup mail server
        // properties.setProperty("mail.smtp.host", host);
        //  properties.put("mail.smtp.starttls.enable", "true");
        // Get the default Session object.
//        Session session = Session.getDefaultInstance(properties);
        //       final PasswordAuthentication auth = new PasswordAuthentication(from, pass);
//Session session = Session.getDefaultInstance(properties, new Authenticator() {
//    @Override
//    protected PasswordAuthentication getPasswordAuthentication() { return auth; }
//});
//Session session = Session.getInstance(properties);
//        try {
//            // Create a default MimeMessage object.
//            MimeMessage message = new MimeMessage(session);
//
//            // Set From: header field of the header.
//            message.setFrom(new InternetAddress(from));
//
//            // Set To: header field of the header.
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//            // Set Subject: header field
//            message.setSubject("Volunteer Registration");
//            message.setText("Thank you for registering with us. Your account will be activated within 24 hours. We will keep you posted in case of emergencies.");
//            // Send message
//            Transport transport = session.getTransport("smtp");
//            transport.connect(host, from, pass);
//            transport.sendMessage(message, message.getAllRecipients());
//            transport.close();
//            System.out.println("Sent message successfully....");
//        } catch (MessagingException mex) {
//            mex.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Invalid email id");
//        }
    }

    public Boolean contactValidity(String custContact) {
        String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
        Pattern pattern = Pattern.compile(regex);
        
        Matcher matcher = pattern.matcher(custContact);
        if(matcher.matches()){
            return true;
        }
        return false;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel emailSuccessLabel;
    private javax.swing.JLabel emailValidateMessage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblIncome;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSSN;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JRadioButton rdbFemale;
    private javax.swing.JRadioButton rdbMale;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIncome;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPwd;
    private javax.swing.JTextField txtSSN;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JLabel userNameSuccessLabel;
    private javax.swing.JLabel usernameExistsMessage;
    // End of variables declaration//GEN-END:variables
}
