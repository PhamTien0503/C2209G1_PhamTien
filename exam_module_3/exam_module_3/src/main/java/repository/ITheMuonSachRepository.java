package repository;

import model.TheMuonSach;

import java.util.List;

public interface ITheMuonSachRepository {
    List<TheMuonSach> findAll();
    boolean save(TheMuonSach theMuonSach);
}
