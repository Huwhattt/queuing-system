 
package com.mycompany.queiungsystem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class menu extends javax.swing.JFrame {
int[] prices = {120, 100, 150, 200, 130, 180}; 
    String[] meals = {
        "The Byte Meal", 
        "The Snack Stack", 
        "Flamin' Firewall",
        "Cheat Code", 
        "Krazy Kernel", 
        "The Full Stack Meal"
    };

    int selectedMealIndex = -1;

    public menu() {
        initComponents();
        setSize(400, 800);
        setLocation(10, 12);
        quantity.setText("1");
    }

    private void updateTotal() {
        if (selectedMealIndex != -1) {
            int qty = Integer.parseInt(quantity.getText());
            int mealPrice = prices[selectedMealIndex] * qty;
            mealtotal.setText(" " + mealPrice);
        }
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkout = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        mealtotal = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        subtract = new javax.swing.JButton();
        quantity = new javax.swing.JTextField();
        addorder = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        checkout.setBorder(null);
        checkout.setContentAreaFilled(false);
        checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutActionPerformed(evt);
            }
        });
        getContentPane().add(checkout, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 0, 195, 65));

        cancel.setBorder(null);
        cancel.setContentAreaFilled(false);
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 717, 167, 32));

        mealtotal.setEditable(false);
        mealtotal.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        mealtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mealtotalActionPerformed(evt);
            }
        });
        getContentPane().add(mealtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 660, 70, 40));

        add.setBorder(null);
        add.setContentAreaFilled(false);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 667, 27, 25));

        subtract.setBorder(null);
        subtract.setContentAreaFilled(false);
        subtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subtractActionPerformed(evt);
            }
        });
        getContentPane().add(subtract, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 667, 27, 25));

        quantity.setEditable(false);
        quantity.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        quantity.setBorder(null);
        quantity.setOpaque(true);
        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });
        getContentPane().add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 669, 24, 20));

        addorder.setBorder(null);
        addorder.setContentAreaFilled(false);
        addorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addorderActionPerformed(evt);
            }
        });
        getContentPane().add(addorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 720, 170, 30));

        b1.setBorder(null);
        b1.setContentAreaFilled(false);
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        getContentPane().add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 160, 90));

        b2.setBorder(null);
        b2.setContentAreaFilled(false);
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        getContentPane().add(b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 170, 100));

        b3.setBorder(null);
        b3.setContentAreaFilled(false);
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        getContentPane().add(b3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 160, 90));

        b4.setBorder(null);
        b4.setContentAreaFilled(false);
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });
        getContentPane().add(b4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 170, 90));

        b5.setBorder(null);
        b5.setContentAreaFilled(false);
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });
        getContentPane().add(b5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 160, 100));

        b6.setBorder(null);
        b6.setContentAreaFilled(false);
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });
        getContentPane().add(b6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 170, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menu.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutActionPerformed
        cart wow = new cart();
        wow.setVisible(true);

    this.dispose();
    }//GEN-LAST:event_checkoutActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
    int choice = javax.swing.JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to cancel your order?",
        "Confirm Cancel",
        javax.swing.JOptionPane.YES_NO_OPTION
    );

    if (choice == javax.swing.JOptionPane.YES_OPTION) {

        OrderData.resetOrder();


        JOptionPane.showMessageDialog(this, "Your order has been cancelled.");


        kiosk back = new kiosk();
        back.setVisible(true);
        this.dispose();

    } else if (choice == javax.swing.JOptionPane.NO_OPTION) {

        JOptionPane.showMessageDialog(this, "Your order has been resumed.");
    }

    }//GEN-LAST:event_cancelActionPerformed

    private void subtractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subtractActionPerformed
     int qty = Integer.parseInt(quantity.getText());
        if (qty > 1) {
            qty--;
            quantity.setText(String.valueOf(qty));
            updateTotal();
        }
    }//GEN-LAST:event_subtractActionPerformed

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
    int qty = Integer.parseInt(quantity.getText());
        qty++;
        quantity.setText(String.valueOf(qty));
        updateTotal();
    }//GEN-LAST:event_addActionPerformed

    private void mealtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mealtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mealtotalActionPerformed

    private void addorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addorderActionPerformed
if (selectedMealIndex != -1) {
        String meal = meals[selectedMealIndex];
        int qty = Integer.parseInt(quantity.getText());

        // Check stock first
        if (InventoryData.reduceStock(meal, qty)) {
            OrderData.addOrder(meal, prices[selectedMealIndex], qty);
            JOptionPane.showMessageDialog(this, 
                meal + " added!\nCurrent Total: " + OrderData.getFormattedTotal());
        } else {
            JOptionPane.showMessageDialog(this, 
                meal + " is unavailable or insufficient stock!");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a meal first!");
    }
    quantity.setText("1");
    mealtotal.setText("");
    }//GEN-LAST:event_addorderActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
            selectedMealIndex = 0;
                updateTotal();
    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        selectedMealIndex = 1;
        updateTotal();
    }//GEN-LAST:event_b2ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        selectedMealIndex = 2;
        updateTotal();
    }//GEN-LAST:event_b3ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        selectedMealIndex = 3;
        updateTotal();
    }//GEN-LAST:event_b4ActionPerformed

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        selectedMealIndex = 4;
        updateTotal();
    }//GEN-LAST:event_b5ActionPerformed

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
        selectedMealIndex = 5;
        updateTotal();
    }//GEN-LAST:event_b6ActionPerformed

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton addorder;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton cancel;
    private javax.swing.JButton checkout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField mealtotal;
    private javax.swing.JTextField quantity;
    private javax.swing.JButton subtract;
    // End of variables declaration//GEN-END:variables
}
