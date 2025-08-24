
package com.mycompany.queiungsystem;


public class choice extends javax.swing.JFrame {

   
    public choice() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dinein = new javax.swing.JButton();
        dineout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dinein.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dineinActionPerformed(evt);
            }
        });
        getContentPane().add(dinein, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 230, 60));

        dineout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dineoutActionPerformed(evt);
            }
        });
        getContentPane().add(dineout, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 230, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/qms kiosk and status.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dineoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dineoutActionPerformed
        menu loe = new menu();
        loe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dineoutActionPerformed

    private void dineinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dineinActionPerformed
        menu hey = new menu ();
        hey.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dineinActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new choice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dinein;
    private javax.swing.JButton dineout;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
