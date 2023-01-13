package repository.iplm;

import model.Sach;
import repository.ISachRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SachRepository implements ISachRepository {
    private static final String FIND_ALL="select * from sach";
    @Override
    public List<Sach> findAll() {
        List<Sach>sachList=new ArrayList<>();
        Connection connection=BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_ALL);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                 String maSach =resultSet.getString("ma_sach");
                 String tenSach=resultSet.getString("ten_sach");
                 String tacGia=resultSet.getString("tac_gia");
                 String moTa=resultSet.getString("mo_ta");
                 int soLuong=resultSet.getInt("so_luong");
                 Sach sach=new Sach(maSach,tenSach,tacGia,moTa,soLuong);
                 sachList.add(sach);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sachList;
    }
}
