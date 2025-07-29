package Service;

import java.sql.Date;

public interface PengeluaranService {
    void showPengeluaran();
    void showPengeluaranById(Integer id);
    void addPengeluaran(Double jumlah, String keterangan);
    void removePengeluaran(Integer id);
}
