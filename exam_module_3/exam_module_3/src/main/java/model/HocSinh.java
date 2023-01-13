package model;

public class HocSinh {
    private int ma_hoc_sinh;
    private String ho_ten;
    private String lop;

    public HocSinh(int ma_hoc_sinh, String ho_ten, String lop) {
        this.ma_hoc_sinh = ma_hoc_sinh;
        this.ho_ten = ho_ten;
        this.lop = lop;
    }

    public HocSinh(int ma_hoc_sinh) {
        this.ma_hoc_sinh = ma_hoc_sinh;
    }

    public int getMa_hoc_sinh() {
        return ma_hoc_sinh;
    }

    public void setMa_hoc_sinh(int ma_hoc_sinh) {
        this.ma_hoc_sinh = ma_hoc_sinh;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
}
