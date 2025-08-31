package com.mycompany.queiungsystem;

public class kiosk extends javax.swing.JFrame {

    public kiosk() {
        initComponents();
        setSize(400, 800);
        setLocation(10, 12); 
        setTitle("Kiosk");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 800));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hi.setBorder(null);
        hi.setContentAreaFilled(false);
        hi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hiActionPerformed(evt);
            }
        });
        getContentPane().add(hi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 390, 140));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tto.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hiActionPerformed
            choice hi = new choice();
            hi.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_hiActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kiosk().setVisible(true);
                new logque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hi;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
