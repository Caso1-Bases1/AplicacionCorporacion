/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

/**
 *
 * @author danielalvarado
 */
public class EmpFrame extends javax.swing.JFrame {

    /**
     * Creates new form HistFrame
     */
    public EmpFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        empleadoRadioBtn = new javax.swing.JRadioButton();
        descRadioBTN = new javax.swing.JRadioButton();
        totalesRadioBtn = new javax.swing.JRadioButton();
        mostarBtn = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        aguinaldosRadioBtn = new javax.swing.JRadioButton();
        ascRadioBTN = new javax.swing.JRadioButton();
        plantaRadioBtn = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Historico");

        buttonGroup1.add(empleadoRadioBtn);
        empleadoRadioBtn.setText("Top 10");
        empleadoRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empleadoRadioBtnActionPerformed(evt);
            }
        });

        buttonGroup1.add(descRadioBTN);
        descRadioBTN.setText("Por cantidad de empleados descendente");

        buttonGroup1.add(totalesRadioBtn);
        totalesRadioBtn.setText("Totales");
        totalesRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalesRadioBtnActionPerformed(evt);
            }
        });

        mostarBtn.setText("Mostrar");
        mostarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostarBtnMouseClicked(evt);
            }
        });

        jButton1.setText("<-");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel1.setText("Empleados");

        buttonGroup1.add(aguinaldosRadioBtn);
        aguinaldosRadioBtn.setText("Aguinaldos");

        buttonGroup1.add(ascRadioBTN);
        ascRadioBTN.setText("Por cantidad de empleados ascendente");

        buttonGroup1.add(plantaRadioBtn);
        plantaRadioBtn.setText("Por planta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aguinaldosRadioBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mostarBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(empleadoRadioBtn)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89)
                                .addComponent(jLabel1))
                            .addComponent(plantaRadioBtn)
                            .addComponent(totalesRadioBtn)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ascRadioBTN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descRadioBTN)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(empleadoRadioBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(plantaRadioBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ascRadioBTN)
                    .addComponent(descRadioBTN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalesRadioBtn)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(mostarBtn))
                    .addComponent(aguinaldosRadioBtn)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void empleadoRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empleadoRadioBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empleadoRadioBtnActionPerformed

    private void totalesRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalesRadioBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalesRadioBtnActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        new MainFrame().setVisible(true);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void mostarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mostarBtnMouseClicked
        
        // TODO add your handling code here:
        if (empleadoRadioBtn.isSelected()) {
            //Top 10
            new EmpTiempoDialog(this,true).setVisible(true);
        } else if (plantaRadioBtn.isSelected()) {
            //Por planta
            new EmpPlantaDialog(this,true).setVisible(true);
        } else if (ascRadioBTN.isSelected()) {
            //Por empleado ascendente
            EmpAscDialog nuevo =
            new EmpAscDialog(this,true);
            nuevo.setTypeOfTable(1);
            nuevo.setVisible(true);
        } else if (descRadioBTN.isSelected()) {
            //Por empleado descendente
            EmpDescDialog nuevo =
            new EmpDescDialog(this,true);
            nuevo.setTypeOfTable(2);
            nuevo.setVisible(true);
        }else if (totalesRadioBtn.isSelected()) {
            //Totales
            new HistPlantaDialog(this,true).setVisible(true);
        }else if (aguinaldosRadioBtn.isSelected()) {
            //Aguinaldos
            new EmpleadoAguinaldoDialog(this,true).setVisible(true);
        }
    }//GEN-LAST:event_mostarBtnMouseClicked

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
            java.util.logging.Logger.getLogger(HistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton aguinaldosRadioBtn;
    private javax.swing.JRadioButton ascRadioBTN;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton descRadioBTN;
    private javax.swing.JRadioButton empleadoRadioBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton mostarBtn;
    private javax.swing.JRadioButton plantaRadioBtn;
    private javax.swing.JRadioButton totalesRadioBtn;
    // End of variables declaration//GEN-END:variables
}
