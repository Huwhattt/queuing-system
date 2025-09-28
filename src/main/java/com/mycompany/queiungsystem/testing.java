package com.mycompany.queiungsystem;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
public class testing extends javax.swing.JFrame {
    
    public boolean hasPaid = false;
    private int currentOrderNumber;
        
    public testing() {
        initComponents();
        clearTable();
        setLocation(407,12);
        setSize(720,390);
        setTitle("Cashier Screen");
        
        pay.setContentAreaFilled(false);
        pay.setBorderPainted(false);
        pay.setOpaque(false);
        
        totalprice2.setText("00.00");
        payment2.setText("");
        sukli2.setText("");
        
        print.setOpaque(false);
        print.setContentAreaFilled(false);
        print.setBorderPainted(false);
        
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
    @Override
    public void keyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();

        // Only allow digits 0–9
        if (!Character.isDigit(c)) {
            evt.consume(); // stop non-digit input
        }

        // Limit to 5 characters
        if (jTextField1.getText().length() >= 5) {
            evt.consume(); // block more typing
        }
    }
});
        
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
                    jTextField1.setText("");
            return;
        }

        // Create table model
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

        // Load order data
        List<String> orderItems = OrderData.getOrderByNumber(orderNumber);
        Double total = OrderData.getTotalByNumber(orderNumber);
        String type = OrderData.getOrderTypeByNumber(orderNumber);

        // Add one row per item
        for (String item : orderItems) {
            try {
                // Format: "Meal xQty - ₱Price"
                String[] parts = item.split(" x");
                String mealName = parts[0];

                String[] rest = parts[1].split(" - ₱");
                int quantity = Integer.parseInt(rest[0]);
                double subtotal = Double.parseDouble(rest[1]);
                double unitPrice = subtotal / quantity;

                model.addRow(new Object[]{
                    String.format("%03d", orderNumber),
                    mealName,
                    quantity,
                    "₱" + String.format("%.2f", unitPrice),
                    "₱" + String.format("%.2f", subtotal),
                    type,
                    "₱" + String.format("%.2f", total)
                });
            } catch (Exception e) {
                model.addRow(new Object[]{
                    String.format("%03d", orderNumber),
                    item,
                    "N/A",
                    "N/A",
                    "N/A",
                    type,
                    "₱" + String.format("%.2f", total)
                });
            }
        }

        // Set total to text field
        totalprice2.setText("₱" + String.format("%.2f", total));

        // Auto-resize table
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
    
        public void setOrderNumber(int orderNumber) {
        this.currentOrderNumber = orderNumber;
        System.out.println("testing frame received order number: " + currentOrderNumber);
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
        clear = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        bacground = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(710, 350));
        setMinimumSize(new java.awt.Dimension(710, 350));
        setPreferredSize(new java.awt.Dimension(710, 350));
        setSize(new java.awt.Dimension(710, 350));
        getContentPane().setLayout(null);

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

        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(484, 153, 130, 25);

        search.setBorderPainted(false);
        search.setContentAreaFilled(false);
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search);
        search.setBounds(480, 190, 150, 50);
        jPanel1.add(totalprice2);
        totalprice2.setBounds(130, 275, 110, 18);

        payment2.setBorder(null);
        payment2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment2ActionPerformed(evt);
            }
        });
        jPanel1.add(payment2);
        payment2.setBounds(130, 298, 110, 18);
        jPanel1.add(sukli2);
        sukli2.setBounds(130, 320, 110, 18);

        pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payActionPerformed(evt);
            }
        });
        jPanel1.add(pay);
        pay.setBounds(270, 270, 124, 35);

        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel1.add(print);
        print.setBounds(270, 310, 124, 40);

        clear.setBorderPainted(false);
        clear.setContentAreaFilled(false);
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel1.add(clear);
        clear.setBounds(616, 160, 10, 10);

        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(220, 0, 190, 50);

        bacground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addorder.png"))); // NOI18N
        bacground.setMaximumSize(new java.awt.Dimension(710, 350));
        bacground.setMinimumSize(new java.awt.Dimension(710, 350));
        bacground.setPreferredSize(new java.awt.Dimension(710, 350));
        jPanel1.add(bacground);
        bacground.setBounds(0, 0, 710, 360);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 790, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    searchForOrder();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
    if (hasPaid) {
        JOptionPane.showMessageDialog(this, "You need to Finish a Transaction");
        return;
    } 
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

    resibo2 receipt = new resibo2();

    receipt.loadReceiptData(model, total, payment, change, orderType);

    receipt.setVisible(true);
    this.dispose();
    clearTable();
    hasPaid = false;
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
            payment2.setText("");
            
        } else {
            double change = payment - total;

            sukli2.setText("₱" + String.format("%.2f", change));
            hasPaid=true;
            JOptionPane.showMessageDialog(this,
                    "Payment Successful!",
                    "Transaction Complete",
                    JOptionPane.INFORMATION_MESSAGE);

            int savedOrderNumber = OrderData.lastSavedOrderNumber;

            if (KFrame.yey != null) {
                KFrame.yey.displayOrderNumber(savedOrderNumber);
            }
            
            if (KFrame.woah != null) {
            KFrame.woah.setOrderNumber(String.format("%03d", savedOrderNumber));
            }
            
            if (KFrame.panis != null) {
                int slot = KFrame.panis.showOrderNumber(String.format("%03d", savedOrderNumber));

                if (slot != -1) {
                    KFrame.panis.setOrderStatus(slot, "Preparing");
                    KFrame.panis.showTime(slot);
                }
            }
            
        }
        
    } catch (NumberFormatException e) {
        hasPaid=false;
        JOptionPane.showMessageDialog(this,
                "Please enter a valid payment amount!",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_payActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
      jTextField1.setText("");
    }//GEN-LAST:event_clearActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        history his = new history();
        his.setVisible(true);
        this.dispose();
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
    private javax.swing.JLabel bacground;
    private javax.swing.JButton clear;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
