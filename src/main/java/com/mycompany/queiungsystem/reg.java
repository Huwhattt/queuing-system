package com.mycompany.queiungsystem;

import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

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
    
    

  
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/queuingdb"; 
        String user = "root"; 
        String pass = "12341"; 
        return DriverManager.getConnection(url, user, pass);
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

        // Check password 6 digits
        if (strpass.length() != 6) {
            JOptionPane.showMessageDialog(null, "Password must be 6 digits");
            regpass.setText("");
            regcon.setText("");
            return;
        }

        if (!strpass.equals(strconfirm)) {
            JOptionPane.showMessageDialog(null, "Passwords do not match");
            regpass.setText("");
            regcon.setText("");
            return;
        }

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = getConnection();

            // Check username 
            String checkQuery = "SELECT * FROM accounts WHERE username = ?";
            pst = conn.prepareStatement(checkQuery);
            pst.setString(1, username);
            rs = pst.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Username already exists. Choose another one.");
                return;
            }

            // Insert new 
            String insertQuery = "INSERT INTO accounts (name, username, password) VALUES (?, ?, ?)";
            pst = conn.prepareStatement(insertQuery);
            pst.setString(1, username);
            pst.setString(2, username);
            pst.setString(3, strpass);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registration Successful");

            new logque().setVisible(true);
            dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }

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
