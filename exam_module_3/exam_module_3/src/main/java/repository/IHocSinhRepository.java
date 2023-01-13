package repository;

import model.HocSinh;
import model.Sach;

import java.util.List;

public interface IHocSinhRepository {
    List<HocSinh> findAll();
}