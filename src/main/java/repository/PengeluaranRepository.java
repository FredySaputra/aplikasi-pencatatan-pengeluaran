package repository;

import entity.Pengeluaran;

import java.util.List;

public interface PengeluaranRepository {
    void save(Pengeluaran pengeluaran);
    List<Pengeluaran> findAll();
    List<Pengeluaran> findByPengeluaranId(int id);
    Boolean remove (Integer id);
}
