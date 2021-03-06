/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misOfertasEscritorio.UI;

import cl.duoc.misOfertasEscritorio.DAO.ProductoDAO;
import cl.duoc.misOfertasEscritorio.DAO.RubroDAO;
import cl.duoc.misOfertasEscritorio.DAO.TiendaDAO;
import cl.duoc.misOfertasEscritorio.Entities.Producto;
import cl.duoc.misOfertasEscritorio.Entities.Rubro;
import cl.duoc.misOfertasEscritorio.Entities.Tienda;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David
 */
public class CategoryMenu extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public CategoryMenu() {
        initComponents();
        populateTable();
        setHeaderColor();
        populateComboBox();
    }

    public CategoryMenu(String s) {
        initComponents();
        jLabelLogedAs.setText("Logeado como: " + s);
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
        jLabel8 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jTextFieldSelectedCod = new javax.swing.JTextField();
        jTextFieldAddNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldSelectedNombre1 = new javax.swing.JTextField();
        jButtonAddProduct = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jCbxTienda = new javax.swing.JComboBox<>();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRubro = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        menuProductos = new javax.swing.JLabel();
        menuCategoria = new javax.swing.JLabel();
        menuTiendas = new javax.swing.JLabel();
        menuUsuarios = new javax.swing.JLabel();
        exitMenu = new javax.swing.JLabel();
        jLabelBackHome = new javax.swing.JLabel();
        jLabelLogedAs = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(36, 47, 65));
        setMinimumSize(new java.awt.Dimension(1170, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(97, 212, 195));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mantenedor Categorias");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 540, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("NOMBRE");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(97, 212, 195));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 420, 10));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(97, 212, 195));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 410, 10));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Agregar Categoria");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(36, 47, 65));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/duoc/misOfertasEscritorio/Repository/deleteButton.png"))); // NOI18N
        jButton1.setText("ELIMINAR");
        jButton1.setBorder(null);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 140, 70));

        jButtonEdit.setBackground(new java.awt.Color(255, 255, 255));
        jButtonEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonEdit.setForeground(new java.awt.Color(36, 47, 65));
        jButtonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/duoc/misOfertasEscritorio/Repository/updateButton.png"))); // NOI18N
        jButtonEdit.setText("ACTUALIZAR");
        jButtonEdit.setBorder(null);
        jButtonEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEditMouseClicked(evt);
            }
        });
        jPanel1.add(jButtonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 150, 70));

        jTextFieldSelectedCod.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldSelectedCod.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldSelectedCod.setForeground(new java.awt.Color(36, 47, 65));
        jTextFieldSelectedCod.setBorder(null);
        jTextFieldSelectedCod.setCaretColor(new java.awt.Color(36, 47, 65));
        jTextFieldSelectedCod.setEnabled(false);
        jPanel1.add(jTextFieldSelectedCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 230, 30));

        jTextFieldAddNombre.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldAddNombre.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldAddNombre.setForeground(new java.awt.Color(36, 47, 65));
        jTextFieldAddNombre.setBorder(null);
        jTextFieldAddNombre.setCaretColor(new java.awt.Color(36, 47, 65));
        jTextFieldAddNombre.setMaximumSize(new java.awt.Dimension(0, 40));
        jPanel1.add(jTextFieldAddNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 230, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Editar Categorias");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("CODIGO CATEGORIA");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("TIENDA");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        jTextFieldSelectedNombre1.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldSelectedNombre1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldSelectedNombre1.setForeground(new java.awt.Color(36, 47, 65));
        jTextFieldSelectedNombre1.setBorder(null);
        jTextFieldSelectedNombre1.setCaretColor(new java.awt.Color(36, 47, 65));
        jPanel1.add(jTextFieldSelectedNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 230, 30));

        jButtonAddProduct.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAddProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonAddProduct.setForeground(new java.awt.Color(36, 47, 65));
        jButtonAddProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/duoc/misOfertasEscritorio/Repository/saveButton.png"))); // NOI18N
        jButtonAddProduct.setText("GUARDAR");
        jButtonAddProduct.setBorder(null);
        jButtonAddProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAddProductMouseClicked(evt);
            }
        });
        jPanel1.add(jButtonAddProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 150, 70));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(97, 212, 195));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 420, 10));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("NOMBRE CATEGORIA");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, -1));

        jCbxTienda.setBackground(new java.awt.Color(255, 255, 255));
        jCbxTienda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCbxTienda.setForeground(new java.awt.Color(36, 47, 65));
        jCbxTienda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCbxTienda.setBorder(null);
        jPanel1.add(jCbxTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 550, 230, 40));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setForeground(new java.awt.Color(97, 212, 195));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 410, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 540, 800));

        jPanel3.setBackground(new java.awt.Color(36, 47, 65));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableRubro.setBackground(new java.awt.Color(255, 255, 255));
        jTableRubro.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTableRubro.setForeground(new java.awt.Color(36, 47, 65));
        jTableRubro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Codigo", "Nombre Categoría", "Activo"
            }
        ));
        Color c = new Color(36,47,65);
        jTableRubro.getTableHeader().setBackground(Color.ORANGE);
        jTableRubro.setGridColor(new java.awt.Color(255, 255, 255));
        jTableRubro.setIntercellSpacing(new java.awt.Dimension(2, 2));
        jTableRubro.setSelectionBackground(new java.awt.Color(97, 212, 195));
        jTableRubro.setSelectionForeground(new java.awt.Color(36, 47, 65));
        jTableRubro.setShowHorizontalLines(false);
        jTableRubro.setShowVerticalLines(false);
        jTableRubro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRubroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableRubro);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 740, 240));

        jPanel2.setBackground(new java.awt.Color(97, 212, 195));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mis Categorias");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 120));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, -1, 800));

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

        jLabelBackHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/duoc/misOfertasEscritorio/Repository/backMenu.png"))); // NOI18N
        jLabelBackHome.setText("Home");
        jLabelBackHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBackHomeMouseClicked(evt);
            }
        });
        jPanel4.add(jLabelBackHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, -1, -1));

        jLabelLogedAs.setText("Logeado como: ");
        jPanel4.add(jLabelLogedAs, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuProductosMouseClicked
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        dispose();
        new ProductMenu().setVisible(true);
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

    private void jLabelBackHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackHomeMouseClicked
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        dispose();
        new Home().setVisible(true);
    }//GEN-LAST:event_jLabelBackHomeMouseClicked

    private void jButtonAddProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddProductMouseClicked

    }//GEN-LAST:event_jButtonAddProductMouseClicked
    /**
     *
     * @param evt
     *
     */
    private void jTableRubroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRubroMouseClicked
        RubroDAO rDAO = new RubroDAO();
        Rubro r;
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        int column = 0;
        String id = source.getModel().getValueAt(row, column).toString();
        r = rDAO.findById(Long.valueOf(id));
        jTextFieldSelectedCod.setText(String.valueOf(r.getIdRubro()));
        jTextFieldSelectedNombre1.setText(r.getNombreRubro());
    }//GEN-LAST:event_jTableRubroMouseClicked

    private void jButtonEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEditMouseClicked
        
        /*
                ProductoDAO pDAO = new ProductoDAO();
        Producto p = new Producto();
        String oldName = null;
        try {
            p = pDAO.findById(Long.valueOf(jTextFieldSelectedCod.getText()));
            oldName = p.getNombreProducto();
            if (verificarCampo(jTextFieldSelectedNombre1, 100)) {
                p.setNombreProducto(jTextFieldSelectedNombre1.getText());
                pDAO.editProducto(p);
                JOptionPane.showMessageDialog(null, "Producto con ID: " + p.getIdProducto() + " actualizado con exito! Antiguo: " + oldName + ", Nuevo nombre:" + p.getNombreProducto());
                clearTable();
                
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar valor en campo nombre. Largo permitido entre 1 y 100");
                jTextFieldSelectedNombre1.setText(oldName);
                jTextFieldSelectedNombre1.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }*/
    }//GEN-LAST:event_jButtonEditMouseClicked

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
            java.util.logging.Logger.getLogger(CategoryMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CategoryMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CategoryMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CategoryMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CategoryMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exitMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAddProduct;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JComboBox<String> jCbxTienda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelBackHome;
    private javax.swing.JLabel jLabelLogedAs;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTableRubro;
    private javax.swing.JTextField jTextFieldAddNombre;
    private javax.swing.JTextField jTextFieldSelectedCod;
    private javax.swing.JTextField jTextFieldSelectedNombre1;
    private javax.swing.JLabel menuCategoria;
    private javax.swing.JLabel menuProductos;
    private javax.swing.JLabel menuTiendas;
    private javax.swing.JLabel menuUsuarios;
    // End of variables declaration//GEN-END:variables

    private void setHeaderColor() {
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(36, 47, 65));
        headerRenderer.setForeground(Color.WHITE);
        headerRenderer.setBorder(BorderFactory.createEmptyBorder());
        for (int i = 0; i < jTableRubro.getModel().getColumnCount(); i++) {
            jTableRubro.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }

    }

    private void populateTable() {
        RubroDAO rDAO = new RubroDAO();
        DefaultTableModel model = (DefaultTableModel) jTableRubro.getModel();
        List<Rubro> lista;
        lista = rDAO.listAll();
        Object rowData[] = new Object[3];
        for (Rubro r : lista) {
            rowData[0] = r.getIdRubro();
            rowData[1] = r.getNombreRubro();
            rowData[2] = r.getIsActive();
            model.addRow(rowData);
        }
    }
    private void populateComboBox() {
        TiendaDAO tDAO = new TiendaDAO();
        List<Tienda> lista = tDAO.findAll();
        jCbxTienda.removeAllItems();
        DefaultComboBoxModel defaultC = new DefaultComboBoxModel();
        for (Tienda t : lista) {
            defaultC.addElement(t.getNombre());
        }
        jCbxTienda.setModel(defaultC);
    }
}
