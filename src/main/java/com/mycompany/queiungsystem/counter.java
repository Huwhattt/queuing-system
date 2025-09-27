package com.mycompany.queiungsystem;

import java.awt.Color;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author Arabelle Donor
 */
public class counter extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(counter.class.getName());

    private JTextField[] statFields;
    private JTextField[] timeFields;
    private JTextField[] qnoFields;
    private String selectedOrderNumber = "";
    
    public counter() {
        initComponents();
        
        setLocation(1124, 413);
        setSize(404, 400);
        setTitle("Counter Screen");
        
        qno1.setOpaque(false);
        qno1.setBorder(null);
        qno1.setBackground(new Color(0,0,0,0));
        
        stat1.setOpaque(false);
        stat1.setBorder(null);
        stat1.setBackground(new Color(0, 0, 0, 0));
        
        time1.setOpaque(false);
        time1.setBorder(null);
        time1.setBackground(new Color(0, 0, 0, 0));
        
        qno2.setOpaque(false);
        qno2.setBorder(null);
        qno2.setBackground(new Color(0, 0, 0, 0));

        stat2.setOpaque(false);
        stat2.setBorder(null);
        stat2.setBackground(new Color(0, 0, 0, 0));

        time2.setOpaque(false);
        time2.setBorder(null);
        time2.setBackground(new Color(0, 0, 0, 0));
        
        qno3.setOpaque(false);
        qno3.setBorder(null);
        qno3.setBackground(new Color(0, 0, 0, 0));

        stat3.setOpaque(false);
        stat3.setBorder(null);
        stat3.setBackground(new Color(0, 0, 0, 0));

        time3.setOpaque(false);
        time3.setBorder(null);
        time3.setBackground(new Color(0, 0, 0, 0));
        
        qno4.setOpaque(false);
        qno4.setBorder(null);
        qno4.setBackground(new Color(0, 0, 0, 0));

        stat4.setOpaque(false);
        stat4.setBorder(null);
        stat4.setBackground(new Color(0, 0, 0, 0));

        time4.setOpaque(false);
        time4.setBorder(null);
        time4.setBackground(new Color(0, 0, 0, 0));
        
        qno5.setOpaque(false);
        qno5.setBorder(null);
        qno5.setBackground(new Color(0, 0, 0, 0));

        stat5.setOpaque(false);
        stat5.setBorder(null);
        stat5.setBackground(new Color(0, 0, 0, 0));

        time5.setOpaque(false);
        time5.setBorder(null);
        time5.setBackground(new Color(0, 0, 0, 0));
        
        qno6.setOpaque(false);
        qno6.setBorder(null);
        qno6.setBackground(new Color(0, 0, 0, 0));

        stat6.setOpaque(false);
        stat6.setBorder(null);
        stat6.setBackground(new Color(0, 0, 0, 0));

        time6.setOpaque(false);
        time6.setBorder(null);
        time6.setBackground(new Color(0, 0, 0, 0));
        
        qnoFields = new JTextField[]{qno1, qno2, qno3, qno4, qno5, qno6};
        statFields = new JTextField[]{stat1, stat2, stat3, stat4, stat5, stat6};
        timeFields = new JTextField[]{time1, time2, time3, time4, time5, time6};

        qno1.setEditable(false);
        qno2.setEditable(false);
        qno3.setEditable(false);
        qno4.setEditable(false);
        qno5.setEditable(false);
        qno6.setEditable(false);
        
        stat1.setEditable(false);
        stat2.setEditable(false);
        stat3.setEditable(false);
        stat4.setEditable(false);
        stat5.setEditable(false);
        stat6.setEditable(false);
        
        refresh();
                
    }
    
    public int showOrderNumber(String orderNumber) {
        for (int i = 0; i < qnoFields.length; i++) {
            if (qnoFields[i].getText().isEmpty()) {
                qnoFields[i].setText(orderNumber);
                return i;
            }
        }
        return -1;
    }

    public void setOrderStatus(int index, String status) {
        if (index >= 0 && index < statFields.length) {
            statFields[index].setText(status);
        }
    }

    public void showTime(int index) {
        if (index >= 0 && index < timeFields.length) {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
            String currentTime = LocalTime.now().format(timeFormatter);
            timeFields[index].setText(currentTime);
        }
    }

    private void refresh() {
        Timer timer = new Timer(1000, e -> refreshOrders());
        timer.start();
    }

    private void refreshOrders() {
        for (int i = 0; i < qnoFields.length - 1; i++) {

            if (qnoFields[i].getText().trim().isEmpty()) {
                qnoFields[i].setText(qnoFields[i + 1].getText());
                statFields[i].setText(statFields[i + 1].getText());
                timeFields[i].setText(timeFields[i + 1].getText());

                qnoFields[i + 1].setText("");
                statFields[i + 1].setText("");
                timeFields[i + 1].setText("");
            }
        }
    }

    private void done(JTextField qno, JTextField stat, JTextField time) {
        String orderNum = qno.getText().trim();
        String status = stat.getText().trim();

        if (!orderNum.isEmpty()) {

            if (!status.equalsIgnoreCase("Ready")) {
                JOptionPane.showMessageDialog(
                        null,
                        "Order " + orderNum + " is still " + status + ". Cannot complete until it is Ready.",
                        "Order Not Ready",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            int choice = JOptionPane.showConfirmDialog(
                    null,
                    "Mark order " + orderNum + " as completed?",
                    "Confirm Completion",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(
                        null,
                        "Order " + orderNum + " completed.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );

                qno.setText("");
                stat.setText("");
                time.setText("");

                if (KFrame.woah != null) {
                    KFrame.woah.doneOrder(orderNum);
                }
            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "No order found in this slot.",
                    "Empty Order",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
    
    public JTextField[] getQnoFields() {
        return qnoFields; 
    }

    public JTextField[] getStatFields() {
        return statFields;
    }
    
    public JTextField[] getTimeFields() {
        return timeFields;  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        qno1 = new javax.swing.JTextField();
        qno2 = new javax.swing.JTextField();
        qno3 = new javax.swing.JTextField();
        qno4 = new javax.swing.JTextField();
        qno5 = new javax.swing.JTextField();
        qno6 = new javax.swing.JTextField();
        stat1 = new javax.swing.JTextField();
        stat2 = new javax.swing.JTextField();
        stat3 = new javax.swing.JTextField();
        stat4 = new javax.swing.JTextField();
        stat5 = new javax.swing.JTextField();
        stat6 = new javax.swing.JTextField();
        time1 = new javax.swing.JTextField();
        time2 = new javax.swing.JTextField();
        time3 = new javax.swing.JTextField();
        time4 = new javax.swing.JTextField();
        time5 = new javax.swing.JTextField();
        time6 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        qno1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qno1MouseClicked(evt);
            }
        });
        getContentPane().add(qno1);
        qno1.setBounds(30, 120, 40, 30);

        qno2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qno2MouseClicked(evt);
            }
        });
        getContentPane().add(qno2);
        qno2.setBounds(30, 160, 40, 30);

        qno3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qno3MouseClicked(evt);
            }
        });
        qno3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qno3ActionPerformed(evt);
            }
        });
        getContentPane().add(qno3);
        qno3.setBounds(30, 200, 40, 30);

        qno4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qno4MouseClicked(evt);
            }
        });
        getContentPane().add(qno4);
        qno4.setBounds(30, 235, 40, 32);

        qno5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qno5MouseClicked(evt);
            }
        });
        getContentPane().add(qno5);
        qno5.setBounds(30, 270, 40, 30);

        qno6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qno6MouseClicked(evt);
            }
        });
        getContentPane().add(qno6);
        qno6.setBounds(30, 310, 40, 32);
        getContentPane().add(stat1);
        stat1.setBounds(160, 120, 80, 30);
        getContentPane().add(stat2);
        stat2.setBounds(160, 160, 80, 30);
        getContentPane().add(stat3);
        stat3.setBounds(160, 200, 80, 30);
        getContentPane().add(stat4);
        stat4.setBounds(160, 240, 80, 30);
        getContentPane().add(stat5);
        stat5.setBounds(160, 270, 80, 32);
        getContentPane().add(stat6);
        stat6.setBounds(160, 310, 80, 30);
        getContentPane().add(time1);
        time1.setBounds(290, 120, 90, 30);
        getContentPane().add(time2);
        time2.setBounds(290, 160, 90, 30);
        getContentPane().add(time3);
        time3.setBounds(290, 200, 90, 30);
        getContentPane().add(time4);
        time4.setBounds(290, 240, 90, 30);
        getContentPane().add(time5);
        time5.setBounds(290, 280, 90, 30);
        getContentPane().add(time6);
        time6.setBounds(290, 320, 90, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/counter.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 390, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void qno1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qno1MouseClicked
        done(qno1, stat1, time1);
    }//GEN-LAST:event_qno1MouseClicked

    private void qno2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qno2MouseClicked
        done(qno2, stat2, time2);
    }//GEN-LAST:event_qno2MouseClicked

    private void qno3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qno3ActionPerformed

    }//GEN-LAST:event_qno3ActionPerformed

    private void qno4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qno4MouseClicked
        done(qno4, stat4, time4);
    }//GEN-LAST:event_qno4MouseClicked

    private void qno5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qno5MouseClicked
        done(qno5, stat5, time5);
    }//GEN-LAST:event_qno5MouseClicked

    private void qno6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qno6MouseClicked
        done(qno6, stat6, time6);
    }//GEN-LAST:event_qno6MouseClicked

    private void qno3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qno3MouseClicked
        done(qno3, stat3, time3);
    }//GEN-LAST:event_qno3MouseClicked

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new counter().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField qno1;
    private javax.swing.JTextField qno2;
    private javax.swing.JTextField qno3;
    private javax.swing.JTextField qno4;
    private javax.swing.JTextField qno5;
    private javax.swing.JTextField qno6;
    private javax.swing.JTextField stat1;
    private javax.swing.JTextField stat2;
    private javax.swing.JTextField stat3;
    private javax.swing.JTextField stat4;
    private javax.swing.JTextField stat5;
    private javax.swing.JTextField stat6;
    private javax.swing.JTextField time1;
    private javax.swing.JTextField time2;
    private javax.swing.JTextField time3;
    private javax.swing.JTextField time4;
    private javax.swing.JTextField time5;
    private javax.swing.JTextField time6;
    // End of variables declaration//GEN-END:variables
}
