package service.iplm;

import repository.IDivisionRepository;
import repository.iplm.DivisionRepository;
import service.IDivisionService;

import java.util.Map;

public class DivisionService implements IDivisionService {
    IDivisionRepository divisionRepository= new DivisionRepository();
    @Override
    public Map<Integer, String> findAll() {
        return divisionRepository.findAll();
    }
}
