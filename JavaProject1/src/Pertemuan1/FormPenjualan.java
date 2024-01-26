
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pertemuan1;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


/**
 *
 * @author Asus
 */
public class FormPenjualan extends javax.swing.JFrame {

    public String tgl;
     
    /**
     * Creates new form FormPenjualan
     */
    public FormPenjualan() {
        initComponents();
        showTable();
        
         jTextField5.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                hitungTotal();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                hitungTotal();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                hitungTotal();
            }
        });
    }

    private void hitungTotal() {
        try {
            String hargaText = jTextField3.getText().trim();
            String qtyText = jTextField5.getText().trim();

            if (!hargaText.isEmpty() && !qtyText.isEmpty()) {
                int harga1 = Integer.parseInt(hargaText);
                int qty1 = Integer.parseInt(qtyText);

                int total1 = harga1 * qty1;

                String total = Integer.toString(total1);
                jTextField6.setText(total);
            } else {
                // Jika salah satu atau kedua JTextField kosong, tampilkan pesan kesalahan
                JOptionPane.showMessageDialog(null, "Isi kedua kolom dengan nilai numerik.");
            }
        } catch (NumberFormatException e) {
            // Tangani kesalahan jika terjadi kesalahan konversi
            JOptionPane.showMessageDialog(null, "Masukkan nilai numerik yang valid.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void showTable () {
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("Id");
        tabel.addColumn("Kode_Barang");
        tabel.addColumn("Nama_Barang");
        tabel.addColumn("QTY");
        tabel.addColumn("Tanggal");
        tabel.addColumn("Total");
        tabel.addColumn("Profit");
        tabel.addColumn("Stok");
        tabel.addColumn("Saham");
        
        try {
            String sql = "SELECT penjualan_barang.id, penjualan_barang.Kode_Barang, penjualan_barang.Nama_Barang, penjualan_barang.QTY, penjualan_barang.Tanggal, penjualan_barang.Total, penjualan_barang.Profit, barang.Stok, barang.Saham FROM penjualan_barang INNER JOIN barang ON barang.Kode_Barang = penjualan_barang.Kode_Barang";
            
            java.sql.Connection conn = (Connection)Pertemuan1.Config.configDB();
            java.sql.PreparedStatement pat = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pat.executeQuery(sql);
            
            
            while(rs.next()) {
                tabel.addRow(new Object[] {
                rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5),  rs.getString(6),
                rs.getString(7), rs.getString(8), rs.getString(9),
               }); 
                
               jTable1.setModel(tabel);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error");
        }
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("FORM ENTRI DATA PENJUALAN ACC");

        jLabel2.setText("Kode ACC");

        jLabel3.setText("Nama ACC");

        jLabel4.setText("Harga");

        jLabel5.setText("Stok");

        jLabel6.setText("Qty");

        jLabel7.setText("Tanggal");

        jLabel8.setText("Total");

        jTextField1.setText("jTextField1");
        jTextField1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField1CaretUpdate(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setText("jTextField2");
        jTextField2.setPreferredSize(new java.awt.Dimension(71, 30));

        jTextField3.setEditable(false);
        jTextField3.setText("jTextField3");

        jTextField4.setEditable(false);
        jTextField4.setText("jTextField4");

        jTextField5.setText("jTextField5");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        jTextField6.setEditable(false);
        jTextField6.setText("jTextField6");
        jTextField6.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField6CaretUpdate(evt);
            }
        });
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("SAVE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("CLOSE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Kode_Barang", "Nama_Barang", "QTY", "Tanggal", "Total", "Profit", "Stok", "Saham"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(30, 30, 30)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton2)
                                    .addComponent(jButton1)
                                    .addComponent(jButton3)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(172, 172, 172))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(98, 98, 98)))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty() || jTextField5.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Isi semua kolom yang diperlukan!");
        } else {
            try {
                // Mendapatkan stok dan kuantitas
                int stok = Integer.parseInt(jTextField4.getText());
                int beli = Integer.parseInt(jTextField5.getText());

                String kodeBarang = jTextField1.getText();

                // Query untuk mendapatkan informasi barang dan penjualan
                String query = "SELECT barang.Stok, barang.Saham, barang.Harga_Beli, barang.Harga_Jual, SUM(penjualan_barang.QTY) AS Jumlah_Terjual FROM penjualan_barang INNER JOIN barang ON barang.Kode_Barang = penjualan_barang.Kode_Barang WHERE barang.Kode_Barang = ? AND penjualan_barang.QTY = ?";

                java.sql.Connection conn = (Connection) Pertemuan1.Config.configDB();
                java.sql.PreparedStatement queryPat = conn.prepareStatement(query);
                queryPat.setString(1, kodeBarang);
                queryPat.setInt(2, beli);

                java.sql.ResultSet rs = queryPat.executeQuery();

                if (rs.next()) {
                    int hargaBeli = rs.getInt("Harga_Beli");
                    int hargaJual = rs.getInt("Harga_Jual");
                    int jumlahTerjual = rs.getInt("Jumlah_Terjual");

                    // Perhitungan profit (hargaJual - hargaBeli) dikalikan dengan jumlahTerjual
                    int profit1 = (hargaJual - hargaBeli) * jumlahTerjual;
                    String profit = Integer.toString(profit1);

                    if (stok >= beli) {
                        
                        String insertSql = "INSERT INTO penjualan_barang(Kode_Barang, Nama_Barang, QTY, Tanggal, Total, Profit) VALUES (?, ?, ?, ?, ?, ?)";

                        java.sql.PreparedStatement insertPat = conn.prepareStatement(insertSql);

                        insertPat.setString(1, jTextField1.getText());
                        insertPat.setString(2, jTextField2.getText());
                        insertPat.setString(3, jTextField5.getText());
                        insertPat.setString(4, tgl);
                        insertPat.setString(5, jTextField6.getText());
                        insertPat.setString(6, profit);

                        int rowsInserted = insertPat.executeUpdate();
                        
                        // Penyisipan data ke dalam tabel 'penjualan_barang' dan pembaruan pada 'barang'

                        // UPDATE 'pembelian' dengan nilai profit yang baru
                        String updateProfitSql = "UPDATE pembelian SET Profit = ? WHERE Kode_Barang = ?";
                        java.sql.PreparedStatement updateProfitStatement = conn.prepareStatement(updateProfitSql);
                        updateProfitStatement.setString(1, profit);
                        updateProfitStatement.setString(2, kodeBarang);

        
                        // UPDATE 'barang' dengan mengurangi stok berdasarkan 'beli'
                        String updateSql = "UPDATE barang SET Stok=?, Saham=? WHERE Kode_Barang=?";
                        java.sql.PreparedStatement updatePat = conn.prepareStatement(updateSql);

                        int updatedStok = stok - beli;
                        int saham = updatedStok * hargaBeli;

                        updatePat.setInt(1, updatedStok);
                        updatePat.setInt(2, saham);
                        updatePat.setString(3, kodeBarang);

                        int rowsUpdated = updatePat.executeUpdate();

                        updatePat.close();

                        if (rowsUpdated > 0) {
                            JOptionPane.showMessageDialog(null, "Data berhasil diperbarui.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Tidak ada pembaruan pada data barang.");
                        }

                        // Tutup koneksi dan pernyataan
                        queryPat.close();
                        conn.close();
                    } else {
                        JOptionPane.showMessageDialog(null, "Stok tidak tersedia untuk transaksi ini.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan.");
                }
            } catch (HeadlessException | SQLException | NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField1CaretUpdate
       try {
            String sql = "select * from barang where Kode_Barang='"+this.jTextField1.getText()+"'";
            
            java.sql.Connection conn = (Connection)Pertemuan1.Config.configDB();
            java.sql.PreparedStatement pat = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pat.executeQuery(sql);
            
            while (rs.next()) {
                this.jTextField2.setText(rs.getString(2));
                this.jTextField3.setText(rs.getString(4));
                this.jTextField4.setText(rs.getString(5));
            }
            
        } catch (HeadlessException | SQLException e) {
            System.out.println("Erorr");
        }
    }//GEN-LAST:event_jTextField1CaretUpdate

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
     
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField6CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField6CaretUpdate

    }//GEN-LAST:event_jTextField6CaretUpdate

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
           if (jDateChooser1.getDate() !=null ) {
            SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
            tgl = Format.format(jDateChooser1.getDate());
        }
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        showTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
       
    }//GEN-LAST:event_jTextField5ActionPerformed

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
            java.util.logging.Logger.getLogger(FormPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPenjualan().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
