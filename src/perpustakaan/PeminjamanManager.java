package perpustakaan;

import java.util.ArrayList;

public class PeminjamanManager {
    public boolean save(ArrayList<Buku> bukuDipinjamCollection) {
        try {
            for (Buku bukuDipinjam : bukuDipinjamCollection) {
                bukuDipinjamCollection.add(bukuDipinjam);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
