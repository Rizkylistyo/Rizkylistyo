import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 *
 */
public class framebarang extends javax.swing.JFrame {
    private Statement stat;
 private ResultSet rs;
 DefaultTableModel model;
 private final String judulKolom[]={"No.","Kode Barang","Nama Barang","Kategori","Satuan","Harga","Jumlah"};
 private String[][] dataBarang;
 String objKategori[]={"Alat Tulis","Kertas","Buku","ATK"};

 
 private void setModeltabel(){
 // membuat tampilan model tabel
 model = new DefaultTableModel(dataBarang,judulKolom);
 tblBarang.setModel(model);
 }
    private void view_data(){
    model.getDataVector().removeAllElements();
    try {
            int no=1;
            String sql = "select * from barang";
            koneksi objkoneksi=new koneksi();
            Connection con = objkoneksi.bukakoneksi();
            stat = con.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()){
            model.addRow(new
            Object[]{no++,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
        }

                            } catch (Exception e) {
 }
 }
    
    /**
     * Creates new form FrameBarang
     */
    public framebarang() {
        initComponents();
        setModeltabel();
        view_data();
        for (String object : objKategori){
            cbkategori.addItem(object);
    }    
    tblBarang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tblBarang.getSelectedRow();
                if(row!=-1){
                    String tKode =(tblBarang.getModel().getValueAt(row, 1).toString());
                    String tNama =(tblBarang.getModel().getValueAt(row, 2).toString());
                    String tKategori =(tblBarang.getModel().getValueAt(row, 3).toString());
                    String tSatuan =(tblBarang.getModel().getValueAt(row, 4).toString());
                    String tHarga =(tblBarang.getModel().getValueAt(row, 5).toString());
                    String tJumlah =(tblBarang.getModel().getValueAt(row, 6).toString());
                    
                    txtkode.setText(tKode);
                    txtnamabarang.setText(tNama);
                    txtharga.setText(tHarga);
                    txtjumlah.setText(tJumlah);
                    btnedit.setEnabled(true);
                    btnhapus.setEnabled(true);
                    btnsimpan.setEnabled(false);
                    
                    
                    cbkategori.setSelectedItem(tKategori);
                    switch (tSatuan) {
                        case "pcs":
                            rbpcs.setSelected(true);
                            break;
                        case "box":
                            rbbox.setSelected(true);
                            break;
                        default:
                            rbrim.setSelected(true);
                            break;
                    }
                }}
        }); 
                
                                          
    
    }
       

private void awal(){
    txtkode.setText("");
    txtnamabarang.setText("");
    txtharga.setText("");
    txtjumlah.setText("");
    cbkategori.setSelectedIndex(0);
    rbpcs.setSelected(false);
    rbbox.setSelected(false);
    rbrim.setSelected(false);
    txtkode.requestFocus();
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        txtkode = new javax.swing.JTextField();
        txtnamabarang = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        txtjumlah = new javax.swing.JTextField();
        cbkategori = new javax.swing.JComboBox();
        rbbox = new javax.swing.JRadioButton();
        rbpcs = new javax.swing.JRadioButton();
        rbrim = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnsimpan = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        btnbatal1 = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtharga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txthargaKeyTyped(evt);
            }
        });

        txtjumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtjumlahKeyTyped(evt);
            }
        });

        cbkategori.setName("Pilih Kategori"); // NOI18N
        cbkategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkategoriActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbbox);
        rbbox.setText("box");

        buttonGroup1.add(rbpcs);
        rbpcs.setText("pcs");

        buttonGroup1.add(rbrim);
        rbrim.setText("rim");

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 2, 24)); // NOI18N
        jLabel1.setText("FORM BARANG");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Kode Barang");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Nama Barang");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Kategori");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Satuan");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Harga");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Jumlah");

        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnbatal.setText("Batal");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        btnbatal1.setText("Keluar");
        btnbatal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatal1ActionPerformed(evt);
            }
        });

        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBarangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblBarang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnsimpan)
                                .addGap(32, 32, 32)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnbatal)
                                .addGap(18, 18, 18)
                                .addComponent(btnedit)
                                .addGap(18, 18, 18)
                                .addComponent(btnhapus)
                                .addGap(18, 18, 18)
                                .addComponent(btnbatal1))
                            .addComponent(jLabel1)
                            .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbpcs)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbbox)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbrim))
                            .addComponent(cbkategori, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbbox)
                    .addComponent(rbpcs)
                    .addComponent(rbrim)
                    .addComponent(jLabel5))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsimpan)
                    .addComponent(btnbatal)
                    .addComponent(btnbatal1)
                    .addComponent(btnedit)
                    .addComponent(btnhapus))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txthargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthargaKeyTyped
      char cDigit = evt.getKeyChar(); 
      if(txtharga.getText().length()<10){
          if(!Character.isDigit(cDigit)){
              evt.consume();
          }
      }else{
          evt.consume();
      } 
        // TODO add your handling code here:
    }//GEN-LAST:event_txthargaKeyTyped

    private void txtjumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtjumlahKeyTyped
