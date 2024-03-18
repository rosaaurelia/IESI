package perpustakaan;

import java.util.ArrayList;

public class PeminjamanController {
    private PeminjamanManager peminjamanManager;

    public PeminjamanController() {
        this.peminjamanManager = new PeminjamanManager();
    }

    private ArrayList<Buku> bukuDipinjam = new ArrayList<>();

    public ArrayList<Buku> getBukuDipinjam() {
        return bukuDipinjam;
    }

    public void showFormPeminjaman() {
        Perpustakaan.formPeminjaman = new FormPeminjaman();
        Perpustakaan.formPeminjaman.tampilkan();
    }

    public void cariBuku(String judul) {
        BukuProvider bukuProvider = new BukuProvider();
        try {
            ArrayList<Buku> listBuku = bukuProvider.selectBuku(judul);
            if (listBuku.isEmpty()) {
                DialogUI dialogUI = new DialogUI("Buku tidak terdaftar");
                dialogUI.pack();
                dialogUI.setLocationRelativeTo(null);
                dialogUI.setVisible(true);
            } else
                Perpustakaan.formPeminjaman.display(listBuku);
        } catch (Exception ex) {
            DialogUI dialogUI = new DialogUI("Connection Error");
            dialogUI.pack();
            dialogUI.setLocationRelativeTo(null);
            dialogUI.setVisible(true);
        }
    }

    public void pinjamBuku(Buku buku) {
        bukuDipinjam.add(buku);
        Perpustakaan.formPeminjaman.displayBukuDipinjam(bukuDipinjam);
    }

    public void hapusBuku(String judul) {
        for (Buku buku : bukuDipinjam) {
            if (buku.getJudul().equals(judul)) {
                bukuDipinjam.remove(buku);
                Perpustakaan.formPeminjaman.displayBukuDipinjam(bukuDipinjam);
                return;
            }
        }
    }

    public void konfirmasiBukuDipinjam(ArrayList<Buku> bukuDipinjamCollection) {
        boolean status = peminjamanManager.save(bukuDipinjamCollection);
        if (status) {
            DialogUI dialogUI = new DialogUI("Peminjaman telah dikonfirmasi");
            dialogUI.pack();
            dialogUI.setLocationRelativeTo(null);
            dialogUI.setVisible(true);
        } else {
            DialogUI dialogUI = new DialogUI("Gagal menyimpan buku yang dipinjam");
            dialogUI.pack();
            dialogUI.setLocationRelativeTo(null);
            dialogUI.setVisible(true);
        }
    }
    
}
