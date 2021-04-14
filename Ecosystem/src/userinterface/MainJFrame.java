/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import Business.Adopter.AdopterDirectory;
import Business.Child.ChildDirectory;
import Business.EcoSystem;
import Business.DB4OUtil.DB4OUtil;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.DoctorRole;

import Business.Role.Role;
import Business.Role.Role.RoleType;


import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import userinterface.AdopterRegisteration.AdopterRegistrationJPanel;
//import userinterface.UserRegisteration.UserRegistrationJPanel;

/**
 *
 * @author Lingfeng
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    private EcoSystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    UserAccount userAccount;
    Enterprise inEnterprise;
    Organization inOrganization;
    Network networkEmergency;
    private ChildDirectory directory;
    private AdopterDirectory udirectory;

    public MainJFrame() {
        this.setUndecorated(true);
        initComponents();
        system = dB4OUtil.retrieveSystem();
        EcoSystem.setInstance(system);
        loginJPanel.setVisible(true);
        container.setVisible(false);
        UpperPanel.setVisible(false);
        this.setSize(1250, 800);
        
        getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        //directory = dB4OUtil.retrieveDirectory();
        //udirectory = dB4OUtil.retrieveUserDirectory();
       udirectory = system.getUdirectory();
        directory = system.getDirectory();

    }

    private void changePanel1() {

        if (userAccount != null && userAccount.getRole() != null) {
            String greetings = " ";
//            if (userAccount.getRole() instanceof DoctorRole) {
//                greetings = greetings + " " + userAccount.getUsername();
//                container.add("workArea", userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, networkEmergency, system));
//            } else if (userAccount.getRole() instanceof DisasterHead) {
//                greetings = greetings + " " + userAccount.getUsername();
//                container.add("workArea", userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, networkEmergency, system));
//            } else if (userAccount.getRole() instanceof EmergencyUnitAdmin) {
//                greetings = greetings + " " + userAccount.getUsername();
//                container.add("workArea", userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, networkEmergency, system));
//            } else if (userAccount.getRole() instanceof FireSafetyHead) {
//                greetings = greetings + " " + userAccount.getUsername();
//                container.add("workArea", userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, networkEmergency, system));
//            } else if (userAccount.getRole() instanceof HospitalAdmin) {
//                greetings = greetings + " " + userAccount.getUsername();
//                container.add("workArea", userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, networkEmergency, system));
//            }else if (userAccount.getRole() instanceof IncidentUnitManager) {
//                greetings = greetings + " " + userAccount.getUsername();
//                container.add("workArea", userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, networkEmergency, system)); 
//            }else if (userAccount.getRole() instanceof MedicalAgencyHead) {
//                greetings = greetings + " " + userAccount.getUsername();
//                container.add("workArea", userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, networkEmergency, system)); 
//            }else if (userAccount.getRole() instanceof NGOAdmin) {
//                greetings = greetings + " " + userAccount.getUsername();
//                container.add("workArea", userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, networkEmergency, system)); 
//            }else if (userAccount.getRole() instanceof PersonalAdmin) {
//                greetings = greetings + " " + userAccount.getUsername();
//                container.add("workArea", userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, networkEmergency, system)); 
//            }else if (userAccount.getRole() instanceof PoliceHead) {
//                greetings = greetings + " " + userAccount.getUsername();
//                container.add("workArea", userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, networkEmergency, system)); 
//            }else if (userAccount.getRole() instanceof ReportingAdmin) {
//                greetings = greetings + " " + userAccount.getUsername();
//                container.add("workArea", userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, networkEmergency, system)); 
//            }else if (userAccount.getRole() instanceof SceneManager) {
//                greetings = greetings + " " + userAccount.getUsername();
//                container.add("workArea", userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, networkEmergency, system)); 
//            }else if (userAccount.getRole() instanceof VoluntaryUnitAdmin) {
//                greetings = greetings + " " + userAccount.getUsername();
//                container.add("workArea", userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, networkEmergency, system)); 
//            }else {
//                greetings = greetings + " " + userAccount.getUsername();
//                container.add("workArea", userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, networkEmergency, system));
//            }
            greetings = greetings + " " + userAccount.getUsername();
            container.add("workArea",userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, system, directory, udirectory));
            greetingUserLabel.setText(greetings + " ");
            CardLayout layout = (CardLayout) container.getLayout();
            layout.next(container);
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

        UpperPanel = new javax.swing.JPanel();
        btnLogoutLabel = new javax.swing.JLabel();
        greetingUserLabel = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        container = new javax.swing.JPanel();
        loginJPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        userNameJTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JLabel();
        cancelButton = new javax.swing.JLabel();
        btnDonate = new javax.swing.JLabel();
        btnRegisterForAdoption = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 23, 1338, 900));
        setMinimumSize(new java.awt.Dimension(1338, 900));
        setSize(new java.awt.Dimension(1338, 900));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UpperPanel.setBackground(new java.awt.Color(255, 255, 255));
        UpperPanel.setMinimumSize(new java.awt.Dimension(1338, 60));
        UpperPanel.setPreferredSize(new java.awt.Dimension(1338, 60));
        UpperPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogoutLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnLogoutLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnLogoutLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout.png"))); // NOI18N
        btnLogoutLabel.setText("Logout");
        btnLogoutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLogoutLabelMousePressed(evt);
            }
        });
        UpperPanel.add(btnLogoutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 0, 90, 60));

        greetingUserLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        UpperPanel.add(greetingUserLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 690, 60));

        back.setText("back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        UpperPanel.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 20, 50, 30));

        getContentPane().add(UpperPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setForeground(new java.awt.Color(31, 50, 97));
        container.setPreferredSize(new java.awt.Dimension(1338, 840));
        container.setLayout(new java.awt.CardLayout());
        getContentPane().add(container, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 61, 1338, 1048));

        loginJPanel.setBackground(new java.awt.Color(255, 255, 255));
        loginJPanel.setPreferredSize(new java.awt.Dimension(1338, 900));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(554, 840));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cc.jpeg"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(600, 840));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 554, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 900, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(236, 113, 107)));
        jPanel3.setPreferredSize(new java.awt.Dimension(302, 34));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user (6).png"))); // NOI18N

        userNameJTextField.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        userNameJTextField.setToolTipText("");
        userNameJTextField.setBorder(null);
        userNameJTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        userNameJTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        userNameJTextField.setDisabledTextColor(new java.awt.Color(16, 10, 55));
        userNameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameJTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userNameJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(userNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(236, 113, 107)));
        jPanel4.setPreferredSize(new java.awt.Dimension(302, 34));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/house-key (1).png"))); // NOI18N

        passwordField.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        passwordField.setBorder(null);
        passwordField.setCaretColor(new java.awt.Color(255, 255, 255));
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(passwordField)
        );

        loginButton.setBackground(new java.awt.Color(255, 255, 255));
        loginButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        loginButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginButton.setText("LOGIN");
        loginButton.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(236, 113, 107)));
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginButtonMousePressed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(255, 255, 255));
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancel.png"))); // NOI18N
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cancelButtonMousePressed(evt);
            }
        });

        btnDonate.setBackground(new java.awt.Color(255, 255, 255));
        btnDonate.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnDonate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDonate.setText("Adopt");
        btnDonate.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(236, 113, 107)));
        btnDonate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDonateMousePressed(evt);
            }
        });

        btnRegisterForAdoption.setBackground(new java.awt.Color(255, 255, 255));
        btnRegisterForAdoption.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnRegisterForAdoption.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegisterForAdoption.setText("Donate");
        btnRegisterForAdoption.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(236, 113, 107)));
        btnRegisterForAdoption.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRegisterForAdoptionMousePressed(evt);
            }
        });

        javax.swing.GroupLayout loginJPanelLayout = new javax.swing.GroupLayout(loginJPanel);
        loginJPanel.setLayout(loginJPanelLayout);
        loginJPanelLayout.setHorizontalGroup(
            loginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginJPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(loginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginJPanelLayout.createSequentialGroup()
                        .addGap(746, 746, 746)
                        .addComponent(cancelButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginJPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(loginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDonate, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegisterForAdoption, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(227, 227, 227))))
        );
        loginJPanelLayout.setVerticalGroup(
            loginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(loginJPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(333, 333, 333)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnRegisterForAdoption, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnDonate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(loginJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutLabelMousePressed
        logout();
    }//GEN-LAST:event_btnLogoutLabelMousePressed

    private void userNameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameJTextFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void loginButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMousePressed
        // TODO add your handling code here:
        String userName = userNameJTextField.getText();
        char[] passwordCharArray = passwordField.getPassword();
        String password = String.valueOf(passwordCharArray);

        userAccount = system.getUserAccountDirectory().authenticateUser(userName, password);
        inEnterprise = null;
        inOrganization = null;
        networkEmergency = null;

        if (userAccount == null) {
            for (Network network : system.getNetworkList()) {
                //Step 2.a: check against each enterprise
                System.out.println("Network name --->> " + network.getName());
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    System.out.println("Enterprise name --->> " + enterprise.getName());
                    userAccount = enterprise.getUserAccountDirectory().authenticateUser(userName, password);
                    networkEmergency = network;
                    if (userAccount == null) {
                        //Step 3:check against each organization for each enterprise
                        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            userAccount = organization.getUserAccountDirectory().authenticateUser(userName, password);
                            if (userAccount != null) {
                                inEnterprise = enterprise;
                                inOrganization = organization;
                                networkEmergency = network;
                                break;
                            }
                        }

                    } else {
                        inEnterprise = enterprise;
                        break;
                    }
                    if (inOrganization != null) {
                        break;
                    }
                }
                if (inEnterprise != null) {
                    break;
                }
                /*if (networkEmergency != null) {//changed
                    break;
                }*/
            }
        }
        if (userAccount == null) {
            JOptionPane.showMessageDialog(null, "Invalid credentials");
            return;
        } else {
            loginJPanel.setVisible(false);
            container.setVisible(true);
            UpperPanel.setVisible(true);
            btnLogoutLabel.setVisible(true);
            //btnBackLabel.setVisible(false);
            userNameJTextField.setText("");
            passwordField.setText("");
            changePanel1();
        }

    }//GEN-LAST:event_loginButtonMousePressed

    private void cancelButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_cancelButtonMousePressed

    private void btnDonateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDonateMousePressed
        // TODO add your handling code here:
