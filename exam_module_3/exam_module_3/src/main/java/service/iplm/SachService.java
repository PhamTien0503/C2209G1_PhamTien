package service.iplm;

import model.Sach;
import repository.ISachRepository;
import repository.iplm.SachRepository;
import service.ISachService;

import java.util.List;

public class SachService implements ISachService {
    ISachRepository sachRepository=new SachRepository();
    @Override
    public List<Sach> findAll() {
        return sachRepository.findAll();
    }
}
