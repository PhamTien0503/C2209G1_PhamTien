package service;

import model.TheMuonSach;

import java.util.List;

public interface ITheMuonSachService {
    List<TheMuonSach> findAll();
    boolean save(TheMuonSach theMuonSach);
}
