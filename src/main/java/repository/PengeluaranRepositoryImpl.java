package repository;

import Util.ConnectionUtil;
import com.zaxxer.hikari.HikariDataSource;
import entity.Pengeluaran;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PengeluaranRepositoryImpl implements PengeluaranRepository{
    public DataSource dataSource;

    public PengeluaranRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Pengeluaran pengeluaran) {
        String sql = "INSERT INTO pengeluaran (jumlah, keterangan, tanggal) VALUES (?,?,?)";
        try(Connection connection = ConnectionUtil.getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setDouble(1,pengeluaran.getJumlah());
            preparedStatement.setString(2,pengeluaran.getKeterangan());
            preparedStatement.setDate(3,pengeluaran.getTanggal());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Pengeluaran> findAll() {
        String sql = "SELECT * FROM pengeluaran";
        try(Connection connection = ConnectionUtil.getDataSource().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){

            List<Pengeluaran> list = new ArrayList<>();
            while (resultSet.next()){
                Pengeluaran pengeluaran = new Pengeluaran();
                pengeluaran.setId(resultSet.getInt("id"));
                pengeluaran.setJumlah(resultSet.getDouble("jumlah"));
                pengeluaran.setKeterangan(resultSet.getString("keterangan"));
                pengeluaran.setTanggal(resultSet.getDate("tanggal"));

                list.add(pengeluaran);
            }
            return  list;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isExists(Integer id){
        String sql = "SELECT jumlah,keterangan,tanggal FROM pengeluaran WHERE id = ?";
        try(Connection connection = ConnectionUtil.getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Pengeluaran findByPengeluaranId(Integer id) {
        String sql = "SELECT * FROM pengeluaran WHERE id = ?";
        try(Connection connection = ConnectionUtil.getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            if(isExists(id)) {
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
                ResultSet resultSet = preparedStatement.executeQuery();
                Pengeluaran pengeluaran = new Pengeluaran();
                if (resultSet.next()) {
                    pengeluaran.setId(resultSet.getInt("id"));
                    pengeluaran.setJumlah(resultSet.getDouble("jumlah"));
                    pengeluaran.setKeterangan(resultSet.getString("keterangan"));
                    pengeluaran.setTanggal(resultSet.getDate("tanggal"));
                }
                return pengeluaran;
            }else{
                return null;
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean remove(Integer id) {
        String sql = "DELETE FROM pengeluaran WHERE id=?";
        try(Connection connection = ConnectionUtil.getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            if(isExists(id)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                return true;
            }else{
                return false;
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
