package com.mycompany.queiungsystem;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
public class testing extends javax.swing.JFrame {
    
 public boolean hasPaid = false;
    
    public testing() {
        initComponents();
        clearTable();
        setLocation(407,12);
        setSize(720,400);
        
        totalprice2.setText("00.00");
        payment2.setText("");
        sukli2.setText("");
        
        print.setOpaque(false);
        print.setContentAreaFilled(false);
        print.setBorderPainted(false);
        
    }
    
    public void clearTable() {
        jTextField1.setText("");
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
    
    public void loadSpecificOrderToTable(int orderNumber) {
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
        totalprice2 = new javax.swing.JLabel();
        payment2 = new javax.swing.JTextField();
        sukli2 = new javax.swing.JLabel();
        pay = new javax.swing.JButton();
        print = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        search.setBorderPainted(false);
        search.setContentAreaFilled(false);
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        payment2.setBorder(null);
        payment2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment2ActionPerformed(evt);
            }
        });

        pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payActionPerformed(evt);
            }
        });

        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sukli2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(payment2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(totalprice2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(print, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pay, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(480, 480, 480)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(payment2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(totalprice2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(sukli2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    searchForOrder();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
     searchForOrder();
    }//GEN-LAST:event_searchActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
      if (!hasPaid) {
        JOptionPane.showMessageDialog(this, "You need to make a Transaction");
        return;
    } 
      
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

    if (model.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "No data to print.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String total = totalprice2.getText();
    String payment = payment2.getText();
    String change = sukli2.getText();
    String orderType = model.getValueAt(0, 5).toString();

    // ✅ Create the resibo2 frame using the default constructor
    resibo2 receipt = new resibo2();

    // ✅ Send the data using your new method
    receipt.loadReceiptData(model, total, payment, change, orderType);

    // ✅ Show the receipt window
    receipt.setVisible(true);
    
    clearTable();
    }//GEN-LAST:event_printActionPerformed

    private void payment2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payment2ActionPerformed

    private void payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payActionPerformed
        try {
        String totalText = totalprice2.getText().replace("₱", "").trim();
        double total = Double.parseDouble(totalText);

        double payment = Double.parseDouble(payment2.getText().trim());
        payment2.setText("₱" + String.format("%.2f", payment));
        if (payment < total) {
            hasPaid=false;
            JOptionPane.showMessageDialog(this,
                    "Insufficient Amount",
                    "Payment Error",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            double change = payment - total;

            sukli2.setText("₱" + String.format("%.2f", change));
            hasPaid=true;
            JOptionPane.showMessageDialog(this,
                    "Payment Successful!",
                    "Transaction Complete",
                    JOptionPane.INFORMATION_MESSAGE);
            
            
        }
    } catch (NumberFormatException e) {
        hasPaid=false;
        JOptionPane.showMessageDialog(this,
                "Please enter a valid payment amount!",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_payActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton pay;
    public javax.swing.JTextField payment2;
    private javax.swing.JButton print;
    private javax.swing.JButton search;
    public javax.swing.JLabel sukli2;
    public javax.swing.JLabel totalprice2;
    // End of variables declaration//GEN-END:variables
}
