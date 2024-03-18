package perpustakaan;

import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class KonfirmasiPeminjaman extends javax.swing.JDialog {
    private boolean okClicked = false;
    private int durasiPeminjaman;
    private JRadioButton r1;
    private JRadioButton r2;
    private JRadioButton r3;
    private JButton jButtonAdd;

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

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JLabel jLabel1 = new JLabel();
        jLabel1.setText("Lama Peminjaman: ");
        jLabel1.setBounds(10, 10, 120, 30);
        add(jLabel1);

        r1 = new JRadioButton("1 Hari");
        r2 = new JRadioButton("2 Hari");
        r3 = new JRadioButton("3 Hari");

        r1.setBounds(130, 50, 100, 30);
        r2.setBounds(130, 100, 100, 30);
        r3.setBounds(130,150,100,30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);

        add(r1);
        add(r2);
        add(r3);

        jButtonAdd = new JButton();
        jButtonAdd.setText("OK");
        jButtonAdd.setBounds(130, 200, 100, 30);
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        add(jButtonAdd);

        setSize(400, 400);
        setLayout(null);
        setVisible(true);
    }
    

    private void jButtonAddActionPerformed(ActionEvent evt) {
        if (r1.isSelected()) {
            durasiPeminjaman = 1;
        } else if (r2.isSelected()) {
            durasiPeminjaman = 2;
        } else if (r3.isSelected()) {
            durasiPeminjaman = 3;
        } else {
            JOptionPane.showMessageDialog(this, "Silakan pilih durasi peminjaman.");
            return;
        }

        // Menampilkan pesan Konfirmasi
        JOptionPane.showMessageDialog(this, "Buku berhasil ditambahkan dengan lama peminjaman " + durasiPeminjaman + " Hari");
        okClicked = true;

        // Dialog ditutup
        dispose();
    }
}
