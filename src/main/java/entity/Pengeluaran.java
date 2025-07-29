package entity;

import java.util.Date;

public class Pengeluaran {

    private Integer id;
    private Double jumlah;
    private String keterangan;
    private Date tanggal;

    public Pengeluaran() {
    }

    public Pengeluaran(Double jumlah, String keterangan, Date tanggal) {
        this.jumlah = jumlah;
        this.keterangan = keterangan;
        this.tanggal = tanggal;
    }

    public Pengeluaran(Integer id, Double jumlah, String keterangan, Date tanggal) {
        this.id = id;
        this.jumlah = jumlah;
        this.keterangan = keterangan;
        this.tanggal = tanggal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getJumlah() {
        return jumlah;
    }

    public void setJumlah(Double jumlah) {
        this.jumlah = jumlah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
}
