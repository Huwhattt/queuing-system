package com.mycompany.queiungsystem;

    import java.time.LocalDate;
    import java.time.LocalTime;
    import java.time.format.DateTimeFormatter;
    import java.util.Random;
    import javax.swing.JOptionPane;
    import javax.swing.table.DefaultTableModel;

public class resibo2 extends javax.swing.JFrame {

    DefaultTableModel receiptModel;
    
    public resibo2() {
        initComponents();
        setSize(720,400);
        setTitle("Receipt");
        setLocation(407,12);
        
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);
        jButton1.setOpaque(false);
        
        resiboTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        resiboTable.getColumnModel().getColumn(1).setPreferredWidth(800);
        resiboTable.getColumnModel().getColumn(2).setPreferredWidth(30);
        
        
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);


        resiboTable.setOpaque(false);
        resiboTable.setShowGrid(false); 

        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);

        resiboTable.setBorder(null);
        resiboTable.setShowGrid(false);
        resiboTable.setOpaque(false);
        

        
        //-----------------------------------------------------------------------------------//
        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String currentDate = LocalDate.now().format(dateFormatter);
        date.setText(currentDate);
        
        
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:a");
        String currentTime = LocalTime.now().format(timeFormatter);
        time.setText(currentTime);
        
        
        Random rand = new Random();
        StringBuilder refNumBuilder = new StringBuilder();
            for (int i = 0; i < 12; i++) {
                refNumBuilder.append(rand.nextInt(10)); // Digits 0–9
            }
                ref.setText(refNumBuilder.toString());
    } 
  
    
    public void loadReceiptData(DefaultTableModel sourceModel, String total, String payment, String change, String orderType) {
    DefaultTableModel receiptModel = new DefaultTableModel(
        new Object[][]{},
        new String[]{"Qty", "Item", "Price"}
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    for (int i = 0; i < sourceModel.getRowCount(); i++) {
        Object qty = sourceModel.getValueAt(i, 2);
        Object item = sourceModel.getValueAt(i, 1);
        Object price = sourceModel.getValueAt(i, 3);

        if (qty != null && item != null && price != null &&
            !qty.toString().isEmpty() && !item.toString().equals("ORDER ITEMS:")) {
            receiptModel.addRow(new Object[]{qty, item, price});
        }
    }

    resiboTable.setModel(receiptModel);
    totalprice.setText(total);
    bayad.setText(payment);
    suklimo.setText(change);
    serv.setText(orderType);
}
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resiboTable = new javax.swing.JTable();
        serv = new javax.swing.JLabel();
        ref = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        totalprice = new javax.swing.JLabel();
        bayad = new javax.swing.JLabel();
        suklimo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        bakgrounf = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        resiboTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", ""
            }
        ));
        resiboTable.setEnabled(false);
        resiboTable.setRowSelectionAllowed(false);
        resiboTable.getTableHeader().setResizingAllowed(false);
        resiboTable.getTableHeader().setReorderingAllowed(false);
        resiboTable.setUpdateSelectionOnSort(false);
        resiboTable.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(resiboTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(250, 170, 210, 110);

        serv.setFont(new java.awt.Font("Segoe UI Black", 0, 9)); // NOI18N
        serv.setText("jLabel2");
        jPanel1.add(serv);
        serv.setBounds(330, 153, 60, 13);

        ref.setText("jLabel3");
        jPanel1.add(ref);
        ref.setBounds(320, 114, 80, 16);

        date.setText("jLabel4");
        jPanel1.add(date);
        date.setBounds(300, 130, 60, 16);

        time.setText("jLabel5");
        jPanel1.add(time);
        time.setBounds(410, 130, 60, 16);

        totalprice.setText("jLabel6");
        jPanel1.add(totalprice);
        totalprice.setBounds(410, 283, 50, 16);

        bayad.setText("jLabel7");
        jPanel1.add(bayad);
        bayad.setBounds(410, 298, 50, 16);

        suklimo.setText("jLabel8");
        jPanel1.add(suklimo);
        suklimo.setBounds(410, 313, 50, 16);

        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(520, 280, 150, 50);

        bakgrounf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/receipt.png"))); // NOI18N
        jPanel1.add(bakgrounf);
        bakgrounf.setBounds(0, -20, 710, 410);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    JOptionPane.showMessageDialog(this, "Transaction Successful!");
    testing t = new testing();
    
    
    String reference = ref.getText();
    String dateVal = date.getText();
    String total = totalprice.getText();

    // Add to history table
    history.historyTableModel.addRow(new Object[]{reference, dateVal, total});
      
    t.setVisible(true);
    dispose();
    
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
            java.util.logging.Logger.getLogger(resibo2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(resibo2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(resibo2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(resibo2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new resibo2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bakgrounf;
    public javax.swing.JLabel bayad;
    public javax.swing.JLabel date;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel ref;
    public javax.swing.JTable resiboTable;
    public javax.swing.JLabel serv;
    public javax.swing.JLabel suklimo;
    public javax.swing.JLabel time;
    public javax.swing.JLabel totalprice;
    // End of variables declaration//GEN-END:variables
}
