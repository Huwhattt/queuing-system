package com.mycompany.queiungsystem;
    
    import javax.swing.table.DefaultTableModel;
    import javax.swing.table.DefaultTableCellRenderer;
    import javax.swing.plaf.basic.BasicScrollBarUI;

public class history extends javax.swing.JFrame {
    
         public static DefaultTableModel historyTableModel = new DefaultTableModel(
        new Object[]{"Reference", "Date", "Total Price"}, 0
    );

    
    public history() {
        initComponents();
        setLocation(407,12);
        setSize(720,390);
        setTitle("Order History");
        
        lame.setFont(new java.awt.Font("Aracde Gamer", java.awt.Font.PLAIN, 14));
           
        lame.setModel(historyTableModel);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( javax.swing.JLabel.CENTER );
        for (int i = 0; i < lame.getColumnCount(); i++) {
            lame.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
         
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    jScrollPane1.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
        @Override
        protected void configureScrollBarColors() {
            this.thumbColor = new java.awt.Color(255, 215, 0);   // gold handle
            this.trackColor = new java.awt.Color(128, 0, 0);     // dark red track
        }
    });


lame.setOpaque(false);
lame.setShowGrid(false); 

jScrollPane1.setBorder(null);
jScrollPane1.setOpaque(false);
jScrollPane1.getViewport().setOpaque(false);

lame.setBorder(null);
lame.setShowGrid(false);
lame.setOpaque(false);
         
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lame = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(0, 0, 220, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/orderhis2.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 120, 530, 23);

        lame.setBackground(new java.awt.Color(199, 5, 57));
        lame.setForeground(new java.awt.Color(255, 255, 255));
        lame.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        lame.setEnabled(false);
        lame.setRowHeight(25);
        lame.setRowSelectionAllowed(false);
        lame.getTableHeader().setResizingAllowed(false);
        lame.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(lame);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 120, 500, 200);

        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jPanel1.add(jButton2);
        jButton2.setBounds(580, 180, 120, 40);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/orderhis2.png"))); // NOI18N
        jPanel1.add(background);
        background.setBounds(0, 0, 710, 360);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        testing tes = new testing();
        tes.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new history().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable lame;
    // End of variables declaration//GEN-END:variables
}
