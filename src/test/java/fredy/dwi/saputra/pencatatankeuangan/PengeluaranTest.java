package fredy.dwi.saputra.pencatatankeuangan;

import Service.PengeluaranService;
import Service.PengeluaranServiceImpl;
import Util.ConnectionUtil;
import com.zaxxer.hikari.HikariDataSource;
import entity.Pengeluaran;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.PengeluaranRepository;
import repository.PengeluaranRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PengeluaranTest {
    private HikariDataSource dataSource;
    private PengeluaranRepository pengeluaranRepository;
    private PengeluaranService pengeluaranService;
    @BeforeEach
    void setUp() {
        dataSource = ConnectionUtil.getDataSource();
        pengeluaranRepository = new PengeluaranRepositoryImpl(dataSource);
        pengeluaranService = new PengeluaranServiceImpl(pengeluaranRepository);
    }

    @Test
    void showAllTest() {
        pengeluaranService.showPengeluaran();
    }

    @Test
    void showById() {
        pengeluaranService.showPengeluaranById(2);
    }

    @Test
    void addTest() throws SQLException {
        Connection connection = dataSource.getConnection();
        Pengeluaran pengeluaran = new Pengeluaran();
        pengeluaran.setJumlah(8_000.00);
        pengeluaran.setKeterangan("Nasi Kulit");

        pengeluaranService.addPengeluaran(pengeluaran.getJumlah(),pengeluaran.getKeterangan());
        connection.close();

    }

    @Test
    void removeTest() {
        pengeluaranService.removePengeluaran(1);
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
