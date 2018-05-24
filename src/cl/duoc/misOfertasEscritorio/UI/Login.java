/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misOfertasEscritorio.UI;

import cl.duoc.misOfertasEscritorio.DAO.UsuarioDAO;
import cl.duoc.misOfertasEscritorio.Entities.Usuario;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author David
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Login() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jPasswordFieldLogin = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1170, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(97, 212, 195));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Aplicación Escritorio");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/duoc/misOfertasEscritorio/Repository/misOfertasLogo.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 170, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 850));

        jPanel3.setBackground(new java.awt.Color(36, 47, 65));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Acceso Usuario");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PASSWORD");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("USERNAME");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, -1));

        jTextFieldUsername.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldUsername.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jTextFieldUsername.setForeground(new java.awt.Color(36, 47, 65));
        jTextFieldUsername.setBorder(null);
        jTextFieldUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldUsernameMouseClicked(evt);
            }
        });
        jPanel3.add(jTextFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 200, 30));

        jPasswordFieldLogin.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordFieldLogin.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jPasswordFieldLogin.setForeground(new java.awt.Color(36, 47, 65));
        jPasswordFieldLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordFieldLoginMouseClicked(evt);
            }
        });
        jPanel3.add(jPasswordFieldLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 200, 30));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, 200, 10));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 200, 10));

        jButtonLogin.setBackground(new java.awt.Color(255, 255, 255));
        jButtonLogin.setForeground(new java.awt.Color(36, 47, 65));
        jButtonLogin.setText("Login");
        jButtonLogin.setBorder(null);
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 110, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 740, 850));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldUsernameMouseClicked

    }//GEN-LAST:event_jTextFieldUsernameMouseClicked

    private void jPasswordFieldLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordFieldLoginMouseClicked

    }//GEN-LAST:event_jPasswordFieldLoginMouseClicked

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        UsuarioDAO uDAO = new UsuarioDAO();
        Usuario u = new Usuario();
        try {
            if (jTextFieldUsername.getText().trim().length() != 0) {
                if (jPasswordFieldLogin.getText().toString().trim().length() != 0) {
                    String password = jPasswordFieldLogin.getText();
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date();
                    String strDate = dateFormat.format(date);
                    String username = jTextFieldUsername.getText();
                    u = uDAO.findByCredential(username, password);
                    if (validarLogin(username, password, u)) {
                        JOptionPane.showMessageDialog(null, "Login exitoso!");
                        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        dispose();
                        new Home(u, strDate).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingrese credenciales correctas");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Debe ingresar valor en campo PASSWORD");
                    jPasswordFieldLogin.requestFocus();

                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar valor en campo USERNAME");
                jTextFieldUsername.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese credenciales correctas");
            dispose();
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordFieldLogin;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables

    public boolean validarLogin(String username, String passw, Usuario u) {
        if (u.getUsername().compareTo(username) == 0 && u.getPassw().compareTo(passw) == 0) {
            return true;
        } else {
            return false;
        }
    }
}
