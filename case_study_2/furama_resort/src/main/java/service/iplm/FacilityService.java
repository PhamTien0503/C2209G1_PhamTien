package service.iplm;

import model.Facility;
import repository.IFacilityRepository;
import repository.iplm.FacilityRepositoty;
import service.IFacilityService;


import java.util.List;

public class FacilityService implements IFacilityService {
    IFacilityRepository facilityRepository=new FacilityRepositoty();
    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
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
