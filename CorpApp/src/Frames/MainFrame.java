/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.io.File;
import printer.PDFprinter;

/**
 *
 * @author danielalvarado
 */
public class MainFrame extends javax.swing.JFrame {
    public static util.DBConnection BD = new util.DBConnection();
                
    public static util.Query newQuery = new util.Query();

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }
    
    public static util.DBConnection getBD(){
        return BD;
    } 
    public static util.Query getQueryObject(){
        return newQuery;
    } 


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        historicButton = new javax.swing.JButton();
        employeesButton = new javax.swing.JButton();
        pagoPlanillasButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Corporation App");

        historicButton.setText("Historico de Planillas");
        historicButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historicButtonMouseClicked(evt);
            }
        });
        historicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historicButtonActionPerformed(evt);
            }
        });

        employeesButton.setText("Empleados");
        employeesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeesButtonMouseClicked(evt);
            }
        });
        employeesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeesButtonActionPerformed(evt);
            }
        });

        pagoPlanillasButton.setText("Pago de planillas");
        pagoPlanillasButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pagoPlanillasButtonMouseClicked(evt);
            }
        });
        pagoPlanillasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagoPlanillasButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pagoPlanillasButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeesButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(historicButton, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(historicButton)
                .addGap(18, 18, 18)
                .addComponent(employeesButton)
                .addGap(18, 18, 18)
                .addComponent(pagoPlanillasButton)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void historicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historicButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_historicButtonActionPerformed

    private void employeesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeesButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeesButtonActionPerformed

    private void historicButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historicButtonMouseClicked

        // TODO add your handling code here:
       new HistFrame().setVisible(true);
       this.setVisible(false);
       dispose();
    }//GEN-LAST:event_historicButtonMouseClicked

    private void pagoPlanillasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagoPlanillasButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pagoPlanillasButtonActionPerformed

    private void employeesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeesButtonMouseClicked
        // TODO add your handling code here:
       new EmpFrame().setVisible(true);
       this.setVisible(false);
       dispose();
    }//GEN-LAST:event_employeesButtonMouseClicked

    private void pagoPlanillasButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagoPlanillasButtonMouseClicked
        // TODO add your handling code here:
       new PagosPlanillasDialog(this, true).setVisible(true);
       //new PagosPlanillasDialog().setVisible(true);
       this.setVisible(false);
       dispose();
    }//GEN-LAST:event_pagoPlanillasButtonMouseClicked

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
                
                
                BD.connect();
                
                //newQuery.getEmployeeName(20);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton employeesButton;
    private javax.swing.JButton historicButton;
    private javax.swing.JButton pagoPlanillasButton;
    // End of variables declaration//GEN-END:variables
}
