/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Toko;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fD_c3o6
 */
public class stock_barang extends javax.swing.JFrame {
    koneksi koneksi = new koneksi();

    private DefaultTableModel model;

    private void autonumber() {
        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM stock_barang ORDER BY id_daging DESC";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String NoFaktur = r.getString("id_daging").substring(2);
                String DG = "" + (Integer.parseInt(NoFaktur) + 1);
                String Nol = "";

                if (DG.length() == 1) {
                    Nol = "00";
                } else if (DG.length() == 2) {
                    Nol = "0";
                } else if (DG.length() == 3) {
                    Nol = "";
                }

                txid_daging.setText("DG" + Nol + DG);
            } else {
                txid_daging.setText("DG001");
            }
            r.close();
            s.close();
        } catch (Exception e) {
            System.out.println("autonumber error");
        }
    }

    public void clear() {
        txnama_daging.setText("");
        txharga_beli.setText("");
        txharga_jual.setText("");
        txstock_daging.setText("");
    }

    public void loadData() {
        model.getDataVector().removeAllElements();

        model.fireTableDataChanged();

        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM stock_barang";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                Object[] o = new Object[8];
                o[0] = r.getString("id_daging");
                o[1] = r.getString("nama_daging");
                o[2] = r.getString("jenis_daging");
                o[3] = r.getString("bagian_daging");
                o[4] = r.getString("stock_daging");
                o[5] = r.getString("harga_beli");
                o[6] = r.getString("harga_jual");
                o[7] = r.getString("berat_daging");

                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (Exception e) {
            System.out.println("terjadi kesalahan");
        }
    }

    public void cariData() {
        DefaultTableModel tabel = new DefaultTableModel();

        model.addColumn("id_daging");
        model.addColumn("nama_daging");
        model.addColumn("jenis_daging");
        model.addColumn("bagian_daging");
        model.addColumn("stock_daging");
        model.addColumn("harga_beli");
        model.addColumn("harga_jual");
        model.addColumn("berat_daging");

        try {
            Connection c = koneksi.getKoneksi();
            String sql = "Select * from stock_barang where id_daging like '%" + jTextField1.getText() + "%'" +
                    "or nama_daging like '%" + jTextField1.getText() + "%'";
            Statement stat = c.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                tabel.addRow(new Object[] {
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                });
            }
            jTable1.setModel(tabel);
            loadData();
        } catch (Exception e) {
            System.out.println("Cari Data Error");
        } finally {
        }
    }

    /**
     * Creates new form DataBarang
     */
    public stock_barang() {
        initComponents();
        this.setLocationRelativeTo(null);

        model = new DefaultTableModel();

        jTable1.setModel(model);

        model.addColumn("id_daging");
        model.addColumn("nama_daging");
        model.addColumn("jenis_daging");
        model.addColumn("bagian_daging");
        model.addColumn("stock_daging");
        model.addColumn("harga_beli");
        model.addColumn("harga_jual");
        model.addColumn("berat_daging");

        loadData();
        autonumber();
        btnedit.setEnabled(false);
        btnhapus.setEnabled(false);
        btnbatal.setEnabled(false);

        /**
         * Creates new form stock_barang
         */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txid_daging = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txnama_daging = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txjenis_daging = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txbagian_daging = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txstock_daging = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbberat_daging = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txharga_beli = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txharga_jual = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnsimpan = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("STOCK BARANG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(285, 285, 285)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1)
                                .addContainerGap(41, Short.MAX_VALUE)));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("ID Daging");

        txid_daging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txid_dagingActionPerformed(evt);
            }
        });

        jLabel4.setText("Nama Daging");

        txnama_daging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnama_dagingActionPerformed(evt);
            }
        });

        jLabel5.setText("Jenis Daging");

        jLabel6.setText("Bagian Daging");

        jLabel7.setText("Stock Daging");

        txstock_daging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txstock_dagingActionPerformed(evt);
            }
        });

        jLabel8.setText("Berat Daging");

        cbberat_daging.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "250 gr", "500 gr", "750 gr", "1kg", " " }));
        cbberat_daging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbberat_dagingActionPerformed(evt);
            }
        });

        jLabel9.setText("Harga Beli /gr");

        jLabel10.setText("Harga Jual /gr");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout
                                                        .createSequentialGroup()
                                                        .addGroup(jPanel2Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel4)
                                                                .addComponent(jLabel3))
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(jLabel5)
                                                        .addGap(13, 13, 13)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(5, 5, 5)))
                                .addGroup(jPanel2Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txjenis_daging)
                                        .addComponent(txid_daging, javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                        .addComponent(txnama_daging, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txbagian_daging))
                                .addGap(217, 217, 217)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout
                                                        .createSequentialGroup()
                                                        .addGroup(jPanel2Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel8)
                                                                .addComponent(jLabel9))
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(jLabel7)
                                                        .addGap(13, 13, 13)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(7, 7, 7)))
                                .addGroup(jPanel2Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txharga_jual, javax.swing.GroupLayout.DEFAULT_SIZE, 140,
                                                Short.MAX_VALUE)
                                        .addComponent(txstock_daging)
                                        .addComponent(txharga_beli, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbberat_daging, javax.swing.GroupLayout.Alignment.LEADING, 0, 140,
                                                Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txid_daging, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7)
                                        .addComponent(txstock_daging, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(txnama_daging, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8)
                                        .addComponent(cbberat_daging, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(txjenis_daging, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9)
                                        .addComponent(txharga_beli, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addGroup(jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txbagian_daging, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel10)
                                                .addComponent(txharga_jual, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(44, Short.MAX_VALUE)));

        jLabel2.setText("Cari Data");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }));
        jScrollPane1.setViewportView(jTable1);

        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnedit.setText("Edit");

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnbatal.setText("Batal");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 679,
                                                Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(jLabel2)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 152,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 67,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 67,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnhapus)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 67,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnsimpan)
                                        .addComponent(btnedit)
                                        .addComponent(btnhapus)
                                        .addComponent(btnbatal))
                                .addGap(21, 21, 21)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txid_dagingActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txid_dagingActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txid_dagingActionPerformed

    private void txnama_dagingActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txnama_dagingActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txnama_dagingActionPerformed

    private void cbberat_dagingActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbberat_dagingActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_cbberat_dagingActionPerformed

    private void txstock_dagingActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txstock_dagingActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txstock_dagingActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnbatalActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnbatalActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnhapusActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnsimpanActionPerformed
        String id = txid_daging.getText();
        String nama = txnama_daging.getText();
        String jenis = txjenis_daging.getText();
        String bagian = txbagian_daging.getText();
        String stock = txstock_daging.getText();
        String hargabeli = txharga_beli.getText();
        String hargajual = txharga_jual.getText();
        String berat = (String) cbberat_daging.getSelectedItem();

        try {
            Connection c = koneksi.getKoneksi();
            String sql = "INSERT INTO stock_barang VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, id);
            p.setString(2, nama);
            p.setString(3, jenis);
            p.setString(4, bagian);
            p.setString(5, stock);
            p.setString(6, hargabeli);
            p.setString(7, hargajual);
            p.setString(8, berat);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
            loadData();
        } catch (Exception e) {
            System.out.print(e);
            System.out.println("Terjadi Kesalahan");
        } finally {
            autonumber();
            clear();
        }
    }// GEN-LAST:event_btnsimpanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(stock_barang.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stock_barang.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stock_barang.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stock_barang.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stock_barang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JComboBox<String> cbberat_daging;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txbagian_daging;
    private javax.swing.JTextField txharga_beli;
    private javax.swing.JTextField txharga_jual;
    private javax.swing.JTextField txid_daging;
    private javax.swing.JTextField txjenis_daging;
    private javax.swing.JTextField txnama_daging;
    private javax.swing.JTextField txstock_daging;
    // End of variables declaration//GEN-END:variables
}