
package com.mycompany.queiungsystem;

import java.util.*;
import javax.swing.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class reg extends javax.swing.JFrame {
    
    public reg() {
        initComponents();
        setResizable(false);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

addWindowListener(new java.awt.event.WindowAdapter() {
    public void windowClosing(java.awt.event.WindowEvent e) {
        int confirmed = JOptionPane.showConfirmDialog(
            null,
            "Are you sure you want to exit?",
            "Logout Confirmation",
            JOptionPane.YES_NO_OPTION
        );

        if (confirmed == JOptionPane.YES_OPTION) {
            new logque().setVisible(true);
            dispose();
        }
    }
});

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reguser = new javax.swing.JTextField();
        regpass = new javax.swing.JPasswordField();
        regcon = new javax.swing.JPasswordField();
        regissave = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(407, 12));
        setMaximumSize(new java.awt.Dimension(1119, 799));
        setMinimumSize(new java.awt.Dimension(1119, 799));
        setPreferredSize(new java.awt.Dimension(1119, 799));
        setResizable(false);
        setSize(new java.awt.Dimension(1119, 799));
        getContentPane().setLayout(null);

        reguser.setBorder(null);
        reguser.setOpaque(false);
        reguser.setBackground(new java.awt.Color(0,0,0,0));
        getContentPane().add(reguser);
        reguser.setBounds(490, 420, 360, 40);

        regpass.setBorder(null);
        regpass.setOpaque(false);
        regpass.setBackground(new java.awt.Color(0,0,0,0));
        regpass.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || regpass.getPassword().length >= 6) {
                    e.consume();
                }
            }
        });
        getContentPane().add(regpass);
        regpass.setBounds(490, 470, 360, 30);

        regcon.setBorder(null);
        regcon.setOpaque(false);
        regcon.setBackground(new java.awt.Color(0,0,0,0));
        regcon.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || regcon.getPassword().length >= 6) {
                    e.consume();
                }
            }
        });
        getContentPane().add(regcon);
        regcon.setBounds(580, 510, 350, 40);

        regissave.setOpaque(false);
        regissave.setContentAreaFilled(false);
        regissave.setBorderPainted(false);
        regissave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regissaveActionPerformed(evt);
            }
        });
        getContentPane().add(regissave);
        regissave.setBounds(320, 560, 90, 40);

        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(740, 560, 110, 40);

        jButton1.setOpaque(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(520, 560, 130, 40);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tempreg.png"))); // NOI18N
        jLabel5.setMaximumSize(new java.awt.Dimension(1119, 799));
        jLabel5.setMinimumSize(new java.awt.Dimension(1119, 799));
        jLabel5.setPreferredSize(new java.awt.Dimension(1119, 799));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 1119, 799);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regissaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regissaveActionPerformed
        String username = reguser.getText().trim();
        String strpass = new String(regpass.getPassword()).trim();
        String strconfirm = new String(regcon.getPassword()).trim();

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Type username");
            return;
        }

        if (!strpass.equals(strconfirm)) {
            JOptionPane.showMessageDialog(null, "Passwords do not match");
            regpass.setText("");
            regcon.setText("");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2 && parts[1].trim().equals(username)) {
                    JOptionPane.showMessageDialog(null, "Username already exists. Choose another one.");
                    return;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading accounts.txt");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("accounts.txt", true))) {
            writer.write(username + "," + username + "," + strpass);
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing to accounts.txt");
            e.printStackTrace();
            return;
        }

        JOptionPane.showMessageDialog(null, "Registration Successful");

        new logque().setVisible(true);
        dispose();
    }//GEN-LAST:event_regissaveActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        new logque().setVisible(true);
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    reguser.setText("");
    regpass.setText("");
    regcon.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField regcon;
    private javax.swing.JButton regissave;
    private javax.swing.JPasswordField regpass;
    private javax.swing.JTextField reguser;
    // End of variables declaration//GEN-END:variables
}
