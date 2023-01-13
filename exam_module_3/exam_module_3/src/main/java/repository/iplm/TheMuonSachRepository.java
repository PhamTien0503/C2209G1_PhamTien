package repository.iplm;

import model.HocSinh;
import model.Sach;
import model.TheMuonSach;
import repository.ITheMuonSachRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TheMuonSachRepository implements ITheMuonSachRepository {
    private static final String FIND_ALL="select * from the_muon_sach";
    @Override
    public List<TheMuonSach> findAll() {
        List<TheMuonSach>theMuonSachList=new ArrayList<>();
        Connection connection=BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_ALL);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                 String maMuonSach=resultSet.getString("ma_muon_sach");
                 String maSach=resultSet.getString("ma_sach");
                 Sach sach=new Sach(maSach);
                int maHocSinh=Integer.parseInt(resultSet.getString("ma_hoc_sinh"));
                HocSinh hocSinh=new HocSinh(maHocSinh);

                 boolean trangThai=resultSet.getBoolean("trang_thai");
                 String ngayMuon=resultSet.getString("ngay_muon");
                 String ngayTra=resultSet.getString("ngay_tra");
                TheMuonSach theMuonSach=new TheMuonSach(maMuonSach,sach,hocSinh,trangThai,ngayMuon,ngayTra);
                theMuonSachList.add(theMuonSach);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theMuonSachList;
    }

    @Override
    public boolean save(TheMuonSach theMuonSach) {
        return false;
    }
}
