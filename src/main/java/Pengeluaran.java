import Service.PengeluaranService;
import Service.PengeluaranServiceImpl;
import Util.ConnectionUtil;
import repository.PengeluaranRepository;
import repository.PengeluaranRepositoryImpl;
import view.PengeluaranView;

import javax.sql.DataSource;
import java.sql.Connection;

public class Pengeluaran {
    public static void main(String[] args) {
        DataSource dataSource = ConnectionUtil.getDataSource();
        PengeluaranRepository repository = new PengeluaranRepositoryImpl(dataSource);
        PengeluaranService service = new PengeluaranServiceImpl(repository);
        PengeluaranView view = new PengeluaranView(service);

        view.viewShowAll();
    }
}
