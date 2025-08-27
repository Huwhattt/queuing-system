/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.queiungsystem;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
public class testing extends javax.swing.JFrame {

    /**
     * Creates new form testing
     */
    public testing() {
        initComponents();
        clearTable();
        setLocation(407,12);
        setSize(720,400);
        
        totalprice2.setText("00.00");
        payment2.setText("");
        sukli2.setText("");
    }
    
    private void clearTable() {
        // Create empty table model with additional columns
        DefaultTableModel model = new DefaultTableModel(
            new Object[][]{}, 
            new String[]{"Order Number", "Item", "Quantity", "Price", "Subtotal", "Order Type", "Total Amount"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable1.setModel(model);
    }
    
    private void loadSpecificOrderToTable(int orderNumber) {
        // Check if order exists
        if (!OrderData.getAllOrderNumbers().contains(orderNumber)) {
            JOptionPane.showMessageDialog(this, 
                "Order number " + orderNumber + " not found!", 
                "Order Not Found", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Create table model with detailed columns
        DefaultTableModel model = new DefaultTableModel(
            new Object[][]{}, 
            new String[]{"Order Number", "Item", "Quantity", "Price", "Subtotal", "Order Type", "Total Amount"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        jTable1.setModel(model);
        
        // Load specific order data
        List<String> orderItems = OrderData.getOrderByNumber(orderNumber);
        Double total = OrderData.getTotalByNumber(orderNumber);
        String type = OrderData.getOrderTypeByNumber(orderNumber);
        
        // Add order header row
        model.addRow(new Object[]{
            String.format("%03d", orderNumber),
            "ORDER ITEMS:", "", "", "", type, ""
        });
        
        // Parse and add each item with quantity details
        for (String item : orderItems) {
            // Parse the order string (format: "Meal xQty - ₱Price")
            try {
                String[] parts = item.split(" x");
                String mealName = parts[0];
                
                String[] rest = parts[1].split(" - ₱");
                int quantity = Integer.parseInt(rest[0]);
                double subtotal = Double.parseDouble(rest[1]);
                double unitPrice = subtotal / quantity;
                
                // Add item row with quantity details
                model.addRow(new Object[]{
                    "", // Empty order number for item rows
                    mealName,
                    quantity,
                    "₱" + String.format("%.2f", unitPrice),
                    "₱" + String.format("%.2f", subtotal),
                    "", // Empty order type for item rows
                    ""  // Empty total for item rows
                });
                
            } catch (Exception e) {
                // If parsing fails, just add the raw string
                model.addRow(new Object[]{
                    "",
                    item,
                    "N/A",
                    "N/A",
                    "N/A",
                    "",
                    ""
                });
            }
        }
        
        // Add total row
        model.addRow(new Object[]{
            "",
            "TOTAL:",
            "",
            "",
            "",
            "",
            "₱" + String.format("%.2f", total)
        });
        
        int lastRow = model.getRowCount() - 1;
Object totalValue = model.getValueAt(lastRow, 6); // column 6 = "Total Amount"

if (totalValue != null) {
    totalprice2.setText(totalValue.toString()); // set text directly
}
        
        // Auto-resize columns to fit content
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
    
        private void searchForOrder() {
        try {
            String input = jTextField1.getText().trim();
            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Please enter an order number!", 
                    "Input Required", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            int orderNumber = Integer.parseInt(input);
            loadSpecificOrderToTable(orderNumber);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Please enter a valid number!", 
                "Invalid Input", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
        
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        pay = new javax.swing.JButton();
        totalprice2 = new javax.swing.JLabel();
        payment2 = new javax.swing.JTextField();
        sukli2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 70, 380, 180);

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(480, 130, 130, 30);

        search.setBorderPainted(false);
        search.setContentAreaFilled(false);
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search);
        search.setBounds(480, 190, 150, 50);

        pay.setBorderPainted(false);
        pay.setContentAreaFilled(false);
        pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payActionPerformed(evt);
            }
        });
        jPanel1.add(pay);
        pay.setBounds(270, 268, 125, 75);
        jPanel1.add(totalprice2);
        totalprice2.setBounds(130, 275, 110, 18);

        payment2.setBorder(null);
        jPanel1.add(payment2);
        payment2.setBounds(130, 298, 110, 18);
        jPanel1.add(sukli2);
        sukli2.setBounds(130, 320, 110, 18);

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(450, 280, 140, 50);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addtemp.png"))); // NOI18N
        jPanel1.add(background);
        background.setBounds(0, 0, 710, 360);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    searchForOrder();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
     searchForOrder();
    }//GEN-LAST:event_searchActionPerformed

    private void payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payActionPerformed
        try {
        // Get total from label (remove ₱ sign)
        String totalText = totalprice2.getText().replace("₱", "").trim();
        double total = Double.parseDouble(totalText);

        // Get payment from text field
        double payment = Double.parseDouble(payment2.getText().trim());

        if (payment < total) {
            JOptionPane.showMessageDialog(this,
                    "Insufficient Amount",
                    "Payment Error",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            double change = payment - total;
            
            // ✅ Display change in sukli2 label
            sukli2.setText("₱" + String.format("%.2f", change));

            JOptionPane.showMessageDialog(this,
                    "Payment Successful!",
                    "Transaction Complete",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
                "Please enter a valid payment amount!",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE);
    }


    }//GEN-LAST:event_payActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    resibo2 res = new resibo2();
    res.setVisible(true);
    res.sendToReceipt();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(testing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(testing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(testing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(testing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new testing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton pay;
    public javax.swing.JTextField payment2;
    private javax.swing.JButton search;
    public javax.swing.JLabel sukli2;
    public javax.swing.JLabel totalprice2;
    // End of variables declaration//GEN-END:variables
}
