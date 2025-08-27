
package com.mycompany.queiungsystem;

import java.util.List;
public class CustomersOrder extends javax.swing.JFrame {

    private int orderNumber;
    public CustomersOrder(int orderNumber) {
        initComponents();
        this.orderNumber = orderNumber;


        number.setText(String.format("%03d", orderNumber));


        List<String> orders = OrderData.getOrderByNumber(orderNumber);
        double total = OrderData.getTotalByNumber(orderNumber);

        if (orders != null && !orders.isEmpty()) {
            System.out.println("Orders for " + orderNumber + ": " + orders);
            System.out.println("Total: " + total);
        }
    }
    public CustomersOrder() {
        initComponents();
        number.setText("No Order");
    }


  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JButton();
        number = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setBorder(null);
        back.setContentAreaFilled(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 390, 120));

        number.setEditable(false);
        number.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 36)); // NOI18N
        number.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        number.setBorder(null);
        number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberActionPerformed(evt);
            }
        });
        getContentPane().add(number, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 170, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/your order.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        OrderData.orders.clear();
        OrderData.total = 0.0;
        OrderData.orderType = "";

        new logque().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberActionPerformed
    
    }//GEN-LAST:event_numberActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomersOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField number;
    // End of variables declaration//GEN-END:variables
}
