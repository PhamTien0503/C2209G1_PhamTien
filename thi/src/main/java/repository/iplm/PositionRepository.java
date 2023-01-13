package repository.iplm;

import repository.IPositionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class PositionRepository implements IPositionRepository {
    private static final String FIND_ALL="select * from position;";
    @Override
    public Map<Integer, String> findAll() {
        Connection connection=BaseRepository.getConnectDB();
        Map<Integer, String>positionMap=new LinkedHashMap<>();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_ALL);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                positionMap.put(id,name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positionMap;
    }
}