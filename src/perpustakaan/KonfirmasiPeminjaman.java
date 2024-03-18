package perpustakaan;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class KonfirmasiPeminjaman extends javax.swing.JDialog {
    private boolean okClicked = false;
    private int durasiPeminjaman;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox jComboBoxKonfirmasiDurasi;

    public KonfirmasiPeminjaman(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public boolean isOkPressed() {
        return okClicked;
    }

    public int getDurasiPeminjaman() {
        return durasiPeminjaman;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jComboBoxKonfirmasiDurasi = new javax.swing.JComboBox<>();
        jButtonAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Lama Peminjaman: ");

        jComboBoxKonfirmasiDurasi
                .setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 Hari", "2 Hari", "3 Hari" }));

        jButtonAdd.setText("Tambahkan");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxKonfirmasiDurasi, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonAdd)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jComboBoxKonfirmasiDurasi, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonAdd))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }

    private void jButtonAddActionPerformed(ActionEvent evt) {
        // TODO Auto-generated method stub
        String selected = (String) jComboBoxKonfirmasiDurasi.getSelectedItem();

        // Mengubah lama peminjaman jadi Integer
        switch (selected) {
            case "1 Hari":
                durasiPeminjaman = 1;
                break;
            case "2 Hari":
                durasiPeminjaman = 2;
                break;
            case "3 Hari":
                durasiPeminjaman = 3;
                break;
        }

        // Menampilkan pesan Konfirmasi
        JOptionPane.showMessageDialog(this, "Buku berhasil ditambahkan dengan lama peminjaman " + selected);
        okClicked = true;

        // Dialog ditutup
        dispose();
    }

}
