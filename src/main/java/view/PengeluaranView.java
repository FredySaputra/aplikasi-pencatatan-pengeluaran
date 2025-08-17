package view;

import Service.PengeluaranService;
import Util.InputUtil;

public class PengeluaranView {
    private PengeluaranService pengeluaranService;

    public PengeluaranView(PengeluaranService pengeluaranService) {
        this.pengeluaranService = pengeluaranService;
    }

    public void viewShowAll(){
        while(true) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("PENGELUARAN");
            pengeluaranService.showPengeluaran();
            System.out.println();
            System.out.println("MENU");
            System.out.println("1. TAMBAH PENGELUARAN");
            System.out.println("2. LIHAT PENGELUARAN BERDASARKAN ID");
            System.out.println("3. HAPUS PENGELUARAN");
            System.out.println("x. EXIT");
            System.out.println("MASUKAN NOMOR MENU PILIHAN");
            String input = InputUtil.input("PILIH");
            if (input.equals("1")) {
                viewAdd();
            } else if (input.equals("2")) {
                viewShowById();
            } else if (input.equals("3")) {
                viewRemove();
            } else if (input.equals("x")) {
                break;
            }else {
                System.out.println("Tidak ada pilihan tersebut, inputkan hanya 1-3 atau x");
            }
        }
    }

    public void viewAdd(){
        System.out.println("Masukkan jumlah dan keterangan");
        String data = InputUtil.input("Jumlah");
        Double jumlah = Double.valueOf(data);
        String keterangan = InputUtil.input("Keterangan");

        pengeluaranService.addPengeluaran(jumlah,keterangan);
    }

    public void viewShowById(){
        System.out.println("Informasi berdasarkan id");
        String data = InputUtil.input("Masukkan id");
        Integer id = Integer.valueOf(data);

        pengeluaranService.showPengeluaranById(id);
    }

    public void viewRemove(){
        System.out.println("Menghapus data pengeluaran");
        String data = InputUtil.input("Masukkan id");
        Integer id = Integer.valueOf(data);

        pengeluaranService.removePengeluaran(id);
    }
}
