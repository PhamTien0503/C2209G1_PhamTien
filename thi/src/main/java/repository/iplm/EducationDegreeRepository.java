package repository.iplm;

import repository.IEducationDegreeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class EducationDegreeRepository implements IEducationDegreeRepository {
    private static final String FIND_ALL="select * from education_degree;";
    @Override
    public Map<Integer, String> findAll() {
        Connection connection=BaseRepository.getConnectDB();
        Map<Integer, String> educationDegreeMap=new LinkedHashMap<>();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_ALL);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                educationDegreeMap.put(id,name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return educationDegreeMap;
    }
}