package service.iplm;

import model.TheMuonSach;
import repository.ITheMuonSachRepository;
import repository.iplm.TheMuonSachRepository;
import service.ITheMuonSachService;

import java.util.List;

public class TheMuonSachService implements ITheMuonSachService {
    ITheMuonSachRepository theMuonSachRepository=new TheMuonSachRepository();
    @Override
    public List<TheMuonSach> findAll() {
        return theMuonSachRepository.findAll();
    }

    @Override
    public boolean save(TheMuonSach theMuonSach) {
        return false;
    }
}
