package com.mycompany.queiungsystem;

import java.awt.Color;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
        
        completed.setContentAreaFilled(false);
        completed.setBorderPainted(false);
        completed.setOpaque(false);
        
        refresh.setContentAreaFilled(false);
        refresh.setBorderPainted(false);
        refresh.setOpaque(false);
        
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
    
    public void refreshOrders() {
        for (int i = 0; i < qnoFields.length - 1; i++) {

            if (qnoFields[i].getText().isEmpty()) {
                for (int j = i + 1; j < qnoFields.length; j++) {
                    if (!qnoFields[j].getText().isEmpty()) {

                        qnoFields[i].setText(qnoFields[j].getText());
                        statFields[i].setText(statFields[j].getText());
                        timeFields[i].setText(timeFields[j].getText());

                        qnoFields[j].setText("");
                        statFields[j].setText("");
                        timeFields[j].setText("");

                        break; 
                    }
                }
            }
        }
    }
    
    public void FIFO() {
        for (int i = 0; i < qnoFields.length; i++) {
            String orderNum = qnoFields[i].getText().trim();
            String status = statFields[i].getText().trim();

            if (!orderNum.isEmpty()) {
                if (!status.equalsIgnoreCase("Ready")) {
                    JOptionPane.showMessageDialog(this,
                            "Order " + orderNum + " is still " + status + ". Cannot complete until it is Ready.",
                            "Order Not Ready",
                            JOptionPane.WARNING_MESSAGE);
                    return;  // stop here, no completion
                }

                // Status is Ready, proceed
                int response = JOptionPane.showConfirmDialog(this,
                        "Mark order " + orderNum + " as completed?",
                        "Confirm Completion",
                        JOptionPane.YES_NO_OPTION);

                if (response == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(this,
                            "Order " + orderNum + " completed.",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);

                    if (KFrame.woah != null) {
                        KFrame.woah.doneOrder(orderNum);
                    }

                    qnoFields[i].setText("");
                    statFields[i].setText("");
                    timeFields[i].setText("");

                    return;
                } else {
                    return;
                }
            }
        }

        JOptionPane.showMessageDialog(this,
                "No orders to complete.",
                "Empty Queue",
                JOptionPane.INFORMATION_MESSAGE);
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
        completed = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        qno1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qno1MouseClicked(evt);
            }
        });

        qno2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qno2MouseClicked(evt);
            }
        });

        qno3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qno3ActionPerformed(evt);
            }
        });

        qno4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qno4MouseClicked(evt);
            }
        });

        qno5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qno5MouseClicked(evt);
            }
        });

        qno6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qno6MouseClicked(evt);
            }
        });

        completed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completedActionPerformed(evt);
            }
        });

        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/counter.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(qno2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(stat4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(qno1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(time2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(time4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(time3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(qno4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(stat3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(time1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(qno6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(completed, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(stat6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(stat5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(time6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(stat2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(time5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(qno5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(qno3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(stat1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(completed, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(qno4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(qno6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(qno2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(qno1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(qno3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addComponent(qno5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(stat4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(stat3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(stat2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(stat1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(stat5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(stat6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(time2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(time3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(time1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(time4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(time6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(time5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void completedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completedActionPerformed
        FIFO();
    }//GEN-LAST:event_completedActionPerformed

    private void qno1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qno1MouseClicked

    }//GEN-LAST:event_qno1MouseClicked

    private void qno2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qno2MouseClicked

    }//GEN-LAST:event_qno2MouseClicked

    private void qno3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qno3ActionPerformed

    }//GEN-LAST:event_qno3ActionPerformed

    private void qno4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qno4MouseClicked

    }//GEN-LAST:event_qno4MouseClicked

    private void qno5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qno5MouseClicked

    }//GEN-LAST:event_qno5MouseClicked

    private void qno6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qno6MouseClicked
 
    }//GEN-LAST:event_qno6MouseClicked

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed

        refreshOrders();
        
    }//GEN-LAST:event_refreshActionPerformed

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
    private javax.swing.JButton completed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField qno1;
    private javax.swing.JTextField qno2;
    private javax.swing.JTextField qno3;
    private javax.swing.JTextField qno4;
    private javax.swing.JTextField qno5;
    private javax.swing.JTextField qno6;
    private javax.swing.JButton refresh;
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
