/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;


public class Buku {
    
    public String judul;
    public int durasiPeminjaman;
    
    public Buku(String judul) {
        this.judul = judul;
    }
    
    public Buku(String judul, int durasiPeminjaman) {
        this.judul = judul;
        this.durasiPeminjaman = durasiPeminjaman;
    }

    public String getJudul() {
        return judul;
    }

    public void setDurasiPeminjaman(int durasiPeminjaman) {
        this.durasiPeminjaman = durasiPeminjaman;
    }

    public int getDurasiPeminjaman() {
        return durasiPeminjaman;
    }
}
