package com.mycompany.queiungsystem;

import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class kitchen extends javax.swing.JFrame {
    
    private int nextInsertIndex = 0;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(kitchen.class.getName());

    /**
     * Creates new form kitchen
     */

    private JTextArea[] kitchenOrders;
    
    public kitchen() {
        initComponents();
        
        setSize(720,400);
        setLocation(407, 413); 
        setTitle("Kitchen Screen");
        
        kitchenOrders = new JTextArea[]{order1, order2, order3, order4, order5, order6};        
        
        order1.setEditable(false);
        order2.setEditable(false);
        order3.setEditable(false);
        order4.setEditable(false);
        order5.setEditable(false);
        order6.setEditable(false);
        
        for (JTextArea area : kitchenOrders) {
            area.setOpaque(true);
            area.setBorder(null);
            area.setBackground(Color.WHITE);
            area.setEditable(false);
            area.setLineWrap(true);
            area.setWrapStyleWord(true);
        }
        
        ready1.setContentAreaFilled(false);
        ready1.setBorderPainted(false);
        ready1.setOpaque(false);
        
        ready2.setContentAreaFilled(false);
        ready2.setBorderPainted(false);
        ready2.setOpaque(false);
        
        ready3.setContentAreaFilled(false);
        ready3.setBorderPainted(false);
        ready3.setOpaque(false);
        
        ready4.setContentAreaFilled(false);
        ready4.setBorderPainted(false);
        ready4.setOpaque(false);
        
        ready5.setContentAreaFilled(false);
        ready5.setBorderPainted(false);
        ready5.setOpaque(false);
        
        ready6.setContentAreaFilled(false);
        ready6.setBorderPainted(false);
        ready6.setOpaque(false);
        
    }    
    
     public void displayOrderNumber(int orderNumber) {

        if (KFrame.panis == null) {

            return;

        }
 
        List<String> orderItems = OrderData.getOrderByNumber(orderNumber);

        if (orderItems == null || orderItems.isEmpty()) {

            return;

        }
 
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%03d", orderNumber)).append("\n");
 
        for (String item : orderItems) {

            try {

                String[] parts = item.split(" x");

                String mealName = parts[0];
 
                String[] rest = parts[1].split(" - ₱");

                int quantity = Integer.parseInt(rest[0]);
 
                sb.append(mealName).append(" x").append(quantity).append("\n");

            } catch (Exception e) {

                sb.append(item).append("\n");

            }

        }

        int insertIndex = -1;

        for (int i = nextInsertIndex; i < kitchenOrders.length; i++) {

            if (kitchenOrders[i].getText().trim().isEmpty()) {

                insertIndex = i;

                break;

            }

        }

        if (insertIndex != -1) {

            kitchenOrders[insertIndex].setText(sb.toString().trim());

            nextInsertIndex = insertIndex + 1;

        } else {

            JOptionPane.showMessageDialog(null,

                    "No space available in the kitchen queue.",

                    "Queue Full",

                    JOptionPane.WARNING_MESSAGE);

        }

    }
     

    public void markOrderAsReady(String orderNum) {
        if (orderNum == null || orderNum.trim().isEmpty()) {
            return;
        }

        orderNum = orderNum.trim();

        int correctIndex = -1;

        if (KFrame.panis != null) {
            JTextField[] qnoFields = KFrame.panis.getQnoFields();

            System.out.println("Looking for orderNum: '" + orderNum + "'");

            for (int i = 0; i < qnoFields.length; i++) {
                String qnoText = qnoFields[i].getText().trim();
                System.out.println("Checking index " + i + " with qno: '" + qnoText + "'");
                try {
                    if (!qnoText.isEmpty()) {
                        int orderNumInt = Integer.parseInt(orderNum);
                        int qnoInt = Integer.parseInt(qnoText);
                        if (orderNumInt == qnoInt) {
                            correctIndex = i;
                            break;
                        }
                    }
                } catch (NumberFormatException e) {
                    if (orderNum.equals(qnoText)) {
                        correctIndex = i;
                        break;
                    }
                }
            }
        }

        if (correctIndex != -1) {
            if (KFrame.woah != null) {
                KFrame.woah.setOrderReady(orderNum);
            }

            if (KFrame.panis != null) {
                JTextField[] statFields = KFrame.panis.getStatFields();

                if (correctIndex < statFields.length) {
                    statFields[correctIndex].setText("Ready");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Order not found in counter. It may have been completed or moved.",
                    "Order Missing",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

     public void markOrderReady(int index, JTextArea orderArea) {

        String orderText = kitchenOrders[index].getText();
 
        if (orderText != null && !orderText.trim().isEmpty()) {

            String[] lines = orderText.split("\n");

            if (lines.length > 0) {

                String orderNum = lines[0].trim();

                System.out.println("Looking for orderNum: '" + orderNum + "'");
 
                markOrderAsReady(orderNum);
 
                kitchenOrders[index].setText("");

            } else {

                JOptionPane.showMessageDialog(null, "Invalid order format.");

            }

        } else {

            JOptionPane.showMessageDialog(null, "No order found to mark ready.");

        }

    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ready1 = new javax.swing.JButton();
        ready2 = new javax.swing.JButton();
        ready3 = new javax.swing.JButton();
        ready4 = new javax.swing.JButton();
        ready5 = new javax.swing.JButton();
        ready6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        order1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        order2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        order3 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        order4 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        order5 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        order6 = new javax.swing.JTextArea();
        inventory = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(710, 363));
        setMinimumSize(new java.awt.Dimension(710, 363));
        setPreferredSize(new java.awt.Dimension(710, 363));
        getContentPane().setLayout(null);

        ready1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ready1ActionPerformed(evt);
            }
        });
        getContentPane().add(ready1);
        ready1.setBounds(50, 153, 160, 30);

        ready2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ready2ActionPerformed(evt);
            }
        });
        getContentPane().add(ready2);
        ready2.setBounds(270, 153, 170, 30);

        ready3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ready3ActionPerformed(evt);
            }
        });
        getContentPane().add(ready3);
        ready3.setBounds(500, 153, 160, 30);

        ready4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ready4ActionPerformed(evt);
            }
        });
        getContentPane().add(ready4);
        ready4.setBounds(50, 310, 160, 30);

        ready5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ready5ActionPerformed(evt);
            }
        });
        getContentPane().add(ready5);
        ready5.setBounds(270, 310, 170, 30);

        ready6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ready6ActionPerformed(evt);
            }
        });
        getContentPane().add(ready6);
        ready6.setBounds(500, 310, 160, 30);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        order1.setColumns(20);
        order1.setRows(5);
        jScrollPane1.setViewportView(order1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 70, 180, 80);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        order2.setColumns(20);
        order2.setRows(5);
        jScrollPane2.setViewportView(order2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(264, 70, 180, 80);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        order3.setColumns(20);
        order3.setRows(5);
        jScrollPane3.setViewportView(order3);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(490, 70, 180, 80);

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        order4.setColumns(20);
        order4.setRows(5);
        jScrollPane4.setViewportView(order4);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(40, 220, 180, 86);

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        order5.setColumns(20);
        order5.setRows(5);
        jScrollPane5.setViewportView(order5);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(264, 220, 180, 86);

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        order6.setColumns(20);
        order6.setRows(5);
        jScrollPane6.setViewportView(order6);

        getContentPane().add(jScrollPane6);
        jScrollPane6.setBounds(490, 220, 180, 86);

        inventory.setBorder(null);
        inventory.setBorderPainted(false);
        inventory.setContentAreaFilled(false);
        inventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryActionPerformed(evt);
            }
        });
        getContentPane().add(inventory);
        inventory.setBounds(230, 0, 190, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Darex\\Downloads\\kitchen.png")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 710, 363);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ready1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ready1ActionPerformed
        markOrderReady(0, kitchenOrders[0]); 
    }//GEN-LAST:event_ready1ActionPerformed

    private void ready2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ready2ActionPerformed
        markOrderReady(1, kitchenOrders[1]);
    }//GEN-LAST:event_ready2ActionPerformed

    private void ready3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ready3ActionPerformed
        markOrderReady(2, kitchenOrders[2]);
    }//GEN-LAST:event_ready3ActionPerformed

    private void ready4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ready4ActionPerformed
        markOrderReady(3, kitchenOrders[3]);
    }//GEN-LAST:event_ready4ActionPerformed

    private void ready5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ready5ActionPerformed
        markOrderReady(4, kitchenOrders[4]);
    }//GEN-LAST:event_ready5ActionPerformed

    private void ready6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ready6ActionPerformed
        markOrderReady(5, kitchenOrders[5]);
    }//GEN-LAST:event_ready6ActionPerformed

    private void inventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryActionPerformed
        inventory wah = new inventory();
        wah.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_inventoryActionPerformed

  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new kitchen().setVisible(true));
        java.awt.EventQueue.invokeLater(() -> new status2().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton inventory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea order1;
    private javax.swing.JTextArea order2;
    private javax.swing.JTextArea order3;
    private javax.swing.JTextArea order4;
    private javax.swing.JTextArea order5;
    private javax.swing.JTextArea order6;
    private javax.swing.JButton ready1;
    private javax.swing.JButton ready2;
    private javax.swing.JButton ready3;
    private javax.swing.JButton ready4;
    private javax.swing.JButton ready5;
    private javax.swing.JButton ready6;
    // End of variables declaration//GEN-END:variables
}
