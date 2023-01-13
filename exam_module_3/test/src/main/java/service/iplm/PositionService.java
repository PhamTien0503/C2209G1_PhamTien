package service.iplm;

import repository.IPositionRepository;
import repository.iplm.PositionRepository;
import service.IPositionService;

import java.util.Map;

public class PositionService implements IPositionService {
    IPositionRepository positionRepository=new PositionRepository();

    @Override
    public Map<Integer, String> findAll() {
        return positionRepository.findAll();
    }
}
