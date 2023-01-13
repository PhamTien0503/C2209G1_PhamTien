package repository.iplm;

import model.HocSinh;
import model.Sach;
import repository.IHocSinhRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HocSinhRepository implements IHocSinhRepository {
    private static final String FIND_ALL="select * from hoc_sinh";

    @Override
    public List<HocSinh> findAll() {
        List<HocSinh>hocSinhList=new ArrayList<>();
        Connection connection=BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_ALL);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                int maHocSinh =Integer.parseInt(resultSet.getString("ma_hoc_sinh"));
                String ho_Ten=resultSet.getString("ho_ten");
                String lop=resultSet.getString("lop");
                HocSinh hocSinh=new HocSinh(maHocSinh,ho_Ten,lop);
                hocSinhList.add(hocSinh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hocSinhList;
    }
}

