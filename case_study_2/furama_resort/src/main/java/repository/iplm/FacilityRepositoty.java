package repository.iplm;

import model.Facility;
import model.RentType;
import repository.IFacilityRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FacilityRepositoty implements IFacilityRepository {

        private static final String SELECT_ALL_FACILITY="select * from facility;";
        @Override
        public List<Facility> findAll() {
            List<Facility>facilityList=new ArrayList<>();
            Connection connection=BaseRepository.getConnectDB();
            try {
                PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_FACILITY);
                ResultSet resultSet=preparedStatement.executeQuery();
                while (resultSet.next()){
                     int id=resultSet.getInt("id");
                     String name=resultSet.getString("name");
                     int area=resultSet.getInt("area");
                     double cost=resultSet.getDouble("cost");
                     int maxPeople=resultSet.getInt("max_people");
                     int rentTypeId=resultSet.getInt("rent_type_id");
                     int facilityTypeId=resultSet.getInt("facility_type_id");
                     String standardRoom=resultSet.getString("standard_room");
                     String descriptionOtherConvenience=resultSet.getString("description_other_convenience");
                     double poolArea=resultSet.getDouble("pool_area");
                     int numberOfFloors=resultSet.getInt("number_of_floors");
                     String facilityFree=resultSet.getString("facility_free");
                     Facility  facility=new Facility(id,name,area,cost,maxPeople,rentTypeId,facilityTypeId,standardRoom,
                             descriptionOtherConvenience,poolArea,numberOfFloors,facilityFree);
                     facilityList.add(facility);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return facilityList;
        }


    @Override
    public Facility findById(int id) {
        return null;
    }

    @Override
    public boolean save(Facility facility) {
        return false;
    }

    @Override
    public boolean edit(Facility facility) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Facility> search(int id, String name) {
        return null;
    }
}
