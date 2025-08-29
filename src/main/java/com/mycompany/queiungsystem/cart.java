
package com.mycompany.queiungsystem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class cart extends javax.swing.JFrame {

    
    public cart() {
        initComponents();
        setSize(400, 800);
        setLocation(10, 12);
        StringBuilder sb = new StringBuilder();
        for (String order : OrderData.orders) {
            sb.append(order).append("\n");
        }

        totalmenu.setText("Order Type: " + OrderData.orderType + "\n\n" 
                          + sb.toString() 
                          + "\nTOTAL: " + OrderData.getFormattedTotal());
        totalmenu.setEditable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        back = new javax.swing.JButton();
        proceed = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        totalmenu = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 70));

        back.setBorder(null);
        back.setContentAreaFilled(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 710, 350, 40));

        proceed.setBorder(null);
        proceed.setContentAreaFilled(false);
        proceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedActionPerformed(evt);
            }
        });
        getContentPane().add(proceed, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 350, 50));

        totalmenu.setEditable(false);
        totalmenu.setColumns(20);
        totalmenu.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        totalmenu.setRows(5);
        totalmenu.setBorder(null);
        jScrollPane1.setViewportView(totalmenu);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 330, 410));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cart.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        menu wow = new menu ();
        wow.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
    int choice = javax.swing.JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to cancel your order?",
        "Confirm Cancel",
        javax.swing.JOptionPane.YES_NO_OPTION
    );

    if (choice == javax.swing.JOptionPane.YES_OPTION) {
    
        OrderData.resetOrder();


        JOptionPane.showMessageDialog(this, "Your order has been cancelled.");


        kiosk ah = new kiosk();
        ah.setVisible(true);
        this.dispose();

    } else if (choice == javax.swing.JOptionPane.NO_OPTION) {

        JOptionPane.showMessageDialog(this, "Your order has been resumed.");
    }

    }//GEN-LAST:event_backActionPerformed

    private void proceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedActionPerformed
        if (OrderData.orders.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Your cart is empty!");
            return;
        }

        int orderNumber = OrderData.saveOrder();
        
        testing t = new testing();
        t.loadSpecificOrderToTable(orderNumber);

        CustomersOrder queueWindow = new CustomersOrder(orderNumber);
        queueWindow.setLocation(10,12);
        queueWindow.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_proceedActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton proceed;
    private javax.swing.JTextArea totalmenu;
    // End of variables declaration//GEN-END:variables
}
