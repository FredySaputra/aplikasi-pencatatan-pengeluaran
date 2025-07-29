package repository;

import entity.Pengeluaran;

import java.util.List;

public interface PengeluaranRepository {
    void save(Pengeluaran pengeluaran);
    List<Pengeluaran> findAll();
    Pengeluaran findByPengeluaranId (Integer id);
    Boolean remove (Integer id);
}