//        System.out.println("CLICKED");
//        if(container.equals(null)){
//            System.out.println("container is null");
//        }else{
//            System.out.println("CLICKED2");
//        RegisterUserJPanel panel = new RegisterUserJPanel(container, system);
//        container.add("RegisterUserJPanel", panel);
//        CardLayout layout = (CardLayout) container.getLayout();
//        layout.next(container);
//        }

     // TODO add your handling code here:
        AdopterRegistrationJPanel panel = new AdopterRegistrationJPanel(container, system);
        greetingUserLabel.setText( "WELCOME NEW VOLUNTEER ORGANIZATION REGISTRATION!!!");
        //emoRR panel = new demoRR(container, system);
        //container.add("UserRegistrationJPanel", panel);
            loginJPanel.setVisible(false);
            container.setVisible(true);
            UpperPanel.setVisible(true);
            btnLogoutLabel.setVisible(false);
            //btnBackLabel.setVisible(true);
            userNameJTextField.setText("");
            passwordField.setText("");
        //cc();
        //SystemAdminRole r = new SystemAdminRole();
        container.add("workArea", panel);
        CardLayout layout = (CardLayout) container.getLayout();
            layout.next(container);
            
    }//GEN-LAST:event_btnDonateMousePressed

    private void btnRegisterForAdoptionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterForAdoptionMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegisterForAdoptionMousePressed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        logout();
    }//GEN-LAST:event_backActionPerformed

    private void logout() {
        container.removeAll();
        dB4OUtil.storeSystem(system);
        loginJPanel.setVisible(true);
        container.setVisible(false);
        UpperPanel.setVisible(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel UpperPanel;
    private javax.swing.JButton back;
    private javax.swing.JLabel btnDonate;
    private javax.swing.JLabel btnLogoutLabel;
    private javax.swing.JLabel btnRegisterForAdoption;
    private javax.swing.JLabel cancelButton;
    private javax.swing.JPanel container;
    private javax.swing.JLabel greetingUserLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel loginButton;
    private javax.swing.JPanel loginJPanel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField userNameJTextField;
    // End of variables declaration//GEN-END:variables

}
