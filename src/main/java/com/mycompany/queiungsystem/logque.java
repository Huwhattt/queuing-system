
package com.mycompany.queiungsystem;

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class logque extends javax.swing.JFrame {
    private List<String> usernames = new ArrayList<>();
    private List<String> passwords = new ArrayList<>();
    
    public logque() {
        setResizable(false);              
        setSize(1920, 1080);               
        setLocationRelativeTo(null); 
        loadAccountsFromFile();
        initComponents();
    }

   private void loadAccountsFromFile() {
        File file = new File("accounts.txt");

       
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Failed to create accounts.txt");
                return;
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String user = parts[1].trim();  
                    String pass = parts[2].trim();  
                    usernames.add(user);
                    passwords.add(pass);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading accounts.txt");
            e.printStackTrace();
        }
    }

    public void setnewuser(String newuser) {
        usernames.add(newuser);
    }

    public void setnupass(String newpass) {
        passwords.add(newpass);
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pfield = new javax.swing.JPasswordField();
        inuser = new javax.swing.JTextField();
        reg = new javax.swing.JButton();
        login = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1200, 800));
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setPreferredSize(new java.awt.Dimension(1200, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 800));
        getContentPane().setLayout(null);

        pfield.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || pfield.getPassword().length >= 6) {
                    e.consume();
                }
            }
        });
        pfield.setBorder(null);
        pfield.setOpaque(false);
        pfield.setBackground(new java.awt.Color(0,0,0,0));
        pfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfieldActionPerformed(evt);
            }
        });
        getContentPane().add(pfield);
        pfield.setBounds(490, 470, 350, 30);

        inuser.setBorder(null);
        inuser.setOpaque(false);
        inuser.setBackground(new java.awt.Color(0,0,0,0));
        inuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inuserActionPerformed(evt);
            }
        });
        getContentPane().add(inuser);
        inuser.setBounds(490, 430, 350, 30);

        reg.setOpaque(false);
        reg.setContentAreaFilled(false);
        reg.setBorderPainted(false);
        reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regActionPerformed(evt);
            }
        });
        getContentPane().add(reg);
        reg.setBounds(650, 530, 180, 40);

        login.setOpaque(false);
        login.setContentAreaFilled(false);
        login.setBorderPainted(false);
        login.setMaximumSize(new java.awt.Dimension(1200, 628));
        login.setMinimumSize(new java.awt.Dimension(1200, 628));
        login.setPreferredSize(new java.awt.Dimension(1200, 628));
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login);
        login.setBounds(290, 530, 130, 40);

        clear.setOpaque(false);
        clear.setContentAreaFilled(false);
        clear.setBorderPainted(false);
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        getContentPane().add(clear);
        clear.setBounds(470, 530, 130, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(1200, 800));
        jLabel1.setMinimumSize(new java.awt.Dimension(1200, 800));
        jLabel1.setPreferredSize(new java.awt.Dimension(1200, 800));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1120, 800);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void inuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inuserActionPerformed

    }//GEN-LAST:event_inuserActionPerformed

    private void pfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfieldActionPerformed
        
    }//GEN-LAST:event_pfieldActionPerformed

    private void regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regActionPerformed
        
    }//GEN-LAST:event_regActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed

         String enteredUser = inuser.getText().trim();
        String enteredPass = new String(pfield.getPassword()).trim();

        for (int i = 0; i < usernames.size(); i++) {
            if (enteredUser.equals(usernames.get(i)) && enteredPass.equals(passwords.get(i))) {
                JOptionPane.showMessageDialog(this, "Access Granted");
                kiosk nice = new kiosk ();
                nice.setVisible(true);
                dispose();
                return;
            }
        }

      
        JOptionPane.showMessageDialog(this, "Access Denied\nInvalid Username or Password");
        inuser.setText("");
        pfield.setText("");
    
    }//GEN-LAST:event_loginActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
    inuser.setText("");
    pfield.setText("");
    }//GEN-LAST:event_clearActionPerformed


    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new logque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear;
    public javax.swing.JTextField inuser;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JButton login;
    private javax.swing.JPasswordField pfield;
    public javax.swing.JButton reg;
    // End of variables declaration//GEN-END:variables
}
