/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misOfertasEscritorio.UI;

import cl.duoc.misOfertasEscritorio.Entities.Usuario;
import javax.swing.JFrame;

/**
 *
 * @author David
 */
public class Home extends javax.swing.JFrame {

    Usuario logedUser = new Usuario();
    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
    }

    public Home(Usuario u, String d) {
        initComponents();
        jTextFieldLogedUserName.setText(u.getPersonaId().getPrimerNombre()+" "+u.getPersonaId().getApellidoPaterno());
        jTextFieldLogedUser.setText(u.getUsername());
        jTextFieldLogedUserHour.setText(d);
        logedUser = u;
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
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jTextFieldLogedUserHour = new javax.swing.JTextField();
        jTextFieldLogedUser = new javax.swing.JTextField();
        jTextFieldLogedUserName = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        menuProductos = new javax.swing.JLabel();
        menuCategoria = new javax.swing.JLabel();
        menuTiendas = new javax.swing.JLabel();
        menuUsuarios = new javax.swing.JLabel();
        exitMenu = new javax.swing.JLabel();

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 540, 800));

        jPanel3.setBackground(new java.awt.Color(36, 47, 65));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Acceso Usuario");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("HORA INGRESO");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("FULLNAME");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 300, 10));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 300, 10));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("USERNAME");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, -1));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 300, 10));

        jTextFieldLogedUserHour.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldLogedUserHour.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jTextFieldLogedUserHour.setForeground(new java.awt.Color(36, 47, 65));
        jTextFieldLogedUserHour.setBorder(null);
        jTextFieldLogedUserHour.setEnabled(false);
        jPanel3.add(jTextFieldLogedUserHour, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 170, 30));

        jTextFieldLogedUser.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldLogedUser.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jTextFieldLogedUser.setForeground(new java.awt.Color(36, 47, 65));
        jTextFieldLogedUser.setBorder(null);
        jTextFieldLogedUser.setEnabled(false);
        jPanel3.add(jTextFieldLogedUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 200, 30));

        jTextFieldLogedUserName.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldLogedUserName.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jTextFieldLogedUserName.setForeground(new java.awt.Color(36, 47, 65));
        jTextFieldLogedUserName.setBorder(null);
        jTextFieldLogedUserName.setEnabled(false);
        jPanel3.add(jTextFieldLogedUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 200, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 740, 800));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/duoc/misOfertasEscritorio/Repository/productMenu.png"))); // NOI18N
        menuProductos.setText("Productos");
        menuProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuProductosMouseClicked(evt);
            }
        });
        jPanel4.add(menuProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        menuCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/duoc/misOfertasEscritorio/Repository/categoryMenu.png"))); // NOI18N
        menuCategoria.setText("Categoria");
        menuCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCategoriaMouseClicked(evt);
            }
        });
        jPanel4.add(menuCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, -1, -1));

        menuTiendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/duoc/misOfertasEscritorio/Repository/storeMenu.png"))); // NOI18N
        menuTiendas.setText("Tiendas");
        menuTiendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuTiendasMouseClicked(evt);
            }
        });
        jPanel4.add(menuTiendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, -1, -1));

        menuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/duoc/misOfertasEscritorio/Repository/userMenu.png"))); // NOI18N
        menuUsuarios.setText("Usuarios");
        menuUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuUsuariosMouseClicked(evt);
            }
        });
        jPanel4.add(menuUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, -1));

        exitMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/duoc/misOfertasEscritorio/Repository/exitMenu.png"))); // NOI18N
        exitMenu.setText("Salir");
        exitMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMenuMouseClicked(evt);
            }
        });
        jPanel4.add(exitMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 0, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuProductosMouseClicked
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        dispose();
        new ProductMenu(logedUser).setVisible(true);
    }//GEN-LAST:event_menuProductosMouseClicked

    private void exitMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMenuMouseClicked
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_exitMenuMouseClicked

    private void menuCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCategoriaMouseClicked
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        dispose();
        new CategoryMenu().setVisible(true);
    }//GEN-LAST:event_menuCategoriaMouseClicked

    private void menuTiendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuTiendasMouseClicked
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        dispose();
        new StoreMenu().setVisible(true);
    }//GEN-LAST:event_menuTiendasMouseClicked

    private void menuUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuUsuariosMouseClicked
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        dispose();
        new UserMenu().setVisible(true);
    }//GEN-LAST:event_menuUsuariosMouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exitMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextFieldLogedUser;
    private javax.swing.JTextField jTextFieldLogedUserHour;
    private javax.swing.JTextField jTextFieldLogedUserName;
    private javax.swing.JLabel menuCategoria;
    private javax.swing.JLabel menuProductos;
    private javax.swing.JLabel menuTiendas;
    private javax.swing.JLabel menuUsuarios;
    // End of variables declaration//GEN-END:variables
}