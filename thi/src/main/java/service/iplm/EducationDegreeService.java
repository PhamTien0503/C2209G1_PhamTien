package service.iplm;

import repository.IEducationDegreeRepository;
import repository.iplm.EducationDegreeRepository;
import service.IEducationDegreeService;

import java.util.Map;

public class EducationDegreeService implements IEducationDegreeService {
    IEducationDegreeRepository educationDegreeRepository=new EducationDegreeRepository();
    @Override
    public Map<Integer, String> findAll() {
        return educationDegreeRepository.findAll();
    }
}
