package service.iplm;

import model.HocSinh;
import repository.IHocSinhRepository;
import repository.iplm.HocSinhRepository;
import service.IHocSinhService;

import java.util.List;

public class HocSinhService implements IHocSinhService {
    IHocSinhRepository hocSinhRepository=new HocSinhRepository();
    @Override
    public List<HocSinh> findAll() {
        return hocSinhRepository.findAll();
    }
}
