package Service;

import entity.Pengeluaran;
import repository.PengeluaranRepository;

import java.sql.Date;
import java.util.List;

public class PengeluaranServiceImpl implements PengeluaranService{

    private PengeluaranRepository pengeluaranRepository;

    public PengeluaranServiceImpl(PengeluaranRepository pengeluaranRepository) {
        this.pengeluaranRepository = pengeluaranRepository;
    }

    @Override
    public void showPengeluaran() {
        List<Pengeluaran> pengeluarans = pengeluaranRepository.findAll();
        for (var pengeluaran: pengeluarans) {
            if (pengeluaran != null) {
                System.out.println(pengeluaran.getId() + " . "  + pengeluaran.getJumlah()+ "  "+ pengeluaran.getKeterangan() + "   " + pengeluaran.getTanggal());
            }
        }
    }

    @Override
    public void showPengeluaranById(Integer id) {
        Pengeluaran pengeluaran = pengeluaranRepository.findByPengeluaranId(id);
        if(pengeluaran != null){
            System.out.println(pengeluaran.getId() + " . " + pengeluaran.getJumlah()+ "  "+ pengeluaran.getKeterangan() + "  " + pengeluaran.getTanggal());
        }
    }

    @Override
    public void addPengeluaran(Double jumlah, String keterangan) {

        Date tanggal = new Date(System.currentTimeMillis());
        Pengeluaran pengeluaran = new Pengeluaran(jumlah,keterangan,tanggal);

        pengeluaranRepository.save(pengeluaran);
    }

    @Override
    public void removePengeluaran(Integer id) {
        boolean success = pengeluaranRepository.remove(id);
        if(success){
            System.out.println("Berhasil menghapus pengeluaran");
        }else{
            System.out.println("Gagal menghapus pengeluaran");
        }
    }
}