char cDigit = evt.getKeyChar();    
if(txtjumlah.getText().length()<5){
    if(!Character.isDigit(cDigit)){
        evt.consume();
    }
}else{ 
    evt.consume();
} 
 
    }//GEN-LAST:event_txtjumlahKeyTyped

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
String satuan;
if(rbpcs.isSelected()){
    satuan = "pcs"; 
}else if(rbbox.isSelected()){ 
    satuan = "box";
}else{  
    satuan = "rim";
}
try{
    koneksi objkoneksi=new koneksi();
    Connection con=objkoneksi.bukakoneksi(); 
    String sql="INSERT INTO barang VALUES ('"+txtkode.getText()+"','"+txtnamabarang.getText()+"','"+cbkategori.getSelectedItem()+"','"+satuan+"','"+txtharga.getText()+"','"+txtjumlah.getText()+"')"; 
    stat = con.createStatement();
    stat.execute(sql);
    JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
    view_data();
    txtkode.setText(""); 
    txtnamabarang.setText("");
    txtharga.setText("");
    txtjumlah.setText("");
    cbkategori.setSelectedIndex(0);
    rbpcs.setSelected(false);
    rbbox.setSelected(false);
    rbrim.setSelected(false);
    txtkode.requestFocus();
}      
catch(SQLException | HeadlessException e)    
{              
    System.out.println("gagal="+e.getMessage());

           } 
    
 
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
     txtkode.setText("");
txtnamabarang.setText("");
txtharga.setText("");
txtjumlah.setText("");  
cbkategori.setSelectedIndex(0); 
rbpcs.setSelected(false);
rbbox.setSelected(false);
rbrim.setSelected(false);
txtkode.requestFocus(); 
    }//GEN-LAST:event_btnbatalActionPerformed

    private void btnbatal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatal1ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_btnbatal1ActionPerformed

    private void tblBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBarangMouseClicked
        // TODO add your handling code here:
    
        
    }//GEN-LAST:event_tblBarangMouseClicked

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        if(cbkategori.getSelectedIndex()!=0){
String satuan;
if(rbpcs.isSelected()){
satuan = "pcs";
}else if(rbbox.isSelected()){
satuan = "box";
}else if(rbrim.isSelected()){
satuan = "rim";
}else{
satuan = null;
}
try{
    koneksi objkoneksi=new koneksi();
Connection con=objkoneksi.bukakoneksi();
String sql="UPDATE barang SET namabarang='"+txtnamabarang.getText()+"',kategori='"+cbkategori.getSelectedItem()+"',"+ " satuan='"+satuan+"', harga='"+txtharga.getText()+"',jumlah='"+txtjumlah.getText()+"' where kodebarang='"+txtkode.getText()+"' ";
stat = con.createStatement();
stat.executeUpdate(sql);
javax.swing.JOptionPane.showMessageDialog(null, "Data Berhasil diedit"); 
awal();
view_data();
}
catch (Exception e)
{
System.out.println("gagal="+e.getMessage());
}
}else{
JOptionPane.showMessageDialog(null, "Pilih kategori barang","notifikasi",2);
}
    }//GEN-LAST:event_btneditActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        try{
koneksi objkoneksi=new koneksi();
Connection con=objkoneksi.bukakoneksi();
String sql="DELETE from barang where kodebarang='"+txtkode.getText()+"' ";
stat = con.createStatement();
stat.executeUpdate(sql);
JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
awal();
view_data();
}
catch (Exception e)
{
System.out.println("gagal="+e.getMessage());
}
    }//GEN-LAST:event_btnhapusActionPerformed

    private void cbkategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbkategoriActionPerformed

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
            java.util.logging.Logger.getLogger(framebarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(framebarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(framebarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(framebarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new framebarang().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnbatal1;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbkategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rbbox;
    private javax.swing.JRadioButton rbpcs;
    private javax.swing.JRadioButton rbrim;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtkode;
    private javax.swing.JTextField txtnamabarang;
    // End of variables declaration//GEN-END:variables
}